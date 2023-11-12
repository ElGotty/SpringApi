package com.backend.apirest.api.model.services;

import org.springframework.data.domain.Page;

import com.backend.apirest.api.model.entity.Cliente;

public interface IClienteService {

    public Page<Cliente> findAll(Integer pageNumber, Integer pageSize);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public Cliente findById(Long id);
    
}
