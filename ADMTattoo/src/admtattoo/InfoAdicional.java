package admtattoo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class InfoAdicional extends javax.swing.JFrame {

    Agenda a = new Agenda();
    Comissao c = new Comissao();
    AgendaDAO aDAO = new AgendaDAO();
    AgendaDTO aDTO = new AgendaDTO();
    ConexaoJDBC cjdbc = new ConexaoJDBC();

    private int id;
    private int idSelecionado;
    private int idFuncionario;
    private int idCliente;
    private double value;

    public InfoAdicional() {
        initComponents();
        carregarDados();
        contadorDeCaracteres();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    public InfoAdicional(Agenda a) {
        initComponents();
        this.a = a;
        this.idCliente = a.getIdCliente();
        this.value = value;
        carregarDados();
        contadorDeCaracteres();
        exibeValor();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    public InfoAdicional(int id, int idFuncionario) {
        this.id = id; // id do último agendamento
        a = AgendaDAO.buscarPorId(id); // <- busca completa o objeto com cliente/funcionário
        if (a != null) {
            this.idCliente = a.getIdCliente();
            this.idFuncionario = idFuncionario;
        }
        initComponents();
        carregarDados();
        contadorDeCaracteres();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAtendido = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LabelCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxNSessao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxDuracao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ComboBoxPorcento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaNota = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        LabelFuncionario = new javax.swing.JLabel();
        LabelContador = new javax.swing.JLabel();
        LabelErro = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Informações adicionais");

        TableAtendido.setModel(new javax.swing.table.DefaultTableModel(
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
        TableAtendido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableAtendidoFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(TableAtendido);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        LabelCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelCliente.setText(a.getCliente());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Atendimento/Sessão N°:");

        ComboBoxNSessao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxNSessao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Duração do atendimento:");

        ComboBoxDuracao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxDuracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45", "24:00" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Porcentagem de comissão:");

        ComboBoxPorcento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxPorcento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Anotações:");

        TextAreaNota.setColumns(20);
        TextAreaNota.setLineWrap(true);
        TextAreaNota.setRows(5);
        TextAreaNota.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TextAreaNota);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Funcionário:");

        LabelFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelFuncionario.setText(a.getFuncionario()
        );

        LabelContador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelContador.setText("Limite de caracteres : 0/255");

        LabelErro.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelContador)
                .addGap(250, 250, 250))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxPorcento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxNSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelFuncionario)))
                        .addGap(129, 129, 129)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelFuncionario))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxNSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ComboBoxDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ComboBoxPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelErro)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LabelContador)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ButtonSalvar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(ButtonSalvar)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        salvarInfoExtra();
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void TableAtendidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableAtendidoFocusGained
        TableAtendido.setModel(montarTabelaUltimoCadastro());// pega o cadastro recém salvo para adicionar informações
        selecionarPrimeiraLinha(TableAtendido);
        idSelecionado = getIdLinhaSelecionada(TableAtendido); // pega o ID da linha selecionada
        System.out.println("ID selecionado: " + idSelecionado);
        exibeValor();
    }//GEN-LAST:event_TableAtendidoFocusGained

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
            java.util.logging.Logger.getLogger(InfoAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoAdicional().setVisible(true);
            }
        });
    }

    public DefaultTableModel montarTabelaUltimoCadastro() {
        String[] colunas = {
            "idAgenda", "idCliente", "idFuncionario", "data",
            "hora", "tipoServico", "valor"
        };

        DefaultTableModel tabela = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Double.class : String.class; // Coluna "valor" como Double
            }
        };

        ArrayList<AgendaDTO> lista = AgendaDAO.listarUltimoCadastro();

        for (AgendaDTO a : lista) {
            // Carrega participante principal
            Participante participante = AgendaDAO.carregarParticipante(a.getIdAgenda(), a.getIdFuncionario());
            String tipoServico = participante != null ? participante.getTipoServico() : "Indefinido";

            tabela.addRow(new Object[]{
                a.getIdAgenda(),
                a.getIdCliente(),
                a.getIdFuncionario(),
                a.getData(),
                a.getHora(),
                tipoServico,
                a.getValor()
            });

            value = a.getValor(); //salva no atributo global  
            LabelErro.setHorizontalAlignment(SwingConstants.CENTER);
            LabelErro.setVerticalAlignment(SwingConstants.CENTER);
            LabelErro.setText("Valor recebido: R$:" + (String.valueOf(value)));
        }
        return tabela;
    }

    private boolean confirmaValor() {
        try {
            double valor = Double.parseDouble(LabelErro.getText().replaceAll("[^\\d.]+", ""));
            value = valor;
            return valor != 0.0;
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter para double: " + e.getMessage());
            return false;
        }
    }

    public void exibeValor() {
        try {
            if (!confirmaValor()) {
                ComboBoxPorcento.setEnabled(false);
                ComboBoxPorcento.removeAllItems();
                ComboBoxPorcento.addItem("0");
                ComboBoxPorcento.setSelectedItem("0");
                LabelErro.setHorizontalAlignment(SwingConstants.CENTER);
                LabelErro.setVerticalAlignment(SwingConstants.CENTER);
                LabelErro.setForeground(Color.RED);
                LabelErro.setText("Se o valor é R$0, a comissão é 0%");
            } else {
                ComboBoxPorcento.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir valor" + e);
        }
    }

    public void selecionarPrimeiraLinha(JTable tabela) {
        if (tabela.getRowCount() > 0) {
            // Seleciona a primeira linha da tabela automaticamente
            tabela.setRowSelectionInterval(0, 0);

            // Garante que a linha esteja visível, caso a tabela tenha scroll
            tabela.scrollRectToVisible(tabela.getCellRect(0, 0, true));
        }
    }
// Pega o ID da linha automaticamente

    public int getIdLinhaSelecionada(JTable tabela) {
        int id = -1; // Valor padrão caso nada esteja selecionado

        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada != -1) {
            // Considera que a coluna 0 contém o ID
            Object linha = tabela.getValueAt(linhaSelecionada, 0);

            if (linha != null) {
                try {
                    id = Integer.parseInt(linha.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter ID para inteiro: " + e.getMessage());
                }
            }
        }
        return id;
    }

    // Método para selecionar a linha com ID específico
    public void selecionarLinhaPorId(JTable tabela, int idSelecionado) {
        for (int i = 0; i < tabela.getRowCount(); i++) {
            Object linha = tabela.getValueAt(i, 0); // Supondo ID na coluna 0
            if (linha != null && Integer.parseInt(linha.toString()) == idSelecionado) {
                tabela.setRowSelectionInterval(i, i);
                tabela.scrollRectToVisible(tabela.getCellRect(i, 0, true));
                break;
            }
        }
    }

    private void carregarDados() {

        CadastroDAO cDAO = new CadastroDAO();
        Cadastro cadastro = cDAO.buscarNomePeloId(idCliente);
        Cadastro cadastroFuncionario = cDAO.buscarNomePeloId(idFuncionario);
        System.out.println("ID Cliente: " + idCliente + "\nID Funcionario: " + idFuncionario + "\nVALOR COLETADO :" + value);

        if (cadastro == null) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado para o ID: " + idCliente + cadastro + ",\nNem funcionário para o id: " + idFuncionario + cadastroFuncionario,
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe o método se o cadastro não for encontrado
        }
// Preenche os campos com os dados do agendamento
        String nomeCliente = cadastro.getNome();
        String nomeFuncionario = cadastroFuncionario.getNome();

        LabelFuncionario.setText(nomeFuncionario);
        LabelCliente.setText(nomeCliente);
    }

    private void contadorDeCaracteres() {
        TextAreaNota.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            int limite = 255;

            public void atualizarContador() {
                int total = TextAreaNota.getText().length();
                LabelContador.setText("Limite de caracteres: " + total + "/" + limite);

                if (total > limite) {
                    LabelContador.setForeground(Color.RED);
                } else {
                    LabelContador.setForeground(Color.BLACK);
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContador();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContador();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContador();
            }
        });
    }

    private void salvarInfoExtra() {
        Informacao i = new Informacao();

        i.setIdAgenda(idSelecionado);

        String sessao = ComboBoxNSessao.getSelectedItem().toString();
        i.setSessao("Selecione".equalsIgnoreCase(sessao) ? 0 : Integer.parseInt(sessao));

        String duracao = ComboBoxDuracao.getSelectedItem().toString();
        i.setDuracao("Selecione".equalsIgnoreCase(duracao) ? "" : duracao);

        i.setNota(TextAreaNota.getText());

        if (InfoDAO.adicionarInfo(i)) {
            System.out.println("Informações adicionadas com sucesso");
        } else {
            System.err.println("Não foi possível salvar informações");
        }
        salvarComissao();
    }

    private void salvarComissao() {
        try {
            Comissao com = new Comissao();

            if (!ComissaoUtils.definirPorcentagem(com, ComboBoxPorcento, a.getStatus(), value, value, this)) {
                return;
            }

            com.setIdAgenda(this.id);
            com.setIdProfissional(this.idFuncionario);
            com.setValor(value);

            if (ComissaoDAO.existeComissao(this.id, this.idFuncionario)) {
                ComissaoDAO.atualizarValores(com);
            } else {
                ComissaoDAO.inserirComissao(com);
            }
            JOptionPane.showMessageDialog(this, "Informações salvas com sucesso!");
            dispose();

        } catch (Exception e) {
            System.err.println("Erro ao salvar comissão : " + e);
        }
    }

    private void adicionarConfirmacaoDeSaida() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        InfoAdicional.this,
                        "Fechar a tela, irá perder informações importantes como: Comissão e informações extras\nDeseja salvar as alterações antes de sair?",
                        "Confirmar saída",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resposta == JOptionPane.YES_OPTION) {
                    salvarInfoExtra();
                    dispose();
                } else if (resposta == JOptionPane.NO_OPTION) {
                    dispose();
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JComboBox<String> ComboBoxDuracao;
    private javax.swing.JComboBox<String> ComboBoxNSessao;
    private javax.swing.JComboBox<String> ComboBoxPorcento;
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelContador;
    private javax.swing.JLabel LabelErro;
    private javax.swing.JLabel LabelFuncionario;
    private javax.swing.JTable TableAtendido;
    private javax.swing.JTextArea TextAreaNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
