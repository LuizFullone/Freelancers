package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Login;

public class LoginDAOImpl implements LoginDAO{
	
	@Override
	public void adicionarLogin(Login l) {
		try {
			Connection con = new Conexao().getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO login (nome_user, senha, tipo_user) VALUES ('"+l.getUser()+"','"+l.getSenha()+"','"+l.getTipoUser()+"')";
			stmt.executeUpdate(sql);
			sql = "select idlogin from login where nome_user = '"+l.getUser()+"';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				l.setId(Integer.parseInt(rs.getString("idlogin")));
			}else {
				System.out.println("erro");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int updateUser(String usuario, String senha) {
		try {
			Connection con = new Conexao().getConnection();
			Statement stmt = con.createStatement();
			String query = "select idlogin from freelancers.login where nome_user = '"+usuario+"' && senha = '"+senha+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getInt("idlogin");
			}else {
				return 0;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String identificaUser(String nome) {
		try {
			Connection con = new Conexao().getConnection();
			Statement stmt = con.createStatement();
			String query = "select tipo_user from freelancers.login where nome_user = '"+nome+"';";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return rs.getString("tipo_user");
			}else {
				return null;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
