package com.backend.apirest.api.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apirest.api.model.entity.Cliente;

public interface IclienteDao extends JpaRepository<Cliente, Long> {
    
}
