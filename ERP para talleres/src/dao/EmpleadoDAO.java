package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    

}
