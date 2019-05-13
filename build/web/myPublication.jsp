<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.GestorBD"%>
<%@page import="Model.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicaciones</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <%!
            GestorBD query = new GestorBD();
            ArrayList<Producto> productos;
            int iduser = -1;
        %>
        <%
            iduser = Integer.parseInt(session.getAttribute("id").toString());

             productos = query.selectProducts(iduser);
        %>
        <%
            if (productos.size() < 1) {%>
        <h2 style="margin-left: 20%; margin-top: 8%;">No haz realizado alguna publicación</h2>
        <%} else { %>
        <h2 style="margin-left: 20%; margin-top: 8%;">Tus publicaciones</h2>
        <%} %>
        <table id="productsList">
            <%    for (Producto producto : productos) {
            %>
            <tr>
                <td>
                    <img src="<%= producto.getImage()%>" />
                </td>
                <td>
                    <h1><%= producto.getNombreProd()%></h1>
                </td>
                <td>
                    <h4>Precio: $<%= producto.getPrecio()%></h4>
                </td>
                <td>
                    <form action="MyAccount" method="post">
                        <input type="hidden" name="idDelete" 
                               value="<%= producto.getIdProducto() %>"/>
                        <input class="deleteInput" type="image" 
                               src="<%= request.getContextPath()%>/img/deleteIcon.png"
                               alt="Eliminar"/>
                    </form>
                </td>
                <td>
                    <form action="MyAccount" method="post">
                        <input type="hidden" name="idEdit" 
                               value="<%= producto.getIdProducto() %>"/>
                        <input type="hidden" name="nombre"
                               value="<%= producto.getNombreProd() %>" />
                        <input type="hidden" name="descripcion"
                               value="<%= producto.getDecripción() %>"/>
                        <input type="hidden" name="precio"
                               value="<%= producto.getPrecio() %>"/>
                        <input type="hidden" name="unidades"
                               value="<%= producto.getUnidades() %>"/>
                        <input type="hidden" name="imagen"
                               value="<%= producto.getImage() %>"/>
                        <input class="deleteInput" type="image" 
                               src="<%= request.getContextPath()%>/img/editIcon.png"
                               alt="Modificar"/>
                    </form>
                </td>
            </tr>
            <%    }
            %>
        </table>
        <div id="actions">      
            <div>
                <%
                    if (productos.size() < 1) {%>
                <form action="#" method="post">
                    <input type="submit" value="Realizar publicación" />
                </form>
                <%}
                    productos.clear();
                %>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
        
        <jsp:include page="scripts.html" />
    </body>
</html>
