package application.controller;

import java.util.ArrayList;
import application.model.Calendario;
import application.model.RouteDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class CalendarioController {
	

	
	RouteDao dao = new RouteDao();

	
	@FXML
	Label day1Label, day2Label, day3Label, day4Label, day5Label, day6Label, day7Label, day8Label, day9Label, day10Label, day11Label, day12Label, day13Label, day14Label, day15Label, day16Label, day17Label
	,day18Label, day19Label, day20Label, day21Label, day22Label, day23Label, day24Label, day25Label, day26Label, day27Label, day28Label, day29Label, day30Label, day31Label, day32Label, day33Label
	, day34Label, day35Label;
	
	@FXML
	BorderPane day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31,day32
	,day33,day34,day35;

	
	
	
	@FXML
	Label mesesLabel;
	
	
	
	
	@FXML
	private ScrollPane scrollInfo;


	@FXML
	public void initialize(){
		

		
		Calendario cal = new Calendario();
		
		ArrayList<String> calDias = cal.PosicionDias();
		
		int dia = cal.PrimerDia();
		
		 Label[] dias = { day1Label, day2Label, day3Label, day4Label, day5Label, day6Label, day7Label, day8Label, day9Label, day10Label, day11Label, day12Label, day13Label, day14Label, day15Label,
			        day16Label, day17Label,day18Label, day19Label, day20Label, day21Label, day22Label, day23Label, day24Label, day25Label, day26Label, day27Label, day28Label, day29Label, day30Label
			        , day31Label, day32Label, day33Label, day34Label, day35Label};
		
		for(int i = 0; i < calDias.size(); i++ ) {
			
			dias[i + dia - 1].setText(calDias.get(i));
			
			int mesSR = 0;
			String meses = cal.ContadorMes(mesSR);
			
			mesesLabel.setText(meses);
			
							
				
			}
		
		
		
		
		
		BorderPane[] diasBorder = {day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14, day15, day16, day17, day18, day19, day20, day21, day22, day23, day24, day25, day26, day27, day28, day29, day30, day31, day32, day33, day34, day35};
		
		
	
		
		

		
		
		int primerDia = cal.PrimerDia();
		int totalDias = calDias.size();

		cal.DiaLunes(1, "#2E5D4D", primerDia, totalDias, diasBorder); 
		cal.pintarAlternado(5,"#4E4E55", "#486B85",primerDia, totalDias, diasBorder );		
		
		
		
	

		    scrollInfo.setFitToWidth(true);
		    scrollInfo.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		    scrollInfo.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		    System.out.println("nombreEmpleado = " + nombreEmpleado);

	
		}
	
	@FXML
	public void sumaMes(){
		
		Calendario cal = new Calendario();

		ArrayList<String> calDias = cal.PosicionDias();

		int dia = cal.PrimerDia();
		
		 Label[] dias = { day1Label, day2Label, day3Label, day4Label, day5Label, day6Label, day7Label, day8Label, day9Label, day10Label, day11Label, day12Label, day13Label, day14Label, day15Label,
			        day16Label, day17Label,day18Label, day19Label, day20Label, day21Label, day22Label, day23Label, day24Label, day25Label, day26Label, day27Label, day28Label, day29Label, day30Label
			        , day31Label, day32Label, day33Label, day34Label, day35Label};
		
		for(int i = 0; i < calDias.size(); i++ ) {
			
			dias[i + dia - 1].setText(calDias.get(i));
			
			int mesSR = 2;
			String meses = cal.ContadorMes(mesSR);
			
			mesesLabel.setText(meses);
			
							
				
			}
		
		
		
		
		
		BorderPane[] diasBorder = {day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14, day15, day16, day17, day18, day19, day20, day21, day22, day23, day24, day25, day26, day27, day28, day29, day30, day31, day32, day33, day34, day35};
		
		
	
		
		

		
		
		int primerDia = cal.PrimerDia();
		int totalDias = calDias.size();

		cal.DiaLunes(1, "#2E5D4D", primerDia, totalDias, diasBorder); 
		cal.pintarAlternado(5,"#4E4E55", "#486B85",primerDia, totalDias, diasBorder );		
		
		
	
		
		
	}	
	
	
	
	// MOSTRAR DATOS LUNES:
	
	@FXML
	BorderPane fondoInfo;
	
	@FXML
	Label horarioLabel,nomRutaLabel,InformacionLabel,tituloLabel, nombreEmpleado, nomMatricula ;
	
	
	@FXML
	ImageView residuos1,residuos2,residuos3,residuos4,residuos5;
	
	
	
	
	@FXML 
	public void OrganicoDatos(ActionEvent event) {
		
	String horario;
	
	horario = "     8:00AM - 10:00AM ";
	
	horarioLabel.setText(horario);
	
	
    int idRuta = 1;
    
    
    String nombreRuta = dao.obtenerNombreRuta(idRuta);

    nomRutaLabel.setText("     " + nombreRuta);
    
    
    
    fondoInfo.setStyle("-fx-background-color: #274E41;");
    
    
    String lunes = "Lunes";
    
    
    tituloLabel.setText(lunes);
    
    
    Button boton = (Button) event.getSource();

    String id = boton.getId();


    
    switch(id) {
    

    case "button8":
    	
    	String nombre = "  Isaac de Jesus Rivas Garcia";
    	
    	
    	String matricula = "   4814FJG";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    	
    case "button15":
    	
    	nombre = "  Joshua David Delgado Lopez";
    	
    	
    	 matricula = "   4814FJG";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    case "button22":
    	
    	 nombre = "  Aide Guadalupe Michel Manriquez";
    	
    	
    	 matricula = "   8913NCF";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    
    case "button29":
    	
    	nombre = "  Aide Guadalupe Michel Manriquez";
    	
    	
        matricula = "   4814FJG";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    
    
    
    }	
    	
    
    
    
    
    
    
    
    
    String informacion =
    		"                             Organicos\n\n"
    		+ "Los residuos orgánicos son todos aquellos desechos de origen natural que provienen de seres vivos, como plantas o animales, y que tienen la capacidad de descomponerse de manera natural con el paso del tiempo.\n\n"

    		+ "Residuos orgánicos:\n\n"

    		+ "• Cáscaras de frutas (plátano, naranja, mango, manzana, etc.)\n"
    		+ "• Restos de verduras y vegetales\n"
    		+ "• Sobras de comida natural (arroz, frijoles, tortillas, pan)\n"
    		+ "• Cáscaras de huevo\n"
    		+ "• Huesos pequeños y restos de carne\n"
    		+ "• Restos de café molido y filtros de papel\n"
    		+ "• Bolsitas de té\n"
    		+ "• Hojas secas\n"
    		+ "• Flores marchitas\n"
    		+ "• Pasto cortado\n"
    		+ "• Ramas pequeñas\n"
    		+ "• Semillas\n"
    		+ "• Servilletas usadas con comida\n"
    		+ "• Aserrín natural sin químicos\n\n\n\n\n\n\n\n\n\n\n\n\n";
    
    InformacionLabel.setWrapText(true);
    InformacionLabel.setPrefWidth(195);
    InformacionLabel.setText(informacion);
    

    Image img = new Image("file:Resource/organicoo.png");
    Image img2 = new Image("file:Resource/plantas.png");
    
    
    
    residuos1.setImage(null);
    residuos2.setImage(null);
    residuos3.setImage(null);
    residuos4.setImage(null);
    residuos5.setImage(null);
    
    residuos1.setImage(img);
    residuos2.setImage(img2);

	
	}
	

	
	
	
	
	
	@FXML 
	public void ReciclableDatos(ActionEvent event) {
		
	String horario;
	
	horario = "     1:00PM - 3:00PM ";
	
	horarioLabel.setText(horario);
	
	
    int idRuta = 1;
    
    fondoInfo.setStyle("-fx-background-color: #486B85;");
    
    String nombreRuta = dao.obtenerNombreRuta(idRuta);

    nomRutaLabel.setText("     " + nombreRuta);
    
    
    
    
    
    
    String lunes = "Viernes";
    
    
    tituloLabel.setText(lunes);
    
    
    
    

    Button boton = (Button) event.getSource();

    String id = boton.getId();


    
    switch(id) {
    

    case "button12":
    	
    	String nombre = "  Ricardo Méndez Ortiz";
    	
    	
    	String matricula = "   8060HDJ";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    	
    case "button26":
    	
    	nombre = "  Ricardo Méndez Ortiz";
    	
    	
    	 matricula = "   8060HDJ";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
   
    
   
    
    
    }	
    	
    
    
    
    
    
    String informacion =
    	    "                             Reciclables\n\n"
    	    + "Son materiales que, tras un proceso de transformación industrial, pueden convertirse en materia prima para fabricar nuevos productos, evitando la extracción de recursos naturales.\n\n"

    	    + "Plásticos:\n\n"
    	    + "• Botellas de agua y refresco (PET).\n"
    	    + "• Envases de champú, detergente y productos de limpieza (PEAD).\n"
    	    + "• Tapas de plástico, envases de yogur y recipientes tipo \"tupper\".\n\n"

    	    + "Metales:\n\n"
    	    + "• Latas de aluminio (jugos y cervezas).\n"
    	    + "• Latas de conservas (atún, chiles, frijoles).\n"
    	    + "• Papel aluminio limpio y grapas o clips.\n\n"

    	    + "Papel y Cartón:\n\n"
    	    + "• Cajas de cereal y de zapatos.\n"
    	    + "• Hojas de cuaderno (sin el resorte metálico), folletos y sobres de papel.\n"
    	    + "• Tubos de cartón del papel higiénico o servitoallas.\n\n"

    	    + "Vidrio:\n\n"
    	    + "• Botellas de vino, cerveza y licores.\n"
    	    + "• Frascos de mermelada, café o conservas.\n"
    	    + "• Envases de perfumes y cosméticos de cristal.\n\n"

    	    + "Madera y Textiles:\n\n"
    	    + "• Lápices, abatelenguas, cajas de fruta (huacales) y palitos de paleta.\n"
    	    + "• Ropa vieja, retazos de tela de algodón o poliéster y sábanas desgastadas.\n";
    
    InformacionLabel.setWrapText(true);
    InformacionLabel.setPrefWidth(195);
    InformacionLabel.setText(informacion);
    

    Image img = new Image("file:Resource/plastico.png");
    Image img2 = new Image("file:Resource/papel.png");
    Image img3 = new Image("file:Resource/vidrio.png");
    Image img4 = new Image("file:Resource/metal.png");
    Image img5 = new Image("file:Resource/tela.png");

    
    
    residuos1.setImage(null);
    residuos2.setImage(null);
    residuos3.setImage(null);
    residuos4.setImage(null);
    residuos5.setImage(null);
    
    residuos1.setImage(img);
    residuos2.setImage(img2);
    residuos3.setImage(img3);
    residuos4.setImage(img4);
    residuos5.setImage(img5);

	
	}
	
	

	
		
	
	
	
	

	
	@FXML 
	public void InorganicoDatos(ActionEvent event) {
		
	String horario;
	
	horario = "     5:00PM - 7:00PM ";
	
	horarioLabel.setText(horario);
	
	
    int idRuta = 1;
    
    fondoInfo.setStyle("-fx-background-color: #4E4E55;");
    
    String nombreRuta = dao.obtenerNombreRuta(idRuta);

    nomRutaLabel.setText("     " + nombreRuta);
    
    
    
    
    
    
    String lunes = "Viernes";
    
    
    tituloLabel.setText(lunes);
    
    
    
    
    

    Button boton = (Button) event.getSource();

    String id = boton.getId();


    
    switch(id) {
    

    case "button5":
    	
    	String nombre = "  Mónica Leticia Carrillo";
    	
    	
    	String matricula = "   4046BMM";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    	
    case "button19":
    	
    	nombre = "  Joshua David Delgado Lopez";
    	
    	
    	 matricula = "   3395GKC";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    case "button33":
    	
    	 nombre = "  Gabriela Monserrat Soto";
    	
    	
    	 matricula = "   5828HHB";

    	
    	nombreEmpleado.setText(nombre);	
    	
    	nomMatricula.setText(matricula);
    	
    	break;
    
  
    
    
    
    }	
    	
    
    
    
    
    
    
    String informacion =
    	    "                             Inorgánicos\n\n"
    	    + "Son residuos de origen no biológico que, debido a su composición o grado de contaminación, no pueden ser reciclados o requieren procesos muy complejos para su reutilización.\n\n"

    	    + "Residuos Inorgánicos:\n\n"

    	    + "• Focos y bombillas rotas\n"
    	    + "• Espejos y cristales de ventana\n"
    	    + "• Cerámica y porcelana (tazas o platos rotos)\n"
    	    + "• Papel celofán y envolturas de frituras (metalizadas)\n"
    	    + "• Popotes y cubiertos desechables usados\n"
    	    + "• Unicel (vasos, platos y charolas)\n"
    	    + "• Toallas sanitarias y pañales desechables\n"
    	    + "• Papel higiénico usado y pañuelos desechables\n"
    	    + "• Jeringas y material de curación (con cuidado en su manejo)\n"
    	    + "• Colillas de cigarro\n"
    	    + "• Esponjas de cocina usadas\n"
    	    + "• Discos compactos (CDs) y casetes\n"
    	    + "• Calzado muy deteriorado o con materiales mezclados\n"
    	    + "• Cepillos de dientes usados\n"
    	    + "• Plumas y bolígrafos sin tinta\n\n\n\n\n\n\n\n";    
    
    
    InformacionLabel.setWrapText(true);
    InformacionLabel.setPrefWidth(195);
    InformacionLabel.setText(informacion);
    

    Image img = new Image("file:Resource/inorganicoo.png");
    Image img2 = new Image("file:Resource/papelIg.png");
    Image img3 = new Image("file:Resource/unicel.png");

    
    
    residuos1.setImage(null);
    residuos2.setImage(null);
    residuos3.setImage(null);
    residuos4.setImage(null);
    residuos5.setImage(null);
    
    residuos1.setImage(img);
    residuos2.setImage(img2);
    residuos3.setImage(img3);

	
	}
	


		
		}
		

	
	

