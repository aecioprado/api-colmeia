package com.colmeia.api.v1.servico;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.api.entidades.Conta;
import com.colmeia.api.repositorios.IContaRepositorio;
import com.colmeia.api.v1.dto.ContaDTO;

@Service
public class ContaServico implements IContaServico{
	
	@Autowired
	private IContaRepositorio contaRepositorio;
	
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<Conta> listarTudo() {
		return this.contaRepositorio.findAll();
	}

	@Override
	public List<Conta> listarContasPorClienteId(Long id) {
		try {
			return this.contaRepositorio.listarContasPorClienteId(id);
		} catch (Exception e) {
			throw new RuntimeException("Não existem contas cadastradas para esse cliente ou cliente não existe.");
		}
	}

	@Override
	public Conta pesquisarContaPorId(Long id) {
		try {
			return this.contaRepositorio.findById(id).get();
			} catch (Exception e ) {
				throw new RuntimeException("Conta não cadastrada.");
			}
	}

	@Override
	public Boolean salvar(ContaDTO contaDTO) {
		try {
			if(contaDTO.getId() != null) { 
				throw new RuntimeException("Um Id não pode ser informado na operação de cadastro");
			}
			
			Conta conta = mapper.map(contaDTO, Conta.class);
			
			
			this.contaRepositorio.save(conta);
			
			return Boolean.TRUE;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean atualizar(ContaDTO contaDTO) {
		try {
			this.pesquisarContaPorId(contaDTO.getId());
			Conta contaAtualizada = this.mapper.map(contaDTO,Conta.class);

			this.contaRepositorio.save(contaAtualizada);

			return Boolean.TRUE;

		} catch (Exception e ) {
			throw new RuntimeException("Não foi possível atualizar este recurso");
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.pesquisarContaPorId(id);
			this.contaRepositorio.deleteById(id);

			return Boolean.TRUE;

		} catch (Exception e ) {
			throw new RuntimeException("Não foi possível excluir este recurso");
		}
	}

	

}
