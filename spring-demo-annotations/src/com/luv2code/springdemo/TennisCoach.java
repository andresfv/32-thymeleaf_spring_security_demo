package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
//Se puede usar un parametro tipo String en @Component para dar un id a la clase
//Si se deja sin parametro de id, spring automaticamente dara el nombre de la clase pero en minuscula.
public class TennisCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: dentro del constructor por defecto");
	}
	
	/*
	@Autowired//Autowired de tipo método
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: dentro del método inyectado con autowire");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	@Autowired//Autowired de tipo constructor
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your throw";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
