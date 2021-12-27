package com.colmeia.api.v1.servico;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.api.entidades.Cliente;
import com.colmeia.api.repositorios.IClienteRepositorio;
import com.colmeia.api.v1.dto.ClienteDTO;

@Service
public class ClienteServico implements IClienteServico {
	
	@Autowired
	private IClienteRepositorio clienteRepositorio;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Cliente> listarTudo() {
		return this.clienteRepositorio.findAll();
	}

	@Override
	public Cliente pesquisarPorId(Long id) {
		try {
		return this.clienteRepositorio.findById(id).get();
		} catch (Exception e ) {
			throw new RuntimeException("Cliente não cadastrado.");
		}
	}

	@Override
	public Boolean salvar(ClienteDTO clienteDTO) {
		try {
			if(clienteDTO.getId() != null) { 
				throw new RuntimeException("Um Id não pode ser informado na operação de cadastro");
			}
			
			Cliente clientePesquisadoPorCnpj = this.clienteRepositorio.findByCnpj(clienteDTO.getCpfOuCnpj());
			if(clientePesquisadoPorCnpj != null) {
				throw new RuntimeException("Cnpj já cadastrado");
			}
			
			Cliente clientePesquisadoPorCpf = this.clienteRepositorio.findByCnpj(clienteDTO.getCpfOuCnpj());
			if(clientePesquisadoPorCpf != null) {
				throw new RuntimeException("Cpf já cadastrado");
			}
			
			Cliente cliente = mapper.map(clienteDTO, Cliente.class);
			
			
			this.clienteRepositorio.save(cliente);
			
			return Boolean.TRUE;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean atualizar(ClienteDTO clienteDTO) {
		try {
			this.pesquisarPorId(clienteDTO.getId());
			Cliente clienteAtualizado = this.mapper.map(clienteDTO,Cliente.class);

			this.clienteRepositorio.save(clienteAtualizado);

			return Boolean.TRUE;

		} catch (Exception e ) {
			throw new RuntimeException("Não foi possível atualizar este recurso");
		}
		
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.pesquisarPorId(id);
			this.clienteRepositorio.deleteById(id);

			return Boolean.TRUE;

		} catch (Exception e ) {
			throw new RuntimeException("Não foi possível excluir este recurso");
		}
	}

	

	

}
