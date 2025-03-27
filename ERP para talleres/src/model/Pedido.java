package model;

public class Pedido {
    private int numeroPedido;
    private String fecha;
    private Proveedor proveedor;
    private int importe;
    private int cantidad;
    private Producto producto;
    private Boolean estado;
    private String fechaEntrega;
    private String fechaRecepcion;

    //Constructor 
    public Pedido(int numeroPedido, String fecha, Proveedor proveedor, int importe, int cantidad, Producto producto, Boolean estado, String fechaEntrega, String fechaRecepcion) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.importe = importe;
        this.cantidad = cantidad;
        this.producto = producto;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.fechaRecepcion = fechaRecepcion;
    }
    
}
