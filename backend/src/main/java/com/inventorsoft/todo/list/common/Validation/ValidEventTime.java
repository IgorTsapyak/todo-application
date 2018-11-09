package com.inventorsoft.todo.list.common.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom Validation annotation responsible for validation of date and time and uses {@link EventTimeValidator}
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EventTimeValidator.class)
public @interface ValidEventTime {

    String message() default "The time of the event should be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
