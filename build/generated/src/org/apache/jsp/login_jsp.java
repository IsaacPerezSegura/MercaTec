package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Login MercaTec</title>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<!--===============================================================================================-->\t\r\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"");
      out.print( request.getContextPath());
      out.write("/img/favicon.ico\"/>\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/util.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/main.css\">\r\n");
      out.write("<!--===============================================================================================-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"limiter\">\r\n");
      out.write("\t\t<div class=\"container-login100\">\r\n");
      out.write("\t\t\t<div class=\"wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50\">\r\n");
      out.write("                            <!-- MÉTODO POST PARA INGRESAR AL INDEX -->\r\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form\" action=\"validacionUsuario\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title p-b-33\">\r\n");
      out.write("\t\t\t\t\t\tAccount Login\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"El usuario es requerido\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"user\" placeholder=\"Usuario\" required>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100-1\"></span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100-2\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 rs1 validate-input\" data-validate=\"La contraseña es requerida\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"password\" placeholder=\"Contraseña\" required>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100-1\"></span>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100-2\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn m-t-20\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"login100-form-btn\">\r\n");
      out.write("\t\t\t\t\t\t\tSign in\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"text-center p-t-45 p-b-4\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"txt1\">\r\n");
      out.write("\t\t\t\t\t\t\tOlvidaste\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"txt2 hov1\">\r\n");
      out.write("\t\t\t\t\t\t\tUsuario / Contraseña?\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");

        if (request.getAttribute("LogError") != null) {
            out.print("<script>alert(\"" + request.getAttribute("LogError").toString() + "\")</script>");
        }
    
      out.write("\r\n");
      out.write("</html>");
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
