<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@include file="layout/master.jsp" %>
<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    <!--navbar itens dropdown-->
</div>
<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<style type="text/css">
    #nome_centro_tabela{
        text-align: center;
    }
    
    #botao_compra {
        margin-left: 37%;
    }
</style>

<div id="nome_centro_tabela" class='col-md-12'>
    <%  List<PessoaBean> usuarios = new PessoaDAO().ObterUsuario(); %>
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
                <% for (PessoaBean usuario : usuarios) {%>
                <tr>
                    <th class="center"><%=usuario.getId()%></th>
                    <th><%=usuario.getNome()%></th>
                    <th> 
                        <a id="botao_compra" href='/alimentos/editar?id=<%=usuario.getId()%>' class='btn btn-success'><i class="material-icons center">shopping_cart</i></a>
                    </th>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
</div>
<%@include file="layout/footer.jsp" %>
