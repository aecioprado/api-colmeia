package com.colmeia.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.colmeia.api.entidades.enums.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="conta_id")
	private Conta conta;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;

	@Column(name = "data", updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;

	@Column(name = "tipo_movimentacao", updatable = false)
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	@Column(name = "valor", updatable = false)
	private BigDecimal valor;

	@Column(name = "movimentacao_cancelada", updatable = true)
	private Boolean movimentacaoCancelada = false;

}
