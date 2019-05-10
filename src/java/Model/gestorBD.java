package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aideé Alvarez
 */
public class gestorBD {
    private Connection conexion;
    private ResultSet rs;
    private Statement st;
    
    public gestorBD(){
        conexion = ConexionBD.obtenerConexion();
    }
    
    public boolean getUsuario(String us, String pass){
        try {
         String sql = "SELECT * FROM Usuario WHERE usuario = ' "+us+" ' AND contraseña = '"+pass+"' AND estado = 1";
        PreparedStatement ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        rs.close();
        ps.close();
        return true;
        } catch (Exception e) {
            System.out.println("Error al traer el usuario. Favor de checar.");
            e.printStackTrace();
        return false;
        }
    } 
}
