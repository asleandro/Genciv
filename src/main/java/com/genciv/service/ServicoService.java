package com.genciv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.MaterialConsumido;
import com.genciv.model.Servico;
import com.genciv.repository.MaterialConsumidoRepository;
import com.genciv.repository.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	//@Autowired
	//MaterialConsumidoRepository materialConsumidoRepository;
	
	@Autowired
	MaterialConsumidoService materialConsumidoService;

	public Servico salvar(Servico servico) {
		return servicoRepository.save(servico);
	}

	public List<Servico> listarTodos() {
		return servicoRepository.findAll();
	}

	public Servico findById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void excluir(Long id) {
		Servico novoServico = servicoRepository.getReferenceById(id);
		List<MaterialConsumido> materiaisConsumidos = novoServico.getMateriaisConsumidos();
		for (MaterialConsumido materialConsumido : materiaisConsumidos) {
			materialConsumidoService.excluir(materialConsumido.getId());
		}
		servicoRepository.deleteById(id);
	}

	public Servico criarServicoComMateriais(Servico servico, List<MaterialConsumido> materiaisConsumidos) {
		Servico novoServico = servicoRepository.save(servico);

		for (MaterialConsumido materialConsumido : materiaisConsumidos) {
			materialConsumido.setServico(novoServico);
			novoServico.getMateriaisConsumidos().add(materialConsumido);
			// testar se funciona igual trocando de repository para service o "salvar"
			materialConsumidoService.salvar(materialConsumido);
		}
		novoServico = servicoRepository.save(novoServico);
		// novoServico = servicoRepository.findById(novoServico.getId()).orElse(null);

		return novoServico;
	}

}
