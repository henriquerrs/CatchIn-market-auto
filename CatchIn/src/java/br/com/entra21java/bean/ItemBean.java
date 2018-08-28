/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.bean;

/**
 *
 * @author Crispim Paiano dos Santos
 */
public class ItemBean {

    private int id, quantidade, idCompra, idProduto;
    private CompraBean compra;
    private ProdutoBean produto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdCompras() {
        return idCompra;
    }

    public void setIdCompras(int idCompras) {
        this.idCompra = idCompras;
    }

    public int getIdProdutos() {
        return idProduto;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProduto = idProdutos;
    }

    public CompraBean getCompra() {
        return compra;
    }

    public void setCompra(CompraBean compra) {
        this.compra = compra;
    }

    public ProdutoBean getProduto() {
        return produto;
    }

    public void setProduto(ProdutoBean produto) {
        this.produto = produto;
    }

}
