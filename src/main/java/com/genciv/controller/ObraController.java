package com.genciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genciv.model.Obra;
import com.genciv.service.ObraService;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @PostMapping
    public ResponseEntity<String> criarObra(@RequestBody Obra obra) {
        obraService.salvarObra(obra);
        return ResponseEntity.ok("Obra criada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> obterObraPorId(@PathVariable Long id) {
        Obra obra = obraService.findById(id);
        return obra != null ? ResponseEntity.ok(obra) : ResponseEntity.notFound().build();
    }

}
