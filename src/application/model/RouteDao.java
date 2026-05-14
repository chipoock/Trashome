package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RouteDao {
	
	//CONECTAR A LA BASE DE DATOS
	
	ConexionSQL cn = new ConexionSQL();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	//REGISTRAR RUTA
	
	public boolean registroRuta(Route Ruta) {
		
		
		String query = "INSERT INTO rutas (codigoPostal, asentamiento, tipoAsentamiento, municipio, calles, frecuencia, rutaNombre) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		//Timestamp datetime = new Timestamp(new Date(0).getTime());
		
		ArrayList<String> lista = Ruta.getCalles();

		String callesTexto = String.join(", ", lista);


		try {
			conn = cn.conectar();
			pst = conn.prepareStatement(query);
			pst.setInt(1, Ruta.getCodigoPostal());
			pst.setString(2, Ruta.getNomAsentamiento());
			pst.setString(3, Ruta.getTipoAsentamiento());
			pst.setString(4, Ruta.getMunicipio());
			pst.setString(5, callesTexto);
			pst.setString(6, Ruta.getFrecuencia());
			pst.setString(7, Ruta.getNomRuta());
			
			pst.execute();
			
			return true;
			
			
			
		}catch(SQLException e) {
			
			
			JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LA RUTA");
		}
		return false;
		
	}
	
	
	
		
		// MODIFICAR RUTAS
		
		
		public boolean UpdateRuta(Route Ruta) {
			
			
			String query = "UPDATE rutas SET codigoPostal = ?, asentamiento = ?, tipoAsentamiento = ?, municipio = ?, calles = ?, frecuencia = ?, rutaNombre = ? WHERE CodigoRuta = ?";
			
			ArrayList<String> lista = Ruta.getCalles();

			String callesTexto = String.join(", ", lista);




			try {
				conn = cn.conectar();
				pst = conn.prepareStatement(query);
				pst.setInt(1, Ruta.getCodigoPostal());
				pst.setString(2, Ruta.getNomAsentamiento());
				pst.setString(3, Ruta.getTipoAsentamiento());
				pst.setString(4, Ruta.getMunicipio());
				pst.setString(5, callesTexto);
				pst.setString(6, Ruta.getFrecuencia());
				pst.setString(7, Ruta.getNomRuta());
				
				pst.execute();
				
				return true;
				
				
				
			}catch(SQLException e) {
				
				
				JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR LOS DATOS DE LAS RUTA");
			}
			return false;
			
			
		}
		
		
		// ELIMINAR RUTAS

		
		public boolean DeleteRuta(int id) {
			

			
			
			String query = "DELETE FROM rutas WHERE codigoRuta = " + id;
			



			try {
				conn = cn.conectar();
				pst = conn.prepareStatement(query);
				pst.execute();
				return true;
				
				
				
			}catch(SQLException e) {
				
				
				JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR LOS DATOS DE LAS RUTA");
			}
			return false;
			
			
		}
		
		//OPTENER EL CODIGO DE LA RUTA
		
		
		// OBTENER NOMBRE DE RUTA

		public int obtenerCodigoRuta(String nombreRuta) {

		    String sql = "SELECT CodigoRuta FROM rutas WHERE rutaNombre = ?";

		    try {
		        conn = cn.conectar();
		        pst = conn.prepareStatement(sql);
		        pst.setString(1, nombreRuta);
		        rs = pst.executeQuery();

		        if(rs.next()) {
		            return rs.getInt("CodigoRuta");
		        }

		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		    return 0;
		}
		
		
		
	
		public List<String> obtenerNombresRutas() {
		    // Solo seleccionamos la columna del nombre y quitamos el filtro WHERE
		    String sql = "SELECT rutaNombre FROM rutas";
		    List<String> listaNombres = new ArrayList<>();

		    try {
		        conn = cn.conectar();
		        pst = conn.prepareStatement(sql);
		        rs = pst.executeQuery();

		        // Recorremos todos los registros encontrados
		        while (rs.next()) {
		            // Agregamos cada nombre a nuestra lista
		            listaNombres.add(rs.getString("rutaNombre"));
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        // Es recomendable cerrar los recursos aquí (rs, pst, conn)
		    }

		    return listaNombres;
		}
		
	
		// OBTENER NOMBRE DE RUTA

		public String obtenerNombreRuta(int codigoRuta) {

		    String sql = "SELECT rutaNombre FROM rutas WHERE CodigoRuta = ?";

		    try {

		        conn = cn.conectar();
		        pst = conn.prepareStatement(sql);
		        pst.setInt(1, codigoRuta);

		        rs = pst.executeQuery();

		        if(rs.next()) {

		            return rs.getString("rutaNombre");

		        }

		    } catch(Exception e) {

		        e.printStackTrace();

		    }

		    return "";
		}


}

