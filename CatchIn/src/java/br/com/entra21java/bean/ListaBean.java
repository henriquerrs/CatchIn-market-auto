package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class ListaBean {
    
    private ClienteBean clienteBean;
    private int cliente_id;

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public int getClientes_id() {
        return cliente_id;
    }

    public void setClientes_id(int clientes_id) {
        this.cliente_id = clientes_id;
    }
    
}
