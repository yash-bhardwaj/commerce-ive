package com.rccl.cp.ive.update.cruiseplanner.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import akka.NotUsed;

public interface UpdateHealthCheckService extends Service {

    // getMyHealthCheck
    ServiceCall<NotUsed, String> getMyHealthCheck();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("updatehealth").withCalls(
            restCall(Method.GET,
                "/api/v1/events/commerce/health",
                this::getMyHealthCheck) // getMyHealthCheck
        ).withAutoAcl(true);
        // @formatter:on
    }
}
