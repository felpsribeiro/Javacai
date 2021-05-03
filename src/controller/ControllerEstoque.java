package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ItemBO;
import model.VO.ItemVO;
import model.VO.TipoItem;
import view.Telas;

public class ControllerEstoque implements Initializable{
	
	static ItemBO itemBo = new ItemBO();
	
	@FXML TextField textFieldId;
	@FXML TextField textFieldNome;                         
	@FXML ChoiceBox choiceBoxAcai;
	
	@FXML TableView<ItemVO> tabela;
	@FXML TableColumn<ItemVO, Long> colunaId;
	@FXML TableColumn<ItemVO, String> colunaNome;
	@FXML TableColumn<ItemVO, TipoItem> colunaTipo;
	@FXML TableColumn<ItemVO, Double> colunaQuantidade;
	@FXML TableColumn<ItemVO, Double> colunaPorcao;
	@FXML TableColumn<ItemVO, String> colunaUnidade;
	
	private List<ItemVO> itens;
	private ObservableList<ItemVO> obsItens;
	
	private TipoItem[] listaTipos;
	private ObservableList<TipoItem> strListaTipos;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunaId.setCellValueFactory(new PropertyValueFactory<ItemVO, Long>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("nome"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<ItemVO, TipoItem>("tipoItem"));
		colunaQuantidade.setCellValueFactory(new PropertyValueFactory<ItemVO, Double>("quantidade"));
		colunaPorcao.setCellValueFactory(new PropertyValueFactory<ItemVO, Double>("porcao"));
		colunaUnidade.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("unidadeDeEntrada"));
		
		atualizarChoicebox();
		
		itens = itemBo.listar();
		atualizarTabela();
	}
	
	public void atualizarChoicebox() {
		if(choiceBoxAcai != null) {
			List<TipoItem> stList = new ArrayList<TipoItem>();
			listaTipos = TipoItem.values();
			for(int i = 0; i < listaTipos.length; ++i) {
				stList.add(listaTipos[i]);
			}
			strListaTipos = FXCollections.observableArrayList(stList);
			
			choiceBoxAcai.setItems(strListaTipos);
		}
	}
	
	public void atualizarTabela() {
		obsItens = FXCollections.observableArrayList(itens);
		tabela.setItems(obsItens);
	}
	
	public void filtrar() {
		boolean checkId = textFieldId == null || textFieldId.getText().trim().isEmpty();
		boolean checkNome = textFieldId == null || textFieldId.getText().trim().isEmpty();
		
		
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

	
}
