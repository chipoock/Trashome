package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.Camiones;
import application.model.CamionesDao;
import application.model.RouteDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.fxml.Initializable;


public class CrearCamionController implements Initializable {
	
	
	
	
	 @FXML
	    private WebView mapa;

	    private WebEngine engine;
	    

	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        engine = mapa.getEngine();
	        engine.load("https://opentopomap.org/#map=13/20.6736/-103.344");
	        
	        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
	            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
	                engine.executeScript("""
	                    // Busca el control de capas y selecciona OpenStreetMap
	                    let labels = document.querySelectorAll('label');
	                    labels.forEach(l => {
	                        if (l.innerText.includes('OpenStreetMap')) {
	                            l.click();
	                        }
	                    });
	                """);
	            }
	        });
	        
	        
	        
	        contenedorBox.getItems().addAll("Organico","Reciclable","Inorganico");
	        contenedorBox.setValue("Inorganico");
	        
	        
		    nomRutas = miDao.obtenerNombresRutas();
		    
		    
	        rutaBox.getItems().addAll(nomRutas);
	        if (!nomRutas.isEmpty()) {
	            rutaBox.getSelectionModel().selectFirst(); 
	        }
	    }
	
	    
	    @FXML
	    private TextField matriculaField;
	    
	    @FXML
	    private TextField codigoEmpField;
	    
	    @FXML
	    private ComboBox<String> contenedorBox;
	    
	    @FXML
	    private ComboBox<String> rutaBox;
	    
	    @FXML
	    public List<String> nomRutas = new ArrayList<>();	
	    RouteDao miDao = new RouteDao();
	    
	    
		@FXML private void CrearCamion() {
				
		 String matriculaCamion = matriculaField.getText();
		
		 String codigoEmp = codigoEmpField.getText().trim();
		 
		 System.out.println("[" + codigoEmp + "]");
		 
		 
		 
		 if(codigoEmp.isEmpty()){
			    JOptionPane.showMessageDialog(null,"Campo vacío");
			    return;
			}

		 
		 int idEmployee = Integer.parseInt(codigoEmp);
		
		 String typeBus = contenedorBox.getValue();
		 
		 String nombreRuta = rutaBox.getValue();

		 int codigoRuta = miDao.obtenerCodigoRuta(nombreRuta);
		 
		 matriculaCamion = matriculaCamion.toString();
			
		Camiones crearCamion = new Camiones(matriculaCamion, typeBus, codigoRuta, idEmployee); 
		
		CamionesDao camDao = new CamionesDao();
		
		camDao.registroCamiones(crearCamion);
		
		matriculaField.clear();		
		
		codigoEmpField.clear();
	}
}
	

	
	

