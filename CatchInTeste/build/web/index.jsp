<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>
<%@include file="validarCliente.jsp" %>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.dao.ClienteDAO"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="br.com.entra21java.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@include file="layout/masterBootStrap.jsp" %>

<title>Página de Usuario</title>

<!--<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    navbar itens dropdown
</div>-->


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
<h3 style="text-align: center">May the capitalism be with you</h3>
<br>
<div class="container">
    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-admin" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Comprar</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoBean produto : produtos) {%>
                    <tr>
                        <th><%=produto.getPreco()%></th>
                        <th><%=produto.getNome()%></th>
                        <th><%=produto.getMarca()%></th>
                        <th>
                            <form action='/adicionar' method="get">
                                <a id="botao_add_carrinho" href='/adicionar?id=<%=produto.getId()%>' class='btn btn-success blue'><img style="width: 18px; height: 19px; margin-left: 5%" src="libs/imagens/add list.png"></a>
                                <input type="number" id="botao_quantidade" name="quantidade" style="margin-left: 25%;" min="0" max="50" value="1">
                                <button type="submit" id="botao_compra" name="id" value="<%=produto.getId()%>" class='btn btn-success blue'><i class="fas fa-cart-plus"></i></button>
                            </form>
                        </th>
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Comprar</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<%@include file="layout/footerBootstrap.jsp" %>