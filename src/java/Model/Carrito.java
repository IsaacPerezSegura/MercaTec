package Model;

import java.util.ArrayList;

public class Carrito{
    private ArrayList<Producto> productos;
    private int idAregacion;

    public Carrito(ArrayList<Producto> productos, int idAregacion) {
        this.productos = productos;
        this.idAregacion = idAregacion;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getIdAregacion() {
        return idAregacion;
    }

    public void setIdAregacion(int idAregacion) {
        this.idAregacion = idAregacion;
    }
    
}
