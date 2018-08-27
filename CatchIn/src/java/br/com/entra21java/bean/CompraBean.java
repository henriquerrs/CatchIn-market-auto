package br.com.entra21java.bean;

import java.util.List;

/**
* @author Crispim Paiano dos Santos
*/
public class CompraBean {

    private int id, idClientes;
    private ClienteBean cliente;
    private double total;
    private List<ItemBean> itens;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ItemBean> getItens() {
        return itens;
    }

    public void setItens(List<ItemBean> itens) {
        this.itens = itens;
    }

   
    
}
