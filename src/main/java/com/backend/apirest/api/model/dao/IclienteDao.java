package com.backend.apirest.api.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.apirest.api.model.entity.Cliente;

public interface IclienteDao extends CrudRepository<Cliente, Long> {
    
}
