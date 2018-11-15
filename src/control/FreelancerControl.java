package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
					+ " (nome, cpf, email, cep, endereco, especialidade, tempo_exp) "
					+ " VALUES ('" + f.getNomeFreelancer() + "', "
						+ f.getCpf()+  ", "
						+ "'" + f.getEmail()+ "', "
						+ f.getCEP() + ", '" + f.getEndereco()+ "', '"+ f.getEspecialidade() + "', '"+ f.getTempExp()+"');";
			
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Freelancer> ler(Freelancer j) {
		Freelancer f = new Freelancer();
		List<Freelancer> cadastros = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM especialidade;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString("nome"));
				f.setEspecialidade(rs.getString("nome"));
				f.setTempExp(rs.getString("temp_exp"));
				cadastros.add(f);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadastros;

	}

	public void cadastrarEspecialidade(Freelancer f) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO especialidade "
					+ " (nome, temp_exp) "
					+ " VALUES ('"+f.getEspecialidade()+"', '"+f.getTempExp()+"');";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}