package com.genciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.Obra;
import com.genciv.repository.ObraRepository;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public void salvarObra(Obra obra) {
        obraRepository.save(obra);
    }

    public Obra findById(Long id) {
        return obraRepository.findById(id).orElse(null);
    }

   
}
