package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Proveedor;
public class ProveedorDAO {
    public void insertarProveedor(Proveedor proveedor){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Proveedores (NIF, Nombre, Tipo, Direccion, Num_tlf, CorreoElectronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, proveedor.getCif()); // Asigna el valor del teléfono
                stmt.setString(2, proveedor.getNombre()); 
                stmt.setString(3, proveedor.getSuministro()); //Esto es la columna tipo
                stmt.setString(6, proveedor.getDireccion());
                stmt.setString(5, proveedor.getTelefono());
                stmt.setString(7, proveedor.getEmail());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Proveedor agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar proveedor: " + e.getMessage());
            }
        }
    }
}
