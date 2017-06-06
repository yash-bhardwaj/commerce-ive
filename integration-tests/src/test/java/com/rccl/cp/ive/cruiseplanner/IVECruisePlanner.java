package com.rccl.cp.ive.cruiseplanner;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.api.transport.RequestHeader;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;
import com.rccl.cp.ive.it.IVEIT;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.ImmutableEventAttendee;
import com.rccl.cp.ive.update.common.ImmutableEventLocation;
import com.rccl.cp.ive.update.common.ImmutableEventSourceDetail;
import com.rccl.cp.ive.update.common.ImmutableEventTime;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerUpdateService;
import com.rccl.cp.ive.update.cruiseplanner.api.ImmutableCruisePlannerEventMessage;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;

public class IVECruisePlanner {


    private static final String SERVICE_LOCATOR_URI = "http://localhost:8000";

    private static LagomClientFactory clientFactory;
    private static CruisePlannerUpdateService plannerUpdateService;

    private static ActorSystem system;
    private static Materializer mat;
    final Logger logger = LoggerFactory.getLogger(IVECruisePlanner.class);

    private static Function<RequestHeader, RequestHeader> handler = header -> header.withHeader("api-key", "5656");

    @BeforeClass
    public static void setup() {
        clientFactory = LagomClientFactory.create("integration-test", IVEIT.class.getClassLoader());
        // One of the clients can use the service locator, the other can use the
        // service gateway, to test them both.
        plannerUpdateService =
            clientFactory.createDevClient(CruisePlannerUpdateService.class, URI.create(SERVICE_LOCATOR_URI));

        system = ActorSystem.create();
        mat = ActorMaterializer.create(system);

    }

    @Test
    public void updateEvents() throws Exception {
        Object obj =
            await(plannerUpdateService.updateCruisePlannerEvents("AL20170611").handleRequestHeader(handler)
                .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
                .invoke(getCruisePlannerEventMessage()));

        if (!(obj instanceof Done)) {
            throw new AssertionError("Dining update issue test failed");
        }
    }

    @Test
    public void removeEvents() throws Exception {

        Object obj = await(plannerUpdateService
            .removeCruisePlannerEvents("AL20170611", "191919", "191919", "42793", "PCP", "ABSD01")
            .handleRequestHeader(handler)
            .handleRequestHeader(rh -> rh.withHeader("api-key", "TESTKEY"))
            .invoke());

        if (!(obj instanceof Done)) {
            throw new AssertionError("cruisePlanner update issue test failed");
        }
    }

    private CruisePlannerEventMessage getCruisePlannerEventMessage() {

        List<EventAttendee> attendees = new ArrayList<>();

        /*
         * DiningEventMessage diningEventMessage = null; ObjectMapper mapper =
         * new ObjectMapper(); try { diningEventMessage = mapper.readValue(new
         * File(
         * "/home/ravi/Downloads/add_dining_event_sample_request_20170412.json")
         * , ImmutableDiningEventMessage.class); } catch
         * (JsonGenerationException e) { // TODO Auto-generated catch block
         * logger.
         * error("getCruisePlannerEventMessage() got JsonGenerationException: {}"
         * , e.getMessage()); } catch (JsonMappingException e) { // TODO
         * Auto-generated catch block logger.
         * error("getCruisePlannerEventMessage() got JsonMappingException: {}",
         * e.getMessage()); } catch (IOException e) { // TODO Auto-generated
         * catch block
         * logger.error("getCruisePlannerEventMessage() got IOException: {}",
         * e.getMessage()); }
         */

        // System.err.println(diningEventMessage.cruiseBookingID());

        EventAttendee attendee1 = ImmutableEventAttendee.builder()
            .cruiseReservationID("42793")
            .guestID("191919")
            .sailingID("AL20170611")
            .firstName("Shih-Chien")
            .lastName("Lu").build();

        EventAttendee attendee2 = ImmutableEventAttendee.builder()
            .cruiseReservationID("42793")
            .guestID("202020")
            .sailingID("AL20170611")
            .firstName("Robert")
            .lastName("Volante").build();

        attendees.add(attendee1);
        attendees.add(attendee2);

        CruisePlannerEventMessage eventMessage = ImmutableCruisePlannerEventMessage.builder()
            .cruiseBookingID("42793")
            .guestID("191919")
            .shipSailDate("AL20170611")
            .eventGroupType("SHIPSCHEDULE")
            .eventGroupDescription("Ship Schedule")
            .eventType("SHOREX")
            .eventLocale("en_US")
            .eventName("Shore Excursion Test")
            .eventLocation(ImmutableEventLocation.builder()
                .locationCode("MIA")
                .locationName("Miami")
                .locationType("PORT").build())
            .eventStartTime(ImmutableEventTime.builder()
                .eventTime("20:00")
                .eventDate("2017-07-04")
                .eventTimeZone("SHIP").build())
            .eventEndTime(ImmutableEventTime.builder()
                .eventTime("21:30")
                .eventDate("2017-07-04")
                .eventTimeZone("SHIP").build())
            .sourceDetail(ImmutableEventSourceDetail.builder()
                .sourceSystemApplicationID("PCP")
                .sourceSystemReservationID("100001")
                .sourceSystemOrderID("11111")
                .sourceSystemExternalOrderID("")
                .sourceSystemProductID("12345")
                .sourceSystemOfferingID("ABSD01")
                .sourceSystemProductName("Beach Tour").build())
            .attendees(attendees).build();

        return eventMessage;
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
