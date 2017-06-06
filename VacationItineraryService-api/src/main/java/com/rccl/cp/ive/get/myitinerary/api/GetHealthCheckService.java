package com.rccl.cp.ive.get.myitinerary.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;

public interface GetHealthCheckService extends Service {
    // getMyHealthCheck
    ServiceCall<NotUsed, String> getMyHealthCheck();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("guesthealth")
            .withCalls(restCall(Method.GET,
                "/api/v1/myItineraries/health",
                this::getMyHealthCheck)) // getMyHealthCheck
            .withAutoAcl(true);
        // @formatter:on
    }
}
