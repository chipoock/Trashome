package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class CreateUserController {

    @FXML
    private TextField txt_Name;

    @FXML
    private TextField txt_Age;

    @FXML
    private TextField txt_Addres;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_CP;

    @FXML
    private TextField txt_Telephone;

    @FXML
    private PasswordField txt_Password;

    @FXML
    private Button btn_Login;
    
    @FXML
    private Hyperlink hyperlink_volveralinicio;

    @FXML
    private void iniciarSesion() {
        System.out.println("Clic en crear usuario...");
        // Aquí puedes agregar la lógica para guardar el usuario usando ClienteDao
    }
    
    @FXML
    private void volveralinicio() {
		try {
			// Repetimos el proceso
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/loginView.fxml"));
			Parent root = loader.load();

			Stage stage = (Stage) hyperlink_volveralinicio.getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

