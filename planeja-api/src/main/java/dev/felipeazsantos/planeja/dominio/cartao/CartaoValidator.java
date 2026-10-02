package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.common.validation.CampoInvalido;
import dev.felipeazsantos.planeja.common.validation.ValidationResult;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form) {
        var result = ValidationResult.novo();

        if (repository.findByNome(form.nome()).isPresent()) {
            result.add(new CampoInvalido("nome", "Já cadastrado."));
        }

        return result;
    }
}
