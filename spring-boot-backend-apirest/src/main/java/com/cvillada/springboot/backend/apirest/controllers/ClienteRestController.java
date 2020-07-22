package com.cvillada.springboot.backend.apirest.controllers;

import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import com.cvillada.springboot.backend.apirest.models.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClientesService clientesService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clientesService.findAll();
    }
}
