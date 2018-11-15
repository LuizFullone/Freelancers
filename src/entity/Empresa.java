package entity;

public class Empresa {
	private String nome;
	private String cnpj;
	private String email;
	private int cep;
	private String endereco;
	private String uf;
	private String cidade;
	private String bairro;
	private String inscricaoEst;
	private String razaoSocial;
	private String missao;
	private String visao;
	private String valores;
	private String quem_somos;
	
	public String getQuem_somos() {
		return quem_somos;
	}
	public void setQuem_somos(String quem_somos) {
		this.quem_somos = quem_somos;
	}
	public String getMissao() {
		return missao;
	}
	public void setMissao(String missao) {
		this.missao = missao;
	}
	public String getVisao() {
		return visao;
	}
	public void setVisao(String visao) {
		this.visao = visao;
	}
	public String getValores() {
		return valores;
	}
	public void setValores(String valores) {
		this.valores = valores;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(Object object) {
		this.uf = (String) object;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getInscricaoEst() {
		return inscricaoEst;
	}
	public void setInscricaoEst(String inscricaoEst) {
		this.inscricaoEst = inscricaoEst;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}
