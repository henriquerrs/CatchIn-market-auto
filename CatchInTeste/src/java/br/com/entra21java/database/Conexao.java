package br.com.entra21java.database;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Crispim Paiano dos Santos
 */
public class Conexao {
    
    private static final String HOST="jdbc:mysql://localhost/supermercado_catchin";
    private static final String USER="root";
    private static final String PASSWORD="";
    private static final String CLASS="com.mysql.jdbc.Driver";
    private static Connection conexao;
    
    public static void main(String[] args) {
        Conexao.obterConexao();
    }
    
    public static Connection obterConexao(){
        try {
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void fecharConexao(){
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public static void truncate() {
        obterConexao();
        if (conexao != null) {
            try {
                Statement st = (Statement) conexao.createStatement();
                st.addBatch("SET FOREIGN_KEY_CHECKS = 0;");
                st.addBatch("TRUNCATE TABLE clientes;");
                st.addBatch("TRUNCATE TABLE colaboradores;");
                st.addBatch("TRUNCATE TABLE compras;");
                st.addBatch("TRUNCATE TABLE itens;");
                st.addBatch("TRUNCATE TABLE listas;");
                st.addBatch("TRUNCATE TABLE pessoas;");
                st.addBatch("TRUNCATE TABLE privilegios;");
                st.addBatch("TRUNCATE TABLE produtos;");
                st.addBatch("TRUNCATE TABLE produtos_listas;");
                st.addBatch("SET FOREIGN_KEY_CHECKS = 1;");
                st.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                fecharConexao();
            }
        }
    }
    
}
