package com.inventorsoft.todo.list.common.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class EventTimeValidator implements ConstraintValidator<ValidEventTime, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return value.isAfter(LocalDateTime.now());
    }

}
