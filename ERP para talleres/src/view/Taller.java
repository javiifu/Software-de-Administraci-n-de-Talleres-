package view;
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
            switch(opcion){

                case 1 -> {
                    //Registrar el clinete
                }
                case 2 -> {
                    //Registrar empleado
                }
                case 3 -> {
                    //Registrar proveedor
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
    
            }
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
            switch(opcion){
                case 1 -> {
                    //Crear servicio
                }
                case 2 -> {
                    //Modificar servicio
                }
                case 3 -> {
                    //Eliminar servicio
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
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
            switch(opcion){
                case 1 -> {
                    //Añadir producto
                }
                case 2 -> {
                    //Modificar producto
                }
                case 3 -> {
                    //Eliminar producto
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        } while (opcion != 4);
    }
    //sub Menu para gestionar las facturas
    public void menuFacturas(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Crear Factura.");
            System.out.println("2. Modificar Factura.");
            System.out.println("3. Mostrar Factura específica.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    //Crear factura
                }
                case 2 -> {
                    //Modificar factura
                }
                case 3 -> {
                    //Mostrar factura específica
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
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
            switch(opcion){
                case 1 -> {
                    //Crear cita
                }
                case 2 -> {
                    //Modificar cita
                }
                case 3 -> {
                    //Eliminar cita
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
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
            switch(opcion){
                case 1 -> {
                    //Asignar servicio a un empleado
                }
                case 2 -> {
                    //Modificar servicio asignado a un empleado
                }
                case 3 -> {
                    //Eliminar servicio asignado a un empleado
                }
                case 4 -> {
                    //Volver al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        } while (opcion != 4);
    }
    public void menuListas(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Listar Empleados.");
            System.out.println("2. Listar Cliente.");
            System.out.println("3. Listar Servicios.");
            System.out.println("4. Listar Proveedores.");
            System.out.println("5. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    //listar empleados
                }
                case 2 -> {
                    //listar clientes
                }
                case 3 -> {
                    //listar servicios
                }
                case 4 -> {
                    //listar proveedores
                }
            }
        } while (opcion != 5);
        
    }
    public void menuGestionarDatosTaller(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Gestionar Proveedores.");
            System.out.println("2. Gestionar Empleados.");
            System.out.println("3. Gestionar Cliente.");
            System.out.println("4. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    //Gestionar proveedores
                }
                case 2 -> {
                    //Gestionar empleados
                }
                case 3 -> {
                    //Gestionar clientes
                }
            }
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
            switch(opcion){
                case 1 -> {
                    //ver balance
                }
                case 2 -> {
                    //ver ingresos
                }
                case 3 -> {
                    //ver gastos
                }
            }
        } while (opcion != 4);
        
    }
    public void Asignacion
}
