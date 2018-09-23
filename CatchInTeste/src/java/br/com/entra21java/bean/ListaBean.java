package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class ListaBean {
    
    private ClienteBean clienteBean;
    private int id;

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
    
}
