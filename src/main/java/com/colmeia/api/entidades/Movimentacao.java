package com.colmeia.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.colmeia.api.entidades.enums.TipoMovimentacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private ContaClientePK clienteContaPk;

	// DATA
	@Column(name = "data")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull
	private LocalDate data;

	// TIPO DE MOVIMENTACAO
	@Column(name = "tipo_movimentacao")
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "O campo tipo de cliente é obrigatório.")
	private TipoMovimentacao tipoMovimentacao;

	// VALOR
	@Column(name = "valor")
	@NotBlank(message = "O campo saldo inicial é obrigatório.")
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal saldoInicial;

	// MOVIMENTACAO CANCELADA
	@Column(name = "movimentacao_cancelada")
	private Boolean movimentacaoCancelada = false;

}
