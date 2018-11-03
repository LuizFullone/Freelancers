package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
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
		txtUser.setBounds(121, 129, 276, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 73, 276, 20);
		frame.getContentPane().add(textField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setBounds(290, 201, 104, 36);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblCriarConta = new JLabel("Ainda n\u00E3o possui conta ? Clique aqui para cadastra-se");
		lblCriarConta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCriarConta.setBounds(83, 163, 299, 14);
		frame.getContentPane().add(lblCriarConta);
	}
}
