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
        <a href="#" class="btn btn-secondary btn-lg disabled" role="button" aria-disabled="true">Cadastrar Listas</a>
        <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
        <table class="table">
            <thead>
                <tr style="background-color: grey" class='table'>
                    <th style="color: white" class="center">Preço</th>
                    <th style="color: white">Nome</th>
                    <th style="color: white" class="center">Marca</th>
                    <th style="color: white" class="center">Comprar</th>
                </tr>
            </thead>

            <tbody>
                <% for (ProdutoBean produto : produtos) {%>
                <tr>
                    <th class="center"><%=produto.getPreco()%></th>
                    <th><%=produto.getNome()%></th>
                    <th class="center"><%=produto.getMarca()%></th>
                    <th> 
                        <a href="#" class="btn btn-secondary btn-lg disabled" role="button" >Excluir Lista</a>
                        <a href="#" class="btn btn-secondary btn-lg disabled" role="button" >Editar Lista</a>
                    </th>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>
<%@include file="layout/footerBootstrap.jsp"%>