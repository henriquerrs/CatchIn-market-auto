package br.com.entra21java.dao;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.PessoaBean;
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
public class ClienteDAO {

    public List<ClienteBean> obterCliente() {

        List<ClienteBean> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes cl JOIN pessoas ps ON cl.id_pessoa = ps.id";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                ClienteBean usuario = new ClienteBean();
                usuario.setId(resultset.getInt("cl.id"));
                usuario.setEndereco(resultset.getString("cl.endereco"));
                usuario.setIdPessoa(resultset.getInt("cl.id_privilegio"));

                PessoaBean pessoa = new PessoaBean();
                pessoa.setId(resultset.getInt("ps.id"));
                pessoa.setNome(resultset.getString("ps.nome"));
                pessoa.setSenha(resultset.getString("ps.senha"));
                pessoa.setEmail(resultset.getString("ps.email"));
                pessoa.setCpf(resultset.getString("ps.cpf"));
                pessoa.setIdade(resultset.getByte("ps.idade"));
                pessoa.setTelefone(resultset.getString("ps.telefone"));
                pessoa.setIdPrivilegio(resultset.getInt("ps.id_privilegio"));
                usuario.setPessoaBean(pessoa);

                clientes.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return clientes;
    }

    public int adicionarCliente(ClienteBean cliente) {

        String sql = "INSERT INTO clientes (endereco, id_compra, id_pessoa) VALUES (?,?,?);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            int idCompra = new CompraDAO().criarCompra();
            int idPessoa = new PessoaDAO().adicionarPessoa(cliente.getPessoaBean());
            ps.setString(quantidade++, cliente.getEndereco());
            ps.setInt(quantidade++, idCompra);
            ps.setInt(quantidade++, idPessoa);
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

    public boolean excluirCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }

    public boolean alterar(ClienteBean cliente) {
        String sql = "UPDATE clientes cl JOIN pessoas ps ON cl.id_pessoa = ps.id SET cl.endereco = ?, "
                + "cl.id_pessoa = ?, ps.nome = ?, ps.senha = ?, ps.email = ?, ps.cpf = ?, ps.idade = ?,"
                + " ps.telefone = ?, ps.id_privilegio = ? WHERE cl.id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            int quantidade = 1;
            ps.setString(quantidade++, cliente.getEndereco());
            ps.setInt(quantidade++, cliente.getIdPessoa());
            ps.setString(quantidade++, cliente.getPessoaBean().getNome());
            ps.setString(quantidade++, cliente.getPessoaBean().getSenha());
            ps.setString(quantidade++, cliente.getPessoaBean().getEmail());
            ps.setString(quantidade++, cliente.getPessoaBean().getCpf());
            ps.setByte(quantidade++, cliente.getPessoaBean().getIdade());
            ps.setString(quantidade++, cliente.getPessoaBean().getTelefone());
            ps.setInt(quantidade++, cliente.getPessoaBean().getIdPrivilegio());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }

    public ClienteBean obterPeloIdPessoa(int id) {

        String sql = "SELECT * FROM clientes cl JOIN pessoas ps ON cl.id_pessoa = ps.id WHERE cl.id_pessoa = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultset = ps.getResultSet();
            if (resultset.next()) {
                ClienteBean cliente = new ClienteBean();
                cliente.setId(resultset.getInt("cl.id"));
                cliente.setEndereco(resultset.getString("cl.endereco"));
                cliente.setIdPessoa(resultset.getInt("cl.id_pessoa"));

                PessoaBean pessoa = new PessoaBean();
                pessoa.setId(resultset.getInt("ps.id"));
                pessoa.setNome(resultset.getString("ps.nome"));
                pessoa.setSenha(resultset.getString("ps.senha"));
                pessoa.setEmail(resultset.getString("ps.email"));
                pessoa.setCpf(resultset.getString("ps.cpf"));
                pessoa.setIdade(resultset.getByte("ps.idade"));
                pessoa.setTelefone(resultset.getString("ps.telefone"));
                pessoa.setIdPrivilegio(resultset.getInt("ps.id_privilegio"));
                cliente.setPessoaBean(pessoa);
                return cliente;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return null;
    }

}
