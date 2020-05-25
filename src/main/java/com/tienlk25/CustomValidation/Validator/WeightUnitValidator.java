package com.tienlk25.CustomValidation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tienlk25.CustomValidation.annotation.WeightUnit;

public class WeightUnitValidator implements ConstraintValidator<WeightUnit, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null) return false;
		if(value.compareToIgnoreCase("kg") == 0) { return true;}
		return false;
	}
}
