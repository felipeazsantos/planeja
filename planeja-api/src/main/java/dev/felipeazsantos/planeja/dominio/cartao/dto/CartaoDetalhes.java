package dev.felipeazsantos.planeja.dominio.cartao.dto;

import dev.felipeazsantos.planeja.dominio.cartao.model.BandeiraCartao;

import java.time.LocalDateTime;

public record CartaoDetalhes(String id, String nome, BandeiraCartao bandeira, LocalDateTime dataCadastro) {
}
