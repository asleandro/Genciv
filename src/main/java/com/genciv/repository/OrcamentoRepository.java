package com.genciv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.genciv.model.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
	Page<Orcamento> findAllByAtivoTrue(Pageable paginacao);

}
