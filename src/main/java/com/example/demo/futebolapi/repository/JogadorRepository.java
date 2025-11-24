package com.example.demo.futebolapi.repository;

import com.example.demo.futebolapi.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {}