package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.VO.UsuarioVO;
import util.MyArrayList;
import model.VO.TipoUsuario;
import view.Telas;

public class ControllerConfiguaracoesVisualizar implements Initializable{
	@FXML TableView<UsuarioVO> tabela;
	@FXML TableColumn<UsuarioVO, Long> colunaId;
	@FXML TableColumn<UsuarioVO, String> colunaNome;
	@FXML TableColumn<UsuarioVO, String> colunaCPF;
	@FXML TableColumn<UsuarioVO, String> colunaTelefone;
	@FXML TableColumn<UsuarioVO, TipoUsuario> colunaTipo;
	
	List<UsuarioVO> usuarioL;
	ObservableList<UsuarioVO> usuarioOL;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunaId.setCellValueFactory(new PropertyValueFactory<UsuarioVO, Long>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<UsuarioVO, String>("nome"));
		colunaCPF.setCellValueFactory(new PropertyValueFactory<UsuarioVO, String>("cpf"));
		colunaTelefone.setCellValueFactory(new PropertyValueFactory<UsuarioVO, String>("telefone"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<UsuarioVO, TipoUsuario>("tipoUsuario"));
		
		usuarioL = new MyArrayList<UsuarioVO>();
		usuarioL.add(Telas.usuarioAtivo);
		
		visualizar();
	}
	
	
	private void visualizar() {
		usuarioOL = FXCollections.observableArrayList(usuarioL);
		tabela.setItems(usuarioOL);
	}


	public void irEditar() {
		try {
			//Telas.telaConfiguaracoesInicial();
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
	
	public void irConfiguracoesEditar() {
		try {
			Telas.ConfiguaracoesEditar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
