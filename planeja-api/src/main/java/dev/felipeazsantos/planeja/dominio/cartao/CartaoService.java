package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.common.exceptions.ValidationException;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoDetalhes;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import dev.felipeazsantos.planeja.dominio.cartao.mapper.CartaoMapper;
import dev.felipeazsantos.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator validator;

    @Autowired
    private CartaoRepository repository;

    @Autowired
    private CartaoMapper mapper;

    public CartaoDetalhes criar(CartaoForm form) {
        var result = validator.validar(form);
        if (result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }

        CartaoEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetalhes(entity);
    }
}
