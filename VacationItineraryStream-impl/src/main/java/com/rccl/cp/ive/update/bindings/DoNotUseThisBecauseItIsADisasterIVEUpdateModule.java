/*

 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>

 */

package com.rccl.cp.ive.update.bindings;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassStreamService;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassUpdateService;
import com.rccl.cp.ive.update.cruisecompass.api.impl.CruiseCompassStreamServiceImpl;
import com.rccl.cp.ive.update.cruisecompass.api.impl.CruiseCompassUpdateServiceImpl;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEntityService;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerStreamService;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerUpdateService;
import com.rccl.cp.ive.update.cruiseplanner.api.StreamConsumerService;
import com.rccl.cp.ive.update.cruiseplanner.api.UpdateHealthCheckService;
import com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerEntityServiceImpl;
import com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerStreamServiceImpl;
import com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerUpdateServiceImpl;
import com.rccl.cp.ive.update.cruiseplanner.api.impl.StreamConsumerServiceImpl;
import com.rccl.cp.ive.update.cruiseplanner.api.impl.UpdateHealthCheckServiceImpl;
import com.rccl.cp.ive.update.dining.api.DiningUpdateService;
import com.rccl.cp.ive.update.dining.api.impl.DiningUpdateServiceImpl;
import com.rccl.cp.ive.update.readside.po.DoNotUseExtremelySlowPersistor;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;

/**
 *
 * The module that binds the StreamService so that it can be served.
 *
 */

public class DoNotUseThisBecauseItIsADisasterIVEUpdateModule extends
    AbstractModule implements ServiceGuiceSupport {

    @Override

    protected final void configure() {

        bindServices(
            serviceBinding(CruisePlannerUpdateService.class,
                CruisePlannerUpdateServiceImpl.class),
            serviceBinding(CruisePlannerStreamService.class,
                CruisePlannerStreamServiceImpl.class),
            serviceBinding(CruisePlannerEntityService.class,
                CruisePlannerEntityServiceImpl.class),
            serviceBinding(CruiseCompassUpdateService.class,
                CruiseCompassUpdateServiceImpl.class),
            serviceBinding(CruiseCompassStreamService.class,
                CruiseCompassStreamServiceImpl.class),
            serviceBinding(DiningUpdateService.class,
                DiningUpdateServiceImpl.class),
            serviceBinding(UpdateHealthCheckService.class,
                UpdateHealthCheckServiceImpl.class),
            serviceBinding(StreamConsumerService.class,
                StreamConsumerServiceImpl.class));

        // bind readside persistors

        bind(ReadsideGuestCalendarPersistor.class)
            .annotatedWith(Names.named("DefaultGuestCalendarEventPersistor"))
            .to(DoNotUseExtremelySlowPersistor.class);
    }
}
