package com.genciv.fornecedor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
