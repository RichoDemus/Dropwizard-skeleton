package com.richo.test.dropwizard.api;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.richo.test.dropwizard.model.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;


public class HelloWorldResource implements HelloWorldApi
{
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public HelloWorldResource(String template, String defaultName)
	{
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	@Override
	public Saying sayHello(Optional<String> name) {
		final String value = String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
