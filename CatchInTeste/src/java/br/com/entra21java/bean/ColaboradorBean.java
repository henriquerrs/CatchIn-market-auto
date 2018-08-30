package br.com.entra21java.bean;

/**
 * @author Crispim Paiano dos Santos
 */

public class ColaboradorBean{

    private PessoaBean pessoaBean;

    private int id, idPessoa;
    private String cargo;

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

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPrivilegio) {
        this.idPessoa = idPrivilegio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
