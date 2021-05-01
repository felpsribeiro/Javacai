package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static void mensagemInfo(String m) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText(m);
		a.show();
	}
	
	public static void mensagemErro(String m) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(m);
		a.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Java�a�");
		primaryStage.show();
		telaInicial();
	}
	
	public static void telaInicial() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Inicial.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaVendas() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Vendas.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaEstoque() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Estoque.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
}