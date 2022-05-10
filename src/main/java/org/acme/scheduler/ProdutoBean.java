package org.acme.scheduler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.Enum.Status;
import org.acme.model.Produto;
import org.acme.service.ProdutoService;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class ProdutoBean {

    @Inject
    private ProdutoService produtoService;

    @Scheduled(every = "20s")
    void updateProduto() {
        List<Produto> produtos = produtoService.listar();

        produtos.forEach(produto -> {
            Produto produto2 = new Produto();
            if (produto.getStatus().equals(Status.AGUARDANDO.toString())) {
                // produto2.setNome(produto.getNome());
                // produto2.setDescricao(produto.getDescricao());
                // produto2.setPreco(produto.getPreco());
                // produto2.setStatus(Status.APROVADO.toString());
                // produtoService.salvarStatus(produto2);
                Log.info("Produto " + produto.getNome() + " foi aprovado");
                Log.info("Status " + produto.getStatus());
            } else {
                Log.info("Produto não está aguardando");
            }
        });

        System.out.println("Status dos produtos atualizados");
    }

}
