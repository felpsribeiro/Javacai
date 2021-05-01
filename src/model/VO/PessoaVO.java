package model.VO;

public class PessoaVO {
	private Long id;
	private String nome;
	private String telefone;
	
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
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.isEmpty()) {
			this.telefone = telefone;
		} else {
			System.out.println("Telefone inválido");
		}
	}
}
