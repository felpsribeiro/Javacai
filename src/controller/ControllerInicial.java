package controller;

import exception.ExceptionMensagem;
import model.VO.TipoUsuario;
import view.Telas;

public class ControllerInicial {
	
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
	
	public void irEntrada() {
		try {
			Telas.telaEntrada();
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
			if(Telas.usuarioAtivo.getTipoUsuario() == TipoUsuario.Funcionario) {
				throw new ExceptionMensagem("Você não tem acesso para Cadastro Pessoas");
			}
			Telas.telaCadastroPessoas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irConfiguracoes() {
		try {
			Telas.ConfiguaracoesVisualizar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {
			Telas.usuarioAtivo = null;
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
