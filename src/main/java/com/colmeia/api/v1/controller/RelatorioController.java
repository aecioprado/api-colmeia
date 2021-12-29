package com.colmeia.api.v1.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.api.v1.dto.RelatorioSaldoClienteDTO;
import com.colmeia.api.v1.servico.IRelatorioSaldoClienteServico;

@RestController
@RequestMapping(value = "/v1/relatorios")
public class RelatorioController {
	
	@Autowired
	private IRelatorioSaldoClienteServico relatorioSaldoClienteServico;
	
	
	@GetMapping("/receita-por-cliente/{id}")
	public ResponseEntity<BigDecimal> listarReceitaPorCliente(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.relatorioSaldoClienteServico.somaMovimentacoesReceitas(id));
	}
	
	@GetMapping("/despesa-por-cliente/{id}")
	public ResponseEntity<BigDecimal> listarDespesasPorCliente(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.relatorioSaldoClienteServico.somaMovimentacoesDespesas(id));
	}
	
	
	@GetMapping("/saldo-por-cliente-desde-inicio/{id}")
	public ResponseEntity<RelatorioSaldoClienteDTO> listarSaldoPorCliente(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.relatorioSaldoClienteServico.relatorioSaldoCliente(id));
	}

}
