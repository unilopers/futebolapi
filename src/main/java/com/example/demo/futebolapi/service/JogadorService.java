package com.example.demo.futebolapi.service;

import com.example.demo.futebolapi.model.Jogador;
import com.example.demo.futebolapi.model.Time;
import com.example.demo.futebolapi.repository.JogadorRepository;
import com.example.demo.futebolapi.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    @Autowired
    private TimeRepository timeRepository;

    public Jogador salvar(Jogador jogador, Long timeId) {
        Time t = timeRepository.findById(timeId).orElse(null);
        jogador.setTime(t);
        return repository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return repository.findAll();
    }

    public Jogador buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Jogador atualizar(Long id, Jogador novo) {
        Jogador existente = buscarPorId(id);
        if (existente == null) return null;

        existente.setNome(novo.getNome());
        existente.setPosicao(novo.getPosicao());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}