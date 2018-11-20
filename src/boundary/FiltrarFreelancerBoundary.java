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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import control.FiltrarFreelancerControl;
import entity.FreelancerFiltro;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FiltrarFreelancerBoundary implements ActionListener{

	private JFrame frame;
	private JTextField txtNome;
	private JLabel lblEspecialidade;
	private JLabel lblNome;
	private JTextField txtTempoExp;
	private JPanel panel;
	private JTextField txtEspecialidade;
	private FiltrarFreelancerControl control = new FiltrarFreelancerControl();
	private JTable tabela = new JTable(control);
    
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltrarFreelancerBoundary window = new FiltrarFreelancerBoundary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FiltrarFreelancerBoundary() {
		initialize();
	}

	private void initialize() {
		this.setLocationRelativeTo(null);
		
		frame = new JFrame("Filtrar Freelancer");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(300, 151, 787, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane panTabela = new JScrollPane();
		panTabela.setViewportView(tabela);
		panTabela.setBounds(20, 137, 730, 265);
		frame.getContentPane().add(panTabela);
		
		txtNome = new JTextField();
		txtNome.setBounds(103, 19, 647, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAlterar = new JButton("Filtrar");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAlterar.setBackground(new Color(0, 0, 255));
		btnAlterar.setBounds(476, 413, 132, 36);
		btnAlterar.addActionListener(this);
		frame.getContentPane().add(btnAlterar);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNome.setBounds(20, 11, 73, 31);
		frame.getContentPane().add(lblNome);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(186, 420, 73, -7);
		frame.getContentPane().add(horizontalStrut);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(618, 413, 132, 36);
		btnCancelar.addActionListener(this);
		frame.getContentPane().add(btnCancelar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtro por Especialidade", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 50, 730, 76);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setBounds(10, 27, 118, 31);
		panel.add(lblEspecialidade);
		lblEspecialidade.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		JLabel lblTempoDeExperiencia = new JLabel("Tempo de Exp:");
		lblTempoDeExperiencia.setBounds(399, 27, 118, 31);
		panel.add(lblTempoDeExperiencia);
		lblTempoDeExperiencia.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		txtTempoExp = new JTextField();
		txtTempoExp.setBounds(523, 34, 198, 20);
		panel.add(txtTempoExp);
		txtTempoExp.setColumns(10);
		
		txtEspecialidade = new JTextField();
		txtEspecialidade.setBounds(128, 34, 261, 20);
		panel.add(txtEspecialidade);
		txtEspecialidade.setColumns(10);
	}
	
	private void setLocationRelativeTo(Object object) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Cancelar".equals(e.getActionCommand())) { 
			DashboardEmpresaBoundary dash = new DashboardEmpresaBoundary();
			dash.main();
			frame.setVisible(false);
		} else if ("Filtrar".equals(e.getActionCommand())) {
			List<FreelancerFiltro> lista = control.updateFreelancers();
			if (lista.size() > 0) {
				FreelancerFiltro f = lista.get(0);
				txtNome.setText( f.getNome() );
				txtEspecialidade.setText( f.getEspecialidade() );
				txtTempoExp.setText(f.getTemp_exp());
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		}
	}
}









