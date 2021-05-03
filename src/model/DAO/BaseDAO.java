package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import BD.BD;

public abstract class BaseDAO {
	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/Javacai";
	private static final String login = "postgres";
	private static final String senha = BD.PASSWORD_POSTGRE;
	
	public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, login, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		} 
		else return conn;
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
