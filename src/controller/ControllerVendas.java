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
import model.BO.ItemBO;
import model.VO.ItemVO;
import model.VO.PedidoVO;
import view.Telas;

public class ControllerVendas implements Initializable {
	@FXML ChoiceBox choiceBoxCopo;
	@FXML ChoiceBox choiceBoxCreme;
	@FXML ChoiceBox choiceBoxAcai;
	@FXML ChoiceBox choiceBoxCobertura;
	@FXML ChoiceBox choiceBoxRe1;
	@FXML ChoiceBox choiceBoxRe2;
	@FXML ChoiceBox choiceBoxRe3;
	@FXML ChoiceBox choiceBoxRe4;
	@FXML ChoiceBox choiceBoxRe5;
	@FXML ChoiceBox choiceBoxRe6;
	
	private ItemBO itensBO = new ItemBO();
	private List<ItemVO> listaCopos;
	private ObservableList<String> listaStgCopos;
	private List<ItemVO> listaCreme;
	private ObservableList<String> listaStgCreme;
	private List<ItemVO> listaAcai;
	private ObservableList<String> listaStgAcai;
	private List<ItemVO> listaCobertura;
	private ObservableList<String> listaStgCobertura;
	private List<ItemVO> listaRecheio;
	private ObservableList<String> listaStgRecheio;
	
	static PedidoVO pedido = new PedidoVO();
	
	public void atualizarCopos() {
		if(choiceBoxCopo != null) {
			listaCopos = itensBO.listarCopos();
			List<String> stList = new ArrayList<String>();
			Iterator<ItemVO> iter = listaCopos.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us.getNome());
			}
			listaStgCopos = FXCollections.observableArrayList(stList);
			choiceBoxCopo.setItems(listaStgCopos);
		}
	}
	
	private void atualizarCremes() {
		if(choiceBoxCreme != null) {
			listaCreme = itensBO.listarCremes();
			List<String> stList = new ArrayList<String>();
			Iterator<ItemVO> iter = listaCreme.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us.getNome());
			}
			listaStgCreme = FXCollections.observableArrayList(stList);
			choiceBoxCreme.setItems(listaStgCreme);
		}
	}
	
	private void atualizarAcai() {
		if(choiceBoxAcai != null) {
			listaAcai = itensBO.listarAcais();
			List<String> stList = new ArrayList<String>();
			Iterator<ItemVO> iter = listaAcai.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us.getNome());
			}
			listaStgAcai = FXCollections.observableArrayList(stList);
			choiceBoxAcai.setItems(listaStgAcai);
		}
	}
	
	private void atualizarCobertura() {
		if(choiceBoxCobertura != null) {
			listaCobertura = itensBO.listarCoberturas();
			List<String> stList = new ArrayList<String>();
			Iterator<ItemVO> iter = listaCobertura.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us.getNome());
			}
			listaStgCobertura = FXCollections.observableArrayList(stList);
			choiceBoxCobertura.setItems(listaStgCobertura);
		}
	}
	
	private void atualizarRecheio() {
		if(choiceBoxRe1 != null) {
			listaRecheio = itensBO.listarRecheios();
			List<String> stList = new ArrayList<String>();
			Iterator<ItemVO> iter = listaRecheio.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us.getNome());
			}
			listaStgRecheio = FXCollections.observableArrayList(stList);
			choiceBoxRe1.setItems(listaStgRecheio);
			choiceBoxRe2.setItems(listaStgRecheio);
			choiceBoxRe3.setItems(listaStgRecheio);
			choiceBoxRe4.setItems(listaStgRecheio);
			choiceBoxRe5.setItems(listaStgRecheio);
			choiceBoxRe6.setItems(listaStgRecheio);
		}		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizarCopos();
		atualizarCremes();
		atualizarAcai();
		atualizarCobertura();
		atualizarRecheio();
	}
	
	public void irConfirmar() {
		
		try {
			int index;
			
			index = choiceBoxCopo.getSelectionModel().getSelectedIndex();
			pedido.setCopo(listaCopos.get(index));
			
			index = choiceBoxCreme.getSelectionModel().getSelectedIndex();
			pedido.setCreme(listaCreme.get(index));
			
			index = choiceBoxAcai.getSelectionModel().getSelectedIndex();
			pedido.setAcai(listaAcai.get(index));
			
			index = choiceBoxCobertura.getSelectionModel().getSelectedIndex();
			pedido.setCobertura(listaCobertura.get(index));
			
			List<ItemVO> listRecheios = new ArrayList<ItemVO>();
			
			index = choiceBoxRe1.getSelectionModel().getSelectedIndex();
			listRecheios.add(listaRecheio.get(index));
			index = choiceBoxRe2.getSelectionModel().getSelectedIndex();
			listRecheios.add(listaRecheio.get(index));
			index = choiceBoxRe3.getSelectionModel().getSelectedIndex();
			listRecheios.add(listaRecheio.get(index));
			if(false) { // DEFINIR VARIAVEL QUE VAI HABILITAR MAIS DE 3 RECHEIOS EM UNICO AÇAI
				index = choiceBoxRe4.getSelectionModel().getSelectedIndex();
				listRecheios.add(listaRecheio.get(index));
				index = choiceBoxRe5.getSelectionModel().getSelectedIndex();
				listRecheios.add(listaRecheio.get(index));
				index = choiceBoxRe6.getSelectionModel().getSelectedIndex();
				listRecheios.add(listaRecheio.get(index));
			}
			
			pedido.setRecheios(listRecheios);
			
			try {
				Telas.telaConfirmacao();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			Telas.mensagemErro("Preencha todos os campos antes de enviar a Nova Venda.");;
		}
	}
	
	public void irInicial() {
		try {
			Telas.telaInicial();
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
	
}
