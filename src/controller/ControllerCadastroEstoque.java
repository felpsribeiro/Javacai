package controller;

import java.net.URL;
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
import util.MyArrayList;
import view.Telas;

public class ControllerCadastroEstoque implements Initializable {
	@FXML TextField textFieldNome;
	@FXML ChoiceBox choice;
	@FXML TextField textFieldUn;
	@FXML TextField textFieldQuan;
	@FXML TextField textFieldPor;
	private TipoItem[] listaTipos;
	private ObservableList<String> listaStgTipos;
	ItemBO itBO = new ItemBO();
	ItemVO item = new ItemVO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizar();
	}
	
	private void atualizar() {
		if(choice != null) {
			List<String> stList = new MyArrayList<String>();
			listaTipos = TipoItem.values();
			for(int i = 0; i < listaTipos.length; ++i) {
				stList.add(listaTipos[i].toString());
			}
			listaStgTipos = FXCollections.observableArrayList(stList);
			
			choice.setItems(listaStgTipos);
		}
		
	}

	public void cadastrar() {
		
		item.setNome(textFieldNome.getText());
		
		int index = choice.getSelectionModel().getSelectedIndex();
		item.setTipoItem(listaTipos[index]);
		
		item.setUnidadeDeEntrada(textFieldUn.getText());
		item.setQuantidade(Double.parseDouble(textFieldQuan.getText()));
		item.setPorcao(Double.parseDouble(textFieldPor.getText()));
		
		try {
			itBO.cadastrar(item);
			textFieldNome.setText("");
			atualizar();
			textFieldUn.setText("");
			textFieldQuan.setText("");
			textFieldPor.setText("");
			Telas.mensagemInfo("O item foi cadastrado.");
		} catch (Exception e){
			Telas.mensagemErro("N?o foi poss?vel realizar o cadastro.");
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
