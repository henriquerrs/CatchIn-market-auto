package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.CompraBean;
import br.com.entra21java.database.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
