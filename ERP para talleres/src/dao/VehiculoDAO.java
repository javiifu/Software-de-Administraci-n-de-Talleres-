package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Vehiculo;


public class VehiculoDAO {

    public void insertar(Vehiculo vehiculo) {
        
        Connection conexion = ConexionBD.conectar();
        
        if (conexion != null) {

            
            String query = "INSERT INTO Vehiculos (Matricula, Marca, Modelo, Cliente) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, vehiculo.getMatricula()); // Asigna el valor de la matricula
                stmt.setString(2, vehiculo.getMarca()); 
                stmt.setString(3, vehiculo.getModelo());
                stmt.setString(4, vehiculo.getPropietario());
                
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Empleado agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar vehiculo: " + e.getMessage());
            }
        }
    }

    public void actualizar(String atributo, String valor, String matricula) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
           
                String query = "UPDATE Vehiculos SET ? = ? WHERE Matricula = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    
                    stmt.setString(1, atributo ); // Columna que deseamos cambiar
                    stmt.setString(2,  valor); // valor que le queremos dar
                    stmt.setString(3, matricula); // Asigna el ID del vehiculo
                    stmt.executeUpdate(); // Ejecuta la actualización
                    
                } catch (SQLException e) {
                    System.out.println("Error al actualizar el valor: " + e.getMessage());
                }

            
            
            }
            System.out.println("No se ha podido conectar con la base de datos");
        
           
        

    } 

    public void eliminar(String matricula) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {String query = "DELETE FROM Vehiculos WHERE Matricula = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {stmt.setString(1, matricula); // Asigna el ID del cliente
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Vehiculo eliminado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar cliente: " + e.getMessage());
            }
        }

    }

    public Vehiculo buscarPorMatricula(String matricula){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            Vehiculo vehiculo;
            String marca;
            String modelo;
            String color;
            String propietario;
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
        

            try {
                String query = "SELECT Matricula, Marca, Modelo, Color, Cliente " + "FROM Vehiculos WHERE Matricula = ?";

                stmt = conexion.prepareStatement(query);
                stmt.setString(1, matricula.trim()); // Usamos trim() para limpiar espacios

                rs = stmt.executeQuery();

                if (rs.next()) {
                    // Extraemos los datos del ResultSet
                    matricula = rs.getString("Matricula");
                    marca = rs.getString("Marca");
                    modelo = rs.getString("Modelo");
                    color = rs.getString("Color");
                    propietario = rs.getString("Cliente");
                    

                    vehiculo = new Vehiculo(matricula, marca, modelo, color, propietario);
                    return vehiculo;
                }
                

            } catch (SQLException e) {
                System.err.println("Error al buscar vehiculo por matricula: " + e.getMessage());
            } finally {
                // Cerramos recursos en orden inverso a su creación
                try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignorar */ }
                try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignorar */ }
                
            }
        }
        return null;
    }

    public Map<String, Object> buscarClientePorDni(String dni) {
        Connection conexion = ConexionBD.conectar();
        Map<String, Object> resultado = new HashMap<>();
        List<Map<String, String>> vehiculos = new ArrayList<>();

        if (conexion != null) {
            // Consulta para obtener datos del cliente y sus vehículos
            String query = "SELECT c.Nombre, c.Apellidos, v.Matricula " + "FROM Clientes c LEFT JOIN Vehiculos v " +
                        "ON c.DNI_Clientes = v.Clientes " +
                        "WHERE c.DNI_Clientes = ?";

            try (PreparedStatement pstm = conexion.prepareStatement(query)) {
                pstm.setString(1, dni);
                ResultSet rs = pstm.executeQuery();

                boolean encontrado = false;
                while (rs.next()) {
                    encontrado = true;
                    // Si es la primera iteración, guardamos los datos del cliente
                    if (resultado.isEmpty()) {
                        resultado.put("nombre", rs.getString("Nombre"));
                        resultado.put("apellidos", rs.getString("Apellidos"));
                    }

                    // Añadimos cada vehículo a la lista
                    if (rs.getString("Matricula") != null) {
                        Map<String, String> vehiculo = new HashMap<>();
                        vehiculo.put("matricula", rs.getString("Matricula"));
                        vehiculos.add(vehiculo);
                    }
                }

                if (!encontrado) {
                    return null; // Cliente no encontrado
                }

                resultado.put("vehiculos", vehiculos);

            } catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
                return null;
            } finally {
                try {
                    if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
    }
    return resultado;
}
}

