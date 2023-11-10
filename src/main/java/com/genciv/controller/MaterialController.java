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

import com.genciv.dto.MaterialDTO;
import com.genciv.model.Fornecedor;
import com.genciv.model.Material;
import com.genciv.service.FornecedorService;
import com.genciv.service.MaterialService;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public List<Material> listarMateriais() {
		return materialService.listarTodos();
	}

	@GetMapping("/{id}")
	public Material detalhesMaterial(@PathVariable Long id) {
		return materialService.buscarPorId(id);
	}

	@PostMapping("/novo")
	public ResponseEntity<?> criarMaterial(@RequestBody MaterialDTO materialDTO) {
		try {
			Material material = new Material();
			material.setNome(materialDTO.getNome());
			material.setTipo(materialDTO.getTipo());
			material.setUnidade(materialDTO.getUnidade());
			material.setQtdEmbalagem(materialDTO.getQtdEmbalagem());
			material.setValorCusto(materialDTO.getValorCusto());
			material.setValorVenda(materialDTO.getValorVenda());

			List<Fornecedor> fornecedores = materialDTO.getFornecedores();
			if (fornecedores != null) {
				for (Fornecedor fornecedor : fornecedores) {
					Fornecedor fornecedorExistente = fornecedorService.buscarPorId(fornecedor.getId());
					if (fornecedorExistente != null) {
						material.getFornecedores().add(fornecedorExistente);
					}
				}
			}

			materialService.salvar(material);
			return new ResponseEntity<>(material, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<String>("Erro ao criar o material: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/editar")
	public ResponseEntity<Material> editarMaterial(@PathVariable Long id, @RequestBody Material material){
		Material materialAtualizado = materialService.buscarPorId(id);
		if (materialAtualizado == null) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		materialAtualizado.setId(id);
		materialAtualizado.setNome(material.getNome());
		materialAtualizado.setTipo(material.getTipo());
		materialAtualizado.setValorCusto(material.getValorCusto());
		materialAtualizado.setValorVenda(material.getValorVenda());
		materialAtualizado.setUnidade(material.getUnidade());
		materialAtualizado.setQtdEmbalagem(material.getQtdEmbalagem());
		materialAtualizado.setFornecedores(material.getFornecedores());
		
		materialAtualizado = materialService.salvar(materialAtualizado);
		
		return new ResponseEntity<>(materialAtualizado, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/excluir")
	public void excluirMaterial(@PathVariable Long id) {
		materialService.excluir(id);
	}

}
