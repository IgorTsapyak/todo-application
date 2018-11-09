package com.inventorsoft.todo.list.common.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidEventTimeValidator.class)
public @interface ValidEventTime {

    String message() default "The time of the event should be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
