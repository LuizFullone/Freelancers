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
import javax.swing.JCheckBox;

public class CadastroLogin {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtSenha;
	private JTextField txtConfirmSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLogin window = new CadastroLogin();
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
	public CadastroLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 611, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblSenha.setBounds(128, 72, 73, 31);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblUser.setBounds(139, 17, 73, 31);
		frame.getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(222, 80, 292, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(222, 25, 292, 20);
		frame.getContentPane().add(txtSenha);
		
		txtConfirmSenha = new JTextField();
		txtConfirmSenha.setColumns(10);
		txtConfirmSenha.setBounds(222, 138, 292, 20);
		frame.getContentPane().add(txtConfirmSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(33, 130, 179, 31);
		frame.getContentPane().add(lblConfirmarSenha);
		
		JCheckBox chbEmpresa = new JCheckBox("Sou empresa");
		chbEmpresa.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chbEmpresa.setBackground(new Color(255, 255, 255));
		chbEmpresa.setBounds(222, 187, 160, 44);
		frame.getContentPane().add(chbEmpresa);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chbEmpresa.isSelected()) {
					CadastroEmpresa cadastro = new CadastroEmpresa();
					cadastro.main();
					frame.setVisible(false);
				}else {
					CadastroFreelancer cadastro = new CadastroFreelancer();
					cadastro.main();
					frame.setVisible(false);
				}
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCadastrar.setBackground(new Color(0, 0, 255));
		btnCadastrar.setBounds(222, 270, 183, 36);
		frame.getContentPane().add(btnCadastrar);
	}
}
