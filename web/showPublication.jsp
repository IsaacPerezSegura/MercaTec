<%-- 
    Document   : showPublication
    Created on : 13/05/2019, 07:43:25 PM
    Author     : Isaac Perez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Comentario"%>
<%@page import="Model.GestorBD"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/showPublication.css"
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%!  
            Producto producto;
            Usuario usuario;
            GestorBD query = new GestorBD();
            ArrayList<Comentario> comentarios;
            boolean wasBoughtByCustomer = false;
        %>
        <% producto = (Producto)request.getAttribute("producto"); 
            usuario = query.showUsuarioProduct(producto.getIdUsuario());
        %>
        <div id="ficha">
            <img src="<%= producto.getImage() %>" />
            <div align="center">
                <h2><%= producto.getNombreProd() %></h2>
                <p>10 opiniones</p>
                <h3>Precio: $<%= producto.getPrecio() %></h3>
                <br />
                <h4>Descripción:</h4>
                <h5><%= producto.getDecripción() %></h5>
                <form name="unidadesForm">
                    <%!
                        int min = 0;
                        int valueU=0;
                    %>
                    <%
                        if(producto.getUnidades()>0){
                            valueU = 1;
                            min = 1;
                        }else{
                            valueU = 0;
                            min = 0;
                        }
                    %>
                    <br />
                    Cantidad: 
                    <input type="number" value="<%= valueU %>" 
                           min="<%= min %>"
                           max="<%= producto.getUnidades() %>">
                    Unidades disponibles: <%= producto.getUnidades() %>
                </form>
                <footer align="left">
                    <p>Nombre del vendedor: <%= usuario.getNombre() %></p>
                    <p>Corre electornico del vendedor: <%= usuario.getCorreo() %></p>
                </footer>
                <div>
                    <% if((int)session.getAttribute("id") == producto.getIdUsuario()){ %>
                    <form action="MyAccount" method="post" enctype="multipart/form-data">
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
                        <input class="deleteInput" type="submit" 
                               value="Modificar"
                               alt="Modificar"/>
                    </form>
                    <% }else{ %>
                    <form action="ShowPublication" method="post">
                        <input type="hidden" name="addCar" value="<%= producto.getIdProducto() %>"/>
                        <input type="submit" value="Agregar al carrito">
                    </form>
                    <form action="#" method="post">
                        <input type="submit" value="Comprar">
                    </form>
                    <% } %>
                </div>
            </div>
        </div>
                
                <section id="comentarios">
                    <h4>Comentarios:</h4>
                    <% comentarios= query.getComentarios(producto.getIdProducto()); %>
                    <!-- Comentario apertura -->
                    <% for(Comentario comentario: comentarios){ %>
                    <div>
                        <header>
                            <h5><%= comentario.getNombreUsuario() %></h5>
                        </header>
                        <div>
                           <%= comentario.getComentario() %>
                        </div>
                    </div>
                    <% } comentarios.clear(); %>
                    <!-- Comentario cierre -->
                    <% 
                    wasBoughtByCustomer = query.wasBoughtByCustomer((int)session.getAttribute("id")
                            ,producto.getIdProducto());
                    /*if(wasBoughtByCustomer){ */%>
                        <form action="ShowPublication" method="post">
                            <h4>Publicar comentario:</h4>
                            <textarea id="makeCommentContent" name="comentario" 
                                      rows="10" cols="40" required="true"></textarea>
                            <br/>
                            <input type="hidden" name="idProducto" value="<%= producto.getIdProducto() %>"/>
                            <input type="hidden" name="idUsuario" value="<%= (int)session.getAttribute("id") %>"/>
                            <input type="submit" value="Comentar" />
                        </form>
                    <%// } %>
                </section>
        
        <jsp:include page="footer.jsp" />
        <jsp:include page="scripts.html" />
    </body>
</html>
