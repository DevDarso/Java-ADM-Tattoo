package admtattoo;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListaComissao extends javax.swing.JFrame {

    public ListaComissao() {
        initComponents();
        preencherCombosDataAtual();
        atualizarTotais();
        CheckBoxZero.addActionListener(e -> atualizarTabela());

        TableComissao.setModel(new DefaultTableModel(
                new Object[]{"idAgenda", "idFuncionario", "tipoServico", "data", "hora", "valor", "porcento", "valorCalculado"},
                0
        ));
        TableComissao.setRowSorter(new TableRowSorter<>(TableComissao.getModel()));

        atualizarLabelsComparativos();
        carregarTabela();
        carregarFuncionarioNoComboBox();
        carregarServicoNoComboBox();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxFuncionario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboDiaInicial = new javax.swing.JComboBox<>();
        ComboMesInicial = new javax.swing.JComboBox<>();
        ComboAnoInicial = new javax.swing.JComboBox<>();
        ComboDiaFinal = new javax.swing.JComboBox<>();
        ComboMesFinal = new javax.swing.JComboBox<>();
        ComboAnoFinal = new javax.swing.JComboBox<>();
        ButtonCalcular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxServico = new javax.swing.JComboBox<>();
        CheckBoxZero = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableComissao = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        ButtonExibir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        LabelMes = new javax.swing.JLabel();
        LabelAno = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LabelRespostaRegistro = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        LabelRespostaTotal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LabelRespostaComissao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Calcular comissões");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Funcionário:");

        ComboBoxFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Período inicial:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("final:");

        ComboDiaInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboMesInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        ComboAnoInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        ComboDiaFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboMesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        ComboAnoFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        ButtonCalcular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonCalcular.setText("Calcular");
        ButtonCalcular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalcularActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Serviço/Produto:");

        ComboBoxServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CheckBoxZero.setText("Exibir lista com valores zerados");
        CheckBoxZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxZeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(ComboDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(CheckBoxZero))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(CheckBoxZero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCalcular)
                .addContainerGap())
        );

        TableComissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableComissaoFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TableComissao);

        ButtonExibir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonExibir.setText("Exibir na agenda");
        ButtonExibir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Comparativo com ano anterior:");

        LabelMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelMes.setText("jLabel9");

        LabelAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelAno.setText("jLabel9");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelMes)
                .addGap(18, 18, 18)
                .addComponent(LabelAno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonExibir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMes)
                    .addComponent(jLabel9)
                    .addComponent(LabelAno))
                .addGap(18, 18, 18)
                .addComponent(ButtonExibir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Registros:");

        LabelRespostaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelRespostaRegistro.setText("jLabel7");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelRespostaRegistro)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(LabelRespostaRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Total bruto :");

        LabelRespostaTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelRespostaTotal.setText("jLabel7");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelRespostaTotal)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LabelRespostaTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Comissões :");

        LabelRespostaComissao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelRespostaComissao.setText("jLabel7");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelRespostaComissao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LabelRespostaComissao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalcularActionPerformed

        if (isFiltro()) {
            aplicaFiltroDataSituacao(); // só quando há data envolvida
        } else {
            aplicaFiltroGeral(); // funcionário ou serviço
        }
    }//GEN-LAST:event_ButtonCalcularActionPerformed

    private void ButtonExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirActionPerformed
        int idSelecionado = getPosicao();

        if (idSelecionado != -1) {
            Agenda agendamento = AgendaDAO.buscarPorId(idSelecionado);
            if (agendamento != null) {
                ListaAgenda tela = new ListaAgenda(agendamento);
                tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Agendamento não encontrado.");
            }
        }
    }//GEN-LAST:event_ButtonExibirActionPerformed

    private void TableComissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableComissaoFocusGained
