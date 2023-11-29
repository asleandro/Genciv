package com.genciv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genciv.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    
}

