package control;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import DAO.FreelancerDAO;
import DAO.FreelancerDAOImpl;
import entity.Especialidade;
import entity.Freelancer;
import entity.Login;



public class FreelancerControl implements TableModel {
	
	public List<Especialidade> especialidade = new ArrayList<>();
	public FreelancerDAO freeDAO = new FreelancerDAOImpl();
	private FreelancerDAOImpl dao = new FreelancerDAOImpl();
	
	public boolean updateuser(Login l) {
		return dao.updateuser(l);
	}

	public void cadastrarFreelancer(Freelancer f, Login l) {
		dao.cadastrarFreelancer(f,l);
	}
	public boolean validarFreelancerCpf(String cpf) {
		
		FreelancerDAOImpl freedao = new FreelancerDAOImpl();
		
		return freedao.validarFreelancerCpf(cpf);
			
			
	}
	
	public void alterarFreelancer(Freelancer f) {
		FreelancerDAOImpl daoFree = new FreelancerDAOImpl();
		if(f.getEmail() == null){
			f.setEmail(daoFree.buscarEmailCpf(f.getCpf()));
		}
		if(f.getEndereco() == null) {
			f.setEndereco(daoFree.buscarEnderecoCpf(f.getCpf()));
		}
		if(f.getCEP() == 0) {
			f.setCEP(daoFree.buscarCepCpf(f.getCpf()));
		}
		if(f.getNomeFreelancer() == null) {
			f.setNomeFreelancer(daoFree.buscarNomeCpf(f.getCpf()));
		}
		daoFree.alterarFreelancer(f);
		JOptionPane.showMessageDialog(null, "Dados Alterados");
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
	
	public Freelancer update(Login l) {
		return dao.update(l);
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