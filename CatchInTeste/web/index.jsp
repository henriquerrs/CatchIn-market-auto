<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>
<%@include file="validarCliente.jsp" %>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.dao.ClienteDAO"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="br.com.entra21java.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@include file="layout/masterBootStrap.jsp" %>

<title>Página de Usuario</title>

<!--<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    navbar itens dropdown
</div>-->



<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="libs/imagens/BANNER2.jpg" style="margin-top: 3%" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="libs/imagens/BANNER1-2.jpg" style="margin-top: 3%" alt="Second slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br/>
<div class="col-sm-offset-5 col-sm-12 text-center">
    <button style="text-align: center" type="button" class="btn btn-secondary" data-toggle="modal" data-target="#modalCliente" data-whatever="@mdo">Informações Cliente</button>
</div>
<div class="modal fade" id="modalCliente" tabindex="-1" role="dialog" aria-labelledby="modalClientes" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalClientes">Informações Cliente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="#" data-toggle="validator" method="post">
                <br>
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Nome:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getNome()%>" placeholder="info-nome" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">CPF:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getCpf()%>" placeholder="info-nome" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Idade:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdade()%>" placeholder="info-telefone" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                            <div class="form-group col s6">
                                <label for="recipient-name" class="col-form-label">Telefone:</label>
                                <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getTelefone()%>" placeholder="info-email" readonly>
                                <div class="helper-block with-errors"></div>
                            </div>
                        </div>
                    
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">CEP:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getCep()%>" placeholder="info-endereco" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Logradouro:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getLogradouro()%>" placeholder="info-endereco" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Complemento:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getComplemento()%>" placeholder="data" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Bairro:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getBairro()%>" placeholder="data" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Cidade:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getCidade()%>" placeholder="data" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">UF:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getUf()%>" placeholder="data" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
                            <label for="recipient-name" class="col-form-label">Número:</label>
                            <input class="form-control" type="text" value="<%= ((ClienteBean) session.getAttribute("cliente")).getNumero()%>" placeholder="data" readonly>
                            <div class="helper-block with-errors"></div>
                        </div>
                    </div
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" aria-label="Fechar">Fechar</button>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<div class="container">

    <!-- Panel Tickets -->
    <div class="panel box-shadow">
        <div class="panel-body">
            <table id="table-cliente" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Comprar</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Preço</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Comprar</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<%@include file="layout/footerBootstrap.jsp" %>