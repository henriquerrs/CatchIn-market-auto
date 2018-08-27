package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class ListaBean {
    
    private ClienteBean clienteBean;
    private int clientes_id;

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public int getClientes_id() {
        return clientes_id;
    }

    public void setClientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }
    
}
