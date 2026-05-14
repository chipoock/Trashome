package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {

    private ConexionSQL cn = new ConexionSQL();

    public EmployeeDaoImpl() {
    }

    public void guardarEmpleado(Employee employee) {
        String sql = "INSERT INTO empleados (IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conexion = cn.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) return;
            
            ps.setInt(1, employee.getIdUser());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getClass().getSimpleName());
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getPassword());
            ps.setString(7, employee.getPhone());
            ps.setInt(8, employee.getCP());
            ps.setString(9, employee.getAddress());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar empleado: " + e);
        }
    }

    public void eliminarEmpleado(Employee employee) {
        String sql = "DELETE FROM empleados WHERE IdEmpleado = ?";

        try (Connection conexion = cn.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) return;

            ps.setInt(1, employee.getIdUser());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e);
        }
    }

    public void actualizarEmpleado(Employee employee) {
        String sql = "UPDATE empleados SET nombre = ?, edad = ?, puesto = ?, correoElectronico = ?, contrasena = ?, numTelefono = ?, codigoPostal = ?, direccionDom = ? WHERE IdEmpleado = ?";

        try (Connection conexion = cn.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) return;

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getClass().getSimpleName());
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

    public java.util.List<Employee> obtenerEmpleados() {
        java.util.List<Employee> empleados = new java.util.ArrayList<>();
        String sql = "SELECT IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom FROM empleados";

        try (Connection conexion = cn.conectar()) {
            if (conexion == null) return empleados;
            try (PreparedStatement ps = conexion.prepareStatement(sql);
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

                    java.time.LocalDate hiringDate = java.time.LocalDate.now();

                    Employee emp;
                    if ("Conductor".equalsIgnoreCase(puesto)) {
                        emp = new Conductor(name, age, idUser, cp, email, phone, password, address, hiringDate, null);
                    } else {
                        emp = new GeneralEmployee(name, age, idUser, cp, email, phone, password, address, hiringDate);
                    }
                    empleados.add(emp);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener empleados: " + e);
        }

        return empleados;
    }

    @Override
    public Employee buscarPorEmail(String email) {
        String sql = "SELECT IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom FROM empleados WHERE correoElectronico = ?";

        try (Connection conexion = cn.conectar()) {
            if (conexion == null) return null;
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, email);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int idUser = rs.getInt("IdEmpleado");
                        String name = rs.getString("nombre");
                        int age = rs.getInt("edad");
                        String puesto = rs.getString("puesto");
                        String foundEmail = rs.getString("correoElectronico");
                        String password = rs.getString("contrasena");
                        String phone = rs.getString("numTelefono");
                        int cp = rs.getInt("codigoPostal");
                        String address = rs.getString("direccionDom");

                        java.time.LocalDate hiringDate = java.time.LocalDate.now();

                        if ("Conductor".equalsIgnoreCase(puesto)) {
                            return new Conductor(name, age, idUser, cp, foundEmail, phone, password, address, hiringDate, null);
                        } else {
                            return new GeneralEmployee(name, age, idUser, cp, foundEmail, phone, password, address, hiringDate);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar empleado por email: " + e);
        }
        return null;
    }

    @Override
    public Employee buscarPorId(int id) {
        String sql = "SELECT IdEmpleado, nombre, edad, puesto, correoElectronico, contrasena, numTelefono, codigoPostal, direccionDom FROM empleados WHERE IdEmpleado = ?";

        try (Connection conexion = cn.conectar()) {
            if (conexion == null) return null;
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int idUser = rs.getInt("IdEmpleado");
                        String name = rs.getString("nombre");
                        int age = rs.getInt("edad");
                        String puesto = rs.getString("puesto");
                        String foundEmail = rs.getString("correoElectronico");
                        String password = rs.getString("contrasena");
                        String phone = rs.getString("numTelefono");
                        int cp = rs.getInt("codigoPostal");
                        String address = rs.getString("direccionDom");

                        java.time.LocalDate hiringDate = java.time.LocalDate.now();

                        if ("Conductor".equalsIgnoreCase(puesto)) {
                            return new Conductor(name, age, idUser, cp, foundEmail, phone, password, address, hiringDate, null);
                        } else {
                            return new GeneralEmployee(name, age, idUser, cp, foundEmail, phone, password, address, hiringDate);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar empleado por ID: " + e);
        }
        return null;
    }
}
