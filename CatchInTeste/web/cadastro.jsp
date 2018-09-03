<%@include file="layout/masterSemNavBar.jsp" %>
<form action='/supermercado/store' method='post'>
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
                                                <input id="first_name" type="text" class="validate required">
                                                <label for="first_name">Nome</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <i class="material-icons prefix">account_circle</i>
                                                <input id="last_name" type="text" class="validate required">
                                                <label for="last_name">Sobrenome</label>
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
                                                <input id="telefone" type="tel" class="validate">
                                                <label for="telefone">Telefone</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <i class="material-icons prefix">mail_outline</i>
                                                <input name="email" type="email" class="validate" required>
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
                                                <input name="login" type="text" class="validate" required>
                                                <label for="login">Login</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <i class="material-icons prefix">lock_open</i>
                                                <input name="password" type="password" class="validate" required>
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
                                        <p style="text-align: center">Você foi muito bem, receba esse código promocional para ganhar 5% de desconto na primeira compra!!<p><br/>
                                        <p style="text-align: center">Use Sabiamente</p>
                                    </div>
                                    <div class="step-actions">
                                        <a href="/index" id="btn-submit" class="waves-effect waves-dark btn blue">SUBMIT</a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="layout/footer.jsp" %>