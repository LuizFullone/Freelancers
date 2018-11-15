package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class SolicitacaoBoundary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitacaoBoundary window = new SolicitacaoBoundary();
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
	public SolicitacaoBoundary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Solicitações");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de Solicitação:");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTipo.setBounds(10, 11, 414, 36);
		frame.getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 70, 414, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblComentrio = new JLabel("Comentário:");
		lblComentrio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblComentrio.setBounds(165, 101, 130, 36);
		frame.getContentPane().add(lblComentrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 137, 399, 81);
		textArea.setBorder(new LineBorder(null));
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("Enviar");
		button.setFont(new Font("Arial Black", Font.PLAIN, 11));
		button.setBounds(212, 241, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		button_1.setBounds(320, 241, 89, 23);
		frame.getContentPane().add(button_1);
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
