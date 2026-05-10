package application.controller;

import javafx.scene.control.Label;
import java.sql.Connection;

import application.model.ConexionSQL;
import application.model.Client;
import application.model.ClientDaoImpl;
import application.model.ClienteDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class CreateUserController {

    @FXML
    private TextField txt_Name;

    @FXML
    private ChoiceBox<Integer> choiceBox_Age;

    @FXML
    public void initialize() {
        for (int i = 18; i <= 60; i++) {
            choiceBox_Age.getItems().add(i);
        }
    }

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
    private Label lbl_text;

    @FXML
    private void CrearUsuario() {
        try {
            // 1. Capturar datos
            String name = txt_Name.getText();
            Integer ageValue = choiceBox_Age.getValue();
            int age = (ageValue != null) ? ageValue : 18; // Valor por defecto 18 si no se selecciona nada
            String addres = txt_Addres.getText();
            String email = txt_email.getText();
            int cp = Integer.parseInt(txt_CP.getText());
            String telephone = txt_Telephone.getText();
            String password = txt_Password.getText();

            // 2. Conexión
            Connection con = new ConexionSQL().conectar();
            if (con == null) {
                return;
            }

            // 3. Crear objeto y guardar
            Client cliente = new Client(name, age, 0, cp, email, telephone, password, addres);
            ClienteDao clientedao = new ClientDaoImpl(con);

            clientedao.guardarCliente(cliente);

            // 4. Avisar al usuario
            lbl_text.setText("¡Registro exitoso!");

            // Regresar al Login después de registrarse
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/loginView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) txt_Name.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            lbl_text.setText("Ha ocurrido un error");
            e.printStackTrace();
        }
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
