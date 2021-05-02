package model.VO;

public class ItemVO {
	private Long id;
	private String nome;
	private TipoItem tipoItem;
	private double quantidade;
	private double porcao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
	}
	
	public TipoItem getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPorcao() {
		return porcao;
	}
	public void setPorcao(double tamanhoPorcao) {
		this.porcao = tamanhoPorcao;
	}
	
	
}
