package application.model;

import java.util.List;

public interface ReporteDao {
    void crearReporteUsuario(Reporte reporte);
    void crearReporteEmpleado(Reporte reporte);
    List<Reporte> obtenerHistorialUsuario(int idUsuario);
    List<Reporte> obtenerHistorialEmpleado(int idEmpleado);
}
