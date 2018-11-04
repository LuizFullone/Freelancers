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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Dashboard implements ActionListener{

	private JFrame frame;
	String TestBotao = "free";

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		
		frame = new JFrame("Login");
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
		
		if("empresa".equals(TestBotao)) {
			JButton btnBuscarFreelancer = new JButton("Buscar Freelancer");
			btnBuscarFreelancer.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnBuscarFreelancer.setFocusable(false);
			btnBuscarFreelancer.setBorder(null);
			btnBuscarFreelancer.setBackground(Color.WHITE);
			btnBuscarFreelancer.setBounds(20, 11, 172, 23);
			btnBuscarFreelancer.addActionListener(this);
			panel.add(btnBuscarFreelancer);
		}else {
			JButton btnVisualizarVagas = new JButton("Visualizar Vagas");
			btnVisualizarVagas.setBounds(35, 11, 147, 23);
			btnVisualizarVagas.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnVisualizarVagas.setFocusable(false);
			btnVisualizarVagas.setBorder(null);
			btnVisualizarVagas.setBackground(Color.WHITE);
			btnVisualizarVagas.addActionListener(this);
			
			panel.add(btnVisualizarVagas);
		}
		JButton btnVisualizarVagas = new JButton("Alterar Perfil");
		btnVisualizarVagas.setBounds(35, 57, 147, 23);
		panel.add(btnVisualizarVagas);
		btnVisualizarVagas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnVisualizarVagas.setBackground(new Color(255, 255, 255));
		btnVisualizarVagas.setFocusable(false);
		btnVisualizarVagas.addActionListener(this);
		btnVisualizarVagas.setBorder(null);
		
		JLabel lblDashboard = new JLabel("DashBoard");
		lblDashboard.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblDashboard.setBounds(227, 11, 147, 38);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblNotificaes = new JLabel("Notificações:");
		lblNotificaes.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNotificaes.setBounds(305, 86, 193, 44);
		frame.getContentPane().add(lblNotificaes);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (("Finalizar Serviço".equals(e.getActionCommand()))&&("empresa".equals(TestBotao))) { 
			AvaliarFreelancer avaliar = new AvaliarFreelancer();
			avaliar.main();
			frame.setVisible(false);
		} else if (("Finalizar Serviço".equals(e.getActionCommand()))&&("free".equals(TestBotao))) {
			AvaliarEmpresa avaliar = new AvaliarEmpresa();
			avaliar.main();
			frame.setVisible(false);
		}else if ("Solicitar".equals(e.getActionCommand())) {
			Solicitacao solicitacao = new Solicitacao();
			solicitacao.main();
			frame.setVisible(false);
		}else if (("Alterar Perfil".equals(e.getActionCommand()))&&("empresa".equals(TestBotao))) {
			AlterarEmpresa alterar = new AlterarEmpresa();
			alterar.main();
			frame.setVisible(false);
		}else if (("Alterar Perfil".equals(e.getActionCommand()))&&("free".equals(TestBotao))) {
			AlterarFreelancer alterar = new AlterarFreelancer();
			alterar.main();
			frame.setVisible(false);
		}
		else if ("Visualizar Vagas".equals(e.getActionCommand())) {
			Vaga vagas = new Vaga();
			vagas.main();
			frame.setVisible(false);
		}else if ("Buscar Freelancer".equals(e.getActionCommand())) {
			//implementar
		}
	}
}
