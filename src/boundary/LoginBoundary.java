package boundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import control.LoginControll;

public class LoginBoundary implements ActionListener {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtSenha;

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			LoginBoundary window = new LoginBoundary();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginBoundary() {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblSenha.setBounds(33, 121, 73, 31);
		frame.getContentPane().add(lblSenha);

		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblUser.setBounds(33, 65, 73, 31);
		frame.getContentPane().add(lblUser);

		txtUser = new JTextField();
		txtUser.setBounds(121, 73, 276, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(121, 129, 276, 20);
		frame.getContentPane().add(txtSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setBounds(290, 201, 104, 36);
		btnLogin.addActionListener(this);
		frame.getContentPane().add(btnLogin);

		JButton btnAindaNoPossui = new JButton("Ainda não possui conta ? Clique aqui para cadastra-se");

		btnAindaNoPossui.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAindaNoPossui.setBackground(Color.WHITE);
		btnAindaNoPossui.setBounds(43, 160, 354, 23);
		btnAindaNoPossui.setBorder(null);
		btnAindaNoPossui.addActionListener(this);
		frame.getContentPane().add(btnAindaNoPossui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Ainda não possui conta ? Clique aqui para cadastra-se".equals(e.getActionCommand())) {
			CadastroLoginBoundary cadLogin = new CadastroLoginBoundary();
			cadLogin.main();
			frame.setVisible(false);
		} else if ("Login".equals(e.getActionCommand())) {
			LoginControll l = new LoginControll();
			
			if (l.updateUser(txtUser.getText(), txtSenha.getText())) {
				System.out.println(txtUser.getText());
				String tipoUser = l.identificaUser(txtUser.getText());
				if ("freelancer".equals(tipoUser)) {
					DashboardFreelancerBoundary dash = new DashboardFreelancerBoundary();
					dash.main();
					frame.setVisible(false);
				} else if ("empresa".equals(tipoUser)){
					DashboardEmpresaBoundary dash = new DashboardEmpresaBoundary();
					dash.main();
					frame.setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não identificado !");
		}
	}
	}}
