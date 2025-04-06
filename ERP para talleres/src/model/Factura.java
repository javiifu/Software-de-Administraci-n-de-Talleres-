package model;
public class Factura {
    //Atributos de la clase
    private int numeroFactura;
    private String fecha;
    private Cliente cliente;
    private int importe;
    private String servicio;

    //Constructor de la clase
    public Factura (int numeroFactura, String fecha, Cliente cliente, int importe, String servicio){
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.importe = importe;
    }
    public int getNumeroFactura(){
        return numeroFactura;
    }
    public void setNumeroFactura(int numeroFactura){
        this.numeroFactura = numeroFactura;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public int getImporte(){
        return importe;
    }
    public void setImporte(int importe){
        this.importe = importe;
    }
    public String getServicio(){
        return servicio;
    }
    public void setServicio(String servicio){
        this.servicio = servicio;
    }
   
}
