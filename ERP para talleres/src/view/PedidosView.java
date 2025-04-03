package view;
import dao.PedidoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Pedido;
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
}
