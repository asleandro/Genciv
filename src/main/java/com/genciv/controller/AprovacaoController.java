package com.genciv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.model.Orcamento;
import com.genciv.service.OrcamentoService;

@RestController
@RequestMapping("/aprovar-orcamento")
public class AprovacaoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@GetMapping("/{id}")
	public ResponseEntity<String> aprovarOrcamento(@PathVariable Long id, @RequestParam String codigo) {
		Orcamento orcamento = orcamentoService.findById(id);

		if (orcamento == null) {
			return ResponseEntity.notFound().build();
		} else if (codigo.equals(orcamento.getCodigoAprovacao())) {
			orcamento.aprovarOrcamento();
			orcamentoService.salvar(orcamento);
			return ResponseEntity.ok("Orcamento aprovado com sucesso!");
		} else {
			return ResponseEntity.badRequest().body("Código de aprovação inválido.");
		}
	}
}
