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

import control.FreelancerControl;
import control.LoginControll;
import entity.Login;

import javax.swing.JCheckBox;

public class CadastroLoginBoundary implements ActionListener{

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtSenha;
	private JTextField txtConfirmSenha;
	private JCheckBox chbEmpresa = new JCheckBox("Sou empresa");

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLoginBoundary window = new CadastroLoginBoundary();
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
	public CadastroLoginBoundary() {
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
		txtUser.setBounds(222, 25, 292, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(222, 80, 292, 20);
		frame.getContentPane().add(txtSenha);
		
		txtConfirmSenha = new JTextField();
		txtConfirmSenha.setColumns(10);
		txtConfirmSenha.setBounds(222, 138, 292, 20);
		frame.getContentPane().add(txtConfirmSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(33, 130, 179, 31);
		frame.getContentPane().add(lblConfirmarSenha);
		
		chbEmpresa.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chbEmpresa.setBackground(new Color(255, 255, 255));
		chbEmpresa.setBounds(222, 187, 160, 44);
		frame.getContentPane().add(chbEmpresa);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCadastrar.setBackground(new Color(0, 0, 255));
		btnCadastrar.setBounds(222, 270, 183, 36);
		btnCadastrar.addActionListener(this);
		frame.getContentPane().add(btnCadastrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Cadastrar-se".equals(e.getActionCommand())) {
			
			Login login = new Login();
			login.setUser(txtUser.getText());
			login.setSenha(txtSenha.getText());
			
			if(chbEmpresa.isSelected()) {
				login.setTipoUser("empresa");
			}else {
				login.setTipoUser("freelancer");
			}
			
			LoginControll l = new LoginControll();
			l.adicionarLogin(login);
			login.setId(l.updateUser(txtUser.getText(), txtSenha.getText()));
			System.out.println(login.getId());
			
			if(chbEmpresa.isSelected()) {
				CadastroEmpresaBoundary cadastro = new CadastroEmpresaBoundary();
				cadastro.main();
				frame.setVisible(false);
			}else {
				CadastroFreelancerBoundary cadastro = new CadastroFreelancerBoundary(login);
				cadastro.main(login);
				frame.setVisible(false);
			}
		}
		}
		
	}

