package com.tienlk25.CustomValidation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tienlk25.CustomValidation.Validator.WeightUnitValidator;

@Documented
@Constraint(validatedBy = WeightUnitValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WeightUnit {

	String message() default "Not found weight unit!";
	   
    Class<?>[] groups() default {};
   
    Class<? extends Payload>[] payload() default {};
}



