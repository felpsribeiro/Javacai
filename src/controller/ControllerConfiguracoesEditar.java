package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Telas;

public class ControllerConfiguracoesEditar {
	
	@FXML TextField nome;
	@FXML TextField telefone;
	@FXML PasswordField antiga;
	@FXML PasswordField nova;
	@FXML PasswordField repita;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		//exibir o nome no nome.prompText
		//exibir o telefone no telefone.prompText
	}
	
	public void salvar() {
		//salvar as alterações nome e telefone
		//verificar se nova senha e repita a senha são igauis
		//verificar se a senha velha está correta
		//salvar a nova senha
		
		irConfiguracoesVisualizar();
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
	
	public void irCadastro() {
		try {
			Telas.telaCadastroPessoas();
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
}
