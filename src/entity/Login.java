package entity;

public class Login {

	private String user;
	private String senha;
	private String TipoUser;
	
	public String getTipoUser() {
		return TipoUser;
	}
	public void setTipoUser(String tipoUser) {
		TipoUser = tipoUser;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
