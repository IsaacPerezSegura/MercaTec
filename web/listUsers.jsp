<%@page import="Model.GestorBD"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
        <title> Mostrar Usuarios</title>
        <script>
            function atras() {
                history.back();
            }
            ;
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <header id="menuUsuario" align="center">
            <a href="<%= request.getContextPath()%>/index.jsp ">Inicio</a>
            <a href="<%= request.getContextPath()%>/myPublication.jsp ">Mis publicaciones</a>
            <a href="<%= request.getContextPath()%>/publication.jsp ">Hacer publicación</a>
            <%
                String admin = session.getAttribute("type").toString();
                if (admin.equals("Administrador")) {
            %>
            <a href="<%= request.getContextPath()%>/reports.jsp "> Reportes</a>
            <a href="<%= request.getContextPath()%>/users.jsp "> Usuarios</a>
            <% } %>
        </header>
        <%@ page import= "Model.Usuario,java.util.Collection" %>

        <%
            Collection<Usuario> users = new ArrayList<>();
            GestorBD gestor = new GestorBD();
            users = gestor.getUsuarios();
            Collection<Usuario> usuario = null;
            usuario = users;
        %> 
        <div class="container">
            <br>
            <h2> Los usuarios registrados son: </h2>
            <div class="table-responsive">
                <table cellpadding="5" class="table table-striped table-hover">
                    <tr>
                        <th> ID   </th>
                        <th> Nombre </th>
                        <th> Usuario </th>
                        <th> Contraseña </th>
                        <th> Tipo </th>
                        <th> Correo </th>
                        <th> Acciones </th>
                    </tr>
                    <%
                        if (usuario.size() == 0) {
                    %>
                    <tr>
                        <td colspan="7" align="center"> Por el momento no hay usuarios registrados.</td>
                    </tr>
                    <%
                    } else {
                        for (Usuario us: usuario) {
                    %>
                    <tr>
                        <td><%=us.getIdUsuario()%> </td>
                        <td><%=us.getNombre()%> </td>
                        <td><%=us.getUsuario()%> </td>
                        <td><%=us.getContraseña()%> </td>
                        <td><%=us.getTipo()%> </td>
                        <td><%=us.getCorreo()%> </td>
                        <td> <a href="deleteUser?id=<%= us.getIdUsuario()%>"> Eliminar </a></td>
                    </tr>
                    <% } }%>
                </table>
            </div>
            <p> Número de Usuarios registrados: <b> <%= usuario.size()%> </b></p>
            <% usuario.clear();%>
            <br>

            <input type="submit" class=" btn-default" value="Regresar" onclick="atras();"/>
        </div>
        <br> <br>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
