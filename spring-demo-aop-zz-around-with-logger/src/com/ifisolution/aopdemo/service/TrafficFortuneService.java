package com.ifisolution.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {

		// stimulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return "Expect heavy traffic this morning";
	}
}
