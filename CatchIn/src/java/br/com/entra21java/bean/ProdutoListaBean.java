package br.com.entra21java.bean;

/**
 * @author Alunos
 */

public class ProdutoListaBean {
    
    private ListaBean listaBean;
    private ProdutoBean produtoBean;
    private int lista_id, produto_id, quantidade;

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
        return lista_id;
    }

    public void setListas_id(int listas_id) {
        this.lista_id = listas_id;
    }

    public int getProdutos_id() {
        return produto_id;
    }

    public void setProdutos_id(int produtos_id) {
        this.produto_id = produtos_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
