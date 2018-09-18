package br.com.entra21java.web.supermecado;

import br.com.entra21java.dao.ProdutoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet("/produtos/obtertodosparadatatable")
public class SupermercadoObterTodosParaDataTable extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HashMap<String, Object> resultado = new HashMap<>();
        List<HashMap<String, Object>> produtos = new ProdutoDAO().obterTodosParaDataTable();
        resultado.put("data", produtos);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(new Gson().toJson(resultado));
    }
}
