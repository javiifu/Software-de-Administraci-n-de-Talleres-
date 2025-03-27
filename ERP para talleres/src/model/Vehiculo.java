package model;
import java.util.ArrayList;


public class Vehiculo {
    //Atributos de la clase vehiculos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String tipoCombustible;
    private Cliente propietario;
    private ArrayList<Servicio> servicios;

    //Constructor de la clase vehículos

    public Vehiculo(String matricula, String marca, String modelo, String color, String tipoCombustible, Cliente propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.propietario = propietario;
        this.servicios = new ArrayList<Servicio>();
    }

    //Creamos de momento métodos get y set de los atributos de la clase vehículos. 

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    public Cliente getPropietario() {
        return propietario;
    }
    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
}
