/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.dao.ItemDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 * @author Crispim
 */
@WebServlet("/excluirItem")
public class SupermercadoStoreExcluirCarrinhoItem extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html; charset=UTF-8");
         
        int id = Integer.parseInt(req.getParameter("id"));
        
         new ItemDAO().excluirItem(id);
         resp.sendRedirect("");
    }
    
}