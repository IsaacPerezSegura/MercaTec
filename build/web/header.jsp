<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
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
                            //session.setAttribute("id", new String("1"));
                            if(session.getAttribute("id") == null){
                                %>
                                <form action="login.html">
                                    <input type="submit" value="Iniciar sesión"/>
                                </form>
                                <%
                            }else{%>
                                <form action="cuenta.jsp">
                                    <input type="submit" value="Mi cuenta"/>
                                </form>
                                <form action="index.jsp">
                                    <input type="submit" value="Cerrar sesión"/>
                                </form>
                            <%}
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
                                    <!-- Productos en carrito -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="./img/product01.png" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                                        </div>
                                        <button class="delete"><i class="fa fa-close"></i></button>
                                    </div>
                                </div>
                                <div class="cart-summary">
                                    <!-- Contador de productos en carro -->
                                    <!--  -->
                                    <small>3 producto(s)</small>
                                    <h5>SUBTOTAL: $2900.00</h5>
                                </div>
                                <div class="cart-btns">
                                    <form>
                                        <a href="#">Ver carrito</a>
                                        <a href="#">Comprar  <i class="fa fa-arrow-circle-right"></i></a>
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