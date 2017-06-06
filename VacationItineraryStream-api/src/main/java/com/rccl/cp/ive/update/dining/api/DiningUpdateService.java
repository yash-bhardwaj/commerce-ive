package com.rccl.cp.ive.update.dining.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.Done;
import akka.NotUsed;

public interface DiningUpdateService extends Service {

    ServiceCall<DiningEventMessage, Done> updateEvents(String shipSailDate);
    ServiceCall<NotUsed, Done> removeEvents(
        String shipSailDate,
        String guestID,
        String ownerGuestID,
        String ownerReservationID,
        String sourceSystemApplicationID,
        String sourcesystemOfferingID);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_dining").withCalls(
            restCall(Method.POST, "/api/v1/events/dining/:shipSailDate",
                this::updateEvents),
            restCall(Method.DELETE,
                "/api/v1/events/dining/:shipSailDate/:guestID/"
                    + ":ownerGuestID/:ownerReservationID/"
                    + ":sourceSystemApplicationID/:sourcesystemOfferingID",
                this::removeEvents))
            .withAutoAcl(true);
        // @formatter:on
    }
}
