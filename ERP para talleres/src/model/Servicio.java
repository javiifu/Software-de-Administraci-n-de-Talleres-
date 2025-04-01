package model;
public class Servicio {
    //Atributos de la clase Servicios
    private String nombre;
    private boolean terminado;
    private Empleado empleado;

    //Constructor para la clase
    public Servicio (String nombre, boolean terminado, Empleado empleado){
        this.nombre = nombre;
        this.terminado = terminado;
        this.empleado = empleado;
    }
    //Creamos los métodos get y set para los atributos de la clase
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isTerminado() {
        return terminado;
    }
    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
