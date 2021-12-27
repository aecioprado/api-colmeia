package com.colmeia.api.v1.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.colmeia.api.entidades.Endereco;
import com.colmeia.api.entidades.enums.TipoCliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private Long id;
	
	private LocalDate dataCriacao;
	
	@NotBlank(message = "O campo nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "O campo telefone é obrigatório.")
	private String telefone;
	
	@NotNull(message = "O campo tipo de cliente é obrigatório.")
	private TipoCliente tipoCliente;
	
	@NotBlank(message = "O campo cpf/cnpj é obrigatório.")
	@Size(min = 14, max = 18)
	private String cpfOuCnpj;
	
	private Endereco endereco;
	
	
	public boolean isPessoaFisica() {
		if(getTipoCliente() == TipoCliente.PF) {
			return true;
	} else
		return false;
	}
	
	public boolean isPessoaJuridica() {
		if(getTipoCliente() == TipoCliente.PJ) {
			return true;
	} else
		return false;
	}
	
	public boolean isCampoCpfValido( ) {
		String cpf = this.cpfOuCnpj;
		return cpf.matches("(^\\d{3}.\\d{3}.\\d{3}-\\d{2}$)");
		
	}
	
	public boolean isCampoCnpjValido() {
		String cnpj = this.cpfOuCnpj;
		return cnpj.matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
	}

}
