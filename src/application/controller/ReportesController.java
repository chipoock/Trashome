package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

import application.model.ConexionSQL;
import application.model.Reporte;
import application.model.ReporteDao;
import application.model.ReporteDaoImpl;
import application.model.UserSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportesController implements Initializable {

    @FXML
    private ComboBox<String> combo_tipoReporte;
    @FXML
    private TextArea txt_descripcion;
    @FXML
    private Button btn_enviarReporte;

    @FXML
    private TableView<Reporte> tablaReportes;
    @FXML
    private TableColumn<Reporte, Integer> colCodigo;
    @FXML
    private TableColumn<Reporte, String> colTipo;
    @FXML
    private TableColumn<Reporte, String> colDescripcion;
    @FXML
    private TableColumn<Reporte, String> colEstado;
    @FXML
    private TableColumn<Reporte, Timestamp> colFecha;

    // Obtenemos el ID de la sesión actual
    private int usuarioIdActual = (UserSession.getInstance().getClient() != null) ? UserSession.getInstance().getClient().getIdUser() : 1;
    // Si queremos probar como empleado, cambiar este booleano. Por defecto, usuario.
    private boolean esEmpleado = false; 

    private ObservableList<Reporte> listaReportes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicializar ComboBox
        combo_tipoReporte.getItems().addAll("Servicio no brindado", "Daño a contenedor", "Mala atención", "Otro");

        // Configurar Columnas de la Tabla
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoReporte"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoReporte"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionReporte"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoReporte"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));

        listaReportes = FXCollections.observableArrayList();
        tablaReportes.setItems(listaReportes);

        cargarHistorial();
    }

    private void cargarHistorial() {
        listaReportes.clear();
        try {
            ReporteDao reporteDao = new ReporteDaoImpl();
            List<Reporte> historial;
            
            if (esEmpleado) {
                historial = reporteDao.obtenerHistorialEmpleado(usuarioIdActual);
            } else {
                historial = reporteDao.obtenerHistorialUsuario(usuarioIdActual);
            }
            
            if (historial != null) {
                listaReportes.addAll(historial);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar historial de reportes.");
        }
    }

    @FXML
    public void enviarReporte(ActionEvent event) {
        String tipo = combo_tipoReporte.getValue();
        String descripcion = txt_descripcion.getText();

        if (tipo == null || tipo.trim().isEmpty() || descripcion == null || descripcion.trim().isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, seleccione un tipo de reporte y agregue una descripción.");
            return;
        }

        Reporte nuevoReporte = new Reporte();
        nuevoReporte.setTipoReporte(tipo);
        nuevoReporte.setDescripcionReporte(descripcion);

        try {
            ReporteDao reporteDao = new ReporteDaoImpl();                
            if (esEmpleado) {
                nuevoReporte.setIdEmpleadoReporte(usuarioIdActual);
                reporteDao.crearReporteEmpleado(nuevoReporte);
            } else {
                nuevoReporte.setIdUsuario(usuarioIdActual);
                reporteDao.crearReporteUsuario(nuevoReporte);
            }

            mostrarAlerta("Éxito", "El reporte ha sido enviado correctamente.");
            
            // Limpiar campos y recargar historial
            combo_tipoReporte.setValue(null);
            txt_descripcion.clear();
            cargarHistorial();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Ocurrió un error al guardar el reporte.");
        }
    }
    
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
