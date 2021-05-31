package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Telas;

public class ControllerCadastrarPessoas {
	
	@FXML TextField nome;
	@FXML TextField telefone;
	@FXML TextField cpf;
	@FXML PasswordField senha;
	@FXML PasswordField repita;
	@FXML ChoiceBox tipo;
	
	public void cadastrar() {
		/*if() {
			
			
			
			Telas.mensagemInfo("Novo usuário criado:"
							+ "\nNome: " + nome.getText()
							+ "\nTelefone: " + telefone.getText()
							+ "\nCPF: " + cpf.getText()
							+ "\nTipo de Usuário: " + pegar o tipo de usuario);
		}
		else {
			Telas.mensagemErro("Não foi possivel cadastrar o novo usuário.");
		} */
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
	
	public void irRelatorio() {
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irConfiguracoesVisualizar() {
		try {
			Telas.ConfiguaracoesVisualizar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irConfiguracoesEditar() {
		try {
			Telas.ConfiguaracoesEditar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
