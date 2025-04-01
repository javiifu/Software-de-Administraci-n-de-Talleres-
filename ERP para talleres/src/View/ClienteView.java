package view;
import dao.ClientesDAO;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {

    
    
    public void actualizarCliente() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String respuesta;
        String nombre = "Nombre";
        String apellidos = "Apellidos";
        String telefono = "Num_tlf";
        String direccion = "Direccion";
        String email = "Email";
        String dni ="DNI_Cliente";

        
           
            System.out.println("¿Qué cliente desea actualizar? Introduzca su dni: ");
            respuesta = sc.next();
    
            ClientesDAO cldao = new ClientesDAO();
    
            Cliente cliente = cldao.buscarPorDni(respuesta);
        

        do{



            System.out.println("¿Qué desea actualizar de su cliente?");
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
                    cldao.actualizar(nombre, respuesta, cliente.getDni());
                    
                    

                }
                case 2 -> {
                    System.out.println("Introduzca los apellidos nuevos: ");
                    respuesta = sc.nextLine();sc.next();
                    cldao.actualizar(apellidos, respuesta, cliente.getDni());

                    
                }
                case 3 -> {
                    System.out.println("Introduzca la direccion nueva: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(direccion, respuesta, cliente.getDni());
                    
                }
                case 4 -> {
                    System.out.println("Introduzca el telefono nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(telefono, respuesta, cliente.getDni());
                }
                case 5 -> {
                    System.out.println("Introduzca el email nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    cldao.actualizar(email, respuesta, cliente.getDni());
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    
            

        }while(eleccion != 7);

        
    }

    

}
