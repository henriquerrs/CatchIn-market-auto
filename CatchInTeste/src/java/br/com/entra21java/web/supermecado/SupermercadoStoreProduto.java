/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ClienteBean;
import br.com.entra21java.dao.CompraDAO;
import br.com.entra21java.dao.ItemDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Crispim
 */
@WebServlet("/adicionar")
public class SupermercadoStoreProduto extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        HttpSession session = req.getSession();
        int idCompra = ((ClienteBean) session.getAttribute("cliente")).getIdCompra();
        int idProduto = Integer.parseInt(req.getParameter("id"));
        
        String situacao = new ItemDAO().adicionarCompra(idCompra, idProduto);
        
        resp.sendRedirect("");
    
    }    
    
}
