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
                window.location = "/";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Falhou ");
            }
        });
    });

});