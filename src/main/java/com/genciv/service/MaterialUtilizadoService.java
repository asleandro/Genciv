package com.genciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.MaterialUtilizado;
import com.genciv.repository.MaterialUtilizadoRepository;

@Service
public class MaterialUtilizadoService {

    @Autowired
    private MaterialUtilizadoRepository materialUtilizadoRepository;

    public void salvarMaterialUtilizado(MaterialUtilizado materialUtilizado) {
        materialUtilizadoRepository.save(materialUtilizado);
    }

}

