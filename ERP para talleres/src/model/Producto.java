package model;
public class Producto {
    private String nombre;
    private int stock;
    private int precio;
    private Proveedor proveedor;
    
    //constructor
    public Producto(String nombre, int stock, int precio, Proveedor proveedor) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }  

}
