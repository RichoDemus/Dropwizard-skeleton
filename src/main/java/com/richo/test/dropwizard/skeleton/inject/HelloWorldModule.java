package com.richo.test.dropwizard.skeleton.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.richo.test.dropwizard.skeleton.HelloWorldConfiguration;
import com.richo.test.dropwizard.skeleton.service.Service;
import com.richo.test.dropwizard.skeleton.service.ServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class HelloWorldModule extends AbstractModule
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public HelloWorldModule() {
        logger.error("################HelloWorldModule created");
    }

    @Override
    protected void configure()
    {
        logger.error("################HelloWorldModule.configure");
        bind(ServiceApi.class).to(Service.class);
    }

    @Inject
    @Provides
    @Named("template")
    public String getTemplate(HelloWorldConfiguration configuration)
    {
        return configuration.getTemplate();
    }

    @Inject
    @Provides
    @Named("defaultName")
    public String getDefaultName(HelloWorldConfiguration configuration)
    {
        return configuration.getDefaultName();
    }
}
