/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var $cpf = $("#cpf");
    $('#cpf').mask('000.000.000-00', {reverse: true});
});
$(function () {
    $('#telefone').mask('(00)0 0000-0000');
    $('#cep').mask('00000-000');

    $('.stepper').activateStepper({
        autoFocusInput: true,
        autoFormCreation: true
    });


    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.autocomplete');
        var instances = M.Autocomplete.init(elems, options);
    });



    // Or with jQuery

//    $(document).ready(function(){
//        $('.datepicker').datepicker();
//    });

var d = new Date();
    $('.datepicker').datepicker({

        format: 'dd/mm/yyyy',
        yearRange: 100,
        maxYear: d.getFullYear(),
        minYear: '1900',

        i18n: {
            minDate: null,
            maxDate: null,
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
            months: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Maio', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            weekdays: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
            //Materialize modified
            weekdaysAbbrev: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
            today: 'Hoje',
            close: 'Fechar'

                    //The format to show on the `input` element
        }

    });
});

$(document).ready(function () {
    $('#myTable').pageMe({
        pagerSelector: '#myPager',
        activeColor: 'indigo',
        prevText: 'Anterior',
        nextText: 'Siguiente',
        showPrevNext: true,
        hidePageNumbers: false,
        perPage: 10
    });
});

$(document).ready(function () {
    $('.slider').slider();
});

$('#modalProdutos').on('shown.bs.modal', function () {
    $('#modalInput').trigger('focus');
});

$('#finalizar').click(function (){
    new PNotify({
    title: 'Compra',
    text: 'Compra finalizada.',
    type: 'success'
  });
});

var input_selector = 'input[type=text], input[type=password], input[type=email], input[type=tel], input[type=number], textarea';
     $(input_selector).each(function(){
    // Add active if value was embedded in HTML
    $(document).on('change', input_selector, function () {
      if($(this).val().length !== 0) {
       $(this).siblings('label, i').addClass('active');
      }
    });
     // Add active if Form auto complete was used
    $(document).on('change', input_selector, function () {
      if($(this).val().length !== 0) {
       $(this).siblings('label, i').addClass('active');
      }
    })
     // Add active when element has focus
    $(document).on('focus', input_selector, function () {
      $(this).siblings('label, i').addClass('active');
    });
     $(document).on('blur', input_selector, function () {
      console.log($(this).is(':valid'));
      if ($(this).val().length === 0) {
        $(this).siblings('label, i').removeClass('active');
        }
    },
     };
