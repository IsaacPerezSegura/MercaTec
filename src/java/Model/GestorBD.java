package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Carrito carrito;
    private ArrayList<Integer> claveProductos;
    
    private PreparedStatement ps;
    private ResultSet result;
    
    public String typeUser = "";
    
    private Usuario usuario;
    
    public GestorBD(){
        conexion = ConexionBD.obtenerConexion();
    }
    
    public int getUsuario(String us, String pass){
        int id = 0;
        try {
            String sql = "SELECT idUsuario, tipo FROM Usuario WHERE usuario = '"+us+"' AND contraseña = '"+pass+"' AND estado = 1";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("idUsuario");
                typeUser = rs.getString("tipo");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al traer el usuario. Favor de checar.");
            e.printStackTrace();
        }
        return id;
    }
    
    public ArrayList<Producto> selectProducts(int id){
        productos = new ArrayList();
        try {
            if(id != -1){
                ps = conexion.prepareStatement("select * from productos where idUsuario=?");
                ps.setInt(1, id);
            }else{
                ps = conexion.prepareStatement("select * from productos");
            }
            
            result = ps.executeQuery();
            while (result.next()) {
                producto = new Producto(
                        result.getInt(1), 
                        result.getString(3), 
                        result.getBlob(4), 
                        result.getString(5), 
                        result.getDouble(6), 
                        result.getInt(7), 
                        result.getInt(8)
                );
                producto.setIdUsuario(result.getInt(2));
                productos.add(producto);
                
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
            if (result.next()) {
                producto = new Producto(
                        result.getInt(1), 
                        result.getString(3), 
                        result.getBlob(4), 
                        result.getString(5), 
                        result.getDouble(6), 
                        result.getInt(7), 
                        result.getInt(8)
                );
                producto.setIdUsuario(result.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return producto;
    }
    public Carrito selectCarrito(int id){
        productos = new ArrayList();
        carrito = new Carrito();
        try {
            int idPC = 0;
            ps = conexion.prepareStatement("select productos_carrito.id,productos.idProducto"
                    + ", productos.nombreProd, "
                    + "productos.imagenProd, productos.descripcion, productos.precio,"
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
                        result.getInt(2), 
                        result.getString(3), 
                        result.getBlob(4), 
                        result.getString(5), 
                        result.getDouble(6), 
                        result.getInt(7), 
                        result.getInt(8)
                ));
            }
            carrito.setProductos(productos);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return carrito;
    }
    public void insertProductCarrito(int idUsuario, int idProducto){
        try {
            ps = conexion.prepareStatement("select idCarrito from carrito"
                    + " where idUsuario=?"
            );
            ps.setInt(1, idUsuario);
            result = ps.executeQuery();
            int idCarrito = 0;
            if(result.next()){
                idCarrito = result.getInt(1);
            }
            ps = conexion.prepareStatement("insert into productos_carrito (idCarrito,idProducto)"
                    + " values(?,?)");
            ps.setInt(1, idCarrito);
            ps.setInt(2, idProducto);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void deleteProductCarrito(int idPC){
        try {
            ps = conexion.prepareStatement("delete from productos_carrito"
                    + " where id=?");
            ps.setInt(1,idPC);
            if(ps.executeUpdate()!=0){
                System.out.println("Eliminado del carrito");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public ArrayList<Producto> searchProducto(String productoS){
        productos = new ArrayList();
        try {
            ps = conexion.prepareStatement("select * from productos");
            result = ps.executeQuery();
            while(result.next()){
                if(result.getString(3).toLowerCase().contains(productoS.toLowerCase())){
                    producto = new Producto(
                        result.getInt(1), 
                        result.getString(3), 
                        result.getBlob(4), 
                        result.getString(5), 
                        result.getDouble(6), 
                        result.getInt(7), 
                        result.getInt(8)
                    );
                    producto.setIdUsuario(result.getInt(2));
                    productos.add(producto);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }
    public void insertProduct(int id, Producto producto){
        try {
            ps = conexion.prepareStatement("insert into productos ("
                    + "idUsuario,"
                    + "nombreProd,"
                    + "imagenProd,"
                    + "descripcion,"
                    + "precio,"
                    + "existencia,"
                    + "unidades"
                    + ") values ("
                    + "?,?,?,?,?,1,?"
                    + ")");
            ps.setInt(1, id);
            ps.setString(2, producto.getNombreProd());
            ps.setBytes(3, producto.getImage().getBytes());
            ps.setString(4, producto.getDecripción());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getUnidades());
            if(ps.executeUpdate()!=0){
                System.out.println("Producto insertado exitoso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void deleteProduct(int idProducto){
        try {
            ps = conexion.prepareStatement("delete from productos where idProducto=?");
            ps.setInt(1, idProducto);
            if(ps.executeUpdate()!=0){
                System.out.println("Eliminado");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void modifyProduct(Producto producto) {
        try {
            ps = conexion.prepareStatement("update productos set "
                    + "nombreProd=?,"
                    + "imagenProd=?,"
                    + "descripcion=?,"
                    + "precio=?,"
                    + "existencia=?,"
                    + "unidades=? where idProducto=?"
            );
            ps.setString(1,producto.getNombreProd());
            ps.setBytes(2, producto.getImage().getBytes());
            ps.setString(3, producto.getDecripción());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getExistencia());
            ps.setInt(6, producto.getUnidades());
            ps.setInt(7, producto.getIdProducto());
            if (ps.executeUpdate() != 0) {
                System.out.println("Producto insertado exitoso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Usuario showUsuarioProduct(int idUsuario){
        usuario = new Usuario();
        try {
            ps = conexion.prepareStatement("select * from usuario where idUsuario=?");
            ps.setInt(1,idUsuario);
            result = ps.executeQuery();
            if(result.next()){
                usuario.setNombre(result.getString(2));
                usuario.setCorreo(result.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuario;
    }
}
