package DAO;

import java.sql.SQLException;

import entity.Freelancer;

public interface FreelancerDAO {
	
	public void alterarFreelancer(Freelancer f) throws SQLException;
	public boolean validarFreelancerCpf(String cpf);
	public String buscarEmailCpf(String cpf);
	public String buscarEnderecoCpf(String cpf);
	public int buscarCepCpf(String cpf);
	public String buscarNomeCpf(String cpf);
}
