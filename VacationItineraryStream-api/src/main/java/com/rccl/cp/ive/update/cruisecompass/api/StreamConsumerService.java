/*
 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.rccl.cp.ive.update.cruisecompass.api;

import static com.lightbend.lagom.javadsl.api.Service.named;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;

/**
 * The VacationItineraryStream interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the HelloStream service.
 */
public interface StreamConsumerService extends Service {

    @Override
    default Descriptor descriptor() {
        return named("StreamConsumerService")
            .withAutoAcl(true);
    }
}
