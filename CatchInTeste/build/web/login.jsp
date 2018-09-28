<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva, Leonardo Airam & Crispim P.
--%>

<%@page import="br.com.entra21java.dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@include file="layout/masterSemNavBar.jsp" %>

<div class="row" style="margin-top: 13%">
    <div class="container">
        <div class="container">
            <!-- End Page Loading -->
            <div class="col s12 z-depth-4 card-panel">
                <form action="/login" method="POST">
                    <div class="row">
                        <div class="input-field col s12 center">
                            <img src="libs/imagens/LogoParaLogin.png">
                        </div>
                    </div>
                    <div class="row margin" style="margin-left: 2%">
                        <div class="input-field col s11">
                            <i class="material-icons prefix pt-5">account_circle</i>
                            <label for="login">Login</label>
                            <input id="login" type="text" class="validate" name="login">
                        </div>
                    </div>
                    <div class="row margin" style="margin-left: 2%">
                        <div class="input-field col s11">
                            <i class="material-icons prefix">lock_open</i>
                            <label for="senha">Senha</label>
                            <input id="senha" type="password" class="validate" name="senha">
                        </div>
                    </div>
                    
                        <button style="margin-left: 8%" type="button" class="waves-effect waves-light btn col s10 blue" id="entrar">Entrar</button>
                        <div class="row"></div>
                        <a style="margin-left: 74%" href="/cadastro">Registrar</a>
                    <div class="row">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="layout/footerLogin.jsp" %>