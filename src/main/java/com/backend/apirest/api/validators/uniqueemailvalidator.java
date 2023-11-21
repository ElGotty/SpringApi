package com.backend.apirest.api.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.apirest.api.model.dao.IclienteDao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class uniqueemailvalidator implements ConstraintValidator<uniqueemail, String> {

    @Autowired IclienteDao IclienteDao;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !IclienteDao.existsByEmail(email);
    }
}
