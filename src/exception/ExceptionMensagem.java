package exception;

import view.Telas;

public class ExceptionMensagem extends RuntimeException {

	public ExceptionMensagem(String mensagem) {
		super(mensagem);
	}
}
