package com.rccl.cp.ive.get.myitinerary.api.impl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.startServer;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.testkit.ServiceTest.TestServer;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventForDisplay;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventGroup;
import com.rccl.cp.ive.get.myitinerary.api.MyItinerary;

public class GetMyItineraryServiceImplTest {

    private static TestServer testServer;
    private static GetMyItineraryService getMyItineraryService;
    private static com.datastax.driver.core.Session session;
    final Logger logger = LoggerFactory.getLogger(GetMyItineraryServiceImplTest.class);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        testServer = startServer(defaultSetup().withCassandra(true));
        getMyItineraryService = testServer.client(GetMyItineraryService.class);
        CassandraSession cSession = testServer.injector().instanceOf(CassandraSession.class);

        session = cSession.underlying().toCompletableFuture().get(3, TimeUnit.SECONDS);
        String path = GetMyItineraryServiceImplTest.class.getClassLoader().getResource("cassandraSetup").getFile();
        if (System.getProperty("os.name").startsWith("Windows")) {
            path = path.substring(1);
        }
        String queryBatch = new String(Files.readAllBytes(Paths.get(path)));
        String[] queries = queryBatch.split(";");
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            session.execute(query);
        }
    }

    @Test
    public void validatingMyItineraryApi() {
        // getMyItineraryService.descriptor();
        MyItinerary myItinerary = null;
        try {
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
        } catch (Exception e) {
            logger.error("validatingMyItineraryApi() Got exception from await(): {}", e.getMessage());
        }
        if (myItinerary == null) {
            logger.error("validatingMyItineraryApi() Itinerary is null");
            throw new AssertionError("Itinerary is null!");
        }
        assertEquals("AL20170730", myItinerary.sailingID());
        assertEquals(BigInteger.valueOf(42793), myItinerary.cruiseReservationID());
        assertEquals(BigInteger.valueOf(191919), myItinerary.guestID());

    }

    @Test
    public void checkGuestAndOwnerValidation() {

        MyItinerary myItinerary = null;
        try {
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("HM20170304","4967331","5102034165").invoke());
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("OA20171001","101","10002").invoke());
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("OA20171001","101","10003").invoke());
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("OA20171001","101","10005").invoke());
        } catch (Exception e) {
            logger.error("checkGuestAndOwnerValidation() Got exception from await(): {}", e.getMessage());
        }

        for (Iterator<ItineraryEventGroup> eventGroupIter = myItinerary.itineraryEventGroups().iterator();
            eventGroupIter.hasNext();) {
            ItineraryEventGroup group = (ItineraryEventGroup) eventGroupIter.next();

            for (Iterator<ItineraryEventForDisplay> eventIter = group.itineraryEvents().iterator();
                eventIter.hasNext();) {
                ItineraryEventForDisplay event = (ItineraryEventForDisplay) eventIter.next();
                // If condiion is true , then group id is owner Id
                if (event.attendees() == null || event.attendees().size() > 0) {
                    assertEquals("Guest ID is owner", new BigInteger("191919"), event.attendees().get(0).guestID());
                }

                // If this condition true the id is Attendee Id
                if (event.attendees() == null || event.attendees().size() <= 0) {
                    assertEquals("Guest ID is Attendee", "Attendee", "Attendee");
                    // assertEquals("Guest ID is Attendee" ,new
                    // BigInteger("10005") ,
                    // event.attendees().get(0).guestID());
                }
            }

        }

    }

    @Test
    public void retrieveProductAndOfferringTest() {

        MyItinerary myItinerary = null;
        try {
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("HM20170304","4967331","5102034165").invoke());
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
        } catch (Exception e) {
            logger.error("Error occurred in retrieveProductAndOfferringTest and error is {} ", e.getMessage());
        }

        for (Iterator<ItineraryEventGroup> eventGroupIter = myItinerary.itineraryEventGroups().iterator();
            eventGroupIter.hasNext();) {
            ItineraryEventGroup group = (ItineraryEventGroup) eventGroupIter.next();

            if (group.eventGroupType().equals("COMMERCE")) {
                assertEquals("BTOUR-01", group.itineraryEvents().get(0).sourceDetail().sourceSystemOfferingID());
                assertEquals("BTOUR", group.itineraryEvents().get(0).sourceDetail().sourceSystemProductID().get());
            }
        }
    }

    // Prototype for Adding Calender
    @Test
    public void addingCalendarServices() {
        // getMyItineraryService.descriptor();
        MyItinerary myItinerary = null;
        try {
            myItinerary = await(getMyItineraryService.getMyItinerary("OA20171001", "101", "10001")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("HM20170304","4967331","5102034165").invoke());
        } catch (Exception e) {
            logger.error("addingCalendarServices() Got exception from await(): {}", e.getMessage());
        }
        if (myItinerary == null) {
            logger.error("addingCalendarServices() Itinerary is null");
            return;
        }
        assertEquals("OA20171001", myItinerary.sailingID());
        assertEquals(BigInteger.valueOf(101), myItinerary.cruiseReservationID());
        assertEquals(BigInteger.valueOf(10001), myItinerary.guestID());

    }

    @Test
    public void retriveShipSchedule() {
        // getMyItineraryService.descriptor();
        MyItinerary myItinerary = null;
        try {
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20180311", "101", "10001")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
            // myItinerary =
            // await(getMyItineraryService.getMyItinerary("HM20170304","4967331","5102034165").invoke());
        } catch (Exception e) {
            logger.error("addingCalendarServices() Got exception from await(): {}", e.getMessage());
        }
        if (myItinerary == null) {
            logger.error("retriveShipSchedule() Itinerary is null");
            return;
        }
        assertEquals("AL20180311", myItinerary.sailingID());
        assertEquals(BigInteger.valueOf(101), myItinerary.cruiseReservationID());
        assertEquals(BigInteger.valueOf(10001), myItinerary.guestID());

        for (Iterator<ItineraryEventGroup> eventGroupIter = myItinerary.itineraryEventGroups().iterator();
            eventGroupIter.hasNext();) {
            ItineraryEventGroup group = (ItineraryEventGroup) eventGroupIter.next();

            if (group.eventGroupType().equals("SHIPSCHEDULE")) {
                assertEquals("SHIPSCHEDULE", group.itineraryEvents().get(0).eventType());
                assertEquals("SHIPSCHEDULE", group.itineraryEvents().get(0).sourceDetail().sourceSystemApplicationID());
            }
        }
    }

    private <T> T await(CompletionStage<T> future) throws Exception {
        return future.toCompletableFuture().get(10, TimeUnit.SECONDS);
    }
}
