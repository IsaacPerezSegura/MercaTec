/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBD;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Aideé Alvarez
 */
@WebServlet(name = "ShowUsers", urlPatterns = {"/ShowUsers"})
public class ShowUsers extends HttpServlet {

  
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
           Collection <Usuario> users = new ArrayList<>();
           GestorBD gestor = new GestorBD();
            users = gestor.getUsuarios();
           if(users != null){
               request.setAttribute("Usuarios", users);
               request.getRequestDispatcher("/listUsers.jsp").forward(request, response);
           }else{
               request.getRequestDispatcher("/NoRegisters.jsp").forward(request, response);
           }
        } finally {
         out.close();
        }
    }
}
