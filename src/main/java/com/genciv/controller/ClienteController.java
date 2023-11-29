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

import com.genciv.dto.ClienteDTO;
import com.genciv.model.Cliente;
import com.genciv.model.Endereco;
import com.genciv.repository.EnderecoService;
import com.genciv.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarTodos();
	}

	@GetMapping("/{id}")
	public Cliente detalhesCliente(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping("/novo")
	public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			 
			Endereco endereco = new Endereco();
			endereco.setLogradouro(clienteDTO.getEndereco().getLogradouro());
			endereco.setNumero(clienteDTO.getEndereco().getNumero());
			endereco.setComplemento(clienteDTO.getEndereco().getComplemento());
			endereco.setCep(clienteDTO.getEndereco().getCep());
			endereco.setBairro(clienteDTO.getEndereco().getBairro());
			endereco.setCidade(clienteDTO.getEndereco().getCidade());
			endereco.setUf(clienteDTO.getEndereco().getUf());

			endereco = enderecoService.salvarEndereco(endereco);

			Cliente cliente = new Cliente();
			cliente.setNome(clienteDTO.getNome());
			cliente.setCpf_cnpj(clienteDTO.getCpf_cnpj());
			cliente.setEmail(clienteDTO.getEmail());
			cliente.setCelular(clienteDTO.getCelular());
			cliente.setEndereco(endereco);
			cliente.setAtivo(clienteDTO.getAtivo());

			cliente = clienteService.salvar(cliente);

			return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}/editar")
	public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
	    Cliente clienteAtualizado = clienteService.findById(id);
	    Endereco enderecoAtualizado = cliente.getEndereco();
	    if (clienteAtualizado == null) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	    
	    clienteAtualizado.setId(id);
	    clienteAtualizado.setNome(cliente.getNome());
	    clienteAtualizado.setCpf_cnpj(cliente.getCpf_cnpj());
	    clienteAtualizado.setEmail(cliente.getEmail());
	    clienteAtualizado.setCelular(cliente.getCelular());
	    clienteAtualizado.setAtivo(cliente.getAtivo());
	    clienteAtualizado.setEndereco(enderecoAtualizado);
	    
	    enderecoAtualizado = enderecoService.salvarEndereco(enderecoAtualizado);
	    clienteAtualizado = clienteService.salvar(clienteAtualizado);
	    
	    return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/excluir")
	public void excluirCliente(@PathVariable Long id) {
		clienteService.excluir(id);
	}
}