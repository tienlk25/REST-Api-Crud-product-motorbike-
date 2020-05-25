package com.tienlk25.CustomValidation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tienlk25.CustomValidation.annotation.MotorbikeType;

public class MotorbikeTypeValidator implements ConstraintValidator<MotorbikeType, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null) return false;
		if(value.compareToIgnoreCase("XE GA") == 0 || value.compareToIgnoreCase("XE THỂ THAO") == 0 || value.compareToIgnoreCase("XE TAY CÔN") == 0 || value.compareToIgnoreCase("XE SỐ") == 0) { return true;}
		return false;
	}

}
