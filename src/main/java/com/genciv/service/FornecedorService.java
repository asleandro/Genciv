package com.genciv.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genciv.model.Fornecedor;
import com.genciv.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	@Transactional
	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}

	@Transactional
	public Fornecedor buscarPorId(Long id) {
		return fornecedorRepository.findById(id).orElse(null);
	}

	@Transactional
	public void excluir(Long id) {
		fornecedorRepository.deleteById(id);
	}

}
