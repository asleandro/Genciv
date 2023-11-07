package com.genciv.servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}

