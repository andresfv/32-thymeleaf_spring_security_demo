package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface courseCode {
//Define el codigo por defecto
public String value() default "LUV";

//Define el mensaje de error
public String message() default "must start woth LUV";

//Define el grupo por defecto
public Class<?>[]groups() default{};
	
//define el payload por defecto
public Class<? extends Payload>[] payload() default{};
}
