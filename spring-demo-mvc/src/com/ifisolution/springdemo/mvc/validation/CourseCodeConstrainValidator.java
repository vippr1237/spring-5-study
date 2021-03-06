package com.ifisolution.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode courseCode) {
		System.out.println(courseCode);
		coursePrefix = courseCode.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

		boolean result;

		if (code != null) {
			result = code.startsWith(coursePrefix);
		} else {
			return true;
		}
		return result;
	}

}
