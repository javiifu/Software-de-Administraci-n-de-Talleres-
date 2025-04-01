package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Empleado;

public class EmpleadoDAO {


    public void insertar(Empleado empleado) {
        Connection conexion = ConexionBD.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Empleados (DNI_Empleado, Nombre, Apellidos, FechaInscrito, Num_tlf, NumeroSS, CuentaBanco) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, empleado.getDni()); // Asigna el valor del teléfono
                stmt.setString(2, empleado.getNombre()); 
                stmt.setString(3, empleado.getApellidos());
                stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setString(5, empleado.getTelefono());
                stmt.setString(6, empleado.getNumeroSS());
                stmt.setString(7, empleado.getCuentaBancaria());
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
           
                String query = "UPDATE Empleados SET ? = ? WHERE Dni_Clientes = ?";
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
        if (conexion != null) {String query = "DELETE FROM Empleados WHERE DNI_Cliente = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {stmt.setString(1, dni); // Asigna el ID del cliente
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Cliente eliminado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar cliente: " + e.getMessage());
            }
        }

    }

    public Empleado buscarPorDni(String dni){
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            Empleado empleado;
            String nombre;
            String apellidos;
            String telefono;
            String email;
            String numeroseg;
            String cuenta;

        
            PreparedStatement stmt = null;
            ResultSet rs = null;
        

            try {
                String query = "SELECT Nombre, Apellidos, Dni_Cliente, Num_tlf, NumeroSS, CuentaBanco " + "FROM Empleados WHERE Dni_Cliente = ?";

                stmt = conexion.prepareStatement(query);
                stmt.setString(1, dni.trim()); // Usamos trim() para limpiar espacios

                rs = stmt.executeQuery();

                if (rs.next()) {
                    // Extraemos los datos del ResultSet
                    nombre = rs.getString("Nombre");
                    apellidos = rs.getString("Apellidos");
                    dni = rs.getString("Dni_Cliente");
                    telefono = rs.getString("Num_tlf");
                    numeroseg = rs.getString("NumeroSS");
                    email = rs.getString("Email");
                    cuenta = rs.getString("CuentaBanco");

                    empleado = new Empleado(nombre, apellidos, dni, numeroseg, cuenta);
                    return empleado;
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

}
