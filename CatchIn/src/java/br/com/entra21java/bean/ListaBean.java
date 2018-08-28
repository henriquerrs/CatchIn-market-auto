package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class ListaBean {
    
    private ClienteBean clienteBean;
    private int id, idCliente;

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

   
    
}
