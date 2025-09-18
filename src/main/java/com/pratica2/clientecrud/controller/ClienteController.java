package com.pratica2.clientecrud.controller;

import com.pratica2.clientecrud.model.Cliente;
import com.pratica2.clientecrud.usecase.ClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    // Listar todos os clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteUseCase.listarClientes();
    }

    // Buscar cliente pelo CPF
    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
        Cliente cliente = clienteUseCase.getClienteByCpf(cpf).orElse(null);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    // Criar um novo cliente
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteUseCase.criarCliente(cliente);
    }

    // Atualizar cliente pelo CPF-
    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String cpf, @RequestBody Cliente cliente) {
        Cliente atualizado = clienteUseCase.atualizarCliente(cpf, cliente);

        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar cliente pelo CPF
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf) {
        boolean apagou = clienteUseCase.deletarCliente(cpf);

        if (apagou) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}