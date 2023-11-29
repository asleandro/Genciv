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

import com.genciv.dto.ServicoDTO;
import com.genciv.model.Servico;
import com.genciv.service.MaterialConsumidoService;
import com.genciv.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private MaterialConsumidoService materialConsumidoService;

	@PostMapping("/novo")
	public ResponseEntity<?> criarServico(@RequestBody ServicoDTO servicoDTO) {
		// verificar se ainda funciona após mudar a classe acima para ServicoDTO
		try {
			Servico servico = new Servico();
			servico.setNome(servicoDTO.getNome());
			servico.setDescricao(servicoDTO.getDescricao());
			servico.setValorInstalacaoPorUnd(servicoDTO.getValorInstalacaoPorUnd());
			servico.setValorMaterialPorUnd(servicoDTO.getValorMaterialPorUnd());

			Servico servicoComMateriais = servicoService.criarServicoComMateriais(servico,
					servicoDTO.getMateriaisConsumidos());

			return new ResponseEntity<>(servicoComMateriais, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>("Erro ao criar o serviço", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public List<Servico> listarServicos() {
		return servicoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Servico> detalhesServico(@PathVariable Long id) {
		Servico servico = servicoService.findById(id);
		if (servico != null) {
			return new ResponseEntity<>(servico, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}/editar")
	public ResponseEntity<Servico> editarServico(@PathVariable Long id, @RequestBody Servico servico) {
		Servico servicoAtualizado = servicoService.findById(id);
		if (servicoAtualizado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		servicoAtualizado.setNome(servico.getNome());
		servicoAtualizado.setDescricao(servico.getDescricao());
		servicoAtualizado.setValorInstalacaoPorUnd(servico.getValorInstalacaoPorUnd());
		servicoAtualizado.setValorMaterialPorUnd(servico.getValorMaterialPorUnd());
		servicoAtualizado.setMateriaisConsumidos(servico.getMateriaisConsumidos());

		servicoAtualizado = servicoService.salvar(servicoAtualizado);

		return new ResponseEntity<>(servicoAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/excluir")
	public ResponseEntity<Void> excluirServico(@PathVariable Long id) {
		Servico servico = servicoService.findById(id);
		if (servico == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		servicoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
