package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {
	
	public static void main(String[] args) {
		
		ConexionSQL conexion = new ConexionSQL();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		
		rs = stm.executeQuery("DESCRIBE usuarios");

		}catch(SQLException e) {
					
			
		}
		
		System.out.println(rs); 
		}
		
}



