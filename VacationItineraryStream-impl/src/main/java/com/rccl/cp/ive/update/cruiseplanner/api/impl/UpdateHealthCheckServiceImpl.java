package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.concurrent.CompletableFuture;

import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.rccl.cp.ive.update.cruiseplanner.api.UpdateHealthCheckService;

import akka.NotUsed;

public class UpdateHealthCheckServiceImpl implements UpdateHealthCheckService {
    @Override
    public final ServiceCall<NotUsed, String> getMyHealthCheck() {
        return request -> CompletableFuture.completedFuture(
            "/api/v1/events/commerce/health service is up...");
    }
}
