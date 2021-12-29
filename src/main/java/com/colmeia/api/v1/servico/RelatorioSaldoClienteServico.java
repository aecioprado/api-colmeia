package com.colmeia.api.v1.servico;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.api.entidades.Cliente;
import com.colmeia.api.entidades.Conta;
import com.colmeia.api.repositorios.IClienteRepositorio;
import com.colmeia.api.repositorios.IContaRepositorio;
import com.colmeia.api.repositorios.IMovimentacaoRepositorio;
import com.colmeia.api.v1.dto.RelatorioSaldoClienteDTO;

@Service
public class RelatorioSaldoClienteServico implements IRelatorioSaldoClienteServico {

	@Autowired
	private IMovimentacaoRepositorio movimentacaoRepositorio;

	@Autowired
	private IContaRepositorio contaRepositorio;

	@Autowired
	private IClienteRepositorio clienteRepositorio;

	@Override
	public BigDecimal somaMovimentacoesReceitas(Long cliente) {
		return this.movimentacaoRepositorio.somaMovimentacoesReceitas(cliente);
	}

	@Override
	public BigDecimal somaMovimentacoesDespesas(Long cliente) {
		return this.movimentacaoRepositorio.somaMovimentacoesDespesas(cliente);
	}

	@Override
	public BigDecimal quantidadeTotalMovimentacoes(Long cliente) {
		return this.movimentacaoRepositorio.quantidadeTotalMovimentacoes(cliente);
	}

	@Override
	public RelatorioSaldoClienteDTO relatorioSaldoCliente(Long cliente) {

		Cliente clienteCarregado = this.clienteRepositorio.getById(cliente);

		//MONTAGEM DO RELATÓRIO
		RelatorioSaldoClienteDTO relatorio = new RelatorioSaldoClienteDTO();
		
		relatorio.setNomeCliente(clienteCarregado.getNome());
		relatorio.setDataCadastro(clienteCarregado.getDataCriacao());
		// relatorio.setEndereco(clienteCarregado.getEndereco());
		relatorio.setSomaMovimentacoesCredito(this.somaMovimentacoesReceitas(cliente));
		relatorio.setSomaMovimentacoesDebito(this.somaMovimentacoesDespesas(cliente));
		relatorio.setSomaTotalMovimentacoes(this.quantidadeTotalMovimentacoes(cliente));

		BigDecimal taxa = new BigDecimal("0.75");
		BigDecimal custoMovimentacoes = taxa.multiply(relatorio.getSomaTotalMovimentacoes());
		relatorio.setCustoMovimentacoes(custoMovimentacoes);
		
		//todo: considerando conta_id: 1 * provisorio *
		Conta contaCarregada = this.contaRepositorio.getById(1L);
		relatorio.setSaldoInicial(contaCarregada.getSaldoInicial());
		

		return relatorio;
	}

}
