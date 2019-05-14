<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> My Account </title>
        <meta name="viewport" content="width=device=width, initial-scale=1">
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath()%>/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <header id="menuUsuario" align="center">
            <a href="<%= request.getContextPath() %>/index.jsp ">Inicio</a>
            <a href="<%= request.getContextPath() %>/myPublication.jsp ">Mis publicaciones</a>
            <a href="<%= request.getContextPath() %>/publication.jsp ">Hacer publicación</a>
        </header>
        
        <br>
        <div class="container">
           <h2> Mi cuenta</h2>
             <div class="row">
                <a  href="#">
                    <div class="col-sm-5 divStyle div">
                        <div class="images"> <img class="imgStyle" src="<%= request.getContextPath() %>/img/candado.png" alt=""></div>
                        <div><span>Inicio de Sesión</span></div>
                        <div class="colorSecondary"> <span>Editar inicio de sesión o nombre</span></div>
                    </div>
                </a>
                 <a href="#">
                     <div class="col-sm-5 divStyle div">
                         <div class="images"> <img class="imgStyle" src="<%= request.getContextPath() %>/img/tarjeta.png" alt=""></div>
                         <div><span> Opciones de pago</span></div>
                         <div class="colorSecondary"> <span>Editar o agregar métodos de pago </span></div>
                     </div>
                 </a>
             </div>
        </div>
        <jsp:include page="footer.jsp" />
        <jsp:include page="scripts.html" />
    </body>
</html>
