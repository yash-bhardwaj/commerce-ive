package com.rccl.cp.ive.get.myitinerary.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;

public interface GetMyItineraryService extends Service {

    ServiceCall<NotUsed, MyItinerary> getMyItinerary(
        String shipSailDate,
        String cruiseBookingID,
        String guestID);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("myItineraries")
            .withCalls(
                restCall(Method.GET,
                    "/api/v1/myItineraries/:shipSailDate/:cruiseBookingID/:guestID",
                    this::getMyItinerary))
            .withAutoAcl(true);
        // @formatter:on
    }

}
