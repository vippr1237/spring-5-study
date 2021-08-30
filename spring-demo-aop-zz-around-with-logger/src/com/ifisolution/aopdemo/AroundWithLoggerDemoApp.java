package com.ifisolution.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ifisolution.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Program: AroundDemoApp");

		logger.info("Calling Fortune");

		String data = fortuneService.getFortune();

		logger.info("\nMy fortune is: " + data);

		logger.info("Finished");
		context.close();
	}

}
