package com.backend.apirest.api.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apirest.api.model.entity.Cliente;

public interface IclienteDao extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByOrderByIdDesc(PageRequest pageRequest);

    boolean existsByEmail(String email);
}
