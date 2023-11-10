package com.genciv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.genciv.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

}
