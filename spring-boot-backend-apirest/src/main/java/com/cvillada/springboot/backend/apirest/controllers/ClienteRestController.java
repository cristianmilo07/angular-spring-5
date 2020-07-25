package com.cvillada.springboot.backend.apirest.controllers;

import com.cvillada.springboot.backend.apirest.models.entity.Cliente;
import com.cvillada.springboot.backend.apirest.models.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClientesService clientesService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clientesService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){
        return clientesService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clientesService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = clientesService.findById(id);

        clienteActual.setApellido(clienteActual.getApellido());
        clienteActual.setNombre(clienteActual.getNombre());
        clienteActual.setEmail(clienteActual.getEmail());

        return clientesService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id ) {
        clientesService.delete(id);
    }

}
