package entity;

import java.util.Date;

public class Freelancer {
	private String nomeFreelancer;
	private int Cpf;
	private int telefone;
	private String email;
	private Date dataNasc;
	private String endereco;
	private int CEP;
	
	public String getNomeFreelancer() {
		return nomeFreelancer;
	}
	public void setNomeFreelancer(String nomeFreelancer) {
		this.nomeFreelancer = nomeFreelancer;
	}
	public int getCpf() {
		return Cpf;
	}
	public void setCpf(int cpf) {
		Cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	
}
