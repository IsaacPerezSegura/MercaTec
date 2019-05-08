package Controller;

import Model.gestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
/**
 *
 * @author Aideé Alvarez
 */
@WebServlet(name = "validacionUsuario", urlPatterns = {"/validacionUsuario"})
public class Validation extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Primero traerse los parámetros del html.
            String usuario = request.getParameter("user");
            String pass = request.getParameter("password");
            // Llamar al gestor de base de datos para realizar la búsqueda.
            gestorBD gestor = new gestorBD();
            if(gestor.getUsuario(usuario, pass)){
                //Si regresa un sí, se crea una sesión de usuario.
                HttpSession session = request.getSession(true);
                session.setAttribute( "usuario", usuario );
                response.sendRedirect("index.jsp");
            }else{
                         RequestDispatcher rd = request.getRequestDispatcher("login.html");
			out.println("<font color=red>El usuario o contraseña son incorrectos.</font>");
			rd.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }
    }
}