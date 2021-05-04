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
import model.BO.PedidoBO;
import model.VO.ItemVO;
import model.VO.PedidoVO;
import view.Telas;

public class ControllerHistorico implements Initializable{
	static ItemBO itemBo = new ItemBO();
	static PedidoBO pedidoBo = new PedidoBO();
	
	@FXML TextField textFieldNu;
	@FXML ChoiceBox<ItemVO> choiceboxCopo;
	@FXML TextField textFieldDataIn;
	@FXML TextField textFieldDataFi;
	@FXML TextField textFieldHoraIn;
	@FXML TextField textFieldHoraFi;
	
	@FXML TableView<PedidoVO> tabela;
	@FXML TableColumn<PedidoVO, Long> colunaId;
	@FXML TableColumn<PedidoVO, ItemVO> colunaCopo;
	@FXML TableColumn<PedidoVO, ItemVO> colunaCreme;
	@FXML TableColumn<PedidoVO, ItemVO> colunaAcai;
	@FXML TableColumn<PedidoVO, List<ItemVO>> colunaRecheios;
	@FXML TableColumn<PedidoVO, ItemVO> colunaCobertura;
	
	List<PedidoVO> pedidos;
	ObservableList<PedidoVO> obsPedidos;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunaId.setCellValueFactory(new PropertyValueFactory<PedidoVO, Long>("id"));
		colunaCopo.setCellValueFactory(new PropertyValueFactory<PedidoVO, ItemVO>("copo"));
		colunaCreme.setCellValueFactory(new PropertyValueFactory<PedidoVO, ItemVO>("creme"));
		colunaAcai.setCellValueFactory(new PropertyValueFactory<PedidoVO, ItemVO>("acai"));
		colunaRecheios.setCellValueFactory(new PropertyValueFactory<PedidoVO, List<ItemVO>>("recheios"));
		colunaCobertura.setCellValueFactory(new PropertyValueFactory<PedidoVO, ItemVO>("cobertura"));
		
		atualizarChoicebox();
		
		pedidos = pedidoBo.listar();
		
		atualizarTabela();
	}
	
	public void buscar() {
		boolean checkId = textFieldNu == null || textFieldNu.getText().trim().isEmpty();
		
		if(!checkId) {
			PedidoVO pedido = new PedidoVO();
			pedido.setId(Long.parseLong(textFieldNu.getText().trim()));
			List<PedidoVO> list = new ArrayList<PedidoVO>();
			list.add(pedidoBo.buscarPorId(pedido));
			pedidos = list;
			atualizarTabela();
			return;
		}
		
		if(choiceboxCopo.getSelectionModel().getSelectedItem() != null) {
			PedidoVO pedido = new PedidoVO();
			pedido.setCopo(choiceboxCopo.getSelectionModel().getSelectedItem());
			pedidos = pedidoBo.buscarPorCopo(pedido);
		}
	}
	
	public void atualizarChoicebox() {
		List<ItemVO> lista = itemBo.listarCopos();
		if(choiceboxCopo != null) {
			ObservableList<ItemVO> copos = FXCollections.observableArrayList(lista);
			choiceboxCopo.setItems(copos);
		}
	}
	
	public void atualizarTabela() {
		obsPedidos = FXCollections.observableArrayList(pedidos);
		tabela.setItems(obsPedidos);
	}
	
	public void limpar() {
		textFieldNu.clear();
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
	
	public void irInicial() {
		try {
			Telas.telaInicial();
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

	
}
