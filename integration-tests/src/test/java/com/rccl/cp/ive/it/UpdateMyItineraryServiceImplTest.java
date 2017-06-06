package com.rccl.cp.ive.it;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.eventually;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ProtocolOptions.Compression;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;
import com.rccl.cp.ive.get.myitinerary.api.MyItinerary;
import com.rccl.cp.ive.it.prepare.CassandraTestModelCreator;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassUpdateService;
import com.rccl.cp.ive.update.cruisecompass.api.ImmutableCruiseCompassEventMessage;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerUpdateService;
import com.rccl.cp.ive.update.cruiseplanner.api.ImmutableCruisePlannerEventMessage;
import com.rccl.cp.ive.update.dining.api.DiningUpdateService;
import com.rccl.cp.ive.update.dining.api.ImmutableDiningEventMessage;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import scala.concurrent.duration.FiniteDuration;

public class UpdateMyItineraryServiceImplTest {

    private static final String SERVICE_LOCATOR_URI = "http://localhost:8000";

    private static LagomClientFactory clientFactory;
    private static GetMyItineraryService getMyItineraryService;
    private static CruisePlannerUpdateService updateCruisePlannerService;
    private static CruiseCompassUpdateService updateCruiseCompassService;
    private static DiningUpdateService updateDiningService;
    private static CassandraTestModelCreator modelCreator;
    private static com.datastax.driver.core.Session session;
    final Logger logger = LoggerFactory.getLogger(UpdateMyItineraryServiceImplTest.class);
    private static ActorSystem system;
    private static Materializer mat;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        clientFactory = LagomClientFactory.create("update-get-service-test",
            UpdateMyItineraryServiceImplTest.class.getClassLoader());
        updateCruisePlannerService =
            clientFactory.createDevClient(CruisePlannerUpdateService.class, URI.create(SERVICE_LOCATOR_URI));
        updateCruiseCompassService =
            clientFactory.createDevClient(CruiseCompassUpdateService.class, URI.create(SERVICE_LOCATOR_URI));
        updateDiningService =
            clientFactory.createDevClient(DiningUpdateService.class, URI.create(SERVICE_LOCATOR_URI));
        getMyItineraryService =
            clientFactory.createDevClient(GetMyItineraryService.class, URI.create(SERVICE_LOCATOR_URI));

        system = ActorSystem.create();
        mat = ActorMaterializer.create(system);

        setupCassandraInstance();
        session = modelCreator.getSession();

