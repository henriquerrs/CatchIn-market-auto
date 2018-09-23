package br.com.entra21java.bean;

/**
 * @author Alunos
 */

public class ProdutoListaBean {
    
    private ListaBean listaBean;
    private ProdutoBean produtoBean;
    private int id, idLista, idProduto, quantidade;

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
