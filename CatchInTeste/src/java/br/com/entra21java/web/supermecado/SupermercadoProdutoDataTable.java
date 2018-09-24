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
@WebServlet(name = "SupermercadoProdutoDataTable", urlPatterns = {"/produto/datatable"})
public class SupermercadoProdutoDataTable extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comeco = req.getParameter("start");
        String tamanho = req.getParameter("length");
        String busca = req.getParameter("search[value]");

        List<ProdutoBean> produtos = new ProdutoDAO().obterProdutosParaDataTable(comeco, tamanho, busca);
        resp.setContentType("application/json");
        HashMap<String, Object> resultados = new HashMap<>();
        resultados.put("data", produtos);
        resp.getWriter().write(new Gson().toJson(resultados));

    }

}
