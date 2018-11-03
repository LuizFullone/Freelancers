package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class AvaliarFreelancer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvaliarFreelancer window = new AvaliarFreelancer();
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
	public AvaliarFreelancer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String nome_freelancer = "Ricardo Viadao";
		frame = new JFrame("Avaliar Freelancer");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAval = new JLabel("Funcionário: "+ nome_freelancer);
		lblAval.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblAval.setBounds(41, 11, 383, 36);
		frame.getContentPane().add(lblAval);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNota.setBounds(41, 59, 105, 36);
		frame.getContentPane().add(lblNota);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 70, 66, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblComentrio = new JLabel("Comentário:");
		lblComentrio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblComentrio.setBounds(165, 101, 130, 36);
		frame.getContentPane().add(lblComentrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 137, 399, 81);
		textArea.setBorder(new LineBorder(null));
		frame.getContentPane().add(textArea);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
