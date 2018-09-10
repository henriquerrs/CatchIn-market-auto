<%@include file="layout/masterSemNavBar.jsp" %>
<form action='/store' method='post'>
    <div class="section scrollspy" id="non-linear">
        <div class="row">
            <div class="col s12 center"><h5>Faça seu cadastro</h5></div>
            <div class="col l12 m12 s12">
                <div class="card">
                    <div class="card-content">
                        <ul class="stepper horizontal">
                            <li class="step active">
                                <div class="step-title waves-effect waves-dark">Dados Pessoais</div>
                                <div class="step-content">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="input-field col s6">
                                                <i class="material-icons prefix">account_circle</i>
                                                <input id="nome" type="text" class="validate required" name="nome">
                                                <label for="nome">Nome</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <i class="material-icons prefix">account_circle</i>
                                                <input id="endereco" type="text" class="validate" name="endereco" required>
                                                <label for="enderco">Endereço</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s6">
                                                <i class="material-icons prefix">perm_contact_calendar</i>
                                                <input id="idade_usuario" type="text" class="datepicker validate required" readonly="true">
                                                <label for="idade_usuario">Data</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <i class="material-icons prefix">phone</i>
                                                <input id="telefone" type="tel" class="validate" name="telefone">
                                                <label for="telefone">Telefone</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <i class="material-icons prefix">mail_outline</i>
                                                <input id="email" type="email" class="validate" name="email" required>
                                                <label for="email">e-mail</label>
                                            </div>
                                        </div>
                                        <div class="step-actions">
                                            <button class="waves-effect waves-dark btn blue next-step">CONTINUE</button>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="step">
                                <div class="step-title waves-effect waves-dark">Dados de Login</div>
                                <div class="step-content">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <i class="material-icons prefix">account_circle</i>
                                                <input name="login" id="login" type="text" class="validate" required>
                                                <label for="login">Login</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <i class="material-icons prefix">lock_open</i>
                                                <input id="senha" type="password" class="validate" name="senha" required>
                                                <label for="password">Senha</label>
                                            </div>
                                        </div>
                                        <div class="step-actions">
                                            <button class="waves-effect waves-dark btn blue next-step">CONTINUE</button>
                                            <button class="waves-effect waves-dark btn-flat previous-step">BACK</button>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="step">
                                <div class="step-title waves-effect waves-dark">Às compras</div>
                                <div class="step-content">
                                    <div class="container">
                                        <p style="text-align: center; margin-top: 30%;">Muito bem jovem gafanhoto, agora você está apto à fazer compras como um bom capitalista opressor<p>
                                        <!--<p style="text-align: center"> </p>-->
                                    </div>
                                    <div class="step-actions">
                                        <button type="submit" class="waves-effect waves-light btn" id="cadastrar">Cadastrar</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>    

    <%@include file="layout/footer.jsp" %>