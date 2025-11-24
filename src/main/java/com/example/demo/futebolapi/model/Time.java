package com.example.demo.futebolapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do time não pode ser nulo")
    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "time_campeonato",
            joinColumns = @JoinColumn(name = "time_id"),
            inverseJoinColumns = @JoinColumn(name = "campeonato_id")
    )
    private List<Campeonato> campeonatos = new ArrayList<>();

    public Time() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public List<Jogador> getJogadores() { return jogadores; }

    public void setJogadores(List<Jogador> jogadores) { this.jogadores = jogadores; }

    public List<Campeonato> getCampeonatos() { return campeonatos; }

    public void setCampeonatos(List<Campeonato> campeonatos) { this.campeonatos = campeonatos; }

    @JsonProperty("campeonatos")
    public List<String> getNomesCampeonatos() {
        List<String> nomes = new ArrayList<>();
        for (Campeonato c : campeonatos) {
            nomes.add(c.getNome());
        }
        return nomes;
    }
}