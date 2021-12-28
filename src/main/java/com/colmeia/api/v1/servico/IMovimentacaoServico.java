package com.colmeia.api.v1.servico;

import java.util.List;

import com.colmeia.api.entidades.Movimentacao;
import com.colmeia.api.v1.dto.MovimentacaoDTO;

public interface IMovimentacaoServico {
	
	
	public Boolean salvar(MovimentacaoDTO movimentacao);

	public Boolean excluirMovimentacaoFormaLogica(Long id);
	
	public Movimentacao pesquisarMovimentacaoPorId(Long id);

	public List<Movimentacao> listarMovimentacaoPorContaId(Long id);
	

}
