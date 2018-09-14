$(document).ready(function() {
    var table = $('#table-admin').DataTable( {
        responsive: true
    } );
 
    new $.fn.dataTable.FixedHeader( table );
} );
