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

	@Override
	public List<FreelancerFiltro> updateFreelancers(FreelancerFiltro f) {
		
		List<FreelancerFiltro> lista = new ArrayList<>();
		
		String query = null;
		
		try {
			Connection con = new Conexao().getConnection();
			
			query = "SELECT f.nome, e.nome_especialidade, e.temp_exp FROM freelancer AS f\r\n" + 
					"INNER JOIN especialidade AS e ON e.fk_freelancer = f.fk_login\r\n" + 
					"where f.nome like '%"+f.getNome()+"%' && e.nome_especialidade like '%"
							+ ""+f.getEspecialidade()+"%' && e.temp_exp like '%"+f.getTemp_exp()+"%'";
			Statement stmt = con.createStatement();
			
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
