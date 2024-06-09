package Base;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Txtnome;
	private JTextField Txtmodelo;
	private JTextField Txtobs;
	private JTextField Txtvalor;
	private JTextField Txtquantidade;
	public JTextField Nmlst;
	static String Nmls;
	static ArrayList<String> data = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public  Cadastro() {

	
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lbtxt = new JLabel("Cadastro de Produtos Novos");
		Lbtxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Lbtxt.setBounds(27, 11, 204, 14);
		contentPane.add(Lbtxt);
		
		JLabel Lbcategoria = new JLabel("Categoria do Produto");
		Lbcategoria.setForeground(Color.WHITE);
		Lbcategoria.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Lbcategoria.setBounds(26, 36, 128, 14);
		contentPane.add(Lbcategoria);
		
		JLabel Lbnome = new JLabel("Nome do Produto");
		Lbnome.setForeground(Color.WHITE);
		Lbnome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Lbnome.setBounds(27, 141, 108, 14);
		contentPane.add(Lbnome);
		
		Txtnome = new JTextField();
		Txtnome.setBounds(20, 171, 196, 20);
		contentPane.add(Txtnome);
		Txtnome.setColumns(10);
		
		JLabel Lbmodelo = new JLabel("Modelo");
		Lbmodelo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Lbmodelo.setForeground(Color.WHITE);
		Lbmodelo.setBounds(27, 202, 108, 14);
		contentPane.add(Lbmodelo);
		
		Txtmodelo = new JTextField();
		Txtmodelo.setBounds(20, 227, 196, 20);
		contentPane.add(Txtmodelo);
		Txtmodelo.setColumns(10);
		
		JLabel Lbobs = new JLabel("Observação");
		Lbobs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Lbobs.setForeground(Color.WHITE);
		Lbobs.setBounds(27, 269, 108, 14);
		contentPane.add(Lbobs);
		
		Txtobs = new JTextField();
		Txtobs.setBounds(20, 294, 196, 20);
		contentPane.add(Txtobs);
		Txtobs.setColumns(10);
		
		JLabel Lbvalor = new JLabel("Valor de Custo");
		Lbvalor.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Lbvalor.setForeground(Color.WHITE);
		Lbvalor.setBounds(367, 36, 98, 14);
		contentPane.add(Lbvalor);
		
		Txtvalor = new JTextField();
		Txtvalor.setBounds(358, 61, 121, 20);
		contentPane.add(Txtvalor);
		Txtvalor.setColumns(10);
		
		//JTextField Nmlst = new JTextField();
		//Nmlst.setBounds(184, 61, 47, 17);
		//contentPane.add(Nmlst);
		
		JLabel Lbquantidade = new JLabel("Quantidade comprado");
		Lbquantidade.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Lbquantidade.setForeground(Color.WHITE);
		Lbquantidade.setBounds(358, 141, 128, 14);
		contentPane.add(Lbquantidade);
		
		Txtquantidade = new JTextField();
		Txtquantidade.setBounds(358, 171, 121, 20);
		contentPane.add(Txtquantidade);
		Txtquantidade.setColumns(10);
		
		final JLabel Lbfiltro = new JLabel("Selecione*");
		Lbfiltro.setForeground(Color.WHITE);
		Lbfiltro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Lbfiltro.setBackground(Color.WHITE);
		Lbfiltro.setBounds(27, 61, 156, 20);
		contentPane.add(Lbfiltro);
		
		JButton Btlista = new JButton("lista de categorias");
		Btlista.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
				

				
                // Dados para o JList
				carregarTabela();
				//System.out.print(data);
                //String[] data = {"capinha", "pelicula", "fone com fio", "fone sem fio", "fonte carregador", "cabo", "teclado", "mouse", "controle"};
				Object[] dat = data.toArray(new String[data.size()]); 
                // Cria o JList com os dados
                JList<Object> list = new JList<Object>(dat);
				

                // Adiciona o JList a um JScrollPane (para scroll, se necessário)
                JScrollPane scrollPane = new JScrollPane(list);
                scrollPane.setPreferredSize(new Dimension(200, 100));
                
                

                // Cria um novo JFrame ou JDialog para mostrar a lista
                final JFrame Listfiltro = new JFrame("Lista de categorias");
                list.addMouseListener((MouseListener) new MouseAdapter() {
        			public void mouseClicked(MouseEvent evt) {
						JList list = (JList)evt.getSource();
        				if(evt.getClickCount() >= 2) {
        					String selected  = (String) list.getSelectedValue();
                            if (selected != null) {

                            	Lbfiltro.setText(selected);		

								getnml(selected);                            	
                            
                            } else {
                            	Lbfiltro.setText("Nenhum item selecionado");
                            }
        					System.out.println(selected);
        					System.out.println(Nmlst.getText());
        					Listfiltro.dispose();
        				}
        			}
        		});
                
                // Adiciona um botão para confirmar a seleção
                JButton selectButton = new JButton("Selecionar");
                Listfiltro.getContentPane().add(selectButton, BorderLayout.SOUTH);

                // ActionListener para o botão de seleção
                selectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Obtém o item selecionado
                        Object selectedItem = list.getSelectedValue();

                        // Atualiza o JLabel com o item selecionado
                        if (selectedItem != null) {
                        	Lbfiltro.setText(selectedItem.toString());
                        } else {
                        	Lbfiltro.setText("Nenhum item selecionado");
                        }

                        // Fecha o JFrame da lista
                        Listfiltro.dispose();
                    }
                });
				

                Listfiltro.setSize(400, 300);
                Listfiltro.getContentPane().add(scrollPane);
                Listfiltro.setLocationRelativeTo(null); // Centraliza na tela
                Listfiltro.setVisible(true);
                
            }
        });
		Btlista.setBounds(37, 94, 142, 23);
		contentPane.add(Btlista);
		
		JButton Btcadastro = new JButton("cadastrar");
		Btcadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btlist = Lbfiltro.getText();
				System.out.println(Btlist);
				sqlCadastro cadastro = new sqlCadastro();
				
				String nome = Txtnome.getText();
				String numerolist = Nmlst.getText();
				String modelo = Txtmodelo.getText();
				String Obeservacao = Txtobs.getText();
				String preco = Txtvalor.getText();
				String quantidade = Txtquantidade.getText();
				Produtos Novaproduto= new Produtos(1, nome, modelo, Obeservacao, Integer.parseInt(numerolist), Float.parseFloat(preco), Integer.parseInt(quantidade));
				
				cadastro.Adicionarproduto(Novaproduto);
				cadastro.Listaprodutos();
			}
		});
		Btcadastro.setBounds(376, 266, 108, 23);
		contentPane.add(Btcadastro);
		
	}




	private void carregarTabela() {
        try (Connection con = ConectionFabric.getConection(); Statement stmt = con.createStatement();) {
            String sql = "SELECT * from categoria";
             ResultSet rs = stmt.executeQuery(sql);
			 data.clear();
			 while (rs.next()) {
				data.add(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produto" + ex.getMessage());
        }
    }

	
	public JTextField getnml(String Name) {
		
        try (Connection con = ConectionFabric.getConection(); Statement stmt = con.createStatement();) {
            String sql = "SELECT CategoryCod from categoria where Names = '" + Name + "';";
             ResultSet rs = stmt.executeQuery(sql);
			 JTextField Nmlst = new JTextField();
			 Nmlst.setBounds(184, 61, 47, 17);
			 contentPane.add(Nmlst);
			 while (rs.next()) {
				Nmls= (rs.getObject(1).toString());
				
				Nmlst.setText(Nmls);
				
				
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produto" + ex.getMessage());
        }
		return Nmlst;
    }
	
}
