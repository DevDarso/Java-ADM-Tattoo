package admtattoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ListaInfo extends javax.swing.JFrame {

    private boolean carregandoCombos = true;
    private int id;

    public ListaInfo() {
    }

    public ListaInfo(int idCliente) {
        this.id = idCliente;
        initComponents();
        TableInfo.setModel(montarTabelaHistorico(idCliente));
        contarLinhasTabela();

        preencherCombosDataAtual(); // preenche os combos com a data mais antiga do banco

        ItemListener dateChangeListener = e -> {
            if (!carregandoCombos) {
                atualizarTabelaPorData();
            }
        };
        ComboAno.addItemListener(dateChangeListener);
        ComboMes.addItemListener(dateChangeListener);
        ComboDia.addItemListener(dateChangeListener);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        ComboDia = new javax.swing.JComboBox<>();
        ComboMes = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ButtonFiltro = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ButtonVisualizar = new javax.swing.JButton();
        ButtonExportar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        LabelErro = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Lista informe");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        TableInfo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableInfoFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TableInfo);

        ComboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Selecione o período:");

        ButtonFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonFiltro.setText("Aplicar filtro");
        ButtonFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ButtonFiltro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonVisualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonVisualizar.setText("Visualizar");
        ButtonVisualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVisualizarActionPerformed(evt);
            }
        });

        ButtonExportar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonExportar.setText("Exportar");
        ButtonExportar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(ButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(ButtonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVisualizar)
                    .addComponent(ButtonExportar))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        LabelErro.setText("jLabel3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelErro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableInfoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableInfoFocusGained
        TableInfo.setModel(montarTabelaHistorico(id));
        contarLinhasTabela();
    }//GEN-LAST:event_TableInfoFocusGained

    private void ButtonFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFiltroActionPerformed
        aplicarFiltroData();
    }//GEN-LAST:event_ButtonFiltroActionPerformed

    private void ButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVisualizarActionPerformed
        int id = getPosicao();
        InfoDAO iDAO = new InfoDAO();
        AgendaDAO aDAO = new AgendaDAO();

        List<Informacao> informacoes = iDAO.buscarInfoPeloIdAgenda(id);

        if (informacoes.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma informação disponível para este agendamento");
            return;
        }

        Informacao primeira = informacoes.get(0);
        String obs = primeira.getObservacao();
        boolean temObs = obs != null && !obs.trim().isEmpty();

        Agenda agenda = aDAO.buscarSituacaoPeloId(id);
        if (agenda == null) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao obter status do agendamento.");
            return;
        }

        String status = agenda.getStatus();

        if ("Agendado".equalsIgnoreCase(status) && !temObs) {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma informação disponível para este agendamento");
            return;
        }
        exibirInfoExtra(); // Chama tela apenas se passou pela verificação correta
    }//GEN-LAST:event_ButtonVisualizarActionPerformed

    private void ButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExportarActionPerformed
        salvarTextoParaTextArea();
        dispose();
    }//GEN-LAST:event_ButtonExportarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaInfo().setVisible(true);
            }
        });
    }

    private void aplicarFiltroData() {
        // Verifica se os combos têm seleção válida
        if (ComboAno.getSelectedIndex() == 0 || ComboMes.getSelectedIndex() == 0 || ComboDia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma data completa (dia, mês e ano).");
            return;
        }

        // Obtém os valores selecionados
        String ano = (String) ComboAno.getSelectedItem();
        String mes = (String) ComboMes.getSelectedItem();
        String dia = (String) ComboDia.getSelectedItem();

        try {
            // Cria a data inicial no formato yyyy-MM-dd
            LocalDate dataInicial = LocalDate.parse(String.format("%s-%s-%s", ano, mes, dia));
            LocalDate dataFinal = LocalDate.now(); // Data final sempre é hoje

            // Verifica se a data inicial é futura
            if (dataInicial.isAfter(dataFinal)) {
                JOptionPane.showMessageDialog(this, "A data inicial não pode ser futura.");
                return;
            }

            // Obtém o modelo original da tabela
            DefaultTableModel modeloOriginal = (DefaultTableModel) TableInfo.getModel();

            // Cria novo modelo filtrado
            DefaultTableModel modeloFiltrado = new DefaultTableModel(
                    new String[]{"idAgenda", "data", "hora", "Profissional", "tipoServico", "Informe"},
                    0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            // Formatter para datas no formato dd/MM/yyyy (como aparecem na tabela)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Filtra as linhas
            for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
                String dataTabelaStr = (String) modeloOriginal.getValueAt(i, 1);
                try {
                    LocalDate dataLinha = LocalDate.parse(dataTabelaStr, formatter);

                    // Verifica se a data está no intervalo (inicial ≤ linha ≤ final)
                    if ((dataLinha.isEqual(dataInicial) || dataLinha.isAfter(dataInicial))
                            && (dataLinha.isEqual(dataFinal) || dataLinha.isBefore(dataFinal))) {

                        // Copia a linha para o modelo filtrado
                        Object[] linha = new Object[modeloOriginal.getColumnCount()];
                        for (int j = 0; j < linha.length; j++) {
                            linha[j] = modeloOriginal.getValueAt(i, j);
                        }
                        modeloFiltrado.addRow(linha);
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Erro ao converter data da tabela: " + dataTabelaStr);
                }
            }

            // Aplica o modelo filtrado e atualiza a interface
            TableInfo.setModel(modeloFiltrado);
            TableInfo.revalidate();
            TableInfo.repaint();
            contarLinhasTabela();

            // Feedback para o usuário
            LabelErro.setText(String.format("Filtro aplicado: %s até %s (%d registros)",
                    dataInicial.format(formatter),
                    dataFinal.format(formatter),
                    modeloFiltrado.getRowCount()));

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Data inválida. Por favor, selecione valores válidos para dia, mês e ano.",
                    "Erro de Data", JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultTableModel montarTabelaHistorico(int id) {
        String[] colunas = {
            "idAgenda", "data", "hora", "Profissional", "tipoServico", "Informe"
        };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // Obtém os dados do banco
        List<Informacao> info;
        try {
            info = InfoDAO.buscarInfoPeloIdCliente(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar informações para este ID : " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return model;
        }
        if (info.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhuma informação encontrada para o ID :" + id,
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        // Preenche a tabela
        for (Informacao informacao : info) {
            model.addRow(new Object[]{
                informacao.getIdAgenda(),
                formatarDataString(informacao.getData()),
                informacao.getHora(),
                informacao.getNomeFuncionario(),
                informacao.getTipoServico(),
                informacao.getNota()
            });
        }
        return model;
    }

    private String formatarDataString(String dataString) {
        if (dataString == null || dataString.isEmpty()) {
            return "";
        }
        try {
            // Primeiro converte a String para LocalDate (se estiver em formato padrão ISO)
            LocalDate data = LocalDate.parse(dataString); // Formato ISO (yyyy-MM-dd)
            return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            // Se já estiver no formato dd/MM/yyyy, retorna direto
            return dataString;
        }
    }

    private int getPosicao() {
        int selectedRow = TableInfo.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum atendimento selecionado. Por favor, selecione um na tabela.",
                    "Seleção Necessária", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        try {
            Object valorId = TableInfo.getValueAt(selectedRow, 0);
            return Integer.parseInt(valorId.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao obter ID do atendimento: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void preencherCombosDataAtual() {
        InfoDAO infoDAO = new InfoDAO();

        // Busca datas reais para este cliente
        LocalDate dataMaisAntiga = infoDAO.buscarDataMaisAntiga(this.id);
        LocalDate dataMaisRecente = infoDAO.buscarDataMaisRecente(this.id);

        // Se não houver dados, usa data atual como fallback
        LocalDate hoje = LocalDate.now();
        LocalDate dataInicial = (dataMaisAntiga != null) ? dataMaisAntiga : hoje;
        LocalDate dataFinal = (dataMaisRecente != null) ? dataMaisRecente : hoje;

        int diaInicial = dataInicial.getDayOfMonth();
        int mesInicial = dataInicial.getMonthValue();
        int anoMinimo = dataInicial.getYear();
        int anoMaximo = dataFinal.getYear();

        carregandoCombos = true;
        ComboAno.removeAllItems();
        ComboAno.addItem("Ano");
        for (int a = anoMinimo; a <= anoMaximo; a++) {
            ComboAno.addItem(String.valueOf(a));
        }
        ComboAno.setSelectedItem(String.valueOf(dataInicial.getYear()));

        ComboMes.removeAllItems();
        ComboMes.addItem("Mês");
        for (int m = 1; m <= 12; m++) {
            ComboMes.addItem(String.format("%02d", m));
        }
        ComboMes.setSelectedItem(String.format("%02d", mesInicial));

        ComboDia.removeAllItems();
        ComboDia.addItem("Dia");
        for (int d = 1; d <= 31; d++) {
            ComboDia.addItem(String.format("%02d", d));
        }
        ComboDia.setSelectedItem(String.format("%02d", diaInicial));

        carregandoCombos = false; // FIM DO CARREGAMENTO
    }

    private void atualizarTabelaPorData() {
        // Verifica se todos os combos têm seleção válida
        if (ComboAno.getSelectedIndex() <= 0
                || ComboMes.getSelectedIndex() <= 0
                || ComboDia.getSelectedIndex() <= 0) {
            return;
        }

        try {
            String ano = (String) ComboAno.getSelectedItem();
            String mes = (String) ComboMes.getSelectedItem();
            String dia = (String) ComboDia.getSelectedItem();

            LocalDate dataSelecionada = LocalDate.parse(String.format("%s-%s-%s", ano, mes, dia));
            LocalDate dataAtual = LocalDate.now();

            // Verifica se a data selecionada é futura
            if (dataSelecionada.isAfter(dataAtual)) {
                JOptionPane.showMessageDialog(this, "Data não pode ser futura");
                return;
            }

            // Atualiza a tabela diretamente do banco com o filtro
            DefaultTableModel novoModelo = montarTabelaFiltrada(id, dataSelecionada, dataAtual);
            TableInfo.setModel(novoModelo);
            contarLinhasTabela();

        } catch (Exception e) {
            System.err.println("Erro ao atualizar tabela: " + e.getMessage());
        }
    }

    private DefaultTableModel montarTabelaFiltrada(int idCliente, LocalDate dataInicial, LocalDate dataFinal) {
        String[] colunas = {"idAgenda", "data", "hora", "Profissional", "tipoServico", "Informe"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            List<Informacao> info = InfoDAO.buscarInfoPorPeriodo(idCliente, dataInicial, dataFinal);

            for (Informacao informacao : info) {
                model.addRow(new Object[]{
                    informacao.getIdAgenda(),
                    formatarDataString(informacao.getData()),
                    informacao.getHora(),
                    informacao.getNomeFuncionario(),
                    informacao.getTipoServico(),
                    informacao.getNota()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + e.getMessage());
        }

        return model;
    }

    private void salvarTextoParaTextArea() {
        DefaultTableModel model = (DefaultTableModel) TableInfo.getModel();
        String linhaCompleta = "_".repeat(75);
        int rowCount = model.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum dado disponível para exportar.");
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(linhaCompleta + "\n");

        for (int i = 0; i < rowCount; i++) {
            String data = String.valueOf(model.getValueAt(i, 1));
            String hora = String.valueOf(model.getValueAt(i, 2));
            String profissional = String.valueOf(model.getValueAt(i, 3));
            String servico = String.valueOf(model.getValueAt(i, 4));
            String observacao = String.valueOf(model.getValueAt(i, 5));

            builder.append("Data: ").append(data)
                    .append(" | Hora: ").append(hora)
                    .append(" | Profissional: ").append(profissional).append("\n");
            builder.append("Serviço: ").append(servico).append("\n");
            builder.append("Observação: ").append(observacao).append("\n");
            builder.append(linhaCompleta + "\n");
        }
        String textoFinal = builder.toString();

        // Envia para TelaFormResponsa
        //Cria e configura a nova tela normalmente
        TelaFormResponsa tela = new TelaFormResponsa(this.id);
        tela.desativarCamposResponsavel();
        tela.setTextoNoFormulario(textoFinal);
        tela.setTituloHistorico("----- HISTÓRICO CLÍNICO -----");
        tela.setVisible(true);
    }

    private void contarLinhasTabela() {
        int totalLinhas = TableInfo.getRowCount();
        LabelErro.setHorizontalAlignment(SwingConstants.CENTER);
        LabelErro.setVerticalAlignment(SwingConstants.CENTER);
        LabelErro.setText("Total de registros : " + totalLinhas);

        if (totalLinhas == 0) {
            LabelErro.setText("Nenhum registro encontrado !");
            LabelErro.setForeground(Color.RED);
            LabelErro.setFont(LabelErro.getFont().deriveFont(Font.BOLD));

            ButtonVisualizar.setEnabled(false);
        } else {
            LabelErro.setForeground(Color.BLACK);
            LabelErro.setFont(LabelErro.getFont().deriveFont(Font.PLAIN));
            ButtonVisualizar.setEnabled(true);
        }
    }

    private void exibirInfoExtra() {
        Informacao i = new Informacao();
        InfoDAO iDAO = new InfoDAO();
        int id = getPosicao();
        if (id == -1) {
            return;
        } else {
            i.setIdAgenda(id);
        }
        try {
            // Obter as informações extras do banco de dados com o id
            Informacao idSelecionado = iDAO.buscarInfoPeloId(id);

            if (idSelecionado != null) {
                // Abrir a tela de informações extras
                InfoExtra infoExtra = new InfoExtra(idSelecionado);
                infoExtra.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this,
                        "Sem informações para este atendimento",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao exibir informações: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExportar;
    private javax.swing.JButton ButtonFiltro;
    private javax.swing.JButton ButtonVisualizar;
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboDia;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JLabel LabelErro;
    private javax.swing.JTable TableInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
