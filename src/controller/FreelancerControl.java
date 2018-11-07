package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Freelancer;

public class FreelancerControl {

	//private static String url = "jdbc:mysql://localhost:3306/freelancers";
	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	
	public FreelancerControl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarFreelancer(Freelancer f) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO freelancer "
					+ " (nome, cpf, email, cep, endereco) "
					+ " VALUES ('" + f.getNomeFreelancer() + "', "
						+ f.getCpf()+  ", "
						+ "'" + f.getEmail()+ "', "
						+ f.getCEP() + ", '" + f.getEndereco()+ "')";
			
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
