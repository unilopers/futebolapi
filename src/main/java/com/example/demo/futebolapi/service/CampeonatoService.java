package com.example.demo.futebolapi.service;

import com.example.demo.futebolapi.model.Campeonato;
import com.example.demo.futebolapi.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    public Campeonato salvar(Campeonato campeonato) {
        return repository.save(campeonato);
    }

    public List<Campeonato> listarTodos() {
        return repository.findAll();
    }

    public Campeonato buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Campeonato atualizar(Long id, Campeonato novo) {
        Campeonato existente = buscarPorId(id);
        if (existente == null) return null;

        existente.setNome(novo.getNome());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}