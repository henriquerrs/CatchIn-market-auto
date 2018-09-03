<%-- 
    Document   : carrinho
    Created on : 03/09/2018, 10:16:27
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/master.jsp" %>

<div id="nome_centro_tabela" class='col-md-12'>
    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos(); %>
    <div>
        <br/>
        <br/>
        <h3>Especiais da Semana</h3>
        <table style="background-color: #009aad;" class='table table-striped table-hover'>
            <thead>
                <tr style="background-color: #141861;" class='table-primary'>
                    <th style="color: white" class="center">Preço</th>
                    <th style="color: white">Nome</th>
                    <th style="color: white" class="center">Comprar</th>
                </tr>
            </thead>
            <tbody>
                <% for (ProdutoBean produto : produtos) {%>
                <tr>
                    <th class="center"><%=produto.getId()%></th>
                    <th><%=produto.getNome()%></th>
                    <th> 
                        <a id="botao_compra" href='/alimentos/editar?id=<%=produto.getId()%>' class='btn btn-success'><i class="material-icons center">shopping_cart</i></a>
                    </th>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
