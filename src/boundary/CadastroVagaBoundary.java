package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;

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


public class CadastroVagaBoundary {

	private JFrame frame;
	private JTextField txtNomeVaga;
	private JTextField txtCargaHoraria;
	private JLabel lblCargaHorria;
	private JLabel lblNomeVaga;
	private JLabel lblResquisitosObrigatrios;
	private JTextArea textArea;
	private JTextField txtObrigatorio;
	private JTextField txtDesejaveis;
	private JButton btnAdd;
	
	//Inicio table básico, apenas para visualização
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
    
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVagaBoundary window = new CadastroVagaBoundary();
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
	public CadastroVagaBoundary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNomeVaga = new JTextField();
		txtNomeVaga.setBounds(165, 25, 217, 20);
		frame.getContentPane().add(txtNomeVaga);
		txtNomeVaga.setColumns(10);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(563, 25, 233, 20);
		frame.getContentPane().add(txtCargaHoraria);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setBounds(398, 528, 183, 36);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel lblConfirmarSenha = new JLabel("Descri\u00E7\u00E3o");
		lblConfirmarSenha.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(10, 80, 121, 31);
		frame.getContentPane().add(lblConfirmarSenha);
		
		lblCargaHorria = new JLabel("Carga hor\u00E1ria:");
		lblCargaHorria.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCargaHorria.setBounds(398, 17, 155, 31);
		frame.getContentPane().add(lblCargaHorria);
		
		lblNomeVaga = new JLabel("Nome da vaga:");
		lblNomeVaga.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNomeVaga.setBounds(10, 17, 155, 31);
		frame.getContentPane().add(lblNomeVaga);
		
		lblResquisitosObrigatrios = new JLabel("Resquisitos Obrigat\u00F3rios:");
		lblResquisitosObrigatrios.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblResquisitosObrigatrios.setBounds(21, 260, 260, 31);
		frame.getContentPane().add(lblResquisitosObrigatrios);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(186, 420, 73, -7);
		frame.getContentPane().add(horizontalStrut);
		
		JLabel lblResquisitosDesejveis = new JLabel("Resquisitos Desej\u00E1veis:");
		lblResquisitosDesejveis.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblResquisitosDesejveis.setBounds(462, 260, 334, 31);
		frame.getContentPane().add(lblResquisitosDesejveis);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(613, 528, 183, 36);
		frame.getContentPane().add(btnCancelar);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 113, 786, 110);
		textArea.setBorder(new LineBorder(null));
		frame.getContentPane().add(textArea);
		
		txtObrigatorio = new JTextField();
		txtObrigatorio.setBounds(25, 325, 256, 20);
		frame.getContentPane().add(txtObrigatorio);
		txtObrigatorio.setColumns(10);
		
		JButton button = new JButton("+");
		button.setBackground(Color.GREEN);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Black", Font.PLAIN, 27));
		button.setBounds(304, 325, 52, 20);
		frame.getContentPane().add(button);
		
		txtDesejaveis = new JTextField();
		txtDesejaveis.setColumns(10);
		txtDesejaveis.setBounds(453, 325, 256, 20);
		frame.getContentPane().add(txtDesejaveis);
		
		btnAdd = new JButton("+");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial Black", Font.PLAIN, 27));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBounds(732, 325, 52, 20);
		frame.getContentPane().add(btnAdd);
		
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(25, 380, 256, 120);
        frame.getContentPane().add(barraRolagem);
       
	}
}
