package com.colmeia.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.colmeia.api.entidades.Conta;

public interface IContaRepositorio extends JpaRepository<Conta, Long>{
	
	@Query(value="select * from conta c where c.cliente_id= :id", nativeQuery=true)
	public List<Conta> listarContasPorClienteId(Long id);
	

}
