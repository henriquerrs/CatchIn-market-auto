/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.dao.ClienteDAO;
import br.com.entra21java.dao.ConverterSHA512;
import br.com.entra21java.dao.PessoaDAO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        resp.setContentType("text/html;charset=utf-8");
        ClienteBean cliente = new ClienteBean();
        
        cliente.setCep(new String(req.getParameter("cep").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setLogradouro(new String(req.getParameter("logradouro").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setComplemento(new String(req.getParameter("complemento").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setBairro(new String(req.getParameter("bairro").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setCidade(new String(req.getParameter("cidade").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setUf(new String(req.getParameter("uf").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        cliente.setNumero(new String(req.getParameter("numero").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        
        PessoaBean pessoa = new PessoaBean();
        pessoa.setNome(new String(req.getParameter("nome").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        pessoa.setSenha(new ConverterSHA512().transformarSenha(req.getParameter("senha")));
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setTelefone(req.getParameter("telefone"));
        pessoa.setCpf(req.getParameter("cpf"));
        byte idade = new PessoaDAO().retornarAno(req.getParameter("idade_usuario"));
        pessoa.setIdade(idade);
                
        cliente.setPessoaBean(pessoa);
        
        int codigo = new ClienteDAO().adicionarCliente(cliente);

        if(codigo > 0){
            resp.sendRedirect("/login");
        } 
        
    }
    
}
