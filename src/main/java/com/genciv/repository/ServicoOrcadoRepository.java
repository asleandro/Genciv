package com.genciv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genciv.model.Orcamento;
import com.genciv.model.ServicoOrcado;

@Repository
public interface ServicoOrcadoRepository extends JpaRepository<ServicoOrcado, Long> {
	List<ServicoOrcado> findByOrcamento(Orcamento orcamento);
}
