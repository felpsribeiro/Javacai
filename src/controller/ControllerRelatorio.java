package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.BO.PedidoBO;
import model.VO.PedidoVO;
import view.Telas;

public class ControllerRelatorio {
	@FXML private DatePicker dataInicial;
	@FXML private DatePicker dataFinal;
	
	PedidoBO pBo = new PedidoBO();
	
	private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public void gerarRelatorio() {
		if ((dataInicial.getValue() == null) != (dataFinal.getValue() == null)) {
			Telas.mensagemInfo("Por favor, preencha o campo vazio do Filtro por data");
			return;
		}
		else {
			List<PedidoVO> pedidos;
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			if (dataInicial.getValue() != null && dataFinal.getValue() != null) {
				cal1.setTime(Date.from(Instant.from(dataInicial.getValue().atStartOfDay(ZoneId.systemDefault()))));
				cal2.setTime(Date.from(Instant.from(dataFinal.getValue().atStartOfDay(ZoneId.systemDefault()))));
				
				pedidos = pBo.buscarPorData(cal1, cal2);
			}
			else {
				pedidos = pBo.listar();
				cal1 = null;
				cal2 = null;
			}
			
			if (cal1 == null && cal2 == null)
				gerarRelatorio(pedidos);
			else
				gerarRelatorio(pedidos, cal1, cal2);
		}
	}
	
	public void gerarRelatorio(List<PedidoVO> pedidos, Calendar inicio, Calendar fim) {
		Document document = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
				
				document.open();
				Paragraph paragraph = new Paragraph();
				
				paragraph.add("Pedidos de: " + formatter.format(inicio.getTime()) + " até " + formatter.format(fim.getTime()) + "\n\n");		
				for(PedidoVO pedido : pedidos) {
					paragraph.add(formatPedido(pedido));
				}
				document.add(paragraph);
				
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Relatório gerado com sucesso");
				a.show();
				
			} catch (FileNotFoundException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(e.getMessage());
				a.show();
			} catch (DocumentException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Não foi possível gerar o relatório");
				a.show();
			} finally {
				document.close();
			}
		} 
	}
	
	public void gerarRelatorio(List<PedidoVO> pedidos) {
		Document document = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
				
				document.open();
				Paragraph paragraph = new Paragraph();
				
				paragraph.add("Todas os pedidos\n\n");		
				for(PedidoVO pedido : pedidos) {
					paragraph.add(formatPedido(pedido));
				}
				document.add(paragraph);
				
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Relatório gerado com sucesso");
				a.show();
				
			} catch (FileNotFoundException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(e.getMessage());
				a.show();
			} catch (DocumentException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Não foi possível gerar o relatório");
				a.show();
			} finally {
				document.close();
			}
		 }
	}
	
	private String formatPedido(PedidoVO pedido) {
		String str;
		
		str = "Id: " + pedido.getId()
				+ "\nCopo: " + pedido.getCopo()
				+ "\nAçaí: " + pedido.getAcai()
				+ "\nCreme: ";
		
		if(pedido.getCreme() == null || pedido.getCreme().toString().isEmpty())
			str += "Sem creme";
		else
			str += pedido.getCreme().toString().isEmpty();
		
		str += "\nCobertura";
		
		if(pedido.getCobertura() == null || pedido.getCobertura().toString().isEmpty())
			str += "Sem cobertura";
		else
			str += pedido.getCreme().toString().isEmpty();
		
		str += "\nRecheios: ";
		
		if(!pedido.getRecheios().isEmpty())
			str += "Sem recheios";
		else {
			for(int i = 0; i < pedido.getRecheios().size(); ++i) {
				str += pedido.getRecheios().get(i) + " ";
			}
		}
		
		str += "\nPreço: " + pedido.getPreco()
				+ "\nData do Pedido: " + formatter.format(pedido.getDataPedido().getTime());
		
		return str;
	}
	
	public void irVoltarInicial() {
		try {
			Telas.telaInicial();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}