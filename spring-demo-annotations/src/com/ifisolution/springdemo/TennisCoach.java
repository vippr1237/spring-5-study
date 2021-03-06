package com.ifisolution.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public TennisCoach() {
		System.out.println("inside default constructor");
	}

//	@Autowired
//	public void methodCuaHa(FortuneServic e fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("hello inside do my start up");
	}

	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("hello insinde my clean up");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
