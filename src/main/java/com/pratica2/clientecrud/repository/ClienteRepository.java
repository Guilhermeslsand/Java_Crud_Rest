package com.pratica2.clientecrud.repository;

import com.pratica2.clientecrud.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll(){
        return clientes;
    }

    public Optional<Cliente> findByCpf(String cpf){
        return clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst();
    }

    public Cliente save(Cliente cliente) {
        Optional<Cliente> existente = findByCpf(cliente.getCpf());

        if (existente.isPresent()) {
            Cliente c = existente.get();
            c.setNome(cliente.getNome());
            c.setEmail(cliente.getEmail());
        } else {
            clientes.add(cliente);
        }

        return cliente;
    }

    public void deleteByCpf(String cpf){
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }

}
