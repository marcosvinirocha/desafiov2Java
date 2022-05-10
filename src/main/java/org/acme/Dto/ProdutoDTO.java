package org.acme.Dto;

import java.util.Objects;

public class ProdutoDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private String status;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, String descricao, Double preco, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProdutoDTO nome(String nome) {
        setNome(nome);
        return this;
    }

    public ProdutoDTO descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public ProdutoDTO preco(Double preco) {
        setPreco(preco);
        return this;
    }

    public ProdutoDTO status(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProdutoDTO)) {
            return false;
        }
        ProdutoDTO produtoDTO = (ProdutoDTO) o;
        return Objects.equals(nome, produtoDTO.nome) && Objects.equals(descricao, produtoDTO.descricao)
                && Objects.equals(preco, produtoDTO.preco) && Objects.equals(status, produtoDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, preco, status);
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", descricao='" + getDescricao() + "'" +
                ", preco='" + getPreco() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
