package com.rccl.cp.ive.update.cruisecompass.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;
import akka.stream.javadsl.Source;

public interface CruiseCompassStreamService extends Service {

    String CRUISE_COMPASS_EVENT_TOPIC = "ive.topic.cruise.compass.event";
    String METHOD_END_OF_STREAM = "END_OF_STREAM";

    ServiceCall<Source<CruiseCompassEventMessage, NotUsed>,
        Source<StreamResponse, NotUsed>> streamCruiseCompassEvents();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_cruisecompassstream")
            .withCalls(restCall(Method.GET,
                "/api/v1/events/cruisecompassstream",
                this::streamCruiseCompassEvents))
            .withAutoAcl(true);
        // @formatter:on
    }

}
