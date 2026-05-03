package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class EscenaPrincipalController {

    @FXML
    private BorderPane contenedorPrincipal;

    @FXML
    public void initialize() {
        cargarVista("CreateRoute.fxml"); 
    }

    private void cargarVista(String archivo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/" + archivo) );

            Parent vista = loader.load();

            vista.maxWidth(Double.MAX_VALUE);
            vista.maxHeight(Double.MAX_VALUE);
            
            System.out.println("Cargando: " + archivo);

            contenedorPrincipal.setCenter(vista);
        } catch (Exception e) {
            System.out.println(" Error cargando vista: " + archivo);
            e.printStackTrace();
        }
    }

    
    @FXML
    private void abrirPerfil() {
        cargarVista("Perfil.fxml");
    }

    @FXML
    private void abrirCalendario() {
        cargarVista("Calendario.fxml");
    }

    @FXML
    private void abrirTrabajo() {
        cargarVista("RegistroEmpleado.fxml");
    }

    @FXML
    private void abrirCamiones() {
        cargarVista("CrearCamion.fxml");
    }

    @FXML
    private void abrirRutas() {
        cargarVista("CreateRoute.fxml");
    }

    @FXML
    private void abrirReportes() {
        cargarVista("Reportes.fxml");
    }

    @FXML
    private void abrirCreditos() {
        cargarVista("Creditos.fxml");
    }
    
}

