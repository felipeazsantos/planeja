package dev.felipeazsantos.planeja.infra;

import dev.felipeazsantos.planeja.dominio.cartao.CartaoRepository;
import dev.felipeazsantos.planeja.dominio.cartao.model.BandeiraCartao;
import dev.felipeazsantos.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sandbox implements CommandLineRunner {

    @Autowired
    private CartaoRepository repository;

    public void salvarCartao() {
        CartaoEntity cartao = new CartaoEntity();
        cartao.setNome("Itau Personalité");
        cartao.setBandeira(BandeiraCartao.VISA);

        repository.save(cartao);
    }

    @Override
    public void run(String... args) throws Exception {
//        salvarCartao();
    }
}
