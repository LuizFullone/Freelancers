package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import control.FreelancerControl;
import entity.Freelancer;

import javax.swing.JPanel;

public class AlterarFreelancer implements ActionListener {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JComboBox txtUf;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JLabel lblCep;
	private JLabel lblEndereo;
	private JLabel label_1;
	private JLabel lblNome_1;
	private JLabel label_2;
	private JTextField txtTempoExp;
	private JPanel panel;

	// Inicio table básico
	private JTable tabela;
	private JScrollPane barraRolagem;
	Object[][] dados = { { "Java", "1 ano" }, { "sql", "3 anos" }, { "UML", "3 anos" }, { "html", "1 ano" },
			{ "css", "2 anos" }, { "angular", "2 anos" }, { "java web", "2 anos" },
			{ "Lógica de programação", "10 anos" }, { "Inglês monstrão", "10 anos" } };

	String[] colunas = { "Especialidade", "Tempo de experiecia" };
	// Fim da tabela

	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarFreelancer window = new AlterarFreelancer();
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
	public AlterarFreelancer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("Cadastro de Freelancer");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSenha = new JLabel("CPF:");
		lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblSenha.setBounds(50, 72, 73, 31);
		frame.getContentPane().add(lblSenha);

		JLabel lblNome = new JLabel("Bairro:");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNome.setBounds(439, 190, 101, 31);
		frame.getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(133, 25, 217, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(133, 80, 217, 20);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 140, 217, 20);
		frame.getContentPane().add(txtEmail);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(133, 198, 217, 20);
		frame.getContentPane().add(txtCep);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(563, 25, 233, 20);
		frame.getContentPane().add(txtEndereco);

		txtUf = new JComboBox();
		txtUf.setBounds(563, 80, 51, 20);
		frame.getContentPane().add(txtUf);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(563, 140, 233, 20);
		frame.getContentPane().add(txtCidade);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(563, 198, 233, 20);
		frame.getContentPane().add(txtBairro);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(0, 0, 255));
		btnAlterar.setBounds(398, 528, 183, 36);
		btnAlterar.addActionListener(this);
		frame.getContentPane().add(btnAlterar);

		JLabel lblConfirmarSenha = new JLabel("Email:");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(50, 132, 73, 31);
		frame.getContentPane().add(lblConfirmarSenha);

		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEndereo.setBounds(439, 17, 114, 31);
		frame.getContentPane().add(lblEndereo);

		label_1 = new JLabel("Cidade:");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label_1.setBounds(439, 132, 101, 31);
		frame.getContentPane().add(label_1);

		lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNome_1.setBounds(50, 17, 73, 31);
		frame.getContentPane().add(lblNome_1);

		label_2 = new JLabel("UF:");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label_2.setBounds(439, 80, 73, 31);
		frame.getContentPane().add(label_2);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(186, 420, 73, -7);
		frame.getContentPane().add(horizontalStrut);

		JLabel label_3 = new JLabel("CEP:");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label_3.setBounds(50, 190, 73, 31);
		frame.getContentPane().add(label_3);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(613, 528, 183, 36);
		btnCancelar.addActionListener(this);
		frame.getContentPane().add(btnCancelar);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Adicionar Especialidade",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 282, 746, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblCep = new JLabel("Especialidade:");
		lblCep.setBounds(10, 27, 118, 31);
		panel.add(lblCep);
		lblCep.setFont(new Font("Arial Black", Font.PLAIN, 14));

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(138, 34, 198, 20);
		panel.add(comboBox);

		JLabel lblTempoDeExperiencia = new JLabel("Tempo de Exp:");
		lblTempoDeExperiencia.setBounds(399, 27, 118, 31);
		panel.add(lblTempoDeExperiencia);
		lblTempoDeExperiencia.setFont(new Font("Arial Black", Font.PLAIN, 14));

		txtTempoExp = new JTextField();
		txtTempoExp.setBounds(523, 34, 198, 20);
		panel.add(txtTempoExp);
		txtTempoExp.setColumns(10);

		tabela = new JTable(dados, colunas);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50, 380, 746, 120);
		frame.getContentPane().add(barraRolagem);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Cancelar".equals(e.getActionCommand())) {
			CadastroLoginBoundary cadLogin = new CadastroLoginBoundary();
			cadLogin.main();
			frame.setVisible(false);
		} else if ("Cadastrar-se".equals(e.getActionCommand())) {
			DashboardFreelancerBoundary dash = new DashboardFreelancerBoundary();
			dash.main();
			frame.setVisible(false);
		} else if ("Alterar".equals(e.getActionCommand())) {
			Freelancer f = new Freelancer();
			if(txtCpf.getText() == null) {
				JOptionPane.showMessageDialog(null, "Insira o seu CPF");
			}
			System.out.println("Apertei 1");
			FreelancerControl control = new FreelancerControl();
			if (!control.validarFreelancerCpf(txtCpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF Não cadastrado e/ou inválido");
			} else {
				f.setEmail(txtEmail.getText());
				f.setEndereco(txtEndereco.getText());
				f.setCEP(Integer.parseInt(txtCep.getText()));
				f.setNomeFreelancer(txtNome.getText());
				System.out.println("Apertei 2");
			}
			System.out.println("Apertei 3");
		}
	}
}
