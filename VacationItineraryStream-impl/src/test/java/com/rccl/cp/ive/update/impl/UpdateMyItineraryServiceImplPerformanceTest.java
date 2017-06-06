package com.rccl.cp.ive.update.impl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.startServer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.testkit.ServiceTest.Setup;
import com.lightbend.lagom.javadsl.testkit.ServiceTest.TestServer;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassUpdateService;
import com.rccl.cp.ive.update.cruisecompass.api.ImmutableCruiseCompassEventMessage;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerUpdateService;
import com.rccl.cp.ive.update.cruiseplanner.api.ImmutableCruisePlannerEventMessage;
import com.rccl.cp.ive.update.dining.api.DiningUpdateService;
import com.rccl.cp.ive.update.dining.api.ImmutableDiningEventMessage;

public class UpdateMyItineraryServiceImplPerformanceTest {

    private static TestServer testServer;
    private static CruiseCompassUpdateService cruiseCompassUpdateService;
    private static CruisePlannerUpdateService cruisePlannerUpdateService;
    private static DiningUpdateService diningUpdateService;
    private static com.datastax.driver.core.Session session;
    final Logger logger = LoggerFactory.getLogger(UpdateMyItineraryServiceImplPerformanceTest.class);

    private final static Setup setup = defaultSetup().withCassandra(true)
        .configureBuilder(b ->
    // by default, cassandra-query-journal delays propagation of events by
    // 10sec. In test we're using
    // a 1 node cluster so this delay is not necessary.
    b.configure("cassandra-query-journal.eventual-consistency-delay", "0")

    );

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        testServer = startServer(setup);
        cruiseCompassUpdateService = testServer.client(CruiseCompassUpdateService.class);
        cruisePlannerUpdateService = testServer.client(CruisePlannerUpdateService.class);
        diningUpdateService = testServer.client(DiningUpdateService.class);

