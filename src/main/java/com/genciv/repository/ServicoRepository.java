package com.genciv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genciv.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}

