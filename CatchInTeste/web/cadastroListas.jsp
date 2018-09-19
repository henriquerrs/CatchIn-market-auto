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
<link href="tema/CustomCss/datatable.css" rel="stylesheet">
<link href="tema/CustomCss/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="tema/CustomCss/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="tema/CustomCss/responsive.bootstrap.min.css" rel="stylesheet">
<title>Página de Listas</title>
<script src="tema/bootstrap/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>

<h3 style="text-align: center">May the capitalism be with you</h3>
<br>
<div class="container">
    <style type="text/css">
        #nome_centro_tabela{
            text-align: center;
        }

        #botao_compra {
            margin-left: 37%;
        }
        body {
            background-color: silver !important;
        }
    </style>
    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
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
                <style>
                    #botao_excluir_lista {
                        margin-left: 5%;
                    }
                    #botao_editar_compra {
                        margin-left: 5%;
                    }
                </style>
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
<script type="text/javascript" src="tema/bootstrap/js/jsbootstrap.js">
    <%@include file="layout/footerBootstrap.jsp" %>