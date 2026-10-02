package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.common.exceptions.NotFoundException;
import dev.felipeazsantos.planeja.common.exceptions.ValidationException;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoDetalhes;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import dev.felipeazsantos.planeja.dominio.cartao.mapper.CartaoMapper;
import dev.felipeazsantos.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator validator;

    @Autowired
    private CartaoRepository repository;

    @Autowired
    private CartaoMapper mapper;

    public CartaoDetalhes criar(CartaoForm form) {
        validarDadosCartao(form, null);
        CartaoEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetalhes(entity);
    }

    public CartaoDetalhes obterDetalhes(UUID id) {
        var cartaoDetalhes = repository
                .findById(id)
                .map(mapper::toDetalhes)
                .orElseThrow(() -> new NotFoundException());

        return cartaoDetalhes;
    }

    public void atualizar(UUID id, CartaoForm form) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        validarDadosCartao(form, id);
        mapper.update(entity, form);
        repository.save(entity);
    }

    private void validarDadosCartao(CartaoForm form, UUID id) {
        var result = validator.validar(form, id);
        if (result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }
    }
}
