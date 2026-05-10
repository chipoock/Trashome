package application.model;

import java.util.Scanner;

public class Camiones {
	
	private String matriculaCamion,typeBus, zonaAsignada;
	private int idEmployee;
	
	//----------CONSTRUCTOR----------
	public Camiones(String matriculaCamion, String typeBus, String zonaAsignada, int idEmployee ) {
		
		setMatriculaCamion(matriculaCamion);
		setTypeBus(typeBus);
		setZonaAsignda(zonaAsignada);
		setIdEmployee(idEmployee);
		
		
				
		
		
	}
	
	
	
	
	//--------------- METODOS MatriculaCamion Get y Set -----------------
	
	public final String getMatriculaCamion(){
		
		return matriculaCamion;
		
	}
	
	
	// Este setter hace una validacion para saber si deja entrar la matricula al constructor.
	
	public void setMatriculaCamion(String matriculaCamion){
		
		matriculaCamion = matriculaCamion.toUpperCase();

		int contador = matriculaCamion.length();
		
		if(contador == 7 || contador == 6) {
			this.matriculaCamion = matriculaCamion;
			System.out.print("Se a agregado correctamente");

		} else {throw new IllegalArgumentException("La Matricula tiene que tener de 6 a 7 - digitos Intentalo de nuevo."); }		
		
	}
	
	
	
	
	
	//--------------- methods typeBus Get and Set -----------------
	
	
	public final String getTypeBus() {
		
		return typeBus;
	}
	
	
	
	public void setTypeBus(String typeBus){
		
		
		switch(typeBus) {
		
		case "Organico":
		case "Inorganico":
		case "Reciclable":
			
			this.typeBus = typeBus;
		    break;
		    
		default: throw new IllegalArgumentException("El tipo de bus No existe");
		
		}
		
	}
	
	
	public String getZonaAsignada() {
		
		return zonaAsignada;
	}
	
	
	public void setZonaAsignda(String zonaAsignada) {
		
		this.zonaAsignada = zonaAsignada;
		
		
	} 
	
	
	public int getIdEmployee() {
		
		return idEmployee;
	}
	
	
	public void setIdEmployee(int idEmployee) {
		
		this.idEmployee = idEmployee;
		
		
	} 
	
	
	
	
	

	
	

}
