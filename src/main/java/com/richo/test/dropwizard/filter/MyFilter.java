package com.richo.test.dropwizard.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;


public class MyFilter implements Filter
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void init(FilterConfig filterConfig)
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		logger.info("Path: {}", request.getServletContext().getContextPath());
		chain.doFilter(request, response);
	}

	public void destroy()
	{
	}
}
