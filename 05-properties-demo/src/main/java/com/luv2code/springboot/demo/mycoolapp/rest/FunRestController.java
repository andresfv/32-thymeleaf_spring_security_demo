package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
//	Injecta propiedades  personalizadas desde archivo application.properties
	@Value("${entrenador.nombre}")
	private String entrenadorNombre;
	
	@Value("${equipo.nombre}")
	private String equipoNombre;

//	Utiliza las propiedades personalizadas
	@GetMapping("teaminfo")
	public String getTeamInfo() {
		return "Entrenador: "+ entrenadorNombre + ", Equipo: "+equipoNombre;
	}

	/**
	 * Retorna HelloWorld
	 */
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
		
	}
	
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
	
	
}
