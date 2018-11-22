package DAO;

import java.util.List;

import entity.Especialidade;
import entity.Freelancer;
import entity.Login;

public interface FreelancerDAO {

	public void cadastrarFreelancer(Freelancer f, Login l);
	public List<Freelancer> ler(Freelancer j);
	public String encontrarID(String nome);
	public List<Especialidade> updateEspecialidade(Login l);
	void cadastrarEspecialidade(Especialidade f, Login l);
	public boolean updateuser(int id);
	
	
}
