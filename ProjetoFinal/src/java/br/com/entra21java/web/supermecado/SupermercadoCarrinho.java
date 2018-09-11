package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ItemBean;
import br.com.entra21java.dao.ItemDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique Silva
 */
@WebServlet("/carrinho")
public class SupermercadoCarrinho extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int idCompra =1;
        List<ItemBean> itens = new ItemDAO().obterItensPeloIdCompra(idCompra);
        req.getRequestDispatcher("/carrinho.jsp").include(req, resp);
    }
    
}
