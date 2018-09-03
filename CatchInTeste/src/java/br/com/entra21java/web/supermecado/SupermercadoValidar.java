/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.dao.PessoaDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alunos
 */
@WebServlet("/supermercado/login")
public class SupermercadoValidar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        PessoaBean pessoa = new PessoaDAO().verificarLogin(login, senha);

        if (pessoa != null) {
            HttpSession session = req.getSession();
            session.setAttribute("pessoa", pessoa);
            
            HashMap<String, Integer> retorno = new HashMap<>();
            retorno.put("id", pessoa.getId());
            resp.getWriter().write(new Gson().toJson(retorno));
        } else {
            resp.sendRedirect("");
        }

    }

}
