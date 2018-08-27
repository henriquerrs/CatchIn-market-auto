package br.com.entra21java.bean;

/**
 * @author Alunos
 */

public class ProdutoListaBean {
    
    private ListaBean listaBean;
    private ProdutoBean produtoBean;
    private int listas_id, produtos_id, quantidade;

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
        return listas_id;
    }

    public void setListas_id(int listas_id) {
        this.listas_id = listas_id;
    }

    public int getProdutos_id() {
        return produtos_id;
    }

    public void setProdutos_id(int produtos_id) {
        this.produtos_id = produtos_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
