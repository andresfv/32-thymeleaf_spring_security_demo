package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		Employee employee1 = new Employee(1,"Andrés", "Fallas", "andresfallas@gmail.com");
		Employee employee2 = new Employee(2,"Eva", "Valenciano", "evavalenciano@gmail.com");
		Employee employee3 = new Employee(3,"Ivannia", "Mendoza", "ivanniamendoza@gmail.com");
		
		theEmployees = new ArrayList<Employee>();
		
		theEmployees.add(employee1);
		theEmployees.add(employee2);
		theEmployees.add(employee3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		theModel.addAttribute("employees", theEmployees);
	return "list-employees";	
	}
}
