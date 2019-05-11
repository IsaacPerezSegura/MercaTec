package Model;

import java.util.ArrayList;

public class Carrito{
    private ArrayList<Integer> idproducto;
    public Carrito(ArrayList<Integer> idproducto){
        this.idproducto = idproducto;
    }

    public ArrayList<Integer> getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(ArrayList<Integer> idproducto) {
        this.idproducto = idproducto;
    }
    
    
}
