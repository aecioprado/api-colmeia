package com.colmeia.api.v1.servico;

import java.util.List;

import com.colmeia.api.entidades.Cliente;
import com.colmeia.api.v1.dto.ClienteDTO;

public interface IClienteServico {

	public List<Cliente> listarTudo();

	public Cliente pesquisarPorId(Long id);
	
	public Boolean salvar(ClienteDTO cliente);
	
	public Boolean atualizar(ClienteDTO cliente);

	public Boolean excluir(Long id);

}
