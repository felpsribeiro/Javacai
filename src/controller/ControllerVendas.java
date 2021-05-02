package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import view.Telas;

public class ControllerVendas {
	@FXML ChoiceBox choiceBoxCopo;
	@FXML ChoiceBox choiceBoxCreme;
	@FXML ChoiceBox choiceBoxAcai;
	@FXML ChoiceBox choiceBoxCobertura;
	@FXML ChoiceBox choiceBoxRe1;
	@FXML ChoiceBox choiceBoxRe2;
	@FXML ChoiceBox choiceBoxRe3;
	@FXML ChoiceBox choiceBoxRe4;
	@FXML ChoiceBox choiceBoxRe5;
	@FXML ChoiceBox choiceBoxRe6;
	
	public void irConfirmar() {
		
		//pegar os dados das choiceBoxs
		
		try {
			Telas.telaConfirmacao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irInicial() {
		try {
			Telas.telaInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irHistorico() {
		try {
			Telas.telaHistorico();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irEntrada() {
		try {
			Telas.telaEntrada();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irEstoque() {
		try {
			Telas.telaEstoque();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
