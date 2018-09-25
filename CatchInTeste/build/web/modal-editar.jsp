<div class='modal fade' id='modalEditar' tabindex='-1' role='dialog' aria-labelledby='modalProdutos' aria-hidden='true'>
    <div class='modal-dialog modal-lg' role='document'>
        <div class='modal-content'>
            <div class='modal-header'>
                <h5 class='modal-title' id='modalProdutos'>Adicionar Produto</h5>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <form action='/editar' data-toggle='validator' method='post'>
                <br>
                <div class='modal-body'>
                    <div class='row'>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Nome:</label>
                            <input type='text' class='form-control' value="+data.nome+" id='recipient-name' name='nome' data-error='Por favor, informe um nome do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Preço:</label>
                            <input type='number' class='form-control'value="+data.preco+"id='recipient-preco' name='preco' data-error='Por favor, informe um preço do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Peso:</label>
                            <input type='number' class='form-control' value="+data.peso+"id='recipient-peso' name='peso' data-error='Por favor, informe um peso do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Quantidade:</label>
                            <input type='number' class='form-control' value="+data.quantidade+" id='recipient-quantidade' name='quantidade' data-error='Por favor, informe um quantidade do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                    </div>
                    <div class='form-group'>
                        <label for='recipient-name' class='col-form-label'>Marca:</label>
                        <input type='text' class='form-control' value="+data.marca+" id='recipient-marca' name='marca' data-error='Por favor, informe um marca do produto.' required>
                        <div class='helper-block with-errors'></div>
                    </div>
                    <div class='form-group'>
                        <label for='recipient-name' class='col-form-label'>Categoria:</label>
                        <input type='text' class='form-control' value="+data.categoria+" id='recipient-categoria' name='categoria' data-error='Por favor, informe um categoria do produto.' required>
                        <div class='helper-block with-errors'></div>
                    </div>
                    <div class='form-group'>
                        <label for='message-text' class='col-form-label'>Descrição:</label>
                        <textarea class='form-control' value="+data.descricao+" id='message-descricao' name='descricao'></textarea>
                    </div>
                </div>
                <div class='modal-footer'>
                    <button type='button' class='btn btn-secondary' data-dismiss='modal'>Fechar</button>
                    <button type='submit' class='btn btn-primary'>Editar Produto</button>
                </div>
            </form>
        </div>
    </div>
</div>