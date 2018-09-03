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
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input id="login" type="text" class="validate" name="login">
                                <label for="icon_prefix">Login</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock_open</i>
                            <input id="senha" type="password" class="validate" name="senha">
                                <label for="lock_open">Senha</label>
                        </div>
                        <div class="input-field col s12">
                            <!--                        <button class="waves-effect waves-light btn" type="submit" name="action">Entrar
                                                    </button>-->
                            <button type="button" id="cadastrar">Cadastrar</button>
                            <a href="/cadastro" class="waves-effect waves-light btn-flat">Registre-se</a>
                        </div>
                        <div  class="input-field col s12">
                        </div>
                        <div  class="input-field col s12">
<!--                            <a class="addthis_button_facebook addthis_button_preferred_1 at300b" title="Facebook" href="m.facebook.com">
                                <span class="at-icon-wrapper" style="background-color: rgb(59, 89, 152); line-height: 32px; height: 32px; width: 32px;">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 32 32" version="1.1" role="/libs/imagens/facebook.jpg" aria-labelledby="at-svg-facebook-16" title="Facebook" alt="Facebook" style="width: 32px; height: 32px;" class="at-icon at-icon-facebook">
                                        <title id="at-svg-facebook-16">Facebook</title>
                                        <g><path d="M22 5.16c-.406-.054-1.806-.16-3.43-.16-3.4 0-5.733 1.825-5.733 5.17v2.882H9v3.913h3.837V27h4.604V16.965h3.823l.587-3.913h-4.41v-2.5c0-1.123.347-1.903 2.198-1.903H22V5.16z" fill-rule="evenodd"></path></g>
                                    </svg>
                                </span>
                            </a>-->
                            <a class="btn-floating btn-large waves-effect waves-light red"><img class="materialboxed" src="/libs/imagens/facebook.jpg"></a>
                            <a class="btn-floating btn-large waves-effect waves-light red"><img src="/libs/imagens/gmail.jpg"></a>
                            <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">visibility</i></a>
                        </div>
                    </form>
                </fieldset>
            </div>
        </div>
</div>
</div>
<%@include file="layout/footer.jsp" %>