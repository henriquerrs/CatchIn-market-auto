<%-- 
    Document   : cadastroListas
    Created on : 17/09/2018, 09:55:17
    Author     : Alunos
--%>

<%@include file="validarCliente.jsp" %>
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
    <br>
    <br>
    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-lista" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th class="text-center" >Nome</th>
                        <th class="text-center">Preço</th>
                        <th class="text-center">Quantidade</th>
                        <th class="text-center">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoListaBean produto : produtos) {%>
                    <tr>
                        <td class="text-center" ><%=produto.getProdutoBean().getNome()%></td>
                        <td class="text-center" >R$ <%=produto.getProdutoBean().getPreco()%></td>
                        <td class="text-center" ><%=produto.getQuantidade()%></td>
                        <td>
                            <a class=" center btn btn-danger btn-sm col-12" href="/excluirLista?id=<%= produto.getId()%>"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th class="text-center" >Nome</th>
                        <th class="text-center" >Preço</th>
                        <th class="text-center" >Quantidade</th>
                        <th class="text-center" >Ação</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<%@include file="layout/footerBootStrapLista.jsp" %>