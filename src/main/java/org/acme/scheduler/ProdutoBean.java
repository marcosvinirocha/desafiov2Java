package org.acme.scheduler;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.Enum.Status;
import org.acme.model.Produto;
import org.acme.service.ProdutoService;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class ProdutoBean {

    @Inject
    private ProdutoService produtoService;

    @Scheduled(every = "120s")
    @Transactional
    void updateProduto() {
        List<Produto> produtos = produtoService.listarStatus();

        produtos.forEach(produto -> {
            Produto produto2 = new Produto();
            if (produto.getStatus().equals(Status.AGUARDANDO.toString())) {
                produto2.setNome(produto.getNome());
                produto2.setDescricao(produto.getDescricao());
                produto2.setPreco(produto.getPreco());
                produto2.setStatus(Status.APROVADO.toString());
                produtoService.salvarStatus(produto2);
                produtoService.deletar();
                Log.info("Produto " + produto.getNome());
                Log.info("Status " + produto.getStatus());
            } else {
                Log.info("Todos os produtos foram aprovados");
            }
        });

        System.out.println("Status dos produtos atualizados");
    }

}
