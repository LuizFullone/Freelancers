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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class BuscarFreelancerBoundary implements ActionListener{

	private JFrame frame;
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarFreelancerBoundary window = new BuscarFreelancerBoundary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	  private JTable tabela;
	    private JScrollPane barraRolagem;    
	    Object [][] dados = {
	        {"Luis","São Paulo","Java"},
	        {"Luis","São Paulo","sql"},
	        {"Luis","São Paulo","UML"},
	        {"Luis","São Paulo","html"},
	        {"Luis","São Paulo","css"},
	        {"Luis","São Paulo","angular"},
	        {"Luis","São Paulo","java web"},
	        {"Luis","São Paulo","Lógica de programação"},
	        {"Luis","São Paulo","Inglês monstrão"}
	    };
	     
	    String [] colunas = {"Nome", "Cidade", "Especialidades"}; 
	    
	    
	public BuscarFreelancerBoundary() {
		
		frame = new JFrame("Buscar Freelancers");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 664, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFreelancer = new JLabel("Freelacers:");
		lblFreelancer.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblFreelancer.setBounds(153, 14, 193, 44);
		frame.getContentPane().add(lblFreelancer);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(new Color(0, 153, 255));
		btnFiltrar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnFiltrar.setBounds(26, 22, 89, 32);
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFocusable(false);
		frame.getContentPane().add(btnFiltrar);
		
		tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(26, 82, 612, 451);
        frame.getContentPane().add(barraRolagem);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		FiltrarFreelancerBoundary filtrar = new FiltrarFreelancerBoundary();
		filtrar.main();
	}
}
