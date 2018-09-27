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
                    <h7>Voc� � um administrador</h7>
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
                                <th class="text-center">Pre�o</th>
                                <th>Nome</th>
                                <th class="text-center">Quantidade</th>
                                <th class="text-center">A��o</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (ItemBean item : itens) {%>
                            <tr>
                                <td class="text-center"><%=item.getProduto().getPreco()%></td>
                                <td><%=item.getProduto().getNome()%></td>
                                <td class="text-center"><%=item.getQuantidade()%></td>
                                <td class="text-center"><a class="btn btn-danger" href="/excluirItem?id=<%=item.getId()%>"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                            <% }%>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th class="text-center">Pre�o</th>
                                <th class="text-center">Nome</th>
                                <th class="text-center">Quantidade</th>
                                <th class="text-center">A��o</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <%}%>
            </div>
            <div class="modal-footer">
                <!--button id="finalizar" type="submit" class="btn btn-dark">Finalizar Compra</button-->
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                <form action='/excluirCompra' method='get'>
                    <button type="submit" id="finalizar" class="btn btn-dark" data-dismiss="modal" aria-label="Finalizar">Finalizar</button>
                </form>
            </div>
        </div>
    </div>
</div>