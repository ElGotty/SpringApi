package com.backend.apirest.api.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.apirest.api.model.dao.ICountryDao;
import com.backend.apirest.api.model.entity.Country;

@Service
public class ICountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryDao iCountryDao;

    @Override
    @Transactional(readOnly = true)
    public List<Country> findall() {
        return iCountryDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Country findById(Long id) {
        return iCountryDao.findById(id).orElse(null);
    }
    
}
