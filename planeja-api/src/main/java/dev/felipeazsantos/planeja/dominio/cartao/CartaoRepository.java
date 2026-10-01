package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {
}
