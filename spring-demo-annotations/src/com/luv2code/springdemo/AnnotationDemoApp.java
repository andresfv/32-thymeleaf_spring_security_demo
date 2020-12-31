package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//Lee la configuración del archivo xml
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Obtiene el bean desde el Spring Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//Llama al método del bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Llama el metodo dailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		//Cierra el context
		context.close();
		
	}

}
