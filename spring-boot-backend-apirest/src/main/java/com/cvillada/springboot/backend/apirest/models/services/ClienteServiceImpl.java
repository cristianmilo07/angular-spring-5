package com.cvillada.springboot.backend.apirest.models.services;

import com.cvillada.springboot.backend.apirest.models.dao.IClientesDao;
import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClientesService{

    @Autowired
    private IClientesDao clientesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clientesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clientesDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clientesDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientesDao.deleteById(id);
    }
}
