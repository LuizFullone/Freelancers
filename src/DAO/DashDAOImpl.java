package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.FreelancerFiltro;
import entity.Vaga;

public class DashDAOImpl implements DashDAO {

	@Override
	public List<Vaga> updateVaga(Vaga v) {
		List<Vaga> lista = new ArrayList<>();
		
		String query = null;
		
		try {
			Connection con = new Conexao().getConnection();
			
			query = "SELECT vaga From Vaga";
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Vaga v1 = new Vaga();
				
				v1.setVaga(rs.getString("vaga"));
				lista.add(v1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	
	}

}
