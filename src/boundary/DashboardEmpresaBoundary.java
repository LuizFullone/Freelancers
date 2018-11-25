package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import control.FreelancerControl;
import control.LoginControll;
import entity.Login;

public class DashboardEmpresaBoundary implements ActionListener{
	private FreelancerControl control = new FreelancerControl();
	private JFrame frame;
	private JTable tabela = new JTable(control);
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardEmpresaBoundary window = new DashboardEmpresaBoundary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DashboardEmpresaBoundary() {
		JScrollPane panTabela = new JScrollPane();
		panTabela.setViewportView(tabela);
		frame = new JFrame("Dashboard");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 709, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 217, 584);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnFinalizarServio = new JButton("Finalizar Serviço");
		btnFinalizarServio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnFinalizarServio.setFocusable(false);
		btnFinalizarServio.setBorder(null);
		btnFinalizarServio.setBackground(Color.WHITE);
		btnFinalizarServio.setBounds(35, 116, 147, 23);
		btnFinalizarServio.addActionListener(this);
		panel.add(btnFinalizarServio);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnSolicitar.setFocusable(false);
		btnSolicitar.setBorder(null);
		btnSolicitar.setBackground(Color.WHITE);
		btnSolicitar.setBounds(35, 175, 147, 23);
		btnSolicitar.addActionListener(this);
		panel.add(btnSolicitar);
		
		LoginControll login = new LoginControll();
		
			JButton btnBuscarFreelancer = new JButton("Buscar Freelancer");
			btnBuscarFreelancer.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnBuscarFreelancer.setFocusable(false);
			btnBuscarFreelancer.setBorder(null);
			btnBuscarFreelancer.setBackground(Color.WHITE);
			btnBuscarFreelancer.setBounds(20, 11, 172, 23);
			btnBuscarFreelancer.addActionListener(this);
			panel.add(btnBuscarFreelancer);
			
		JButton btnAlterar = new JButton("Alterar Perfil");
		btnAlterar.setBounds(35, 57, 147, 23);
		panel.add(btnAlterar);
		btnAlterar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(255, 255, 255));
		btnAlterar.setFocusable(false);
		btnAlterar.addActionListener(this);
		btnAlterar.setBorder(null);
		
		JButton btnVaga = new JButton("CadastrarVaga");
		btnVaga.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnVaga.setFocusable(false);
		btnVaga.setBorder(null);
		btnVaga.setBackground(Color.WHITE);
		btnVaga.addActionListener(this);
		btnVaga.setBounds(35, 241, 147, 23);
		panel.add(btnVaga);
		
		JLabel lblDashboard = new JLabel("DashBoard");
		lblDashboard.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblDashboard.setBounds(227, 11, 147, 38);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblNotificaes = new JLabel("Notificações:");
		lblNotificaes.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNotificaes.setBounds(305, 86, 193, 44);
		frame.getContentPane().add(lblNotificaes);
		
		panTabela.setBounds(235, 141, 432, 402);
		frame.getContentPane().add(panTabela);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("Finalizar Serviço".equals(e.getActionCommand())) { 
			AvaliarFreelancerBoundary avaliar = new AvaliarFreelancerBoundary();
			avaliar.main();
			
		}else if ("Solicitar".equals(e.getActionCommand())) {
			SolicitacaoBoundary solicitacao = new SolicitacaoBoundary();
			solicitacao.main();
		
		}else if ("Alterar Perfil".equals(e.getActionCommand())) {
			AlterarEmpresa alterar = new AlterarEmpresa();
			alterar.main();
		
		}else if ("Buscar Freelancer".equals(e.getActionCommand())) {
			FiltrarFreelancerBoundary buscar = new FiltrarFreelancerBoundary();
			buscar.main();
			
		}else if ("CadastrarVaga".equals(e.getActionCommand())) {
			CadastroVagaBoundary cadastro = new CadastroVagaBoundary();
			cadastro.main();
		}
		frame.setVisible(false);
	}
}
