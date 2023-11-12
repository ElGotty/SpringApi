package com.backend.apirest.api.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.apirest.api.model.dao.IclienteDao;
import com.backend.apirest.api.model.entity.Cliente;

@Service
public class IClienteServiceImpl implements IClienteService{

    @Autowired
    private IclienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Integer pageNumber, Integer pageSize) {
        
        return clienteDao.findAll(PageRequest.of(pageNumber, pageSize));

    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
    
}
