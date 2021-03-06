package com.ifisolution.springdemo;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("im here");
	}

	@Override
	public String getDailyWorkout() {
		return "1000 Swing";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("im in setter");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("im in setter");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("im in setter");
		this.fortuneService = fortuneService;
	}

}
