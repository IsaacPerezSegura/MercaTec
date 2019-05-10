package Model;

import java.sql.Blob;
import java.sql.SQLException;

public class Producto {
    private int idProducto;
    private String nombreProd;
    private Blob imagenProd;
    private String decripción;
    private double precio;
    private int existencia;
    private int unidades;
    private String image;
    
    public Producto(int idProducto, String nombreProd, Blob imagenProd, String decripción, double precio, int existencia, int unidades) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.imagenProd = imagenProd;
        this.decripción = decripción;
        this.precio = precio;
        this.existencia = existencia;
        this.unidades = unidades;
        try {
            this.image = "data:image/png;base64,"+new String(imagenProd.getBytes(1, (int)imagenProd.length()));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Producto(){
        
    }

    public String getImage() {
        return image;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public Blob getImagenProd() {
        return imagenProd;
    }

    public void setImagenProd(Blob imagenProd) {
        this.imagenProd = imagenProd;
    }

    public String getDecripción() {
        return decripción;
    }

    public void setDecripción(String decripción) {
        this.decripción = decripción;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
}
