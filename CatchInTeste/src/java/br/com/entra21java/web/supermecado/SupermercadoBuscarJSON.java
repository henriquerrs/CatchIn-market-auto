/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.ProdutoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(name = "SupermercadoBuscarJSON", urlPatterns = {"/produto/buscar"})
public class SupermercadoBuscarJSON extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        int id = Integer.parseInt(req.getParameter("id"));
        ProdutoBean produto = new ProdutoDAO().obterProdutoPeloId(id);
        resp.getWriter().write(new Gson().toJson(produto));
    }
    
}
