package com.backend.apirest.api.model.services;

import java.util.List;

import com.backend.apirest.api.model.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public Cliente findById(Long id);
    
}
