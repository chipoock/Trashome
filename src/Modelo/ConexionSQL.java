package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
	
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/trashome";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "147741";


	static {
		
		try {Class.forName(CONTROLADOR);
		}catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("ERROR al cargar el controlador");
			
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		
		try { 			
			conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA);
			System.out.println("Conexion ok");

			
			} catch(SQLException e) {
				System.out.println("ERROR en la Conexion");
				e.printStackTrace();
				
		}  
		
		return conexion;

		
	}
	
}