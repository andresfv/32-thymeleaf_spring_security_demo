package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.courseCode;

public class Customer {

	@NotNull(message= "campo requerido")
	@Size(min = 1, message= "campo requerido")
	private String firstName;
	
	@NotNull(message= "campo requerido")
	@Size(min = 1, message= "campo requerido")
	private String lastName;
	
	@Min(value = 0, message = "Debe ser mayor o igual a 0")
	@Max(value = 10, message = "Debe ser menor o igual a 10")
	@NotNull(message= "campo requerido")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Solo se aceptan 5 caracteres o digitos")
	private String postalCode;
	
	@courseCode(value="CP-", message = "El código ebe comenzar con CP-")
	private String courseCode;
	
	public Customer() {
		
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
