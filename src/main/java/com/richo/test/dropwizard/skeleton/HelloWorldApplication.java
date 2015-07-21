package com.richo.test.dropwizard.skeleton;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.richo.test.dropwizard.skeleton.api.HelloWorldApi;
import com.richo.test.dropwizard.skeleton.api.HelloWorldResource;
import com.richo.test.dropwizard.skeleton.filter.MyFilter;
import com.richo.test.dropwizard.skeleton.inject.HelloWorldModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public class HelloWorldApplication extends Application<HelloWorldConfiguration>
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) throws Exception
	{
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName()
	{
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap)
	{
		bootstrap.addBundle(getGuiceBundle(bootstrap));
		AssetsBundle assetsBundle = new AssetsBundle("/assets/", "/", "index.html", "static");
		bootstrap.addBundle(assetsBundle);
	}

	private GuiceBundle getGuiceBundle(Bootstrap<?> bootstrap) {
		return GuiceBundle.<HelloWorldConfiguration>newBuilder().addModule(new HelloWorldModule())
				.setConfigClass(HelloWorldConfiguration.class)
				.enableAutoConfig("com.richo.test.dropwizard.skeleton")
				.build(Stage.DEVELOPMENT);
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
	                Environment environment)
	{

	}
}