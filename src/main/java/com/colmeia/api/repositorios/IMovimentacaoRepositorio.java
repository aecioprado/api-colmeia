package com.colmeia.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colmeia.api.entidades.Movimentacao;

public interface IMovimentacaoRepositorio extends JpaRepository<Movimentacao, Long>{

}
