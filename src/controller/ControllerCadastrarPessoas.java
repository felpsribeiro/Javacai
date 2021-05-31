package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.UsuarioBO;
import model.VO.TipoItem;
import model.VO.TipoUsuario;
import model.VO.UsuarioVO;
import util.MyArrayList;
import view.Telas;

public class ControllerCadastrarPessoas implements Initializable{
	
	@FXML TextField nome;
	@FXML TextField telefone;
	@FXML TextField cpf;
	@FXML PasswordField senha;
	@FXML PasswordField repita;
	@FXML ChoiceBox<TipoUsuario> tipo;
	
	private TipoUsuario[] tipos;
	private ObservableList<TipoUsuario> obsList;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		atualizarChoicebox();
	}
	
	public void cadastrar() {
		UsuarioVO usuario = new UsuarioVO();
		
		try {
			if(telefone.getText() != null && !isDigit(telefone.getText()))
				throw new Exception("Telefone deve conter somente números.");
			
			if(nome.getText() == null || telefone.getText() == null || cpf.getText() == null || senha.getText() == null || repita.getText() == null || tipo.getValue() == null)
				throw new Exception("Preencha todos os campos.");
			
			if(!senha.getText().equals(repita.getText()))
				throw new Exception("Senhas incompatíveis.");
			
			usuario.setNome(nome.getText().trim());
			usuario.setTelefone(telefone.getText().trim());
			usuario.setCpf(cpf.getText().trim());
			usuario.setSenha(senha.getText());
			usuario.setTipoUsuario(tipo.getValue());
			
			UsuarioBO uBo = new UsuarioBO();
			uBo.cadastrar(usuario);
			
		} catch (Exception e) {
			//e.printStackTrace();
			Telas.mensagemErro(e.toString());
		}
		
		irInicial();
	}
	
	public void atualizarChoicebox() {
		if(tipo != null) {
			List<TipoUsuario> stList = new MyArrayList<TipoUsuario>();
			tipos = TipoUsuario.values();
			for(int i = 0; i < tipos.length; ++i) {
				stList.add(tipos[i]);
			}
			obsList = FXCollections.observableArrayList(stList);
			
			tipo.setItems(obsList);
		}
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
