package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection conexion;

    public EmployeeDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardarEmpleado(Employee employee) {
        String sql = "INSERT INTO empleados (IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom) VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, employee.getIdUser());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getClass().getSimpleName()); // Se usa el nombre de la clase como puesto
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getPassword());
            ps.setString(7, employee.getPhone()); // Se manda como String, MySQL maneja la conversión si el número cabe
            ps.setInt(8, employee.getCP());
            ps.setString(9, employee.getAddress());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar empleado: " + e);
        }
    }

    @Override
    public void eliminarEmpleado(Employee employee) {
        String sql = "DELETE FROM empleados WHERE IdEmpleado = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, employee.getIdUser());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e);
        }
    }

    @Override
    public void actualizarEmpleado(Employee employee) {
        String sql = "UPDATE empleados SET nombre = ?, edad = ?, puesto = ?, correoElectronico = ?, contrasena = ?, numTelefono = ?, codigoPostal = ?, direccionDom = ? WHERE IdEmpleado = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getClass().getSimpleName()); // Se usa el nombre de la clase como puesto
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPassword());
            ps.setString(6, employee.getPhone());
            ps.setInt(7, employee.getCP());
            ps.setString(8, employee.getAddress());
            ps.setInt(9, employee.getIdUser());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e);
        }
    }

    @Override
    public java.util.List<Employee> obtenerEmpleados() {
        java.util.List<Employee> empleados = new java.util.ArrayList<>();
        String sql = "SELECT IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom FROM empleados";

        try (java.sql.PreparedStatement ps = conexion.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idUser = rs.getInt("IdEmpleado");
                String name = rs.getString("nombre");
                int age = rs.getInt("edad");
                String puesto = rs.getString("puesto");
                String email = rs.getString("correoElectronico");
                String password = rs.getString("contrasena");
                String phone = rs.getString("numTelefono");
                int cp = rs.getInt("codigoPostal");
                String address = rs.getString("direccionDom");

                // Asignar valores por defecto para campos no presentes en la tabla (si los hubiera)
                java.time.LocalDate hiringDate = java.time.LocalDate.now();
                double salary = 0.0;

                Employee emp;
                if ("Conductor".equalsIgnoreCase(puesto)) {
                    emp = new Conductor(name, age, idUser, cp, email, phone, password, address, hiringDate, (int)salary, null);
                } else {
                    emp = new GeneralEmployee(name, age, idUser, cp, email, phone, password, address, hiringDate, salary);
                }
                empleados.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener empleados: " + e);
        }

        return empleados;
    }
}
