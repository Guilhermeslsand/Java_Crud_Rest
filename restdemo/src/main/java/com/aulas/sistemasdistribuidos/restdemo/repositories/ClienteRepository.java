package com.aulas.sistemasdistribuidos.restdemo.repositories;

import com.aulas.sistemasdistribuidos.restdemo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
