package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.ConexionSQL;

public class ClientDaoImpl implements ClienteDao {

    private Connection conexion;

    public ClientDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardarCliente(Client cliente) {

        String sql = "INSERT INTO usuarios (IdUsuario, nombre, edad, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdUser());
            ps.setString(2, cliente.getName());
            ps.setInt(3, cliente.getAge());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getPassword());
            ps.setInt(6, Integer.parseInt(cliente.getPhone()));
            ps.setInt(7, cliente.getCP());
            ps.setString(8, cliente.getAddress());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar: " + e);
        }
    }

    @Override
    public void actualizarCliente(Client cliente) {

        String sql = "UPDATE usuarios SET nombre = ?, edad = ?, correoElectronico = ?, contrasena = ?, numTelefono = ?, codigoPostal = ?, direccionDom = ? WHERE IdUsuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getName());
            ps.setInt(2, cliente.getAge());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getPassword());
            ps.setInt(5, Integer.parseInt(cliente.getPhone()));
            ps.setInt(6, cliente.getCP());
            ps.setString(7, cliente.getAddress());
            ps.setInt(8, cliente.getIdUser());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e);
        }
    }

    @Override
    public void eliminarCliente(int idUser) {

        String sql = "DELETE FROM usuarios WHERE IdUsuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idUser);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error " + e);
        }
    }

    @Override
    public Client buscarPorId(int idUser) {

        String sql = "SELECT * FROM usuarios WHERE IdUsuario = ?";
        Client cliente = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Client();

                cliente.setidUser(rs.getInt("IdUsuario"));
                cliente.setName(rs.getString("nombre"));
                cliente.setAge(rs.getInt("edad"));
                cliente.setEmail(rs.getString("correoElectronico"));
                cliente.setPassword(rs.getString("contrasena"));
                cliente.setPhone(String.valueOf(rs.getInt("numTelefono")));
                cliente.setCP(rs.getInt("codigoPostal"));
                cliente.setAddress(rs.getString("direccionDom"));
            }

        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos " + e);
        }

        return cliente;
    }

    @Override
    public Client inicioDeSesion(String email) {

        String sql = "SELECT * FROM usuarios WHERE correoElectronico = ?";
        Client cliente = null;

        try (Connection con = new ConexionSQL().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Client();

                cliente.setidUser(rs.getInt("IdUsuario"));
                cliente.setName(rs.getString("nombre"));
                cliente.setAge(rs.getInt("edad"));
                cliente.setEmail(rs.getString("correoElectronico"));
                cliente.setPassword(rs.getString("contrasena"));
                cliente.setPhone(String.valueOf(rs.getInt("numTelefono")));
                cliente.setCP(rs.getInt("codigoPostal"));
                cliente.setAddress(rs.getString("direccionDom"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar por email: " + e);
        }

        return cliente;
    }
}
