package controller;

import java.util.List;

import exception.ExceptionLogin;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.Telas;

public class ControllerLogin {
	@FXML TextField fieldCPF	;
	@FXML TextField fieldSenha;
	
	public void login() {
		try {
			if (fieldCPF.getText().isEmpty() || fieldSenha.getText().isEmpty()) {
				throw new ExceptionLogin("Preencha todos os campos.");
			}
			
		} catch (Exception e) {
			Telas.mensagemErro(e.getMessage());
		}
	}
	
	public void irCadastrar() {
		try {
			//Telas.telaCadastrar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
