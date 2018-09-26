/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisp
 */
@WebServlet(name = "SupermecadoAlterarProduto", urlPatterns = {"/editar"})
public class SupermecadoAlterarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProdutoBean produto = new ProdutoBean();
        produto.setId(Integer.parseInt(req.getParameter("id_produto")));
        produto.setNome(new String(req.getParameter("nome").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        produto.setPreco(Double.parseDouble(req.getParameter("preco")));
        produto.setPeso(Double.parseDouble(req.getParameter("peso")));
        produto.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
        produto.setMarca(new String(req.getParameter("marca").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        produto.setCategoria(new String(req.getParameter("categoria").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        produto.setDescricao(new String(req.getParameter("descricao").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        
        boolean alterado = new ProdutoDAO().alterarProduto(produto);
        
        if(alterado){
            resp.sendRedirect("/admin");
        } 
        
    }

}
