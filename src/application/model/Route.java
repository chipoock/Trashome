package application.model;

import java.util.ArrayList;

public class Route {
	
	private int codigoPostal;
	private String TipoAsentamienoto, municipio, calles, nombreAsentamiento;
	
	public Route (int codigoPostal, String tipoAsentamiento, String nombreAsentamiento , String municipio, String calles) {
		
		setCodigoPostal(codigoPostal);
		
	}
	
	private final int getCodigoPostal() {
		
		return codigoPostal;	
		
	}
	
	
	
	//Geters & Seters Codigo Postal 
	
	private void  setCodigoPostal(int codigoPostal) {
		
		ArrayList<Integer> cP = new ArrayList<>();
		cP.add(21232);
		cP.add(232);
		cP.add(2232);


		
		for(int i = 0; i < cP.size(); i++) {
			
			int codigoPostalBD = cP.get(i);
			
			
			if(codigoPostal == codigoPostalBD) {
				
			 this.codigoPostal = codigoPostal;
			 
			 return ;
		}  
	}
		
	throw new IllegalArgumentException("El Codigo Postal NO SE ENCONTRO."); 		

	}

	
	
	//Geters & Seters municipio
	
	
	
	
	

	
	
	
	
	private void CreateRoute (String calles) {
		
		
		
		
		
		
		
		
	}
}
