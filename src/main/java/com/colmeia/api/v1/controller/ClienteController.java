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

import com.colmeia.api.entidades.Cliente;
import com.colmeia.api.v1.dto.ClienteDTO;
import com.colmeia.api.v1.servico.IClienteServico;

@RestController
@RequestMapping(value = "/v1/clientes")
public class ClienteController {
		
		@Autowired
		private IClienteServico clienteServico;
		
		
		@GetMapping
		public ResponseEntity<List<Cliente>> listar() {
			return ResponseEntity.status(HttpStatus.OK).body(this.clienteServico.listarTudo());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> pesquisarPorId(@PathVariable Long id) {
			return ResponseEntity.status(HttpStatus.OK).body(this.clienteServico.pesquisarPorId(id));
		}
		
		@PostMapping
		public ResponseEntity<Boolean> salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteServico.salvar(clienteDTO));
		}
		
		@PutMapping
		public ResponseEntity<Boolean> atualizar(@Valid @RequestBody ClienteDTO clienteDTO) {
			return ResponseEntity.status(HttpStatus.OK).body(this.clienteServico.atualizar(clienteDTO));
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Boolean> excluir(@PathVariable Long id) {
			return ResponseEntity.status(HttpStatus.OK).body(this.clienteServico.excluir(id));
		}

}
