<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>

<nav>
    <div class="nav-wrapper">

        <a href="/index"><img src="libs/imagens/catchinCOIN.png" style="margin-top: 7px" width="50px" height="50px" class="imagem-logo"><a>
                <a href='/index' class='brand-logo'>CatchIn</a>
                <!--<a id="nome_logo" style="margin-left: 60px" >CatchIn</a>-->
                <!--<a href="/index" class="brand-logo"><i class="material-icons">shopping_basket</i>CatchIn</a>-->

                <!--<a href="/" class="input-field"><i class="material-icons">shopping_basket</i>CatchIn</a>-->
                <ul class="right hide-on-med-and-down">
                    <li class="input-field">
                        <style type="text/css">.nav-wrapper .input-field input[type=search] {height: auto;}
                        </style>
                        <!--<i class="material-icons">close</i>-->
                    </li>
                    <% PessoaBean pessoabean = (PessoaBean)request.getSession().getAttribute("pessoa");  %>
                    <li><a href="#"><i class="material-icons">date_range</i></a></li>
                    <li><a href="/carrinho?id="><i class="material-icons">shopping_cart</i></a></li>
                </ul>
                </div>
                </nav>