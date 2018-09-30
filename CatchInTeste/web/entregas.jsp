<%-- 
    Document   : cadastroListas
    Created on : 17/09/2018, 09:55:17
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.bean.CompraBean"%>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@include file="validarAdmin.jsp" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/masterBootStrap.jsp"%>

<title>Página de Entregas</title>
<br>
<br>
<br>
<br>
<div class="container">
    <%  List<CompraBean> entregas = new CompraDAO().obterCompras();%>
    <br>
    <br>
    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-lista" class="table" style="width:100%">
                <thead>
                    <tr>
                        <th class="text-center" >TOTAL</th>
                        <th class="text-center">ENDEREÇO</th>
                        <th class="text-center">CLIENTE</th>
                        <th class="text-center">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (CompraBean entrega : entregas) {%>
                    <tr>
                        <td class="text-center" ><%=entrega.getTotal() %></td>
                        <td class="text-center" ><%=entrega.getCliente().getLogradouro() %></td>
                        <td class="text-center" ><%=entrega.getCliente().getPessoaBean().getNome() %></td>
                        <td class="text-center"><a class="btn btn-danger" href="/entregue?id=<%=entrega.getId()%>"><i class="fas fa-trash-alt"></i></a></td>
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th class="text-center" >TOTAL</th>
                        <th class="text-center" >ENDEREÇO</th>
                        <th class="text-center" >CLIENTE</th>
                        <th class="text-center" >Ação</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<%@include file="layout/footerBootStrapLista.jsp" %>