package com.rccl.cp.ive.update.dining.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;
import akka.stream.javadsl.Source;

public interface DiningStreamProducerService extends Service {

    ServiceCall<Source<DiningEventMessage, NotUsed>,
        Source<DiningEventMessage, NotUsed>> streamEvents();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("events_cruiseplannerstream")
            .withCalls(restCall(Method.GET,
                "/api/v1/events/cruiseplannerstream", this::streamEvents))
            .withAutoAcl(true);
        // @formatter:on
    }
}
