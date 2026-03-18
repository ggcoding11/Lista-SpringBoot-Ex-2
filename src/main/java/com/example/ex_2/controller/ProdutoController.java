package com.example.ex_2.controller;

import com.example.ex_2.model.Produto;
import com.example.ex_2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> request = service.listarTodos();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id) {
        Produto request = service.listarPorId(id).get();

        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto p) {
        Produto request = service.criar(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }



}
