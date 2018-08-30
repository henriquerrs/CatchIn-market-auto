package br.com.entra21java.bean;

/**
 * @author Alunos
 */

public class ProdutoListaBean {
    
    private ListaBean listaBean;
    private ProdutoBean produtoBean;
    private int idLista, idProduto, quantidade;

    public ListaBean getListaBean() {
        return listaBean;
    }

    public void setListaBean(ListaBean listaBean) {
        this.listaBean = listaBean;
    }

    public ProdutoBean getProdutoBean() {
        return produtoBean;
    }

    public void setProdutoBean(ProdutoBean produtoBean) {
        this.produtoBean = produtoBean;
    }

    public int getListas_id() {
        return idLista;
    }

    public void setListas_id(int listas_id) {
        this.idLista = listas_id;
    }

    public int getProdutos_id() {
        return idProduto;
    }

    public void setProdutos_id(int produtos_id) {
        this.idProduto = produtos_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
