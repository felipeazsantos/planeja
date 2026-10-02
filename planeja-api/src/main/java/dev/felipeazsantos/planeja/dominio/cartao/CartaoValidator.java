package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.common.validation.CampoInvalido;
import dev.felipeazsantos.planeja.common.validation.ValidationResult;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form, UUID id) {
        var result = ValidationResult.novo();

        if (!repository.findByNomeAndNotId(form.nome(), id).isEmpty()) {
            result.add(new CampoInvalido("nome", "Já cadastrado."));
        }

        return result;
    }
}
