<%@page import="br.com.entra21java.bean.ClienteBean"%>
<%@page import="br.com.entra21java.bean.PessoaBean"%>
<%@page import="br.com.entra21java.bean.ItemBean"%>
<%@page import="br.com.entra21java.dao.ItemDAO"%>

<nav>
    <div class="nav-wrapper">

        <a href="/" style="margin-left: 1%"><i class="fas fa-comment-dollar"></i>

            <a href="/" id="texto_logo" style=" font-size: xx-large; margin-bottom: 30%; margin-left: 1% !important">CatchIn</a></a>
        <!--<a id="nome_logo" style="margin-left: 60px" >CatchIn</a>-->
        <!--<a href="/index" class="brand-logo"><i class="material-icons">shopping_basket</i>CatchIn</a>-->

        <!--<a href="/" class="input-field"><i class="material-icons">shopping_basket</i>CatchIn</a>-->
        <ul class="right">
            <div>
                <li><a id="botao_logout" href="/logout"><i class="fas fa-sign-out-alt"></i></a></li>
                <li><a href="/carrinho"><i class="material-icons">shopping_cart</i></a></li>
            </div>
        </ul>
    </div>
</nav>