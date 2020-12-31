package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<courseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(courseCode theCourseCode) {
	 coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		if (theCode!=null) {
			boolean result = theCode.startsWith(coursePrefix);
			return result;
		}else {
			return true;
		}
	}

}
