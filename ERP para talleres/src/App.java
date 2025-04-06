import java.util.Scanner;

import view.Taller;
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
            System.out.println("4. Pedidos.");
            System.out.println("5. Facturas.");
            System.out.println("6. Citas.");
            System.out.println("7. Asignar empleado a un servicio");
            System.out.println("8. Listas (Empleados, Cliente, Servicios, Proveedores y Vehiculos).");
            System.out.println("9. Gestionar (Proveedores, Empleados, Cliente y Vehiculos).");
            System.out.println("10. Contabilidad.");
            System.out.println("11. Salir.");
            opcion = sc.nextInt();
            sc.nextLine(); //Limpiamos el bufer del scanner
            switch(opcion){
                case 1 -> taller.menuRegistro();
                case 2 -> taller.menuServicios();
                case 3 -> taller.menuInventario();
                case 4 -> taller.MenuPedidos();
                case 5 -> taller.menuFacturas();
                case 6 -> taller.menuCitas();   
                case 7 -> taller.menuAsignarServicio();
                case 8 -> taller.menuListas();
                case 9 -> taller.menuGestionarDatosTaller();
                case 10 -> taller.menuContabilidad();
                case 11 -> System.out.println("Gracias por usar nuestro ERP para talleres.");
            } 
        } while (opcion != 10);
        
       
        sc.close();
    }
}
