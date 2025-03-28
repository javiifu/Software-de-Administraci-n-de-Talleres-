package model;
import java.util.ArrayList;


public class Cliente {
    //Atributos de la clase
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int telefono;
    private String email;
    private ArrayList<Vehiculo> vehiculos;
    //Constructor de la clase
    public Cliente (String nombre, String apellidos, String dni, String direccion, int telefono, String email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
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
        return apellidos;
    }
    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getdni() {
        return dni;
    }
    public void setdni(String dni) {
        this.dni = dni;
    }
    public String getdireccion() {
        return direccion;
    }
    public void setdireccion(String direccion) {
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
}
