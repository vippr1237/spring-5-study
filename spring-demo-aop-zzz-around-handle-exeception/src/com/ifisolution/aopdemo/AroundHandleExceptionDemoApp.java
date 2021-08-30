package com.ifisolution.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ifisolution.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Program: AroundDemoApp");

		logger.info("Calling Fortune");

		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);

		logger.info("\nMy fortune is: " + data);

		logger.info("Finished");
		context.close();
	}

}
