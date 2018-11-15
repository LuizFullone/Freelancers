package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Empresa;
import entity.Login;

public class EmpresaControl {

	private static String url = "jdbc:mysql://localhost:3306/freelancers?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	
	public EmpresaControl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionarEmpresa(Empresa empresa) throws SQLException {
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO empresa (nome_empresa, cnpj, email, cep, endereco, cidade, bairro, razao_social, incricao_estadual, missao, visao, valores, quem_somos) VALUES "
		+ "('"+empresa.getNome()+"',"
		+ " '"+empresa.getCnpj()+"',"
		+ " '"+empresa.getEmail()+"',"
		+ " "+empresa.getCep()+","
		+ " '"+empresa.getEndereco()+"',"
		+ " '"+empresa.getCidade()+"',"
		+ " '"+empresa.getBairro()+"',"
		+ " '"+empresa.getRazaoSocial()+"',"
		+ " '"+empresa.getInscricaoEst()+"',"
		+ "'"+empresa.getMissao()+"', "
		+ "'"+empresa.getVisao()+"', "
		+ "'"+empresa.getValores()+"', "
		+ "'"+empresa.getQuem_somos()+"');";		
		stmt.executeUpdate(sql);
		con.close();
	}
	
	public void adicionarLogin (Login l) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO login (nome_user, senha, tipo_user) VALUES ('"+l.getUser()+"','"+l.getSenha()+"','"+l.getTipoUser()+"')";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
