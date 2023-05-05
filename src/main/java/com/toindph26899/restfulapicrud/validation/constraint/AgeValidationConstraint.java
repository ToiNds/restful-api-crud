package com.toindph26899.restfulapicrud.validation.constraint;

import com.toindph26899.restfulapicrud.validation.AgeValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidationConstraint implements ConstraintValidator<AgeValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {

            int age = Integer.parseInt(value);

            if (age >= 18 && age <= 50) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
