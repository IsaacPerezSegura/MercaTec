<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD" %> 
<!DOCTYPE html>
<!-- Contenido de index (articulos) -->
<%! 
            GestorBD queries = new GestorBD();
            ArrayList<Producto> productos;
%>
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Publicaciones recientes</h3>
                </div>
            </div>
            <!-- /section title -->
            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab1" class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <!-- product -->
                                <%
                                    productos =  queries.selectProducts(-1);
                                    for(Producto producto:productos){
                                %>
                                <div class="product">
                                    <div class="product-img">
                                        <img src="<%= producto.getImage()%>">
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-name">
                                            <form action="ShowPublication" method="post">
                                                <input type="hidden" name="idProducto" 
                                                       value="<%= producto.getIdProducto() %>"/>
                                                <input type="submit" 
                                                       value="<%= producto.getNombreProd() %>"/>
                                            </form>
                                        </h3>
                                        <h4 class="product-price">
                                            $<%= producto.getPrecio() %>
                                        </h4>
                                        <form action="ShowPublication" method="post" class="product-btns">
                                            <input type="hidden" name="idProducto" 
                                                   value="<%= producto.getIdProducto() %>"/>
                                            <button class="quick-view">
                                                <i class="fa fa-eye"></i>
                                                <span class="tooltipp">
                                                    Ver producto
                                                </span>
                                            </button>
                                        </form>
                                    </div>
                                    <div  class="add-to-cart">
                                        <form action="carrito" method="post">
                                            <input type="hidden" name="requestURL" 
                                                value="<%= request.getRequestURI() %>" />
                                            <input type="hidden" value="<%= producto.getIdProducto() %>" 
                                                   name="id"/>
                                            <input type="submit"  value="Añadir al carrito" 
                                                   class="add-to-cart-btn" />
                                        </form>
                                    </div>
                                </div>
                                <%
                            }
                                %>
                                <!-- /product -->
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->
<hr style="color:black;" />
<!-- Articulos en general -->
<div class="section">
    <!-- container -->
    <div id="productsTable">
        <!-- products -->
        <%
            for (Producto producto : productos) {
        %>
        <div id="item">
            <div class="product">
                <div class="product-img">
                    <img src="<%= producto.getImage()%>">
                </div>
                <div class="product-body">
                    <h3 class="product-name">
                        <form action="ShowPublication" method="post">
                            <input type="hidden" name="idProducto" 
                               value="<%= producto.getIdProducto() %>"/>
                            <input type="submit" 
                                   value="<%= producto.getNombreProd()%>"/>
                        </form>
                    </h3>
                    <h4 class="product-price">$<%= producto.getPrecio()%></h4>
                    <form action="ShowPublication" method="post" class="product-btns">
                        <input type="hidden" name="idProducto" 
                               value="<%= producto.getIdProducto()%>"/>
                        <button class="quick-view">
                            <i class="fa fa-eye"></i>
                            <span class="tooltipp">
                                Ver producto
                            </span>
                        </button>
                    </form>
                </div>
                <div class="add-to-cart">
                    <form action="carrito" method="post">
                        <input type="hidden" name="requestURL" 
                               value="<%= request.getRequestURI() %>" />
                        <input type="hidden" value="<%= producto.getIdProducto()%>" name="id"/>
                        <input type="submit"  value="Añadir al carrito" 
                               class="add-to-cart-btn" />
                    </form>
                </div>
            </div>
        </div>
        <%
            }
            productos.clear();
        %>
        <!-- /product -->
    </div>
</div>  