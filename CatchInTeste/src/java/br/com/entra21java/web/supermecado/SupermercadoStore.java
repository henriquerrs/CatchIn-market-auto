/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet("/store")
public class SupermercadoStore extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ClienteBean cliente = new ClienteBean();
        
        cliente.setEndereco(req.getParameter("endereco"));

        PessoaBean pessoa = new PessoaBean();
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setSenha(req.getParameter("senha"));
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setTelefone(req.getParameter("telefone"));
        cliente.setPessoaBean(pessoa);
        
        int codigo = new ClienteDAO().adicionarCliente(cliente);

        if(codigo > 0){
            resp.sendRedirect("/index");
        } 
        
    }
    
}
