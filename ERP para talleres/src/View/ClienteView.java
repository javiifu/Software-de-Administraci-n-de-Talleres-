package view;
import java.util.Scanner;

import model.*;
import model.Cliente;
import ClientesDAO;

public class ClienteView {

    
    private int nuevoTelefono;
    private String nuevoNombre;
    private String nuevoApellido;
    private String nuevoDni;
    private String nuevaDireccion;
    private String nuevoEmail;

    public void actualizarCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        do{
            System.out.println("¿Qué desea actualizar de su cliente?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Dni");
            System.out.println("4. Direccion");
            System.out.println("5. Telefono");
            System.out.println("6. Email");
            System.out.println("7. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca el nombre nuevo: ");
                    this.nuevoNombre = sc.nextLine();sc.next();
                    cliente.setNombre(this.nuevoNombre);
                    cliente.actualizar(Nombre, nuevoNombre, )

                }
                case 2 -> {
                    System.out.println("Introduzca los apellidos nuevos: ");
                    this.nuevoApellido = sc.nextLine();sc.next();
                    cliente.setApellidos(this.nuevoApellido);
                }
                case 3 -> {
                    System.out.println("Introduzca el dni nuevo: ");
                    this.nuevoDni = sc.nextLine();sc.next();
                    cliente.setDni(this.nuevoDni);
                    
                }
                case 4 -> {
                    System.out.println("Introduzca la direccion nueva: ");
                    this.nuevaDireccion = sc.nextLine(); sc.next();
                    cliente.setDireccion(this.nuevaDireccion);
                    
                }
                case 5 -> {
                    System.out.println("Introduzca el telefono nuevo: ");
                    this.nuevoTelefono= sc.nextInt();
                    cliente.setTelefono(this.nuevoTelefono);
                }
                case 6 -> {
                    System.out.println("Introduzca el email nuevo: ");
                    this.nuevoEmail = sc.nextLine(); sc.next();
                    cliente.setEmail(this.nuevoEmail);
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    
            

        }while(eleccion != 7);

        
    }

    public String getNuevoNombre() { return nuevoNombre; }
    public String getNuevoApellido() { return nuevoApellido; }
    public String getNuevoDni() { return nuevoDni; }
    public String getNuevaDireccion() { return nuevaDireccion; }
    public String getNuevoEmail() { return nuevoEmail; }
    public int getNuevoTelefono() { return nuevoTelefono; }

}
