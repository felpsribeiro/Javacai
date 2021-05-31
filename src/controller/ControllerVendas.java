package controller;

import java.net.URL;
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
import util.MyArrayList;
import view.Telas;

public class ControllerVendas implements Initializable {
	@FXML ChoiceBox<ItemVO> choiceBoxCopo;
	@FXML ChoiceBox<ItemVO> choiceBoxCreme;
	@FXML ChoiceBox<ItemVO> choiceBoxAcai;
	@FXML ChoiceBox<ItemVO> choiceBoxCobertura;
	@FXML ChoiceBox<ItemVO> choiceBoxRe1;
	@FXML ChoiceBox<ItemVO> choiceBoxRe2;
	@FXML ChoiceBox<ItemVO> choiceBoxRe3;
	@FXML ChoiceBox<ItemVO> choiceBoxRe4;
	@FXML ChoiceBox<ItemVO> choiceBoxRe5;
	@FXML ChoiceBox<ItemVO> choiceBoxRe6;
	
	private ItemBO itensBO = new ItemBO();
	private List<ItemVO> listaCopos;
	private ObservableList<ItemVO> listaStgCopos;
	private List<ItemVO> listaCreme;
	private ObservableList<ItemVO> listaStgCreme;
	private List<ItemVO> listaAcai;
	private ObservableList<ItemVO> listaStgAcai;
	private List<ItemVO> listaCobertura;
	private ObservableList<ItemVO> listaStgCobertura;
	private List<ItemVO> listaRecheio;
	private ObservableList<ItemVO> listaStgRecheio;
	
	static PedidoVO pedido = new PedidoVO();
	
	public void atualizarCopos() {
		if(choiceBoxCopo != null) {
			listaCopos = itensBO.listarCopos();
			List<ItemVO> stList = new MyArrayList<ItemVO>();
			Iterator<ItemVO> iter = listaCopos.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us);
			}
			listaStgCopos = FXCollections.observableArrayList(stList);
			choiceBoxCopo.setItems(listaStgCopos);
		}
	}
	
	private void atualizarCremes() {
		if(choiceBoxCreme != null) {
			listaCreme = itensBO.listarCremes();
			List<ItemVO> stList = new MyArrayList<ItemVO>();
			Iterator<ItemVO> iter = listaCreme.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us);
			}
			listaStgCreme = FXCollections.observableArrayList(stList);
			choiceBoxCreme.setItems(listaStgCreme);
		}
	}
	
	private void atualizarAcai() {
		if(choiceBoxAcai != null) {
			listaAcai = itensBO.listarAcais();
			List<ItemVO> stList = new MyArrayList<ItemVO>();
			Iterator<ItemVO> iter = listaAcai.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us);
			}
			listaStgAcai = FXCollections.observableArrayList(stList);
			choiceBoxAcai.setItems(listaStgAcai);
		}
	}
	
	private void atualizarCobertura() {
		if(choiceBoxCobertura != null) {
			listaCobertura = itensBO.listarCoberturas();
			List<ItemVO> stList = new MyArrayList<ItemVO>();
			Iterator<ItemVO> iter = listaCobertura.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us);
			}
			listaStgCobertura = FXCollections.observableArrayList(stList);
			choiceBoxCobertura.setItems(listaStgCobertura);
		}
	}
	
	private void atualizarRecheio() {
		if(choiceBoxRe1 != null) {
			listaRecheio = itensBO.listarRecheios();
			List<ItemVO> stList = new MyArrayList<ItemVO>();
			Iterator<ItemVO> iter = listaRecheio.iterator();
			while(iter.hasNext()) {
				ItemVO us = iter.next();
				stList.add(us);
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
			if(choiceBoxCopo.getValue() == null || choiceBoxAcai.getValue() == null)
				throw new Exception("Preencha todos os campos obrigatórios(Copo e Açaí)");
			
			pedido.setCopo(choiceBoxCopo.getValue());
			
			pedido.setCreme(choiceBoxCreme.getValue());
			
			pedido.setAcai(choiceBoxAcai.getValue());
			
			pedido.setCobertura(choiceBoxCobertura.getValue());
			
			List<ItemVO> listRecheios = new MyArrayList<ItemVO>();
			
			if(choiceBoxRe1 != null && choiceBoxRe1.getValue() != null)
				listRecheios.add(choiceBoxRe1.getValue());
			
			if(choiceBoxRe1 != null && choiceBoxRe1.getValue() != null)
				listRecheios.add(choiceBoxRe2.getValue());
			
			if(choiceBoxRe1 != null && choiceBoxRe1.getValue() != null)
				listRecheios.add(choiceBoxRe3.getValue());
			
			pedido.setRecheios(listRecheios);
			
			try {
				Telas.telaConfirmacao();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			Telas.mensagemErro(e.toString());
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
