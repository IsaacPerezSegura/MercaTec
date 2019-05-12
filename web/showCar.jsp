<%@page import="java.util.ArrayList"%>
<%@page import="Model.Carrito"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="header.jsp" />
        
        <%!
            double total;
            GestorBD queryCarrito = new GestorBD();
            Carrito carrito;
            int idUser = 0;
        %> 
        <%
            idUser = Integer.parseInt(session.getAttribute("id").toString());
            
            carrito = queryCarrito.selectCarrito(idUser);
            total = 0;
        %>
        <table id="productsList">
        <%    for(Producto producto:carrito.getProductos()){
                total = total + producto.getPrecio();
        %>
            <tr>
                <td>
                    sadasdasd
                </td>
            </tr>
        <%    }
        %>
        </table>
        <jsp:include page="footer.jsp"/>
        
        <jsp:include page="scripts.html"/>
    </body>
</html>
