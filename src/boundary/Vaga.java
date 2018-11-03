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
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;


public class Vaga {

	private JFrame frame;
	private JLabel lblCargaHorria;
	private JLabel lblNomeVaga;
	private JLabel lblResquisitosObrigatrios;
	private JTextArea textArea;
	
	//Inicio table básico
    private JTable tabela;
    private JScrollPane barraRolagem;    
    Object [][] dados = {
        {"Java"},
        {"sql"},
        {"UML"},
        {"html"},
        {"css"},
        {"angular"},
        {"java web"},
        {"Lógica de programação"},
        {"Inglês monstrão"}
    };
     
    String [] colunas = {"Requisitos básicos"}; 
    //Fim da tabela
    
  //Inicio table Desejavel
    private JTable tabela_desejavel;
    private JScrollPane barraDesejavel;    
    Object [][] dadosDesejavel = {
        {"Java Script"},
        {"Banco de dados Oracle"},
        
    };
     
    String [] colunasDesejavel = {"Requisitos básicos"}; 
    //Fim da tabela
    
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaga window = new Vaga();
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
	public Vaga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String nomeVaga = " Desenvolvedor back java"; 
		String CargaHoraria = " 240h";
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnCadastrar = new JButton("< Rejeitar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCadastrar.setBackground(Color.RED);
		btnCadastrar.setBounds(21, 497, 183, 36);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel lblConfirmarSenha = new JLabel("Descrição");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(10, 97, 121, 31);
		frame.getContentPane().add(lblConfirmarSenha);
		
		lblCargaHorria = new JLabel("Carga horária: "+ CargaHoraria);
		lblCargaHorria.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCargaHorria.setBounds(10, 59, 416, 31);
		frame.getContentPane().add(lblCargaHorria);
		
		lblNomeVaga = new JLabel("Nome da vaga: " + nomeVaga);
		lblNomeVaga.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNomeVaga.setBounds(10, 17, 786, 31);
		frame.getContentPane().add(lblNomeVaga);
		
		lblResquisitosObrigatrios = new JLabel("Resquisitos Obrigatórios:");
		lblResquisitosObrigatrios.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblResquisitosObrigatrios.setBounds(21, 260, 260, 31);
		frame.getContentPane().add(lblResquisitosObrigatrios);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(186, 420, 73, -7);
		frame.getContentPane().add(horizontalStrut);
		
		JLabel lblResquisitosDesejveis = new JLabel("Resquisitos Desejáveis:");
		lblResquisitosDesejveis.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblResquisitosDesejveis.setBounds(462, 260, 334, 31);
		frame.getContentPane().add(lblResquisitosDesejveis);
		
		JButton btnCancelar = new JButton("Aceitar >");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCancelar.setBackground(Color.GREEN);
		btnCancelar.setBounds(613, 497, 183, 36);
		frame.getContentPane().add(btnCancelar);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 139, 786, 110);
		textArea.setBorder(new LineBorder(null));
		frame.getContentPane().add(textArea);
		
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(21, 309, 256, 120);
        frame.getContentPane().add(barraRolagem);
       
	}
}
