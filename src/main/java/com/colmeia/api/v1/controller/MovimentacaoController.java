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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.api.entidades.Movimentacao;
import com.colmeia.api.v1.dto.MovimentacaoDTO;
import com.colmeia.api.v1.servico.IMovimentacaoServico;

@RestController
@RequestMapping(value = "/v1/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private IMovimentacaoServico movimentacaoServico;
	
	
	@GetMapping("/listar-movimentacoes-por-conta/{id}")
	public ResponseEntity<List<Movimentacao>> listarMovimentacaoPorContaId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.movimentacaoServico.listarMovimentacaoPorContaId(id));
	}
	
	@GetMapping("listar-movimentacao-por-id/{id}")
	public ResponseEntity<Movimentacao> pesquisarMovimentacaoPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.movimentacaoServico.pesquisarMovimentacaoPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> salvar(@Valid @RequestBody MovimentacaoDTO movimentacaoDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.movimentacaoServico.salvar(movimentacaoDTO));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirMovimentacaoFormaLogica(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.movimentacaoServico.excluirMovimentacaoFormaLogica(id));
	}

}
