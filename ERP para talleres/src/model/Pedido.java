package model;

public class Pedido {
    private int numeroPedido;
    private String fechaPedido;
    private Proveedor proveedor;
    private int importe;
    private int cantidad;
    private Producto producto;
    private Boolean estado;
    private String fechaEntrega;
    private String fechaRecepcion;

    //Constructor 
    public Pedido(int numeroPedido, String fechaPedido, Proveedor proveedor, int importe, int cantidad, Producto producto, Boolean estado, String fechaEntrega, String fechaRecepcion) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.proveedor = proveedor;
        this.importe = importe;
        this.cantidad = cantidad;
        this.producto = producto;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.fechaRecepcion = fechaRecepcion;
    }
    //Creamos métodos get y set para los atributos de la clase
    public int getNumeroPedido() {
        return numeroPedido;
    }
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    public String getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public int getImporte() {
        return importe;
    }
    public void setImporte(int importe) {
        this.importe = importe;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public String getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
    
}
