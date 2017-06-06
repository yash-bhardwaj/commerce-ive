/*
 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.rccl.cp.ive.it;

import static org.junit.Assert.assertFalse;

import java.math.BigInteger;
import java.net.URI;
import java.util.Iterator;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.oai.validator.SwaggerRequestResponseValidator;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.model.Response;
import com.atlassian.oai.validator.model.SimpleRequest;
import com.atlassian.oai.validator.model.SimpleResponse;
import com.atlassian.oai.validator.report.ValidationReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;
import com.rccl.cp.ive.get.myitinerary.api.EventAttendee;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventForDisplay;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventGroup;
import com.rccl.cp.ive.get.myitinerary.api.MyItinerary;
import com.rccl.cp.ive.update.cruiseplanner.api.StreamConsumerService;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;

public class IVEIT {

    private static final String SERVICE_LOCATOR_URI = "http://localhost:8000";

    private static LagomClientFactory clientFactory;
    private static GetMyItineraryService getMyItineraryService;
    private static GetMyItineraryService getMyInvalidItineraryService;
    private static StreamConsumerService VacationItineraryStreamService;
    private static ActorSystem system;
    private static Materializer mat;
    final Logger logger = LoggerFactory.getLogger(IVEIT.class);

    @BeforeClass
    public static void setup() {
        clientFactory = LagomClientFactory.create("integration-test", IVEIT.class.getClassLoader());
        // One of the clients can use the service locator, the other can use the
        // service gateway, to test them both.
        getMyItineraryService = clientFactory.createDevClient(GetMyItineraryService.class,
            URI.create(SERVICE_LOCATOR_URI));
        getMyInvalidItineraryService = clientFactory.createDevClient(GetMyItineraryService.class,
            URI.create(SERVICE_LOCATOR_URI));
        VacationItineraryStreamService = clientFactory.createDevClient(StreamConsumerService.class,
            URI.create(SERVICE_LOCATOR_URI));

        system = ActorSystem.create();
        mat = ActorMaterializer.create(system);
    }

    @Test
    public void getMyItinerary() throws Exception {
        MyItinerary myItinerary;
        StringBuffer oddOne = new StringBuffer();
        BigInteger ownerCruiseReservationID = null;
        String ownerSailingId = null;

        try {
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "11111555556161", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY")).invoke());
        } catch (Exception e) {
            logger.error("getMyItinerary() getMyItineraryService.getMyItinerary() got Exception: {}", e.getMessage());
            logger.error("err", e);
            return;
        }

        if (myItinerary.cruiseReservationID() == null) {
            throw new AssertionError("Cruise Reservation ID is null!");
        }
        if (myItinerary.firstName() == null || myItinerary.lastName() == null) {
            throw new AssertionError("Guest's First Name and/or Last Name is null!");
        }
        if (myItinerary.itineraryEventGroups() == null || myItinerary.itineraryEventGroups().size() <= 0) {
            throw new AssertionError("ItineraryEventGroups is null or empty.");
        }

        logger.info("Value in myItinerary [" + myItinerary.toString() + "]");

        for (Iterator<ItineraryEventGroup> eventGroupIter = myItinerary.itineraryEventGroups()
            .iterator(); eventGroupIter.hasNext();) {
            ownerCruiseReservationID = myItinerary.cruiseReservationID();
            ownerSailingId = myItinerary.sailingID();
            ItineraryEventGroup group = (ItineraryEventGroup) eventGroupIter.next();

            if (group.itineraryEvents() == null || group.itineraryEvents().size() <= 0) {
                throw new AssertionError("ItineraryEventGroup " + group.eventGroupType() + " had 0 events scheduled.");
            }
            for (Iterator<ItineraryEventForDisplay> eventIter = group.itineraryEvents().iterator(); eventIter
                .hasNext();) {
                ItineraryEventForDisplay event = (ItineraryEventForDisplay) eventIter.next();
                if (event.attendees() == null || event.attendees().size() <= 0) {
                    throw new AssertionError("Event had null or zero attendees.");
                }
                if (event.eventStartTime() == null || event.eventEndTime() == null) {
                    if (event.attendees() == null || event.attendees().size() <= 0) {
                        throw new AssertionError("Event had null event start time and/or event end time.");
                    }
                }
                if (event.eventLocation() == null) {
                    throw new AssertionError("Event had null event location.");
                }
                logger.info(
                    "Number of Attendees we have for [" + ownerSailingId + "] are [" + event.attendees().size() + "]");
                if (event.attendees().size() > 0) {
                    for (EventAttendee attendee : event.attendees()) {
                        if (!ownerSailingId.equalsIgnoreCase(attendee.sailingID())) {
                            oddOne.append(
                                ownerSailingId + " ownerGuestID did not match " + attendee.sailingID() + "\n");
                        }
                    }
                }
            }
        }
        if (oddOne.length() > 0) {
            logger.error("These Attendees aren't on the same ship!!\n" + oddOne);
            throw new AssertionError("Some of the Attendees are not on the same ship!!!");
        } else {
            logger.info("All Attendees aren on the same ship!!");
        }
    }

    // Test cases for invalid values

    @Test
    public void getMyItineraryForInvalidRequest() throws Exception {
        try {

            await(getMyInvalidItineraryService.getMyItinerary("AL20170111", "101", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY")).invoke());
        } catch (Exception e) {
            if (e instanceof BadRequest || e.getMessage().contains("an invalid")) {
                logger.info("Test case Passed with Exception : \n" + e);
            } else {
                logger.info("Test case Failed with Exception : \n" + e);
            }
            logger.error("getMyInvalidItineraryService.getMyItineraryForInvalidRequest() got Exception: {}",
                e.getMessage());
            logger.info("err {}", e);
            return;
        }
    }

    @Test
    public void shouldPayloadFromFileConformToSchema() throws Exception {
        // first test the plain json is valid with schema
        final String sailingId = "AL20170730";
        final String cruiseResevationId = "11111555556161";
        final String guestId = "191919";
        try {
            SwaggerRequestResponseValidator validator = SwaggerRequestResponseValidator
                .createFor("sampleSchema.json").build();
            final Request validRequest =
                SimpleRequest.Builder.get("/myItineraries/" + sailingId + "/" + cruiseResevationId + "/" + guestId)
                    .withHeader("api-key", "TESTKEY")
                    .build();
            Response validResponse = SimpleResponse.Builder.ok()
                .withBody(ValidatorTestUtil.loadResponse("my_itinerary_sample_response_2017_03_16")).build();
            ValidationReport reportForText = validator.validate(validRequest, validResponse);
            logger.info("shouldPayloadFromFileConformToSchema() #### VALIDATION PAYLOAD REPORT ###");
            reportForText.getMessages().forEach((m) -> {
                logger.info("{}", m);
            });
            assertFalse(reportForText.hasErrors());
            logger.info("shouldPayloadFromFileConformToSchema() ### VALIDATION PAYLOAD REPORT END ###");

            MyItinerary myItinerary =
                await(getMyItineraryService.getMyItinerary(sailingId, cruiseResevationId, guestId)
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY")).invoke());
            ObjectMapper mapper = new ObjectMapper();
            String myItineraryJson = mapper.writeValueAsString(myItinerary);
            logger.info(myItinerary+"\nmyItineraryJson : "+myItineraryJson);
            reportForText = validator.validate(validRequest, SimpleResponse.Builder.ok()
                .withBody(myItineraryJson).build());

            logger.info("shouldPayloadFromFileConformToSchema() ###VALIDATION PAYLOAD REPORT###");
            reportForText.getMessages().forEach((m) -> {
                logger.info("msgs : {} \n\t*********", m);
            });
            assertFalse(reportForText.hasErrors());
            logger.info("shouldPayloadFromFileConformToSchema() ### VALIDATION PAYLOAD REPORT END ###");
        } catch (Exception e) {
            logger.error("Error in shouldPayloadFromFileConformToSchema {}", e);
        }
    }
    private <T> T await(CompletionStage<T> future) throws Exception {
        return future.toCompletableFuture().get(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        if (clientFactory != null) {
            clientFactory.close();
        }
        if (system != null) {
            system.terminate();
        }
    }

}
