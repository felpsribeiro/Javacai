package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.BO.ItemBO;
import model.BO.PedidoBO;
import model.VO.ItemVO;
import model.VO.PedidoVO;
import view.Telas;

public class ControllerConfirmacao implements Initializable {
	@FXML Label label1;
	@FXML Label label2;
	@FXML Label label3;
	@FXML Label label4;
	@FXML Label label5;
	
	PedidoBO peBO = new PedidoBO();
	ItemBO itBO = new ItemBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		label1.setText(ControllerVendas.pedido.getCopo().getNome());
		label2.setText(ControllerVendas.pedido.getCreme().getNome());
		label3.setText(ControllerVendas.pedido.getAcai().getNome());
		label4.setText(ControllerVendas.pedido.getCobertura().getNome());
		
		List<ItemVO> listRecheios = ControllerVendas.pedido.getRecheios();
		String StgRecheios = "";
		for (ItemVO item : listRecheios) {
			StgRecheios += item.getNome() + ", ";
			System.out.println(StgRecheios);
		}
		StgRecheios = StgRecheios.substring(0, (StgRecheios.length()-2));
		label5.setText(StgRecheios); 
	}
	
	public void irConfirmar() {
		try {
			peBO.cadastrar(ControllerVendas.pedido);
			itBO.retirarDoEstoque(ControllerVendas.pedido);
			Telas.mensagemInfo("Venda salva com sucesso.");
			
			try {
				Telas.telaVendas();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e){
			Telas.mensagemErro("Não foi possível realizar a venda.");
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
}
