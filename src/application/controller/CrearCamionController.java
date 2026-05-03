package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	        
	        
	    }
	

	
		
	}
	
	

	
	

