<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
--%>

<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@include file="layout/masterBootStrap.jsp" %>
<link href="tema/CustomCss/datatable.css" rel="stylesheet">
<link href="tema/CustomCss/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="tema/CustomCss/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="tema/CustomCss/responsive.bootstrap.min.css" rel="stylesheet">
<title>Página de administração</title>
<script src="tema/bootstrap/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>



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

</style>
<div class="container">
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
            background-color: #E8E8E8 !important;
        }
    </style>
    <div id="nome_centro_tabela" class='col-md-12'>
        <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
        <div>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Adicionar Produto</button>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Adicionar Produto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <form action="/adicionarProduto" method="post">
                            <br>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Nome:</label>
                                        <input type="text" class="form-control" id="recipient-name" name="nome">
                                    </div>
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Preço:</label>
                                        <input type="number" class="form-control" id="recipient-preco" name="preco">
                                    </div>
                                </div>
                                <div class="row">
                                <div class="form-group col s6">
                                    <label for="recipient-name" class="col-form-label">Peso:</label>
                                    <input type="number" class="form-control" id="recipient-peso" name="peso">
                                </div>
                                <div class="form-group col s6">
                                    <label for="recipient-name" class="col-form-label">Quantidade:</label>
                                    <input type="number" class="form-control" id="recipient-quantidade" name="quantidade">
                                </div>
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Marca:</label>
                                    <input type="text" class="form-control" id="recipient-marca" name="marca">
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Categoria:</label>
                                    <input type="text" class="form-control" id="recipient-categoria" name="categoria">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Descrição:</label>
                                    <textarea class="form-control" id="message-descricao" name="descricao"></textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                <button type="submit" class="btn btn-primary">Adicionar Produto</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <h3>Produtos</h3>
            <table id="table-admin" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (ProdutoBean produto : produtos) {%>
                    <tr>
                        <th><%=produto.getPreco()%></th>
                        <th><%=produto.getNome()%></th>
                        <th><%=produto.getMarca()%></th>

                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
    <script type="text/javascript" src="tema/bootstrap/js/jsbootstrap.js">
        <%@include file="layout/footerBootstrap.jsp" %>
