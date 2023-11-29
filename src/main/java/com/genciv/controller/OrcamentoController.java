package com.genciv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.dto.OrcamentoDTO;
import com.genciv.dto.ServicoOrcadoDTO;
import com.genciv.model.Endereco;
import com.genciv.model.Orcamento;
import com.genciv.model.Servico;
import com.genciv.model.ServicoOrcado;
import com.genciv.repository.EnderecoService;
import com.genciv.service.OrcamentoService;
import com.genciv.service.ServicoOrcadoService;
import com.genciv.service.ServicoService;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@Autowired
	private ServicoOrcadoService servicoOrcadoService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ServicoService servicoService;

	@PostMapping("/novo")
	public ResponseEntity<?> criarOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
		try {
			Endereco endereco = new Endereco();
			endereco.setLogradouro(orcamentoDTO.getEnderecoObra().getLogradouro());
			endereco.setNumero(orcamentoDTO.getEnderecoObra().getNumero());
			endereco.setComplemento(orcamentoDTO.getEnderecoObra().getComplemento());
			endereco.setCep(orcamentoDTO.getEnderecoObra().getCep());
			endereco.setBairro(orcamentoDTO.getEnderecoObra().getBairro());
			endereco.setCidade(orcamentoDTO.getEnderecoObra().getCidade());
			endereco.setUf(orcamentoDTO.getEnderecoObra().getUf());
			endereco = enderecoService.salvarEndereco(endereco);

			Orcamento orcamento = new Orcamento();
			orcamento.setCliente(orcamentoDTO.getCliente());
			orcamento.setObraOrcada(orcamentoDTO.getObraOrcada());
			orcamento.setEnderecoObra(endereco);
			orcamento.setValorMaterialTotal(orcamentoDTO.getValorMaterialTotal());
			orcamento.setValorServicoTotal(orcamentoDTO.getValorServicoTotal());
			orcamento.setPrazoPagamentoMaterial(orcamentoDTO.getPrazoPagamentoMaterial());
			orcamento.setPrazoPagamentoServico(orcamentoDTO.getPrazoPagamentoServico());
			orcamento.setAtivo(orcamentoDTO.getAtivo());

			List<ServicoOrcado> servicosOrcados = new ArrayList<>();
			for (ServicoOrcadoDTO servicoOrcadoDTO : orcamentoDTO.getServicosOrcados()) {
				Servico servico = servicoService.findById(servicoOrcadoDTO.getServicoId());
				ServicoOrcado servicoOrcado = new ServicoOrcado();
				servicoOrcado.setServico(servico);
				servicoOrcado.setQuantidade(servicoOrcadoDTO.getQuantidade());
				servicosOrcados.add(servicoOrcado);
			}

			orcamento.setServicosOrcados(servicosOrcados);
			Orcamento orcamentoComServicos = orcamentoService.criarOrcamentoComServicos(orcamento,
					servicosOrcados);
			return new ResponseEntity<>(orcamentoComServicos, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = e.getMessage();

			return new ResponseEntity<>("Erro ao criar orçamento: " + mensagem,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public List<Orcamento> listarOrcamentos() {
		return orcamentoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orcamento> detalhesOrcamento(@PathVariable Long id) {
		Orcamento orcamento = orcamentoService.findById(id);
		if (orcamento != null) {
			return new ResponseEntity<>(orcamento, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}/excluir")
	public ResponseEntity<Void> excluirOrcamento(@PathVariable Long id) {
		Orcamento orcamento = orcamentoService.findById(id);
		if (orcamento == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		orcamentoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/*
	@PostMapping("/aprovar-orcamento/{id}")
	public ResponseEntity<String> aprovarOrcamento(@PathVariable Long id){
		Orcamento orcamento = orcamentoService.buscarPorId(id);

	    if (orcamento != null) {
	        orcamento.aprovarOrcamento();
	        orcamentoService.salvar(orcamento);
	        return ResponseEntity.ok("Orcamento aprovado com sucesso!");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	*/
	
	@PostMapping("/{id}/aprovar")
	public ResponseEntity<String> aprovarOrcamento(@PathVariable Long id, @RequestParam String codigo) {
	    Orcamento orcamento = orcamentoService.findById(id);

	    if (orcamento != null) {
	        if (codigo.equals(orcamento.getCodigoAprovacao())) {
	            if (!orcamento.getAprovado()) {  // Verifica se o orçamento ainda não foi aprovado
	                orcamento.aprovarOrcamento();
	                orcamentoService.salvar(orcamento);
	                return ResponseEntity.ok("Orçamento aprovado com sucesso!");
	            } else {
	                return ResponseEntity.badRequest().body("Este orçamento já foi aprovado anteriormente.");
	            }
	        } else {
	            return ResponseEntity.badRequest().body("Código de aprovação inválido.");
	        }
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	

}
