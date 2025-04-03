package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Pedido;
import model.Producto;
import model.Proveedor;
public class PedidoDAO {  
    public void insertarPedido(Pedido Pedido){
        Connection conexion = ConexionBD.conectar();
        if(conexion != null){
            String query = "INSERT INTO Pedidos (ID_Pedido, Producto, FechaPedido, FechaEntrega, Estado, Cantidad, Proveedor, CosteUnidad, Total) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, Pedido.getNumeroPedido());
                stmt.setString(2, Pedido.getProducto().getNombre()); //Para obtener el nombre del producto
                stmt.setDate(3, java.sql.Date.valueOf(Pedido.getFechaPedido()));
                stmt.setDate(4, java.sql.Date.valueOf(Pedido.getFechaEntrega()));
                stmt.setBoolean(5, Pedido.getEstado());
                stmt.setInt(6, Pedido.getCantidad());
                stmt.setString(7, Pedido.getProveedor().getCif()); //Para obtener el cif del proveedor
                stmt.setDouble(8, Pedido.getCosteUnidad());
                stmt.setDouble(9, Pedido.getTotal());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Pedido agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar pedido: " + e.getMessage());
            }
        }
    }

    //Como en esta tabla tenemos diferentes tipos de datos vamos a introducir vamos a hacerloe manera diferente. 
    public void actualizarPedido(String atributo, String valor, int id) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            // Validar el atributo para evitar inyección SQL
            switch (atributo) {
                case "Producto":
                case "FechaPedido":
                case "FechaEntrega":
                case "Estado":
                case "Cantidad":
                case "Proveedor":
                case "CosteUnidad":
                    break;
                default:
                    System.out.println("Atributo no válido.");
                    return;
            }
            //
            String query = "UPDATE Pedidos SET " + atributo + " = ? WHERE ID_Pedido = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
    
                // Detectamos el tipo de dato
                if (atributo.equals("Estado")) {
                    stmt.setBoolean(1, Boolean.parseBoolean(valor));
                } else if (atributo.equals("Cantidad")) {
                    stmt.setInt(1, Integer.parseInt(valor));
                } else if (atributo.equals("CosteUnidad")) {
                    stmt.setBigDecimal(1, new java.math.BigDecimal(valor));
                } else if (atributo.equals("FechaPedido") || atributo.equals("FechaEntrega")) { 
                    stmt.setDate(1, java.sql.Date.valueOf(valor)); //Habrá que introducir las fechas en este formato yyyy-mm-dd
                } else {
                    stmt.setString(1, valor); // Para los demás atributos
                }
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Pedido actualizado exitosamente.");
    
            } catch (SQLException | IllegalArgumentException e) {
                System.out.println("Error al actualizar el valor: " + e.getMessage());
            }
        }
    }
    //Método eliminar pedido
    public void eliminarPedido(int id){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "DELETE FROM Pedidos WHERE ID_Pedido = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, id); // Asigna el ID del pedido
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Pedido eliminado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar pedido: " + e.getMessage());
            }
        }
    }
    public Pedido buscarPedido(int id){
        Connection conexion = ConexionBD.conectar();
        Pedido pedido = null;

        if (conexion != null) {
            String query = "SELECT * FROM Pedidos WHERE ID_Pedido = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Extraemos los valores de la tabla
                    int numeroPedido = rs.getInt("ID_Pedido");
                    String fechaPedido = rs.getString("FechaPedido");
                    String nombreProducto = rs.getString("Producto");
                    int cantidad = rs.getInt("Cantidad");
                    boolean estado = rs.getBoolean("Estado");
                    String fechaEntrega = rs.getString("FechaEntrega");
                    String fechaRecepcion = null; // Si no está en la tabla, se pone como null
                    String proveedorNIF = rs.getString("Proveedor");
                    int costeUnidad = rs.getInt("CosteUnidad"); // solo si necesitas reconstruirlo
                    int importe = rs.getInt("Total"); 

                    // Construir los objetos asociados
                    Proveedor proveedor = new Proveedor("NombreDesconocido", proveedorNIF, "", "", "", "");
                    Producto producto = new Producto(nombreProducto, 0, costeUnidad, proveedor); // stock = 0, ya que no lo tienes en esta tabla
                     // datos ficticios

                    // Construir el objeto Pedido
                    pedido = new Pedido(numeroPedido, fechaPedido, proveedor, importe, cantidad, producto, estado, fechaEntrega, fechaRecepcion);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el pedido: " + e.getMessage());
            }
        }

        return pedido;
    }
    public ArrayList<Pedido> obtenerPedidos(){
        //Establecemos conexión con la BD
        Connection conexion = ConexionBD.conectar();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        //Comprobamos si la conexión es correcta
        if (conexion != null) {
            String query = "SELECT * FROM Pedidos";
            try (PreparedStatement stmt = conexion.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
    
                while (rs.next()) {
                    int numeroPedido = rs.getInt("ID_Pedido");
                    String fechaPedido = rs.getString("FechaPedido");
                    String nombreProducto = rs.getString("Producto");
                    int cantidad = rs.getInt("Cantidad");
                    boolean estado = rs.getBoolean("Estado");
                    String fechaEntrega = rs.getString("FechaEntrega");
                    String fechaRecepcion = null; // no está en la tabla
                    String proveedorNIF = rs.getString("Proveedor");
                    int costeUnidad = rs.getInt("CosteUnidad");
                    int importe = rs.getInt("Total");
    
                    // Objetos ficticios solo con datos mínimos
                    Proveedor proveedor = new Proveedor("NombreDesconocido", proveedorNIF, "", "", "", "");
                    Producto producto = new Producto(nombreProducto, 0, costeUnidad, proveedor);

                    Pedido pedido = new Pedido(numeroPedido, fechaPedido, proveedor, importe, cantidad, producto, estado, fechaEntrega, fechaRecepcion);
                    pedidos.add(pedido);
                }
    
            } catch (SQLException e) {
                System.out.println("Error al obtener los pedidos: " + e.getMessage());
            }
        }
    
        return pedidos;
    }
}

