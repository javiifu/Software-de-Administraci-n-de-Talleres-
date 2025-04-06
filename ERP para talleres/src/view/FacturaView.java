package view;
import java.util.Scanner;
import model.Factura;
import model.Cliente;
import dao.FacturaDAO;
import java.time.LocalDate;//importamos esta biblioteca para que cuando se cree el pedido se introduzca la fecha acutal en la que se realiza.
import java.time.format.DateTimeFormatter;  //Importamos esta biblioteca para poder cambiar la variable a tipo string.
public class FacturaView {
    Scanner sc = new Scanner(System.in);
    FacturaDAO facturaDAO = new FacturaDAO();
    public void crearFactura() {
        LocalDate fechaFactura = LocalDate.now();  //utilizamos la siguiente funcion para poder realizar un pedido con la fecha actual.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fechaFacturaF = fechaFactura.format(formato);
        System.out.println("Introduce el número de factura:");
        int numeroFactura = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Introduce el dni del cliente:");
        String dniCliente = sc.nextLine();
        System.out.println("Introduce el servicio:");
        String servicio = sc.nextLine();
        System.out.println("Introduce el importe:");
        int importe = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        //Creamos la factura 
        //Antes tenemos que crear el cliente para poder asignarselo a la factura
        Cliente cliente = new Cliente("", "", dniCliente, "", "", "");
        Factura factura = new Factura(numeroFactura, fechaFacturaF, cliente, importe, servicio);
        facturaDAO.crearFactura(factura);
    }
    public void eliminarFactura() {
        System.out.println("Introduce el número de factura a eliminar:");
        String dni = sc.nextLine();
        facturaDAO.eliminar(dni);
    }
    public void actualizarFactura() {
        System.out.println("Introduce el número de factura a actualizar:");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Introduce el atributo a actualizar (ID_Factura, Cliente, Servicio, Coste, Fecha):");
        String atributo = sc.nextLine();
        System.out.println("Introduce el nuevo valor:");
        String valor = sc.nextLine();
        facturaDAO.actualizarFactura(atributo, valor, id);
    }
    public void buscarFactura() {
        System.out.println("Introduce el número de factura a buscar:");
        int id = sc.nextInt();
        Factura factura = facturaDAO.buscarFactura(id);
        if (factura != null) {
            System.out.println("Factura encontrada: " + factura);
        } else {
            System.out.println("Factura no encontrada.");
        }
    }
    public void listarFacturas() {
        System.out.println("Introduce el número de factura a buscar:");
        int id = sc.nextInt();
        Factura factura = facturaDAO.buscarFactura(id);
        if (factura != null) {
            System.out.println("Factura encontrada: " + factura);
        } else {
            System.out.println("Factura no encontrada.");
        }
    }
    

}
