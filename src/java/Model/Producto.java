package Model;

import java.sql.Blob;
import java.util.ArrayList;

public class Producto {
    private int idProducto;
    private String nombreProd;
    private Blob imagenProd;
    private String decripción;
    private double precio;
    private int existencia;
    private int unidades;
    private ArrayList<Producto> productos;
    private Producto producto;
    
    public Producto(int idProducto, String nombreProd, Blob imagenProd, String decripción, double precio, int existencia, int unidades) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.imagenProd = imagenProd;
        this.decripción = decripción;
        this.precio = precio;
        this.existencia = existencia;
        this.unidades = unidades;
    }
    public Producto(){
        
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
