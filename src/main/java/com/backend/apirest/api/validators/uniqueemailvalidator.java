package com.backend.apirest.api.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.apirest.api.model.dao.IclienteDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class uniqueemailvalidator implements ConstraintValidator<uniqueemail, String> {

    @Autowired 
    IclienteDao IclienteDao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(request.getMethod().equals("PUT")){
            String[] url = request.getRequestURL().toString().split("/");
            Long id = Long.parseLong(url[url.length-1]);
            
            return !IclienteDao.existsByEmailAndIdNot(email,id);
        }

        return !IclienteDao.existsByEmail(email);
    }
}
