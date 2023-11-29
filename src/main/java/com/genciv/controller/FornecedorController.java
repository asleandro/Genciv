package com.genciv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.dto.FornecedorDTO;
import com.genciv.model.Endereco;
import com.genciv.model.Fornecedor;
import com.genciv.repository.EnderecoService;
import com.genciv.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public List<Fornecedor> listarFornecedores() {
		return fornecedorService.listarTodos();
	}

	@GetMapping("/{id}")
	public Fornecedor detalhesFornecedor(@PathVariable Long id) {
		return fornecedorService.findById(id);
	}

	@PostMapping("/novo")
	public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
		try {
			Endereco endereco = new Endereco();
			endereco.setLogradouro(fornecedorDTO.getEndereco().getLogradouro());
			endereco.setNumero(fornecedorDTO.getEndereco().getNumero());
			endereco.setComplemento(fornecedorDTO.getEndereco().getComplemento());
			endereco.setCep(fornecedorDTO.getEndereco().getCep());
			endereco.setBairro(fornecedorDTO.getEndereco().getBairro());
			endereco.setCidade(fornecedorDTO.getEndereco().getCidade());
			endereco.setUf(fornecedorDTO.getEndereco().getUf());

			// Salve o Endereco no banco de dados
			endereco = enderecoService.salvarEndereco(endereco);

			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(fornecedorDTO.getNome());
			fornecedor.setCnpj(fornecedorDTO.getCnpj());
			fornecedor.setEmail(fornecedorDTO.getEmail());
			fornecedor.setTelefone(fornecedorDTO.getTelefone());
			fornecedor.setEndereco(endereco);
			fornecedor.setAtivo(fornecedorDTO.getAtivo());

			fornecedor = fornecedorService.salvar(fornecedor);

			return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}/editar")
	public ResponseEntity<Fornecedor> editarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorAtualizado = fornecedorService.findById(id);
		Endereco enderecoAtualizado = fornecedor.getEndereco();
		if (fornecedorAtualizado == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		fornecedorAtualizado.setId(id);
		fornecedorAtualizado.setNome(fornecedor.getNome());
		fornecedorAtualizado.setCnpj(fornecedor.getCnpj());
		fornecedorAtualizado.setEmail(fornecedor.getEmail());
		fornecedorAtualizado.setTelefone(fornecedor.getTelefone());
		fornecedorAtualizado.setAtivo(fornecedor.getAtivo());
		fornecedorAtualizado.setEndereco(enderecoAtualizado);

		enderecoAtualizado = enderecoService.salvarEndereco(enderecoAtualizado);
		fornecedorAtualizado = fornecedorService.salvar(fornecedorAtualizado);

		return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/excluir")
	public void excluirFornecedor(@PathVariable Long id) {
		fornecedorService.excluir(id);
	}
}
