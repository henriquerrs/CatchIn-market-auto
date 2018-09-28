<%@include file="layout/masterSemNavBar.jsp" %>
<form action='/store' method='post'>
    <div class="section scrollspy" id="non-linear">
        <div class="row">
            <div class="col s12 center"><h5>Faça seu cadastro</h5></div>
            <div class="col l12 m12 s12">
                <div class="card">
                    <div class="card-content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="nome" type="text" class="validate" required name="nome">
                                    <label for="nome">Nome</label>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">perm_contact_calendar</i>
                                    <input id="idade_usuario" type="text" class="datepicker" readonly="true" name="idade_usuario">
                                    <label for="idade_usuario">Data do Nascimento</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">phone</i>
                                    <input id="telefone" type="tel" class="validate" name="telefone">
                                    <label for="telefone">Telefone</label>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">art_track</i>
                                    <input id="cpf" type="text" class="validate" name="cpf">
                                    <label for="cpf">Cpf</label>
                                </div>
                            </div>
                            
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="cep" type="text" class="validate" required name="cep">
                                    <label for="cep">CEP</label>
                                </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="logradouro" type="text" class="validate" required name="logradouro">
                                    <label for="logradouro">Logradouro</label>
                                </div>
                            </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="complemento" type="text" class="validate" required name="complemento">
                                    <label for="complemento">Complemento</label>
                                </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="bairro" type="text" class="validate" required name="bairro">
                                    <label for="bairro">Bairro</label>
                                </div>
                            </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="cidade" type="text" class="validate" required name="cidade">
                                    <label for="cidade">Cidade</label>
                                </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="uf" type="text" class="validate" required name="uf">
                                    <label for="uf">UF</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">add_location</i>
                                    <input id="numero" type="number" class="validate" required name="numero">
                                    <label for="numero">Número</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">mail_outline</i>
                                    <input id="email" type="email" class="validate" required name="email">
                                    <label for="email">e-mail</label><br>
                                    <span style="color: red; font-size: smaller; margin-left: 11%">Este campo será usado para efetuar seu login</span>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">lock_open</i>
                                    <input id="senha" type="password" name="senha" class="validate" required>
                                    <label for="senha">Senha</label>
                                </div>
                            </div>
                            <div id="div_cadastro">
                                <a href="/login" class="btn btn-dark grey darken-2">Voltar</a>
                                <button type="submit" class="waves-effect waves-light btn blue" id="cadastrar">Cadastrar</button>
                            </div>
                        </div>
                    </div>
                    <!--
                    
                    <li class="step">
                        <div class="step-title waves-effect waves-dark">Dados de Login</div>
                        <div class="step-content">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input id="login" type="text" class="validate" required>
                                        <label for="login">Login</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">lock_open</i>
                                        <input id="senha" type="password" class="validate" required>
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
                                <p style="text-align: center"> </p>
                            </div>
                            <div class="step-actions">
                                <button type="submit" class="waves-effect waves-light btn" id="cadastrar">Cadastrar</button>
                            </div>
                        </div>
                    </li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
</form> 

<%@include file="layout/footer.jsp" %>