package com.richo.test.dropwizard.skeleton.api;

import com.google.common.base.Optional;
import com.google.inject.name.Named;
import com.richo.test.dropwizard.skeleton.HelloWorldConfiguration;
import com.richo.test.dropwizard.skeleton.model.Saying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;


public class HelloWorldResource implements HelloWorldApi
{
	private static final AtomicLong initCounter = new AtomicLong();
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	@Inject
	public HelloWorldResource(HelloWorldConfiguration conf)
	{
		this(conf.getTemplate(), conf.getDefaultName());
	}

	//@Inject
	public HelloWorldResource(@Named("template") String template, @Named("defaultName") String defaultName)
	{
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
		logger.warn("HelloWorldResource number {} created", initCounter.incrementAndGet());
	}

	@Override
	public Saying sayHello(Optional<String> name)
	{
		logger.info("{} is using sayHello Api", name.or("Unknown"));
		final String value = String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
