package Model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aideé Alvarez
 */
public class GestorBD {
    private Connection conexion;
    private ResultSet rs;
    private Statement st;
    private Producto producto;
    private ArrayList<Producto> productos;
    //Arrays para carrito
    private ArrayList<Carrito> carrito;
    private ArrayList<Integer> claveProductos;
    
    private PreparedStatement ps;
    private ResultSet result;
    
    public GestorBD(){
        conexion = ConexionBD.obtenerConexion();
    }
    
    public boolean getUsuario(String us, String pass){
        try {
            String sql = "SELECT * FROM Usuario WHERE usuario = ' "+us+" ' AND contraseña = '"+pass+"' AND estado = 1";
            ps = conexion.prepareStatement(sql);
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
    
    public ArrayList<Producto> selectProducts(){
        productos = new ArrayList();
        try {
            ps = conexion.prepareStatement("select * from productos");
            result = ps.executeQuery();
            while (result.next()) {
                productos.add(new Producto(
                        result.getInt(1), 
                        result.getString(2), 
                        result.getBlob(3), 
                        result.getString(4), 
                        result.getDouble(5), 
                        result.getInt(6), 
                        result.getInt(7)
                ));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }
    public Producto selectProduct(int id){
        try {
            ps = conexion.prepareStatement("select * from productos where idProducto=?");
            ps.setInt(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                producto = new Producto(
                        result.getInt(1), 
                        result.getString(2), 
                        result.getBlob(3), 
                        result.getString(4), 
                        result.getDouble(5), 
                        result.getInt(6), 
                        result.getInt(7)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return producto;
    }
    public ArrayList<Producto> selectCarrito(int id){
        productos = new ArrayList();
        try {
            ps = conexion.prepareStatement("select productos.idProducto, productos.nombreProd, "
                    + "productos.imagenProd, productos.decripcion, productos.precio,"
                    + " productos.existencia, productos.unidades " +
                "from Productos_Carrito inner join carrito " +
                "on carrito.idCarrito = Productos_Carrito.idCarrito inner join usuario " +
                "on carrito.idUsuario = usuario.idUsuario inner join productos " +
                "on Productos_Carrito.idProducto = productos.idProducto " +
                "where usuario.idUsuario = ?"
            );
            ps.setInt(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                productos.add(new Producto(
                        result.getInt(1), 
                        result.getString(2), 
                        result.getBlob(3), 
                        result.getString(4), 
                        result.getDouble(5), 
                        result.getInt(6), 
                        result.getInt(7)
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }
}
