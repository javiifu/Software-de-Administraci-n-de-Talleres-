package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Cliente;

public class ClientesDAO {

    public void insertar(Cliente cliente) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Cliente (DNI_Cliente, Nombre, Apellidos, FechaInscrito, Num_tlf) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, cliente.getDni()); // Asigna el valor del teléfono
                stmt.setString(2, cliente.getNombre()); 
                stmt.setString(3, cliente.getApellidos());
                stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setInt(5, cliente.getTelefono());
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
                Cliente x; 
                int id;
                String nombre;
                String apellidos;
                String Dni;
                int telefono;

                while (rs.next()) {
                    id = rs.getInt("ID");
                    nombre = rs.getString("Nombre");
                    telefono = rs.getInt("Num_tlf");
                    apellidos = rs.getString("Apellidos");
                    
                    Cliente cliente = new Cliente(id, nombre, telefono, apellidos);
                }  
            }catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }
        return null;
    }

    
}
