import java.util.Scanner;

public class Taller {

    Scanner sc = new Scanner(System.in);
    int opcion;
    //sub Menu de Registro
    public void menuRegistro(){
        
        
        do{
            System.out.println("¿Qué desea registrar? (Escriba el número asociado a la opción):");
            System.out.println("1. Registrar Cliente.");
            System.out.println("2. Registrar Empleado.");
            System.out.println("3. Registrar Proveedor.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine(); //Todos los sc.nextLine() o sc.next() serán para limpiar el bufer del scanner
        } while (opcion !=4);

    }
    //sub Menu para servicios
    public void menuServicios(){

        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Crear Servicio.");
            System.out.println("2. Modificar Servicio.");
            System.out.println("3. Eliminar Servicio.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine(); 
        } while (opcion != 4);
    }
    //sub Menu para Inventario
    public void menuInventario(){

        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Añadir Producto.");
            System.out.println("2. Modificar Producto.");
            System.out.println("3. Eliminar Producto.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine(); 
        } while (opcion != 4);
    }
    //sub Menu para gestionar las facturas
    public void menuFacturas(){
        do { 
            System.out.pritnln("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Crear Factura.");
            System.out.println("2. Modificar Factura.");
            System.out.println("3. Mostrar Factura específica.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 4);
    }

    //sub Menu para gestionar las citas
    public void menuCitas(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Crear cita.");
            System.out.println("2. Modificar cita.");
            System.out.println("3. Eliminar cita.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();

        } while (opcion !=4);
    }
}
