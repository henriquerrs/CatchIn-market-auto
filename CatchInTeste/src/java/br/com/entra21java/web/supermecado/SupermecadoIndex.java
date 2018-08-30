package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.PessoaBean;
import br.com.entra21java.dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */
@WebServlet(urlPatterns = "/index2")
public class SupermecadoIndex extends HttpServlet{
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PessoaBean> clientes = new PessoaDAO().ObterUsuario();
        req.getRequestDispatcher("/layout/master.jsp").include(req, resp);
    }
    
}
