package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import entity.FreelancerFiltro;

public class FiltrarFreelancerDAOImpl implements FiltrarFreelancerDAO {

	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";

	public FiltrarFreelancerDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FreelancerFiltro> updateFreelancers(FreelancerFiltro f) {
		
		List<FreelancerFiltro> lista = new ArrayList<>();
		
		String query = null;
		
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			
			query = "SELECT f.nome, e.nome_especialidade, e.temp_exp FROM freelancer AS f\r\n" + 
					"INNER JOIN especialidade AS e ON e.fk_freelancer = f.fk_especialidade\r\n" + 
					"where f.nome like '%"+f.getNome()+"%' && e.nome_especialidade like '%"
							+ ""+f.getEspecialidade()+"%' && e.temp_exp like '%"+f.getTemp_exp()+"%'";
			
			Statement stmt = con.createStatement();
			
			/*
			query = "SELECT f.nome, e.nome_especialidade, e.temp_exp FROM freelancer AS f\r\n" + 
					"INNER JOIN especialidade AS e ON e.fk_freelancer = f.fk_especialidade\r\n" + 
					"where f.nome like ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, "%"+f.getNome()+"%");
			*/
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				FreelancerFiltro free = new FreelancerFiltro();
				
				free.setNome(rs.getString("nome"));
				free.setEspecialidade(rs.getString("nome_especialidade"));
				free.setTemp_exp(rs.getString("temp_exp"));
				lista.add(free);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
