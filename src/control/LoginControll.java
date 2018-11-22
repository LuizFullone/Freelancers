package control;

import javax.swing.JTextField;

import DAO.LoginDAOImpl;
import entity.Login;

public class LoginControll {
	
	private LoginDAOImpl logDAO = new LoginDAOImpl();
	
	public void adicionarLogin (Login l) {
		logDAO.adicionarLogin(l);
	}
	
	public int updateUser(String usuario, String txtSenha) {
		return logDAO.updateUser(usuario, txtSenha);
	}
	

	public String identificaUser(String nome) {
		return logDAO.identificaUser(nome);
	}
	
	
}
