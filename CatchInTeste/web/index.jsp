<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@include file="layout/masterBootStrap.jsp" %>
<!--<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    navbar itens dropdown
</div>-->
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
<!--<div class="slider">
    <ul class="slides">
        <li>
            <img src="libs/imagens/imagem1.jpg">  random image 
            <div class="caption left-align">
                <h5 class="light black-text text-lighten-3">Etiqueta Pêssego no CatchIn</h5>
            </div>
        </li>
        <li>
            <img src="libs/imagens/imagem2.jpg">  random image 
            <div class="caption right-align">
                <h5 class="light white-text text-lighten-3">May the capitalismo be with you</h5>
            </div>
        </li>
        <li>
            <img src="libs/imagens/imagem3.jpg">  random image 
            <div class="caption right-align">
                <h5 class="light grey-text text-lighten-3">Mercado? CatchIn</h5>
            </div>
        </li>
    </ul>
</div>-->
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
    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
    <table class="table">
        <thead>
            <tr style="background-color: #343838;" class='table-primary'>
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
                    <a id="botao_compra" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success blue'><i class="material-icons center">shopping_cart</i></a>
                </th>
            </tr>
            <% }%>
        </tbody>
    </table>
</div>
    <!--    <div id="nome_centro_tabela" class='col-md-12'>
    
    <div>
        <h3>Produtos</h3>
        <table id="myTable" style="background-color: #d3e2f5;" class='table table-striped table-hover'>
            <thead>
                <tr style="background-color: #343838;" class='table-primary'>
                    <th style="color: white" class="center">Preço</th>
                    <th style="color: white">Nome</th>
                    <th style="color: white" class="center">Marca</th>
                    <th style="color: white" class="center">Comprar</th>
                </tr>
            </thead>
            <tbody>
    
</tbody>
<ul class="pagination pager" id="myPager">
</ul>
</table>
</div>-->
</div>
<%@include file="layout/footerBootstrap.jsp" %>