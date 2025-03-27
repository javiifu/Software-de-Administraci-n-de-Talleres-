
public class Pedidos {
    private int numeroPedido;
    private String fecha;
    private Proveedores proveedor;
    private int importe;
    private int cantidad;
    private Productos producto;
    private Boolean estado;
    private String fechaEntrega;
    private String fechaRecepcion;

    //Constructor 
    public Pedidos(int numeroPedido, String fecha, Proveedores proveedor, int importe, int cantidad, Productos producto, Boolean estado, String fechaEntrega, String fechaRecepcion) {
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
