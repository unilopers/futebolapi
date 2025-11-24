package com.example.demo.futebolapi.controller;

import com.example.demo.futebolapi.model.Campeonato;
import com.example.demo.futebolapi.model.Time;
import com.example.demo.futebolapi.service.CampeonatoService;
import com.example.demo.futebolapi.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @Autowired
    private CampeonatoService campeonatoService;

    @PostMapping
    public Time criar(@RequestBody Time time) {
        return service.salvar(time);
    }

    @GetMapping
    public List<Time> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Time buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Time atualizar(@PathVariable Long id, @RequestBody Time time) {
        return service.atualizar(id, time);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}/addCampeonato/{idCamp}")
    public Time adicionarCampeonato(@PathVariable Long id, @PathVariable Long idCamp) {
        Time time = service.buscarPorId(id);
        Campeonato camp = campeonatoService.buscarPorId(idCamp);

        if (time != null && camp != null) {
            if (!time.getCampeonatos().contains(camp)) {
                time.getCampeonatos().add(camp);
            }
            if (!camp.getTimes().contains(time)) {
                camp.getTimes().add(time);
            }
            service.salvar(time);
        }
        return time;
    }
}