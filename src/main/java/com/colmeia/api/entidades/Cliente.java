package com.colmeia.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.colmeia.api.entidades.enums.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//DATA DE CRIACAO
	@Column(name = "data_criacao", updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull
	private LocalDate dataCriacao = LocalDate.now();
	
	//NOME
	@Column(name = "nome")
	@NotBlank(message = "O campo nome é obrigatório.")
	private String nome;
	
	//TIPO DO CLIENTE
	@Column(name = "tipo_cliente", updatable = false)
    @Enumerated(EnumType.STRING)
	@NotBlank(message = "O campo tipo de cliente é obrigatório.")
	private TipoCliente tipoCliente;
	
	//CPF OU CNPJ
	@Column(name = "cpf_cnpj")
	@NotBlank(message = "O campo cpf/cnpj é obrigatório.")
	@Size(min = 11, max = 14)
	private String cpfOuCnpj;
		
	//ENDERECO
	@Embedded
	private Endereco endereco;
	
	//CONTAS
	@OneToMany(mappedBy="cliente")
	private Set<Conta> contas;
	
	//TELEFONE
	@Column(name = "telefone")
	@NotBlank(message = "O campo telefone é obrigatório.")
	private String telefone;
	
	@Column(name = "saldo_inicial", updatable = false)
	@NotBlank(message = "O campo saldo inicial é obrigatório.")
	private BigDecimal saldoInicial;
	
	// Métodos auxiliares
	
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
		return cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)");
		
	}
	
	public boolean isCampoCnpjValido() {
		String cnpj = this.cpfOuCnpj;
		return cnpj.matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
	}
	
}
