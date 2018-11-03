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

public class Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		String TestBotao = "free";
		
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
		
		JButton btnFinalizarServio = new JButton("Finalizar Servi\u00E7o");
		btnFinalizarServio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnFinalizarServio.setFocusable(false);
		btnFinalizarServio.setBorder(null);
		btnFinalizarServio.setBackground(Color.WHITE);
		btnFinalizarServio.setBounds(35, 116, 147, 23);
		panel.add(btnFinalizarServio);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnSolicitar.setFocusable(false);
		btnSolicitar.setBorder(null);
		btnSolicitar.setBackground(Color.WHITE);
		btnSolicitar.setBounds(35, 175, 147, 23);
		panel.add(btnSolicitar);
		
		if("empresa".equals(TestBotao)) {
			JButton btnBuscarFreelancer = new JButton("Buscar Freelancer");
			btnBuscarFreelancer.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnBuscarFreelancer.setFocusable(false);
			btnBuscarFreelancer.setBorder(null);
			btnBuscarFreelancer.setBackground(Color.WHITE);
			btnBuscarFreelancer.setBounds(20, 11, 172, 23);
			panel.add(btnBuscarFreelancer);
		}else {
			JButton button = new JButton("Visualizar Vagas");
			button.setBounds(35, 11, 147, 23);
			button.setFont(new Font("Arial Black", Font.PLAIN, 16));
			button.setFocusable(false);
			button.setBorder(null);
			button.setBackground(Color.WHITE);
			panel.add(button);
		}
		JButton btnVisualizarVagas = new JButton("Alterar Perfil");
		btnVisualizarVagas.setBounds(35, 57, 147, 23);
		panel.add(btnVisualizarVagas);
		btnVisualizarVagas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnVisualizarVagas.setBackground(new Color(255, 255, 255));
		btnVisualizarVagas.setFocusable(false);
		btnVisualizarVagas.setBorder(null);
		
		JLabel lblDashboard = new JLabel("DashBoard");
		lblDashboard.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblDashboard.setBounds(227, 11, 147, 38);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblNotificaes = new JLabel("Notifica\u00E7\u00F5es:");
		lblNotificaes.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNotificaes.setBounds(305, 86, 193, 44);
		frame.getContentPane().add(lblNotificaes);
	}
}
