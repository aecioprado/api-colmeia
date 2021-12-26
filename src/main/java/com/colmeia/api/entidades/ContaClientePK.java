package com.colmeia.api.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ContaClientePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "conta_id")
    private Long contaId;
	
    @Column(name = "cliente_id")
    private Long clienteId;
	
	
}
