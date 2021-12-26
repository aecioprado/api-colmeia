package com.colmeia.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colmeia.api.entidades.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long>{

}
