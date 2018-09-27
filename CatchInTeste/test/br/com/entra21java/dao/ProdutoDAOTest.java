/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.database.Conexao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Reis
 */
public class ProdutoDAOTest {

    /**
     * Test of obterProdutos method, of class ProdutoDAO.
     */
    @Test
    public void obter() {
        Conexao.truncate();
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        System.out.println("Resultado ID: "+i);

        assertEquals(i, 1);
    }

    /**
     * Test of adicionarProduto method, of class ProdutoDAO.
     */
    @Test
    public void adicionar() {
        Conexao.truncate();
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.400);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        System.out.println("Resultado ID: "+i);
        
        assertEquals(i, 1);
        
    }

    /**
     * Test of excluirProduto method, of class ProdutoDAO.
     */
    @Test
    public void excluir() {
        Conexao.truncate();
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.400);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        new ProdutoDAO().excluirProduto(i);

        assertNull(new ProdutoDAO().buscarIdProduto(i));
         
    }

    /**
     * Test of alterarProduto method, of class ProdutoDAO.
     */
    @Test
    public void alterar() {
        Conexao.truncate();
        
        ProdutoBean produto = new ProdutoBean(); 
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.400);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
        
        produto.setNome("Barra de Chocolate");
        produto.setMarca("Lacta");
        produto.setPreco(4.99);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.200);
        produto.setQuantidade(100);
        produto.setDescricao("Delicious");
        
        new ProdutoDAO().alterarProduto(produto);
        
    }

    /**
     * Test of obterTodosParaDataTable method, of class ProdutoDAO.
     */
    @Test
    public void testObterTodosParaDataTable() {
        Conexao.truncate();
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.400);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
    }
    
}