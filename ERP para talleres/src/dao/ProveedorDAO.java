package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Proveedor;
public class ProveedorDAO {
    public void insertarProveedor(Proveedor proveedor){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Proveedores (NIF, Nombre, Tipo, Dirección, CorreoElectronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, proveedor.getCif()); // Asigna el valor del teléfono
                stmt.setString(2, proveedor.getNombre()); 
                stmt.setString(3, proveedor.getapellidos());
                stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setString(5, cliente.getTelefono());
                stmt.setString(6, cliente.getdireccion());
                stmt.setString(7, cliente.getEmail());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Cliente agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar cliente: " + e.getMessage());
            }
        }
    }
}
