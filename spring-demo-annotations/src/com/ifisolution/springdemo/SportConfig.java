package com.ifisolution.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ifisolution.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		Coach myCoach = new SwimCoach(sadFortuneService());

		return myCoach;
	}
}
