<%-- 
    Document   : publication
    Created on : 12/05/2019, 08:47:51 PM
    Author     : Isaac Perez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo publicación</title>
        <link type="text/css" rel="stylesheet" 
              href="<%= request.getContextPath() %>/css/myAccount.css" />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form action="Publication" method="post" id="newPublication" 
              enctype="multipart/form-data">
            <h3>Por favor ingresa todos los datos solicitados</h3>
            <h5>
                Nombre del producto: 
                <input type="text" required="true" name="nombre"/>
            </h5>
            <h5>
                Introduce una descripción: 
                <input type="text" name="descripcion" value=""/>
            </h5>
            <h5>
                Indica su precio: $
                <input type="number" required="true" min="0" name="precio" 
                       value="0"/>
            </h5>
            <h5>
                Numero de unidades disponibles: 
                <input type="number" required="true" min="0" name="unidades" 
                       value="1"/>
            </h5>
            <h5 style="display:flex;">
                Selecciona una imagen:
                <input type="file" id="image" onChange="loadImage()" 
                       style="margin-left: 5%" required="true" name="imagen">
                <div id="imageContainer">
                    <output id="list"></output>
                </div>
            </h5>
            <input type="submit" value="Publicar" />
        </form>
        
        
        <jsp:include page="footer.jsp" />
        
        <script>
            function loadImage() {
                var archivo = document.getElementById("image");
                var imagen = archivo.files[0];
                var reader = new FileReader();
                //se solicita leer el objeto file como URL
                reader.readAsDataURL(imagen);
                reader.onloadend = function(){
                        document.getElementById("list").innerHTML = "<img class=\"photo\" src=\""+reader.result+"\" title=\""+imagen.name+"\"/>";
                }
            }	
        </script>
    </body>
</html>
