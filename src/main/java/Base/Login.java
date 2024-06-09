package Base;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Txtnome;
	private JTextField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Btlogin = new JButton("Login");
		Btlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checklogin(Txtnome.getText(), txtsenha.getText())) {
					JOptionPane.showMessageDialog(null, "Bem vindo ");
					Tabela_produtos tabela = new Tabela_produtos();
							tabela.setVisible(true);
							dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Nome ou senha invalidos");
				}
			}
		});
		Btlogin.setBounds(178, 197, 89, 23);
		contentPane.add(Btlogin);
		
		JLabel lblNewLabel = new JLabel("Loja de Informatica");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 146, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Area de Acesso");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(37, 36, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		Txtnome = new JTextField();
		Txtnome.setBounds(147, 88, 146, 20);
		contentPane.add(Txtnome);
		Txtnome.setColumns(10);
		
		txtsenha = new JTextField();
		txtsenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                	if(Checklogin(Txtnome.getText(), txtsenha.getText())) {
    					JOptionPane.showMessageDialog(null, "Bem vindo ");
    					Tabela_produtos tabela = new Tabela_produtos();
    							tabela.setVisible(true);
    							dispose();
    				}else {
    					JOptionPane.showMessageDialog(null, "Nome ou senha invalidos");
    				}
                }
				
			}
		});
		txtsenha.setBounds(147, 142, 146, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		JLabel Lbnome = new JLabel("Nome");
		Lbnome.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Lbnome.setBounds(63, 94, 46, 14);
		contentPane.add(Lbnome);
		
		JLabel Lbsenha = new JLabel("Senha");
		Lbsenha.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Lbsenha.setBounds(63, 148, 46, 14);
		contentPane.add(Lbsenha);
		
		
	}
	
	public boolean Checklogin(String login, String senha) {
		if (login.equals("emanuel") && senha.equals("123")) {
	        return true;
	    } else if (login.equals("Jhon") && senha.equals("1420")) {
	        return true;
	    } else if (login.equals("samuel") && senha.equals("789")) {
	        return true;
	    // Adicione mais verificações conforme necessário
		}else {
	        return false;
	    }
	}
	
}
