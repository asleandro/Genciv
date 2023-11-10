package com.genciv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.model.MaterialConsumido;
import com.genciv.model.Servico;
import com.genciv.service.MaterialConsumidoService;

@RestController
@RequestMapping("/materiaisconsumidos")
public class MaterialConsumidoController {

    private MaterialConsumidoService materialConsumidoService;

    @Autowired
    public MaterialConsumidoController(MaterialConsumidoService materialConsumidoService) {
        this.materialConsumidoService = materialConsumidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MaterialConsumido>> listarMateriaisConsumidos(@PathVariable Long id) {
        Servico servico = new Servico();
        servico.setId(id);
        List<MaterialConsumido> materiaisConsumidos = materialConsumidoService.buscarPorServico(servico);
        return new ResponseEntity<>(materiaisConsumidos, HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<MaterialConsumido> criarMaterialConsumido(@RequestBody MaterialConsumido materialConsumido) {
        try {
            MaterialConsumido novoMaterialConsumido = materialConsumidoService.salvar(materialConsumido);
            return new ResponseEntity<>(novoMaterialConsumido, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<Void> excluirMaterialConsumido(@PathVariable Long id) {
        materialConsumidoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
