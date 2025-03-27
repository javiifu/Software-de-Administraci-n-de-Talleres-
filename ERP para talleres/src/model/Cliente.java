package model;
import java.util.ArrayList;


public class Cliente {
    //Atributos de la clase
    private String nombre;
    private String Apellidos;
    private String Dni;
    private String Direccion;
    private int telefono;
    private String email;
    private ArrayList<Vehiculo> vehiculos;
    //Constructor de la clase
    public Cliente (String nombre, String Apellidos, String Dni, String Direccion, int telefono, String email){
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.email = email;
        this.vehiculos = new ArrayList<Vehiculo>();

    }
    //Creamos los métodos get y set para los atributos de la clase
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }
    public String getDni() {
        return Dni;
    }
    public void setDni(String dni) {
        this.Dni = dni;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        this.Direccion = direccion;
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
}
