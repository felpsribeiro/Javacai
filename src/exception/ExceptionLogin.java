package exception;

import view.Telas;

public class ExceptionLogin extends RuntimeException {

	public ExceptionLogin(String mensagem) {
		super(mensagem);
	}
}
