<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Mostrar Usuarios</title>
    </head>
    <body>
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
    </body>
</html>
