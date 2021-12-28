package com.colmeia.api.v1.servico;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.api.entidades.Movimentacao;
import com.colmeia.api.repositorios.IMovimentacaoRepositorio;
import com.colmeia.api.v1.dto.MovimentacaoDTO;

@Service
public class MovimentacaoServico implements IMovimentacaoServico {

	@Autowired
	private IMovimentacaoRepositorio movimentacaoRepositorio;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean salvar(MovimentacaoDTO movimentacaoDTO) {
		try {
			if(movimentacaoDTO.getId() != null) { 
				throw new RuntimeException("Um Id não pode ser informado na operação de cadastro");
			}
			
			Movimentacao movimentacao = mapper.map(movimentacaoDTO, Movimentacao.class);
			
			
			this.movimentacaoRepositorio.save(movimentacao);
			
			return Boolean.TRUE;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean excluirMovimentacaoFormaLogica(Long id) {
		try {
			
			Movimentacao movimentacaoCarregada = this.movimentacaoRepositorio.findById(id).get();
			
			if(movimentacaoCarregada == null) { 
				throw new RuntimeException("Não foi possível encontrar esse recurso.");
			}
			
			Movimentacao movimentacaoAtualizada = movimentacaoCarregada;
			
			movimentacaoAtualizada.setMovimentacaoCancelada(true);

			this.movimentacaoRepositorio.save(movimentacaoAtualizada);

			return Boolean.TRUE;

		} catch (Exception e ) {
			throw new RuntimeException("Não foi possível excluir este recurso");
		}
	}

	@Override
	public List<Movimentacao> listarMovimentacaoPorContaId(Long id) {
		try {
			return this.movimentacaoRepositorio.listarMovimentacaoPorContaId(id);
		} catch (Exception e) {
			throw new RuntimeException("Não existem movimentações cadastradas para esse cliente ou cliente não existe.");
		}
	}

	@Override
	public Movimentacao pesquisarMovimentacaoPorId(Long id) {
		try {

			Movimentacao movimentacaoCarregada = this.movimentacaoRepositorio.findById(id).get();

			if (movimentacaoCarregada.getMovimentacaoCancelada() == true) {
				throw new RuntimeException("Essa movimentação foi excluida.");
			}
			return movimentacaoCarregada;

		} catch (Exception e) {
			throw new RuntimeException("Conta não cadastrada.");
		}
	}

}
