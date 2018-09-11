<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@include file="layout/master.jsp" %>
<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    <!--navbar itens dropdown-->
</div>
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
        background-color: #05adc3;
    }
</style>
<div id="nome_centro_tabela" class='col-md-12'>
    <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos(); %>
    <div>
        <h1>Seja bem vindo <%= ((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getNome() %>!</h1>
        <h3>Produtos</h3>
        <table id="myTable" style="background-color: #009aad;" class='table table-striped table-hover'>
            <thead>
                <tr style="background-color: #141861;" class='table-primary'>
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
                        <a id="botao_compra" href='/alimentos/editar?id=<%=produto.getId()%>' class='btn btn-success'><i class="material-icons center">shopping_cart</i></a>
                        
                    </th>
                </tr>
                <% }%>
            </tbody>
            <ul class="pagination pager" id="myPager">
            </ul>
        </table>
    </div>
</div>
<%@include file="layout/footer.jsp" %>
