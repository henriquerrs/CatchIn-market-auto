/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('#telefone').mask('(00)0 0000-0000');

    $('.stepper').activateStepper({
        autoFocusInput: true,
        autoFormCreation: true
    });


    $(function () {
        $("#idade_usuario").datepicker({minDate: now.getDate()});
    });

    $('.datepicker').datepicker({
        format: 'dd/mm/yyyy',
        i18n: {
            selectMonths: true, //Creates a dropdown to control month
            selectYears: 15, //Creates a dropdown of 15 years to control year
            //The title label to use for the month nav buttons
            labelMonthNext: 'Proximo Mês',
            labelMonthPrev: 'Mês Anterior',
            //The title label to use for the dropdown selectors
            labelMonthSelect: 'Selecionar Mês',
            labelYearSelect: 'Selecionar Ano',
            cancel: 'Cancelar',
            clear: 'Limpar',
            done: 'Ok',
            previousMonth: '‹',
            nextMonth: '›',
            months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Maio', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            weekdays: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
            //Materialize modified
            weekdaysAbbrev: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
            today: 'Hoje',
            close: 'Fechar',
            //The format to show on the `input` element
        }

    });
});
