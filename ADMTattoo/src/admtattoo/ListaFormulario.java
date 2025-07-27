package admtattoo;

import admtattoo.ListaCadastro.OrigemChamada;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListaFormulario extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;

    public ListaFormulario() {
        initComponents();
        TextFieldId.setEditable(false);
        TextFieldId.setText("ID");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        atualizarTabela();
    }

    public ListaFormulario(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        initComponents();
        TextFieldId.setEditable(false);
        TextFieldId.setText("ID");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableFormulario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ButtonVisualizar = new javax.swing.JButton();
        ButtonExcluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TextFieldId = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();
        ButtonTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Lista de formulários");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableFormulario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableFormulario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableFormularioFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TableFormulario);

        ButtonVisualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonVisualizar.setText("Visualizar");
        ButtonVisualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVisualizarActionPerformed(evt);
            }
        });

        ButtonExcluir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonExcluir.setText("Excluir");
        ButtonExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(ButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Selecione o cadastro:");

        TextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldId.setText("ID");

        ButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonBuscar.setText("Buscar");
        ButtonBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        ButtonTodos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonTodos.setText("Listar todos");
        ButtonTodos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ButtonTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(310, 310, 310))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButtonTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
//       identifica que a chamada vem de ListaFormulario
        new ListaCadastro(funcionarioLogado, this, OrigemChamada.ListaFormulario).setVisible(true);
        configurarTabela();
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void TableFormularioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableFormularioFocusGained
//        TableFormulario.setModel(montarTabela());
//        jScrollPane1.setViewportView(TableFormulario);
    }//GEN-LAST:event_TableFormularioFocusGained

    private void ButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVisualizarActionPerformed
        abreVisualizacao();
    }//GEN-LAST:event_ButtonVisualizarActionPerformed

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed
        try {
            int id = getPosicao();
            if (id == -1) {
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir este formulário ?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                boolean sucesso = FormResponsaDAO.excluir(id);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Formulário excluído com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao excluir formulário.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao tentar excluir formulário: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonExcluirActionPerformed

    private void ButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTodosActionPerformed
        TextFieldId.setText("ID");
        atualizarTabela();
    }//GEN-LAST:event_ButtonTodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFormulario().setVisible(true);
            }
        });
    }

    private DefaultTableModel montarTabela() {
        String[] colunas = {"id", "idCliente", "Titulo", "Cabeçalho", "Questionario", "Cidade", "Empresa", "Rodapé"};
        return new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Integer.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void preencherTabela(List<FormResponsa> listaFormularios) {
        DefaultTableModel model = montarTabela();

        for (FormResponsa f : listaFormularios) {
            model.addRow(new Object[]{
                f.getId(),
                f.getIdCliente(),
                f.getTitulo(),
                f.getCabecalho(),
                f.getQuestionario(),
                f.getCidade(),
                f.getEmpresa(),
                f.getRodape()
            });
        }

        TableFormulario.setModel(model);
        configurarTabela();
    }

    public void atualizarTabela() {
        try {
            List<FormResponsa> todosFormularios = FormResponsaDAO.listarTodos();
            preencherTabela(todosFormularios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar formulários: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void setIdSelecionado(int id) {
        TextFieldId.setText(String.valueOf(id));
        TextFieldId.requestFocus();

        List<FormResponsa> listaFiltrada = FormResponsaDAO.listarFormularioID(id);

        if (listaFiltrada == null || listaFiltrada.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum relatório para este ID.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            TextFieldId.setText("ID");
            atualizarTabela(); // Volta para a lista completa
        } else {
            preencherTabela(listaFiltrada); // método central para atualizar a tabela
        }
    }

    public int getPosicao() {
        int selectedRow = TableFormulario.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum formulário selecionado. Por favor, selecione um na tabela.",
                    "Seleção Necessária", JOptionPane.WARNING_MESSAGE);
            return -1;
        }

        try {
            Object valorId = TableFormulario.getValueAt(selectedRow, 0);
            return Integer.parseInt(valorId.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao obter ID do formulário: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void filtrarFormulariosPorCliente(int idCliente) {
        try {
            List<FormResponsa> listaFiltrada = FormResponsaDAO.listarFormularioID(idCliente);
            preencherTabela(listaFiltrada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao filtrar formulários: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void configurarTabela() {
        // Configuração básica da tabela
        TableFormulario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableFormulario.setRowSelectionAllowed(true);
        TableFormulario.setColumnSelectionAllowed(false);
        TableFormulario.setShowGrid(true);
        TableFormulario.setGridColor(Color.LIGHT_GRAY);

        // Configuração visual da seleção
        TableFormulario.setSelectionBackground(new Color(0, 120, 215));
        TableFormulario.setSelectionForeground(Color.WHITE);

        // Renderizador personalizado para melhor visualização
        TableFormulario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground());
                } else {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
// Listener para clique do mouse na tabela
        TableFormulario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = TableFormulario.rowAtPoint(e.getPoint());

                // Ignora cliques fora da tabela
                if (row < 0) {
                    return;
                }

                // Clique duplo: abrir visualização
                if (e.getClickCount() == 2) {
                    abreVisualizacao();
                }

            }
        });
    }

    public void abreVisualizacao() {
        int idForm = getPosicao();

        if (idForm == -1) {
            // A própria função getPosicao() já mostra a mensagem de erro
            return;
        }

        // Abrir TelaFormResponsa e passar o ID do formulário
        TelaFormResponsa tela = new TelaFormResponsa();
        tela.carregarFormulario(idForm);
        tela.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JButton ButtonTodos;
    private javax.swing.JButton ButtonVisualizar;
    private javax.swing.JTable TableFormulario;
    private javax.swing.JTextField TextFieldId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
