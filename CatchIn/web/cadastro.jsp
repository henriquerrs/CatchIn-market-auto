<%@include file="layout/master.jsp" %>
<form action='/SupermercadoGemidao/supermercado/store' method='post'>
    <div id='div-campo-nome'>
        <label for='campo-nome'>Nome</label>
        <input type='text' id='campo-nome' name='nome' required='required'>
    </div>
    <div id='div-campo-senha'>
        <label for='campo-senha'>Senha</label>
        <input type='text' id='campo-senha' name='senha' required='required'>
    </div>
    <div id='div-campo-email'>
        <label for='campo-email'>email</label>
        <input type='text' id='campo-email' name='email' required='required'>
    </div>
    <div id='div-campo-cpf'>
        <label for='campo-cpf'>cpf</label>
        <input type='text' id='campo-cpf' name='cpf' required='required'>
    </div>
    <div id='div-campo-idade'>
        <label for='campo-idade'>idade</label>
        <input type='text' id='campo-idade' name='idade' required='required'>
    </div>
    <div id='div-campo-telefone'>
        <label for='campo-telefone'>telefone</label>
        <input type='text' id='campo-telefone' name='telefone' required='required'>
    </div>

    <div id='div-campo-endereco'>
        <label for='campo-endereco'>endereco</label>
        <input type='text' id='campo-endereco' name='endereco' required='required'>
    </div>

    <input type='submit' value='Cadastrar'>
</form>

<%@include file="layout/footer.jsp" %>