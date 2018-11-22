package DAO;

import entity.Login;

public interface LoginDAO {
	
	void adicionarLogin(Login l);
	int updateUser(String usuario, String senha);
	String identificaUser(String nome);
	
}
