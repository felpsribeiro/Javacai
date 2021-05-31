package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.VO.ItemVO;
import model.VO.PedidoVO;
import model.VO.TipoUsuario;
import view.Telas;

public class ControllerConfiguaracoesVisualizar {
	@FXML TableView<PedidoVO> tabela;
	@FXML TableColumn<PedidoVO, Long> colunaId;
	@FXML TableColumn<PedidoVO, String> colunaNome;
	@FXML TableColumn<PedidoVO, String> colunaCPF;
	@FXML TableColumn<PedidoVO, String> colunaTelefone;
	@FXML TableColumn<PedidoVO, TipoUsuario> colunaTipo;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		visualizar();
	}
	
	
	private void visualizar() {
		//exibir dados na tabela
		
	}


	public void irEditar() {
		try {
			//Telas.telaConfiguaracoesInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
