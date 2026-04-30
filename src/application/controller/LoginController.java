package application.controller;

import application.model.ClienteDao;
import application.model.ClientDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.sql.Connection;
import Modelo.ConexionSQL;
import application.model.Client;

import javafx.scene.Parent;

import javafx.scene.Scene;

import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txt_Correo;
	
	@FXML
	private TextField txt_Password;
	
	@FXML
	private Button btn_Login;
	
	@FXML
	private Label lbl_mensaje;
	
	@FXML
	private Hyperlink linkRegistro;
	
	@FXML
	private Hyperlink linkEquipo;
	
	// Primero obtenemos una conexión usando tu clase ConexionSQL
	private Connection con = new ConexionSQL().conectar();

	// Ahora se la pasamos al constructor de la implementación
	private ClienteDao clienteDao = new ClientDaoImpl(con);
	
	@FXML
	 private void iniciarSesion() {
		String email = txt_Correo.getText();
		String password = txt_Password.getText();
		
		Client cliente = clienteDao.inicioDeSesion(email);
		
		if(cliente == null) {
			lbl_mensaje.setText("El correo no existe");
		}else {
			if(password.equals(cliente.getPassword())) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/CreateRoute.fxml"));
					Parent root = loader.load();
					
					Stage stage = (Stage) btn_Login.getScene().getWindow();
					
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
			        lbl_mensaje.setText("Error al cargar la siguiente ventana");
			        e.printStackTrace();
			    }

			}else {
				lbl_mensaje.setText("Contrasena Incorrecta");
			}
		}
		
	}

	@FXML
	private void abrirRegistro() {
	    System.out.println("Clic en abrir registro");
	    // Por ahora déjalo vacío para que no de error
	}

	@FXML
	private void registroEquipo() {
	    System.out.println("Clic en abrir equipo");
	}
	
}
