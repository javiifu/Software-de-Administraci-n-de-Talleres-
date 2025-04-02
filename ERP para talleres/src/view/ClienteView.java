package view;
import dao.ClientesDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {

    
    
    public void gestionarCliente() {

        ClientesDAO cldao = new ClientesDAO();
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String respuesta;
        String nombre = "Nombre";
        String apellidos = "Apellidos";
        String telefono = "Num_tlf";
        String direccion = "Direccion";
        String email = "Email";
        

        
        System.out.println("¿Qué cliente desea gestionar? Introduzca su dni: ");
        respuesta = sc.next();
        Cliente cliente = cldao.buscarPorDni(respuesta);
        
        
        do{       

            System.out.println("¿Qué desea gestionar de su cliente?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Direccion");
            System.out.println("4. Telefono");
            System.out.println("5. Email");
            System.out.println("6. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca el nombre nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    cldao.actualizar(nombre, respuesta, cliente.getdni());
                    
                    

                }
                case 2 -> {
                    System.out.println("Introduzca los apellidos nuevos: ");
                    respuesta = sc.nextLine();sc.next();
                    cldao.actualizar(apellidos, respuesta, cliente.getdni());

                    
                }
                case 3 -> {
                    System.out.println("Introduzca la direccion nueva: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(direccion, respuesta, cliente.getdni());
                    
                }
                case 4 -> {
                    System.out.println("Introduzca el telefono nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(telefono, respuesta, cliente.getdni());
                }
                case 5 -> {
                    System.out.println("Introduzca el email nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(email, respuesta, cliente.getdni());
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    
            

        }while(eleccion != 6);

        
    }

    public void crearCliente() {
        ClientesDAO cldao = new ClientesDAO();
        Scanner sc = new Scanner(System.in);
        String nombre;
        String apellidos;
        String telefono;
        String direccion;
        String email;
        String dni;
        

        System.out.println("Bienvenido a la creacion de clientes");
        System.out.println("Introduzca los valores de su cliente: ");

        System.out.println("Dni");
        dni = sc.nextLine();sc.next();

        System.out.println("Nombre");
        nombre = sc.nextLine();sc.next();

        System.out.println("Apellidos");
        apellidos = sc.nextLine();sc.next();

        System.out.println("Direccion");
        direccion = sc.nextLine();sc.next();

        System.out.println("Telefono");
        telefono = sc.nextLine();sc.next();

        System.out.println("Email");
        email = sc.nextLine();sc.next();

        Cliente cliente = new Cliente(nombre, apellidos, dni, direccion, telefono, email);
        cldao.insertar(cliente);
    }       
           
    public void eliminarCliente() {

        Scanner sc = new Scanner(System.in);
        ClientesDAO cldao = new ClientesDAO();
        String respuesta;
        boolean control = false;

        if (cldao.obtenerTodos() != null) {

            do{
                System.out.println("¿Qué cliente desea eliminar?");
                System.out.println("Introduzca su Dni: ");
                respuesta = sc.nextLine();sc.next();
            
                
                if ( cldao.buscarPorDni(respuesta) != null) {
        
                    cldao.eliminar(respuesta);
                    System.out.println("Cliente eliminado con exito");
                    control = true;
                } else {
                    System.out.println("El DNI que ha introducido no esta relacionado con ningun cliente existente");
                    
                }
    
            }while(!control);

        } else {
            System.out.println("Si no hay clientes como vas a borrarlos, iluminado");
        }
            
        

    }
        
    public ArrayList<Cliente> clientesMostrar() {
        ClientesDAO cldao = new ClientesDAO();

        if (cldao.obtenerTodos() != null) {
            ArrayList<Cliente> clientes = cldao.obtenerTodos();
    
            System.out.println("Clientes obtenidos");
            
            return clientes;
            
        }else {
            System.out.println("¿Otra vez intentando conseguir cosas que no existen?");
            return null;
        }
    }
    

}
