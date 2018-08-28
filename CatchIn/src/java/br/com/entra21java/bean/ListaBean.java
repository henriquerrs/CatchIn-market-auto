package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class ListaBean {
    
    private ClienteBean clienteBean;
    private int idCliente;

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public int getClientes_id() {
        return idCliente;
    }

    public void setClientes_id(int clientes_id) {
        this.idCliente = clientes_id;
    }
    
}
