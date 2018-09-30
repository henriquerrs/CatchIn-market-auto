/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class PrivilegioDAOTest {
    
    /**
     * Test of obterPrivilegio method, of class PrivilegioDAO.
     */
    @Test
    public void obter() {
        Conexao.truncate();
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");
        
        byte age = 22;
        pessoa.setId(age);
        
        pessoa.setNome("Eduardo");
        pessoa.setPrivilegioBean(pv);
        pessoa.setSenha("1234");
        pessoa.setTelefone("00000000");
        
        int i = new PrivilegioDAO().adicionarPrivilegio(pv);
        pv.setId(i);
        
    }

    /**
     * Test of adicionarPrivilegio method, of class PrivilegioDAO.
     */
    @Test
    public void adicionar() {
        Conexao.truncate();
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");
        
        byte age = 24;
        pessoa.setId(age);
        
        pessoa.setNome("Helena");
        pessoa.setPrivilegioBean(pv);
        pessoa.setSenha("abcd");
        pessoa.setTelefone("00000000");
        
        int i = new PrivilegioDAO().adicionarPrivilegio(pv);
        pv.setId(i);
        
        
    }

    /**
     * Test of excluirPrivilegio method, of class PrivilegioDAO.
     */
    @Test
    public void excluir() {
        Conexao.truncate();
        
        PrivilegioBean pv = new PrivilegioBean();
        pv.setTipo("Cliente");
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setCpf("00000000000");
        pessoa.setEmail("pessoa@gmail.com");
        
        byte age = 24;
        pessoa.setId(age);
        
        pessoa.setNome("Kim");
        pessoa.setPrivilegioBean(pv);
        pessoa.setSenha("123abcd");
        pessoa.setTelefone("00000000");
        
        int i = new PrivilegioDAO().adicionarPrivilegio(pv);
        pv.setId(i);
        
        new PrivilegioDAO().excluirPrivilegio(i);
    }
    
}