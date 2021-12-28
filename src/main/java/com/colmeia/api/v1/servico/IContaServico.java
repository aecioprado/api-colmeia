package com.colmeia.api.v1.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colmeia.api.entidades.Conta;
import com.colmeia.api.v1.dto.ContaDTO;

@Service
public interface IContaServico {
	
	public List<Conta> listarTudo();
	
	public List<Conta> listarContasPorClienteId(Long id);

	public Conta pesquisarContaPorId(Long id);
		
	public Boolean salvar(ContaDTO conta);
	
	public Boolean atualizar(ContaDTO conta);

	public Boolean excluir(Long id);

}
