package com.rccl.cp.ive.update.bindings;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.api.ConfigurationServiceLocator;
import com.lightbend.lagom.javadsl.api.ServiceLocator;

import play.Configuration;
import play.Environment;

public class ConfigurationServiceLocatorModule extends AbstractModule {

    private final Environment environment;
    @SuppressWarnings("unused")
    private final Configuration configuration;

    @SuppressWarnings("unused")
    public ConfigurationServiceLocatorModule(final Environment environ,
        final Configuration config) {
        this.environment = environ;
        this.configuration = config;
    }

    @Override
    protected final void configure() {
        if (environment.isProd()) {
            bind(ServiceLocator.class).to(ConfigurationServiceLocator.class);
        }
    }
}
