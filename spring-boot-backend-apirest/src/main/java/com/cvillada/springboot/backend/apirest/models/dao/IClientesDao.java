package com.cvillada.springboot.backend.apirest.models.dao;

import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClientesDao extends CrudRepository<Cliente, Long> {
}
