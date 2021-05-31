package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.BO.ItemBO;
import model.VO.ItemVO;
import view.Telas;

public class ControllerEntrada {
	
	@FXML TextField textFieldId;
	@FXML TextField textFieldNome;
	@FXML TextField textFieldEnt;
	@FXML Label	label1;
	@FXML Label	label2;
	@FXML Label	label3;
	@FXML Label	label4;
	@FXML Label	id;
	@FXML Label	nome;
	@FXML Label	un;
	@FXML Label	atual;
	@FXML Label quant;
	@FXML ImageView buttonCadastrar;
	ItemVO item = new ItemVO();
	ItemBO itBO = new ItemBO();
	
	public void pesquisar() {
		visivel(false);
		if(textFieldId.getText() != null && !textFieldId.getText().isEmpty()) {
			try {
				item.setId(Long.valueOf(textFieldId.getText()));
				item = itBO.buscarPorId(item);
				if(item.getNome() != null) {
					exibir(item);
				}
				else {
					Telas.mensagemErro("Sua pesquisa não retornou resultado.");
				}
			} catch (NumberFormatException e) {
				Telas.mensagemErro("Valor inválido para ID, tente usar somente numeros.");
			}
		} 
			
		else if(textFieldNome.getText() != null && !textFieldNome.getText().isEmpty()){
			item.setNome(textFieldNome.getText());
			int aux = 0;
			for(ItemVO listaNomes : itBO.buscarPorNome(item)) {
				item = listaNomes;
				aux += 1;
			}
			if(aux == 0) {
				Telas.mensagemErro("Sua pesquisa não retornou resultado.");
			} 
			else if (aux == 1) {
				exibir(item);
			}
			else {
				Telas.mensagemErro("Sua pesquisa retornou mais de um resultado, por favor, seja mais específico.");
			}
		} 
		else {
			Telas.mensagemErro("Insira algum valor nos campos ID ou Nome.");
		}
	}

	public void exibir(ItemVO item) {
		visivel(true);
		
		label1.setText(item.getId().toString());
		label2.setText(item.getNome());
		label3.setText(item.getUnidadeDeEntrada());
		label4.setText(String.valueOf(item.getQuantidade()));
	}

	private void visivel(boolean b) {
		id.setVisible(b);
		nome.setVisible(b);
		un.setVisible(b);
		atual.setVisible(b);
		label1.setVisible(b);
		label2.setVisible(b);
		label3.setVisible(b);
		label4.setVisible(b);
		quant.setVisible(b);
		textFieldEnt.setVisible(b);
		buttonCadastrar.setVisible(b);
	}

	public void cadastrar() {
		if(textFieldEnt.getText().matches("^[0-9]*[.]{0,1}[0-9]*$")) {
			item.setQuantidade(Double.parseDouble(textFieldEnt.getText().replaceAll(",", ".")));
			itBO.adicionarItem(item);
			exibir(item);
			Telas.mensagemInfo("Entrada realizada.");
		}
		else {
			Telas.mensagemErro("Digite números.");
		}
	}
	
	public void irCadastrar() {
		try {
			Telas.telaCadastroEstoque();
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
