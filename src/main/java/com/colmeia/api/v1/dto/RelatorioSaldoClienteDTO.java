package com.colmeia.api.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.colmeia.api.entidades.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioSaldoClienteDTO {
	
	private String nomeCliente;
	
	private LocalDate dataCadastro;
	
	private List<Endereco> endereco;
	
	private BigDecimal somaMovimentacoesCredito;
	
	private BigDecimal somaMovimentacoesDebito;
	
	private BigDecimal somaTotalMovimentacoes;
	
	private BigDecimal custoMovimentacoes;
	
	private BigDecimal saldoInicial;
	
	private BigDecimal saldoAtual;


}
