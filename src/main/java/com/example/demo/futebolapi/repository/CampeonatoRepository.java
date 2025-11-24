package com.example.demo.futebolapi.repository;

import com.example.demo.futebolapi.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {}