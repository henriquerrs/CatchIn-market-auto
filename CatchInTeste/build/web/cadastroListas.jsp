<%-- 
    Document   : cadastroListas
    Created on : 17/09/2018, 09:55:17
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.dao.ProdutoDAO"%>
<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/masterBootStrap.jsp"%>
<div class="container">
    <h3 style="text-align: center">Cadastre sua lista de compras</h3>
    <div class="row">
        <a href="#" class="btn btn-secondary btn-lg" role="button" aria-disabled="true">Cadastrar Listas</a>
        <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
        <table class="table">
            <thead>
                <tr style="background-color: grey" class='table'>
                    <th style="color: white" class="center">Nome</th>
                    <th style="color: white">Quantidade de Produtos</th>
                    <th style="color: white" class="center">Preço da compra</th>
                    <th style="color: white" class="center">Comprar</th>
                </tr>
            </thead>

            <tbody>
                <% for (ProdutoBean produto : produtos) {%>
                <tr>
                    <th><%=produto.getNome()%></th>
                    <th class="center"><%=produto.getQuantidade()%></th>
                    <th class="center"><%=produto.getPreco()%></th>
                    <th> 
                        <a href="#" class="btn btn-secondary btn-lg" role="button" >Completar Compra</a>
                        <a href="#" class="btn btn-secondary btn-lg" role="button" ><i class="fas fa-trash"></i></a>
                        <a href="#" class="btn btn-secondary btn-lg " role="button" ><i class="far fa-edit"></i></a>
                    </th>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>
<%@include file="layout/footerBootstrap.jsp"%>