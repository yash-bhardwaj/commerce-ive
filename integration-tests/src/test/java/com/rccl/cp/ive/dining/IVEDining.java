package com.rccl.cp.ive.dining;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.lightbend.lagom.javadsl.api.transport.RequestHeader;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;
import com.rccl.cp.ive.it.IVEIT;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import com.rccl.cp.ive.update.dining.api.DiningUpdateService;
import com.rccl.cp.ive.update.dining.api.ImmutableDiningEventMessage;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;

public class IVEDining {

    private static final String SERVICE_LOCATOR_URI = "http://localhost:8000";

    private static LagomClientFactory clientFactory;
    private static DiningUpdateService diningUpdateService;

    private static ActorSystem system;
    private static Materializer mat;

    private static ArrayList<DiningEventMessage> diningEventMessagesList = null;
    static final Logger logger = LoggerFactory.getLogger(IVEDining.class);

    private static Function<RequestHeader, RequestHeader> handler = header -> header.withHeader("api-key", "5656");

    @BeforeClass
    public static void setup() {
        clientFactory = LagomClientFactory.create("integration-test", IVEIT.class.getClassLoader());
        // One of the clients can use the service locator, the other can use the
        // service gateway, to test them both.
        diningUpdateService = clientFactory.createDevClient(DiningUpdateService.class, URI.create(SERVICE_LOCATOR_URI));

        diningEventMessagesList = getDiningEventMessageList();

        system = ActorSystem.create();
        mat = ActorMaterializer.create(system);
    }

    @Test
    public void updateEvents() throws Exception {

        for (DiningEventMessage msg : diningEventMessagesList) {
            Object obj = await(diningUpdateService.updateEvents(msg.shipSailDate()).handleRequestHeader(handler)
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(msg));
            if (!(obj instanceof Done)) {
                throw new AssertionError("Dining update issue test failed");
            }
        }

    }

    @Test
    public void removeEvents() throws Exception {

        for (DiningEventMessage msg : diningEventMessagesList) {
            Object obj = await(diningUpdateService.removeEvents(msg.shipSailDate(),
                msg.guestID(),
                msg.guestID(),
                msg.cruiseBookingID(),
                msg.sourceDetail().sourceSystemApplicationID(),
                msg.sourceDetail().sourceSystemOfferingID()).handleRequestHeader(handler)
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke());

            if (!(obj instanceof Done)) {
                throw new AssertionError("Dining update issue test failed");
            }
        }

    }

    private static ArrayList<DiningEventMessage> getDiningEventMessageList() {

        ArrayList<DiningEventMessage> diningEventMessagesList = null;
        // String jsonfile = "dining_event_sample_request.json";
        String jsonfile = "dining_event_sample_request_many_attendees.json";
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser
                .parse(new InputStreamReader(IVEDining.class.getClassLoader().getResourceAsStream(jsonfile)));

            if (jsonArray.size() == 0) {
                return null;
            }

            diningEventMessagesList = new ArrayList<>();

            DiningEventMessage diningEventMessage = null;
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new GuavaModule());
            mapper.registerModule(new Jdk8Module());

            JSONObject jsonObject = null;
            for (Object obj : jsonArray) {
                jsonObject = (JSONObject) obj;
                diningEventMessage = mapper.readValue(jsonObject.toJSONString(), ImmutableDiningEventMessage.class);
                diningEventMessagesList.add(diningEventMessage);
            }

        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            logger.error("getDiningEventMessageList() Got ParseException: {}", e1.getMessage());
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            logger.error("getDiningEventMessageList() Got JsonParseException: {}", e.getMessage());
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            logger.error("getDiningEventMessageList() Got JsonMappingException: {}", e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("getDiningEventMessageList() Got IOException: {}", e.getMessage());
        }

        return diningEventMessagesList;
    }

    private <T> T await(CompletionStage<T> future) throws Exception {
        return future.toCompletableFuture().get(100, TimeUnit.SECONDS);
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
