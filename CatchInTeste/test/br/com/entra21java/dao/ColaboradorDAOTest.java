/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ColaboradorBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.bean.PrivilegioBean;
import br.com.entra21java.database.Conexao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Reis
 */
public class ColaboradorDAOTest {
    
    /**
     * Test of obterCliente method, of class ColaboradorDAO.
     */
    @Test
    public void obter() {
        Conexao.truncate();
        
        List<ColaboradorBean> funcionarios = new ArrayList<>();
        
        ColaboradorBean funcionario = new ColaboradorBean();
        funcionario.setCargo("Gerente");

        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 28;
        pessoa.setId(age);
        
        pessoa.setNome("Fabiano");
        pessoa.setSenha("123abc");
        pessoa.setTelefone("00000000");
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Gerente");
        
        pessoa.setPrivilegioBean(pv);
        
        funcionario.setPessoaBean(pessoa);
        
        int i = new ColaboradorDAO().adicionarCliente(funcionario);
        pessoa.setId(i);

        funcionarios.add(funcionario);
        
        assertEquals(i, 1);
        assertEquals(funcionario, new ColaboradorDAO().obterPeloId(i));
        
    }

    /**
     * Test of adicionarCliente method, of class ColaboradorDAO.
     */
    @Test
    public void adicionar() {
        Conexao.truncate();
        
        List<ColaboradorBean> funcionarios = new ArrayList<>();
        
        ColaboradorBean funcionario = new ColaboradorBean();
        funcionario.setCargo("Gerente");

        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 28;
        pessoa.setId(age);
        
        pessoa.setNome("Fabiano");
        pessoa.setSenha("123abc");
        pessoa.setTelefone("00000000");
        
        PrivilegioBean pv = new PrivilegioBean();
        
        pessoa.setPrivilegioBean(pv);
        
        funcionario.setPessoaBean(pessoa);
        
        int i = new ColaboradorDAO().adicionarCliente(funcionario);
        pessoa.setId(i);

        funcionarios.add(funcionario);
        
        assertEquals(i, 1);
        assertEquals(funcionario, new ColaboradorDAO().obterPeloId(i));
        
    }

    /**
     * Test of excluirCliente method, of class ColaboradorDAO.
     */
    @Test
    public void excluir() {
        Conexao.truncate();
        
        List<ColaboradorBean> funcionarios = new ArrayList<>();
        
        ColaboradorBean funcionario = new ColaboradorBean();
        funcionario.setCargo("Gerente");

        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 28;
        pessoa.setId(age);
        
        pessoa.setNome("Fabiano");
        pessoa.setSenha("123abc");
        pessoa.setTelefone("00000000");
        
        PrivilegioBean pv = new PrivilegioBean();
        
        pessoa.setPrivilegioBean(pv);
        
        funcionario.setPessoaBean(pessoa);
        
        int i = new ColaboradorDAO().adicionarCliente(funcionario);
        funcionario.setId(i);
        
        funcionarios.add(funcionario);
        
        new ColaboradorDAO().excluirCliente(i);
                
    }

    /**
     * Test of alterar method, of class ColaboradorDAO.
     */
    @Test
    public void alterar() {
        Conexao.truncate();
        
        List<ColaboradorBean> funcionarios = new ArrayList<>();
        
        ColaboradorBean funcionario = new ColaboradorBean();
        funcionario.setCargo("Gerente");

        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 28;
        pessoa.setId(age);
        
        pessoa.setNome("Fabiano");
        pessoa.setSenha("123abc");
        pessoa.setTelefone("00000000");
        
        PrivilegioBean pv = new PrivilegioBean();
        
        pessoa.setPrivilegioBean(pv);
        
        funcionario.setPessoaBean(pessoa);
        
        int i = new ColaboradorDAO().adicionarCliente(funcionario);
        pessoa.setId(i);

        funcionarios.add(funcionario);
        
        assertEquals(i, 1);
        assertEquals(funcionario, new ColaboradorDAO().obterPeloId(i));
        
    }

    /**
     * Test of obterPeloId method, of class ColaboradorDAO.
     */
    @Test
    public void testObterPeloId() {
        Conexao.truncate();
        
        List<ColaboradorBean> funcionarios = new ArrayList<>();
        
        ColaboradorBean funcionario = new ColaboradorBean();
        funcionario.setCargo("Gerente");

        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");

        byte age = 28;
        pessoa.setId(age);
        
        pessoa.setNome("Fabiano");
        pessoa.setSenha("123abc");
        pessoa.setTelefone("00000000");
        
        PrivilegioBean pv = new PrivilegioBean();
        
        pessoa.setPrivilegioBean(pv);
        
        funcionario.setPessoaBean(pessoa);
        
        int i = new ColaboradorDAO().adicionarCliente(funcionario);
        pessoa.setId(i);

        funcionarios.add(funcionario);
        
        assertEquals(i, 1);
        assertEquals(funcionario, new ColaboradorDAO().obterPeloId(i));
        
    }
    
}