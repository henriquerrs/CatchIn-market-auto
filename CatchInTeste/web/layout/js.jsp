<script src="../tema/bootstrap/jquery/jquery-3.3.1.min.js"></script>
<script src="../js/validator.min.js"></script>
<script src="../tema/bootstrap/jquery/popper.min.js"></script>
<script src="../tema/bootstrap/js/bootstrap.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<!--<script src="../js/customJSBootstrap.js"></script>-->
<script src="../js/dataTables.bootstrap4.min.js"></script>
<script src="../js/portuguese-Brasil.json"></script>
<script src="../js/customDataTable.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/pnotify.custom.min.js"></script>


<script>
    $(document).ready(function () {
        $("body").tooltip({
            selector: "[data-toggle='tooltip']",
            container: "body"
        })
                .popover({
                    selector: "[data-toggle='popover']",
                    container: "body",
                    html: true
                });
    });
</script>