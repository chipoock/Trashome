package application.model;

import java.sql.Timestamp;

public class Reporte {
    private int codigoReporte;
    private String tipoReporte;
    private String descripcionReporte;
    private Timestamp fechaCreacion;
    
    // Sub-tablas repus / repemp
    private Integer idUsuario;
    private Integer idEmpleadoReporte;
    private Integer idEmpleadoAtencion;
    private String estadoReporte;
    private String comentario;
    private Timestamp fechaAtendido;
    
    public Reporte() {
    }

    public Reporte(String tipoReporte, String descripcionReporte, Integer idUsuario, Integer idEmpleadoReporte) {
        this.tipoReporte = tipoReporte;
        this.descripcionReporte = descripcionReporte;
        this.idUsuario = idUsuario;
        this.idEmpleadoReporte = idEmpleadoReporte;
    }

    public int getCodigoReporte() {
        return codigoReporte;
    }

    public void setCodigoReporte(int codigoReporte) {
        this.codigoReporte = codigoReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getDescripcionReporte() {
        return descripcionReporte;
    }

    public void setDescripcionReporte(String descripcionReporte) {
        this.descripcionReporte = descripcionReporte;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpleadoReporte() {
        return idEmpleadoReporte;
    }

    public void setIdEmpleadoReporte(Integer idEmpleadoReporte) {
        this.idEmpleadoReporte = idEmpleadoReporte;
    }

    public Integer getIdEmpleadoAtencion() {
        return idEmpleadoAtencion;
    }

    public void setIdEmpleadoAtencion(Integer idEmpleadoAtencion) {
        this.idEmpleadoAtencion = idEmpleadoAtencion;
    }

    public String getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFechaAtendido() {
        return fechaAtendido;
    }

    public void setFechaAtendido(Timestamp fechaAtendido) {
        this.fechaAtendido = fechaAtendido;
    }
}
