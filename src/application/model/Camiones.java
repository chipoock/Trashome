package application.model;

import java.util.Scanner;

public class Camiones {
	
	private String matriculaCamion,typeBus;
	private int idEmployee, zonaAsignada;
	
	//----------CONSTRUCTOR----------
	public Camiones(String matriculaCamion, String typeBus, int zonaAsignada, int idEmployee ) {
		
		setMatriculaCamion(matriculaCamion);
		setTypeBus(typeBus);
		setZonaAsignda(zonaAsignada);
		setIdEmployee(idEmployee);
		
		System.out.println(matriculaCamion);
		System.out.println(typeBus);
		System.out.println(zonaAsignada);
		System.out.println(idEmployee);

		
		
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
	
	
	public int getZonaAsignada() {
		
		return zonaAsignada;
	}
	
	
	public void setZonaAsignda(int zonaAsignada) {
		
		this.zonaAsignada = zonaAsignada;
		
		
	} 
	
	
	public int getIdEmployee() {
		
		return idEmployee;
	}
	
	
	public void setIdEmployee(int idEmployee) {
		
		this.idEmployee = idEmployee;
		
		
	} 
	
	
	
	
	

	
	

}
