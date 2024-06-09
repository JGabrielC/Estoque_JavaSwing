package Base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabela_produtos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabela_produtos frame = new Tabela_produtos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabela_produtos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 681, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 79, 20);
		panel.add(lblNewLabel);
		
		JButton Btcadastro = new JButton("Cadastro");
		Btcadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro=new Cadastro();
				cadastro.setVisible(true);
				cadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		Btcadastro.setBounds(384, 8, 89, 23);
		panel.add(Btcadastro);
		
		JButton btnNewButton_1 = new JButton("Estoque");
		btnNewButton_1.setBounds(483, 8, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton Btcontas = new JButton("Contas");
		Btcontas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contas contas=new Contas();
				contas.setVisible(true);
			}
		});
		Btcontas.setBounds(582, 8, 89, 23);
		panel.add(Btcontas);
		
		JButton Btsair = new JButton("Finalizar");
		Btsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Btsair.setBounds(592, 323, 89, 23);
		contentPane.add(Btsair);
		
	}
	
}

