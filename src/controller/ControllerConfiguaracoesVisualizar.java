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
