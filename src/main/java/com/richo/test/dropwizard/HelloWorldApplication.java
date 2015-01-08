package com.richo.test.dropwizard;

import com.richo.test.dropwizard.api.HelloWorldApi;
import com.richo.test.dropwizard.api.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class HelloWorldApplication extends Application<HelloWorldConfiguration>
{
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
		AssetsBundle assetsBundle = new AssetsBundle("/assets/", "/", "index.html", "static");
		bootstrap.addBundle(assetsBundle);
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
	                Environment environment)
	{
		final HelloWorldApi resource = new HelloWorldResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
		);

		final TemplateHealthCheck healthCheck =
				new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);

		environment.admin().addTask(new MyTestTask());

		environment.jersey().register(resource);
		environment.jersey().setUrlPattern("/api/*");
	}

}