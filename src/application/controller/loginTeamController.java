package application.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;

import Modelo.ConexionSQL;
import application.model.Client;
import application.model.ClientDaoImpl;
import application.model.ClienteDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class loginTeamController {
	@FXML
	private TextField txt_id;

	@FXML
	private javafx.scene.control.PasswordField txt_Password;

	@FXML
	private Button btn_login_Employee;

	@FXML
	private Hyperlink linkInicio;

	@FXML
	private Label lbl_mensaje;

	@FXML
	private void iniciarSesion() {
		String id = txt_id.getText();
		String password = txt_Password.getText();

		Connection con = new ConexionSQL().conectar();
		if (con == null) {
			lbl_mensaje.setText("Error: Sin conexión a la base de datos");
			return;
		}

		ClienteDao clienteDao = new ClientDaoImpl(con);
		Client cliente = clienteDao.inicioDeSesion(id);

		if (cliente == null) {
			lbl_mensaje.setText("El correo no existe");
		} else {
			if (password.equals(cliente.getPassword())) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/CreateRoute.fxml"));
					Parent root = loader.load();

					Stage stage = (Stage) btn_login_Employee.getScene().getWindow();

					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					lbl_mensaje.setText("Error al cargar la siguiente ventana");
					e.printStackTrace();
				}

			} else {
				lbl_mensaje.setText("Contrasena Incorrecta");
			}
		}
	}
	
	@FXML
	private void volveralinicio() {
		try {
			//Repetimos el proceso
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/loginView.fxml"));
			Parent root = loader.load();
			
			Stage stage = (Stage) linkInicio.getScene().getWindow();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			lbl_mensaje.setText("No se pudo cargar la ventana de equipo");
			e.printStackTrace();
		}
	}
}