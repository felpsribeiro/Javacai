package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Telas;

public class ControllerEntrada {
	
	@FXML TextField textFieldId;
	@FXML TextField textFieldNome;
	@FXML Label	label1;
	@FXML Label	label2;
	@FXML Label	label3;
	@FXML Label	label4;
	@FXML Label	label5;
	
	public void pesquisar() {
		//pegar os textos e pesquisar	
	}
	
	public void cadastrar() {
		//
	}
	
	public void irCadastrar() {
		try {
			Telas.telaCadastroEstoque();
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
	
	public void irVendas() {
		try {
			Telas.telaVendas();
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
		
	public void irEstoque() {
		try {
			Telas.telaEstoque();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
