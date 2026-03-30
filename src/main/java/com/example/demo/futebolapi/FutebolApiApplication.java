package com.example.demo.futebolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FutebolApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FutebolApiApplication.class, args);
    }}