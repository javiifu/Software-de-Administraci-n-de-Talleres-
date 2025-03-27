package model;
public class Servicios {
    //Atributos de la clase Servicios
    private String nombre;
    private boolean terminado;
    private Empleados empleado;

    //Constructor para la clase
    public Servicios (String nombre, boolean terminado, Empleados empleado){
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
    public Empleados getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }
}
