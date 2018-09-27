<div class='modal fade' id='modalEditar' tabindex='-1' role='dialog' aria-labelledby='modalProdutos' aria-hidden='true'>
    <div class='modal-dialog modal-lg' role='document'>
        <div class='modal-content'>
            <div class='modal-header'>
                <h5 class='modal-title' id='modalProdutos'>Adicionar Produto</h5>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <form action='/editar' method='get'>
                <div class='modal-body'>
                    <input type="hidden" id="recipiente-id" name="id_produto">
                    <div class='row'>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Nome:</label>
                            <input type='text' class='form-control' id='recipiente-nome' name='nome' data-error='Por favor, informe um nome do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Preço:</label>
                            <input type='number' step="0.01" class='form-control' id='recipiente-preco' name='preco' data-error='Por favor, informe um preço do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Peso:</label>
                            <input type='number' step="0.01" class='form-control' id='recipiente-peso' name='peso' data-error='Por favor, informe um peso do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                        <div class='form-group col s6'>
                            <label for='recipient-name' class='col-form-label'>Quantidade:</label>
                            <input type='number' class='form-control' id='recipiente-quantidade' name='quantidade' data-error='Por favor, informe um quantidade do produto.' required>
                            <div class='helper-block with-errors'></div>
                        </div>
                    </div>
                    <div class='form-group'>
                        <label for='recipient-name' class='col-form-label'>Marca:</label>
                        <input type='text' class='form-control' id='recipiente-marca' name='marca' data-error='Por favor, informe um marca do produto.' required>
                        <div class='helper-block with-errors'></div>
                    </div>
                    <div class='form-group'>
                        <label for='recipient-name' class='col-form-label'>Categoria:</label>
                        <input type='text' class='form-control' id='recipiente-categoria' name='categoria' data-error='Por favor, informe um categoria do produto.' required>
                        <div class='helper-block with-errors'></div>
                    </div>
                    <div class='form-group'>
                        <label for='message-text' class='col-form-label'>Descrição:</label>
                        <textarea class='form-control' id='recipiente-descricao' name='descricao'></textarea>
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