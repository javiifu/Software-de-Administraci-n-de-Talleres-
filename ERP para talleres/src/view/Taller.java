package view;
import java.util.Scanner;

public class Taller {


    //Atributos clase Taller
    Scanner sc = new Scanner(System.in);
    ClienteView clienteView = new ClienteView();
    ProveedorVew proveedorView = new ProveedorVew();
    PedidosView pedidosView = new PedidosView();
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
                    clienteView.crearCliente();
                }
                case 2 -> {
                    //Registrar empleado
                }
                case 3 -> {
                    proveedorView.crearProveedor();
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
            System.out.println("5. Listar Pedidos.");
            System.out.println("6. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    //listar empleados
                }
                case 2 -> {
                    clienteView.clientesMostrar();
                }
                case 3 -> {
                    //listar servicios
                }
                case 4 -> {
                    proveedorView.listarProveedores();
                }
                case 5 -> {
                    pedidosView.listarPedidos();
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
                    subMenuGestionProveedor();
                }
                case 2 -> {
                    //Gestionar empleados
                }
                case 3 -> {
                    subMenuGestionCliente();
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
    public void subMenuGestionCliente(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Modificar Cliente datos de cliente.");
            System.out.println("2. Eliminar Cliente.");
            System.out.println("3. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    clienteView.gestionarCliente();
                }
                case 2 -> {
                    clienteView.eliminarCliente();
                }
               default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        } while (opcion != 3);
    }
    public void subMenuGestionProveedor(){
        do { 
            System.out.println("¿Qué desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Modificar Proveedor datos de proveedor.");
            System.out.println("2. Eliminar Proveedor.");
            System.out.println("3. Volver al menú principal.");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> {
                    proveedorView.gestionarProveedores();
                }
                case 2 -> {
                    proveedorView.eliminarProveedor();
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        } while (opcion != 3);
    }

    public void MenuPedidos(){
        do{
            System.out.println("¿Que desea hacer? (Escriba el número asociado a la opción):");
            System.out.println("1. Registrar nuevo pedido.");
            System.out.println("2. Actualizar algún pedido");
            System.out.println("3. Eliminar Pedido.");
            System.out.println("4. Volver al menú Principal");
            opcion = sc.nextInt();
            sc.next();
            switch(opcion){
                case 1 -> {
                    pedidosView.crearPedido();
                }
                case 2 -> {
                    pedidosView.gestionarPedido();
                }
                case 3 -> {
                    pedidosView.eliminarPedido();
                }
                case 4 -> {
                    //Volvemos al menú principal
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        }while (opcion != 4);
    }
}
