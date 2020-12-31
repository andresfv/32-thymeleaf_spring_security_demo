package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Lee el archivo de configuracion de spring usando una clase java
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Obtiene el bean desde el Spring Container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		//Llama al método del bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Llama el metodo dailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		//Cierra el context
		context.close();
		
	}

}
