<%-- 
    Document   : index
    Created on : 9/05/2019, 07:41:09 PM
    Author     : Isaac Perez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.GestorBD" %> 
<%@page import="Controller.Carrito"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shortcut icon" href="<%= request.getContextPath() %>/img/gorro.ico" />
        <title>MercaTec</title>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%! 
            GestorBD queries = new GestorBD();
            ArrayList<Producto> productos;
        %>
        
        <!-- Contenido de index (articulos) -->
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
                                            productos =  queries.selectProducts();
                                            for(Producto producto:productos){
                                                %>
                                                <div class="product">
                                                    <div class="product-img">
                                                        <img src="<%= producto.getImage()%>">
                                                    </div>
                                                    <div class="product-body">
                                                        <h3 class="product-name"><a href="#"><%= producto.getNombreProd() %></a></h3>
                                                        <h4 class="product-price">$<%= producto.getPrecio() %></h4>
                                                        <div class="product-rating">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <div class="product-btns">
                                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">Ver producto</span></button>
                                                        </div>
                                                    </div>
                                                    <div  class="add-to-cart">
                                                        <form action="carrito" method="post">
                                                            <input type="hidden" value="<%= producto.getIdProducto() %>" name="id"/>
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
                            <h3 class="product-name"><a href="#"><%= producto.getNombreProd()%></a></h3>
                            <h4 class="product-price">$<%= producto.getPrecio()%></h4>
                            <div class="product-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-btns">
                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">Ver producto</span></button>
                            </div>
                        </div>
                        <div class="add-to-cart">
                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> Añadir al carrito</button>
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
        <!-- limpiar contenedor -->
        <div style="clear:both"></div>
        <jsp:include page="footer.jsp"/>
        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
