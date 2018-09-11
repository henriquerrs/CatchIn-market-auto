package br.com.entra21java.web.supermecado;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique Silva and Crispim P.
 */
@WebServlet("/login")
public class SupermercadoLogin extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("cliente") != null){
            resp.sendRedirect("/");
            return;
        }
        
        
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/login.jsp").include(req, resp);
    }
    
}