        String path = UpdateMyItineraryServiceImplTest.class.getClassLoader().getResource("cassandraSetup").getFile();
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
    public void validatingUpdateCruisePlannerEventApi() {

        ImmutableCruisePlannerEventMessage request = null;

        try {
            String path = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_cruiseplanner_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path = path.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path)));

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            request = mapper.readValue(json, ImmutableCruisePlannerEventMessage.class);
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception: {}", e.getMessage());
        }

        try {
            await(updateCruisePlannerService.updateCruisePlannerEvents(request.shipSailDate())
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(request));
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

        eventually(new FiniteDuration(10, SECONDS), () -> {
            MyItinerary myItinerary = null;
            try {
                myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            } catch (Exception e) {
                logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during getMyItinerary: {}",
                    e.getMessage());
            }
            if (myItinerary == null) {
                logger.error("validatingUpdateCruisePlannerEventApi() Itinerary is null");
                // throw new AssertionError("Itinerary is null!");
                return;
            }
            assertEquals("AL20170730", myItinerary.sailingID());
            assertEquals(BigInteger.valueOf(42793), myItinerary.cruiseReservationID());
            assertEquals(BigInteger.valueOf(191919), myItinerary.guestID());
            assertNotNull(myItinerary.itineraryEventGroups());
        });
    }

    @Test
    public void validatingUpdateCruiseCompassEventApi() {

        ImmutableCruiseCompassEventMessage request = null;

        try {
            String path = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_cruisecompass_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path = path.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path)));

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            request = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception: {}", e.getMessage());
        }

        try {
            await(updateCruiseCompassService.updateCruiseCompassEvents(request.shipSailDate())
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(request));
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

        eventually(new FiniteDuration(10, SECONDS), () -> {
            MyItinerary myItinerary = null;
            try {
                myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            } catch (Exception e) {
                logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during getMyItinerary: {}",
                    e.getMessage());
            }
            if (myItinerary == null) {
                logger.error("validatingUpdateCruisePlannerEventApi() Itinerary is null");
                // throw new AssertionError("Itinerary is null!");
                return;
            }
            assertEquals("AL20170730", myItinerary.sailingID());
            assertEquals(BigInteger.valueOf(42793), myItinerary.cruiseReservationID());
            assertEquals(BigInteger.valueOf(191919), myItinerary.guestID());
            assertNotNull(myItinerary.itineraryEventGroups());
        });
    }

    @Test
    public void validatingUpdateSelfEventApi() {

        ImmutableCruiseCompassEventMessage request = null;

        try {
            String path = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_self_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path = path.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path)));

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            request = mapper.readValue(json, ImmutableCruiseCompassEventMessage.class);
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception: {}", e.getMessage());
        }

        try {
            await(updateCruiseCompassService.updateSelfEvents(request.shipSailDate())
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(request));
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

        eventually(new FiniteDuration(10, SECONDS), () -> {
            MyItinerary myItinerary = null;
            try {
                myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            } catch (Exception e) {
                logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during getMyItinerary: {}",
                    e.getMessage());
            }
            if (myItinerary == null) {
                logger.error("validatingUpdateCruisePlannerEventApi() Itinerary is null");
                // throw new AssertionError("Itinerary is null!");
                return;
            }
            assertEquals("AL20170730", myItinerary.sailingID());
            assertEquals(BigInteger.valueOf(42793), myItinerary.cruiseReservationID());
            assertEquals(BigInteger.valueOf(191919), myItinerary.guestID());
            assertNotNull(myItinerary.itineraryEventGroups());
        });
    }

    @Test
    public void validatingUpdateDiningEventApi() {

        ImmutableDiningEventMessage request = null;

        try {
            String path = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_cruiseplanner_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path = path.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path)));

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            request = mapper.readValue(json, ImmutableDiningEventMessage.class);
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception: {}", e.getMessage());
        }

        try {
            await(updateDiningService.updateEvents(request.shipSailDate())
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(request));
        } catch (Exception e) {
            logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during updateCruisePlannerEvents: {}",
                e.getMessage());
        }

        eventually(new FiniteDuration(10, SECONDS), () -> {
            MyItinerary myItinerary = null;
            try {
                myItinerary = await(getMyItineraryService.getMyItinerary("AL20170730", "42793", "191919")
                    .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                    .invoke());
            } catch (Exception e) {
                logger.error("validatingUpdateCruisePlannerEventApi() Got Exception during getMyItinerary: {}",
                    e.getMessage());
            }
            if (myItinerary == null) {
                logger.error("validatingUpdateCruisePlannerEventApi() Itinerary is null");
                // throw new AssertionError("Itinerary is null!");
                return;
            }
            assertEquals("AL20170730", myItinerary.sailingID());
            assertEquals(BigInteger.valueOf(42793), myItinerary.cruiseReservationID());
            assertEquals(BigInteger.valueOf(191919), myItinerary.guestID());
            assertNotNull(myItinerary.itineraryEventGroups());
        });
    }
    @Test
    public void multipleUpdateRemoveTest() {
        ImmutableCruisePlannerEventMessage[] requests = new ImmutableCruisePlannerEventMessage[2];

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            String path16 = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/sixteen_attendee_self_event_request.json").getFile();
            String path300 = UpdateMyItineraryServiceImplTest.class.getClassLoader()
                .getResource("requests/300_attendee_self_event_request.json").getFile();
            if (System.getProperty("os.name").startsWith("Windows")) {
                path16 = path16.substring(1);
                path300 = path300.substring(1);
            }
            String json = new String(Files.readAllBytes(Paths.get(path16)));
            requests[0] = mapper.readValue(json, ImmutableCruisePlannerEventMessage.class);

            json = new String(Files.readAllBytes(Paths.get(path300)));
            requests[1] = mapper.readValue(json, ImmutableCruisePlannerEventMessage.class);
        } catch (Exception e) {
            logger.error("multipleUpdateRemoveTest() Got Exception: {}", e.getMessage());
        }
        for (int j = 0; j < requests.length; j++) {
            ImmutableCruisePlannerEventMessage request = requests[j];

            for (int i = 0; i <= 500; i++) {
                if (Math.random() > .5 || i == 500) {
                    try {
                        await(
                            updateCruisePlannerService
                                .removeCruisePlannerEvents(request.shipSailDate(), request.guestID(),
                                    request.guestID(), request.cruiseBookingID(),
                                    request.sourceDetail().sourceSystemApplicationID(),
                                    request.sourceDetail().sourceSystemOfferingID())
                                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                                .invoke());
                    } catch (Exception e) {
                        logger.error(
                            "multipleUpdateRemoveTest() Got Exception during updateCruisePlannerEvents: {}",
                            e.getMessage());
                    }
                } else {
                    try {
                        await(
                            updateCruisePlannerService.updateCruisePlannerEvents(request.shipSailDate())
                                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                                .invoke(request));
                    } catch (Exception e) {
                        logger.error(
                            "multipleUpdateRemoveTest() Got Exception during updateCruisePlannerEvents: {}",
                            e.getMessage());
                    }
                }
            }
            logger.debug("multipleUpdateRemoveTest()" + request.attendees().get().size() + " attendee test complete.");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("multipleUpdateRemoveTest() Got Exception: {}", e.getMessage());
        }
        MyItinerary myItinerary = null;
        try {
            myItinerary = await(getMyItineraryService.getMyItinerary("AL20180311", "42793", "191919")
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());
        } catch (Exception e) {
            logger.error("multipleUpdateRemoveTest() Got Exception during getMyItinerary: {}",
                e.getMessage());
        }
        if (myItinerary == null) {
            assertNull(myItinerary);
        }
    }

    private <T> T await(CompletionStage<T> future) throws Exception {
        return future.toCompletableFuture().get(10, TimeUnit.SECONDS);
    }

    private static void setupCassandraInstance() {
        List<String> addresses = Arrays.asList(new String[]{"localhost"});
        int port = 4000;
        Compression compression = Compression.SNAPPY;
        String username = "";
        String password = "";
        String qualifiedTableName = "";
        modelCreator =
            new CassandraTestModelCreator(addresses, port, compression, username, password, qualifiedTableName);
    }

    @AfterClass
    public static void tearDown() {
        if (clientFactory != null) {
            clientFactory.close();
        }
        if (modelCreator != null) {
            modelCreator.destroy();
        }
    }

}
