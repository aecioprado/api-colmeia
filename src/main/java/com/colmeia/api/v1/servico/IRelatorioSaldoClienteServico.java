package com.colmeia.api.v1.servico;

import java.math.BigDecimal;

import com.colmeia.api.v1.dto.RelatorioSaldoClienteDTO;


public interface IRelatorioSaldoClienteServico {
	
	public BigDecimal somaMovimentacoesReceitas(Long cliente);
	
	public BigDecimal somaMovimentacoesDespesas(Long cliente);
	
	public BigDecimal quantidadeTotalMovimentacoes(Long cliente);
	
	public RelatorioSaldoClienteDTO relatorioSaldoCliente(Long cliente);
	
}
