package view;
import dao.PedidoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Pedido;
import model.Proveedor;
import model.Producto;
import java.time.LocalDate;//importamos esta biblioteca para que cuando se cree el pedido se introduzca la fecha acutal en la que se realiza.
import java.time.format.DateTimeFormatter;  //Importamos esta biblioteca para poder cambiar la variable a tipo string. 

public class PedidosView {
    PedidoDAO peddao = new PedidoDAO();
    Scanner sc = new Scanner(System.in);
    
    public void gestionarPedido() {
        
        int eleccion;
        int numPedido;
        String respuesta;
        String fechaPedido = "Fecha_Pedido";
        String proveedor = "Proveedor";
        String costeUnidad = "CosteUnidad";
        String cantidad = "Cantidad";
        String producto = "Producto";
        String estado = "Estado";
        String fechaEntrega = "Fecha_Entrega";
        String fechaRecepcion = "Fecha_Recepcion";

        
        System.out.println("¿Qué pedido desea gestionar? Introduzca su numero de pedido: ");
        numPedido = sc.nextInt();
        sc.next();
        //Buscamos el pedido por su numero de pedido
        Pedido pedido = peddao.buscarPedido(numPedido);
        
        
        do{       

            System.out.println("¿Qué desea gestionar de su pedido?");
            System.out.println("1. Fecha del pedido");
            System.out.println("2. Proveedor");
            System.out.println("3. Coste unidad");
            System.out.println("4. Cantidad");
            System.out.println("5. Producto");
            System.out.println("6. Estado");
            System.out.println("7. Fecha de entrega");
            System.out.println("8. Fecha de recepcion");
            System.out.println("9. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca la nueva fecha del pedido: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(fechaPedido, respuesta, pedido.getNumeroPedido());
                    
                    
                }
                case 2 -> {
                    System.out.println("Introduzca el nuevo proveedor: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(proveedor, respuesta, pedido.getNumeroPedido());
                    
                    
                }
                case 3 -> {
                    System.out.println("Introduzca el nuevo coste unidad: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(costeUnidad, respuesta, pedido.getNumeroPedido());
                    
                    
                }
                case 4 -> {
                    System.out.println("Introduzca la nueva cantidad: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(cantidad, respuesta, pedido.getNumeroPedido());
                    
                    
                }
                case 5 -> {
                    System.out.println("Introduzca el nombre del prdocuto del que quiere hacer el pedido: )");
                    respuesta = sc.nextLine();
                    sc.next();
                    peddao.actualizarPedido(producto, respuesta, pedido.getNumeroPedido());
                }   
                case 6 -> {
                    System.out.println("Introduzca el nuevo estado: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(estado, respuesta, pedido.getNumeroPedido());
                }
                case 7 -> {
                    System.out.println("Introduzca la nueva fecha de entrega: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(fechaEntrega, respuesta, pedido.getNumeroPedido());
                }
                case 8 -> {
                    System.out.println("Introduzca la nueva fecha de recepcion: ");
                    respuesta = sc.nextLine();sc.next();
                    peddao.actualizarPedido(fechaRecepcion, respuesta, pedido.getNumeroPedido());
                }
                case 9 -> {
                    System.out.println("Saliendo del gestor de pedidos");
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
        }while (eleccion != 9);
    }
    public void crearPedido(){
        PedidoDAO peddao = new PedidoDAO();   
        int numPedido;
        LocalDate fechaPedido = LocalDate.now();  //utilizamos la siguiente funcion para poder realizar un pedido con la fecha actual.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nombreProveedor;
        int cantidad;
        int costeUnidad;
        String nombreProducto;
        Boolean estado = false; 
        String fechaEntrega;
        String fechaRecepcion;
        
        String fechaPedidoF = fechaPedido.format(formato);

        System.out.println("Introduzca los datos de su pedido");
        System.out.println("Número de pedido: ");
        numPedido = sc.nextInt();
        sc.next();

        System.out.println("Introduzca el nombre del producto del que quiere realizar el pedido");
        nombreProducto = sc.nextLine();
        sc.next();

        System.out.println("Introduzca la cantidad del producto: ");
        cantidad = sc.nextInt();
        sc.next();
        System.out.println("Introduzca el precio por unidad del prodcuto: ");
        costeUnidad = sc.nextInt();
        sc.next();

        System.out.println("Introduzca el nombre del proveedor: ");
        nombreProveedor = sc.nextLine();
        sc.next();

        System.out.println("Introduzca fecha de entrega (en este formato yyyy-mm-dd): ");
        fechaEntrega = sc.nextLine();
        sc.next();

        System.out.println("Introduzca fecha de Recepción (en este formato yyyy-mm-dd): ");
        fechaRecepcion = sc.nextLine();
        sc.next();

        Proveedor proveedor = new Proveedor(nombreProveedor, null, null, nombreProducto, null, null);
        Producto producto = new Producto(nombreProducto, cantidad, proveedor);

        Pedido pedido = new Pedido(numPedido, fechaPedidoF, proveedor, costeUnidad, cantidad, producto, estado, fechaEntrega, fechaRecepcion);

        peddao.insertarPedido(pedido);
        System.out.println("Pedido creado correctamente");
        
    }
    public void eliminarPedido(){
        int id;
        System.out.println("Introduzca el ID dle pedido que desea eliminar: ");
        id = sc.nextInt();
        sc.next();
        peddao.eliminarPedido(id);
        System.out.println("Pedido eliminado correctamente");
    }
    
    public ArrayList<Pedido> listarPedidos(){

        if (peddao.obtenerPedidos() != null) {
            ArrayList<Pedido> listaPedidos = peddao.obtenerPedidos();
            for (Pedido pedido : listaPedidos) {
                System.out.println("Número de pedido: " + pedido.getNumeroPedido());
                System.out.println("Fecha del pedido: " + pedido.getFechaPedido());
                System.out.println("Proveedor: " + pedido.getProveedor().getNombre());
                System.out.println("Coste unidad: " + pedido.getCosteUnidad());
                System.out.println("Cantidad: " + pedido.getCantidad());
                System.out.println("Producto: " + pedido.getProducto().getNombre());
                System.out.println("Estado: " + pedido.getEstado());
                System.out.println("Fecha de entrega: " + pedido.getFechaEntrega());
                System.out.println("Fecha de recepción: " + pedido.getFechaRecepcion());
                System.out.println("------------------------------");
            }
            return listaPedidos;
        } else {
            System.out.println("No hay pedidos disponibles.");
            return null;
        }
    }
}
