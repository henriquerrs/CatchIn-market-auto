<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.dao.ClienteDAO"%>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="br.com.entra21java.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ProdutoBean"%>
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
    .carousel-inner {
        height: 400px;
    }
</style>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="libs/imagens/imagem1.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="libs/imagens/imagem2.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="libs/imagens/imagem3.jpg" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
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
        <!-- Panel Tickets -->
        <div class="panel box-shadow">
            <div class="panel-body">
                <table class="table table-striped table-hover table-bordered text-shadow" style="width:100%" id="tabela-ticket">
                    <thead>
                        <tr class='table-primary'>
                            <th style="background-color: grey; color: white" class="center">Preço</th>
                            <th style="background-color: grey; color: white">Nome</th>
                            <th style="background-color: grey; color: white" class="center">Marca</th>
                            <th style="background-color: grey; color: white" class="center">Comprar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (ProdutoBean produto : produtos) {%>
                        <tr>
                            <th class="center"><%=produto.getPreco()%></th>
                            <th><%=produto.getNome()%></th>
                            <th class="center"><%=produto.getMarca()%></th>
                            <th>
                                <style>
                                    #botao_quantidade {
                                        width:35px;
                                    }
                                </style>
                                <div class="row">
                                    <input style="margin-left: 30%" id="botao_quantidade" type="number" href="#">
                                    <a style="margin-left: 5%" id="botao_compra" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success blue'><i class="fas fa-shopping-cart"></i></a>
                                </div>
                            </th>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>


<!--        <table id="example" class="table table-striped table-bordered" style="width:100%">
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
                        <style>
                            #botao_quantidade {
                                width:35px;
                            }
                        </style>
                        <div class="row">
                            <input id="botao_quantidade" type="number" href="#">
                            <a id="botao_compra" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success blue'><i class="fas fa-shopping-cart"></i></a>
                        </div>
                    </th>
                </tr>
                <% }%>
            </tbody>-->
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