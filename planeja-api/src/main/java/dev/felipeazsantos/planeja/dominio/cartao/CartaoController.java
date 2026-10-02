package dev.felipeazsantos.planeja.dominio.cartao;

import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoDetalhes;
import dev.felipeazsantos.planeja.dominio.cartao.dto.CartaoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoDetalhes> criar(@RequestBody @Valid CartaoForm novo) {
        var detalhes = service.criar(novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhes);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartaoDetalhes> obterDetalhes(@PathVariable UUID id) {
        var result = service.obterDetalhes(id);
        return ResponseEntity.ok(result);
    }


}
