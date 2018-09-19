<% if (((ClienteBean) session.getAttribute("cliente")).getPessoaBean().getIdPrivilegio() == 4) { %>
    <script>
        window.location.replace("/");
    </script>
<% } %>