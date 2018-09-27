/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.ItemBean;
import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class ItemDAO {

    public List<ItemBean> obterItensPeloIdCompra(int idCompra) {
        List<ItemBean> itens = new ArrayList<>();
        String sql = "SELECT * FROM itens it JOIN produtos pr ON (it.id_produto = pr.id) WHERE it.id_compra = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                ItemBean item = new ItemBean();
                item.setId(resultSet.getInt("it.id"));
                item.setQuantidade(resultSet.getInt("it.quantidade"));
                item.setIdCompra(resultSet.getInt("it.id_compra"));
                item.setIdProduto(resultSet.getInt("it.id_produto"));

                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultSet.getInt("pr.id"));
                produto.setNome(resultSet.getString("pr.nome"));
                produto.setPreco(resultSet.getDouble("pr.preco"));
                produto.setPeso(resultSet.getDouble("pr.peso"));
                produto.setQuantidade(resultSet.getInt("pr.quantidade"));
                produto.setMarca(resultSet.getString("pr.marca"));
                produto.setCategoria(resultSet.getString("pr.categoria"));
                produto.setDescricao(resultSet.getString("pr.descricao"));
                
                item.setProduto(produto);
                itens.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        
        return itens;
    }
    
    public int obterIdDaCompra(int idCompra) {
        int itens = 0;
        String sql = "SELECT it.id_compra, ps.id FROM itens it JOIN compras cp ON it.id_compra = cp.id JOIN clientes cl ON cl.id = cp.id_cliente JOIN pessoas ps ON ps.id = cl.id_pessoa WHERE ps.id = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                itens = resultSet.getInt("it.id_compra");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        
        return itens;
    }
    
    public String adicionarCompra(int idCompra, int idProduto, int quantidade) {
        String status = "";
        int quantidadeCadastrado = verificarProdutoCadastrado(idCompra, idProduto);
        if(quantidadeCadastrado>0){
            atualizarCompra(idCompra, idProduto, quantidadeCadastrado, quantidade);
            return status = "atualizado";
        };
        
        String sql = "INSERT INTO itens (quantidade,id_compra,id_produto) VALUES (?,?,?);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quantidade);
            ps.setInt(2, idCompra);
            ps.setInt(3, idProduto);
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return status = "sucesso";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return status = "fracassado";

    }
    
    public int verificarProdutoCadastrado(int idCompra, int idProduto){
        String sql = "SELECT quantidade FROM itens WHERE id_compra = ? AND id_produto = ?";
        
        try {
            PreparedStatement ps =Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.setInt(2, idProduto);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return 0;
    }
    
    public void atualizarCompra(int idCompra, int idProduto, int quantidadeCadastrado, int quantidade){
        String sql = "UPDATE itens SET quantidade = ?+? WHERE id_compra = ? AND id_produto = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quantidadeCadastrado);
            ps.setInt(2, quantidade);
            ps.setInt(3, idCompra);
            ps.setInt(4, idProduto);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        
    }
    
    public boolean excluirItem(int idItem){
        String sql = "DELETE FROM itens WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idItem);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }
    
    public boolean excluirCompra(int idCompra){
        String sql = "DELETE FROM itens WHERE id_compra = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }
    
}
