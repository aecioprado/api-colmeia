package com.colmeia.api.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.colmeia.api.entidades.Cliente;
import com.colmeia.api.entidades.Conta;
import com.colmeia.api.entidades.enums.TipoMovimentacao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovimentacaoDTO {
	
	private Long id;
	
	@NotBlank(message = "O campo conta é obrigatório.")
	private Conta conta;
	
	@NotBlank(message = "O campo cliente é obrigatório.")
	private Cliente cliente;

	@NotNull
	private LocalDate data;

	@NotBlank(message = "O campo tipo de movimentação é obrigatório.")
	private TipoMovimentacao tipoMovimentacao;

	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 9, fraction = 2)
	@NotBlank(message = "O campo valor é obrigatório")
	private BigDecimal valor;

	private Boolean movimentacaoCancelada = false;

}
