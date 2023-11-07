package com.genciv.materialconsumido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.servico.Servico;

@Service
public class MaterialConsumidoService {

    private MaterialConsumidoRepository materialConsumidoRepository;

    @Autowired
    public MaterialConsumidoService(MaterialConsumidoRepository materialConsumidoRepository) {
        this.materialConsumidoRepository = materialConsumidoRepository;
    }

    public MaterialConsumido salvar(MaterialConsumido materialConsumido) {
        return materialConsumidoRepository.save(materialConsumido);
    }

    public List<MaterialConsumido> buscarPorServico(Servico servico) {
        return materialConsumidoRepository.findByServico(servico);
    }

    public void excluir(Long id) {
        materialConsumidoRepository.deleteById(id);
    }
}

