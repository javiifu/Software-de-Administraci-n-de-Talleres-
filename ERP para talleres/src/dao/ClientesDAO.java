package dao;
import java.util.ArrayList;
import java.sql.*;
import model.Cliente;

public class ClientesDAO {
    public void insertar(Cliente cliente) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Cliente (DNI_Cliente, Nombre, Apellidos, FechaInscrito, Num_tlf) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(2, cliente.getDni()); // Asigna el valor del teléfono
                stmt.setString(3, cliente.getNombre()); 
                stmt.setString(4, cliente.getApellidos());
                stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setInt(6, cliente.getTelefono());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Cliente agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar cliente: " + 
                e.getMessage());
            }
        }


    }

    public void actualizar(Cliente cliente) {

    }
    
    public void eliminar(int id) {

    }

    public Cliente buscarPorId(int id){
        return null;
    }

    public ArrayList<Cliente> obtenerTodos() {
              // Establecer conexión
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            // Consulta SQL para obtener todos los Cliente
            String query = "SELECT * FROM Cliente"; 
            try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Iterar sobre los resultados
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_cliente"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Teléfono: " + rs.getString("telefono"));
                    System.out.println("Dirección: " + rs.getString("direccion"));
                    System.out.println("----------------------");
                }  
            }catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }
        return null;
    }

    
}
