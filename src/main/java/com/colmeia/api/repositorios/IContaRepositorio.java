package com.colmeia.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colmeia.api.entidades.Conta;

public interface IContaRepositorio extends JpaRepository<Conta, Long>{

}
