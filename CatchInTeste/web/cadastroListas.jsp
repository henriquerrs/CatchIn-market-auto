<%-- 
    Document   : cadastroListas
    Created on : 17/09/2018, 09:55:17
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.dao.ProdutoListaDAO"%>
<%@page import="br.com.entra21java.bean.ProdutoListaBean"%>
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
    <%  int idLista = ((ClienteBean) session.getAttribute("cliente")).getIdLista();%>
    <%  List<ProdutoListaBean> produtos = new ProdutoListaDAO().obterItensPeloIdLista(idLista);%>
    <div class="col">
        <div class="col offset-5">
            <a id="botao_finaizar_compra" href='/paraCarinho' class='btn btn-success blue'>Adicionar ao Carrinho</a>
        </div>
    </div>
    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-lista" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th style="text-align: center">Preço</th>
                        <th style="text-align: center">Quantidade</th>
                        <th style="text-align: center">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoListaBean produto : produtos) {%>
                    <tr>
                        <td><%=produto.getProdutoBean().getNome()%></td>
                        <td><%=produto.getProdutoBean().getPreco()%></td>
                        <td><%=produto.getQuantidade()%></td>
                        <td>
                            <a href="/excluirLista?id=<%= produto.getId()%>"><i class="fas fa-trash-alt"></i></a>
                        </td>
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