package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Model.Producto;
import Model.GestorBD;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
            GestorBD queries = new GestorBD();
            ArrayList<Producto> productos =  queries.selectProducts();
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("         <link rel=\"shortcut icon\" href=\"");
      out.print( request.getContextPath() );
      out.write("/img/gorro.ico\" />\r\n");
      out.write("        <title>MercaTec</title>\r\n");
      out.write("        <!-- Google font -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,500,700\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- Slick -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/slick.css\"/>\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/slick-theme.css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- nouislider -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/nouislider.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- Font Awesome Icon -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom stlylesheet -->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/style.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <!-- Contenido de index (articulos) -->\r\n");
      out.write("        <div class=\"section\">\r\n");
      out.write("            <!-- container -->\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <!-- row -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <!-- section title -->\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <div class=\"section-title\">\r\n");
      out.write("                            <h3 class=\"title\">Publicaciones recientes</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /section title -->\r\n");
      out.write("                    <!-- Products tab & slick -->\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"products-tabs\">\r\n");
      out.write("                                <!-- tab -->\r\n");
      out.write("                                <div id=\"tab1\" class=\"tab-pane active\">\r\n");
      out.write("                                    <div class=\"products-slick\" data-nav=\"#slick-nav-1\">\r\n");
      out.write("                                        <!-- product -->\r\n");
      out.write("                                        ");

                                            for(Producto producto:productos){
                                                
      out.write("\r\n");
      out.write("                                                <div class=\"product\">\r\n");
      out.write("                                                    <div class=\"product-img\">\r\n");
      out.write("                                                        <img src=\"");
      out.print( producto.getImage());
      out.write("\">\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"product-body\">\r\n");
      out.write("                                                        <h3 class=\"product-name\"><a href=\"#\">");
      out.print( producto.getNombreProd() );
      out.write("</a></h3>\r\n");
      out.write("                                                        <h4 class=\"product-price\">$");
      out.print( producto.getPrecio() );
      out.write("</h4>\r\n");
      out.write("                                                        <div class=\"product-rating\">\r\n");
      out.write("                                                            <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                                            <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                                            <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                                            <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                        <div class=\"product-btns\">\r\n");
      out.write("                                                            <button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">Ver producto</span></button>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div  class=\"add-to-cart\">\r\n");
      out.write("                                                        ");
 String send = String.valueOf(producto.getIdProducto())
                                                                    +"@"+producto.getImage()+"@"+producto.getNombreProd()
                                                                    +"@"+producto.getPrecio(); 
      out.write("\r\n");
      out.write("                                                        <button onclick=\"add('");
      out.print( send );
      out.write("')\" class=\"add-to-cart-btn\">\r\n");
      out.write("                                                            <i class=\"fa fa-shopping-cart\">        \r\n");
      out.write("                                                            </i> Añadir al carrito\r\n");
      out.write("                                                        </button>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                \r\n");
      out.write("                                                \r\n");
      out.write("                                                ");

                                            }
                                        
      out.write("\r\n");
      out.write("                                        <!-- /product -->\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div id=\"slick-nav-1\" class=\"products-slick-nav\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!-- /tab -->\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Products tab & slick -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /row -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /container -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /SECTION -->\r\n");
      out.write("        <hr style=\"color:black;\" />\r\n");
      out.write("        <!-- Articulos en general -->\r\n");
      out.write("        <div class=\"section\">\r\n");
      out.write("            <!-- container -->\r\n");
      out.write("            <div id=\"productsTable\">\r\n");
      out.write("                <!-- products -->\r\n");
      out.write("                ");

                    for (Producto producto : productos) {
                
      out.write("\r\n");
      out.write("                <div id=\"item\">\r\n");
      out.write("                    <div class=\"product\">\r\n");
      out.write("                        <div class=\"product-img\">\r\n");
      out.write("                            <img src=\"");
      out.print( producto.getImage());
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"product-body\">\r\n");
      out.write("                            <h3 class=\"product-name\"><a href=\"#\">");
      out.print( producto.getNombreProd());
      out.write("</a></h3>\r\n");
      out.write("                            <h4 class=\"product-price\">$");
      out.print( producto.getPrecio());
      out.write("</h4>\r\n");
      out.write("                            <div class=\"product-rating\">\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                                <i class=\"fa fa-star\"></i>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"product-btns\">\r\n");
      out.write("                                <button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">Ver producto</span></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"add-to-cart\">\r\n");
      out.write("                            <button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> Añadir al carrito</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                    <!-- /product -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>  \r\n");
      out.write("        <!-- limpiar contenedor -->\r\n");
      out.write("        <div style=\"clear:both\"></div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Scripts -->\r\n");
      out.write("        <script>\r\n");
      out.write("            function add(x){\r\n");
      out.write("                var propiedades = x.split(\"@\");\r\n");
      out.write("                var header = document.getElementById(\"carrito\");\r\n");
      out.write("                var nuevo = \"<div id='product-\"+propiedades[0]+\"' class='product-widget'>\"+\r\n");
      out.write("                                        \"<div class='product-img'>\"+\r\n");
      out.write("                                            \"<img src=\"+propiedades[1]+\">\"+\r\n");
      out.write("                                        \"</div>\"+\r\n");
      out.write("                                        \"<div class='product-body'>\"+\r\n");
      out.write("                                            \"<h3 class='product-name'><a href='#'>\"+propiedades[2]+\"</a></h3>\"+\r\n");
      out.write("                                            \"<h4 class='product-price'><span class='qty'>1x</span>$\"+propiedades[3]+\"</h4>\"+\r\n");
      out.write("                                        \"</div>\"+\r\n");
      out.write("                                        \"<button onclick=\\\"borrar('product-\"+propiedades[0]+\"@\"+propiedades[3]+\"')\\\" class='delete'><i class='fa fa-close'></i></button>\"+\r\n");
      out.write("                                    \"</div>\" ;\r\n");
      out.write("                header.innerHTML += nuevo;\r\n");
      out.write("                var totaltxt = document.getElementById(\"total\").innerHTML;\r\n");
      out.write("                var mounts = totaltxt.split(\"$\");\r\n");
      out.write("                var total = parseInt(mounts[1])+parseInt(propiedades[3]);\r\n");
      out.write("                document.getElementById(\"total\").innerHTML =\"SUBTOTAL: $\"+ total;\r\n");
      out.write("            }\r\n");
      out.write("            function borrar(x){\r\n");
      out.write("                var carrito = document.getElementById(\"carrito\");\r\n");
      out.write("                var propiedades = x.split(\"@\");\r\n");
      out.write("                var elemento = document.getElementById(propiedades[0])\r\n");
      out.write("                var totaltxt = document.getElementById(\"total\").innerHTML;\r\n");
      out.write("                var mounts = totaltxt.split(\"$\");\r\n");
      out.write("                var total = parseInt(mounts[1])-parseInt(propiedades[1]);\r\n");
      out.write("                document.getElementById(\"total\").innerHTML =\"SUBTOTAL: $\"+ total;\r\n");
      out.write("                carrito.removeChild(elemento);\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/slick.min.js\"></script>\r\n");
      out.write("        <script src=\"js/nouislider.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.zoom.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
