package br.com.entra21java.dao;

import br.com.entra21java.bean.ColaboradorBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crispim Paiano dos Santos
 */
public class ColaboradorDAO {
    
    public List<ColaboradorBean> obterCliente() {

        List<ColaboradorBean> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM colaboradoes cb JOIN pessoas ps ON cb.id_pessoas = ps.id";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                ColaboradorBean funcionario = new ColaboradorBean();
                funcionario.setId(resultset.getInt("cl.id"));
                funcionario.setCargo(resultset.getString("cl.endereco"));
                funcionario.setIdPessoa(resultset.getInt("cl.id_privilegios"));

                PessoaBean pessoa = new PessoaBean();
                pessoa.setId(resultset.getInt("ps.id"));
                pessoa.setNome(resultset.getString("ps.nome"));
                pessoa.setSenha(resultset.getString("ps.senha"));
                pessoa.setEmail(resultset.getString("ps.email"));
                pessoa.setCpf(resultset.getString("ps.cpf"));
                pessoa.setIdade(resultset.getByte("ps.idade"));
                pessoa.setTelefone(resultset.getString("ps.telefone"));
                pessoa.setIdPrivilegio(resultset.getInt("ps.id_privilegios"));
                funcionario.setPessoaBean(pessoa);

                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return funcionarios;
    }

    public int adicionarCliente(ColaboradorBean funcionario) {

        String sql = "INSERT INTO pessoas (nome,senha,email,cpf,idade,telefone,id_privilegios) VALUES (?,?,?,?,?,?,3);"
                + "INSERT INTO colaboradores (cargo, id_pessoas) VALUES (?,?);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, funcionario.getPessoaBean().getNome());
            ps.setString(quantidade++, funcionario.getPessoaBean().getSenha());
            ps.setString(quantidade++, funcionario.getPessoaBean().getEmail());
            ps.setString(quantidade++, funcionario.getPessoaBean().getCpf());
            ps.setByte(quantidade++, funcionario.getPessoaBean().getIdade());
            ps.setString(quantidade++, funcionario.getPessoaBean().getTelefone());
            ps.setString(quantidade++, funcionario.getCargo());

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {

                ps.setInt(quantidade++, resultSet.getInt(1));
                ps.execute();
                resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1); 
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return -1;

    }
    
    public boolean excluirCliente(int id){
        String sql = "DELETE FROM colaboradores WHERE id = ?";
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
    
    public boolean alterar(ColaboradorBean funcionario) {
        String sql = "UPDATE colaboradores cb JOIN pessoas ps ON cb.id_pessoas = ps.id SET cb.cargo = ?, "
                + "cb.id_pessoas = ?, ps.nome = ?, ps.senha = ?, ps.email = ?, ps.cpf = ?, ps.idade = ?,"
                + " ps.telefone = ?, ps.id_privilegios = ? WHERE cb.id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            int quantidade = 1;
            ps.setString(quantidade++, funcionario.getCargo());
            ps.setInt(quantidade++, funcionario.getIdPessoa());
            ps.setString(quantidade++, funcionario.getPessoaBean().getNome());
            ps.setString(quantidade++, funcionario.getPessoaBean().getSenha());
            ps.setString(quantidade++, funcionario.getPessoaBean().getEmail());
            ps.setString(quantidade++, funcionario.getPessoaBean().getCpf());
            ps.setByte(quantidade++, funcionario.getPessoaBean().getIdade());
            ps.setString(quantidade++, funcionario.getPessoaBean().getTelefone());
            ps.setInt(quantidade++, funcionario.getPessoaBean().getIdPrivilegio());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }
    
}
