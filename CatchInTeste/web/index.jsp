<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@include file="layout/master.jsp" %>
<style type="text/css">
    .datepicker-table-wrapper{
        color: black !important;
    }
    .select-dropdown{
        display: initial !important;
        color: white !important;
    }
    .select-wrapper .caret {
        fill: rgba(255, 255, 255, 0.9);
    }
</style>
<div class="container-fluid">
    <img class="materialboxed" width="100%" src="/libs/imagens/banner.jpg">
    <!--navbar itens dropdown-->
    <div class="container">
        <ul id="dropdown1" class="dropdown-content">
            <li><a href="#">one</a></li>
            <li><a href="#">two</a></li>
            <li><a href="#">three</a></li>
        </ul>
    </div>
    <!--Opções de seleção-->
    <nav>
        <div class="nav-wrapper">
            <ul class="right hide-on-med-and-down">
                <li><select>
                        <option value="" disabled selected>Categoria</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select></li>
                <li>
                    <a href="#"><i class="material-icons">date_range</i></a>
                </li>
            </ul>
        </div>
    </nav>  
</div>
<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<style type="text/css">
    #nome_centro_tabela{
        text-align: center;
    }
</style>
<div id="nome_centro_tabela" class='col-md-12'>
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
<%@include file="layout/footer.jsp" %>
