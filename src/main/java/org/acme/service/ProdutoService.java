package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.acme.Dto.ProdutoDTO;

import org.acme.model.Produto;

@ApplicationScoped
public class ProdutoService {

    public List<Produto> listar() {
        return Produto.listAll();
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
    public void salvarStatus(Produto produto) {

        Produto produto2 = new Produto();
        produto2.nome = produto.getNome();
        produto2.descricao = produto.getDescricao();
        produto2.preco = produto.getPreco();
        produto2.status = produto.getStatus();
        produto2.persist();
    }

}
