package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.UsuarioBO;
import view.Telas;

public class ControllerConfiguracoesEditar implements Initializable{
	
	@FXML TextField nome;
	@FXML TextField telefone;
	@FXML PasswordField antiga;
	@FXML PasswordField nova;
	@FXML PasswordField repita;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		nome.setText(Telas.usuarioAtivo.getNome());
		telefone.setText(Telas.usuarioAtivo.getTelefone());
	}
	
	public void salvar() {
		try {
			if(!isDigit(telefone.getText().trim()))
				throw new Exception("Telefone deve ter somente números.");
			
			if(!antiga.getText().equals(Telas.usuarioAtivo.getSenha()))
				throw new Exception("Senha antiga incorreta.");
			
			if(nova.getText() != null && repita.getText() != null && !nova.getText().equals(repita.getText()))
				throw new Exception("Senhas novas não compatíveis.");
			
			if(nova.getText() == null || repita.getText() == null || nova.getText().isEmpty() || repita.getText().isEmpty())
				throw new Exception("Repita senha nova");
			
			Telas.usuarioAtivo.setNome(nome.getText().trim());
			Telas.usuarioAtivo.setTelefone(telefone.getText().trim());
			if(nova.getText() != null)
				Telas.usuarioAtivo.setSenha(nova.getText());
			
			UsuarioBO uBo = new UsuarioBO();
			uBo.atualizar(Telas.usuarioAtivo);
			
		} catch(Exception e) {
			Telas.mensagemErro(e.toString());
		}
		//verificar se nova senha e repita a senha são igauis
		//verificar se a senha velha está correta
		//salvar a nova senha
		
		irConfiguracoesVisualizar();
	}
	
	private boolean isDigit(String str) {
		char[] charArray = str.toCharArray();
		
		for(int i = 0; i < str.length(); ++i) {
			if(!Character.isDigit(charArray[i]))
				return false;
		}
		
		return true;
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
