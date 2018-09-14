
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.ProdutoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henri
 */
@WebServlet("/admin")
public class SupermercadoAdmin extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        if (req.getSession().getAttribute("admin") == null) {
            resp.sendRedirect("/login");
            return;
        }

        List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();
        req.getRequestDispatcher("/admin.jsp").include(req, resp);
    }
    
}
