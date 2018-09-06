$(function () {
    $("#entrar").on("click", function () {

        $.ajax({
            url: "/supermercado/login",
            method: "post",
            data: {
                login: $("#login").val(),
                senha: $("#senha").val()
            },
            success: function (data, textStatus, jqXHR) {
                var resultado = JSON.parse(data);
                sessionStorage.setItem("id", resultado.id);
                alert(resultado.id);
                window.location = "/";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Falhou ");
            }
        });
    });

});

$(function () {
    $("#cadastrar").on("click", function () {

        $.ajax({
            url: "/supermercado/store",
            method: "post",
            data: {
                nome: $("#login").val(),
                telefone: $("#telefone").val(),
                email: $("#email").val(),
                senha: $("#senha").val(),
                endereco: $("#endereco").val()
                
            },
            success: function (data, textStatus, jqXHR) {
                var resultado = JSON.parse(data);
                sessionStorage.setItem("id", resultado.id);
                alert(resultado.id);
                window.location = "/";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Falhou ");
            }
        });
    });

});