package com.genciv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.Orcamento;
import com.genciv.model.ServicoOrcado;
import com.genciv.repository.OrcamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class OrcamentoService {

	@Autowired
	private OrcamentoRepository orcamentoRepository;

	@Autowired
	private ServicoOrcadoService servicoOrcadoService;

	public Orcamento salvar(Orcamento orcamento) {
		return orcamentoRepository.save(orcamento);
	}

	public List<Orcamento> listarTodos() {
		return orcamentoRepository.findAll();
	}

	public Orcamento buscarPorId(Long id) {
		return orcamentoRepository.findById(id).orElse(null);
	}

	@Transactional
	public void excluir(Long id) {
		Orcamento orcamento = orcamentoRepository.getReferenceById(id);
		List<ServicoOrcado> servicosOrcados = orcamento.getServicosOrcados();
		for (ServicoOrcado servicoOrcado : servicosOrcados) {
			servicoOrcadoService.excluir(servicoOrcado.getId());
		}
		orcamentoRepository.deleteById(id);
	}

	/*
	 * public Orcamento criarOrcamentoComServicos(Orcamento orcamento,
	 * List<ServicoOrcado> servicosOrcados) { Orcamento novoOrcamento =
	 * orcamentoRepository.save(orcamento);
	 * 
	 * for (ServicoOrcado servicoOrcado : servicosOrcados) {
	 * servicoOrcado.setOrcamento(novoOrcamento);
	 * novoOrcamento.getServicosOrcados().add(servicoOrcado);
	 * servicoOrcadoService.salvar(servicoOrcado); } novoOrcamento =
	 * orcamentoRepository.save(novoOrcamento); return novoOrcamento; }
	 */
	public Orcamento criarOrcamentoComServicos(Orcamento orcamento, List<ServicoOrcado> servicosOrcados) {
		Orcamento novoOrcamento = orcamentoRepository.save(orcamento);

		List<ServicoOrcado> listaServicosOrcados = new ArrayList<>();

		for (ServicoOrcado servicoOrcado : servicosOrcados) {
			ServicoOrcado novoServicoOrcado = new ServicoOrcado();
			novoServicoOrcado.setOrcamento(novoOrcamento);
			novoServicoOrcado.setQuantidade(servicoOrcado.getQuantidade());
			novoServicoOrcado.setServico(servicoOrcado.getServico());

			listaServicosOrcados.add(novoServicoOrcado);
			// novoOrcamento.getServicosOrcados().add(novoServicoOrcado);
			servicoOrcadoService.salvar(novoServicoOrcado);

		}

		novoOrcamento = orcamentoRepository.save(novoOrcamento);

		return novoOrcamento;
	}

}
