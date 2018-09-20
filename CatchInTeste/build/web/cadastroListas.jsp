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

<title>Página de Listas</title>

<h3 style="text-align: center">May the capitalism be with you</h3>
<br>
<div class="container">

    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
    <div class="col">
        <div class="col offset-5">
            <a id="botao_finaizar_compra" href='#' class='btn btn-success blue'>Finalizar Compra</a>
        </div>
    </div>
    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-admin" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th style="text-align: center">Preço</th>
                        <th style="text-align: center">Quantidade</th>
                        <th style="text-align: center">Editar/Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoBean produto : produtos) {%>
                    <tr>
                        <th><%=produto.getNome()%></th>
                        <th><%=produto.getPreco()%></th>
                        <th><%=produto.getQuantidade()%></th>
                        <th>
                            <a style="margin-left: 27%" id="botao_excluir_lista" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success blue'><i class="fas fa-trash"></i></a>
                            <a id="botao_editar_compra" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success red'><i class="far fa-edit"></i></a>
                        </th>
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th style="text-align: center">Preço</th>
                        <th style="text-align: center">Quantidade</th>
                        <th style="text-align: center">Editar/Excluir</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<%@include file="layout/footerBootstrap.jsp" %>