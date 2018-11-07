package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class LoginBoundary implements ActionListener{

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
					LoginBoundary window = new LoginBoundary();
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
			CadastroLogin cadLogin = new CadastroLogin();
			cadLogin.main();
			frame.setVisible(false);
		} else if ("Login".equals(e.getActionCommand())) {
			Dashboard dash = new Dashboard();
			dash.main();
			frame.setVisible(false);
		}
	}
}
