package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.CompraBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */
public class CompraDAO {

    public List<CompraBean> obterCompras() {
        List<CompraBean> compras = new ArrayList<>();
        String sql = "SELECT * FROM compras cp JOIN clientes cl ON cp.id = cl.id_compra JOIN pessoas ps ON ps.id = cl.id_pessoa WHERE cp.status = 1";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                CompraBean compra = new CompraBean();
                compra.setId(resultSet.getInt("cp.id"));
                compra.setTotal(resultSet.getDouble("cp.total"));
                compra.setStatus(resultSet.getInt("cp.status"));
                
                ClienteBean cliente =  new ClienteBean();
                cliente.setLogradouro(resultSet.getString("cl.logradouro"));
                
                PessoaBean pessoa = new PessoaBean();
                pessoa.setNome(resultSet.getString("ps.nome"));
                cliente.setPessoaBean(pessoa);
                compra.setCliente(cliente);
                
                compra.setItens(new ItemDAO().obterItensPeloIdCompra(compra.getId()));

                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return compras;
    }
    
    public int entregarCompra(int idCompra){
        int compra = -1;
        new CompraDAO().atualizarCompra(idCompra);
        String sql = "UPDATE compras SET status = 1 WHERE id=?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return compra;
    }
    
    public int finalizarCompra(int idCompra){
        int compra = -1;
        new ItemDAO().excluirCompra(idCompra);
        String sql = "UPDATE compras SET status = 0 WHERE id=?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return compra;
    }
    
    public int statusCompra(int idCompra){
        int compra = -1;
        String sql = "SELECT status FROM compras WHERE id = ?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                return resultSet.getInt("status");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return compra;
    }

    public int criarCompra() {

        String sql = "INSERT INTO compras (total, status) VALUES (0,0);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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

    public String atualizarTotal(int idCompra) {
        String sql = "SELECT CONCAT(\"R$ \", ROUND(SUM(it.quantidade*pr.preco), 2)) \n"
                + "FROM itens it \n"
                + "JOIN produtos pr ON pr.id = it.id_produto \n"
                + "WHERE it.id_compra = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next() && resultSet.getString(1) != null) {
                return resultSet.getString(1).replace(".", ",");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return "R$ 0,00";
    }
    
    public int atualizarCompra(int idCompra){
        int compra = -1;
        double soma = new CompraDAO().somarTotalCompra(idCompra);
        String sql = "UPDATE compras SET total = ? WHERE id=?;";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, soma);
            ps.setInt(2, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return compra;
    }
    
    public double somarTotalCompra(int idCompra) {
        String sql = "SELECT ROUND((it.quantidade*pr.preco),2) FROM itens it JOIN produtos pr ON pr.id = it.id_produto WHERE it.id_compra = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return -1;
    }

    public CompraBean buscarPeloId(int id){
        CompraBean compra = null;
        String sql = "SELECT * FROM produtos WHERE id=?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                compra = new CompraBean();
                compra.setId(resultSet.getInt("cp.id"));
                compra.setIdClientes(resultSet.getInt("cp.id_cliente"));
                compra.setTotal(resultSet.getDouble("cp.total"));

                ClienteBean cliente = new ClienteBean();
                cliente.setIdPessoa(resultSet.getInt("cl.nome"));
                cliente.setCep(resultSet.getString("cl.cep"));
                cliente.setLogradouro(resultSet.getString("cl.logradouro"));
                cliente.setComplemento(resultSet.getString("cl.complemento"));
                cliente.setBairro(resultSet.getString("cl.bairro"));
                cliente.setCidade(resultSet.getString("cl.cidade"));
                cliente.setUf(resultSet.getString("cl.uf"));
                cliente.setNumero(resultSet.getString("cl.numero"));
                compra.setCliente(cliente);

                compra.setItens(new ItemDAO().obterItensPeloIdCompra(compra.getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return compra;
    }

}
