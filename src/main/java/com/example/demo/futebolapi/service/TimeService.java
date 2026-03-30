package com.example.demo.futebolapi.service;

import com.example.demo.futebolapi.model.Time;
import com.example.demo.futebolapi.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    @Autowired
    private TimeAsyncService timeAsyncService;

    public Time salvar(Time time) {
        Time timeSalvo = repository.save(time);

        // Dispara o processamento em background sem bloquear a resposta
        timeAsyncService.processarPosCadastro(timeSalvo);

        return timeSalvo;
    }

    public List<Time> listarTodos() {
        return repository.findAll();
    }

    public Time buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Time atualizar(Long id, Time novo) {
        Time existente = buscarPorId(id);
        if (existente == null) return null;
        existente.setNome(novo.getNome());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}