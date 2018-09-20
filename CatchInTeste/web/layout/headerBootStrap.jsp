<%-- 
    Document   : headerBootStrap
    Created on : 03/09/2018, 09:56:29
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <% String pagina = ""; %>
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() < 4) {
                    pagina = "admin";
                }%>
            <li class="nav-item active">
                <a style="margin-left: 0%" class="nav-link" href="/<%=pagina%>"><i class="fas fa-shopping-bag"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='/<%=pagina%>'>Catch In</i></a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() == 4) { %>
            <li class="nav-item">
                <a class="nav-link" href="/lista-de-compras"><i class="fas fa-clipboard-list"></i></a>
            </li>
            <li class="nav-item">
                <!--a class="nav-link" href="/carrinho"><i class="fas fa-cart-arrow-down"></i></a-->
                <div>
                    <a class="nav-link" data-toggle="modal" data-target="#modalCarrinho" data-whatever="@mdo"><i class="fas fa-cart-arrow-down"></i></a>
            </li>
            <% }%>
            <li class="nav-item">
                <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i></a>
            </li>
        </ul>
    </div>
</nav>
