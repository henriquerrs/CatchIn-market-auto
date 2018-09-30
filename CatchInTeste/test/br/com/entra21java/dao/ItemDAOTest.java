/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.CompraBean;
import br.com.entra21java.bean.ItemBean;
import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.database.Conexao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Reis
 */
public class ItemDAOTest {
    
    /**
     * Test of obterItensPeloIdCompra method, of class ItemDAO.
     */
    @Test
    public void obterIdItem() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
        assertEquals(itens, new ItemDAO().obterItensPeloIdCompra(i));
        
    }

    /**
     * Test of obterIdDaCompra method, of class ItemDAO.
     */
    @Test
    public void obterIdCompra() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
    }

    /**
     * Test of adicionarCompra method, of class ItemDAO.
     */
    @Test
    public void adicionarCompra() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
    }

    /**
     * Test of verificarProdutoCadastrado method, of class ItemDAO.
     */
    @Test
    public void testVerificarProdutoCadastrado() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int j = new CompraDAO().criarCompra();
        compra.setId(j);
        
        new ItemDAO().verificarProdutoCadastrado(j, i);
        
    }

    /**
     * Test of atualizarCompra method, of class ItemDAO.
     */
    @Test
    public void testAtualizarCompra() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int j = new CompraDAO().criarCompra();
        compra.setId(j);
        
        new ItemDAO().atualizarCompra(j, i, 100, 8);
        
    }

    /**
     * Test of excluirItem method, of class ItemDAO.
     */
    @Test
    public void testExcluirItem() {
        Conexao.truncate();
        
        List<ItemBean> itens = new ArrayList<>();
        
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Caldo de Galinha Balance");
        produto.setMarca("Knorr");
        produto.setPeso(57);
        produto.setPreco(1.79);
        produto.setQuantidade(100);
        produto.setCategoria("Molhos e Condimentos");
        produto.setDescricao("Faz as comida ter gosto");
        
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        new ItemDAO().excluirItem(i);
        
    }
    
}