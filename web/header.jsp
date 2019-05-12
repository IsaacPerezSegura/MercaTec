<%@page import="java.util.ArrayList"%>
<%@page import="Model.Carrito"%>
<%@page import="Model.Producto"%>
<%@page import="Model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<header>
    <%!
        double total;
        GestorBD queryCarrito = new GestorBD();
        Carrito carrito;
    %> 
    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="<%= request.getContextPath() %>/index.jsp" class="logo">
                            <img src="<%= request.getContextPath() %>/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="Search" method="post">
                            <input class="input" placeholder="¡Encuentra lo que buscas!">
                            <button type="submit" class="search-btn">Buscar</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <div class="dropdown">
                            <%
                            if(session.getAttribute("id") == null){
                                %>
                                <form action="login.jsp">
                                    <input type="submit" value="Iniciar sesión"/>
                                </form>
                                <%
                            }else{%>
                                <form action="cuenta.jsp">
                                    <input type="submit" value="Mi cuenta"/>
                                </form>
                                <form action="Logout">
                                    <input type="submit" value="Cerrar sesión"/>
                                </form>
                            <% }
                            %>
                        </div>
                    </div>
                    <div class="header-ctn">
                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Carrito</span>
                                <!-- Icono que representa el numero de articulos en el carrito -->
                                <div class="qty">3</div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <%  
                                        total = 0;
                                        if(session.getAttribute("id")!=null){
                                        carrito = queryCarrito.selectCarrito(
                                                Integer.parseInt(
                                                        session.getAttribute("id").toString()
                                                ));
                                        for(Producto producto:carrito.getProductos()){
                                            total = total + producto.getPrecio();
                                    %>
                                      <!-- Productos en carrito -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="<%= producto.getImage() %>">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#"><%= producto.getNombreProd() %></a></h3>
                                            <h4 class="product-price"><span class="qty">1x</span>$<%= producto.getPrecio() %></h4>
                                        </div>
                                        <form action="carrito" method="post">
                                            <input type="hidden" name="idDelete" 
                                                   value="<%= producto.getIdPc() %>"/>
                                            <input type="submit" class="delete" value="x"/>
                                        </form>
                                    </div>      
                                    <%  }
                                    %>
                                    <!-- Contador de productos en carro -->
                                    <!--  -->
                                </div>
                                    <small><%= carrito.getProductos().size() %> producto(s)</small>
                                    <% carrito.getProductos().clear(); }%>
                                    <h5 id="total">SUBTOTAL: $<%= total %></h5>
                                <div class="cart-btns">
                                    <form action="carrito">
                                        <button value="show" name="show">
                                            Ver carrito
                                        </button>
                                    </form>
                                    <form action="carrito">
                                        <button value="buy" name="buy">
                                            Comprar
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /Cart -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>