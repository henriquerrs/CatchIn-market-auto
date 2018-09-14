<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
--%>

<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@include file="layout/masterBootStrap.jsp" %>
<link href="tema/CustomCss/datatable.css" rel="stylesheet">
<link href="tema/CustomCss/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="tema/CustomCss/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="tema/CustomCss/responsive.bootstrap.min.css" rel="stylesheet">
<title>Página de administração</title>



<style>
    .slider .indicators .indicator-item {
        background-color: #ffffff;
        border: 3px solid #ffffff;
        -webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
        -moz-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
        box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
    }
    .slider .indicators .indicator-item.active {
        background-color: #666666;
    }
    .slider {
        width: 100%;
        margin: 0 auto;
    }
    .slider .indicators {
        bottom: 60px;
        z-index: 100;
        /* text-align: left; */
    }
    
</style>
<div class="container">
    <%@page import="br.com.entra21java.dao.ProdutoDAO"%>
    <%@page import="java.util.List"%>
    <%@page import="br.com.entra21java.bean.ProdutoBean"%>
    <style type="text/css">
        #nome_centro_tabela{
            text-align: center;
        }

        #botao_compra {
            margin-left: 37%;
        }
        body {
            background-color: #E8E8E8 !important;
        }
    </style>
    <div id="nome_centro_tabela" class='col-md-12'>
        <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
        <div>
            <h3>Produtos</h3>
            <table id="table-admin" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoBean produto : produtos) {%>
                    <tr>
                        <th><%=produto.getPreco()%></th>
                        <th><%=produto.getNome()%></th>
                        <th><%=produto.getMarca()%></th>
                       
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
<script type="text/javascript" src="tema/bootstrap/js/jsbootstrap.js">
<%@include file="layout/footerBootstrap.jsp" %>
