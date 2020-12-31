package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// Se necesita un metodo controlador para mostrar la pantalla inicial
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	// Se necesita un metodo controlador para procesar el form html
	@RequestMapping("/processForm")
	public String processForm() {
		return "Hello-World";
	}
	
	//Método para leer y añadir datos del modelo
	//Lee el parametro con el nombre "studentName"
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		//Convierte datos a todas las capas
		theName = theName.toUpperCase();
		
		//Crea un mensaje
		String result = "Welcome " +  theName + "!!!";
		
		//añade un mensaje al modelo
		model.addAttribute("message", result);
		return "Hello-World";
	}
	
	
	
}
