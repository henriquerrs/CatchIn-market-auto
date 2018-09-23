package br.com.entra21java.dao;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.bean.ProdutoListaBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crispim Paiano dos Santos
 */
public class ProdutoListaDAO {
    
    public List<ProdutoListaBean> obterItensPeloIdLista(int idLista) {
        List<ProdutoListaBean> produtoLista = new ArrayList<>();
        String sql = "SELECT * FROM produto_lista it JOIN produtos pr ON (it.id_produto = pr.id) WHERE it.id_lista = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idLista);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                ProdutoListaBean produtoItem = new ProdutoListaBean();
                produtoItem.setId(resultSet.getInt("it.id"));
                produtoItem.setQuantidade(resultSet.getInt("it.quantidade"));
                produtoItem.setIdLista(resultSet.getInt("it.id_lista"));
                produtoItem.setIdProduto(resultSet.getInt("it.id_produto"));

                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultSet.getInt("pr.id"));
                produto.setNome(resultSet.getString("pr.nome"));
                produto.setPreco(resultSet.getDouble("pr.preco"));
                produto.setPeso(resultSet.getDouble("pr.peso"));
                produto.setQuantidade(resultSet.getInt("pr.quantidade"));
                produto.setMarca(resultSet.getString("pr.marca"));
                produto.setCategoria(resultSet.getString("pr.categoria"));
                produto.setDescricao(resultSet.getString("pr.descricao"));
                
                produtoItem.setProdutoBean(produto);
                produtoLista.add(produtoItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        
        return produtoLista;
    }
    
    public int obterIdDaLista(int idLista) {
        int itens = 0;
        String sql = "SELECT it.id_lista, ps.id FROM produto_lista it "
                + "JOIN listas cp ON it.id_lista = cp.id "
                + "JOIN clientes cl ON cl.id = cp.id_cliente "
                + "JOIN pessoas ps ON ps.id = cl.id_pessoa "
                + "WHERE ps.id = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idLista);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                itens = resultSet.getInt("it.id_lista");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        
        return itens;
    }
    
    public String adicionarLista(int idLista, int idProduto, int quantidade) {
        String status = "";
        
        int quantidadeCadastrado = verificarProdutoCadastrado(idLista, idProduto);
        if(quantidadeCadastrado>0){
            atualizarCompra(idLista, idProduto, quantidadeCadastrado, quantidade);
            return status = "atualizado";
        };
        
        String sql = "INSERT INTO produto_lista (quantidade,id_lista,id_produto) VALUES (?,?,?);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quantidade);
            ps.setInt(2, idLista);
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
        String sql = "SELECT quantidade FROM produto_lista WHERE id_lista = ? AND id_produto = ?";
        
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
        String sql = "UPDATE produto_lista SET quantidade = ?+? WHERE id_lista = ? AND id_produto = ?";
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
        String sql = "DELETE FROM produto_lista WHERE id = ?";
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
    
    public boolean passarParaCarrinho(int idLista, int idCompra){
        List<ProdutoListaBean> produtos = new ProdutoListaDAO().obterItensPeloIdLista(idLista);
        try {
            for (ProdutoListaBean produto : produtos) {
                int quantidade = produto.getQuantidade();
                int idProduto = produto.getIdProduto();
                new ItemDAO().adicionarCompra(idCompra,idProduto,quantidade);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return false;
    }
    
}
