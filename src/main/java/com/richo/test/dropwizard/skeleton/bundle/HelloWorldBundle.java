package com.richo.test.dropwizard.skeleton.bundle;

import com.richo.test.dropwizard.skeleton.HelloWorldConfiguration;
import com.richo.test.dropwizard.skeleton.MyTestTask;
import com.richo.test.dropwizard.skeleton.TemplateHealthCheck;
import com.richo.test.dropwizard.skeleton.api.HelloWorldApi;
import com.richo.test.dropwizard.skeleton.api.HelloWorldResource;
import com.richo.test.dropwizard.skeleton.filter.MyFilter;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldBundle implements ConfiguredBundle<HelloWorldConfiguration>
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void initialize(Bootstrap<?> bootstrap)
    {
        logger.info("HeloWorldBundle.initialize called");
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception
    {
        enableWadl(environment);

        final HelloWorldApi resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.getApplicationContext().addFilter(MyFilter.class, "/*", EnumSet.allOf(DispatcherType.class));

        environment.admin().addTask(new MyTestTask());

        //environment.jersey().register(resource);
    }

    private void enableWadl(Environment environment)
    {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.server.wadl.disableWadl", "false");
        environment.jersey().getResourceConfig().addProperties(props);
    }
}
