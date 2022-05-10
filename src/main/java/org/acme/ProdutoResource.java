package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.Dto.ProdutoDTO;
import org.acme.model.Produto;
import org.acme.service.ProdutoService;

@Path("/finalizar")
public class ProdutoResource {

    @Inject
    ProdutoService produtoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @POST
    public void novoProduto(ProdutoDTO produtoDto) {
        produtoService.salvar(produtoDto);
    }
}
