<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
--%>
<%@include file="validarAdmin.jsp" %>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@include file="layout/masterBootStrap.jsp" %>
<!--<link href="tema/CustomCss/datatable.css" rel="stylesheet">
<link href="tema/CustomCss/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="tema/CustomCss/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="tema/CustomCss/responsive.bootstrap.min.css" rel="stylesheet">
<script src="tema/bootstrap/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>-->
<title>Página de administração</title>


<br>
<br>
<div class="container">
    <%@page import="br.com.entra21java.dao.ProdutoDAO"%>
    <%@page import="java.util.List"%>
    <%@page import="br.com.entra21java.bean.ProdutoBean"%>
    <div id="nome_centro_tabela" class='col-md-12'>
        <%  List<ProdutoBean> produtos = new ProdutoDAO().obterProdutos();%>
        <div>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAdmin" data-whatever="@mdo">Adicionar Produto</button>
            <div class="modal fade" id="modalAdmin" tabindex="-1" role="dialog" aria-labelledby="modalProdutos" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalProdutos">Adicionar Produto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <form action="/adicionarProduto" data-toggle="validator" method="post">
                            <br>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Nome:</label>
                                        <input type="text" class="form-control" id="recipient-name" name="nome" data-error="Por favor, informe um nome do produto." required>
                                        <div class="helper-block with-errors"></div>
                                    </div>
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Preço:</label>
                                        <input type="number" class="form-control" id="recipient-preco" name="preco" data-error="Por favor, informe um preço do produto." required>
                                        <div class="helper-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Peso:</label>
                                        <input type="number" class="form-control" id="recipient-peso" name="peso" data-error="Por favor, informe um peso do produto." required>
                                        <div class="helper-block with-errors"></div>
                                    </div>
                                    <div class="form-group col s6">
                                        <label for="recipient-name" class="col-form-label">Quantidade:</label>
                                        <input type="number" class="form-control" id="recipient-quantidade" name="quantidade" data-error="Por favor, informe um quantidade do produto." required>
                                        <div class="helper-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Marca:</label>
                                    <input type="text" class="form-control" id="recipient-marca" name="marca" data-error="Por favor, informe um marca do produto." required>
                                    <div class="helper-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Categoria:</label>
                                    <input type="text" class="form-control" id="recipient-categoria" name="categoria" data-error="Por favor, informe um categoria do produto." required>
                                    <div class="helper-block with-errors"></div>
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
                        <th>Quantidade</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Quantidade</th>
                        <th>Ação</th>
                    </tr>
                </tfoot>
            </table>
            <%@include file="modal-editar.jsp" %>
        </div>
    </div>
   <%@include file="layout/footerBootstrap.jsp" %>
