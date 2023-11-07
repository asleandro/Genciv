package com.genciv.material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genciv.endereco.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService {

	private MaterialRepository materialRepository;
	
	@Autowired
	public MaterialService(MaterialRepository materialRepository) {
		this.materialRepository = materialRepository;
	}

	@Transactional
	public Material salvar(Material material) {
		return materialRepository.save(material);
	}

	@Transactional
	public List<Material> listarTodos() {
		return materialRepository.findAll();
	}

	@Transactional
	public Material buscarPorId(Long id) {
		return materialRepository.findById(id).orElse(null);
	}

	@Transactional
	public void excluir(Long id) {
		materialRepository.deleteById(id);
	}

}
