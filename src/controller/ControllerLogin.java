package controller;

import java.util.List;

import exception.ExceptionLogin;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.BO.UsuarioBO;
import model.VO.UsuarioVO;
import view.Telas;

public class ControllerLogin {
	@FXML TextField fieldCPF;
	@FXML TextField fieldSenha;
	
	public void login() {
		try {
			System.out.println("chegou 1");
			if (fieldCPF.getText().isEmpty() || fieldSenha.getText().isEmpty()) {
				throw new ExceptionLogin("Preencha todos os campos.");
			}
			
			if(!isDigit(fieldCPF.getText().trim()))
				throw new ExceptionLogin("CPF deve ser somente números.");
			
			UsuarioVO vo = new UsuarioVO();
			vo.setCpf(fieldCPF.getText());
			
			UsuarioBO bo = new UsuarioBO();
			
			List<UsuarioVO> usuarioList = bo.buscarPorCpf(vo);
			UsuarioVO usuario = null;
			if(usuarioList.size() > 0)
				usuario = usuarioList.get(0);
			//Telas.usuarioAtivo = usuario;
			
			if(usuario == null) {
				throw new ExceptionLogin("Login inexistente");
			}
			else {
				if (fieldSenha.getText().equals(usuario.getSenha())) {
					Telas.usuarioAtivo = usuario;
					Telas.telaInicial();
				}
				else throw new ExceptionLogin("Senha incorreta");
			}
			
		} catch (Exception e) {
			Telas.mensagemErro(e.getMessage());
		}
	}
	
	private boolean isDigit(String str) {
		boolean isValid = true;
		
		char[] charArray = str.toCharArray();
		
		for(int i = 0; i < str.length(); ++i) {
			if(!Character.isDigit(charArray[i]))
				isValid = false;
		}
		
		return isValid;
	}
	
}
