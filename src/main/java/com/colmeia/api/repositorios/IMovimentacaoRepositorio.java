package com.colmeia.api.repositorios;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.colmeia.api.entidades.Movimentacao;

public interface IMovimentacaoRepositorio extends JpaRepository<Movimentacao, Long> {

	@Query(value = "select * from movimentacao m where m.conta_id= :id", nativeQuery = true)
	public List<Movimentacao> listarMovimentacaoPorContaId(@Param("id") Long id);

	@Query(value = "select sum(m.valor) as receita_total from movimentacao m " + "where m.tipo_movimentacao = 'RECEITA'"
			+ " and m.cliente_id = :cliente and m.movimentacao_cancelada = false", nativeQuery = true)
	public BigDecimal somaMovimentacoesReceitas(@Param("cliente") Long cliente);

	@Query(value = "select sum(m.valor) as despesa_total from movimentacao m " + "where m.tipo_movimentacao = 'DESPESA'"
			+ " and m.cliente_id = :cliente and m.movimentacao_cancelada = false", nativeQuery = true)
	public BigDecimal somaMovimentacoesDespesas(@Param("cliente")Long cliente);

	@Query(value="select COUNT(*) from movimentacao m "+
	"where m.cliente_id = :cliente and m.movimentacao_cancelada = false", nativeQuery=true)
	public BigDecimal quantidadeTotalMovimentacoes(@Param("cliente")Long cliente);

	//public BigDecimal carregarSaldoInicial(Long cliente, Long conta);

}
