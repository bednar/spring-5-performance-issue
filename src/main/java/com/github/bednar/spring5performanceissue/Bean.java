package com.github.bednar.spring5performanceissue;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jakub Bednar (16/02/2018 12:06)
 */
public class Bean
{
	@Autowired
	private Service1 service1;

	@Autowired
	private Service2 service2;

	@Autowired
	private Service3 service3;

	@Autowired
	private Service4 service4;

	@Autowired
	private Service5 service5;

	public void doSomething()
	{
		service1.doSomething1();
		service2.doSomething2();
		service3.doSomething3();
		service4.doSomething4();
		service5.doSomething5();
	}
}