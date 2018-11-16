package DAO;

import entity.Login;

public interface LoginDAO {
	
	void adicionarLogin(Login l);
	boolean updateUser(String usuario, String senha);
	String identificaUser(String nome);
	
}
