<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
    Author     : Leonardo Airam
--%>

<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@include file="layout/masterPrincipal.jsp" %>
<div class="container">
    <form class="col s12">
        <div class="row">
            <div class="alinhamento">
                <fieldset class="center" style="background-color: whitesmoke ">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input id="icon_prefix" type="text" class="validate">
                        <label for="icon_prefix">Login</label>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock_open</i>
                        <input id="lock_open" type="tel" class="validate">
                        <label for="lock_open">Senha</label>
                    </div>
                    <div class="input-field col s12">
<!--                        <button class="waves-effect waves-light btn" type="submit" name="action">Entrar
                        </button>-->
                        <a href="/CatchIn/principal.jsp" class="waves-effect waves-teal btn">Entrar</a>
                        <a href="/CatchIn/cadastro.jsp" class="waves-effect waves-light btn-flat">Registre-se</a>
                    </div>
                    <div  class="input-field col s12">
                    </div>
                    <div  class="input-field col s12">
                        <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">face</i></a>
                        <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">mail_outline</i></a>
                        <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">visibility</i></a>
                    </div>
                </fieldset>
            </div>
        </div>
    </form>
</div>
</div>
<%@include file="layout/footer.jsp" %>