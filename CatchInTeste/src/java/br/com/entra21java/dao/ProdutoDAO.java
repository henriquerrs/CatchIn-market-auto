package br.com.entra21java.dao;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */
public class ProdutoDAO {

    public List<ProdutoBean> obterProdutos() {

        List<ProdutoBean> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setPreco(resultset.getDouble("preco"));
                produto.setPeso(resultset.getDouble("peso"));
                produto.setQuantidade(resultset.getInt("quantidade"));
                produto.setMarca(resultset.getString("marca"));
                produto.setCategoria(resultset.getString("categoria"));
                produto.setDescricao(resultset.getString("descricao"));

                usuarios.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return usuarios;
    }

    public ProdutoBean obterProdutoPeloId(int id) {
        ProdutoBean produto = null;
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultset = ps.getResultSet();
            while (resultset.next()) {
                produto = new ProdutoBean();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setPreco(resultset.getDouble("preco"));
                produto.setPeso(resultset.getDouble("peso"));
                produto.setQuantidade(resultset.getInt("quantidade"));
                produto.setMarca(resultset.getString("marca"));
                produto.setCategoria(resultset.getString("categoria"));
                produto.setDescricao(resultset.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return produto;
    }

    public int adicionarProduto(ProdutoBean produto) {

        String sql = "INSERT INTO produtos (nome, preco, peso, quantidade, marca, categoria, descricao) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, produto.getNome());
            ps.setDouble(quantidade++, produto.getPreco());
            ps.setDouble(quantidade++, produto.getPeso());
            ps.setInt(quantidade++, produto.getQuantidade());
            ps.setString(quantidade++, produto.getMarca());
            ps.setString(quantidade++, produto.getCategoria());
            ps.setString(quantidade++, produto.getDescricao());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return -1;

    }

    public List<ProdutoBean> obterProdutosParaDataTable(String comeco, String quantidade, String busca,
            String ordemColuna, String ordemDirecao) {
        busca = '%' + busca + '%';
        List<ProdutoBean> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE nome LIKE ? OR marca LIKE ? ORDER BY " + ordemColuna + " " + ordemDirecao + " LIMIT " + comeco + ", " + quantidade;
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, busca);
            ps.setString(2, busca);
            ps.execute();
            ResultSet resultset = ps.getResultSet();
            while (resultset.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setPreco(resultset.getDouble("preco"));
                produto.setPeso(resultset.getDouble("peso"));
                produto.setQuantidade(resultset.getInt("quantidade"));
                produto.setMarca(resultset.getString("marca"));
                produto.setCategoria(resultset.getString("categoria"));
                produto.setDescricao(resultset.getString("descricao"));

                usuarios.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return usuarios;
    }

    public boolean excluirProduto(int id) {
        new ItemDAO().excluirItem(id);
        new ProdutoListaDAO().excluirItem(id);
        String sql = "DELETE FROM produtos WHERE id = ?;";
        String sql2 = "DELETE FROM itens WHERE id_produto = ?;";
        String sql3 = "DELETE FROM produto_lista WHERE id_produto = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql3);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps = Conexao.obterConexao().prepareStatement(sql2);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }

    public boolean alterarProduto(ProdutoBean produto) {
        String sql = "UPDATE produtos SET nome = ?,preco = ?, peso = ?, quantidade = ?, marca = ?, categoria = ?, descricao = ? WHERE id= ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            int quantidade = 1;
            ps.setString(quantidade++, produto.getNome());
            ps.setDouble(quantidade++, produto.getPreco());
            ps.setDouble(quantidade++, produto.getPeso());
            ps.setInt(quantidade++, produto.getQuantidade());
            ps.setString(quantidade++, produto.getMarca());
            ps.setString(quantidade++, produto.getCategoria());
            ps.setString(quantidade++, produto.getDescricao());
            ps.setInt(quantidade++, produto.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }

    public List<HashMap<String, Object>> obterTodosParaDataTable() {
        List<HashMap<String, Object>> listaProdutos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        if (Conexao.obterConexao() != null) {
            try {
                Statement statement = Conexao.obterConexao().createStatement();
                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    HashMap<String, Object> produtos = new HashMap<>();
                    produtos.put("nome", resultSet.getString("nome"));
                    produtos.put("preco", resultSet.getDouble("preco"));
                    produtos.put("marca", resultSet.getString("marca"));
                    listaProdutos.add(produtos);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Conexao.fecharConexao();
            }
        }
        return listaProdutos;
    }

    public int obterQuantidadeTotal() {
        String sql = "SELECT COUNT(id) AS 'quantidade' FROM produtos";
        int quantidadeTotal = 0;
        try {
            Statement st = Conexao.obterConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                quantidadeTotal = rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return quantidadeTotal;
    }

    public int obterQuantidadeFiltrada(String busca) {
        String sql = "SELECT COUNT(id) AS 'quantidade' FROM produtos WHERE nome LIKE ? OR marca LIKE ?";
        busca = '%' + busca + '%';
        int quantidadeFiltrada = 0;
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, busca);
            ps.setString(2, busca);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantidadeFiltrada = rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return quantidadeFiltrada;
    }


    public ProdutoBean buscarIdProduto(int id){
        ProdutoBean produto = null;
        String sql = "SELECT * FROM produtos WHERE id=?";
        try {
            PreparedStatement st = Conexao.obterConexao().prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            ResultSet resultset = st.getResultSet();
            if(resultset.next()) {
                produto = new ProdutoBean();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setPreco(resultset.getDouble("preco"));
                produto.setPeso(resultset.getDouble("peso"));
                produto.setQuantidade(resultset.getInt("quantidade"));
                produto.setMarca(resultset.getString("marca"));
                produto.setCategoria(resultset.getString("categoria"));                
                produto.setDescricao(resultset.getString("descricao"));         
                
                return produto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return produto;
    }
        
}
