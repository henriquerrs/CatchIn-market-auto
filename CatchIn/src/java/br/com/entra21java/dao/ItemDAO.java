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
        String sql = "SELECT * FROM itens it WHERE it.id_compra = ? JOIN produtos pr(it.id_produto = pr.id)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                ItemBean item = new ItemBean();
                item.setId(resultSet.getInt("it.id"));
                item.setQuantidade(resultSet.getInt("it.quantidade"));
                item.setIdCompras(resultSet.getInt("it.id_compra"));
                item.setIdProdutos(resultSet.getInt("it.id_produtos"));

                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultSet.getInt("pr.id"));
                produto.setNome(resultSet.getString("pr.nome"));
                produto.setPreco(resultSet.getDouble("pr.preco"));
                produto.setPeso(resultSet.getDouble("pr.peso"));
                produto.setQuantidade(resultSet.getInt("pr.quantidade"));
                produto.setMarca(resultSet.getString("pr.marca"));
                produto.setCategoria(resultSet.getString("pr.cpf"));
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
}
