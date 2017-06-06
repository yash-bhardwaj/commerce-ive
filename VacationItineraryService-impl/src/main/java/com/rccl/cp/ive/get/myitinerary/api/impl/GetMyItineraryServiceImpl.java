package com.rccl.cp.ive.get.myitinerary.api.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.lightbend.lagom.javadsl.api.deser.ExceptionMessage;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.NotFound;
import com.lightbend.lagom.javadsl.api.transport.ResponseHeader;
import com.lightbend.lagom.javadsl.api.transport.TransportErrorCode;
import com.lightbend.lagom.javadsl.api.transport.TransportException;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.server.HeaderServiceCall;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableItineraryEventGroup;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableMyItinerary;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventForDisplay;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventGroup;
import com.rccl.cp.ive.get.myitinerary.api.MyItinerary;
import com.rccl.cp.ive.get.myitinerary.api.po.CommerceGuestCalendarEventForDisplayMapper;
import com.rccl.cp.ive.get.myitinerary.api.po.GetGuestCalendarEventCommand;
import com.rccl.cp.ive.get.validation.GetItenaryValidator;

import akka.NotUsed;
import akka.japi.Pair;
import akka.stream.Materializer;

public class GetMyItineraryServiceImpl implements GetMyItineraryService {

    private Logger logger = LoggerFactory.getLogger(GetMyItineraryServiceImpl.class);
    private final CassandraSession cassandraSession;
    private final Materializer materializer;
    private static final Integer ERROR_CODE_BACKEND = 504;

    @Inject
    public GetMyItineraryServiceImpl(final CassandraSession cassandraSess, final Materializer mat) {
        this.cassandraSession = cassandraSess;
        this.materializer = mat;
        logger.info("GetMyItineraryServiceImpl() INJECTED CASSANDRA SESSION {}", cassandraSess);
        logger.info("GetMyItineraryServiceImpl() INJECTED AKKA MATERIALIZER {}", materializer);
    }

    @Override
    public final HeaderServiceCall<NotUsed, MyItinerary> getMyItinerary(final String shipSailDate,
        final String cruiseBookingID, final String guestID) {
        return (requestHeader, request) -> {
            logger.debug("getMyItinerary called with shipSailDate [" + shipSailDate + "] cruiseBookingID ["
                + cruiseBookingID + "] guestID [" + guestID + "]");
            Optional<String> apiKey = requestHeader.getHeader("api-key");

            if (!apiKey.isPresent()) {
                throw new BadRequest(TransportErrorCode.fromHttp(401), new ExceptionMessage("error", "request not authenticated"));
            }

            final String error = GetItenaryValidator.validateRequest(shipSailDate, cruiseBookingID, guestID);
            if (!error.equalsIgnoreCase("")) {
                logger.info("Bad parameters in get My Itenary...");
                throw new BadRequest(error);
            }

            CompletableFuture<Pair<ResponseHeader, MyItinerary>> completionStage = CompletableFuture
                .supplyAsync(new Supplier<Pair<ResponseHeader, MyItinerary>>() {
                    @Override
                    public Pair<ResponseHeader, MyItinerary> get() {
                        return Pair.create(buildHeader(), buildItinerary());
                    }

                    private ResponseHeader buildHeader() {
                        ResponseHeader responseHeader = ResponseHeader.OK.withHeader("Access-Control-Allow-Origin",
                            "*");
                        return responseHeader;
                    }

                    public MyItinerary buildItinerary() {
                        MyItinerary itin = null;
                        // GetGuestCalendarEventHydrator hydrator =
                        // new GetGuestCalendarEventHydrator();
                        // Map<String, List<ItineraryEvent>> events =
                        // hydrator.getGuestCalendarEvent(cassandraSession,
                        // shipSailDate,
                        // cruiseBookingID,
                        // guestID);
                        GetGuestCalendarEventCommand command = new GetGuestCalendarEventCommand(cassandraSession,
                            shipSailDate,
                            cruiseBookingID,
                            guestID);
                        Map<String, List<ItineraryEvent>> events =
                            command.execute();
                        checkEventsForErrors(events);

                        if (events.size() > 0) {
                            ItineraryEvent firstEvent = new ArrayList<List<ItineraryEvent>>(events.values()).get(0)
                                .get(0);
                            for (int i = 1; i < events.size(); i++) {
                                ItineraryEvent nextEvent = new ArrayList<List<ItineraryEvent>>(events.values())
                                    .get(i).get(0);
                                if (!nextEvent.eventGroupType().equals("SHIPSCHEDULE")) {
                                    firstEvent = nextEvent;
                                    break;
                                }
                            }
                            List<ImmutableItineraryEventGroup> eventGroups = constructEventGroups(events);
                            itin = ImmutableMyItinerary.builder()
                                .cruiseReservationID(BigInteger.valueOf(Long.parseLong(cruiseBookingID)))
                                .guestID(BigInteger.valueOf(Long.parseLong(guestID))).sailingID(shipSailDate)
                                .firstName(firstEvent.firstName()).lastName(firstEvent.lastName())
                                .itineraryEventGroups(ImmutableList.<ItineraryEventGroup>builder()
                                    .addAll(eventGroups).build())
                                .build();
                        } else {
                            throw new NotFound("buildItinerary() No events found for guest " + guestID
                                + " on sailing " + shipSailDate);
                        }
                        return itin;
                    }

                    private List<ImmutableItineraryEventGroup> constructEventGroups(
                        final Map<String, List<ItineraryEvent>> events) {
                        List<ImmutableItineraryEventGroup> eventGroups = new ArrayList<ImmutableItineraryEventGroup>();
                        CommerceGuestCalendarEventForDisplayMapper cassandraToServiceMapper =
                            new CommerceGuestCalendarEventForDisplayMapper.CommerceGuestCalendarEventForDisplayMapperImpl();
                        List<ItineraryEvent> eventsByGroupType = null;
                        for (Entry<String, List<ItineraryEvent>> entry : events.entrySet()) {
                            eventsByGroupType = entry.getValue();
                            List<ItineraryEventForDisplay> eventsForDisplay = eventsByGroupType.stream()
                                .map(cassandraToServiceMapper::toItineraryEventForDisplay)
                                .collect(Collectors.toList());
                            eventGroups.add(ImmutableItineraryEventGroup.builder()
                                .eventGroupType(eventsByGroupType.get(0).eventGroupType())
                                .eventGroupDescription(eventsByGroupType.get(0).eventGroupDescription())
                                .itineraryEvents(eventsForDisplay).build());
                        }

                        return eventGroups;
                    }

                    private void checkEventsForErrors(Map<String, List<ItineraryEvent>> events) {

                        if (events == null) {
                            throw new TransportException(
                                TransportErrorCode.ServiceUnavailable,
                                new ExceptionMessage("ServiceUnavailable",
                                    "Error retrieving MyItineraries."));
                        } else if (!events.isEmpty()) {
                            String firstKey = events.keySet().iterator().next();
                            if (firstKey.contains("ERROR")) {
                                if (firstKey.contains("Timeout")) {
                                    throw new TransportException(
                                        TransportErrorCode.fromHttp(ERROR_CODE_BACKEND),
                                        new ExceptionMessage("ServiceUnavailable",
                                            "Timeout while retrieving MyItineraries."));
                                } else if (firstKey.contains("Error preparing queries for accessor")) {
                                    throw new TransportException(
                                        TransportErrorCode.ServiceUnavailable,
                                        new ExceptionMessage("ServiceUnavailable",
                                            "Error retrieving data from MyItineraries datastore."));
                                }
                            }
                        }
                    }
                });
            return completionStage;
        };
    }
}
