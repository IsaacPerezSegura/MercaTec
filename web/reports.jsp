<%-- 
    Document   : reports
    Created on : 15/05/2019, 04:13:56 PM
    Author     : Aideé Alvarez
--%>

<%@page import="Model.GestorBD"%>
<%@page import="Model.Reportes"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/buttons.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
        <title>JSP Page</title>
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
        <br>
        <% 
            Collection<Reportes> reports = new ArrayList<>();
            GestorBD gestor = new GestorBD();
            reports = gestor.getReports();
            
            Collection<Reportes> rep = null;
            rep = reports;
        %>
        
        <div class="container">
            <h3> Reportes publicados: </h3>
            <div class="table-responsive">
                <table  cellpadding="5" class="table table-striped table-hover">
                    <tr>
                        <td> ID </td>
                        <td> ID Usuario</td>
                        <td> ID Producto</td>
                        <td> Motivo</td>
                        <td colspan="2"> Acciones</td>
                    </tr>
                    <%
                            for(Reportes r:rep){
                    %>
                    <tr>
                        <td><%=r.getIdReporte()%></td>
                        <td><%=r.getIdUsuario()%></td>
                        <td><%=r.getIdProducto()%></td>
                        <td><%=r.getMotivo()%></td>
                        <td><a href="#"> Ver Reporte</a></td>
                        <td><a href="deleteReport?id=<%= r.getIdReporte() %>"> Eliminar Reporte</a></td>
                    </tr>
                    <% }%>
                    
                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
