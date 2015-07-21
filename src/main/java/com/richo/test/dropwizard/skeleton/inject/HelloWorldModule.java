package com.richo.test.dropwizard.skeleton.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.richo.test.dropwizard.skeleton.HelloWorldConfiguration;

import javax.inject.Inject;

public class HelloWorldModule extends AbstractModule
{

    @Override
    protected void configure()
    {

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
