import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Taller taller = new Taller();
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Hola bienvenido a ERP para talleres que hemos creado Marcos Blanquez y Javier Beltrán ");
        System.out.println("¿A que desea acceder? (Escriba el número asociado a la opción):");

        //Menu
        do { 
            System.out.println("1. Registros.");
            System.out.println("2. Servicios.");
            System.out.println("3. Inventario.");
            System.out.println("4. Facturas.");
            System.out.println("5. Citas.");
            System.out.println("6. Asignar empleado a un servicio");
            System.out.println("7. Listas (Empleados, Clientes, Servicios y Proveedores).");
            System.out.println("8. Gestionar (Proveedores, Empleados, Clientes).");
            System.out.println("9. Contabilidad.");
            System.out.println("10. Salir.");
            opcion = sc.nextInt();
            sc.nextLine(); //Limpiamos el bufer del scanner
        } while (opcion != 10);
        
        switch(opcion){
            case 1 -> taller.menuRegistro();
            case 2 -> taller.menuServicios();
            case 3 -> taller.menuInventario();
            case 4 -> taller.menuFacturas();
            case 5 -> taller.menuCitas();   
            case 6 -> taller.menuAsignarServicio();
            case 7 -> taller.menuListas();
            case 8 -> taller.menuGestionarDatosTaller();
            case 9 -> taller.menuContabilidad();
            case 10 -> System.out.println("Gracias por usar nuestro ERP para talleres.");
        }
        sc.close();
    }
}
