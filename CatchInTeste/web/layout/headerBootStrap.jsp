<%-- 
    Document   : headerBootStrap
    Created on : 03/09/2018, 09:56:29
    Author     : Henrique
--%>

<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="css.jsp" %>
<nav id="nav_bar" class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <% String pagina = ""; %>
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() < 4) {
                    pagina = "admin";
                }%>
            <li class="nav-item active">
                <a id="logo_catchIn" class="nav-link" href="/<%=pagina%>"><img src="../libs/imagens/LogoCatchIn (2).png"> </a>
            </li>
        </ul>
    </div>
    <div class="container">
        <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() == 4) { %>
        <fieldset id="menu_centro">
            <li class="nav-link">
                <a id="botao_logout" class="nav-link" href="/logout">Log Out - <i class="fas fa-sign-out-alt"></i></a>
                <a id="botao_lista" class="nav-link" href="/lista-de-compras">Sua Lista - <i class="fas fa-clipboard-list"></i></a>
        <% } else {%>
        <fieldset id="menu_centro_adm">
            <li class="nav-link">
                <a id="botao_logout" class="nav-link" href="/admin/entregas">Entregas<i class="fas fa-sign-out-alt"></i></a>
                <a id="botao_logout_adm" class="nav-link" href="/logout">Log Out - <i class="fas fa-sign-out-alt"></i></a>
        <%}%>
            </li>
        </fieldset>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() == 4) { %>
            <fieldset id="fieldset_preview" data-toggle="tooltip" data-placement="bottom" data-original-title="Veja seus produtos clicando aqui!">
                <li class="nav-item">
                    <!--a class="nav-link" href="/carrinho"><i class="fas fa-cart-arrow-down"></i></a-->
                    <a  class="nav-link" data-toggle="modal" data-target="#modalCarrinho" data-whatever="@mdo">
                        <%  int idCompra = ((ClienteBean) session.getAttribute("cliente")).getIdCompra();%>

                        <% List<ItemBean> itens = new ItemDAO().obterItensPeloIdCompra(idCompra); %>
                        <% int quantidadeNoCarrinho = 0;
                            for (ItemBean item : itens) {
                                quantidadeNoCarrinho++;
                            }%>
                        <!--<p id="produto_no_carrinho"><h7 >Você tem: <%%> produtos no <i class="fas fa-cart-arrow-down"></i></h7></p>-->
                        <p id="produto_no_carrinho"><h7 >Você tem: <%= quantidadeNoCarrinho%> produtos no <i class="fas fa-cart-arrow-down"></i></h7></p>
                        <p id="preco_dos_produtos"><h7>Sua compra está custando:<%=new CompraDAO().atualizarTotal(idCompra)%></h7></p>
                    </a>
            </fieldset>
            <% }%>
        </ul>
    </div>
</nav>
<br/>
<br/>
<br/>
