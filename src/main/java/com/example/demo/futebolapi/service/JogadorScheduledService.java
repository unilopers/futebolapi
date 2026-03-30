package com.example.demo.futebolapi.service;

import com.example.demo.futebolapi.model.Jogador;
import com.example.demo.futebolapi.repository.JogadorRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorScheduledService {

    private final JogadorRepository jogadorRepository;

    public JogadorScheduledService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Scheduled(fixedRate = 15000)
    public void validarJogadoresPeriodicamente() {
        try {
            System.out.println("[SCHEDULED] Iniciando validação periódica de jogadores...");

            List<Jogador> jogadores = jogadorRepository.findAll();

            for (Jogador jogador : jogadores) {
                if (jogador.getNome() == null || jogador.getNome().trim().isEmpty()) {
                    System.out.println("[SCHEDULED] Jogador com nome inválido encontrado. ID: " + jogador.getId());
                }

                if (jogador.getPosicao() == null || jogador.getPosicao().trim().isEmpty()) {
                    System.out.println("[SCHEDULED] Jogador com posição inválida encontrado. ID: " + jogador.getId());
                }
            }

            System.out.println("[SCHEDULED] Validação concluída. Total de jogadores verificados: " + jogadores.size());

        } catch (Exception e) {
            System.err.println("[SCHEDULED] Erro na validação periódica de jogadores: " + e.getMessage());
        }
    }
}