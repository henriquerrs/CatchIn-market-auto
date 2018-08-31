package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */

public class ClienteBean {
    
    private PessoaBean pessoaBean;
    private int id, idPessoa;
    private String endereco;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
