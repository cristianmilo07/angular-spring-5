package com.cvillada.springboot.backend.apirest.models.services;

import com.cvillada.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClientesService {
    public List<Cliente> findAll();
}
