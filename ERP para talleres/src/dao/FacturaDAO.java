package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Factura;
import model.Cliente;

public class FacturaDAO {
    public void crearFactura(Factura factura) {
        // Implementación para crear una factura
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Factura (ID_Factura, Cliente, Servicio, Coste, Fecha) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, factura.getNumeroFactura()); // Asigna el valor del teléfono
                stmt.setString(2, factura.getCliente().getdni()); 
                stmt.setString(3, factura.getServicio());
                stmt.setInt(4, factura.getImporte());
                stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.executeUpdate(); // Ejecuta la consulta de inserción
                System.out.println("Factura agregada exitosamente.");
            }catch (SQLException e) {
                System.out.println("Error al agregar factura: " + e.getMessage());
            }
        }
    }
    public void eliminar(String dni) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {String query = "DELETE FROM Factura WHERE ID_Factura = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {stmt.setString(1, dni); // Asigna el ID del empleado
                stmt.executeUpdate(); // Ejecuta la eliminación
                System.out.println("Factura eliminada.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar la factura: " + e.getMessage());
            }
        }
    }

     public void actualizarFactura(String atributo, String valor, int id) {
        Connection conexion = ConexionBD.conectar();
                if (conexion != null) {
                    String query = "UPDATE Factura SET ? = ? WHERE ID_Factura = ?";
                try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                    stmt.setString(1, atributo); // Columna que deseamos cambiar
                    stmt.setString(2, valor); // valor que le queremos dar
                    stmt.setInt(3, id); // Asigna el ID del cliente
                    stmt.executeUpdate(); // Ejecuta la actualización
                } catch (SQLException e) {
                    System.out.println("Error al actualizar el valor: " + e.getMessage());
                }
            }
        }
    public Factura buscarFactura(int id) {
        Connection conexion = ConexionBD.conectar();
        Factura factura = null;

        if (conexion != null) {
            String query = "SELECT * FROM Factura WHERE ID_Factura = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, id);
                // Aquí deberías ejecutar la consulta y mapear el resultado a un objeto Factura
                // ...
            } catch (SQLException e) {
                System.out.println("Error al buscar la factura: " + e.getMessage());
            }
        }
        return factura;
    }
    public ArrayList<Factura> obtenerFacturas() {
        Connection conexion = ConexionBD.conectar();
        ArrayList<Factura> facturas = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM Factura";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                 ResultSet rs = stmt.executeQuery(); 
    
                while (rs.next()) {
                    int id = rs.getInt("ID_Factura");
                    String cliente = rs.getString("Cliente");
                    String servicio = rs.getString("Servicio");
                    int coste = rs.getInt("Coste");
                    String fecha = rs.getString("Fecha");

                    // Crear un objeto Factura y agregarlo a la lista
                    Cliente Cliente = new Cliente("","", cliente, "", "", "");
                    Factura factura = new Factura(id, fecha, Cliente, coste, servicio);
                    facturas.add(factura);
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener las facturas: " + e.getMessage());
            }
            }
        
        return facturas;
    }
    public ArrayList<Factura> listarFacturas() {
        ArrayList<Factura> facturas = obtenerFacturas();
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
        return facturas;
    }
}
