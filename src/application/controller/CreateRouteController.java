package application.controller;

import javafx.fxml.FXML;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.concurrent.Worker;
import javafx.fxml.Initializable;

public class CreateRouteController implements Initializable {

    @FXML
    private WebView maps;

    private WebEngine engine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = maps.getEngine();
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