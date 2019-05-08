<%-- 
    Document   : index
    Created on : 4/05/2019, 09:24:18 PM
    Author     : Aideé Alvarez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello! ¡Estás ingresando desde un JSP!</h1>
         <%
		if (session != null) {
			if (session.getAttribute("usuario") != null) {
				String name = (String) session.getAttribute("usuario");
				out.print("Hello, " + name + " Bienvenido al sistema :D");
			} else {
				response.sendRedirect("login.html");
			}
		}
	%>
        <br>
        <br>
        <form action="Logout" method="post">
            <input type="submit" value="Salir">
        </form>
    </body>
</html>
