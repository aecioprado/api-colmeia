package com.colmeia.api.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cep", nullable = true)
	private String cep;
	
	@Column(name = "uf", nullable = true)
	private String uf;
	
	@Column(name = "cidade", nullable = true)
	private String cidade;
	
	@Column(name = "bairro", nullable = true)
	private String bairro;
	
	@Column(name = "endereco", nullable = true)
	private String endereco;
	
	@Column(name = "numero", nullable = true)
	private String numero;
	
}
