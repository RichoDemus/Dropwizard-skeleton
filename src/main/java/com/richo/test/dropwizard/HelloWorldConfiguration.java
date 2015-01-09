package com.richo.test.dropwizard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration
{
	@NotEmpty
	final private String template;

	@NotEmpty
	final private String defaultName;

	@JsonCreator
	public HelloWorldConfiguration(@JsonProperty("template") String template, @JsonProperty("defaultName") String defaultName)
	{
		this.template = template;
		this.defaultName = defaultName;
	}

	@JsonProperty
	public String getTemplate()
	{
		return template;
	}

	@JsonProperty
	public String getDefaultName()
	{
		return defaultName;
	}
}
