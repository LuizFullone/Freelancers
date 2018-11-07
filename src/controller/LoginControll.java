package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Login;

public class LoginControll {

	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	
	public LoginControll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionarLogin (Login l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO login (nome_user, senha) VALUES ('"+l.getUser()+"','"+l.getSenha()+"')";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
