package com.rccl.cp.ive.update.cruiseplanner.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;
import akka.stream.javadsl.Source;

public interface CruisePlannerStreamService extends Service {

    String CRUISE_PLANNER_EVENT_TOPIC = "ive.topic.cruise.planner.event";
    String METHOD_END_OF_STREAM = "END_OF_STREAM";

    ServiceCall<Source<CruisePlannerEventMessage, NotUsed>,
        Source<StreamResponse, NotUsed>> streamCruisePlannerEvents();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_cruiseplannerstream")
            .withCalls(restCall(Method.GET,
                "/api/v1/events/cruiseplannerstream",
                this::streamCruisePlannerEvents))
            .withAutoAcl(true);
        // @formatter:on
    }
}
