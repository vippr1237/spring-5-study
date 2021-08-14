package com.ifisolution.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach() {

	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: insinde method doMyStartUpStuff");
	}

	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: inside method doMyCleanUpStuff");
	}

}
