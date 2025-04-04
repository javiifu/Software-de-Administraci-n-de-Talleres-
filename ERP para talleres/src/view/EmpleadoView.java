package view;


import dao.EmpleadoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Empleado;

public class EmpleadoView {

    public void gestionarEmpleado() {

        EmpleadoDAO emdao = new EmpleadoDAO();
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String respuesta;
        String nombre = "Nombre";
        String apellidos = "Apellidos";
        String telefono = "Num_tlf";
        String numeroseg = "NumeroSS";
        String cuenta = "CuentaBanco";
        

        
        System.out.println("¿Qué empleado desea gestionar? Introduzca su dni: ");
        respuesta = sc.next();
        Empleado empleado = emdao.buscarPorDni(respuesta);
        
        
        do{       

            System.out.println("¿Qué desea gestionar de su empleado?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Telefono");
            System.out.println("4. Numero Seguridad Social");
            System.out.println("5. Cuenta bancaria");
            System.out.println("6. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca el nombre nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    emdao.actualizar(nombre, respuesta, empleado.getDni());
    

                }
                case 2 -> {
                    System.out.println("Introduzca los apellidos nuevos: ");
                    respuesta = sc.nextLine();sc.next();
                    emdao.actualizar(apellidos, respuesta, empleado.getDni());

                    
                }
                case 3 -> {
                    System.out.println("Introduzca el telefono nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    emdao.actualizar(telefono, respuesta, empleado.getDni());
                    
                }
                case 4 -> {
                    System.out.println("Introduzca el numero de la seguridad social nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    emdao.actualizar(numeroseg, respuesta, empleado.getDni());
                }
                case 5 -> {
                    System.out.println("Introduzca el numero de cuenta nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    emdao.actualizar(cuenta, respuesta, empleado.getDni());
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    
            

        }while(eleccion != 6);

        
    }

    public void crearEmpleado() {
        EmpleadoDAO emdao = new EmpleadoDAO();
        Scanner sc = new Scanner(System.in);
        String nombre;
        String apellidos;
        String telefono;
        String numeroseg;
        String cuenta;
        String dni;
        

        System.out.println("Bienvenido a la creacion de empleados");
        System.out.println("Introduzca los valores de su empleado: ");

        System.out.println("Dni");
        dni = sc.nextLine();sc.next();

        System.out.println("Nombre");
        nombre = sc.nextLine();sc.next();

        System.out.println("Apellidos");
        apellidos = sc.nextLine();sc.next();

        System.out.println("Numero Seguridad Social");
        numeroseg = sc.nextLine();sc.next();

        System.out.println("Teléfono");
        telefono = sc.nextLine();sc.next();

        System.out.println("Cuenta Bancaria");
        cuenta = sc.nextLine();sc.next();

        Empleado empleado = new Empleado(nombre, apellidos, dni, telefono, numeroseg, cuenta);
        emdao.insertar(empleado);
    }

    public void eliminarEmpleado() {

        Scanner sc = new Scanner(System.in);
        EmpleadoDAO emdao = new EmpleadoDAO();
        String respuesta;
        boolean control = false;

        if (emdao.obtenerTodos() != null) {

            do{
                System.out.println("¿Qué empleado desea eliminar?");
                System.out.println("Introduzca su Dni: ");
                respuesta = sc.nextLine();sc.next();
            
                
                if ( emdao.buscarPorDni(respuesta) != null) {
        
                    emdao.eliminar(respuesta);
                    System.out.println("Empleado eliminado con exito");
                    control = true;
                } else {
                    System.out.println("El DNI que ha introducido no esta relacionado con ningun empleado existente");
                    
                }
    
            }while(!control);

        } else {
            System.out.println("Si no hay empleados como vas a borrarlos, iluminado");
        }
            
        

    }

    public void empleadosMostrar() {
        EmpleadoDAO emdao = new EmpleadoDAO();
        if (emdao.obtenerTodos() != null) {
            
            ArrayList<Empleado> empleados = emdao.obtenerTodos();

            for (Empleado empleado : empleados) {
                System.out.println(empleado);

            }
    
            System.out.println("Empleados obtenidos");
            
            
        } else {
            System.out.println("¿Otra vez intentando conseguir cosas que no existen?");
            
        }
    }

}
