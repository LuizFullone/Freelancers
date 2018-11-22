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

public class AvaliarEmpresaBoundary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvaliarEmpresaBoundary window = new AvaliarEmpresaBoundary();
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
	public AvaliarEmpresaBoundary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String nome_empresa = "Microsoft";
		frame = new JFrame("Avaliar empresa");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAval = new JLabel("Empresa: "+ nome_empresa);
		lblAval.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblAval.setBounds(41, 11, 383, 36);
		frame.getContentPane().add(lblAval);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNota.setBounds(41, 59, 105, 36);
		frame.getContentPane().add(lblNota);
		
		JComboBox comboBox = new JComboBox<Object>() ;
		comboBox.setFont(new java.awt.Font("Dialog", 1, 16));
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String [] { "1","2","3","4","5"}));
		comboBox.setBounds(104, 70, 70, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel lblComentrio = new JLabel("Comentário:");
		lblComentrio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblComentrio.setBounds(165, 101, 130, 36);

		frame.getContentPane().add(lblComentrio);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 137, 399, 81);
		textArea.setBorder(new LineBorder(null));
		frame.getContentPane().add(textArea);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnEnviar.setBounds(227, 255, 89, 23);
		frame.getContentPane().add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCancelar.setBounds(335, 255, 89, 23);
		frame.getContentPane().add(btnCancelar);
		frame.setBounds(100, 100, 450, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
