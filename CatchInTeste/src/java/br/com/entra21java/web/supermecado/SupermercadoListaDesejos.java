package br.com.entra21java.web.supermecado;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author Airam
 */
@WebServlet("/lista-de-compras")
public class SupermercadoListaDesejos extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        
        if (req.getSession().getAttribute("cliente") == null) {
            resp.sendRedirect("/login");
            return;
        }
        
        req.getRequestDispatcher("/cadastroListas.jsp").include(req, resp);
    }
}
