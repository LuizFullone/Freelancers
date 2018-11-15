package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			String sql = "INSERT INTO login (nome_user, senha, tipo_user) VALUES ('"+l.getUser()+"','"+l.getSenha()+"','"+l.getTipoUser()+"')";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateUser(String usuario, String senha) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select nome_user from freelancers.login where nome_user = '"+usuario+"' && senha = '"+senha+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}else {
				return false;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public String identificaUser(Login l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select tipo_user from freelancers.login where nome_user = '"+l.getUser()+"';";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(rs.getString("tipo_user"));
				return (rs.getString("tipo_user"));	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
