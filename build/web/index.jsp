<%-- 
    Document   : index
    Created on : 9/05/2019, 07:41:09 PM
    Author     : Isaac Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <% if(session.getAttribute("id")== null){
            session.setAttribute("id", -1);
        } %>
        <jsp:include page="header.jsp" />
        
        <jsp:include page="products.jsp" />
        
        <jsp:include page="footer.jsp"/>
        
        <jsp:include page="scripts.html"/>
    </body>
</html>
