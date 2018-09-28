/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.CompraBean;
import br.com.entra21java.bean.ItemBean;
import br.com.entra21java.bean.PessoaBean;
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
public class CompraDAOTest {
    
    /**
     * Test of obterCompras method, of class CompraDAO.
     */
    @Test
    public void obterCompras() {
        Conexao.truncate();
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setTelefone("(47) 9999-9999");
        pessoa.setNome("Jandira");
        pessoa.setSenha("321");
        pessoa.setEmail("jandira@gmail.com");
        pessoa.setCpf("11111111111");
        
        byte age = 23;
        pessoa.setIdade(age);
        
        ClienteBean cliente = new ClienteBean();
        cliente.setPessoaBean(pessoa);
        
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
        
        itens.add(item);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
        compras.add(compra);
        
        assertEquals(1, i);
        
    }

    /**
     * Test of criarCompra method, of class CompraDAO.
     */
    @Test
    public void criarCompra() {
        Conexao.truncate();
         
        PessoaBean pessoa = new PessoaBean();
        pessoa.setTelefone("(47) 9999-9999");
        pessoa.setNome("Jandira");
        pessoa.setSenha("321");
        pessoa.setEmail("jandira@gmail.com");
        pessoa.setCpf("11111111111");
        
        byte age = 23;
        pessoa.setIdade(age);
        
        ClienteBean cliente = new ClienteBean();
        cliente.setPessoaBean(pessoa);
        
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
        
        itens.add(item);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        new CompraDAO().criarCompra();
        
        compras.add(compra);
        
    }

    /**
     * Test of atualizarTotal method, of class CompraDAO.
     */
    @Test
    public void atualizarTotal() {
        Conexao.truncate();
         
        PessoaBean pessoa = new PessoaBean();
        pessoa.setTelefone("(47) 9999-9999");
        pessoa.setNome("Jandira");
        pessoa.setSenha("321");
        pessoa.setEmail("jandira@gmail.com");
        pessoa.setCpf("11111111111");
        
        byte age = 23;
        pessoa.setIdade(age);
        
        ClienteBean cliente = new ClienteBean();
        cliente.setPessoaBean(pessoa);
        
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
        
        itens.add(item);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
        compras.add(compra);
        
        item.setQuantidade(10);
        
        compra.setTotal(17.90);
        
        new CompraDAO().atualizarTotal(i);
    }

    /**
     * Test of buscarPeloId method, of class CompraDAO.
     */
    @Test
    public void buscarPeloId() {
        Conexao.truncate();
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setTelefone("(47) 9999-9999");
        pessoa.setNome("Jandira");
        pessoa.setSenha("321");
        pessoa.setEmail("jandira@gmail.com");
        pessoa.setCpf("11111111111");
        
        byte age = 23;
        pessoa.setIdade(age);
        
        ClienteBean cliente = new ClienteBean();
        cliente.setPessoaBean(pessoa);
        
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
        
        itens.add(item);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
        compras.add(compra);
            
        new CompraDAO().buscarPeloId(i);
        
    }
    
}