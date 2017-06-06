package com.rccl.cp.ive.update.cruiseplanner.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.Done;
import akka.NotUsed;

public interface CruisePlannerUpdateService extends Service {

    String CRUISE_PLANNER_EVENT_TOPIC = "ive.topic.cruise.planner.event";

    ServiceCall<CruisePlannerEventMessage, Done>
        updateCruisePlannerEvents(String shipSailDate);
    ServiceCall<NotUsed, Done> removeCruisePlannerEvents(
        String shipSailDate,
        String guestID,
        String ownerGuestID,
        String ownerReservationID,
        String sourceSystemApplicationID,
        String sourcesystemOfferingID);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_cruiseplanner").withCalls(
            restCall(Method.POST,
                "/api/v1/events/commerce/:shipSailDate",
                this::updateCruisePlannerEvents),
            restCall(Method.DELETE,
                "/api/v1/events/commerce/:shipSailDate/:guestID/"
                    + ":ownerGuestID/:ownerReservationID/"
                    + ":sourceSystemApplicationID/:sourcesystemOfferingID",
                this::removeCruisePlannerEvents))
            .withAutoAcl(true);
        // @formatter:on
    }

}
