package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
//Define bean para SadFortune
	@Bean
	public FortuneService sadFotuneService() {
		return new SadFortuneService();

	}

	// Define bean para el swimCoach y injecta la dependencia
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFotuneService());
	}

}
