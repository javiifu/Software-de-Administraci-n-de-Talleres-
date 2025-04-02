package dao;
import java.sql.*;
import java.util.ArrayList;
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
                System.out.println("Empleado agregado exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar empleado: " + e.getMessage());
            }
        }
    }

    public void actualizar(String atributo, String valor, String dni) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
           
                String query = "UPDATE Empleados SET ? = ? WHERE DNI_Empleado = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    
                    stmt.setString(1, atributo ); // Columna que deseamos cambiar
                    stmt.setString(2,  valor); // valor que le queremos dar
                    stmt.setString(3, dni); // Asigna el ID del cliente
                    stmt.executeUpdate(); // Ejecuta la actualización
                    
                } catch (SQLException e) {
                    System.out.println("Error al actualizar el valor: " + e.getMessage());
                }

            
            
            }
            System.out.println("No se ha podido conectar con la base de datos");
        
           
        

    } 

    public void eliminar(String dni) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {String query = "DELETE FROM Empleados WHERE DNI_Empleado = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {stmt.setString(1, dni); // Asigna el ID del empleado
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Empleado eliminado.");
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
            String numeroseg;
            String cuenta;

        
            PreparedStatement stmt = null;
            ResultSet rs = null;
        

            try {
                String query = "SELECT Nombre, Apellidos, Dni_Cliente, Num_tlf, NumeroSS, CuentaBanco " + "FROM Empleados WHERE Dni_Empleado = ?";

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
                    cuenta = rs.getString("CuentaBanco");

                    empleado = new Empleado(nombre, apellidos, dni, telefono, numeroseg, cuenta);
                    return empleado;
                }
                

            } catch (SQLException e) {
                System.err.println("Error al buscar empleado por DNI: " + e.getMessage());
            } finally {
                // Cerramos recursos en orden inverso a su creación
                try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignorar */ }
                try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignorar */ }
                
            }

        
        }
        return null;
    }

    public ArrayList<Empleado> obtenerTodos() {
              // Establecer conexión
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            // Consulta SQL para obtener todos los Empleados
            String query = "SELECT * FROM Empleados"; 
            try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                ArrayList<Empleado> empleados = new ArrayList<>();
                Empleado empleado; 
                String nombre;
                String apellidos;
                String telefono;
                String numeroseg;
                String cuenta;
                String dni;
                
                // Iterar sobre los resultados
                while (rs.next()) {
                    
                    nombre = rs.getString("Nombre");
                    telefono = rs.getString("Num_tlf");
                    apellidos = rs.getString("Apellidos");
                    dni = rs.getString("DNI_Empleado");
                    numeroseg = rs.getString("NumeroSS");
                    cuenta = rs.getString("CuentaBanco");
                    empleado = new Empleado(nombre, apellidos, dni, telefono, numeroseg, cuenta);
                    empleados.add(empleado);

                }  

                return empleados;

            }catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }
        return null;
    }

}
