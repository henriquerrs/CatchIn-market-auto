package br.com.entra21java.dao;

import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.bean.PrivilegioBean;
import br.com.entra21java.database.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */
public class PessoaDAO {
    
    public List<PessoaBean> ObterUsuario(){
        List<PessoaBean> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas ps JOIN privilegios pi ON ps.id_privilegios = pi.id;";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                PessoaBean pessoa = new PessoaBean();
                pessoa.setId(resultSet.getInt("ps.id"));
                pessoa.setNome(resultSet.getString("ps.nome"));
                pessoa.setSenha(resultSet.getString("ps.senha"));
                pessoa.setEmail(resultSet.getString("ps.email"));
                pessoa.setCpf(resultSet.getString("ps.cpf"));
                pessoa.setIdade(resultSet.getByte("ps.idade"));
                pessoa.setTelefone(resultSet.getString("ps.telefone"));
                pessoa.setIdPrivilegio(resultSet.getInt("ps.id_privilegios"));
                
                PrivilegioBean privilegio = new PrivilegioBean();
                privilegio.setId(resultSet.getInt("pi.id"));
                privilegio.setTipo(resultSet.getString("pi.tipo"));
                pessoa.setPrivilegioBean(privilegio);
                
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return pessoas;
    }
    
}
