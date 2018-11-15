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
import javax.swing.border.LineBorder;

import control.LoginControll;
import entity.Login;

public class DashboardFreelancerBoundary implements ActionListener {

	private JFrame frame;

	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFreelancerBoundary window = new DashboardFreelancerBoundary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DashboardFreelancerBoundary() {

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
		
		JButton btnVisualizar = new JButton("Visualizar Vagas");
		btnVisualizar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnVisualizar.setFocusable(false);
		btnVisualizar.setBorder(null);
		btnVisualizar.setBackground(Color.WHITE);
		btnVisualizar.setBounds(35, 11, 147, 23);
		btnVisualizar.addActionListener(this);
		panel.add(btnVisualizar);

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

		JButton btnAlterar = new JButton("Alterar Perfil");
		btnAlterar.setBounds(35, 57, 147, 23);
		panel.add(btnAlterar);
		btnAlterar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(255, 255, 255));
		btnAlterar.setFocusable(false);
		btnAlterar.addActionListener(this);
		btnAlterar.setBorder(null);
		

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

		if ("Finalizar Serviço".equals(e.getActionCommand())) {
			AvaliarEmpresaBoundary avaliar = new AvaliarEmpresaBoundary();
			avaliar.main();
			frame.setVisible(false);
		} else if ("Solicitar".equals(e.getActionCommand())) {
			SolicitacaoBoundary solicitacao = new SolicitacaoBoundary();
			solicitacao.main();
			frame.setVisible(false);
		} else if ("Alterar Perfil".equals(e.getActionCommand())) {
			AlterarFreelancer alterar = new AlterarFreelancer();
			alterar.main();
			frame.setVisible(false);
		} else if ("Visualizar Vagas".equals(e.getActionCommand())) {
			System.out.println("teste");
			VagaBoundary vagas = new VagaBoundary();
			vagas.main();
			frame.setVisible(false);
		}
	}
}
