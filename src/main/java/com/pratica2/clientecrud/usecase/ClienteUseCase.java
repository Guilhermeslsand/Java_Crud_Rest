package com.pratica2.clientecrud.usecase;

import com.pratica2.clientecrud.model.Cliente;
import com.pratica2.clientecrud.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteUseCase {
    private final ClienteRepository repository;

    public ClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> getClienteByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Cliente criarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizarCliente(String cpf, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExiste = repository.findByCpf(cpf);
        if (clienteExiste.isPresent()){
            Cliente cliente = clienteExiste.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            return repository.save(cliente);
        } else {
            return null;
        }
    }

    public boolean deletarCliente(String cpf){
        if(repository.findByCpf(cpf).isPresent()) {
            repository.deleteByCpf(cpf);
            return true;
        }
        return false;
    }
    
}
