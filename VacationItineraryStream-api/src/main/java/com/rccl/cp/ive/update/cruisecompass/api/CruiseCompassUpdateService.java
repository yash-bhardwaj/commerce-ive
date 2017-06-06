package com.rccl.cp.ive.update.cruisecompass.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.Done;
import akka.NotUsed;

public interface CruiseCompassUpdateService extends Service {

    String CRUISE_COMPASS_EVENT_TOPIC = "ive.topic.cruise.compass.event";

    ServiceCall<CruiseCompassEventMessage, Done> updateCruiseCompassEvents(
        String shipSailDate);
    ServiceCall<NotUsed, Done> removeCruiseCompassEvents(
        String shipSailDate,
        String guestID,
        String ownerGuestID,
        String ownerReservationID,
        String sourceSystemApplicationID,
        String sourcesystemOfferingID);

    ServiceCall<CruiseCompassEventMessage, Done> updateSelfEvents(
        String shipSailDate);
    ServiceCall<NotUsed, Done> removeSelfEvents(
        String shipSailDate,
        String guestID,
        String ownerGuestID,
        String ownerReservationID,
        String sourceSystemApplicationID,
        String sourcesystemOfferingID);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_cruisecompass").withCalls(
            restCall(Method.POST,
                "/api/v1/events/cruisecompass/:shipSailDate",
                this::updateCruiseCompassEvents),
            restCall(Method.DELETE,
                "/api/v1/events/cruisecompass/:shipSailDate/:guestID/"
                    + ":ownerGuestID/:ownerReservationID/"
                    + ":sourceSystemApplicationID/:sourcesystemOfferingID",
                this::removeCruiseCompassEvents),
            restCall(Method.POST,
                "/api/v1/events/self/:shipSailDate",
                this::updateSelfEvents),
            restCall(Method.DELETE,
                "/api/v1/events/self/:shipSailDate/:guestID/"
                    + ":ownerGuestID/:ownerReservationID/"
                    + ":sourceSystemApplicationID/:sourcesystemOfferingID",
                this::removeSelfEvents))
            .withAutoAcl(true);
        // @formatter:on
    }

}
