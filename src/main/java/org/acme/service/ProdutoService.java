package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.acme.Dto.ProdutoDTO;
import org.acme.Enum.Status;
import org.acme.model.Produto;

import io.quarkus.logging.Log;

@ApplicationScoped
public class ProdutoService {

    public List<Produto> listar() {
        return Produto.listAll();
    }

    public List<Produto> listarStatus() {
        return Produto.list("status", Status.AGUARDANDO.toString());
    }

    @Transactional
    public void salvar(ProdutoDTO produtoDto) {

        Produto produto = new Produto();
        produto.nome = produtoDto.getNome();
        produto.descricao = produtoDto.getDescricao();
        produto.preco = produtoDto.getPreco();
        produto.status = produtoDto.getStatus();
        produto.persist();
    }

    @Transactional
    public void salvarStatus(Produto produtoDto) {

        Produto produto = new Produto();
        produto.nome = produtoDto.getNome();
        produto.descricao = produtoDto.getDescricao();
        produto.preco = produtoDto.getPreco();
        produto.status = produtoDto.getStatus();
        produto.persist();
    }

    @Transactional
    public void deletar() {
        Produto.delete("status", Status.AGUARDANDO.toString());
        Log.info("Produto deletado");
    }

}
