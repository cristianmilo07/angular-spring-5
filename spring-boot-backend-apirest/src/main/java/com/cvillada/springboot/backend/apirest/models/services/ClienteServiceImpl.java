package com.cvillada.springboot.backend.apirest.models.services;

import com.cvillada.springboot.backend.apirest.models.dao.IClientesDao;
import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClienteServiceImpl implements  IClientesService{

    @Autowired
    private IClientesDao clientesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clientesDao.findAll();
    }
}
