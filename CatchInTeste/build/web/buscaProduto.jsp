<%-- 
    Document   : buscaProduto
    Created on : 14/09/2018, 11:17:48
    Author     : Airam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/master.jsp" %>

<form action="/select2/produtoStore" method="post">
    
    <div class="form-group">
	<label for='campo-produto'><i class=''></i> produtos </label>
	<input class='form-control' type='text' id='campo-produto' name="buca_produto">
    </div>
</form>
<%@include file="layout/footer.jsp" %>