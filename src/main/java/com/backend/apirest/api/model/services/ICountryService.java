package com.backend.apirest.api.model.services;

import java.util.List;

import com.backend.apirest.api.model.entity.Country;

public interface ICountryService {
    public List<Country> findall();

    public Country findById(Long id);
}
