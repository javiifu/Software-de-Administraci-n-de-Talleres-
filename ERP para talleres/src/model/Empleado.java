package model;
import java.util.ArrayList;


public class Empleado {
    //Atributos de la clase empleados
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String numeroSS;
    private String cuentaBancaria;
    private boolean disponible = true;
    private ArrayList<Servicio> servicios;
    //Creamos un constructor para la clase empleados
    public Empleado(String nombre, String apellidos, String dni, String telefono, String numeroSS, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numeroSS = numeroSS;
        this.cuentaBancaria = cuentaBancaria;
        this.servicios = new ArrayList<Servicio>();
        this.telefono = telefono;
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
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNumeroSS() {
        return numeroSS;
    }
    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }
    public String getCuentaBancaria() {
        return cuentaBancaria;
    }
    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getTelefono() {
        return this.telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;

    }
}
