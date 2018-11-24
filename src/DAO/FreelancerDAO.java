package DAO;
import java.util.List;
import entity.Especialidade;
import entity.Freelancer;
import entity.Login;
import java.sql.SQLException;

public interface FreelancerDAO {

	public void cadastrarFreelancer(Freelancer f, Login l);
	
	public String encontrarID(String nome);
	
	public List<Especialidade> updateEspecialidade(Login l);
	
	void cadastrarEspecialidade(Especialidade f, Login l);
	
	public boolean updateuser(Login l);
	
	public void alterarFreelancer(Freelancer f) throws SQLException;
	
	public boolean validarFreelancerCpf(String cpf);
	
	public String buscarEmailCpf(String cpf);
	
	public String buscarEnderecoCpf(String cpf);
	
	public int buscarCepCpf(String cpf);
	public String buscarNomeCpf(String cpf);

	public Freelancer update(Login l);

}
