package com.github.bednar.spring5performanceissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Jakub Bednar (16/02/2018 12:04)
 */
@Service
public class Service3
{
	private static final Logger LOG = LoggerFactory.getLogger(Service3.class);

	public void doSomething3()
	{
		LOG.debug("Do something 3");
	}
}