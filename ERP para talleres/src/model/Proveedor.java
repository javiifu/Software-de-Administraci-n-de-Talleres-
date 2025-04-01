package model;
public class Proveedor {
    //Atributos de la clase
    private String nombre;
    private String cif;
    private String direccion;
    private int telefono;
    private String email;
    private String suministro;
    //Constructor de la clase
    public Proveedor (String nombre, String cif, String direccion, String suministro, int telefono, String email){
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.suministro = suministro;
    }
    //Creamos los métodos get y set para los atributos de la clase
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSuministro() {
        return suministro;
    }
    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }
}
