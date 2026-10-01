package dev.felipeazsantos.planeja.dominio.cartao.mapper;

import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoDetalhes;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import dev.felipeazsantos.planeja.dominio.cartao.model.CartaoEntity;

public interface CartaoMapper {

    CartaoEntity toEntity(CartaoForm form);
    CartaoDetalhes toDetalhes(CartaoEntity entity);
}
