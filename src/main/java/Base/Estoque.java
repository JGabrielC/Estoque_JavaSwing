package Base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Estoque extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Tblist;
    private DefaultTableModel Tblista;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Estoque frame = new Estoque();
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
    public Estoque() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 664, 348);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel(new BorderLayout());
        contentPane.add(buttonPanel, BorderLayout.NORTH); // botao superior

        JButton Btatualizar = new JButton("Atualizar");
        buttonPanel.add(Btatualizar, BorderLayout.WEST); // botao esquerdo

        JButton Bteditar = new JButton("Editar");
        buttonPanel.add(Bteditar, BorderLayout.EAST); // botao direito

        Tblista = new DefaultTableModel();
        Tblist = new JTable(Tblista);
        JScrollPane scrollPane = new JScrollPane(Tblist);
        contentPane.add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao centro

        Tblist.setRowHeight(30); // Altere este valor conforme necessário

        // Renderizador de células personalizado para alternar as cores das linhas
        Tblist.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE); // Cor da linha par
                } else {
                    c.setBackground(Color.LIGHT_GRAY); // Cor da linha ímpar
                }
                return c;
            }
        });

        Btatualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });

        // Carrega os dados da tabela ao iniciar o frame
        carregarTabela();
    }

    // Método para carregar os dados da tabela a partir do banco de dados
    private void carregarTabela() {
        try (Connection con = ConectionFabric.getConection(); Statement stmt = con.createStatement();) {
            String sql = "select * from produtos";
            ResultSet rs = stmt.executeQuery(sql);

            // Limpa o modelo da tabela
            Tblista.setRowCount(0);
            Tblista.setColumnCount(0);

            // Adiciona as colunas ao modelo da tabela
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                Tblista.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Preenche as linhas da tabela com os dados do ResultSet
            while (rs.next()) {
                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                Tblista.addRow(row);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produto" + ex.getMessage());
        }
    }

    // Método para atualizar a tabela
    private void atualizarTabela() {
        carregarTabela(); // Recarrega os dados da tabela
    }
}