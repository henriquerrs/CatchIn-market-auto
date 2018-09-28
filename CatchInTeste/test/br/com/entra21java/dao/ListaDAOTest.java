/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.ListaBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.database.Conexao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class ListaDAOTest {
    
    /**
     * Test of adicionarLista method, of class ListaDAO.
     */
    @Test
    public void testAdicionarLista() {
       Conexao.truncate();
       
       ClienteBean cliente = new ClienteBean();
       cliente.setUf("SC");
       cliente.setCidade("Blumenau");
       cliente.setBairro("Centro");
       cliente.setLogradouro("Rua XV de Novembro 1480");
       cliente.setComplemento("Prédio");
       cliente.setNumero("3001");
        
       PessoaBean pessoa = new PessoaBean();
       pessoa.setTelefone("99999999");
       pessoa.setNome("Jandira");
       pessoa.setSenha("321");
       pessoa.setEmail("jandira@gmail.com");
       pessoa.setCpf("11111111111");
        
       cliente.setPessoaBean(pessoa);
       
       ListaBean lista = new ListaBean();
       lista.setClienteBean(cliente);
       
       new ListaDAO().adicionarLista();
       
    }
    
}