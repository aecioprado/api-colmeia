package com.colmeia.api.v1.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.colmeia.api.entidades.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {
	
	private Long id;
	
	@NotNull(message = "É obrigatório informar o id do cliente")
	private Cliente cliente;
	
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=9, fraction=2)
	private BigDecimal saldoInicial;
	
	@NotBlank(message = "È obrigatório informar uma descrição para a conta")
	private String descricao;

}
