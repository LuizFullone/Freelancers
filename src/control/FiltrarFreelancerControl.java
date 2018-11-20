package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.FiltrarFreelancerDAO;
import DAO.FiltrarFreelancerDAOImpl;
import entity.FreelancerFiltro;

public class FiltrarFreelancerControl implements TableModel{
	
	public List<FreelancerFiltro> free = new ArrayList<>();
	public FiltrarFreelancerDAO freeDAO = new FiltrarFreelancerDAOImpl();
	private FiltrarFreelancerDAOImpl filtrar = new FiltrarFreelancerDAOImpl();
	
	public List<FreelancerFiltro> updateFreelancers(FreelancerFiltro f){
		free = filtrar.updateFreelancers(f);
		return free;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0 : return "Nome";
			case 1 : return "Especialidade";
			case 2 : return "Tempo de Experiência";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return free.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 FreelancerFiltro f = free.get(rowIndex);
		switch (columnIndex) {
			case 0 : return f.getNome();
			case 1 : return f.getEspecialidade();
			case 2 : return f.getTemp_exp();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	
}
