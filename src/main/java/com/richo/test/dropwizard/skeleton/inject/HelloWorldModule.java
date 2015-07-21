package com.richo.test.dropwizard.skeleton.inject;

import com.github.richodemus.guice_classpath_scanning.ClassPathScanningModule;
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
        install(new ClassPathScanningModule("com.richo.test.dropwizard.skeleton"));
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
