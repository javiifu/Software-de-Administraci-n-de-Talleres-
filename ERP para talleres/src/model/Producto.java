package model;
public class Producto {
    private String nombre;
    private int stock;
    private Proveedor proveedor;
    
    //constructor
    public Producto(String nombre, int stock, Proveedor proveedor) {
        this.nombre = nombre;
        this.stock = stock;
        this.proveedor = proveedor;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }  

}
