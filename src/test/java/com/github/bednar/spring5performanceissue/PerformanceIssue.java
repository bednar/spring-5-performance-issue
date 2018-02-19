package com.github.bednar.spring5performanceissue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

/**
 * @author Jakub Bednar (16/02/2018 12:14)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/root-context.xml")
public class PerformanceIssue
{
	private static final Logger LOG = LoggerFactory.getLogger(PerformanceIssue.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void createAndAutowireBean()
	{
		createAndAutowireBean(1000);
		createAndAutowireBean(10000);
		createAndAutowireBean(100000);
	}

	private void createAndAutowireBean(final int count)
	{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 1; i <= count; i++)
		{
			Bean bean = new Bean();
			applicationContext.getAutowireCapableBeanFactory().autowireBean(bean);
		}

		stopWatch.stop();

		LOG.info("{} bean creations {} ms", count, stopWatch.getLastTaskTimeMillis());
	}
}