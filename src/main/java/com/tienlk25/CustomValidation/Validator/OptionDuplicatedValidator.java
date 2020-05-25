package com.tienlk25.CustomValidation.Validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tienlk25.CustomValidation.annotation.OptionDuplicated;
import com.tienlk25.model.request.OptionModelRequest;

public class OptionDuplicatedValidator implements ConstraintValidator<OptionDuplicated, List<OptionModelRequest>>{

	

	@Override
	public boolean isValid(List<OptionModelRequest> optionModel, ConstraintValidatorContext context) {
		if(optionModel == null) {
			return true;
		}
		for(int i = 0;i < optionModel.size() - 1;i++) {
			for (int j = i + 1;j < optionModel.size();j++) {
				if(optionModel.get(i).getName().compareTo(optionModel.get(j).getName()) == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
