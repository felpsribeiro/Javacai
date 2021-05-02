package model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoVO {
	private Long id;
	private ItemVO copo;
	private ItemVO creme;
	private ItemVO acai;
	private List<ItemVO> recheios;
	private ItemVO cobertura;
	private double preco;
	private Calendar dataPedido;
	
	public PedidoVO(){
		recheios = new ArrayList<ItemVO>(3);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ItemVO getCopo() {
		return copo;
	}
	public void setCopo(ItemVO copo) {
		if(copo != null)
			this.copo = copo;
		else
			System.out.println("Copo inv�lido");
	}
	
	public ItemVO getCreme() {
		return creme;
	}
	public void setCreme(ItemVO creme) {
		if(creme != null)
			this.creme = creme;
		else
			System.out.println("Creme inv�lido");
	}
	
	public ItemVO getAcai() {
		return acai;
	}
	public void setAcai(ItemVO acai) {
		if(acai != null)
			this.acai = acai;
		else
			System.out.println("A�a� inv�lido");
	}
	
	public List<ItemVO> getRecheios() {
		return recheios;
	}
	public void setRecheios(List<ItemVO> recheios) {
		if(recheios != null)
			this.recheios = recheios;
		else
			System.out.println("Recheios inv�lidos");
	}
	
	public ItemVO getCobertura() {
		return cobertura;
	}
	public void setCobertura(ItemVO cobertura) {
		if(cobertura != null)
			this.cobertura = cobertura;
		else
			System.out.println("Cobertura inv�lido");
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		if(dataPedido != null)
			this.dataPedido = dataPedido;
	}
}
