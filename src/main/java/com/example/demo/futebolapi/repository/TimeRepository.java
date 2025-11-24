package com.example.demo.futebolapi.repository;

import com.example.demo.futebolapi.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {}