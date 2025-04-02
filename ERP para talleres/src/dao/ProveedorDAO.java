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
    public void actualizar(String atributo, String valor, String cif) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "UPDATE Proveedores SET ? = ? WHERE NIF = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, atributo ); // Columna que deseamos cambiar
                stmt.setString(2,  valor); // valor que le queremos dar
                stmt.setString(3, cif); // Asigna el CIF del proveedor
                stmt.executeUpdate(); // Ejecuta la actualización
            } catch (SQLException e) {
                System.out.println("Error al actualizar el valor: " + e.getMessage());
            }
        }
        System.out.println("Prueba de carga.");
    }
    public void eliminar(String cif) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String query = "DELETE FROM Proveedores WHERE NIF = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, cif); // Asigna el CIF del proveedor
                stmt.executeUpdate(); // Ejecuta la eliminación
            } catch (SQLException e) {
                System.out.println("Error al eliminar el proveedor: " + e.getMessage());
            }
        }
    }
    //Añadir método para añadir una nueva columna a la tabla de proveedores
    public Proveedor buscarPorCif(String cif) {
        Connection conexion = ConexionBD.conectar();
        Proveedor proveedor = null;
        if (conexion != null) {
            String query = "SELECT * FROM Proveedores WHERE NIF = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, cif); // Asigna el CIF del proveedor
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String tipo = rs.getString("Tipo");
                    String direccion = rs.getString("Direccion");
                    String telefono = rs.getString("Num_tlf");
                    String email = rs.getString("CorreoElectronico");
                    proveedor = new Proveedor(nombre, cif, direccion, tipo, telefono, email);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el proveedor: " + e.getMessage());
            }
        }
        return proveedor;
    }
    public ArrayList<Proveedor> listarProveedores() {
        Connection conexion = ConexionBD.conectar();
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM Proveedores";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String cif = rs.getString("NIF");
                    String tipo = rs.getString("Tipo");
                    String direccion = rs.getString("Direccion");
                    String telefono = rs.getString("Num_tlf");
                    String email = rs.getString("CorreoElectronico");
                    Proveedor proveedor = new Proveedor(nombre, cif, direccion, tipo, telefono, email);
                    proveedores.add(proveedor);
                }
            } catch (SQLException e) {
                System.out.println("Error al listar los proveedores: " + e.getMessage());
            }
        }
        return proveedores;
    }
}
