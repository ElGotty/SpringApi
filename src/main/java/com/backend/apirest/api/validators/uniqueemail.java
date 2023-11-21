package com.backend.apirest.api.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = uniqueemailvalidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface uniqueemail {
    String message() default "es un correo electonico en uso";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}