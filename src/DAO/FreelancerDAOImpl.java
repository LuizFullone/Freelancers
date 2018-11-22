package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Freelancer;

public class FreelancerDAOImpl implements FreelancerDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	private Connection con;
	
	@Override
	public void alterarFreelancer(Freelancer f){
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE freelancer SET nome = '?', email = '?', cep = ?, endereco = '?' where cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, f.getNomeFreelancer());
			stmt.setString(2, f.getEmail());
			stmt.setInt(3, f.getCEP());
			stmt.setString(4, f.getEndereco());
			stmt.setString(5, Integer.toString(f.getCpf()));
			stmt.executeQuery();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public FreelancerDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean validarFreelancerCpf(String cpf) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT nome FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String buscarEmailCpf(String cpf) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT email FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			return rs.getString(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String buscarEnderecoCpf(String cpf) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT endereco FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			return rs.getString(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int buscarCepCpf(String cpf) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT cep FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			return Integer.parseInt(rs.getString(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String buscarNomeCpf(String cpf) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT nome FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			return rs.getString(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}


