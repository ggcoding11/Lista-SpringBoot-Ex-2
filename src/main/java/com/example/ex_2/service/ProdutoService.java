package com.example.ex_2.service;

import com.example.ex_2.model.Produto;
import com.example.ex_2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto criar(Produto p) {
        return repository.save(p);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
