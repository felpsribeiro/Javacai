package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.BO.ItemBO;
import model.VO.ItemVO;
import model.VO.TipoItem;
import view.Telas;

public class ControllerCadastroEstoque implements Initializable {
	@FXML TextField textFieldNome;
	@FXML ChoiceBox choice;
	@FXML TextField textFieldUn;
	@FXML TextField textFieldQuan;
	@FXML TextField textFieldPor;
	private List<TipoItem> listaTipos;
	private ObservableList<String> listaStgTipos;
	ItemBO itBO = new ItemBO();
	ItemVO item = new ItemVO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizar();
	}
	
	private void atualizar() {
		if(choice != null) {
				
		
		}
		
	}

	public void cadastrar() {
		
		item.setNome(textFieldNome.getText());
		
		int index = choice.getSelectionModel().getSelectedIndex();
		item.setTipoItem(listaTipos.get(index));
		
		item.setUnidadeDeEntrada(textFieldUn.getText());
		item.setQuantidade(Double.parseDouble(textFieldQuan.getText()));
		item.setPorcao(Double.parseDouble(textFieldPor.getText()));
		
		try {
			itBO.cadastrar(item);
			Telas.mensagemInfo("O item foi cadastrado.");
		} catch (Exception e){
			Telas.mensagemErro("Não foi possível realizar o cadastro.");
		}
	}

	public void irEntrada() {
		try {
			Telas.telaEntrada();
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
