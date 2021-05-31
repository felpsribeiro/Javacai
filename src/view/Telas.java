 package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.VO.UsuarioVO;

public class Telas extends Application {
	
	public static UsuarioVO usuarioAtivo;
		
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
	
	private static Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Javaçaí");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Login.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
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
	public static void telaHistorico() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/VendasHistorico.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaConfirmacao() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/VendasConfirmacao.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaEstoque() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/TelaEstoque.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaEntrada() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Entrada.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaRelatorio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Relatorio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroEstoque() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/EntradaCadastro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void ConfiguaracoesVisualizar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/ConfiguracoesVisualizar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void ConfiguaracoesEditar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/ConfiguracoesEditar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
}
