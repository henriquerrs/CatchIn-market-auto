<%-- 
    Document   : headerBootStrap
    Created on : 03/09/2018, 09:56:29
    Author     : Alunos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="../admin"><i class="fas fa-shopping-bag"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../admin">Cath In</i></a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="../admin">ICON</i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/carrinho"><i class="fas fa-cart-arrow-down"></i></a>
            </li>
        </ul>
    </div>
</nav>