/*
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.bean.PrivilegioBean;
import br.com.entra21java.database.Conexao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Reis
 */
public class PessoaDAOTest {
    
    /**
     * Test of getId method, of class PessoaBean.
     */
    
    @Test
    public void inserir() {
        Conexao.truncate();
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("11111111111");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 45;
        pessoa.setIdade(age);
        
        pessoa.setNome("Roberto Cravos");
        pessoa.setSenha("001001");
        pessoa.setTelefone("11111111");
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        pessoa.setPrivilegioBean(pv);
        
        int i = new PessoaDAO().adicionarPessoa(pessoa);
        pessoa.setId(i);
        
        System.out.println("Resultado do ID : " + i );
        
    }
    
   @Test
    public void verificar() {
        Conexao.truncate();
   
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("22222222222");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 22;
        pessoa.setIdade(age);
        
        pessoa.setNome("Lucas Silva");
        pessoa.setSenha("abgsavjd");
        pessoa.setTelefone("22222222");
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        pessoa.setPrivilegioBean(pv);
        
        new PessoaDAO().adicionarPessoa(pessoa);
        
    }
    
    @Test
    public void obterId() {
        Conexao.truncate();
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("33333333333");
        pessoa.setEmail("pessoa@gmail.com");
        
        byte age = 34;
        pessoa.setIdade(age);
        
        pessoa.setNome("Carla Ferreira");
        pessoa.setSenha("jdshfiofh");
        pessoa.setTelefone("33333333");
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        pessoa.setPrivilegioBean(pv);

        int i = new PessoaDAO().adicionarPessoa(pessoa);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
}