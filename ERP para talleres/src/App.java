import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Hola bienvenido a ERP para talleres que hemos creado Marcos Blanquez y Javier Beltrán ");
        System.out.println("¿A que desea acceder? (Escriba el número asociado a la opción):");

        //Menu
        do { 
            System.out.println("1. Registros.");
            System.out.println("2. Servicios.");
            System.out.println("3. Inventario.");
            System.out.println("4. Asiganar empleado a Servicio.");
            System.out.println("5. Citas.");
            System.out.println("6. Facturas.");
            System.out.println("7. Listas (Empleados, Clientes, Servicios y Proveedores).");
            System.out.println("8. Gestionar (Proveedores, Empleados, Clientes).");
            System.out.println("9. Contabilidad.");
            System.out.println("10. Salir.");
            opcion = sc.nextInt();
            sc.nextLine(); //Limpiamos el bufer del scanner
        } while (opcion != 10);

        sc.close();
    }
}
