<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva, Leonardo Airam & Crispim P.
--%>

<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@include file="layout/masterSemNavBar.jsp" %>
<div class="container">
    <div class="row">
        <div class="alinhamento">
            <fieldset class="center" style="background-color: whitesmoke ">
                <form action="/login" method="POST">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input id="login" type="text" class="validate" name="login">
                            <label for="icon_prefix">Login</label>
                        </div>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock_open</i>
                        <input id="senha" type="password" class="validate" name="senha">
                        <label for="lock_open">Senha</label>
                    </div>
                    <div class="input-field col s12">
                        <button type="button" class="waves-effect waves-light btn" id="entrar">Entrar</button>
                        <a href="/cadastro" class="waves-effect waves-light btn-flat">Registre-se</a>
                    </div>
                    <div  class="input-field col s12">
                    </div>
                    <div  class="input-field col s12">
                        <a class="btn-floating btn-large waves-effect waves-light indigo"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn-floating btn-large waves-effect waves-light red"><i class="fab fa-google"></i></a>
                        <a class="btn-floating btn-large waves-effect waves-light blue"><i class="fab fa-twitter"></i></a>
                    </div>
                </form>
            </fieldset>
        </div>
    </div>
</div>
</div>
<%@include file="layout/footer.jsp" %>