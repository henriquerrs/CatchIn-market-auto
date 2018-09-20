package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.CompraBean;
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
        String sql = "SELECT * FROM compras cp "
                + "JOIN clientes cl ON cp.id_cliente = cl.id ";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                CompraBean compra = new CompraBean();
                compra.setId(resultSet.getInt("cp.id"));
                compra.setIdClientes(resultSet.getInt("cp.id_cliente"));
                compra.setTotal(resultSet.getDouble("cp.total"));
                
                ClienteBean cliente = new ClienteBean();
                cliente.setIdPessoa(resultSet.getInt("cl.nome"));
                cliente.setEndereco(resultSet.getString("cl.endereco"));
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
    
    public int criarCompra() {
        
        String sql = "INSERT INTO compras (total) VALUES (0);";
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
            if (resultSet.next()) {
                return resultSet.getString(1).replace(".", ",");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return "R$ 0,00";
    }
    
}
