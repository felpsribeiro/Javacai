package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.Telas;

public class ControllerHistorico {
	@FXML TextField textFieldNu;
	@FXML TextField textFieldCop;
	@FXML TextField textFieldDataIn;
	@FXML TextField textFieldDataFi;
	@FXML TextField textFieldHoraIn;
	@FXML TextField textFieldHoraFi;
	
	public void buscar() {
		//pegar os text dos textField e pesquisar
		//gerar a tabela.
	}
	
	public void limpar() {
		textFieldNu.clear();
		textFieldCop.clear();
		textFieldDataIn.clear();
		textFieldDataFi.clear();
		textFieldHoraIn.clear();
		textFieldHoraFi.clear();
	}
	
	public void irVendas() {
		try {
			Telas.telaVendas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
