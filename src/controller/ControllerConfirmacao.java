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
		if(ControllerVendas.pedido.getCreme() != null)
			label2.setText(ControllerVendas.pedido.getCreme().getNome());
		else 
			label2.setText("Sem creme");
		label3.setText(ControllerVendas.pedido.getAcai().getNome());
		if(ControllerVendas.pedido.getCobertura() != null)
			label4.setText(ControllerVendas.pedido.getCobertura().getNome());
		else 
			label4.setText("Sem cobertura");
		
		List<ItemVO> listRecheios = ControllerVendas.pedido.getRecheios();
		String StgRecheios = "";
		if(!listRecheios.isEmpty()) {
			for (int i = 0; i < listRecheios.size(); ++i) {
				ItemVO item = listRecheios.get(i);
				StgRecheios += item.getNome() + ", ";
				System.out.println(StgRecheios);
			}
		}
		if(StgRecheios.length() >= 2)
			StgRecheios = StgRecheios.substring(0, (StgRecheios.length()-2));
		else 
			StgRecheios = "Sem recheios";
		label5.setText(StgRecheios); 
	}
	
	public void irConfirmar() {
		try {
			peBO.cadastrar(ControllerVendas.pedido);
			itBO.retirarPedidoDoEstoque(ControllerVendas.pedido);
			Telas.mensagemInfo("Venda salva com sucesso.");
			
			try {
				Telas.telaVendas();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e){
			e.printStackTrace();
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
