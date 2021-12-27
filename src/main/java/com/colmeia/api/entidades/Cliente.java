package com.colmeia.api.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.colmeia.api.entidades.enums.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente implements Serializable{
	

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_criacao", updatable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataCriacao;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "tipo_cliente")
    @Enumerated(EnumType.STRING)
	
	private TipoCliente tipoCliente;
	
	@Column(name = "cpf_cnpj")
	
	private String cpfOuCnpj;
		
	@Embedded
	private Endereco endereco;
	
	
	@OneToMany(mappedBy = "cliente", cascade=CascadeType.PERSIST)
	private List<Conta> contas;
	
	
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
