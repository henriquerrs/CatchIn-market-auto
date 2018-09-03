package br.com.entra21java.dao;

import br.com.entra21java.bean.PessoaBean;
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
public class PessoaDAO {

    public List<PessoaBean> ObterUsuario() {
        List<PessoaBean> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas ps JOIN privilegios pi ON ps.id_privilegio = pi.id;";
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
                pessoa.setIdPrivilegio(resultSet.getInt("ps.id_privilegio"));

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

    public int adicionarPessoa(PessoaBean pessoa) {

        String sql = "INSERT INTO pessoas (nome,senha,email,cpf,idade,telefone,id_privilegio) VALUES (?,?,?,?,?,?,4);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, pessoa.getNome());
            ps.setString(quantidade++, pessoa.getSenha());
            ps.setString(quantidade++, pessoa.getEmail());
            ps.setString(quantidade++, pessoa.getCpf());
            ps.setByte(quantidade++, pessoa.getIdade());
            ps.setString(quantidade++, pessoa.getTelefone());
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

    public PessoaBean verificarLogin(String login, String senha) {
        String sql = "SELECT id FROM pessoas WHERE email = ? AND senha = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return obterPeloId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return null;
    }

    private PessoaBean obterPeloId(int id) {
        PessoaBean pessoa = null;
        String sql = "SELECT * FROM pessoas ps JOIN privilegios pi ON (ps.id_privilegio = pi.id) WHERE ps.id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                pessoa = new PessoaBean();
                pessoa.setId(resultSet.getInt("ps.id"));
                pessoa.setNome(resultSet.getString("ps.nome"));
                pessoa.setSenha(resultSet.getString("ps.senha"));
                pessoa.setEmail(resultSet.getString("ps.email"));
                pessoa.setCpf(resultSet.getString("ps.cpf"));
                pessoa.setIdade(resultSet.getByte("ps.idade"));
                pessoa.setTelefone(resultSet.getString("ps.telefone"));
                pessoa.setIdPrivilegio(resultSet.getInt("ps.id_privilegio"));

                PrivilegioBean privilegio = new PrivilegioBean();
                privilegio.setId(resultSet.getInt("pi.id"));
                privilegio.setTipo(resultSet.getString("pi.tipo"));
                pessoa.setPrivilegioBean(privilegio);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return pessoa;
    }

}
