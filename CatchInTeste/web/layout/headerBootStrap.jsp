<%-- 
    Document   : headerBootStrap
    Created on : 03/09/2018, 09:56:29
    Author     : Alunos
--%>

<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <% String pagina = ""; %>
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() < 4) {
                    pagina = "admin";
                }%>
            <li class="nav-item active">
                <a style="margin-left: 0%" class="nav-link" href="/<%=pagina%>"><i class="fas fa-shopping-bag"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='/<%=pagina%>'>Catch In</i></a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() == 4) { %>
            <li class="nav-item">
                <a class="nav-link" href="/lista-de-compras"><i class="fas fa-clipboard-list"></i></a>
            </li>
            <li class="nav-item">
                <!--a class="nav-link" href="/carrinho"><i class="fas fa-cart-arrow-down"></i></a-->
                <div>
                    <a class="nav-link" data-toggle="modal" data-target="#modalCarrinho" data-whatever="@mdo"><i class="fas fa-cart-arrow-down"></i></a>

                    <div class="modal fade" id="modalCarrinho" tabindex="-1" role="dialog" aria-labelledby="modalHeader" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalHeader">Carrinho</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() < 4) {%>
                                    <div class="form-group">
                                        <h7>Você é um administrador</h7>
                                    </div>
                                    <%} else {%>
                                    <div class="form-group">
                                        <%  int idCompra = ((ClienteBean) session.getAttribute("cliente")).getIdCompra();%>
                                        <h7>Total das compras: R$<%=new CompraDAO().atualizarTotal(idCompra)%></h7>
                                    </div>
                                    <div class="form-group">
                                        <% List<ItemBean> itens = new ItemDAO().obterItensPeloIdCompra(idCompra); %>
                                        <table id="table-carrinho" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Preço</th>
                                                    <th>Nome</th>
                                                    <th>Quantidade</th>
                                                    <th>Opção</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (ItemBean item : itens) {%>
                                                <tr>
                                                    <th><%=item.getProduto().getPreco()%></th>
                                                    <th><%=item.getProduto().getNome()%></th>
                                                    <th><%=item.getQuantidade()%></th>
                                                    <th><a href="/produtos/excluir?id=<%=item.getId()%>">Excluir</a></th>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th>Preço</th>
                                                    <th>Nome</th>
                                                    <th>Quantidade</th>
                                                    <th>Opção</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <%}%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                </div>
                            </div>
                        </div>
                    </div>
            </li>
            <% }%>
            <li class="nav-item">
                <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i></a>
            </li>
        </ul>
    </div>
</nav>