//       TableComissao.setModel(montarTabela());
//        jScrollPane1.setViewportView(TableComissao);
    }//GEN-LAST:event_TableComissaoFocusGained

    private void CheckBoxZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxZeroActionPerformed
        acionarButtonCalcular();
    }//GEN-LAST:event_CheckBoxZeroActionPerformed

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
            java.util.logging.Logger.getLogger(ListaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaComissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaComissao().setVisible(true);
            }
        });
    }

    private void acionarButtonCalcular() {
        ButtonCalcular.doClick();
    }

    public DefaultTableModel montarTabela() {
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"idAgenda", "idFuncionario", "tipoServico", "data", "hora", "valor", "porcento", "valorCalculado"},
                0
        );

        List<ComissaoDTO> lista;

        if (CheckBoxZero.isSelected()) {
            lista = ComissaoDAO.listarComissoesDetalhadas();
        } else {
            lista = ComissaoDAO.listarComissoesSemValoresZerados();
        }

        for (ComissaoDTO dto : lista) {
            modelo.addRow(new Object[]{
                dto.getIdAgenda(),
                dto.getIdFuncionario(),
                dto.getTipoServico(),
                formatarDataString(dto.getData()),
                dto.getHora(),
                dto.getValor(),
                dto.getPorcento(),
                dto.getValorCalculado()
            });
        }

        // Aplicar o modelo na tabela
        TableComissao.setModel(modelo);

        // Verificar integridade da estrutura da tabela
        verificarEstruturaTabela();

        // Atualizar totais após alterar o modelo
        atualizarTotais();

        // Criar o sorter com o modelo atualizado
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        TableComissao.setRowSorter(sorter);

        // Verificação final
        if (TableComissao.getColumnCount() != 8) {
            System.err.println("ALERTA: Modelo da tabela corrompido!");
            verificarEstruturaTabela();
            return modelo;
        }

        return modelo;
    }

    private void atualizarTabela() {
        TableComissao.setModel(montarTabela());
    }

    private void contarLinhasTabela() {
        int totalLinhas = TableComissao.getRowCount();
        LabelRespostaRegistro.setText(String.valueOf(totalLinhas));
    }

    private synchronized void somarValorBrutoTabela() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) TableComissao.getModel();

            // Verificação EXTRA
            if (modelo.getRowCount() == 0 || modelo.getColumnCount() <= 5) {
                LabelRespostaTotal.setText("N/A");
                return;
            }

            double soma = 0.0;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Object valor = modelo.getValueAt(i, 5);
                if (valor != null) {
                    soma += Double.parseDouble(valor.toString());
                }
            }
            LabelRespostaTotal.setText(String.format("R$%.2f", soma));
        } catch (Exception e) {
            System.err.println("Erro ao somar valor bruto: " + e.getMessage());
            LabelRespostaTotal.setText("Erro");
        }
    }

    private synchronized void somarComissaoTabela() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) TableComissao.getModel();

            // Verificação EXTRA de segurança
            int colunaValorCalculado = encontrarIndiceColuna("valorCalculado");
            if (colunaValorCalculado == -1 || modelo.getRowCount() == 0) {
                LabelRespostaComissao.setText("N/A");
                return;
            }

            double soma = 0.0;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Object valor = modelo.getValueAt(i, colunaValorCalculado);
                if (valor != null) {
                    try {
                        soma += Double.parseDouble(valor.toString());
                    } catch (NumberFormatException e) {
                        System.err.println("Valor inválido na linha " + i + ": " + valor);
                    }
                }
            }
            LabelRespostaComissao.setText(String.format("R$%.2f", soma));
        } catch (Exception e) {
            System.err.println("Erro em somarComissaoTabela: " + e.getMessage());
            LabelRespostaComissao.setText("Erro");
            verificarEstruturaTabela(); // Mostra o estado atual para debug
        }
    }
    private boolean emAtualizacao = false; // Variável de controle

    private void atualizarTotais() {
        if (emAtualizacao) {
            return; // Evita recursão
        }
        try {
            emAtualizacao = true;

            RowSorter<? extends TableModel> sorterOriginal = TableComissao.getRowSorter();
            try {
                TableComissao.setRowSorter(null); // Desativa o sorter pra evitar bugs

                // Atualizações seguras
                contarLinhasTabela();
                somarValorBrutoTabela();
                somarComissaoTabela();

            } finally {
                TableComissao.setRowSorter(sorterOriginal);
                emAtualizacao = false;
            }

        } catch (Exception e) {
            System.err.println("Erro em atualizarTotais: " + e.getMessage());
        }
    }

    private int encontrarIndiceColuna(String nomeColuna) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) TableComissao.getModel();
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                // Busca case insensitive e ignora espaços
                if (modelo.getColumnName(i).trim().equalsIgnoreCase(nomeColuna.trim())) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar coluna '" + nomeColuna + "': " + e.getMessage());
        }
        return -1;
    }

    private void carregarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) TableComissao.getModel();
        modelo.setRowCount(0);

        List<ComissaoDTO> lista = ComissaoDAO.listarComissoesSemValoresZerados();
        for (ComissaoDTO dto : lista) {
            modelo.addRow(new Object[]{
                dto.getIdAgenda(),
                dto.getIdFuncionario(),
                dto.getTipoServico(),
                formatarDataString(dto.getData()),
                dto.getHora(),
                dto.getValor(),
                dto.getPorcento(),
                dto.getValorCalculado()
            });
        }

        SwingUtilities.invokeLater(() -> {
            TableComissao.setRowSorter(new TableRowSorter<>(modelo));
            atualizarTotais(); // Única chamada
        });
    }

    public void verificarEstruturaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) TableComissao.getModel();
        System.out.println("\n=== ESTRUTURA DA TABELA ===");
        System.out.println("Total de colunas: " + modelo.getColumnCount());
        System.out.println("Total de linhas: " + modelo.getRowCount());

        System.out.println("\nNomes das colunas:");
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            System.out.println(i + ": " + modelo.getColumnName(i));
        }

        if (modelo.getRowCount() > 0) {
            System.out.println("\nPrimeira linha:");
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                Object valor = modelo.getValueAt(0, i);
                System.out.println(i + ": " + valor
                        + " (" + (valor != null ? valor.getClass().getSimpleName() : "null") + ")");
            }
        }
    }

    private void carregarServicoNoComboBox() {
        List<Servico> servicos = ServicoDAO.buscarPorServicoNoComboBox();

        ComboBoxServico.removeAllItems();
        ComboBoxServico.addItem("Selecione");
        for (Servico servico : servicos) {
            ComboBoxServico.addItem(servico.getNomeServico());
        }
    }

    private void carregarFuncionarioNoComboBox() {
        List<Cadastro> cadastros = CadastroDAO.buscarPorFuncionariosComboBox();

        ComboBoxFuncionario.removeAllItems();
        ComboBoxFuncionario.addItem("Selecione");
        ComboBoxFuncionario.addItem("Todos");

        for (Cadastro cadastro : cadastros) {
            ComboBoxFuncionario.addItem(cadastro.getId() + " - " + cadastro.getNome());
        }

    }

    private int getPosicao() {
        int selectedRow = TableComissao.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum atendimento selecionado. Por favor, selecione um na tabela.",
                    "Seleção Necessária", JOptionPane.WARNING_MESSAGE);
            return -1;
        }

        try {
            Object valorId = TableComissao.getValueAt(selectedRow, 0);
            return Integer.parseInt(valorId.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao obter ID do atendimento: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void aplicaFiltroDataSituacao() {
        Comissao c = new Comissao();
        Agenda a = new Agenda();
        String diaInicio = (String) ComboDiaInicial.getSelectedItem();
        String mesInicio = (String) ComboMesInicial.getSelectedItem();
        String anoInicio = (String) ComboAnoInicial.getSelectedItem();

        boolean dataCompletaInicio = !(diaInicio.equals("Dia") || mesInicio.equals("Mês") || anoInicio.equals("Ano"));
        String dataInicio = dataCompletaInicio ? (anoInicio + "-" + mesInicio + "-" + diaInicio) : null;

        String diaFinal = (String) ComboDiaFinal.getSelectedItem();
        String mesFinal = (String) ComboMesFinal.getSelectedItem();
        String anoFinal = (String) ComboAnoFinal.getSelectedItem();

        boolean dataCompletaFinal = !(diaFinal.equals("Dia") || mesFinal.equals("Mês") || anoFinal.equals("Ano"));
        String dataFinal = dataCompletaFinal ? (anoFinal + "-" + mesFinal + "-" + diaFinal) : null;

        Integer idFuncionario = null;
        String textoCombo = ComboBoxFuncionario.getSelectedItem().toString();
        if (!textoCombo.equals("Todos") && !textoCombo.equals("Selecione")) {
            String apenasNumeros = textoCombo.replaceAll("[^0-9]", "");
            if (!apenasNumeros.isEmpty()) {
                idFuncionario = Integer.parseInt(apenasNumeros);
                a.setIdFuncionario(idFuncionario);
            }
        }
        DefaultTableModel modeloFiltrado = montarTabelaAPartirDaData(dataInicio, dataFinal, idFuncionario);

        // Atualiza a tabela e os labels
        TableComissao.setModel(modeloFiltrado);
        TableComissao.setRowSorter(new TableRowSorter<>(modeloFiltrado));

        // Chama explicitamente a atualização dos totais
        atualizarTotais();
    }

    private void aplicaFiltroGeral() {
        String funcionarioSelecionado = ComboBoxFuncionario.getSelectedItem().toString();
        String servicoSelecionado = ComboBoxServico.getSelectedItem().toString();

        boolean funcionarioNeutro = funcionarioSelecionado.equalsIgnoreCase("Todos") || funcionarioSelecionado.equalsIgnoreCase("Selecione");
        boolean servicoNeutro = servicoSelecionado.equalsIgnoreCase("Selecione");

        // Nenhum filtro aplicado - mostra todos
        if (funcionarioNeutro && servicoNeutro) {
            carregarTabela(); // atualiza a tabela com todos os dados
            return;
        }

        // Extrai idFuncionario, se aplicável
        Integer idFuncionario = null;
        if (!funcionarioNeutro) {
            String apenasNumeros = funcionarioSelecionado.replaceAll("[^0-9]", "");
            if (!apenasNumeros.isEmpty()) {
                idFuncionario = Integer.parseInt(apenasNumeros);
            }
        }

        // Chama montagem da tabela filtrada
        DefaultTableModel modeloFiltrado = montarTabelaAPartirDaData(null, null, idFuncionario);
        TableComissao.setModel(modeloFiltrado);
        TableComissao.setRowSorter(new TableRowSorter<>(modeloFiltrado));
        atualizarTotais();
    }

    public DefaultTableModel montarTabelaAPartirDaData(String dataInicio, String dataFinal, Integer idFuncionario) {

// Validação da data
        if (dataInicio != null && dataFinal == null) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    "Deseja adicionar data final?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                return null;
            } else {
                dataFinal = "9999-12-31";
            }
        }

        String tipoServicoSelecionado = ComboBoxServico.getSelectedItem().toString();
        boolean filtrarPorServico = tipoServicoSelecionado != null
                && !tipoServicoSelecionado.equalsIgnoreCase("Selecione");

        idFuncionario = null;
        String textoCombo = ComboBoxFuncionario.getSelectedItem().toString();
        if (textoCombo != null && !textoCombo.equalsIgnoreCase("Todos") && !textoCombo.equalsIgnoreCase("Selecione")) {
            String apenasNumeros = textoCombo.replaceAll("[^0-9]", "");
            if (!apenasNumeros.isEmpty()) {
                idFuncionario = Integer.parseInt(apenasNumeros);
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"idAgenda", "idFuncionario", "tipoServico", "data", "hora", "valor", "porcento", "valorCalculado"},
                0);
        List<ComissaoDTO> lista = CheckBoxZero.isSelected()
                ? ComissaoDAO.listarComissoesDetalhadas()
                : ComissaoDAO.listarComissoesSemValoresZerados();

        System.out.println("Total de atendimentos encontrados: " + lista.size());

        int totalRegistros = 0;
        double somaValorBruto = 0.0;
        double somaComissao = 0.0;

        if (lista == null) {
            System.err.println("Lista de comissões está nula");
            return new DefaultTableModel();
        }
        System.out.println("=== DEBUG ===");
        System.out.println("Total de registros a processar: " + lista.size());
        System.out.println("Modelo colunas: " + modelo.getColumnCount());
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            System.out.println("Coluna " + i + ": " + modelo.getColumnName(i));
        }
        for (ComissaoDTO dto : lista) {
            // Verificação crítica de dados inválidos
            if (dto.getIdAgenda() == 0 && dto.getValor() == 0.0 && dto.getData() == null) {
                System.err.println("Registro inválido ignorado: " + dto.toString());
                continue; // Pula registros claramente inconsistentes
            }
        }
        for (ComissaoDTO dto : lista) {

// VERIFICAÇÃO DE FILTROS
            boolean aplicarFiltros = dataInicio != null || idFuncionario != null || filtrarPorServico;
            if (aplicarFiltros) {
                boolean dataDentroDoIntervalo = true;
                boolean funcionarioCorreto = true;
                boolean servicoCorreto = true;

                if (dataInicio != null && dataFinal != null && dto.getData() != null) {
                    dataDentroDoIntervalo = dto.getData().compareTo(dataInicio) >= 0
                            && dto.getData().compareTo(dataFinal) <= 0;
                }

                if (idFuncionario != null) {
                    funcionarioCorreto = dto.getIdFuncionario() == idFuncionario;
                }

                if (filtrarPorServico) {
                    servicoCorreto = tipoServicoSelecionado.equalsIgnoreCase(dto.getTipoServico());
                }

                if (!(dataDentroDoIntervalo && funcionarioCorreto && servicoCorreto)) {
                    continue; // pula esse item
                }
            }
            // ADICIONA LINHA NA TABELA
            modelo.addRow(new Object[]{
                dto.getIdAgenda(),
                dto.getIdFuncionario(),
                dto.getTipoServico() != null ? dto.getTipoServico() : "N/A",
                dto.getData() != null ? formatarDataString(dto.getData()) : "N/A",
                dto.getHora() != null ? dto.getHora() : "N/A",
                dto.getValor(),
                dto.getPorcento(),
                dto.getValorCalculado()
            });
            totalRegistros++;
            somaValorBruto += dto.getValor();
            somaComissao += dto.getValorCalculado();
        }
        TableComissao.setModel(modelo);
        TableComissao.setRowSorter(new TableRowSorter<>(modelo));
        // Atualiza os totais APÓS definir o novo modelo
        SwingUtilities.invokeLater(() -> {
            atualizarTotais();
        });
        if (totalRegistros == 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum atendimento encontrado com os filtros informados.",
                    "Resultado vazio", JOptionPane.INFORMATION_MESSAGE);
        }
        verificarEstruturaTabela();
        TableComissao.setRowSorter(null);
        atualizarTotais();

        TableComissao.setRowSorter(new TableRowSorter<>(TableComissao.getModel()));
        return modelo;
    }

    private boolean isFiltro() {
        String funcionario = ComboBoxFuncionario.getSelectedItem().toString();
        String servico = ComboBoxServico.getSelectedItem().toString();
        boolean algumFuncionario = !funcionario.equals("Todos") && !funcionario.equals("Selecione");
        boolean algumServico = !servico.equals("Todos") && !servico.equals("Selecione");

        String dia = ComboDiaInicial.getSelectedItem().toString();
        String mes = ComboMesInicial.getSelectedItem().toString();
        String ano = ComboAnoInicial.getSelectedItem().toString();
        boolean dataCompleta = !(dia.equals("Dia") || mes.equals("Mês") || ano.equals("Ano"));
        return algumFuncionario || dataCompleta || algumServico;
    }

    // comparativo de valores com ano anterior e mês atual
    private double calcularTotalPeriodo(LocalDate inicio, LocalDate fim) {
        List<ComissaoDTO> lista = CheckBoxZero.isSelected()
                ? ComissaoDAO.listarComissoesDetalhadas()
                : ComissaoDAO.listarComissoesSemValoresZerados();

        double soma = 0.0;
        for (ComissaoDTO dto : lista) {
            try {
                LocalDate data = LocalDate.parse(dto.getData());
                if ((data.isEqual(inicio) || data.isAfter(inicio)) && data.isBefore(fim.plusDays(1))) {
                    soma += dto.getValor(); // ou getValorCalculado(), se preferir comparar comissão
                }
            } catch (Exception e) {
                System.err.println("Data inválida em DTO: " + dto.getData());
            }
        }
        return soma;
    }

    private void atualizarLabelsComparativos() {
        try {
            LocalDate hoje = LocalDate.now();

            LocalDate inicioMesAtual = hoje.withDayOfMonth(1);
            LocalDate fimMesAtual = hoje;

            LocalDate inicioMesAnterior = inicioMesAtual.minusYears(1);
            LocalDate fimMesAnterior = fimMesAtual.minusYears(1);

            double totalMesAtual = calcularTotalPeriodo(inicioMesAtual, fimMesAtual);
            double totalMesAnterior = calcularTotalPeriodo(inicioMesAnterior, fimMesAnterior);

            if (totalMesAnterior == 0.0) {
                LabelMes.setForeground(Color.GRAY);
                LabelMes.setText("Sem dados mês anterior");
            } else {
                double variacaoMes = ((totalMesAtual - totalMesAnterior) / totalMesAnterior) * 100;
                if (variacaoMes >= 0) {
                    LabelMes.setForeground(new Color(0, 153, 0)); // verde escuro
                    LabelMes.setText(String.format("↑ Mês: +%.2f%%", variacaoMes));
                } else {
                    LabelMes.setForeground(Color.RED);
                    LabelMes.setText(String.format("↓ Mês: -%.2f%%", Math.abs(variacaoMes)));
                }
            }
            LocalDate inicioAnoAtual = LocalDate.of(hoje.getYear(), 1, 1);
            LocalDate fimAnoAtual = hoje;

            LocalDate inicioAnoAnterior = inicioAnoAtual.minusYears(1);
            LocalDate fimAnoAnterior = fimAnoAtual.minusYears(1);

            double totalAnoAtual = calcularTotalPeriodo(inicioAnoAtual, fimAnoAtual);
            double totalAnoAnterior = calcularTotalPeriodo(inicioAnoAnterior, fimAnoAnterior);

            if (totalAnoAnterior == 0.0) {
                LabelAno.setForeground(Color.GRAY);
                LabelAno.setText("Sem dados ano anterior");
            } else {
                double variacaoAno = ((totalAnoAtual - totalAnoAnterior) / totalAnoAnterior) * 100;
                if (variacaoAno >= 0) {
                    LabelAno.setForeground(new Color(0, 153, 0));
                    LabelAno.setText(String.format("↑ Ano: +%.2f%%", variacaoAno));
                } else {
                    LabelAno.setForeground(Color.RED);
                    LabelAno.setText(String.format("↓ Ano: -%.2f%%", Math.abs(variacaoAno)));
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao calcular comparativos: " + e.getMessage());
        }
    }

    private void preencherCombosDataAtual() {
        LocalDate hoje = LocalDate.now();
        int diaAtual = hoje.getDayOfMonth();
        int mesAtual = hoje.getMonthValue();
        int anoAtual = hoje.getYear();

        // Buscar datas extremas do banco de dados
        AgendaDAO agendaDAO = new AgendaDAO();
        LocalDate dataMaisAntiga = agendaDAO.buscarDataMaisAntiga();
        LocalDate dataMaisRecente = agendaDAO.buscarDataMaisRecente();

        // Definir ano mínimo e máximo
        int anoMinimo = (dataMaisAntiga != null) ? dataMaisAntiga.getYear() : anoAtual;
        int anoMaximo = (dataMaisRecente != null) ? dataMaisRecente.getYear() : anoAtual;

        // PREENCHER COMBOS INICIAIS (PRIMEIRO DIA DO MÊS)
        ComboAnoInicial.removeAllItems();
        ComboAnoInicial.addItem("Ano");
        for (int a = anoMinimo; a <= anoMaximo; a++) {
            ComboAnoInicial.addItem(String.valueOf(a));
        }
        ComboAnoInicial.setSelectedItem(String.valueOf(anoAtual));

        ComboMesInicial.removeAllItems();
        ComboMesInicial.addItem("Mês");
        for (int m = 1; m <= 12; m++) {
            ComboMesInicial.addItem(String.format("%02d", m));
        }
        ComboMesInicial.setSelectedItem(String.format("%02d", mesAtual));

        ComboDiaInicial.removeAllItems();
        ComboDiaInicial.addItem("Dia");
        for (int d = 1; d <= 31; d++) {
            ComboDiaInicial.addItem(String.format("%02d", d));
        }
        ComboDiaInicial.setSelectedItem("01");

        // PREENCHER COMBOS FINAIS (DATA ATUAL)
        ComboAnoFinal.removeAllItems();
        ComboAnoFinal.addItem("Ano");
        for (int a = anoMinimo; a <= anoMaximo; a++) {
            ComboAnoFinal.addItem(String.valueOf(a));
        }
        ComboAnoFinal.setSelectedItem(String.valueOf(anoAtual));

        ComboMesFinal.removeAllItems();
        ComboMesFinal.addItem("Mês");
        for (int m = 1; m <= 12; m++) {
            ComboMesFinal.addItem(String.format("%02d", m));
        }
        ComboMesFinal.setSelectedItem(String.format("%02d", mesAtual));

        ComboDiaFinal.removeAllItems();
        ComboDiaFinal.addItem("Dia");
        for (int d = 1; d <= 31; d++) {
            ComboDiaFinal.addItem(String.format("%02d", d));
        }
        ComboDiaFinal.setSelectedItem(String.format("%02d", diaAtual)); // Dia atual
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCalcular;
    private javax.swing.JButton ButtonExibir;
    private javax.swing.JCheckBox CheckBoxZero;
    private javax.swing.JComboBox<String> ComboAnoFinal;
    private javax.swing.JComboBox<String> ComboAnoInicial;
    private javax.swing.JComboBox<String> ComboBoxFuncionario;
    private javax.swing.JComboBox<String> ComboBoxServico;
    private javax.swing.JComboBox<String> ComboDiaFinal;
    private javax.swing.JComboBox<String> ComboDiaInicial;
    private javax.swing.JComboBox<String> ComboMesFinal;
    private javax.swing.JComboBox<String> ComboMesInicial;
    private javax.swing.JLabel LabelAno;
    private javax.swing.JLabel LabelMes;
    private javax.swing.JLabel LabelRespostaComissao;
    private javax.swing.JLabel LabelRespostaRegistro;
    private javax.swing.JLabel LabelRespostaTotal;
    private javax.swing.JTable TableComissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
