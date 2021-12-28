package com.colmeia.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.colmeia.api.entidades.Movimentacao;

public interface IMovimentacaoRepositorio extends JpaRepository<Movimentacao, Long>{

	@Query(value="select * from movimentacao m where m.conta_id= :id", nativeQuery=true)
	public List<Movimentacao> listarMovimentacaoPorContaId(Long id);
}
