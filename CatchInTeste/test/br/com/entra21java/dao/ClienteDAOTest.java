 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.bean.PrivilegioBean;
import br.com.entra21java.database.Conexao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Sara Reis
 */
public class ClienteDAOTest {

    /**
     * Test of obterCliente method, of class ClienteDAO.
     */
    @Test
    public void obter() {
        Conexao.truncate();
        
        ClienteBean cliente = new ClienteBean();
        cliente.setUf("SC");
        cliente.setCidade("Blumenau");
        cliente.setBairro("Centro");
        cliente.setLogradouro("Rua XV de Novembro 1480");
        cliente.setComplemento("Prédio");
        cliente.setNumero("3001");
        
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
        
    }

    /**
     * Test of adicionarCliente method, of class ClienteDAO.
     */
    @Test
    public void adicionar() {
        Conexao.truncate();
        
        ClienteBean cliente = new ClienteBean();
        cliente.setUf("SC");
        cliente.setCidade("Blumenau");
        cliente.setBairro("Centro");
        cliente.setLogradouro("Rua XV de Novembro 1480");
        cliente.setComplemento("Prédio");
        cliente.setNumero("3001");
         
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
        
    }

    /**
     * Test of excluirCliente method, of class ClienteDAO.
     */
    @Test
    public void excluir() {
        Conexao.truncate();
        
        ClienteBean cliente = new ClienteBean();
        cliente.setUf("SC");
        cliente.setCidade("Blumenau");
        cliente.setBairro("Centro");
        cliente.setLogradouro("Rua XV de Novembro 1480");
        cliente.setComplemento("Prédio");
        cliente.setNumero("3001");
        
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
        
        cliente.setPessoaBean(pessoa);
        
        new ClienteDAO().excluirCliente(i);
        
        assertNull(new ClienteDAO().obterPeloIdPessoa(i));
    
    }

    /**
     * Test of alterar method, of class ClienteDAO.
     */
    @Test
    public void alterar() {
        Conexao.truncate();
        
        ClienteBean cliente = new ClienteBean();
        cliente.setUf("SC");
        cliente.setCidade("Blumenau");
        cliente.setBairro("Centro");
        cliente.setLogradouro("Rua XV de Novembro 1480");
        cliente.setComplemento("Prédio");
        cliente.setNumero("3001");
        
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
        
        new PessoaDAO().adicionarPessoa(pessoa);
        
        cliente.setPessoaBean(pessoa);
        
        
        new ClienteDAO().alterar(cliente);
        
    }

    /**
     * Test of obterPeloIdPessoa method, of class ClienteDAO.
     */
    @Test
    public void testObterPeloIdPessoa() {
        Conexao.truncate();
        
        ClienteBean cliente = new ClienteBean();
        cliente.setUf("SC");
        cliente.setCidade("Blumenau");
        cliente.setBairro("Centro");
        cliente.setLogradouro("Rua XV de Novembro 1480");
        cliente.setComplemento("Prédio");
        cliente.setNumero("3001");
         
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
        
        cliente.setPessoaBean(pessoa);
        
    }
    
}