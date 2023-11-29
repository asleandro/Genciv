package com.genciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.ServicoExecutado;
import com.genciv.repository.ServicoExecutadoRepository;

@Service
public class ServicoExecutadoService {

    @Autowired
    private ServicoExecutadoRepository servicoExecutadoRepository;

    public void salvarServicoExecutado(ServicoExecutado servicoExecutado) {
        servicoExecutadoRepository.save(servicoExecutado);
    }

}
