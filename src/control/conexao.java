package control;

public class conexao {
	static String url = "jdbc:mysql://localhost:3306/freela?useTimezone=true&serverTimezone=UTC";
	static String user = "JJR";
	static String pass = "2043";
	
	public conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
