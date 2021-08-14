package com.ifisolution.springdemo;

public class BasketballCoach implements Coach {
	private FortuneService fortuneService;

	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on dribbling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
