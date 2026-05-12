package application.controller;

import java.io.File;
import java.sql.Connection;

import application.model.ConexionSQL;
import application.model.Client;
import application.model.ClienteDao;
import application.model.ClientDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

public class ProfileController {

	@FXML
	private Label lbl_email;
	@FXML
	private Label lbl_name;
	@FXML
	private Label lbl_telephone;
	@FXML
	private Label lbl_id;
	@FXML
	private Label lbl_addres;
	@FXML
	private ComboBox<String> cbx_role;

	@FXML
	private Circle circle_profile;
	@FXML
	private ComboBox<String> ComboBox_opciones;
	@FXML
	private TextField txt_nuevosDatos;
	@FXML
	private Button btn_guardarCambios;
	@FXML
	private Button btn_editar_cuenta;
	@FXML
	private VBox vbox_edicion;

	@FXML
	public void initialize() {
		try {
			// Configurar ComboBox
			ComboBox_opciones.getItems().addAll("Nombre", "Email", "Numero de telefono", "Domicilio");

			// Ocultar sección de edición por defecto
			vbox_edicion.setVisible(false);

			// Configurar imagen del círculo
			Image defaultImage = new Image("file:Resource/MingcuteProfileFill.png");
			circle_profile.setFill(new ImagePattern(defaultImage));
			Tooltip.install(circle_profile, new Tooltip("click para cambiar imagen"));

			// Evento para cambiar la imagen
			circle_profile.setOnMouseClicked(event -> cambiar_imagen());

			// 1. Creamos la conexión
			Connection con = new ConexionSQL().conectar();

			if (con != null) {
				ClienteDao clientedao = new ClientDaoImpl(con);
				Client clienteLogueado = clientedao.buscarPorId(1);

				if (clienteLogueado != null) {
					lbl_name.setText(clienteLogueado.getName());
					lbl_email.setText(clienteLogueado.getEmail());
					lbl_telephone.setText(clienteLogueado.getPhone());
					lbl_addres.setText(clienteLogueado.getAddress());
				}
			} else {
				System.out.println("Error: La conexión es nula");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al cargar los datos del perfil");
		}
	}

	@FXML
	public void editar_cuenta(ActionEvent event) {
		// Mostrar u ocultar el VBox con las opciones de edición
		vbox_edicion.setVisible(!vbox_edicion.isVisible());
	}

	@FXML
	public void guardar_cambios(ActionEvent event) {
		String opcion = ComboBox_opciones.getValue();
		String nuevoDato = txt_nuevosDatos.getText();

		if (opcion == null || nuevoDato == null || nuevoDato.trim().isEmpty()) {
			return; // No hacer nada si no hay opción o datos
		}

		// Actualizamos los labels en la interfaz
		switch (opcion) {
			case "Nombre":
				lbl_name.setText(nuevoDato);
				break;
			case "Email":
				lbl_email.setText(nuevoDato);
				break;
			case "Numero de telefono":
				lbl_telephone.setText(nuevoDato);
				break;
			case "Domicilio":
				lbl_addres.setText(nuevoDato);
				break;
		}

		// TODO: Aquí puedes agregar el código para guardar en la BD usando ClienteDao

		// Limpiar campos y ocultar la sección
		txt_nuevosDatos.clear();
		vbox_edicion.setVisible(false);
	}

	private void cambiar_imagen() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Seleccionar Imagen de Perfil");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));

		File file = fileChooser.showOpenDialog(circle_profile.getScene().getWindow());
		if (file != null) {
			circle_profile.setFill(new ImagePattern(new Image(file.toURI().toString())));
		}
	}

	@FXML
	public void comboBox_opciones(ActionEvent event) {
		// Método invocado cuando se selecciona una opción en el ComboBox si es
		// necesario
	}

	@FXML
	public void txt_nuevo_valor(ActionEvent event) {
		// Método invocado al dar enter en el TextField si es necesario
	}
}
