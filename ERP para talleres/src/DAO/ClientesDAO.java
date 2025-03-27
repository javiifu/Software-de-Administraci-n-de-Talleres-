import java.util.ArrayList;

import ConexionBD;

import java.sql.*;

import Model.Clientes;

public class ClientesDAO {
    public void insertar(Clientes cliente) {
        // Establecer conexión
 Connection conexion = ConexionBD.conectar();
 if (conexion != null) {
 // Consulta SQL para obtener todos los clientes
 String query = "SELECT * FROM clientes"; 
 try (Statement stmt = conexion.createStatement(); 
ResultSet rs = stmt.executeQuery(query)) {
 // Iterar sobre los resultados
 while (rs.next()) {
 System.out.println("ID: " + 
rs.getInt("id_cliente"));
 System.out.println("Nombre: " + 
rs.getString("nombre"));
 System.out.println("Teléfono: " + 
rs.getString("telefono"));
 System.out.println("Dirección: " + 
rs.getString("direccion"));
 System.out.println("----------------------");
 }
 } catch (SQLException e) {
 System.out.println("Error al realizar la consulta: " 
+ e.getMessage());
 }
 }

    }

    public void actualizar(Clientes cliente) {

    }
    
    public void eliminar(int id) {

    }

    public Clientes buscarPorId(int id){

    }

    public ArrayList<Clientes> obtenerTodos() {
              // Establecer conexión
 Connection conexion = ConexionBD.conectar();
 if (conexion != null) {
 // Consulta SQL para obtener todos los clientes
 String query = "SELECT * FROM clientes"; 
 try (Statement stmt = conexion.createStatement(); 
ResultSet rs = stmt.executeQuery(query)) {
 // Iterar sobre los resultados
 while (rs.next()) {
 System.out.println("ID: " + 
rs.getInt("id_cliente"));
 System.out.println("Nombre: " + 
rs.getString("nombre"));
 System.out.println("Teléfono: " + 
rs.getString("telefono"));
 System.out.println("Dirección: " + 
rs.getString("direccion"));
 System.out.println("----------------------");
 }
 } catch (SQLException e) {
 System.out.println("Error al realizar la consulta: " 
+ e.getMessage());
 }
 }
    }


}
