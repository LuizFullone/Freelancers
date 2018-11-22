package entity;

public class Especialidade {
	private String especialidade;
	private String tempExp;
	private int fk_freelancer;
	
	
	public int getFk_freelancer() {
		return fk_freelancer;
	}
	public void setFk_freelancer(int fk_freelancer) {
		this.fk_freelancer = fk_freelancer;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getTempExp() {
		return tempExp;
	}
	public void setTempExp(String tempExp) {
		this.tempExp = tempExp;
	}
}
