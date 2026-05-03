package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// 1. Cargamos el diseño desde la carpeta de vistas
			// Nota: El nombre del archivo debe terminar en .fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/loginView.fxml"));
			Parent root = loader.load();

			// 2. Creamos la escena (el contenido de la ventana)
			Scene scene = new Scene(root);

			// 3. Configuramos y mostramos el escenario (la ventana física)
			primaryStage.setTitle("Sistema de Rutas - Login 🔑");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			// Si la ruta está mal, aquí nos avisará el error
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
