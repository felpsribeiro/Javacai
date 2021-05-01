package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import view.Telas;

public class ControllerConfirmacao {
	@FXML Label label1;
	@FXML Label label2;
	@FXML Label label3;
	@FXML Label label4;
	@FXML Label label5;
	
	//mostrar os text dos label
	
	public void irConfirmar() {
		//salvar no BD o pedido
		//se a venda for ok
		Telas.mensagemInfo("Venda salva");
		
		//se não
		 //mensagemErro("Não foi possivel salvar a venda");
		
		try {
			Telas.telaVendas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void irVendas() {
		try {
			Telas.telaVendas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
