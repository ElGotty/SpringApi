package com.backend.apirest.api.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apirest.api.model.entity.Country;

public interface ICountryDao extends JpaRepository<Country, Long> {
    List<Country> findAllByOrderByIdDesc();
}
