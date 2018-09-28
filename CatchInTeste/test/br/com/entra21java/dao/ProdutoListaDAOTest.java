package br.com.entra21java.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.CompraBean;
import br.com.entra21java.bean.ItemBean;
import br.com.entra21java.bean.ListaBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.bean.ProdutoListaBean;
import br.com.entra21java.database.Conexao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Reis
 */
public class ProdutoListaDAOTest {

    /**
     * Test of obterItensPeloIdLista method, of class ProdutoListaDAO.
     */
    @Test
    public void testObterItensPeloIdLista() {
        Conexao.truncate();

        List<ProdutoListaBean> produtoLista = new ArrayList<>();

        List<ItemBean> itens = new ArrayList<>();

        ItemBean item = new ItemBean();
        item.setQuantidade(6);

        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);

        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");

        item.setProduto(produto);

        itens.add(item);

        produtoItem.setProdutoBean(produto);

        ListaBean lista = new ListaBean();

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

        lista.setClienteBean(cliente);

        int i = new ListaDAO().adicionarLista();
        lista.setId(i);

        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra);

        new ProdutoListaDAO().obterItensPeloIdLista(i);

    }

    /**
     * Test of obterIdDaLista method, of class ProdutoListaDAO.
     */
    @Test
    public void testObterIdDaLista() {
        Conexao.truncate();

        List<ProdutoListaBean> produtoLista = new ArrayList<>();

        List<ItemBean> itens = new ArrayList<>();

        ItemBean item = new ItemBean();
        item.setQuantidade(6);

        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);

        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");

        item.setProduto(produto);

        itens.add(item);

        produtoItem.setProdutoBean(produto);

        ListaBean lista = new ListaBean();

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

        lista.setClienteBean(cliente);

        int i = new ListaDAO().adicionarLista();
        lista.setId(i);

        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra);
        
        new ProdutoListaDAO().obterIdDaLista(i);

    }

    /**
     * Test of adicionarLista method, of class ProdutoListaDAO.
     */
    @Test
    public void testAdicionarLista() {
        Conexao.truncate();
        
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
          
        List<ItemBean> itens = new ArrayList<>();
          
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);
          
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
          
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
          
        itens.add(item);
          
        produtoItem.setProdutoBean(produto);
          
        ListaBean lista = new ListaBean();
          
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
         
        lista.setClienteBean(cliente);
          
        int j = new ListaDAO().adicionarLista();
        lista.setId(j);
        
        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra);
        
        new ProdutoListaDAO().adicionarLista(j, i, 100);
        
    }

    /**
     * Test of verificarProdutoCadastrado method, of class ProdutoListaDAO.
     */
    @Test
    public void testVerificarProdutoCadastrado() {
        Conexao.truncate();
        
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
          
        List<ItemBean> itens = new ArrayList<>();
          
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);
          
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
          
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
          
        itens.add(item);
          
        produtoItem.setProdutoBean(produto);
          
        ListaBean lista = new ListaBean();
          
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
         
        lista.setClienteBean(cliente);
          
        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        int j= new CompraDAO().criarCompra();
        compra.setId(j);
        
        compras.add(compra);
        
        new ProdutoListaDAO().verificarProdutoCadastrado(j, i);
        
    }

    /**
     * Test of atualizarCompra method, of class ProdutoListaDAO.
     */
    @Test
    public void testAtualizarCompra() {
        Conexao.truncate();
        
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
          
        List<ItemBean> itens = new ArrayList<>();
          
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);
          
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
          
        item.setProduto(produto);
        
        int i = new ProdutoDAO().adicionarProduto(produto);
        produto.setId(i);
          
        itens.add(item);
          
        produtoItem.setProdutoBean(produto);
          
        ListaBean lista = new ListaBean();
          
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
         
        lista.setClienteBean(cliente);
          
        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra);
        
    }

    /**
     * Test of excluirItem method, of class ProdutoListaDAO.
     */
    @Test
    public void testExcluirItem() {
        Conexao.truncate();
        
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
          
        List<ItemBean> itens = new ArrayList<>();
          
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);
          
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
          
        item.setProduto(produto);
        
        itens.add(item);
          
        produtoItem.setProdutoBean(produto);
          
        ListaBean lista = new ListaBean();
          
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
         
        lista.setClienteBean(cliente);
          
        produtoItem.setListaBean(lista);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra); 
        
        int i = new CompraDAO().criarCompra();
        compra.setId(i);
        
        new ProdutoListaDAO().excluirItem(i);
        
    }

    /**
     * Test of passarParaCarrinho method, of class ProdutoListaDAO.
     */
    @Test
    public void testPassarParaCarrinho() {
        Conexao.truncate();
        
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
          
        List<ItemBean> itens = new ArrayList<>();
          
        ItemBean item = new ItemBean();
        item.setQuantidade(6);
        
        ProdutoListaBean produtoItem = new ProdutoListaBean();
        produtoItem.setQuantidade(100);
          
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("Achocolatado Nescau");
        produto.setMarca("Néstle");
        produto.setPreco(6.89);
        produto.setCategoria("Mercearia");
        produto.setPeso(0.4);
        produto.setQuantidade(88);
        produto.setDescricao("Melhor que TODDY");
          
        item.setProduto(produto);
        
        itens.add(item);
          
        produtoItem.setProdutoBean(produto);
          
        ListaBean lista = new ListaBean();
          
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
         
        lista.setClienteBean(cliente);
          
        produtoItem.setListaBean(lista);
        
        int i = new ListaDAO().adicionarLista();
        lista.setId(i);
        
        List<CompraBean> compras = new ArrayList<>();
        
        CompraBean compra = new CompraBean();
        compra.setItens(itens);
        compra.setTotal(10.74);
        
        compras.add(compra); 
        
        int j = new CompraDAO().criarCompra();
        compra.setId(j);
        
        new ProdutoListaDAO().passarParaCarrinho(i, j);
        
    }

}