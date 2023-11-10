package com.genciv.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.model.Endereco;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public Endereco criarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco obterEnderecoPorId(Long id) {
		return enderecoRepository.findById(id).orElse(null);
	}

	public void atualizarEndereco(Long id, Endereco novoEndereco) {
		Endereco enderecoExistente = enderecoRepository.findById(id).orElse(null);
		if (enderecoExistente == null) {
			// Lide com a situação em que o endereço não foi encontrado.
			// Pode lançar uma exceção ou retornar um status apropriado.
		} else {
			// Atualize as informações do endereço existente com os dados do novo endereço.
			enderecoExistente.atualizarInformacoes(null);
			enderecoRepository.save(enderecoExistente);
		}
	}

	public void deletarEndereco(Long id) {
		// Verifique se o endereço com o ID especificado existe no banco de dados.
		Endereco enderecoExistente = enderecoRepository.findById(id).orElse(null);
		if (enderecoExistente != null) {
			// Remova o endereço do banco de dados.
			enderecoRepository.delete(enderecoExistente);
		}
	}

	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
