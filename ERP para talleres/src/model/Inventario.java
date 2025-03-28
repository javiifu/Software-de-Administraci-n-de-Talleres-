package model;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public Inventario(){
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
        
    }
    public void eliminarProducto(Producto producto){
        this.productos.remove(producto);
        
    }
}
