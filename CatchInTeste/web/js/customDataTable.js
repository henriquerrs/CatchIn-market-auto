$(document).ready(function () {
    $('#table-cliente').DataTable({
        responsive: true,
        "serverSide": true,
        "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            }
        },
        "ajax": "/produto/datatable",
        "order": [[0, "asc"]],
        "columns": [
            {"data": null,
                "render": function (data) {
                    return "R$ " + data.preco
                }},
            {"data": "nome"},
            {"data": "marca"},
            {
                "data": null,
                bSortable: false,
                "render": function (data) {
                    return  "<form action='/adicionar' method='get'>\
                                <button type='submit' data-toggle='tooltip' id='botao_add_carrinho' name='idStatus' value='lista' class='btn btn-secondary' data-toggle='tooltip' data-placement='left' data-original-title='Adicione à lista'><i class='fas fa-clipboard-list'></i></button>\
                                <input type='hidden' id='produtoCompra' name='idProduto' value='" + data.id + "'>\
                                <input type='number' id='botao_quantidade' name='quantidade' min='0' max='50' value='1'>\
                                <button type='submit' data-toggle='tooltip' id='botao_compra' name='idStatus' value='carrinho' class='btn btn-secondary' data-toggle='tooltip' data-placement='left' data-original-title='Adicione ao carrinho'><i class='fas fa-cart-plus'></i></button>\
                            </form>";
                }
            }
        ]
    });
});

$(document).ready(function () {
    $('#table-admin').DataTable({
        responsive: true,
        "serverSide": true,
        "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            }
        },
        "ajax": "/produto/datatable",
        "order": [[0, "asc"]],
        "columns": [
            {"data": null,
                "render": function (data) {
                    return "R$ " + data.preco
                }},
            {"data": "nome"},
            {"data": "marca"},
            {"data": "quantidade"},
            {
                "data": null,
                bSortable: false,
                "render": function (data) {
                    return  "<a class='center btn btn-secondary btn-sm editar-produto' data-id='" + data.id + "' data-whatever='@mdo'><i class='fas fa-edit' data-toggle='tooltip' data-placement='left' data-original-title='Editar Item'></i></a>\
                            <a class='center btn btn-danger btn-sm' href='/excluir?id=" + data.id + "'><i class='fas fa-trash-alt' data-toggle='tooltip' data-placement='left' data-original-title='Excluir Item'></i></a>";
                }
            }
        ]
    });

    $("#table-admin").on("click", ".editar-produto", function () {
        $id = $(this).data("id");
        $.ajax({
            url: "/produto/buscar",
            data: {
                id: $id
            },
            success: function (result) {
                $("#recipiente-id").val(result.id);
                $("#recipiente-nome").val(result.nome);
                $("#recipiente-preco").val(result.preco);
                $("#recipiente-peso").val(result.peso);
                $("#recipiente-quantidade").val(result.quantidade);
                $("#recipiente-marca").val(result.marca);
                $("#recipiente-categoria").val(result.categoria);
                $("#recipiente-descricao").val(result.descricao);
                $("#modalEditar").modal("show");

            }
        });
    });

});


$(document).ready(function () {
    $('#table-carrinho').DataTable({
        "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            }
        }
    });
});

