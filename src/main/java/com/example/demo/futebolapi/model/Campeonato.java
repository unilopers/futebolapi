package com.example.demo.futebolapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do campeonato não pode ser nulo")
    private String nome;

    @ManyToMany(mappedBy = "campeonatos")
    private List<Time> times = new ArrayList<>();

    public Campeonato() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public List<Time> getTimes() { return times; }

    public void setTimes(List<Time> times) { this.times = times; }

    @JsonProperty("times")
    public List<String> getNomesTimes() {
        List<String> nomes = new ArrayList<>();
        for (Time t : times) {
            nomes.add(t.getNome());
        }
        return nomes;
    }
}