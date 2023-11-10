package com.genciv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.Orcamento;
import com.genciv.model.ServicoOrcado;
import com.genciv.repository.ServicoOrcadoRepository;

@Service
public class ServicoOrcadoService {

	private ServicoOrcadoRepository servicoOrcadoRepository;

	@Autowired
	public ServicoOrcadoService(ServicoOrcadoRepository servicoOrcadoRepository) {
		this.servicoOrcadoRepository = servicoOrcadoRepository;
	}
	
	public ServicoOrcado salvar(ServicoOrcado servicoOrcado) {
		return servicoOrcadoRepository.save(servicoOrcado);
	}
	
	public List<ServicoOrcado> buscarPorServico(Orcamento orcamento) {
		return servicoOrcadoRepository.findByOrcamento(orcamento);
	}
	
	public void excluir(Long id) {
		servicoOrcadoRepository.deleteById(id);
	}

}
