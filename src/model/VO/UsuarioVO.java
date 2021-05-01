package model.VO;

public class UsuarioVO extends PessoaVO {
	private String cpf;
	private String senha;
	private TipoUsuario tipoUsuario;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf != null && !cpf.isEmpty()) {
			String cpfAux = new String("");
			for(int i = 0; i < cpf.length(); ++i) {
				if(Character.isDigit(cpf.charAt(i)))
					cpfAux += cpf.charAt(i);
			}
			if (!cpfAux.equals("00000000000") && !cpfAux.equals("11111111111") &&
				!cpfAux.equals("22222222222") && !cpfAux.equals("33333333333") &&
				!cpfAux.equals("44444444444") && !cpfAux.equals("55555555555") &&
				!cpfAux.equals("66666666666") && !cpfAux.equals("77777777777") &&
				!cpfAux.equals("88888888888") && !cpfAux.equals("99999999999") && 
				(cpfAux.length() == 11)) {
					int ver1, ver2;
					ver1 = Integer.parseInt("" + cpfAux.charAt(9));
					ver2 = Integer.parseInt("" + cpfAux.charAt(10));
					
					int sm = 0;
					int resto = 0;
					int peso = 10;
					
					for(int i = 0; i < 9; ++i) {
						int num = Integer.parseInt("" + cpfAux.charAt(i));
						
						sm += num * peso;
						--peso;
					}
					resto = 11 - (sm % 11);
					if(resto == 10 || resto == 11)
						resto = 0;
					
					if(resto == ver1) {
						sm = 0;
						peso = 11;
						
						for(int i = 0; i < 10; ++i) {
							int num = Integer.parseInt("" + cpfAux.charAt(i));
							
							sm += num * peso;
							--peso;
						}
						resto = 11 - (sm % 11);
						if(resto == 10 || resto == 11)
							resto = 0;
						
						if(resto == ver2) {
							this.cpf = cpfAux;
							return;
						}
					}
					System.out.println("CPF invalido");
			}
		}
		System.out.println("CPF invalido");
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha != null && !senha.isEmpty()) {
			this.senha = senha;
		} else {
			System.out.println("Senha inválida");
		}
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
