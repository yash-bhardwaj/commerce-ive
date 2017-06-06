package com.rccl.cp.ive.update.cruiseplanner.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;
import akka.stream.javadsl.Source;

public interface CruisePlannerEntityService extends Service {

    ServiceCall<String, Source<CruisePlannerEventMessage, NotUsed>>
        getCruisePlannerEventStates(String entityId);

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("entities_cruiseplanner").withCalls(
            restCall(Method.GET,
                "/api/v1/events/commerce_entity/:id",
                this::getCruisePlannerEventStates))
            .withAutoAcl(true);
        // @formatter:on
    }
}
