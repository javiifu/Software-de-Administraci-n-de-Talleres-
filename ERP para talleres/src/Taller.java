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

    //subMenu para encargar un servicio a un empleadol. 
    public void menuAsignarServicio(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Asignar servicio a un empleado.");
            System.out.println("2. Modificar servicio asignado a un empleado.");
            System.out.println("3. Eliminar servicio asignado a un empleado.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 4);
    }
    public void menuListas(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Listar Empleados.");
            System.out.println("2. Listar Clientes.");
            System.out.println("3. Listar Servicios.");
            System.out.println("4. Listar Proveedores.");
            System.out.println("5. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 5);
    }
    public void menuGestionarDatosTaller(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Gestionar Proveedores.");
            System.out.println("2. Gestionar Empleados.");
            System.out.println("3. Gestionar Clientes.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 4);
    }
    public void menuContabilidad(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Ver balance.");
            System.out.println("2. Ver ingresos.");
            System.out.println("3. Ver gastos.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 4);
    }
}
