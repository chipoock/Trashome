package application.controller;

import javafx.fxml.FXML;
import application.model.Route;
import application.model.RouteDao;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.web.WebView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        
        
        frecuencia.getItems().addAll("Basica","Mediana", "Alta");
	    frecuencia.setValue("Basica");
	    
	    typeAs.getItems().addAll("Colonia","Condominio","Conjunto habitacional","Equipamiento","Fraccionamiento","Pueblo","Unidad Habitacional","Zona Industrial");
	    typeAs.setValue("Colonia");
	    
	    
	    asentamientoBox.getItems().addAll(nomAsentamiento);
	    
	    
	    
    }
    
    
    // METODO SUMAR CALLES
    
    @FXML
    private TextField calleText;
    
    @FXML
    private Label vistaCalles; 
	
	

    
    @FXML public ArrayList<String> SumarCalles() {
    	
    	String calle = calleText.getText();

    	
    	calle = calle.toUpperCase();
		

    	ArrayList<String> view = Route.AgregarCalle(calle);
    	

    	vistaCalles.setWrapText(true);
    	vistaCalles.setText("Calles Agregadas: " + String.join(", ", view));
    	
    
    	calleText.clear();
    	
    	return view;
    	
    	
    }
    
    //METODO BORRAR CALLES
    
    @FXML public void BorrarCalles() {
    	
    	String view = Route.BorrarCalle();
    	
    	vistaCalles.setWrapText(true);
        vistaCalles.setText("Calles Agregadas: " + view );

    
    }
    
    
   @FXML 
   private ComboBox<String> frecuencia;
   
   
   @FXML 
   private ComboBox<String> typeAs;
   
   @FXML 
   private ComboBox<String> asentamientoBox;
   
   @FXML
   private TextField nomRuta;
   
   @FXML
   private TextField CP;
   
   @FXML
   private TextField municipio;
   
   @FXML
   public ArrayList<String> nomAsentamiento = new ArrayList<String>();
 

   
   @FXML public void CrearRuta() {
	   
	   String tipoFrecuencia = frecuencia.getValue();
	   
	   String asentamiento = typeAs.getValue();
	   
	   String nombreRuta = nomRuta.getText();
	   
	   String codigoPostal = CP.getText();
	   
	   int cPostal = Integer.parseInt(codigoPostal);
	   
	   String municipioM = municipio.getText();
	   
	   String nomAsentamiento = asentamientoBox.getValue();

	   
		ArrayList<String> calles = SumarCalles();
	   
	   Route Ruta = new Route(cPostal, asentamiento, municipioM, nombreRuta, nomAsentamiento, tipoFrecuencia, calles);
	   
	   System.out.println("Entró al botón Guardar");
	   RouteDao dao = new RouteDao();
	   System.out.println("DAO creado");
	   
	   
	   boolean ok = dao.registroRuta(Ruta);
	   System.out.println("Resultado: " + ok);
	   
	   nomRuta.clear();
	   CP.clear();
	   municipio.clear();
	   
	   Route.resetCallesArray();
	   
	   vistaCalles.setText("");
	   
   }
	   

   }
    
    
    