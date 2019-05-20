<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
        <title> Mostrar Usuarios</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <header id="menuUsuario" align="center">
            <a href="<%= request.getContextPath() %>/index.jsp ">Inicio</a>
            <a href="<%= request.getContextPath() %>/myPublication.jsp ">Mis publicaciones</a>
            <a href="<%= request.getContextPath() %>/publication.jsp ">Hacer publicación</a>
             <%
                String admin =  session.getAttribute("type").toString();
                if(admin.equals("Administrador")){
            %>
            <a href="<%= request.getContextPath() %>/reports.jsp "> Reportes</a>
            <a href="<%= request.getContextPath() %>/users.jsp "> Usuarios</a>
            <% } %>
        </header>
        <%@ page import= "Model.Usuario,java.util.Collection" %>
        <h2> Los usuarios registrados son: </h2>
       <% 
            Collection<Usuario> usuario = null;
            usuario = (Collection<Usuario>) request.getAttribute("Usuarios");
       %> 
       <table cellpadding="5">
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
                for(Usuario us:usuario) {
        %>
        <tr>
            <td><%=us.getIdUsuario()%> </td>
            <td><%=us.getNombre() %> </td>
            <td><%=us.getUsuario()%> </td>
            <td><%=us.getContraseña()%> </td>
            <td><%=us.getTipo() %> </td>
            <td><%=us.getCorreo() %> </td>
            <td> <a href="#"> Eliminar </a></td>
        </tr>
        <% } %>
       </table>
        <p> Número de Usuarios registrados: <b> <%= usuario.size() %> </b></p>
        <% usuario.clear(); %>
        <br>
        <form action="#" method="POST">
            <input type="submit" value="Regresar"/>
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
