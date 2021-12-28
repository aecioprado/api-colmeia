package com.colmeia.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.api.entidades.Conta;
import com.colmeia.api.v1.dto.ContaDTO;
import com.colmeia.api.v1.servico.IContaServico;

@RestController
@RequestMapping(value = "/v1/contas")
public class ContaController {
	
	@Autowired
	private IContaServico contaServico;
	
	
	@GetMapping("/listar-todas")
	public ResponseEntity<List<Conta>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.contaServico.listarTudo());
	}
	
	@GetMapping("listar-contas-por-cliente/{id}")
	public ResponseEntity<List<Conta>> listarContarPorClienteId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contaServico.listarContasPorClienteId(id));
	}
	
	@GetMapping("listar-conta-por-id/{id}")
	public ResponseEntity<Conta> pesquisarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contaServico.pesquisarContaPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> salvar(@Valid @RequestBody ContaDTO contaDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.contaServico.salvar(contaDTO));
	}
	
	@PutMapping
	public ResponseEntity<Boolean> atualizar(@Valid @RequestBody ContaDTO contaDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contaServico.atualizar(contaDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluir(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contaServico.excluir(id));
	}

}
