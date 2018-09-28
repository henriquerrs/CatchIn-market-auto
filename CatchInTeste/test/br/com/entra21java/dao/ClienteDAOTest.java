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
        
        cliente.setPessoaBean(pessoa);
        
        assertEquals(cliente, new ClienteDAO().obterPeloIdPessoa(i));

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
        
        assertEquals(i, 1);
        
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
    public void obterPeloId() {
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
        
        assertEquals(cliente, new ClienteDAO().obterPeloIdPessoa(i));
    }

    /**
     * Test of obterCliente method, of class ClienteDAO.
     */
    @Test
    public void testObterCliente() {
        System.out.println("obterCliente");
        ClienteDAO instance = new ClienteDAO();
        List<ClienteBean> expResult = null;
        List<ClienteBean> result = instance.obterCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarCliente method, of class ClienteDAO.
     */
    @Test
    public void testAdicionarCliente() {
        System.out.println("adicionarCliente");
        ClienteBean cliente = null;
        ClienteDAO instance = new ClienteDAO();
        int expResult = 0;
        int result = instance.adicionarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirCliente method, of class ClienteDAO.
     */
    @Test
    public void testExcluirCliente() {
        System.out.println("excluirCliente");
        int id = 0;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.excluirCliente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class ClienteDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        ClienteBean cliente = null;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.alterar(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterPeloIdPessoa method, of class ClienteDAO.
     */
    @Test
    public void testObterPeloIdPessoa() {
        System.out.println("obterPeloIdPessoa");
        int id = 0;
        ClienteDAO instance = new ClienteDAO();
        ClienteBean expResult = null;
        ClienteBean result = instance.obterPeloIdPessoa(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}