package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.DashDAOImpl;
import entity.Vaga;

public class DashFreelancerControl implements TableModel {

	public List<Vaga> vaga= new ArrayList<>();
	public DashDAOImpl Dash = new DashDAOImpl();
	
	public List<Vaga> updateVaga(Vaga v){
		v = (Vaga) Dash.updateVaga(v);
		return (List<Vaga>) v;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0 : return "Vaga";
		
	}
		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vaga free = vaga.get(rowIndex);
		switch (columnIndex) {
			case 0 : return free.getVaga();
			
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
