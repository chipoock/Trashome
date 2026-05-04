package application.model;

import java.util.ArrayList;

public class Route {
	
	private int codigoPostal;
	private String tipoAsentamiento, municipio, nomRuta, nomAsentamiento, frecuencia;
	private static ArrayList<String> calles = new ArrayList<>();
	
	private  ArrayList<String> callesCons = new ArrayList<>();

	
	public Route (int codigoPostal, String tipoAsentamiento, String municipio , String nomRuta, String nomAsentamiento, String frecuencia, ArrayList<String> callesCons) {
		
		setCodigoPostal(codigoPostal);
		setTipoAsentamiento(tipoAsentamiento);
		setMunicipio(municipio);
		setNomRuta(nomRuta);
		setNomAsentamiento(nomAsentamiento);	
		setFrecuencia(frecuencia);
		setCallesCons(callesCons);
		
	    System.out.println("Codigo Postal: " + codigoPostal);
	    System.out.println("Tipo Asentamiento: " + tipoAsentamiento);
	    System.out.println("Municipio: " + municipio);
	    System.out.println("Nombre Ruta: " + nomRuta);
	    System.out.println("Nombre Asentamiento: " + nomAsentamiento);
	    System.out.println("Frecuencia: " + frecuencia);
	    System.out.println("Calles: " + callesCons);

		
	}
	
	public final int getCodigoPostal() {
		
		return codigoPostal;	
		
	}
	
	
	
	//Geters & Seters Codigo Postal 
	
	public void  setCodigoPostal(int codigoPostal) {
		
		ArrayList<Integer> cP = new ArrayList<>(20);


		
		for(int i = 0; i < cP.size(); i++) {
			
			int codigoPostalBD = cP.get(i);
			
			
			if(codigoPostal == codigoPostalBD) {
				
			 this.codigoPostal = codigoPostal;
			 
		}  
	}
		
	// throw new IllegalArgumentException("El Codigo Postal NO SE ENCONTRO."); 		
		 this.codigoPostal = codigoPostal;

	}

	
	
	//Geters & Seters type asentamiento
	
	public String getTipoAsentamiento() {
		
		return tipoAsentamiento;
		
	}
	
	
	public void setTipoAsentamiento(String tipoAsentamiento) {
		
		this.tipoAsentamiento = tipoAsentamiento;
	
	}
	
	
	
	//Geters & Seters  municipio

	
	public String getMunicipio() {
		
		return municipio;
		
	}
	
	
	public void setMunicipio(String municipio) {
		
		this.municipio = municipio;
	
	}
	
	

	//Geters & Seters nomAsentamiento

	
	public String getNomAsentamiento() {
		
		return nomAsentamiento;
		
	}
	
	
	public void setNomAsentamiento(String nomAsentamiento) {
		
		this.nomAsentamiento = nomAsentamiento;
	
	}
	
	
	
	
	

	//Geters & Seters nomRuta

	
	public String getNomRuta() {
		
		return nomRuta;
		
	}
	
	
	public void setNomRuta(String nomRuta) {
		
		this.nomRuta = nomRuta;
	
	}
	
	
	//Geters & Seters FRECUENCIA

	
		public String getFrecuencia() {
			
			return frecuencia;
			
		}
		
		
		public void setFrecuencia(String frecuencia) {
			
			this.frecuencia = frecuencia;
		
		}
	
	
	//Geters & Seters calles
	
	
	public ArrayList<String> getcalles() {
		
		return callesCons;
		
	}
	
	
	public void setCallesCons(ArrayList<String> callesCons) {
		
		callesCons = calles;
		this.callesCons = callesCons;
	
	}
	

	
	

	
	
	//AGREGAR CALLES
	
	public static ArrayList<String> AgregarCalle (String calle) {
		
		if(!calle.equals("")) {
		
		calles.add(calle);
    	 		
	

		
		} else {System.out.println("Calles no puedo estar vacio");}
		
		
		
		return calles;

	}
	
	public static String BorrarCalle() {
		
		calles.remove(calles.size()-1);
		
		String vistaCalles = calles.toString();

		return vistaCalles;
	}
	
	
	public static void resetCallesArray() {
		
		calles.clear();
	}
	
	
}
