package boundary;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import control.FreelancerControl;
import entity.Freelancer;
import javax.swing.JPanel;

public class CadastroFreelancerBoundary implements ActionListener {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JComboBox<Object> cmbUf;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JLabel lblCep;
	private JLabel label_1;
	private JLabel lblNome_1;
	private JLabel label_2;
	private JTextField txtTempoExp;
	private JPanel panel;
	private JTextField txtEspecialidade;
	private JButton btnMais = new JButton("+");
	
	private FreelancerControl control = new FreelancerControl();
	private JTable tabela = new JTable(control);

	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFreelancerBoundary window = new CadastroFreelancerBoundary();
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
	public CadastroFreelancerBoundary() {
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
		
		JScrollPane panTabela = new JScrollPane();
		panTabela.getViewport().add(tabela);

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

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(563, 140, 233, 20);
		frame.getContentPane().add(txtCidade);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(563, 198, 233, 20);
		frame.getContentPane().add(txtBairro);

		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCadastrar.setBackground(new Color(0, 0, 255));
		btnCadastrar.setBounds(398, 528, 183, 36);
		btnCadastrar.addActionListener(this);
		frame.getContentPane().add(btnCadastrar);

		JLabel lblConfirmarSenha = new JLabel("Email:");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(50, 132, 73, 31);
		frame.getContentPane().add(lblConfirmarSenha);

		JLabel lblEnd = new JLabel("Endereço:");
		lblEnd.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEnd.setBounds(439, 17, 114, 31);
		frame.getContentPane().add(lblEnd);

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
		
		cmbUf = new JComboBox<Object>();
		cmbUf.setFont(new java.awt.Font("Dialog", 1, 16));
		cmbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC"
				, "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT",
				"PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
		cmbUf.setBounds(563, 83, 51, 20);
		frame.getContentPane().add(cmbUf);

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

		JLabel lblTempoDeExperiencia = new JLabel("Tempo de Exp:");
		lblTempoDeExperiencia.setBounds(399, 27, 118, 31);
		panel.add(lblTempoDeExperiencia);
		lblTempoDeExperiencia.setFont(new Font("Arial Black", Font.PLAIN, 14));

		txtTempoExp = new JTextField();
		txtTempoExp.setBounds(523, 34, 198, 20);
		panel.add(txtTempoExp);
		txtTempoExp.setColumns(10);

		txtEspecialidade = new JTextField();
		txtEspecialidade.setBounds(138, 34, 198, 20);
		panel.add(txtEspecialidade);
		txtEspecialidade.setColumns(10);
		
		panTabela.setBounds(50, 396, 746, 105);
		frame.getContentPane().add(panTabela);

		btnMais.setBounds(707, 372, 89, 23);
		frame.getContentPane().add(btnMais);
		btnMais.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Freelancer freelancer = new Freelancer();
		if ("Cancelar".equals(e.getActionCommand())) {
			CadastroLoginBoundary cadLogin = new CadastroLoginBoundary();
			cadLogin.main();
			frame.setVisible(false);
		} else if ("Cadastrar-se".equals(e.getActionCommand())) {
			freelancer.setNomeFreelancer(txtNome.getText());
			freelancer.setCpf(Integer.parseInt(txtCpf.getText()));
			freelancer.setEmail(txtEmail.getText());
			freelancer.setCEP(Integer.parseInt(txtCep.getText()));
			freelancer.setEndereco(txtEndereco.getText());
			freelancer.setUf(cmbUf.getSelectedItem());
			freelancer.setCidade(txtCidade.getText());
			freelancer.setBairro(txtBairro.getText());
			freelancer.setEspecialidade(txtEspecialidade.getText());
			freelancer.setTempExp(txtTempoExp.getText());
			control.cadastrarFreelancer(freelancer);
			DashboardFreelancerBoundary dash = new DashboardFreelancerBoundary();
			dash.main();
			frame.setVisible(false);
		} else if ("+".equals(e.getActionCommand())) {
			
			freelancer.setEspecialidade(txtEspecialidade.getText());
			freelancer.setTempExp(txtTempoExp.getText());
			List<Freelancer> lista = control.updateEspecialidade();
			
			if (lista.size() > 0) {
				Freelancer free = lista.get(0);
				txtEspecialidade.setText(free.getEspecialidade());
				txtTempoExp.setText(free.getTempExp());
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		}

	}
}
