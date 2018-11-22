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

	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	private Connection con;

	@Override
	public void alterarFreelancer(Freelancer f) {

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

	@Override
	public void cadastrarFreelancer(Freelancer f, Login l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
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
	public List<Freelancer> ler(Freelancer j) {
		Freelancer f = new Freelancer();
		Especialidade e = new Especialidade();
		List<Freelancer> cadastros = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM especialidade;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				e.setEspecialidade(rs.getString("nome_especialidade"));
				e.setTempExp(rs.getString("temp_exp"));
				cadastros.add(f);
			}
			con.close();
		} catch (SQLException d) {
			d.printStackTrace();
		}
		return cadastros;

	}

	@Override
	public void cadastrarEspecialidade(Especialidade f, Login l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
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
			Connection con = DriverManager.getConnection(url, user, pass);
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
			Connection con = DriverManager.getConnection(url, user, pass);
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
	public boolean updateuser(int id) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			Login l = new Login();
			String query = "select * from freelancer where fk_login = " + l.getId() + ";";
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

}
