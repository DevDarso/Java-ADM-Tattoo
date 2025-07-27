package admtattoo;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InfoExtra extends javax.swing.JFrame {

    private int id;
    Informacao i = new Informacao();

    public InfoExtra() {
        initComponents();
        LabelObs.setVisible(false);
        TextFieldObs.setVisible(false);
        setupTextArea();
        carregarDados();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public InfoExtra(Informacao i) {
        this.id = i.getIdAgenda();
        this.i = i;
        initComponents();
        LabelObs.setVisible(false);
        TextFieldObs.setVisible(false);
        carregarDados();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelCliente = new javax.swing.JLabel();
        LabelFuncionario = new javax.swing.JLabel();
        ButtonAtualizar = new javax.swing.JButton();
        LabelObs = new javax.swing.JLabel();
        ComboBoxD = new javax.swing.JComboBox<>();
        ComboBoxN = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaNota = new javax.swing.JTextArea();
        TextFieldObs = new javax.swing.JTextField();
        LabelErro = new javax.swing.JLabel();
        ButtonVerTudo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Informações complementares");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Sessão/Atendimento número:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Duração do atendimento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Observações sobre o atendimento:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Funcionário:");

        LabelCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelCliente.setText("jLabel7");

        LabelFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelFuncionario.setText("jLabel8");

        ButtonAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonAtualizar.setText("Atualizar");
        ButtonAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAtualizarActionPerformed(evt);
            }
        });

        LabelObs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelObs.setText("Observações sobre o agendamento:");

        ComboBoxD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45", "24:00" }));

        ComboBoxN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        TextAreaNota.setColumns(20);
        TextAreaNota.setRows(5);
        jScrollPane3.setViewportView(TextAreaNota);

        LabelErro.setText("(Disponível somente após atendimento concluído)");

        ButtonVerTudo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonVerTudo.setText("Visualizar todos");
        ButtonVerTudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonVerTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVerTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(LabelFuncionario)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelCliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(LabelObs)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelErro, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane3)
                    .addComponent(TextFieldObs)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(ButtonVerTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelFuncionario)
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LabelErro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(ButtonVerTudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAtualizarActionPerformed
        salvarAtualizacao();
    }//GEN-LAST:event_ButtonAtualizarActionPerformed

    private void ButtonVerTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVerTudoActionPerformed
        AgendaDAO aDAO = new AgendaDAO();
        int idCliente = aDAO.buscarIdClientePorAgenda(id);
        ListaInfo li = new ListaInfo(idCliente);
        li.setVisible(true);
    }//GEN-LAST:event_ButtonVerTudoActionPerformed

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
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoExtra().setVisible(true);
            }
        });
    }

    private void carregarDados() {
        InfoDAO iDAO = new InfoDAO();
        AgendaDAO aDAO = new AgendaDAO();
        List<Informacao> informacoes = iDAO.buscarInfoPeloIdAgenda(id);
        System.out.println("ID recebido: " + id);

        // Verifica se há informações
        if (informacoes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há informações disponíveis para o ID " + id,
                    "Erro", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        }

        // Obtém status da agenda
        Agenda agenda = aDAO.buscarSituacaoPeloId(id);
        if (agenda == null) {
            JOptionPane.showMessageDialog(this, "Não foi possível obter o status do agendamento",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        }

        Informacao primeira = informacoes.get(0);
        String obs = primeira.getObservacao();
        int sessao = primeira.getSessao();
        String status = agenda.getStatus();
        boolean temObs = obs != null && !obs.trim().isEmpty();

        // Verificação para Agendado sem observação - RETORNA SEM ABRIR
        if ("Agendado".equalsIgnoreCase(status) && !temObs) {
            JOptionPane.showMessageDialog(this, "Nenhuma informação disponível para este agendamento");
            this.dispose();
            return;
        }

        // Só continua se for Agendado COM observação ou Atendido (com/sem obs)
        // Configuração dos campos baseada no status
        if ("Agendado".equalsIgnoreCase(status)) {
            // Regra 1: Agendado com observação
            setCamposEnabled(false); // Todos desabilitados
            LabelErro.setVisible(true);
            LabelErro.setForeground(Color.RED);
            LabelErro.setText("Agendamento em aberto - apenas visualização");

            // Garante que campos de obs estão visíveis
            LabelObs.setVisible(true);
            TextFieldObs.setVisible(true);
        } else {
            // Regras 2 e 3: Atendido
            setCamposEnabled(true); // Todos habilitados
            LabelErro.setVisible(false);

            // Configura campos de obs conforme existência
            LabelObs.setVisible(temObs);
            TextFieldObs.setVisible(temObs);
        }
        // Preenche os dados básicos
        atualizarComboSessao(sessao);
        String duracao = primeira.getDuracao();
        ComboBoxD.setSelectedItem(
                (duracao == null || "00:00".equalsIgnoreCase(duracao))
                ? ComboBoxD.getItemAt(0) : duracao
        );

        TextAreaNota.setText(primeira.getNota() != null ? primeira.getNota() : "");
        LabelCliente.setText(primeira.getNomeCliente() != null ? primeira.getNomeCliente() : "");

        // Preenche observação se existir
        if (temObs) {
            TextFieldObs.setText(obs);
        }
// Preenche funcionários
        StringBuilder nomes = new StringBuilder("<html>");
        for (Informacao i : informacoes) {
            if (i.getNomeFuncionario() != null) {
                nomes.append(i.getNomeFuncionario());
                if (i.getTipoFuncionario() != null) {
                    nomes.append(" (").append(i.getTipoFuncionario()).append(")");
                }
                nomes.append("<br>");
            }
        }
        nomes.append("</html>");
        LabelFuncionario.setText(nomes.toString());
    }

    private void atualizarComboSessao(int sessao) {
        // Verifica se o valor já existe no ComboBox
        boolean valorExiste = false;
        for (int i = 0; i < ComboBoxN.getItemCount(); i++) {
            String item = ComboBoxN.getItemAt(i).toString();
            if (item.equals(String.valueOf(sessao))) {
                valorExiste = true;
                break;
            }
        }

        // Adiciona o valor se necessário (ignorando strings não numéricas)
        if (!valorExiste && sessao > 30) {
            ComboBoxN.addItem(String.valueOf(sessao));
        }

        // Seleciona o valor
        ComboBoxN.setSelectedItem(String.valueOf(sessao));
    }
// Métodos auxiliares para melhor organização

    private void setCamposEnabled(boolean enabled) {
        TextAreaNota.setEnabled(enabled);
        ComboBoxN.setEnabled(enabled);
        ComboBoxD.setEnabled(enabled);
        TextFieldObs.setEnabled(true);
    }
// Método chamado no construtor para quebrar linhas no TextArea

    private void setupTextArea() {
        TextAreaNota.setLineWrap(true);
        TextAreaNota.setWrapStyleWord(true);
    }

    private void salvarAtualizacao() {
// Verifica se já existe informação no banco
        Informacao existente = InfoDAO.buscarInfoPeloId(id);

        // Cria novo objeto com os dados da tela
        Informacao i = new Informacao();
        i.setIdAgenda(id);

        String sessao = ComboBoxN.getSelectedItem().toString();
        i.setSessao("Selecione".equalsIgnoreCase(sessao) ? 0 : Integer.parseInt(sessao));

        String duracao = ComboBoxD.getSelectedItem().toString();
        i.setDuracao("Selecione".equalsIgnoreCase(duracao) ? "" : duracao);

        i.setNota(TextAreaNota.getText());
        i.setObservacao(TextFieldObs.getText());

        if (existente != null) {
            // Atualiza usando o novo objeto
            InfoDAO.atualizarInfo(i);
            JOptionPane.showMessageDialog(rootPane, "Informações atualizadas com sucesso");
        } else {
            if (InfoDAO.adicionarInfo(i)) {
                JOptionPane.showMessageDialog(rootPane, "Informações adicionadas com sucesso");
            } else {
                System.err.println("Não foi possível salvar informações");
            }
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAtualizar;
    private javax.swing.JButton ButtonVerTudo;
    private javax.swing.JComboBox<String> ComboBoxD;
    private javax.swing.JComboBox<String> ComboBoxN;
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelErro;
    private javax.swing.JLabel LabelFuncionario;
    private javax.swing.JLabel LabelObs;
    private javax.swing.JTextArea TextAreaNota;
    private javax.swing.JTextField TextFieldObs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
