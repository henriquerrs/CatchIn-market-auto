<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.CompraDAO"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.ClienteBean"%>
<div class="modal fade" id="modalCarrinho" tabindex="-1" role="dialog" aria-labelledby="modalHeader" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
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
                    <h7>Total das compras: <%=new CompraDAO().atualizarTotal(idCompra)%></h7>
                </div>
                <div class="form-group">
                    <% List<ItemBean> itens = new ItemDAO().obterItensPeloIdCompra(idCompra); %>
                    <table id="table-carrinho" class="table table-striped table-bordered">
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
                                <th><a href="/excluirItem?id=<%=item.getId()%>">Excluir</a></th>
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
                <button id="finalizar" type="submit" class="btn btn-dark">Finalizar Compra</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>