package com.genciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.dto.ServicoOrcadoDTO;
import com.genciv.model.Orcamento;
import com.genciv.model.Servico;
import com.genciv.model.ServicoOrcado;
import com.genciv.service.OrcamentoService;
import com.genciv.service.ServicoOrcadoService;
import com.genciv.service.ServicoService;

@RestController
@RequestMapping("/servicos-orcados")
public class ServicoOrcadoController {

	@Autowired
	private ServicoOrcadoService servicoOrcadoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private OrcamentoService orcamentoService;

	@PostMapping("/novo")
	public ResponseEntity<?> novoServicoOrcado(@RequestBody ServicoOrcadoDTO servicoOrcadoDTO) {
		try {
			Servico servico = servicoService.buscarPorId(servicoOrcadoDTO.getServicoId());
            if (servico == null) {
                return new ResponseEntity<>("Serviço não encontrado", HttpStatus.NOT_FOUND);
            }
            
            Orcamento orcamento = orcamentoService.buscarPorId(servicoOrcadoDTO.getOrcamentoId());
            if (orcamento == null) {
                return new ResponseEntity<>("Orçamento não encontrado", HttpStatus.NOT_FOUND);
            }
            
            ServicoOrcado servicoOrcado = new ServicoOrcado();
            servicoOrcado.setServico(servico);
            servicoOrcado.setQuantidade(servicoOrcadoDTO.getQuantidade());
            //servicoOrcado.setUnidade(servicoOrcadoDTO.getUnidade());
            servicoOrcado.setOrcamento(orcamento);

            ServicoOrcado servicoOrcadoCriado = servicoOrcadoService.salvar(servicoOrcado);

            return new ResponseEntity<>(servicoOrcadoCriado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar o serviço orçado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}
}
