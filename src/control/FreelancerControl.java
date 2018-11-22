package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.FreelancerDAOImpl;
import entity.Freelancer;

public class FreelancerControl implements TableModel {

	// private static String url = "jdbc:mysql://localhost:3306/freelancers";
	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	public List<Freelancer> freelancer = new ArrayList<>();

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
			String sql = "INSERT INTO freelancer " + " (nome, cpf, email, cep, endereco, especialidade, tempo_exp) "
					+ " VALUES ('" + f.getNomeFreelancer() + "', " + f.getCpf() + ", " + "'" + f.getEmail() + "', "
					+ f.getCEP() + ", '" + f.getEndereco() + "', '" + f.getEspecialidade() + "', '" + f.getTempExp()
					+ "');";

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
			String sql = "INSERT INTO especialidade " + " (nome, temp_exp) " + " VALUES "
					+ "('" + f.getEspecialidade()+ "', '" + f.getTempExp() + "');";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarFreelancerCpf(String cpf) {
		FreelancerDAOImpl freedao = new FreelancerDAOImpl();
		
		if(freedao.validarFreelancerCpf(cpf)) {
			return true;
		}
		
		return false;
		
	}
	
	public void alterarFreelancer(Freelancer f) {
		FreelancerDAOImpl daoFree = new FreelancerDAOImpl();
		if(f.getEmail() == null){
			f.setEmail(daoFree.buscarEmailCpf(Integer.toString(f.getCpf())));
		}
		if(f.getEndereco() == null) {
			f.setEndereco(daoFree.buscarEnderecoCpf(Integer.toString(f.getCpf())));
		}
		if(f.getCEP() == 0) {
			f.setCEP(daoFree.buscarCepCpf(Integer.toString(f.getCpf())));
		}
		if(f.getNomeFreelancer() == null) {
			f.setNomeFreelancer(daoFree.buscarNomeCpf(Integer.toString(f.getCpf())));
		}
		daoFree.alterarFreelancer(f);
		JOptionPane.showMessageDialog(null, "Dados Alterados");
	}
	
	public String encontrarID(String nome) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select * from freelancer where nome = '"+nome+"';";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return rs.getString("idFreelancer");
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Freelancer> updateEspecialidade() {
		List<Freelancer> lista = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "select nome, temp_exp from especialidade;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Freelancer free = new Freelancer();
				free.setEspecialidade(rs.getString("nome"));
				free.setTempExp(rs.getString("temp_exp"));
				lista.add(free);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	

	@Override
	public void addTableModelListener(TableModelListener free) {

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
	}
	return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0 : return "Especialidade";
		case 1 : return "Experiência";
	}
	return "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return freelancer.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Freelancer free = freelancer.get(rowIndex);
		switch (columnIndex) {
			case 0 : return free.getEspecialidade();
			case 1 : return free.getTempExp();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}