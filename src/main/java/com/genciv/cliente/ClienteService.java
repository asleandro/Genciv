package com.genciv.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}

}
