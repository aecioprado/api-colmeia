package com.colmeia.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.colmeia.api.entidades.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.cpfOuCnpj =:cpf")
	Cliente findByCpf(@Param("cpf") String cpf);
	
	@Query("select c from Cliente c where c.cpfOuCnpj = :cnpj")
	Cliente findByCnpj(@Param("cnpj") String cnpj);
	
	

}
