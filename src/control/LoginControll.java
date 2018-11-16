package control;

import DAO.LoginDAOImpl;
import entity.Login;

public class LoginControll {
	
	private LoginDAOImpl logDAO = new LoginDAOImpl();
	
	public void adicionarLogin (Login l) {
		logDAO.adicionarLogin(l);
	}
	
	public boolean updateUser(String usuario, String senha) {
		return logDAO.updateUser(usuario, senha);
	}
	

	public String identificaUser(String nome) {
		return logDAO.identificaUser(nome);
	}
	
	
}
