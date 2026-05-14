package application.model;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Calendario {
	
	
    public ArrayList<Integer> organico;
    public ArrayList<Integer> reciclable;
    public ArrayList<Integer> inorganico;

	
	ArrayList<String> diasNum = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25",
			"26","27","28","29","30","31"));
	
	public Calendario (){
		
		
		

		
		
	}
	
	
	
	
	
	
		LocalDate hoy = LocalDate.now();
		
		int ano = hoy.getYear(); //Año
	
		int mes = hoy.getMonthValue(); //MES
		
		
		LocalDate primerDia = LocalDate.of(ano, mes, 1); //Variable que indica el dia 1
		
        
        int  dia = hoy.getDayOfMonth(); //DIA ACTUAL
        


        
		public int PrimerDia() {
        
        	
        	
            String diaSemana = primerDia.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.of("es", "ES"));
            
            switch(diaSemana) {
            
            
            case "lunes":
            	return 1;
            	
            	
            case "martes":
            	
            	return 2;
            	
            	
            case "mierecoles":
            	
            	return 3;
            	
            	
            case "jueves":
            	
            	return 4;
            	
            	
            case "viernes":
            
            	return 5;
            	
            	
            case "sabado":
            	
            	return 6;
            	
            	
            case "domingo":
            	
            	return 7;
            
            }
            
            return 0;
        	
        }
        
        
        
        
	
	
	
	
	

			
		

		
						

			
	public String ContadorMes(int mesSR){
		
				
		ArrayList<String> meses = new ArrayList<>(Arrays.asList("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"));
		
		String nombreMes = meses.get(mes -1 );
		
		return nombreMes;
		
			
			
			
		}
	
	public ArrayList<String> PosicionDias( ){
		
		
		switch(mes) {
		
		
			
			
		case 4,6,9,11: //30 DIAs
		
			diasNum.remove(30);
			return diasNum;

			
		
		case 2: //28 Dias
			
			diasNum.remove(30);
			diasNum.remove(29);
			diasNum.remove(28);

			return diasNum;

						
			
			
			
		
		}
		return diasNum;

	}
	
	
	
	public void DiaLunes(int diaObjetivo, String color, int primerDia, int totalDias, BorderPane[] diasBorder) {

		int primerRecoleccion = 1 + ((diaObjetivo - primerDia + 7) % 7);

		for (int dia = primerRecoleccion; dia <= totalDias; dia += 7) {

			int posicionVisual = dia + primerDia - 2;

			diasBorder[posicionVisual].setStyle( "-fx-background-color: " + color + ";");
			
			
			 Button btn = (Button) diasBorder[posicionVisual].getCenter();
			
			 
			 btn.getStyleClass().add("botonOrganico");


             btn.setVisible(true);
             
             btn.setText("Orgánico");
             

             
             HBox caja = (HBox) diasBorder[posicionVisual].getBottom();

             ImageView img = (ImageView) caja.getChildren().get(0);
             
             img.setImage(new Image("file:Resource/organico.png"));            		 
             img.setFitWidth(40);
             img.setFitHeight(27);
             img.fitWidthProperty().bind(
            		    diasBorder[posicionVisual].widthProperty().multiply(0.46)
            		);

            		img.fitHeightProperty().bind(
            		    diasBorder[posicionVisual].heightProperty().multiply(0.27)
            		);
            		
            		
            		
                    btn.setVisible(true);
                    img.setVisible(true);

		}
		
		
		
	}
	
	public void pintarAlternado(int diaObjetivo, String color1, String color2, int primerDia, int totalDias, BorderPane[] diasBorder) {
		
		int primerRecoleccion = 1 + ((diaObjetivo - primerDia + 7) % 7);
		int contador = 0;

		for (int dia = primerRecoleccion; dia <= totalDias; dia += 7) {

			int posicionVisual = dia + primerDia - 2;

			if (contador % 2 == 0) {
			
				diasBorder[posicionVisual].setStyle( "-fx-background-color:" + color1 + ";" );
				
				 Button btn = (Button) diasBorder[posicionVisual].getCenter();

	             
	             btn.setText("Inorganico");
	             
				 btn.getStyleClass().add("botonInorganico");
				 
	             
				 HBox caja = (HBox) diasBorder[posicionVisual].getBottom();

		         ImageView img = (ImageView) caja.getChildren().get(0);
		             
		         img.setImage(new Image("file:Resource/inorganico.png"));            		 
                 img.setFitWidth(40);
		         img.setFitHeight(27);
		         img.fitWidthProperty().bind(diasBorder[posicionVisual].widthProperty().multiply(0.46));

	             img.fitHeightProperty().bind(diasBorder[posicionVisual].heightProperty().multiply(0.26));
                 img.setVisible(true);
	             btn.setVisible(true);


				
			} else {
				diasBorder[posicionVisual].setStyle( "-fx-background-color:" + color2 + ";" );
				 Button btn = (Button) diasBorder[posicionVisual].getCenter();

	             
	             btn.setText("Reciclable");
	             
				 btn.getStyleClass().add("botonReciclable");
	             
	             
	             
	             HBox caja = (HBox) diasBorder[posicionVisual].getBottom();

	             ImageView img = (ImageView) caja.getChildren().get(0);
	             
	             img.setImage(new Image("file:Resource/reciclable3.png"));            		 
	             img.setFitWidth(40);
	             img.setFitHeight(27);
	             img.fitWidthProperty().bind(diasBorder[posicionVisual].widthProperty().multiply(0.48));

	            img.fitHeightProperty().bind(diasBorder[posicionVisual].heightProperty().multiply(0.28));
	            
	            
	             btn.setVisible(true);
	             img.setVisible(true);


			}

	
	             contador++;
		}
	}
	
	
	public void Organico() {
		
		
		
		
	}
		


	    


		
		
		
		
			
		
	}
	

