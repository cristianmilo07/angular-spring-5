package com.cvillada.springboot.backend.apirest.models.dao;

import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientesDao extends JpaRepository<Cliente, Long> {
}
