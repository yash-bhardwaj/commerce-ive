/*
 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.rccl.cp.ive.api.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.rccl.cp.ive.get.myitinerary.api.GetHealthCheckService;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;
import com.rccl.cp.ive.get.myitinerary.api.impl.GetHealthCheckServiceImpl;
import com.rccl.cp.ive.get.myitinerary.api.impl.GetMyItineraryServiceImpl;

/**
 * The module that binds the VacationItineraryServiceService so that it can be
 * served.
 */
public class VacationItineraryServiceModule
    extends AbstractModule
    implements ServiceGuiceSupport {
    @Override
    protected final void configure() {
        bindServices(
            serviceBinding(GetMyItineraryService.class,
                GetMyItineraryServiceImpl.class),
            serviceBinding(GetHealthCheckService.class,
                GetHealthCheckServiceImpl.class));
    }
}
