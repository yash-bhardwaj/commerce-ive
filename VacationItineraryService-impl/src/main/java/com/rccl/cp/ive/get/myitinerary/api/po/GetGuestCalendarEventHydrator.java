package com.rccl.cp.ive.get.myitinerary.api.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.extras.codecs.joda.LocalDateCodec;
import com.datastax.driver.extras.codecs.joda.LocalTimeCodec;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.get.myitinerary.api.EventAttendee;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;
import com.rccl.cp.ive.get.shipschedule.api.po.VoyageInfoShipScheduleEvent;
import com.rccl.cp.ive.get.shipschedule.api.po.VoyageInfoToCalendarEventMapper;

public class GetGuestCalendarEventHydrator {

    private Logger logger = LoggerFactory.getLogger(
        GetGuestCalendarEventHydrator.class);
    private static final Integer CASSANDRA_SESSION_SECONDS = 3;

    public final Map<String, List<ItineraryEvent>> getGuestCalendarEvent(
        final CassandraSession cassandraSession,
        final String shipSailDate,
        final String cruiseBookingID,
        final String guestID) {
        List<CommerceGuestCalendarEvent> results =
            new ArrayList<CommerceGuestCalendarEvent>();
        Map<String, List<ItineraryEvent>> resultMap =
            new HashMap<String, List<ItineraryEvent>>();
        com.datastax.driver.core.Session session;
        try {
            session = cassandraSession.underlying().toCompletableFuture().get(
                CASSANDRA_SESSION_SECONDS, TimeUnit.SECONDS);
            if (session == null) {
                return resultMap;
            }
            session.getCluster().getConfiguration().getCodecRegistry()
                .register(LocalDateCodec.instance, LocalTimeCodec.instance);
            MappingManager manager = new MappingManager(session);
            CommerceGuestCalendarEventAccessor accessor = manager
                .createAccessor(CommerceGuestCalendarEventAccessor.class);
            Result<CommerceGuestCalendarEvent> all =
                accessor.getBySailingIDGuestID(shipSailDate, guestID);
            for (CommerceGuestCalendarEvent one : all) {
                Result<CommerceEventAttendee> attendeeResult =
                    accessor.getAttendeesForEvent(one.getSailing_id(),
                        one.getEvent_owner_reservation_id(),
                        one.getEvent_owner_guest_id(),
                        one.getSource_system_application_id(),
                        one.getSource_system_offering_id());
                List<CommerceEventAttendee> attendees =
                    new ArrayList<CommerceEventAttendee>();
                List<EventAttendee> mappedAttendees = null;
                for (CommerceEventAttendee attendee : attendeeResult) {
                    attendees.add(attendee);
                }
                CommerceEventAttendeeMapper cassandraToAttendeeMapper =
                    new CommerceEventAttendeeMapper.CommerceEventAttendeeMapperImpl();
                mappedAttendees = attendees.stream()
                    .map(cassandraToAttendeeMapper::toEventAttendee)
                    .collect(Collectors.toList());

                one.setAttendees(mappedAttendees);
                results.add(one);
            }
            CommerceGuestCalendarEventMapper cassandraToServiceMapper =
                new CommerceGuestCalendarEventMapper.CommerceGuestCalendarEventMapperImpl();

            resultMap = results.stream()
                .map(cassandraToServiceMapper::toItineraryEvent)
                .collect(Collectors.groupingBy(
                    ItineraryEvent::eventGroupType));
            List<ItineraryEvent> shipScheduleEvents = getShipScheduleEvents(
                shipSailDate, accessor);
            if (shipScheduleEvents.size() > 0) {
                resultMap.put("SHIPSCHEDULE", shipScheduleEvents);
            }
        } catch (InterruptedException e) {
            logger.error("getGuestCalendarEvent(): Got InterruptedException {}",
                e.getMessage());
        } catch (ExecutionException e) {
            logger.error("getGuestCalendarEvent(): Got ExecutionException {}",
                e.getMessage());
        } catch (TimeoutException e) {
            logger.error("getGuestCalendarEvent(): Got TimeoutException {}",
                e.getMessage());
        }
        return resultMap;
    }

    private List<ItineraryEvent> getShipScheduleEvents(
        final String shipSailDate,
        final CommerceGuestCalendarEventAccessor accessor) {
        List<VoyageInfoShipScheduleEvent> results =
            new ArrayList<VoyageInfoShipScheduleEvent>();
        String shipCode = shipSailDate.substring(0, 2);
        String sailDate = shipSailDate.substring(2);
        //System.out.println(shipCode + " " + sailDate);
        Result<VoyageInfoShipScheduleEvent> voyageInfo = accessor
            .getShipScheduleByShipSailDate(shipCode, sailDate);
        for (VoyageInfoShipScheduleEvent voyageDay : voyageInfo) {
            results.add(voyageDay);
        }

        VoyageInfoToCalendarEventMapper eventMapper =
            new VoyageInfoToCalendarEventMapper.VoyageInfoToCalendarEventMapperImpl();

        List<ItineraryEvent> mappedResults = results.stream()
            .map(eventMapper::toItineraryEvent)
            .collect(Collectors.toList());

        return mappedResults;
    }
}