        CassandraSession cSession = testServer.injector().instanceOf(CassandraSession.class);
        session = cSession.underlying().toCompletableFuture().get(3, TimeUnit.SECONDS);
        String path =
            UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader().getResource("cassandraSetup").getFile();
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
    public void maxAttendeeSelfEventTest() {
        ImmutableCruiseCompassEventMessage[] requests = new ImmutableCruiseCompassEventMessage[2];

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            String path16 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_self_event_request.json").getFile();
            String path300 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/300_attendee_self_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path16 = path16.substring(1);
                path300 = path300.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path16)));
            requests[0] = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);

            json = new String(Files.readAllBytes(Paths.get(path300)));
            requests[1] = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);
        } catch (Exception e) {
            logger.error("maxAttendeeSelfEventTest() Got Exception: {}", e.getMessage());
        }

        try {
            for (int i = 0; i < requests.length; i++) {
                ImmutableCruiseCompassEventMessage request = requests[i];
                await(cruiseCompassUpdateService.updateSelfEvents(request.shipSailDate())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke(request));
                logger.debug(
                    "maxAttendeeSelfEventTest() " + request.attendees().get().size() + " attendee test complete.");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.error("maxAttendeeSelfEventTest() Got Exception: {}", e.getMessage());
                }

                await(cruiseCompassUpdateService.removeSelfEvents(request.shipSailDate(), request.guestID(),
                    request.guestID(), request.cruiseBookingID(), request.sourceDetail().sourceSystemApplicationID(),
                    request.sourceDetail().sourceSystemOfferingID())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            }
        } catch (Exception e) {
            logger.error("maxAttendeeSelfEventTest() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

    }

    @Test
    public void maxAttendeeCruiseCompassEventTest() {
        ImmutableCruiseCompassEventMessage[] requests = new ImmutableCruiseCompassEventMessage[2];

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            String path16 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_cruisecompass_event_request.json").getFile();
            String path300 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/300_attendee_cruisecompass_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path16 = path16.substring(1);
                path300 = path300.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path16)));
            requests[0] = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);

            json = new String(Files.readAllBytes(Paths.get(path300)));
            requests[1] = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);
        } catch (Exception e) {
            logger.error("maxAttendeeCruiseCompassEventTest() Got Exception: {}", e.getMessage());
        }

        try {
            for (int i = 0; i < requests.length; i++) {
                ImmutableCruiseCompassEventMessage request = requests[i];
                await(cruiseCompassUpdateService.updateCruiseCompassEvents(request.shipSailDate())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke(request));
                logger.debug("maxAttendeeCruiseCompassEventTest() " + request.attendees().get().size()
                    + " attendee test complete.");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.error("maxAttendeeCruiseCompassEventTest() Got Exception: {}", e.getMessage());
                }

                await(cruiseCompassUpdateService.removeCruiseCompassEvents(request.shipSailDate(), request.guestID(),
                    request.guestID(), request.cruiseBookingID(), request.sourceDetail().sourceSystemApplicationID(),
                    request.sourceDetail().sourceSystemOfferingID())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            }
        } catch (Exception e) {
            logger.error("maxAttendeeCruiseCompassEventTest() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

    }

    @Test
    public void maxAttendeeCruisePlannerEventTest() {
        ImmutableCruisePlannerEventMessage[] requests = new ImmutableCruisePlannerEventMessage[2];

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            String path16 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_cruiseplanner_event_request.json").getFile();
            String path300 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/300_attendee_cruiseplanner_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path16 = path16.substring(1);
                path300 = path300.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path16)));
            requests[0] = mapper.readValue(json, ImmutableCruisePlannerEventMessage.class);

            json = new String(Files.readAllBytes(Paths.get(path300)));
            requests[1] = mapper.readValue(json, ImmutableCruisePlannerEventMessage.class);
        } catch (Exception e) {
            logger.error("maxAttendeeCruisePlannerEventTest() Got Exception: {}", e.getMessage());
        }

        try {
            for (int i = 0; i < requests.length; i++) {
                ImmutableCruisePlannerEventMessage request = requests[i];
                await(cruisePlannerUpdateService.updateCruisePlannerEvents(request.shipSailDate())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke(request));
                logger.debug("maxAttendeeCruisePlannerEventTest() " + request.attendees().get().size()
                    + " attendee test complete.");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.error("maxAttendeeCruisePlannerEventTest() Got Exception: {}", e.getMessage());
                }

                await(cruisePlannerUpdateService.removeCruisePlannerEvents(request.shipSailDate(), request.guestID(),
                    request.guestID(), request.cruiseBookingID(), request.sourceDetail().sourceSystemApplicationID(),
                    request.sourceDetail().sourceSystemOfferingID())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            }
        } catch (Exception e) {
            logger.error("maxAttendeeCruisePlannerEventTest() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

    }

    @Test
    public void maxAttendeeDiningEventTest() {
        ImmutableDiningEventMessage[] requests = new ImmutableDiningEventMessage[2];

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            String path16 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_dining_event_request.json").getFile();
            String path300 = UpdateMyItineraryServiceImplPerformanceTest.class.getClassLoader()
                .getResource("requests/300_attendee_dining_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path16 = path16.substring(1);
                path300 = path300.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path16)));
            requests[0] = mapper.readValue(json, ImmutableDiningEventMessage.class);

            json = new String(Files.readAllBytes(Paths.get(path300)));
            requests[1] = mapper.readValue(json, ImmutableDiningEventMessage.class);
        } catch (Exception e) {
            logger.error("maxAttendeeDiningEventTest() Got Exception: {}", e.getMessage());
        }

        try {
            for (int i = 0; i < requests.length; i++) {
                ImmutableDiningEventMessage request = requests[i];
                await(diningUpdateService.updateEvents(request.shipSailDate())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke(request));
                logger.debug(
                    "maxAttendeeDiningEventTest() " + request.attendees().get().size() + " attendee test complete.");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.error("maxAttendeeDiningEventTest() Got Exception: {}", e.getMessage());
                }

                await(diningUpdateService.removeEvents(request.shipSailDate(), request.guestID(),
                    request.guestID(), request.cruiseBookingID(), request.sourceDetail().sourceSystemApplicationID(),
                    request.sourceDetail().sourceSystemOfferingID())
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            }
        } catch (Exception e) {
            logger.error("maxAttendeeDiningEventTest() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

    }

    @AfterClass
    public static void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }

    private <T> T await(CompletionStage<T> future) throws Exception {
        return future.toCompletableFuture().get(10, TimeUnit.SECONDS);
    }

}
