package dev.felipeazsantos.planeja.dominio.cartao.dto;

import dev.felipeazsantos.planeja.dominio.cartao.model.BandeiraCartao;

public record CartaoForm(String nome, BandeiraCartao bandeira) {
}
