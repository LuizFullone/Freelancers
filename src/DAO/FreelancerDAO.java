package DAO;

import java.util.List;

import entity.Especialidade;
import entity.Freelancer;

public interface FreelancerDAO {

	public void cadastrarFreelancer(Freelancer f);
	public List<Freelancer> ler(Freelancer j);
	public String encontrarID(String nome);
	public List<Especialidade> updateEspecialidade();
	void cadastrarEspecialidade(Especialidade f);
	
	
}
