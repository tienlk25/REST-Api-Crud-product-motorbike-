package com.tienlk25.CustomValidation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tienlk25.CustomValidation.annotation.IsExsistName;
import com.tienlk25.repositories.ProductRepoitory;

public class IsExsistNameValidator implements ConstraintValidator<IsExsistName, String>{

	@Autowired
	ProductRepoitory productRepoitory;
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		String v = productRepoitory.findNameByName(value, true);
		if(v != null) {
			return false;
		}
		
		return true;
	}

}
