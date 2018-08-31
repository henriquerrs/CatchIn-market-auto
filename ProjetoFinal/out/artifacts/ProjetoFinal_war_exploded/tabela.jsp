<%-- 
    Document   : index
    Created on : 27/08/2018, 11:29:44
    Author     : Henrique Silva
--%>

<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@include file="layout/master.jsp" %>
<div class='row'>
    <div class='col-md-12'>
        <%  List<PessoaBean> usuarios = new PessoaDAO().ObterUsuario(); %>
        <table class='table table-striped table-hover'>
            <thead>
                <tr class='table-primary'>
                    <th>Código</th>
                    <th>Tipo</th>
                    <th>IDTIPO</th>
                    <th>IDTIPO</th>
                    <th>nome</th>
                    <th>email</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>

                <% for (PessoaBean usuario : usuarios) {%>
                <tr>
                    <th><%=usuario.getId()%></th>
                    <th><%=usuario.getPrivilegioBean().getTipo()%></th>
                    <th><%=usuario.getPrivilegioBean().getId()%></th>
                    <th><%=usuario.getIdPrivilegio()%></th>
                    <th><%=usuario.getNome()%></th>
                    <th><%=usuario.getEmail()%></th>
                    <th> 
                        <a href='/alimentos/editar?id=<%=usuario.getId()%>' class='btn btn-success'><i class='fa fa-edit'></i>Editar</a>
                        <a href='/alimentos/excluir?id=<%=usuario.getId()%>' class='btn btn-outline-danger'>Excluir</a>
                    </th>
                </tr>
                <% }%>

            </tbody>
            <tfoot>
                <tr>
                    <th>Código</th>
                    <th>Tipo</th>
                    <th>IDTIPO</th>
                    <th>IDTIPO</th>
                    <th>nome</th>
                    <th>email</th>
                    <th>Ação</th>
                </tr>
            </tfoot>
        </table>

    </div>
</div>
<%@include file="layout/footer.jsp" %>