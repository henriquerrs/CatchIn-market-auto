package br.com.entra21java.bean;

/**
 *
 * @author Crispim Paiano dos Santos
 */
public class PessoaBean {

    private int id, idPrivilegio;
    private PrivilegioBean privilegioBean;
    private String nome, senha, email, cpf, telefone;
    private byte idade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PrivilegioBean getPrivilegioBean() {
        return privilegioBean;
    }

    public void setPrivilegioBean(PrivilegioBean privilegioBean) {
        this.privilegioBean = privilegioBean;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

}
