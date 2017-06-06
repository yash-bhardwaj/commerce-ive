package com.rccl.cp.ive.api.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.api.ConfigurationServiceLocator;
import com.lightbend.lagom.javadsl.api.ServiceLocator;

import play.Configuration;
import play.Environment;

@SuppressWarnings({"unused", "URF_UNREAD_FIELD"})
public class ConfigurationServiceLocatorModule extends AbstractModule {

    private final Environment environment;
    private final Configuration configuration;

    public ConfigurationServiceLocatorModule(final Environment env,
        final Configuration config) {
        this.environment = env;
        this.configuration = config;
    }

    @Override
    protected final void configure() {
        if (environment.isProd()) {
            bind(ServiceLocator.class).to(ConfigurationServiceLocator.class);
        }
    }
}
