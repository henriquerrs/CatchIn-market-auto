package br.com.entra21java.bean;

import java.util.List;

/**
* @author Crispim Paiano dos Santos
*/
public class CompraBean {

    private int id, idCliente, status;
    private ClienteBean cliente;
    private double total;
    private List<ItemBean> item;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdClientes() {
        return idCliente;
    }

    public void setIdClientes(int idClientes) {
        this.idCliente = idClientes;
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
        return item;
    }

    public void setItens(List<ItemBean> itens) {
        this.item = itens;
    }
    
}
