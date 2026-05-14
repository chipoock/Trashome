package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CamionesDao {

	
	
	ConexionSQL cn = new ConexionSQL();
	Connection conn;
	PreparedStatement pst,pst2,pst3;
	ResultSet rs;
	
	
   public boolean registroCamiones(Camiones crearCamion) {
	   
		String query = "INSERT INTO camiones (Matricula, Contenedor) VALUES (?, ?)";
		
		
		String query2 = "INSERT INTO camRut (Matricula, CodigoRuta, fachaRecoleccion) VALUES (?, ?, ?)";

		String query3 = "INSERT INTO empCam (IdEmpleado, Matricula, FechaAsignada) VALUES (?, ?, ?)";

		
	
		try {
			
			conn = cn.conectar();
			
			conn.setAutoCommit(false);
			
			java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
			
			
			

			pst = conn.prepareStatement(query);
			
			pst.setString(1, crearCamion.getMatriculaCamion());
			pst.setString(2, crearCamion.getTypeBus());
			pst.executeUpdate();
			
			
			
			pst2 = conn.prepareStatement(query2);
			
			pst2.setString(1, crearCamion.getMatriculaCamion());
			pst2.setInt(2, crearCamion.getZonaAsignada());
			pst2.setDate(3, fechaActual);
			pst2.executeUpdate();

			
			
			pst3 = conn.prepareStatement(query3);
			
			pst3.setInt(1, crearCamion.getIdEmployee());
			pst3.setString(2, crearCamion.getMatriculaCamion());
			pst3.setDate(3, fechaActual);
			pst3.executeUpdate();

			conn.commit();
			
			return true;
		}catch(SQLException e){
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
		

	   
	   
	   
	   
   }
	
	
}
