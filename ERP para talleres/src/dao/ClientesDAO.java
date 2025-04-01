package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Cliente;

public class ClientesDAO {

    public void insertar(Cliente cliente) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Clientes (DNI_Cliente, Nombre, Apellidos, FechaInscrito, Num_tlf, Direccion, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, cliente.getDni()); // Asigna el valor del teléfono
                stmt.setString(2, cliente.getNombre()); 
                stmt.setString(3, cliente.getApellidos());
                stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setString(5, cliente.getTelefono());
                stmt.setString(6, cliente.getDireccion());
                stmt.setString(7, cliente.getEmail());
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Cliente agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar cliente: " + e.getMessage());
            }
        }


    }

    public void actualizar(String atributo, String valor, String dni) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
           
                String query = "UPDATE Clientes SET ? = ? WHERE Dni_Clientes = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    
                    stmt.setString(1, atributo ); // Columna que deseamos cambiar
                    stmt.setString(2,  valor); // valor que le queremos dar
                    stmt.setString(3, dni); // Asigna el ID del cliente
                    stmt.executeUpdate(); // Ejecuta la actualización
                    
                } catch (SQLException e) {
                    System.out.println("Error al actualizar teléfono: " + e.getMessage());
                }

            
            
            }
            System.out.println("No se ha podido conectar con la base de datos");
        
           
        

    }
    
    public void eliminar(String dni) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {String query = "DELETE FROM clientes WHERE DNI_Cliente = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {stmt.setString(1, dni); // Asigna el ID del cliente
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Cliente eliminado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar cliente: " + e.getMessage());
            }
        }

    }

    public Cliente buscarPorDni(String dni){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            Cliente cliente;
            String nombre;
            String apellidos;
            String telefono;
            String email;
            String direccion;
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
        

            try {
                String query = "SELECT Nombre, Apellidos, Dni_Cliente, Direccion, Num_tlf, Email " + "FROM Clientes WHERE Dni_Cliente = ?";

                stmt = conexion.prepareStatement(query);
                stmt.setString(1, dni.trim()); // Usamos trim() para limpiar espacios

                rs = stmt.executeQuery();

                if (rs.next()) {
                    // Extraemos los datos del ResultSet
                    nombre = rs.getString("Nombre");
                    apellidos = rs.getString("Apellidos");
                    dni = rs.getString("Dni_Cliente");
                    direccion = rs.getString("Direccion");
                    telefono = rs.getString("Num_tlf");
                    email = rs.getString("Email");

                    cliente = new Cliente(nombre, apellidos, dni, direccion, telefono, email);
                    return cliente;
                }
                

            } catch (SQLException e) {
                System.err.println("Error al buscar cliente por DNI: " + e.getMessage());
                // Podrías lanzar una excepción personalizada aquí si lo prefieres
            } finally {
                // Cerramos recursos en orden inverso a su creación
                try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignorar */ }
                try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignorar */ }
                
            }

        
        }
        return null;
    }

    public ArrayList<Cliente> obtenerTodos() {
              // Establecer conexión
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            // Consulta SQL para obtener todos los Cliente
            String query = "SELECT * FROM Clientes"; 
            try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                ArrayList<Cliente> clientes = new ArrayList<>();
                Cliente cliente; 
                String nombre;
                String apellidos;
                String dni;
                String telefono;
                String email;
                String direccion;
                
                // Iterar sobre los resultados
                while (rs.next()) {
                    
                    nombre = rs.getString("Nombre");
                    telefono = rs.getString("Num_tlf");
                    apellidos = rs.getString("Apellidos");
                    dni = rs.getString("Dni_Cliente");
                    direccion = rs.getString("Direccion");
                    email = rs.getString("Email");
                    cliente = new Cliente(nombre, apellidos, dni, direccion, telefono, email );
                    clientes.add(cliente);

                }  

                return clientes;

            }catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }
        return null;
    }

    
}
