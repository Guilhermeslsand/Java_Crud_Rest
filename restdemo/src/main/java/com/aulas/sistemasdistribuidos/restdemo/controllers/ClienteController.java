package com.aulas.sistemasdistribuidos.restdemo.controllers;

import com.aulas.sistemasdistribuidos.restdemo.domain.Cliente;
import com.aulas.sistemasdistribuidos.restdemo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping()
    public Cliente get(@RequestParam(name = "cpf") String cpf) {
        Cliente cliente = repository.findById(cpf).orElse(null);
        return cliente;
    }

    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        repository.save(cliente);
    }

    @PutMapping
    public void update(@RequestParam(name = "cpf") String cpf,
                       @RequestBody Cliente cliente) {
        cliente.setCpf(cpf);
        repository.save(cliente);
    }

    @DeleteMapping
    public void remove(@RequestParam(name = "cpf") String cpf) {
        repository.deleteById(cpf);
    }
}
