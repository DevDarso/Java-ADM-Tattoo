package admtattoo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListaAgenda extends javax.swing.JFrame {

    Agenda a = new Agenda();
    private ComissaoDAO ComissaoDAO;

    private boolean modoCliente = false;
    private int idCliente = -1;
    private int idFuncionario;

    public ListaAgenda() {
        initComponents();
        configurarTabela();
        CheckBoxInativo.addItemListener(e -> carregarFuncionarioNoComboBox());
        carregarFuncionarioNoComboBox();
        RadioButtonAgendado.setSelected(true);
        configurarListenersRadio();
        carregarAgendados();
        preencherCombosDataAtual();
        LabelErroData.setVisible(false);
        ComboAno.addActionListener(e -> validaData());
        ComboMes.addActionListener(e -> validaData());
        ComboDia.addActionListener(e -> validaData());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        acionarButtonListar();
    }
// construtor para montar lista através do id

    public ListaAgenda(int idCliente) {
        initComponents();
        this.modoCliente = true;
        this.idCliente = idCliente;
        this.idFuncionario = a.getIdFuncionario();
        configurarComponentes();
        preencherCombosDataAtual();
        LabelErroData.setVisible(false);
        ComboAno.addActionListener(e -> validaData());
        ComboMes.addActionListener(e -> validaData());
        ComboDia.addActionListener(e -> validaData());
        configurarTabela();
        carregarTabela(idCliente);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.out.println("ID encontrado para funcionário: " + idFuncionario);
    }

    public ListaAgenda(Agenda agendaSelecionada) {
        initComponents();
        configurarTabela();
        carregarFuncionarioNoComboBox();
        montarTabela(agendaSelecionada);
        preencherCombosDataAtual();
        LabelErroData.setVisible(false);
        ComboAno.addActionListener(e -> validaData());
        ComboMes.addActionListener(e -> validaData());
        ComboDia.addActionListener(e -> validaData());
        reconfigurarTabelaAposFiltro();
        configurarComponentes();
        ButtonAtualizar.setEnabled(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
// construtor para receber dados do botão histórico em cadastro

    public ListaAgenda(int id, String tipoCadastro) {
        initComponents();
        configurarComponentes();
        configurarTabela();
        // Determina se é cliente ou funcionário baseado no status
        boolean isFuncionario = "Funcionário".equalsIgnoreCase(tipoCadastro);
        if (isFuncionario) {
            DefaultTableModel model = montarTabelaHistorico(id, "Funcionário");
            TableAgenda.setModel(model);
        } else {
            DefaultTableModel model = montarTabelaHistorico(id, "Cliente");
            TableAgenda.setModel(model);
        }
        preencherCombosDataAtual();
        LabelErroData.setVisible(false);
        ComboAno.addActionListener(e -> validaData());
        ComboMes.addActionListener(e -> validaData());
        ComboDia.addActionListener(e -> validaData());
        contarLinhasTabela();
        ButtonAtualizar.setEnabled(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgenda = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ButtonAtualizar = new javax.swing.JButton();
        ButtonDetalhe = new javax.swing.JButton();
        LabelErro = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ComboBoxFuncionario = new javax.swing.JComboBox<>();
        ButtonListar = new javax.swing.JButton();
        LabelSelecione = new javax.swing.JLabel();
        RadioButtonAgendado = new javax.swing.JRadioButton();
        RadioButtonAtendido = new javax.swing.JRadioButton();
        RadioButtonCancelado = new javax.swing.JRadioButton();
        ComboDia = new javax.swing.JComboBox<>();
        ComboMes = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();
        CheckBoxInativo = new javax.swing.JCheckBox();
        LabelErroData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Lista agendamentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        TableAgenda.setModel(new javax.swing.table.DefaultTableModel(
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
        TableAgenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableAgendaFocusGained(evt);
            }
        });
        TableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAgenda);

        ButtonAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonAtualizar.setText("Atualizar");
        ButtonAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAtualizarActionPerformed(evt);
            }
        });

        ButtonDetalhe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonDetalhe.setText("Detalhes");
        ButtonDetalhe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonDetalhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDetalheActionPerformed(evt);
            }
        });

        LabelErro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelErro.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(ButtonDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(LabelErro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        ComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ButtonListar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonListar.setText("Listar");
        ButtonListar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonListarActionPerformed(evt);
            }
        });

        LabelSelecione.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelSelecione.setText("Selecione o funcionário");

        buttonGroup1.add(RadioButtonAgendado);
        RadioButtonAgendado.setText("Agendado");

        buttonGroup1.add(RadioButtonAtendido);
        RadioButtonAtendido.setText("Atendido");
        RadioButtonAtendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonAtendidoActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioButtonCancelado);
        RadioButtonCancelado.setText("Cancelado");

        ComboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        CheckBoxInativo.setText(" Incluir inativos ");

        LabelErroData.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(ComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(LabelSelecione)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CheckBoxInativo)
                        .addGap(115, 115, 115))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(RadioButtonAgendado)
                                .addGap(33, 33, 33)
                                .addComponent(RadioButtonAtendido)
                                .addGap(36, 36, 36)
                                .addComponent(RadioButtonCancelado))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(306, 306, 306)
                                .addComponent(ButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LabelErroData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSelecione)
                    .addComponent(CheckBoxInativo))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonAgendado)
                    .addComponent(RadioButtonAtendido)
                    .addComponent(RadioButtonCancelado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelErroData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonListar))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAtualizarActionPerformed
        String status;
        boolean permiteColab;
        try {
            int id = getPosicao();
            if (id == -1) {
                return;
            }
            Agenda agenda = AgendaDAO.buscarPorId(id);
            status = agenda.getStatus();
            permiteColab = agenda.isPermiteColaborador();

            if (!permiteColab && "Atendido".equalsIgnoreCase(status)
                    || "Cancelado".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(rootPane, "Atendimento já foi atualizado !");
                return;
            }
            if (agenda != null) {
                AtualizarAgenda aa = new AtualizarAgenda(agenda, this); //  passa a instância 
                aa.setLocationRelativeTo(this);
                aa.setVisible(true);

                // Listener que atualiza a tabela ao fechar a janela
                aa.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        montarTabelaPorId(agenda.getId());
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Agendamento não encontrado",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                atualizarTabela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonAtualizarActionPerformed

    private void ButtonDetalheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDetalheActionPerformed

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
    }//GEN-LAST:event_ButtonDetalheActionPerformed

    private void TableAgendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableAgendaFocusGained

    }//GEN-LAST:event_TableAgendaFocusGained

    private void ButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonListarActionPerformed
        if (modoCliente) {
            aplicarFiltroCliente();
        } else {
            if (isFiltro()) {
                aplicaFiltroDataSituacao();
            } else {
                aplicarFiltroFuncionarioGeral();
            }
        }
    }//GEN-LAST:event_ButtonListarActionPerformed

    private void TableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAgendaMouseClicked

    }//GEN-LAST:event_TableAgendaMouseClicked

    private void RadioButtonAtendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonAtendidoActionPerformed

    }//GEN-LAST:event_RadioButtonAtendidoActionPerformed
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
            java.util.logging.Logger.getLogger(ListaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAgenda().setVisible(true);
            }
        });
    }

    private void acionarButtonListar() {
        ButtonListar.doClick(); // Simula um clique no botão
    }

    private void configurarComponentes() {
        ComboBoxFuncionario.setEnabled(false);
        ButtonListar.setEnabled(false);
        ComboDia.setEnabled(false);
        ComboMes.setEnabled(false);
        ComboAno.setEnabled(false);
        RadioButtonAgendado.setEnabled(false);
        RadioButtonAtendido.setEnabled(false);
        RadioButtonCancelado.setEnabled(false);
        LabelSelecione.setEnabled(false);
        CheckBoxInativo.setEnabled(false);
    }

    public DefaultTableModel montarTabela() {
        String[] colunas = {"idAgenda", "idCliente", "idFuncionario", "data", "hora", "tipoServico", "valor", "sinal", "status", "permiteColaborador"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return tabela;
    }

    // inicializa agenda sempre carregando os agendados
    public void carregarAgendados() {
        List<Agenda> agendados = AgendaDAO.listarAgendados();
        DefaultTableModel model = montarTabela();

        for (Agenda a : agendados) {
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            Participante principal = a.getParticipantes().stream()
                    .filter(p -> "Principal".equalsIgnoreCase(p.getPapel()))
                    .findFirst()
                    .orElse(null);

            Comissao comissao = a.getComissoes().stream()
                    .filter(c -> c.getIdProfissional() == (principal != null ? principal.getIdProfissional() : -1))
                    .findFirst()
                    .orElse(null);

            String[] linha = {
                String.valueOf(a.getId()),
                String.valueOf(a.getIdCliente()),
                (principal != null ? String.valueOf(principal.getIdProfissional()) : "N/A"),
                formatarDataString(a.getDataAgendada()),
                a.getHorario(),
                (principal != null ? principal.getTipoServico() : "N/A"),
                (comissao != null ? String.valueOf(comissao.getValor()) : "0.0"),
                String.valueOf(a.getSinal()),
                a.getStatus() != null ? a.getStatus() : "Agendado",
                funcionarioExtra
            };

            model.addRow(linha);
        }
        atualizarTabela(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        TableAgenda.setRowSorter(sorter);
        model.addTableModelListener(e -> contarLinhasTabela());
        contarLinhasTabela();
        configurarTabela(); // reaplica renderizadores, seleção, etc.
    }

//    monta tabela a partir do idAgenda recebido em ListaComissao
    public DefaultTableModel montarTabela(Agenda a) {
        String[] colunas = {
            "idAgenda", "idCliente", "idFuncionario",
            "data", "hora", "tipoServico", "valor", "sinal", "status", "permiteColaborador"
        };

        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        if (a != null) {
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            // Busca o participante principal
            Participante principal = a.getParticipantes().stream()
                    .filter(p -> "Principal".equalsIgnoreCase(p.getPapel()))
                    .findFirst()
                    .orElse(null);

            // Busca a comissão associada ao participante principal
            Comissao comissao = a.getComissoes().stream()
                    .filter(c -> principal != null && c.getIdProfissional() == principal.getIdProfissional())
                    .findFirst()
                    .orElse(null);

            // Monta os dados da linha
            String idAgenda = String.valueOf(a.getId());
            String idCliente = String.valueOf(a.getIdCliente());
            String idFuncionario = (principal != null) ? String.valueOf(principal.getIdProfissional()) : "N/A";
            String tipoServico = (principal != null) ? principal.getTipoServico() : "N/A";
            String valor = (comissao != null) ? String.valueOf(comissao.getValor()) : "0.0";
            String sinal = String.valueOf(a.getSinal());
            String status = (a.getStatus() != null) ? a.getStatus() : "Agendado";

            String[] linha = {
                idAgenda,
                idCliente,
                idFuncionario,
                formatarDataString(a.getDataAgendada()),
                a.getHorario(),
                tipoServico,
                valor,
                sinal,
                status,
                funcionarioExtra
            };

            tabela.addRow(linha);
        }

        TableAgenda.setModel(tabela);
        configurarTabela();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        TableAgenda.setRowSorter(sorter);

        return tabela;
    }

    public DefaultTableModel montarTabelaID(int idFuncionario) {
        String[] colunas = {
            "idAgenda", "idCliente", "idFuncionario",
            "data", "hora", "tipoServico", "valor",
            "sinal", "status", "permiteColaborador"
        };
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        ArrayList<Agenda> lista = AgendaDAO.buscarPorFuncionario(idFuncionario);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum agendamento para o funcionário selecionado.");
            return tabela;
        }

        for (Agenda a : lista) {
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            // Obtém o participante com o papel "Principal" (ou o próprio idFuncionario)
            Participante participante = a.getParticipantes().stream()
                    .filter(p -> p.getIdProfissional() == idFuncionario)
                    .findFirst()
                    .orElse(null);

            String tipoServico = (participante != null) ? participante.getTipoServico() : "N/A";

            // Obtém a comissão associada ao idFuncionario
            Comissao comissao = a.getComissoes().stream()
                    .filter(c -> c.getIdProfissional() == idFuncionario)
                    .findFirst()
                    .orElse(null);

            String valor = (comissao != null) ? String.valueOf(comissao.getValor()) : "0.0";

            String[] linha = {
                String.valueOf(a.getId()),
                String.valueOf(a.getIdCliente()),
                String.valueOf(idFuncionario),
                formatarDataString(a.getDataAgendada()),
                a.getHorario(),
                tipoServico,
                valor,
                String.valueOf(a.getSinal()),
                (a.getStatus() != null) ? a.getStatus() : "Agendado",
                funcionarioExtra
            };

            tabela.addRow(linha);
        }
        TableAgenda.setModel(tabela);
        configurarTabela();
        reconfigurarTabelaAposFiltro();

        return tabela;
    }

    public DefaultTableModel montarTabelaAPartirDaData(String data, String statusFiltro, Integer idFuncionario,
            Object diaItem, Object mesItem, Object anoItem) {
        String[] colunas = {
            "idAgenda", "idCliente", "idFuncionario",
            "data", "hora", "tipoServico", "valor",
            "sinal", "status", "permiteColaborador"
        };
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        List<Agenda> lista = AgendaDAO.listarTodos();

        // Verifica o estado dos combos
        boolean diaPadrao = "Dia".equals(diaItem);
        boolean mesPadrao = "Mês".equals(mesItem);
        boolean anoPadrao = "Ano".equals(anoItem);

        // Determina o tipo de filtro a ser aplicado
        int tipoFiltro = 0; // 0 = sem filtro de data
        LocalDate dataFiltro = null;
        YearMonth mesAnoFiltro = null;

        try {
            if (!diaPadrao && !mesPadrao && !anoPadrao) {
                // Filtro por data completa
                tipoFiltro = 1;
                int dia = Integer.parseInt(diaItem.toString());
                int mes = Integer.parseInt(mesItem.toString());
                int ano = Integer.parseInt(anoItem.toString());
                dataFiltro = LocalDate.of(ano, mes, dia);
            } else if (diaPadrao && !mesPadrao && !anoPadrao) {
                // Filtro por mês/ano (dia padrão)
                tipoFiltro = 2;
                int mes = Integer.parseInt(mesItem.toString());
                int ano = Integer.parseInt(anoItem.toString());
                mesAnoFiltro = YearMonth.of(ano, mes);
            } else if (diaPadrao && !mesPadrao && anoPadrao) {
                // Filtro apenas por mês (considera ano atual)
                tipoFiltro = 3;
                int mes = Integer.parseInt(mesItem.toString());
                int ano = LocalDate.now().getYear();
                mesAnoFiltro = YearMonth.of(ano, mes);
            }
        } catch (Exception e) {
            System.err.println("Erro ao converter dados do filtro: " + e.getMessage());
        }

        for (Agenda a : lista) {
            String dataAgenda = a.getDataAgendada();
            String situacao = a.getStatus() != null ? a.getStatus().trim() : "Agendado";
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            // Converte a data do agendamento para LocalDate
            LocalDate dataAgendamento;
            try {
                dataAgendamento = LocalDate.parse(dataAgenda);
            } catch (Exception e) {
                System.err.println("Erro ao converter data do agendamento: " + dataAgenda);
                continue;
            }

            // Aplica o filtro de data conforme o tipo
            boolean dataOk;
            switch (tipoFiltro) {
                case 1: // Filtro por data exata
                    dataOk = dataAgendamento.isEqual(dataFiltro);
                    break;
                case 2: // Filtro por mês/ano
                case 3: // Filtro por mês (ano atual)
                    dataOk = YearMonth.from(dataAgendamento).equals(mesAnoFiltro);
                    break;
                default: // Sem filtro de data ou filtro incompleto
                    dataOk = (data == null || dataAgenda.compareTo(data) >= 0);
            }

            boolean statusOk = (statusFiltro == null || situacao.equalsIgnoreCase(statusFiltro));

            // Participante e comissão referentes ao profissional (ou principal)
            List<Participante> participantes = a.getParticipantes();
            List<Comissao> comissoes = a.getComissoes();

            for (Participante p : participantes) {
                int idProfissional = p.getIdProfissional();

                boolean funcionarioOk = (idFuncionario == null || idFuncionario == idProfissional);

                if (dataOk && statusOk && funcionarioOk) {
                    // Busca a comissão correspondente ao mesmo profissional
                    Comissao comissao = comissoes.stream()
                            .filter(c -> c.getIdProfissional() == idProfissional)
                            .findFirst()
                            .orElse(null);

                    String tipoServico = p.getTipoServico() != null ? p.getTipoServico() : "N/A";
                    String valor = (comissao != null) ? String.valueOf(comissao.getValor()) : "0.0";

                    String[] linha = {
                        String.valueOf(a.getId()),
                        String.valueOf(a.getIdCliente()),
                        String.valueOf(idProfissional),
                        formatarDataString(a.getDataAgendada()),
                        a.getHorario(),
                        tipoServico,
                        valor,
                        String.valueOf(a.getSinal()),
                        situacao,
                        funcionarioExtra
                    };

                    tabela.addRow(linha);
                }
            }
        }

        TableAgenda.setModel(tabela);
        configurarTabela();
        reconfigurarTabelaAposFiltro();

        return tabela;
    }

    private int getPosicao() {
        int selectedRow = TableAgenda.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum agendamento selecionado. Por favor, selecione um na tabela.",
                    "Seleção Necessária", JOptionPane.WARNING_MESSAGE);
            return -1;
        }

        try {
            Object valorId = TableAgenda.getValueAt(selectedRow, 0);
            return Integer.parseInt(valorId.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao obter ID do agendamento: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void carregarFuncionarioNoComboBox() {

        if (CheckBoxInativo.isSelected()) {
            List<Funcionario> funcionarios = FuncionarioDAO.buscarPorAtivosInativosComboBox();

            ComboBoxFuncionario.removeAllItems();
            ComboBoxFuncionario.addItem("Selecione");
            ComboBoxFuncionario.addItem("Todos");

            for (Funcionario funcionario : funcionarios) {
                ComboBoxFuncionario.addItem(funcionario.getIdProfissional() + " - " + funcionario.getNome());
            }

        } else {
            List<Cadastro> cadastros = CadastroDAO.buscarPorFuncionariosComboBox();

            ComboBoxFuncionario.removeAllItems();
            ComboBoxFuncionario.addItem("Selecione");
            ComboBoxFuncionario.addItem("Todos");

            for (Cadastro cadastro : cadastros) {
                ComboBoxFuncionario.addItem(cadastro.getId() + " - " + cadastro.getNome());
            }
        }
    }

    //Recebe seleção do combobox e retira valores não numéricos para validar id
    public void listarAgendaPorFuncionario() {
        String texto = ComboBoxFuncionario.getSelectedItem().toString();

        if ("Selecione".equals(texto)) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário !");
            return;
        }
        if ("Todos".equals(texto)) {
            TableAgenda.setModel(montarTabela());
            reconfigurarTabelaAposFiltro(); // Mostra todos
            return;
        }
        // Remove tudo que não for número
        String apenasNumeros = texto.replaceAll("[^0-9]", "");

        if (apenasNumeros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID do funcionário inválido!");
            return;
        }
        int idFuncionario = Integer.parseInt(apenasNumeros);
        TableAgenda.setModel(montarTabelaID(idFuncionario));
    }

    public void atualizarTabela() {
        try {
            List<Agenda> todosAgenda = AgendaDAO.listarTodos();
            atualizarTabelaComResultados(todosAgenda);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar agendamentos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void atualizarTabelaComResultados(List<Agenda> agendado) {
        DefaultTableModel model = (DefaultTableModel) TableAgenda.getModel();
        model.setRowCount(0);

        for (Agenda agenda : agendado) {
            String funcionarioExtra = agenda.isPermiteColaborador() ? "Sim" : "Não";

            // Pegamos o participante principal (papel = "Principal")
            Participante principal = agenda.getParticipantes().stream()
                    .filter(p -> "Principal".equalsIgnoreCase(p.getPapel()))
                    .findFirst()
                    .orElse(null);

            // Pegamos a comissão do profissional principal
            Comissao comissao = agenda.getComissoes().stream()
                    .filter(c -> c.getIdProfissional() == (principal != null ? principal.getIdProfissional() : -1))
                    .findFirst()
                    .orElse(null);

            model.addRow(new Object[]{
                agenda.getId(),
                agenda.getIdCliente(),
                (principal != null ? principal.getIdProfissional() : "N/A"),
                formatarDataString(agenda.getDataAgendada()),
                agenda.getHorario(),
                (principal != null ? principal.getTipoServico() : "N/A"),
                (comissao != null ? comissao.getValor() : 0.0),
                agenda.getSinal(),
                agenda.getStatus(),
                funcionarioExtra
            });
        }
    }

    private void editarAgendaSelecionado() {
        Agenda a = new Agenda();
        int id = getPosicao();
        if (id == -1) {
            return;
        } else {
            a.setId(id);
        }
        try {

            Agenda agendaSelecionado = AgendaDAO.buscarPorId(id);

            if (agendaSelecionado != null) {

                TelaAgendar telaEdicao = new TelaAgendar(agendaSelecionado);
                telaEdicao.setLocationRelativeTo(null);
                telaEdicao.setVisible(true);

                if (telaEdicao.isAtualizacaoRealizada()) {
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Agendamento não encontrado no banco de dados.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao editar agendamento: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

    private void configurarTabela() {
        // Configurações básicas da tabela
        TableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableAgenda.setRowSelectionAllowed(true);
        TableAgenda.setColumnSelectionAllowed(false);

        // Configura o renderizador personalizado
        TableAgenda.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(new Color(0, 120, 215));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
        // Adiciona listener para duplo clique
        TableAgenda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editarAgendaSelecionado();
                }
            }
        });
    }
// IMPORTANTE: Sempre usar atualizarTabela() em vez de setModel() diretamente
// para manter todas as funcionalidades de seleção e eventos

    private void atualizarTabela(DefaultTableModel model) {
        // Salva a linha selecionada antes da atualização
        int selectedRow = TableAgenda.getSelectedRow();

        // Aplica o novo modelo
        TableAgenda.setModel(model);
        // Reconfigura a tabela
        configurarTabela();
        // Restaura a seleção se possível
        if (selectedRow >= 0 && selectedRow < TableAgenda.getRowCount()) {
            TableAgenda.setRowSelectionInterval(selectedRow, selectedRow);
        }
        // Configura o ordenador
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        TableAgenda.setRowSorter(sorter);
        contarLinhasTabela();
    }

    private void contarLinhasTabela() {
        int totalLinhas = TableAgenda.getRowCount();
        LabelErro.setHorizontalAlignment(SwingConstants.CENTER);
        LabelErro.setVerticalAlignment(SwingConstants.CENTER);
        LabelErro.setText("Total de registros : " + totalLinhas);

        if (totalLinhas == 0) {
            LabelErro.setText("Nenhum registro encontrado !");
            LabelErro.setForeground(Color.RED);
            LabelErro.setFont(LabelErro.getFont().deriveFont(Font.BOLD));

            ButtonAtualizar.setEnabled(false);
            ButtonDetalhe.setEnabled(false);
        } else {
            LabelErro.setForeground(Color.BLACK);
            LabelErro.setFont(LabelErro.getFont().deriveFont(Font.PLAIN));
            ButtonAtualizar.setEnabled(true);
            ButtonDetalhe.setEnabled(true);
        }
    }
//      método para as linhas continuarem clicáveis após filtro aplicado  

    private void reconfigurarTabelaAposFiltro() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(TableAgenda.getModel());
        TableAgenda.setRowSorter(sorter);

        TableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableAgenda.setRowSelectionAllowed(true);
        TableAgenda.setEnabled(true);
        contarLinhasTabela();
    }

    private void aplicaFiltroDataSituacao() {
        String dia = (String) ComboDia.getSelectedItem();
        String mes = (String) ComboMes.getSelectedItem();
        String ano = (String) ComboAno.getSelectedItem();

        boolean dataCompleta = !(dia.equals("Dia") || mes.equals("Mês") || ano.equals("Ano"));
        String data = dataCompleta ? (ano + "-" + mes + "-" + dia) : null;

        String statusFiltro = null;
        if (RadioButtonAgendado.isSelected()) {
            statusFiltro = "Agendado";
        } else if (RadioButtonAtendido.isSelected()) {
            statusFiltro = "Atendido";
        } else if (RadioButtonCancelado.isSelected()) {
            statusFiltro = "Cancelado";
        }

        Integer idFuncionario = null;
        String textoCombo = ComboBoxFuncionario.getSelectedItem().toString();
        if (!textoCombo.equals("Todos") && !textoCombo.equals("Selecione")) {
            String apenasNumeros = textoCombo.replaceAll("[^0-9]", "");
            if (!apenasNumeros.isEmpty()) {
                idFuncionario = Integer.parseInt(apenasNumeros);
            }
        }
        montarTabelaAPartirDaData(
                null,
                statusFiltro,
                idFuncionario,
                ComboDia.getSelectedItem(),
                ComboMes.getSelectedItem(),
                ComboAno.getSelectedItem()
        );
    }
// Método para validar se algum filtro está sendo usado, fora o filtro funcionário

    private boolean isFiltro() {
        boolean algumRadioSelecionado = RadioButtonAgendado.isSelected() || RadioButtonAtendido.isSelected() || RadioButtonCancelado.isSelected();
        String dia = ComboDia.getSelectedItem().toString();
        String mes = ComboMes.getSelectedItem().toString();
        String ano = ComboAno.getSelectedItem().toString();
        boolean dataCompleta = !(dia.equals("Dia") || mes.equals("Mês") || ano.equals("Ano"));
        return algumRadioSelecionado || dataCompleta;
    }

    private void aplicarFiltroCliente() {
        String dia = (String) ComboDia.getSelectedItem();
        String mes = (String) ComboMes.getSelectedItem();
        String ano = (String) ComboAno.getSelectedItem();
        boolean dataCompleta = !(dia.equals("Dia") || mes.equals("Mês") || ano.equals("Ano"));
        String data = dataCompleta ? (ano + "-" + mes + "-" + dia) : null;

        String statusFiltro = null;
        if (RadioButtonAgendado.isSelected()) {
            statusFiltro = "Agendado";
        } else if (RadioButtonAtendido.isSelected()) {
            statusFiltro = "Atendido";
        } else if (RadioButtonCancelado.isSelected()) {
            statusFiltro = "Cancelado";
        }
        Integer idFuncionario = null;
        String textoCombo = ComboBoxFuncionario.getSelectedItem().toString();
        if (!textoCombo.equals("Todos") && !textoCombo.equals("Selecione")) {
            String apenasNumeros = textoCombo.replaceAll("[^0-9]", "");
            if (!apenasNumeros.isEmpty()) {
                idFuncionario = Integer.parseInt(apenasNumeros);
            }
        }
        ArrayList<Agenda> lista = AgendaDAO.buscarPorCliente(idCliente);
        DefaultTableModel tabela = new DefaultTableModel(
                new String[]{"idAgenda", "idCliente", "idFuncionario", "data", "hora", "tipoServico", "valor", "sinal", "status", "permiteColaborador"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Agenda a : lista) {
            String situacao = a.getStatus() != null ? a.getStatus().trim() : "Agendado";
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            List<Participante> participantes = a.getParticipantes();
            List<Comissao> comissoes = a.getComissoes();

            for (Participante p : participantes) {
                int idProfissional = p.getIdProfissional();

                boolean filtrarPorStatus = (statusFiltro == null || situacao.equalsIgnoreCase(statusFiltro));
                boolean filtrarPorData = (data == null || a.getDataAgendada().compareTo(data) >= 0);
                boolean filtrarPorFuncionario = (idFuncionario == null || idFuncionario == idProfissional);

                if (filtrarPorStatus && filtrarPorData && filtrarPorFuncionario) {
                    // Localiza a comissão referente ao profissional (pode ser nula)
                    Comissao comissao = comissoes.stream()
                            .filter(c -> c.getIdProfissional() == idProfissional)
                            .findFirst()
                            .orElse(null);

                    String tipoServico = p.getTipoServico() != null ? p.getTipoServico() : "N/A";
                    Double valor = (comissao != null) ? comissao.getValor() : 0.0;

                    Object[] linha = {
                        a.getId(),
                        a.getIdCliente(),
                        idProfissional,
                        formatarDataString(a.getDataAgendada()),
                        a.getHorario(),
                        tipoServico,
                        valor,
                        a.getSinal(),
                        situacao,
                        funcionarioExtra
                    };

                    tabela.addRow(linha);
                }
            }
        }
//        filtroTipo = "FILTRO_CLIENTE";
        TableAgenda.setModel(tabela);
        configurarTabela();
        reconfigurarTabelaAposFiltro();
    }
//Monta tabela com o id do Cliente selecionado no cadastro

    private DefaultTableModel carregarTabela(int idCliente) {
        ArrayList<Agenda> lista = AgendaDAO.buscarPorCliente(idCliente);

        String[] colunas = {"idAgenda", "idCliente", "idFuncionario", "data", "hora", "tipoServico", "valor", "sinal", "status", "permiteColaborador"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Agenda a : lista) {
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";
            String status = (a.getStatus() != null) ? a.getStatus() : "Agendado";

            List<Participante> participantes = a.getParticipantes();
            List<Comissao> comissoes = a.getComissoes();

            for (Participante p : participantes) {
                int idProfissional = p.getIdProfissional();

                // Tenta encontrar a comissão correspondente
                Comissao comissao = comissoes.stream()
                        .filter(c -> c.getIdProfissional() == idProfissional)
                        .findFirst()
                        .orElse(null);

                String tipoServico = p.getTipoServico() != null ? p.getTipoServico() : "N/A";
                double valor = (comissao != null) ? comissao.getValor() : 0.0;

                Object[] linha = {
                    a.getId(),
                    a.getIdCliente(),
                    idProfissional,
                    formatarDataString(a.getDataAgendada()),
                    a.getHorario(),
                    tipoServico,
                    valor,
                    a.getSinal(),
                    status,
                    funcionarioExtra
                };

                tabela.addRow(linha);
            }
        }
        TableAgenda.setModel(tabela);
        reconfigurarTabelaAposFiltro();
        return tabela;
    }

    private void aplicarFiltroFuncionarioGeral() {
        String textoCombo = ComboBoxFuncionario.getSelectedItem().toString();

        if ("Todos".equalsIgnoreCase(textoCombo) || "Selecione".equalsIgnoreCase(textoCombo)) {
            carregarAgendados();
            return;
        }

        String apenasNumeros = textoCombo.replaceAll("[^0-9]", "");
        if (apenasNumeros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID do funcionário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idFuncionario = Integer.parseInt(apenasNumeros);
        TableAgenda.setModel(montarTabelaID(idFuncionario));
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
// Método genérico para listar histórico de cliente ou funcionário no botão histórico

    private DefaultTableModel montarTabelaHistorico(int id, String status) {
        String[] colunas = {
            "ID", "Cliente", "Profissional", "Data", "Hora",
            "Serviço", "Valor", "Sinal", "Status", "Colaborador"
        };

        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Obtém os dados do banco
        List<Agenda> agendamentos;
        try {
            if ("Cliente".equalsIgnoreCase(status)) {
                agendamentos = AgendaDAO.buscarPorCliente(id);
            } else {
                agendamentos = AgendaDAO.buscarPorFuncionario(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar agendamentos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return model;
        }

        if (agendamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum agendamento encontrado para este " + status.toLowerCase(),
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
            return model;
        }

        // Preenche a tabela
        for (Agenda agenda : agendamentos) {
            adicionarAgendamentoATabela(model, agenda, status, id);
        }

        return model;
    }

    private void adicionarAgendamentoATabela(DefaultTableModel model, Agenda agenda, String tipo, int id) {
        String status = agenda.getStatus() != null ? agenda.getStatus() : "Agendado";
        String permiteColab = agenda.isPermiteColaborador() ? "Sim" : "Não";

        for (Participante participante : agenda.getParticipantes()) {
            // Filtra apenas os participantes relevantes
            if ("Funcionário".equalsIgnoreCase(tipo) && participante.getIdProfissional() != id) {
                continue;
            }

            // Obtém a comissão correspondente
            double valor = agenda.getComissoes().stream()
                    .filter(c -> c.getIdProfissional() == participante.getIdProfissional())
                    .findFirst()
                    .map(Comissao::getValor)
                    .orElse(0.0);

            // Adiciona linha na tabela
            model.addRow(new Object[]{
                agenda.getId(),
                agenda.getIdCliente(),
                participante.getIdProfissional(),
                formatarDataString(agenda.getDataAgendada()),
                agenda.getHorario(),
                participante.getTipoServico(),
                valor,
                agenda.getSinal(),
                status,
                permiteColab
            });
        }
    }

    private void configurarListenersRadio() {
        ActionListener listenerStatus = e -> {
            if (RadioButtonAgendado.isSelected()) {
                aplicaFiltroDataSituacao();
            } else if (RadioButtonAtendido.isSelected()) {
                aplicaFiltroDataSituacao();
            } else if (RadioButtonCancelado.isSelected()) {
                aplicaFiltroDataSituacao();
            } else {
                carregarAgendados();
            }
        };

        RadioButtonAgendado.addActionListener(listenerStatus);
        RadioButtonAtendido.addActionListener(listenerStatus);
        RadioButtonCancelado.addActionListener(listenerStatus);
    }
// monta tabela com o último agendamento/atendimento atualizado

    public DefaultTableModel montarTabelaPorId(int idAgenda) {
        String[] colunas = {
            "idAgenda", "idCliente", "idFuncionario",
            "data", "hora", "tipoServico", "valor", "sinal", "status", "permiteColaborador"
        };

        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        // Busca o agendamento atualizado pelo ID
        Agenda a = AgendaDAO.buscarPorId(idAgenda);

        if (a != null) {
            String funcionarioExtra = a.isPermiteColaborador() ? "Sim" : "Não";

            // Busca o participante principal
            Participante principal = a.getParticipantes().stream()
                    .filter(p -> "Principal".equalsIgnoreCase(p.getPapel()))
                    .findFirst()
                    .orElse(null);

            // Busca o valor associado ao participante principal
            Comissao comissao = a.getComissoes().stream()
                    .filter(c -> principal != null && c.getIdProfissional() == principal.getIdProfissional())
                    .findFirst()
                    .orElse(null);

            // Monta os dados da linha
            String idCliente = String.valueOf(a.getIdCliente());
            String idFuncionario = (principal != null) ? String.valueOf(principal.getIdProfissional()) : "N/A";
            String tipoServico = (principal != null) ? principal.getTipoServico() : "N/A";
            String valor = (comissao != null) ? String.valueOf(comissao.getValor()) : "0.0";
            String sinal = String.valueOf(a.getSinal());
            String status = (a.getStatus() != null) ? a.getStatus() : "Agendado";

            String[] linha = {
                String.valueOf(a.getId()),
                idCliente,
                idFuncionario,
                formatarDataString(a.getDataAgendada()),
                a.getHorario(),
                tipoServico,
                valor,
                sinal,
                status,
                funcionarioExtra
            };

            tabela.addRow(linha);
        }

        TableAgenda.setModel(tabela);
        configurarTabela();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        TableAgenda.setRowSorter(sorter);
        contarLinhasTabela();
        return tabela;
    }

    private boolean validaData() {
        boolean dataValida = DateUtils.validarDataFiltro(
                ComboDia.getSelectedItem(),
                ComboMes.getSelectedItem(),
                ComboAno.getSelectedItem(),
                LabelErroData
        );
        LabelErroData.setHorizontalAlignment(SwingConstants.CENTER);
        LabelErroData.setVerticalAlignment(SwingConstants.CENTER);
        return dataValida;
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

        // Preencher anos (do mais antigo ao mais recente)
        ComboAno.removeAllItems();
        ComboAno.addItem("Ano");
        for (int a = anoMinimo; a <= anoMaximo; a++) {
            ComboAno.addItem(String.valueOf(a));
        }
        ComboAno.setSelectedItem(String.valueOf(anoAtual));

        // Preencher meses (1 a 12)
        ComboMes.removeAllItems();
        ComboMes.addItem("Mês");
        for (int m = 1; m <= 12; m++) {
            ComboMes.addItem(String.format("%02d", m));
        }
        ComboMes.setSelectedItem(String.format("%02d", mesAtual));

        // Preencher dias (1 a 31)
        ComboDia.removeAllItems();
        ComboDia.addItem("Dia");
        for (int d = 1; d <= 31; d++) {
            ComboDia.addItem(String.format("%02d", d));
        }
        ComboDia.setSelectedItem(String.format("%02d", diaAtual));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAtualizar;
    private javax.swing.JButton ButtonDetalhe;
    private javax.swing.JButton ButtonListar;
    private javax.swing.JCheckBox CheckBoxInativo;
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboBoxFuncionario;
    private javax.swing.JComboBox<String> ComboDia;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JLabel LabelErro;
    private javax.swing.JLabel LabelErroData;
    private javax.swing.JLabel LabelSelecione;
    private javax.swing.JRadioButton RadioButtonAgendado;
    private javax.swing.JRadioButton RadioButtonAtendido;
    private javax.swing.JRadioButton RadioButtonCancelado;
    private javax.swing.JTable TableAgenda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
