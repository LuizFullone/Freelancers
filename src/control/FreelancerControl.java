package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.FiltrarFreelancerDAO;
import DAO.FiltrarFreelancerDAOImpl;
import DAO.FreelancerDAO;
import DAO.FreelancerDAOImpl;
import entity.Especialidade;
import entity.Freelancer;
import entity.Login;



public class FreelancerControl implements TableModel {
	
	public List<Especialidade> especialidade = new ArrayList<>();
	public FreelancerDAO freeDAO = new FreelancerDAOImpl();
	private FreelancerDAOImpl dao = new FreelancerDAOImpl();
	
	public boolean updateuser(int id) {
		return dao.updateuser(id);
	}

	public void cadastrarFreelancer(Freelancer f, Login l) {
		dao.cadastrarFreelancer(f,l);
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
	

	public List<Freelancer> ler(Freelancer j) {
			return dao.ler(j);
	}

	public void cadastrarEspecialidade(Especialidade f, Login l) {
		dao.cadastrarEspecialidade(f, l);
	}
	
	public String encontrarID(String nome) {
		return dao.encontrarID(nome);
	}
	
	public List<Especialidade> updateEspecialidade(Especialidade e, Login l) {
		especialidade = dao.updateEspecialidade(l);
		return especialidade;
		
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
		return especialidade.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Especialidade free = especialidade.get(rowIndex);
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