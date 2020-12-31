package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String language;
	
	private String [] operationSystem;

	private LinkedHashMap<String, String>countryOptions;
	private LinkedHashMap<String, String>languageOptions;
	private LinkedHashMap<String, String>operationSystemOptions;
	
	public Student() {
		//Llena la lista de paises
		countryOptions = new  LinkedHashMap<String, String>(); //Inicializar!!!
		countryOptions.put("CR", "Costa Rica");
		countryOptions.put("NC", "Nicaragua");
		countryOptions.put("PN", "Panamá");
		countryOptions.put("HN", "Honduras");
		countryOptions.put("MX", "Mexico");
		
		languageOptions = new  LinkedHashMap<String, String>();
		languageOptions.put("Java", "Java");
		languageOptions.put("C#", "C#");
		languageOptions.put("PHP", "PHP");
		languageOptions.put("Ruby", "Ruby");
		
		operationSystemOptions = new  LinkedHashMap<String, String>();
		operationSystemOptions.put("Linux", "Linux");
		operationSystemOptions.put("Windows", "Windows");
		operationSystemOptions.put("MAC OS", "MAC OS");
		operationSystemOptions.put("Android", "Android");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String[] operationSystem) {
		this.operationSystem = operationSystem;
	}

	public LinkedHashMap<String, String> getOperationSystemOptions() {
		return operationSystemOptions;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}
}
