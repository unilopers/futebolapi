package com.example.demo.futebolapi.service;

import com.example.demo.futebolapi.model.Time;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TimeAsyncService {

    @Async
    public void processarPosCadastro(Time time) {
        try {
            System.out.println("[ASYNC] Iniciando processamento do time: " + time.getNome());

            // Simula um processamento secundário realista
            Thread.sleep(3000);

            System.out.println("[ASYNC] Processamento finalizado para o time ID "
                    + time.getId() + " - " + time.getNome());
        } catch (InterruptedException e) {
            System.err.println("[ASYNC] Erro no processamento do time ID "
                    + time.getId() + ": " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("[ASYNC] Falha inesperada no processamento do time ID "
                    + time.getId() + ": " + e.getMessage());
        }
    }
}