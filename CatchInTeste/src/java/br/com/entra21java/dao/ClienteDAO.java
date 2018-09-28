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
                usuario.setIdPessoa(resultset.getInt("cl.nome"));
                usuario.setCep(resultset.getString("cl.cep"));
                usuario.setLogradouro(resultset.getString("cl.logradouro"));
                usuario.setComplemento(resultset.getString("cl.complemento"));
                usuario.setBairro(resultset.getString("cl.bairro"));
                usuario.setCidade(resultset.getString("cl.cidade"));
                usuario.setUf(resultset.getString("cl.uf"));
                usuario.setNumero(resultset.getString("cl.numero"));
                usuario.setIdPessoa(resultset.getInt("cl.id_privilegio"));
                usuario.setIdLista(resultset.getInt("cl.id_lista"));

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

        String sql = "INSERT INTO clientes (id_compra, id_lista, id_pessoa, cep,logradouro,complemento,bairro,cidade,uf,numero) VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            int idCompra = new CompraDAO().criarCompra();
            int idLista = new ListaDAO().adicionarLista();
            int idPessoa = new PessoaDAO().adicionarPessoa(cliente.getPessoaBean());
            ps.setInt(quantidade++, idCompra);
            ps.setInt(quantidade++, idLista);
            ps.setInt(quantidade++, idPessoa);
            ps.setString(quantidade++, cliente.getCep());
            ps.setString(quantidade++, cliente.getLogradouro());
            ps.setString(quantidade++, cliente.getComplemento());
            ps.setString(quantidade++, cliente.getBairro());
            ps.setString(quantidade++, cliente.getCidade());
            ps.setString(quantidade++, cliente.getUf());
            ps.setString(quantidade++, cliente.getNumero());
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
        String sql = "UPDATE clientes cl JOIN pessoas ps ON cl.id_pessoa = ps.id SET"
                + "cl.cep = ?,cl.logradouro = ?,cl.complemento = ?,cl.bairro = ?,cl.cidade = ?,cl.uf = ?,cl.numero = ?, "
                + "cl.id_pessoa = ?, ps.nome = ?, ps.senha = ?, ps.email = ?, ps.cpf = ?, ps.idade = ?,"
                + " ps.telefone = ?, ps.id_privilegio = ? WHERE cl.id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            int quantidade = 1;
            ps.setString(quantidade++, cliente.getCep());
            ps.setString(quantidade++, cliente.getLogradouro());
            ps.setString(quantidade++, cliente.getComplemento());
            ps.setString(quantidade++, cliente.getBairro());
            ps.setString(quantidade++, cliente.getCidade());
            ps.setString(quantidade++, cliente.getUf());
            ps.setString(quantidade++, cliente.getNumero());
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
                cliente.setCep(resultset.getString("cl.cep"));
                cliente.setLogradouro(resultset.getString("cl.logradouro"));
                cliente.setComplemento(resultset.getString("cl.complemento"));
                cliente.setBairro(resultset.getString("cl.bairro"));
                cliente.setCidade(resultset.getString("cl.cidade"));
                cliente.setUf(resultset.getString("cl.uf"));
                cliente.setNumero(resultset.getString("cl.numero"));
                cliente.setIdPessoa(resultset.getInt("cl.id_pessoa"));
                cliente.setIdCompra(resultset.getInt("cl.id_compra"));
                cliente.setIdLista(resultset.getInt("cl.id_lista"));

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
