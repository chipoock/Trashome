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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import application.model.ConexionSQL;
import application.model.Client;

public class LoginController {

	@FXML
	private TextField txt_Correo;

	@FXML
	private javafx.scene.control.PasswordField txt_Password;

	@FXML
	private Button btn_Login;

	@FXML
	private Label lbl_mensaje;

	@FXML
	private Hyperlink linkRegistro;

	@FXML
	private Hyperlink linkEquipo;

	@FXML
	private void iniciarSesion() {
		String email = txt_Correo.getText();
		String password = txt_Password.getText();

		Connection con = new ConexionSQL().conectar();
		if (con == null) {
			lbl_mensaje.setText("Error: Sin conexión a la base de datos");
			return;
		}

		ClienteDao clienteDao = new ClientDaoImpl(con);
		Client cliente = clienteDao.inicioDeSesion(email);

		if (cliente == null) {
			lbl_mensaje.setText("El correo no existe");
		} else {
			if (password.equals(cliente.getPassword())) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/EscenaPrincipal.fxml"));
					Parent root = loader.load();

					Stage stage = (Stage) btn_Login.getScene().getWindow();

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
	private void abrirRegistro() {
		try {
			// Cargamos el Archivo de la nueva ventana
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/CreateUser.fxml"));
			Parent root = loader.load();

			// Obtenemos el stage
			Stage stage = (Stage) linkRegistro.getScene().getWindow();

			// Creamos la nueva escena
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			lbl_mensaje.setText("No se pudo cargar la ventana de registro");
			e.printStackTrace();
		}
	}

	@FXML
	private void registroEquipo() {
		try {
			// Repetimos el proceso
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/loginTeamView.fxml"));
			Parent root = loader.load();

			Stage stage = (Stage) linkEquipo.getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			lbl_mensaje.setText("No se pudo cargar la ventana de equipo");
			e.printStackTrace();
		}
	}

}
