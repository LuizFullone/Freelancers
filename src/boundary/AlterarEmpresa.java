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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class AlterarEmpresa implements ActionListener{

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JComboBox cmbUf;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JLabel lblEndereo;
	private JLabel label_1;
	private JLabel lblNome_1;
	private JLabel label_2;
	private JTextField txtInscricaoEst;
	private JTextField txtRazaoSocial;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarEmpresa window = new AlterarEmpresa();
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
	public AlterarEmpresa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cadastro de Empresa");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome1 = new JLabel("Nome:");
		lblNome1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNome1.setBounds(10, 25, 168, 31);
		frame.getContentPane().add(lblNome1);
		
		txtNome = new JTextField();
		txtNome.setBounds(171, 25, 217, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCnpj.setBounds(10, 80, 168, 31);
		frame.getContentPane().add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(171, 80, 217, 20);
		frame.getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEmail.setBounds(10, 140, 168, 31);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(171, 140, 217, 20);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCep.setBounds(10, 198, 168, 31);
		frame.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(171, 198, 217, 20);
		frame.getContentPane().add(txtCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEndereco.setBounds(10, 256, 168, 31);
		frame.getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(171, 256, 217, 20);
		frame.getContentPane().add(txtEndereco);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblUf.setBounds(10, 305, 168, 31);
		frame.getContentPane().add(lblUf);
		
		cmbUf = new JComboBox();
		cmbUf.setBounds(171, 305, 51, 20);
		frame.getContentPane().add(cmbUf);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCidade.setBounds(10, 355, 168, 31);
		frame.getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(171, 355, 217, 20);
		frame.getContentPane().add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblBairro.setBounds(10, 410, 168, 31);
		frame.getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(171, 410, 217, 20);
		frame.getContentPane().add(txtBairro);
		
		JLabel lblIncricaoEst = new JLabel("Inscrição Estadual:");
		lblIncricaoEst.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblIncricaoEst.setBounds(10, 502, 168, 31);
		frame.getContentPane().add(lblIncricaoEst);
		
		txtInscricaoEst = new JTextField();
		txtInscricaoEst.setBounds(171, 509, 217, 20);
		frame.getContentPane().add(txtInscricaoEst);
		txtInscricaoEst.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		lblRazoSocial.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblRazoSocial.setBounds(10, 462, 168, 31);
		frame.getContentPane().add(lblRazoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(171, 462, 217, 20);
		frame.getContentPane().add(txtRazaoSocial);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(186, 420, 73, -7);
		frame.getContentPane().add(horizontalStrut);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Especialidade da Empresa", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setToolTipText("Especialidade da empresa");
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(438, 11, 376, 522);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMissao = new JLabel("Missão");
		lblMissao.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblMissao.setBounds(35, 25, 64, 26);
		panel.add(lblMissao);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(35, 49, 319, 52);
		textArea.setBorder(new LineBorder(null));
		textArea.setOpaque(false);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setOpaque(false);
		textArea_1.setBorder(new LineBorder(null));
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(35, 137, 319, 52);
		panel.add(textArea_1);
		
		JLabel lblVisao = new JLabel("Vis\u00E3o");
		lblVisao.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblVisao.setBounds(35, 112, 64, 26);
		panel.add(lblVisao);
		
		JLabel lblValores = new JLabel("Valores");
		lblValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblValores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblValores.setBounds(35, 215, 64, 26);
		panel.add(lblValores);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setOpaque(false);
		textArea_2.setBorder(new LineBorder(null));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setBounds(35, 240, 319, 52);
		panel.add(textArea_2);
		
		JLabel lblQuemSomos = new JLabel("Quem Somos ?");
		lblQuemSomos.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuemSomos.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblQuemSomos.setBounds(136, 320, 141, 26);
		panel.add(lblQuemSomos);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setOpaque(false);
		textArea_3.setBorder(new LineBorder(null));
		textArea_3.setBackground(Color.WHITE);
		textArea_3.setBounds(35, 357, 319, 129);
		panel.add(textArea_3);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(new Color(0, 0, 0));
		btnAlterar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(204, 255, 204));
		btnAlterar.setBounds(438, 554, 183, 36);
		btnAlterar.addActionListener(this);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 102, 102));
		btnCancelar.setBounds(631, 554, 183, 36);
		btnCancelar.addActionListener(this);
		frame.getContentPane().add(btnCancelar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Cadastrar-se".equals(e.getActionCommand())) { 
			Dashboard dash = new Dashboard();
			dash.main();
			frame.setVisible(false);
		} else if ("Cancelar".equals(e.getActionCommand())) {
			CadastroLogin login = new CadastroLogin();
			login.main();
			frame.setVisible(false);
		}
		
		
	}
}
