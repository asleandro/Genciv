package com.genciv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genciv.model.Cliente;
import com.genciv.repository.ClienteRepository;

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
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}

}
