package com.example.demo.futebolapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do jogador não pode ser nulo")
    private String nome;

    @NotNull(message = "A posição do jogador não pode ser nula")
    private String posicao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "time_id")
    @NotNull(message = "O jogador deve estar vinculado a um time")
    private Time time;

    @JsonProperty("nomeTime")
    public String getNomeTime() {
        return time != null ? time.getNome() : null;
    }

    public Jogador() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getPosicao() { return posicao; }

    public void setPosicao(String posicao) { this.posicao = posicao; }

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }
}