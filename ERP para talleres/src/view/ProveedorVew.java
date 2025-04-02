package view;
import dao.ProveedorDAO;
import java.util.Scanner;
import model.Proveedor;
import java.util.ArrayList;
public class ProveedorVew {
    ProveedorDAO provdao = new ProveedorDAO();
    Scanner sc = new Scanner(System.in);
    //Método para gestionar los proveedores
    public void gestionarProveedores(){
        
        int eleccion;
        String respuesta;
        String nombre = "Nombre";
        String cif = "NIF";
        String direccion = "Direccion";
        String telefono = "Num_tlf";
        String email = "Email";
        String suministro = "Tipo";

        
        System.out.println("¿Qué proveedor desea gestionar? Introduzca su NIF: ");
        respuesta = sc.nextLine();
        sc.next();
        //Buscamos el proveedor por su NIF
        Proveedor proveedor = provdao.buscarPorCif(respuesta);
        
        
        do{       

            System.out.println("¿Qué desea gestionar de su proveedor?");
            System.out.println("1. Nombre");
            System.out.println("2. CIF");
            System.out.println("3. Direccion");
            System.out.println("4. Telefono");
            System.out.println("5. Email");
            System.out.println("6. Suministro");
            System.out.println("7. Salir");
            System.out.println("Introduzca una opcion: ");

            eleccion = sc.nextInt();

            switch(eleccion){
                case 1 -> {
                    System.out.println("Introduzca el nombre nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(nombre, respuesta, proveedor.getCif());
                    
                    
                }
                case 2 -> {
                    System.out.println("Introduzca el CIF nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(cif, respuesta, proveedor.getCif());
                    
                    
                }
                case 3 -> {
                    System.out.println("Introduzca la direccion nueva: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(direccion, respuesta, proveedor.getCif());
                    
                    
                }
                case 4 -> {
                    System.out.println("Introduzca el telefono nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(telefono, respuesta, proveedor.getCif());
                    
                    
                }
                case 5 -> {
                    System.out.println("Introduzca el email nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(email, respuesta, proveedor.getCif());
                    
                    
                }
                case 6 -> {
                    System.out.println("Introduzca el suministro nuevo: ");
                    respuesta = sc.nextLine();sc.next();
                    provdao.actualizar(suministro, respuesta, proveedor.getCif());
                }
                case 7 -> {
                    System.out.println("Saliendo del gestor de proveedores");
                }
                default -> {
                    System.out.println("Introduzca una opcion válida");
                }
            }
    }while (eleccion != 7);
    }
    public void crearProveedor(){
        String nombre;
        String cif;
        String direccion;
        String telefono;
        String email;
        String suministro;

        System.out.println("Introduzca el nombre del proveedor: ");
        nombre = sc.nextLine();
        sc.next();
        System.out.println("Introduzca el CIF del proveedor: ");
        cif = sc.nextLine();
        sc.next();
        System.out.println("Introduzca la direccion del proveedor: ");
        direccion = sc.nextLine();
        sc.next();
        System.out.println("Introduzca el telefono del proveedor: ");
        telefono = sc.nextLine();
        sc.next();
        System.out.println("Introduzca el email del proveedor: ");
        email = sc.nextLine();
        sc.next();
        System.out.println("Introduzca el suministro del proveedor: ");
        suministro = sc.nextLine();
        sc.next();
        
        Proveedor proveedor = new Proveedor(nombre, cif, direccion, suministro, telefono, email);
        
        provdao.insertarProveedor(proveedor);
    }
    public void eliminarProveedor(){
        String respuesta;
        boolean existe = false;
        if (provdao.listarProveedores() != null) {
            do{System.out.println("¿Qué proveedor desea eliminar? Introduzca su NIF: ");
            respuesta = sc.nextLine();
            sc.next();
            //Buscamos el proveedor por su NIF
            Proveedor proveedor = provdao.buscarPorCif(respuesta);
            if (proveedor != null) {
                existe = true;
                provdao.eliminar(respuesta);
            } else {
                System.out.println("El proveedor no existe");
            }
        }while (existe != true);
    }
    else{
            System.out.println("No hay proveedores en la base de datos");
        }
    }
    public void listarProveedores(){
        ArrayList<Proveedor> proveedores = provdao.listarProveedores();
        if (proveedores != null) {
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedor);
            }
        } else {
            System.out.println("No hay proveedores en la base de datos");
        }
    }
}

