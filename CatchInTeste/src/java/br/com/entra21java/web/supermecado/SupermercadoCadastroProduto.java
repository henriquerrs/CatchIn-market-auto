/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.supermecado;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Crispim
 * @author Henrique
 */
@WebServlet("/adicionarProduto")
public class SupermercadoCadastroProduto extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdutoBean produto = new ProdutoBean();
        produto.setNome(req.getParameter("nome"));
        produto.setPreco(Double.parseDouble(req.getParameter("preco")));
        produto.setPeso(Double.parseDouble(req.getParameter("peso")));
        produto.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
        produto.setMarca(req.getParameter("marca"));
        produto.setCategoria(req.getParameter("categoria"));
        produto.setDescricao(req.getParameter("descricao"));
        
        int cod = new ProdutoDAO().adicionarProduto(produto);
        
        
        if(cod>0)resp.sendRedirect("/admin");
        
    }
    
}
