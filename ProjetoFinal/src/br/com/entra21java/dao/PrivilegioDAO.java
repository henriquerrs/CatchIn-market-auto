package br.com.entra21java.dao;

import br.com.entra21java.bean.PrivilegioBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */
public class PrivilegioDAO {
   
    public List<PrivilegioBean> obterPrivilegio(){
        
        List<PrivilegioBean> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM privilegios";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                PrivilegioBean usuario = new PrivilegioBean();
                usuario.setId(resultset.getInt("id"));
                usuario.setTipo(resultset.getString("tipo"));              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return usuarios;
    }
    
    public int adicionarPrivilegio(PrivilegioBean usuario){
        
        String sql = "INSERT INTO privilegios (tipo, nome, senha, email, idade, cpf) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++,usuario.getTipo());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }return -1;
        
    }
    
    public boolean excluirPrivilegio(int id){
        String sql = "DELETE FROM privilegios WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return false;
    }
    
}
