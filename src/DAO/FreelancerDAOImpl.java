package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import entity.Especialidade;
import entity.Freelancer;
import entity.Login;

public class FreelancerDAOImpl implements FreelancerDAO {

	private Connection con;


	@Override
	public void alterarFreelancer(Freelancer f) {

		try {
			/*String sql = "UPDATE freelancer SET nome = '?', email = '?', cep = ?, endereco = '?' where cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, f.getNomeFreelancer());
			stmt.setString(2, f.getEmail());
			stmt.setInt(3, f.getCEP());
			stmt.setString(4, f.getEndereco());
			stmt.setString(5, f.getCpf());
			stmt.executeQuery();*/
			
			Statement stmt = con.createStatement();
			String query = "UPDATE freelancer SET nome = '"+ f.getNomeFreelancer()+"', email = '"+f.getEmail()+"', cep = "+f.getCEP()+", endereco = '"+ f.getEndereco()+"' where cpf = '"+f.getCpf()+"';";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public FreelancerDAOImpl() {
		this.con = new Conexao().getConnection();
	}

	@Override
	public boolean validarFreelancerCpf(String cpf) {
		try {
		//	String sql = "SELECT nome FROM freelancer WHERE cpf = '?'";
		//	PreparedStatement stmt = con.prepareStatement(sql);
		//	stmt.setString(1, cpf); 
			//ResultSet rs = stmt.executeQuery();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM freelancer where cpf = '"+cpf+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
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
			/*String sql = "SELECT email FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();*/
			Statement stmt = con.createStatement();
			String query = "SELECT email FROM freelancer where cpf = '"+cpf+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getString("email");
			}
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
			/*String sql = "SELECT endereco FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();*/
			Statement stmt = con.createStatement();
			String query = "SELECT endereco FROM freelancer where cpf = '"+cpf+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getString("endereco");
			}
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
			/*
			String sql = "SELECT cep FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();
			*/
			Statement stmt = con.createStatement();
			String query = "SELECT cep FROM freelancer where cpf = '"+cpf+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getInt("cep");
			}
			return rs.getInt("cep");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String buscarNomeCpf(String cpf) {
		try {
			/*String sql = "SELECT nome FROM freelancer WHERE cpf = '?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			con.close();*/
			Statement stmt = con.createStatement();
			String query = "SELECT nome FROM freelancer where cpf = '"+cpf+"';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getString("nome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cadastrarFreelancer(Freelancer f, Login l) {
		try {
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO freelancer "
					+ " (nome, cpf, email, cep, endereco, uf , cidade , bairro , fk_login) " + " VALUES ('"
					+ f.getNomeFreelancer() + "', " + f.getCpf() + ", " + "'" + f.getEmail() + "', " + f.getCEP()
					+ ", '" + f.getEndereco() + "','" + f.getUf() + "', '" + f.getCidade() + "','" + f.getBairro()
					+ "', " + l.getId() + ");";

			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cadastrarEspecialidade(Especialidade f, Login l) {
		try {
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO especialidade " + " (nome_especialidade, temp_exp, fk_freelancer) " + " VALUES "
					+ "('" + f.getEspecialidade() + "', '" + f.getTempExp() + "'," + l.getId() + ");";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String encontrarID(String nome) {
		try {
			Statement stmt = con.createStatement();
			String query = "select * from freelancer where nome = '" + nome + "';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getString("idFreelancer");
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Especialidade> updateEspecialidade(Login l) {
		List<Especialidade> lista = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String query = "select nome_especialidade, temp_exp from especialidade where fk_freelancer = " + l.getId()
					+ ";";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Especialidade esp = new Especialidade();
				esp.setEspecialidade(rs.getString("nome_especialidade"));
				esp.setTempExp(rs.getString("temp_exp"));
				lista.add(esp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public boolean updateuser(Login l) {
		try {
			
			Statement stmt = con.createStatement();
			String query = "select * from freelancer where fk_login = " + l.getId() + ";";
			System.out.println(l.getId());
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Freelancer update(Login l) {
		try {
			Statement stmt = con.createStatement();
			String query = "select * from freelancer where fk_login = " + l.getId() + ";";
			System.out.println(l.getId());
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				Freelancer f = new Freelancer();
				f.setNomeFreelancer(rs.getString("nome"));
				f.setBairro(rs.getString("bairro"));
				f.setCEP(rs.getInt("cep"));
				f.setCidade(rs.getString("cidade"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setUf(rs.getString("uf"));
				return f;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
