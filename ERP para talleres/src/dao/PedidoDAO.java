package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Pedido;
public class PedidoDAO {  
    public void insertarPedido(Pedido Pedido){
        Connection conexion = ConexionBD.conectar();
        if(conexion != null){
            String query = "INSERT INTO Pedidos (ID_Pedido, ID_Cliente, ID_Producto, Fecha_Pedido, Cantidad) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, Pedido.getIdPedido());
                stmt.setString(2, Pedido.getIdCliente());
                stmt.setString(3, Pedido.getIdProducto());
                stmt.setDate(4, java.sql.Date.valueOf(Pedido.getFechaPedido()));
                stmt.setInt(5, Pedido.getCantidad());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Pedido agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar pedido: " + e.getMessage());
            }
        }
    }
}
