package com.toindph26899.restfulapicrud.validation;

import com.toindph26899.restfulapicrud.validation.constraint.AgeValidationConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AgeValidationConstraint.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValidation {

    String message() default "Age must be an integer and age between 18 to 50";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
