# Javacai

- Para o funcionamento correto do sistema, deve ser feito a importa��o do driver do JDBC para PostgreSQL e da biblioteca itext, que podem ser encontradas em resources/librarys.

- Tamb�m � necess�rio a cria��o de um banco de dados PostgreSQL com o nome Javacai e com usuario postgres, onde deve ser feito o backup por meio do arquivo de backup encontrado em resources/backup.

- Deve ser criado o arquivo src/BD/BD.java e inserir o codigo:
~~~java
package BD;

public class BD {
	public final static String PASSWORD_POSTGRE = "senhaDoPostgre";
}
~~~

adicionando a senha do postgre no atributo PASSWORD_POSTGRE.

- Por fim, o arquivo a ser executado � src/view/Telas.java.