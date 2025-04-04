package view;

import dao.VehiculoDAO;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Vehiculo;


public class VehiculoView {

    public void gestionarVehiculo() {

        VehiculoDAO vdao = new VehiculoDAO();
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String respuesta;
        String matricula = "Matricula";
        String marca = "Marca";
        String modelo = "Modelo";
        String color = "Color";
        String propietario = "Cliente";
        

        
        System.out.println("¿Qué vehiculo desea gestionar? Introduzca su matricula: ");
        respuesta = sc.next();
        Vehiculo vehiculo = vdao.buscarPorMatricula(respuesta);
        
        
        do{       

            System.out.println("¿Qué desea gestionar de su vehiculo?");
            System.out.println("1. Color");
            System.out.println("2. Propietario(DNI)");
            System.out.println("3. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca el color nuevo: ");
                    respuesta = sc.nextLine(); sc.next();
                    vdao.actualizar(color, respuesta, vehiculo.getMatricula());
                    
                }
                case 2 -> {
                    System.out.println("Introduzca el nuevo propietario(formato DNI): ");
                    respuesta = sc.nextLine(); sc.next();
                    vdao.actualizar(propietario, respuesta, vehiculo.getMatricula());
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    
            

        }while(eleccion != 5);

        
    }
    
    public void buscarCliente() {
        VehiculoDAO vdao = new VehiculoDAO();
        try (Scanner sc = new Scanner(System.in)) {
            String dni;
            boolean dniValido = false;
            
            do {
                System.out.print("Ingrese DNI a buscar (8 números + 1 letra): ");
                dni = sc.nextLine().trim().toUpperCase();
                
                // Validación del DNI
                if (dni.matches("^[0-9]{8}[A-Z]$")) {
                    dniValido = true;
                } else {
                    System.out.println("Formato de DNI incorrecto. Debe tener 8 números seguidos de 1 letra (ej: 12345678A)");
                }
            } while (!dniValido);
    
            Map<String, Object> cliente = vdao.buscarClientePorDni(dni);
    
            if (cliente != null) {
                System.out.println("\nCliente encontrado:");
                System.out.println("Nombre: " + cliente.get("nombre"));
                System.out.println("Apellidos: " + cliente.get("apellidos"));
                System.out.println("Vehículos:");
                
                @SuppressWarnings("unchecked")
                List<Map<String, String>> vehiculos = (List<Map<String, String>>) cliente.get("vehiculos");
    
                if (vehiculos.isEmpty()) {
                    System.out.println(" - No tiene vehículos registrados");
                } else {
                    for (Map<String, String> vehiculo : vehiculos) {
                        System.out.println(" - Matrícula: " + vehiculo.get("matricula"));
                    }
                }
            } else {
                System.out.println("\nNo se encontró ningún cliente con DNI: " + dni);
            }
        }
    }

    

}
