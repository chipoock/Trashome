package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReporteDaoImpl implements ReporteDao {

    private ConexionSQL cn = new ConexionSQL();

    public ReporteDaoImpl() {
    }

    @Override
    public void crearReporteUsuario(Reporte reporte) {
        String sqlPrincipal = "INSERT INTO reportes (tipoReporte, descripcionReporte) VALUES (?, ?)";
        String sqlDetalle = "INSERT INTO repus (CodigoReporte, IdUsuario, estadoReporte) VALUES (?, ?, ?)";

        try (Connection conexion = cn.conectar()) {
            if (conexion == null) return;
            conexion.setAutoCommit(false);

            // 1. Insertar en tabla principal
            try (PreparedStatement ps = conexion.prepareStatement(sqlPrincipal, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, reporte.getTipoReporte());
                ps.setString(2, reporte.getDescripcionReporte());
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        reporte.setCodigoReporte(idGenerado);
                    }
                }
            }

            // 2. Insertar en sub-tabla de usuario
            try (PreparedStatement ps = conexion.prepareStatement(sqlDetalle)) {
                ps.setInt(1, reporte.getCodigoReporte());
                ps.setInt(2, reporte.getIdUsuario());
                ps.setString(3, "Pendiente"); // Estado inicial por defecto
                ps.executeUpdate();
            }

            conexion.commit();
            conexion.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Error al guardar el reporte de usuario: " + e);
        }
    }

    @Override
    public void crearReporteEmpleado(Reporte reporte) {
        String sqlPrincipal = "INSERT INTO reportes (tipoReporte, descripcionReporte) VALUES (?, ?)";
        String sqlDetalle = "INSERT INTO repemp (CodigoReporte, IdEmpleadoReporte, estadoReporte) VALUES (?, ?, ?)";

        try (Connection conexion = cn.conectar()) {
            if (conexion == null) return;
            conexion.setAutoCommit(false);

            // 1. Insertar en tabla principal
            try (PreparedStatement ps = conexion.prepareStatement(sqlPrincipal, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, reporte.getTipoReporte());
                ps.setString(2, reporte.getDescripcionReporte());
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        reporte.setCodigoReporte(idGenerado);
                    }
                }
            }

            // 2. Insertar en sub-tabla de empleado
            try (PreparedStatement ps = conexion.prepareStatement(sqlDetalle)) {
                ps.setInt(1, reporte.getCodigoReporte());
                ps.setInt(2, reporte.getIdEmpleadoReporte());
                ps.setString(3, "Pendiente"); // Estado inicial por defecto
                ps.executeUpdate();
            }

            conexion.commit();
            conexion.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Error al guardar el reporte de empleado: " + e);
        }
    }

    @Override
    public List<Reporte> obtenerHistorialUsuario(int idUsuario) {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT r.CodigoReporte, r.tipoReporte, r.descripcionReporte, r.fechaCreacion, " +
                     "u.IdUsuario, u.IdEmpleadoAtencion, u.estadoReporte, u.comentario, u.fechaAtendido " +
                     "FROM reportes r " +
                     "INNER JOIN repus u ON r.CodigoReporte = u.CodigoReporte " +
                     "WHERE u.IdUsuario = ? " +
                     "ORDER BY r.fechaCreacion DESC";

        try (Connection conexion = cn.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) return lista;

            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reporte reporte = new Reporte();
                    reporte.setCodigoReporte(rs.getInt("CodigoReporte"));
                    reporte.setTipoReporte(rs.getString("tipoReporte"));
                    reporte.setDescripcionReporte(rs.getString("descripcionReporte"));
                    reporte.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                    reporte.setIdUsuario(rs.getInt("IdUsuario"));
                    
                    int idAtencion = rs.getInt("IdEmpleadoAtencion");
                    if (!rs.wasNull()) reporte.setIdEmpleadoAtencion(idAtencion);
                    
                    reporte.setEstadoReporte(rs.getString("estadoReporte"));
                    reporte.setComentario(rs.getString("comentario"));
                    reporte.setFechaAtendido(rs.getTimestamp("fechaAtendido"));

                    lista.add(reporte);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener historial de usuario: " + e);
        }
        return lista;
    }

    @Override
    public List<Reporte> obtenerHistorialEmpleado(int idEmpleado) {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT r.CodigoReporte, r.tipoReporte, r.descripcionReporte, r.fechaCreacion, " +
                     "e.IdEmpleadoReporte, e.IdEmpleadoAtencion, e.estadoReporte, e.comentario, e.fechaAtendido " +
                     "FROM reportes r " +
                     "INNER JOIN repemp e ON r.CodigoReporte = e.CodigoReporte " +
                     "WHERE e.IdEmpleadoReporte = ? " +
                     "ORDER BY r.fechaCreacion DESC";

        try (Connection conexion = cn.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) return lista;

            ps.setInt(1, idEmpleado);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reporte reporte = new Reporte();
                    reporte.setCodigoReporte(rs.getInt("CodigoReporte"));
                    reporte.setTipoReporte(rs.getString("tipoReporte"));
                    reporte.setDescripcionReporte(rs.getString("descripcionReporte"));
                    reporte.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                    reporte.setIdEmpleadoReporte(rs.getInt("IdEmpleadoReporte"));
                    
                    int idAtencion = rs.getInt("IdEmpleadoAtencion");
                    if (!rs.wasNull()) reporte.setIdEmpleadoAtencion(idAtencion);
                    
                    reporte.setEstadoReporte(rs.getString("estadoReporte"));
                    reporte.setComentario(rs.getString("comentario"));
                    reporte.setFechaAtendido(rs.getTimestamp("fechaAtendido"));

                    lista.add(reporte);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener historial de empleado: " + e);
        }
        return lista;
    }
}
