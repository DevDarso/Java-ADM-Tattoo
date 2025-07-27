package admtattoo;

import admtattoo.ListaCadastro.OrigemChamada;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaAgendar extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;

    public TelaAgendar() {
        initComponents();
        configurarComissao();
        TextFieldId.setEditable(false);
        LabelErroData.setVisible(false);
        comboAno.addActionListener(e -> validaData());
        comboMes.addActionListener(e -> validaData());
        comboDia.addActionListener(e -> validaData());
        LabelNomeCliente.setVisible(false);
        carregarFuncionarioNoComboBox();
        carregarServicoNoComboBox();
        preencherCombosDataAtual();
        listenerPreencheValores();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public TelaAgendar(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        initComponents();
        configurarComissao();
        TextFieldId.setEditable(false);
        LabelErroData.setVisible(false);
        comboAno.addActionListener(e -> validaData());
        comboMes.addActionListener(e -> validaData());
        comboDia.addActionListener(e -> validaData());
        LabelNomeCliente.setVisible(false);
        carregarFuncionarioNoComboBox();
        carregarServicoNoComboBox();
        preencherCombosDataAtual();
        listenerPreencheValores();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Pega o id do último cadastro para agendar
    public TelaAgendar(int id) {
        initComponents();
        configurarComissao();
        TextFieldId.setText(String.valueOf(id));
        setIdSelecionado(id);
        TextFieldId.setEditable(false);
        LabelErroData.setVisible(false);
        comboAno.addActionListener(e -> validaData());
        comboMes.addActionListener(e -> validaData());
        comboDia.addActionListener(e -> validaData());
        carregarFuncionarioNoComboBox();
        carregarServicoNoComboBox();
        preencherCombosDataAtual();
        listenerPreencheValores();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public TelaAgendar(Agenda agenda) {
    }

    private void carregarFuncionarioNoComboBox() {
        List<Cadastro> cadastros = CadastroDAO.buscarPorFuncionariosComboBox();

        ComboBoxFuncionario.removeAllItems();
        ComboBoxFuncionario.addItem("Selecione");
        for (Cadastro cadastro : cadastros) {
            ComboBoxFuncionario.addItem(cadastro.getId() + " - " + cadastro.getNome());
        }
    }

    private void carregarServicoNoComboBox() {
        List<Servico> servicos = ServicoDAO.buscarPorServicoNoComboBox();

        // Guarda os serviços em um mapa para fácil acesso
        Map<String, Double> servicosMap = new HashMap<>();
        for (Servico servico : servicos) {
            servicosMap.put(servico.getNomeServico(), servico.getValor());
        }

        ComboBoxServico.removeAllItems();
        ComboBoxServico.addItem("Selecione");
        ComboBoxServico.addItem("Orçamento");

        for (Servico servico : servicos) {
            ComboBoxServico.addItem(servico.getNomeServico());
        }

        // Adiciona listener para preencher o valor automaticamente
        ComboBoxServico.addActionListener(e -> {
            if (ComboBoxServico.getSelectedIndex() > 1) { // Ignora "Selecione" e "Orçamento"
                String servicoSelecionado = (String) ComboBoxServico.getSelectedItem();
                Double valor = servicosMap.get(servicoSelecionado);

                if (valor != null) {
                    // Força uso de ponto como separador decimal, independentemente da localidade do sistema
                    TextFieldValor.setText(String.format(Locale.US, "%.2f", valor));
                    TextFieldValor.setForeground(Color.BLACK);
                }
            } else {
                TextFieldValor.setText("0.00");
                TextFieldValor.setForeground(Color.GRAY);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ButtonListar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxFuncionario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxHora = new javax.swing.JComboBox<>();
        comboDia = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        comboAno = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ComboBoxServico = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TextFieldValor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TextFieldSinal = new javax.swing.JTextField();
        CheckBoxAtendido = new javax.swing.JCheckBox();
        TextFieldId = new javax.swing.JTextField();
        CheckBoxColaborador = new javax.swing.JCheckBox();
        LabelErroData = new javax.swing.JLabel();
        LabelNomeCliente = new javax.swing.JLabel();
        ComboBoxComissao = new javax.swing.JComboBox<>();
        LabelComissao = new javax.swing.JLabel();
        LabelPorcento = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ButtonAgendar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cliente :");

        ButtonListar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonListar.setText("Listar");
        ButtonListar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonListarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ID :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Funcionário :");

        ComboBoxFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        ComboBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxFuncionarioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Agendar para :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Horário :");

        ComboBoxHora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45" }));
        ComboBoxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxHoraActionPerformed(evt);
            }
        });

        comboDia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        comboMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        comboAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tipo de serviço :");

        ComboBoxServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Valor :");

        TextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldValor.setText("0.0");
        TextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldValorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Valor Sinal :");

        TextFieldSinal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldSinal.setText("0.0");

        CheckBoxAtendido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CheckBoxAtendido.setText(" Atendimento ja realizado");

        TextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TextFieldId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldIdFocusGained(evt);
            }
        });
        TextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIdActionPerformed(evt);
            }
        });

        CheckBoxColaborador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CheckBoxColaborador.setText(" Permitir colaborador");

        LabelErroData.setText("jLabel4");

        LabelNomeCliente.setText("teste");

        ComboBoxComissao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ComboBoxComissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" }));

        LabelComissao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelComissao.setText("Comissao :");

        LabelPorcento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelPorcento.setText("%");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("IR PARA AGENDA");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonAgendar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonAgendar.setText("Agendar");
        ButtonAgendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(ButtonAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAgendar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(LabelComissao)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ComboBoxComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelPorcento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ComboBoxServico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldSinal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldValor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelErroData))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(LabelNomeCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckBoxColaborador)
                    .addComponent(CheckBoxAtendido))
                .addGap(225, 225, 225))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldId)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelErroData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelPorcento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBoxComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelComissao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxAtendido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnoActionPerformed

    private void ButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonListarActionPerformed
// identifica que a chamada está vindo de TelaAgendar
        new ListaCadastro(funcionarioLogado, this, OrigemChamada.TelaAgendar).setVisible(true);
    }//GEN-LAST:event_ButtonListarActionPerformed

    private void ButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgendarActionPerformed
        try {
            salvarAgenda();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAgendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_ButtonAgendarActionPerformed

    private void TextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldValorActionPerformed

    private void ComboBoxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxHoraActionPerformed

    private void ComboBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxFuncionarioActionPerformed

    private void TextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIdActionPerformed
        Cadastro c = new Cadastro();
        c.getId();
        TextFieldId.setEditable(false);
    }//GEN-LAST:event_TextFieldIdActionPerformed

    private void TextFieldIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldIdFocusGained

    }//GEN-LAST:event_TextFieldIdFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListaAgenda la = new ListaAgenda();
        la.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setIdSelecionado(int id) {
        TextFieldId.setText(String.valueOf(id));
        TextFieldId.requestFocus(); // Coloca o cursor no campo
        exibeNomeCliente(id);
        LabelNomeCliente.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAgendar().setVisible(true);
        });
    }

    public void exibeNomeCliente(int id) {
        CadastroDAO cDAO = new CadastroDAO();
        String nomeCliente = cDAO.buscarNomeComId(id);
        LabelNomeCliente.setText(nomeCliente);
        LabelNomeCliente.setVisible(true);
        System.out.println("ID cliente -> " + id + "\nNome -> " + nomeCliente);

    }

    // valida id do Funcionário selecionado e remove caracteres não numéricos
    public int validarID(String entrada) {
        String somenteNumeros = entrada.replaceAll("\\D", "");

        if (!somenteNumeros.isEmpty()) {
            try {
                return Integer.parseInt(somenteNumeros);
            } catch (NumberFormatException e) {
                System.err.println("Erro: número fora do intervalo de int.");
                return -1;
            }
        } else {
            return -1;
        }
    }

    public boolean isAtualizacaoRealizada() {
        // Retorna true se os dados foram atualizados
        return true;
    }

    public void limparCampos() {
        TextFieldId.setText("");
        LabelNomeCliente.setText("");
        ComboBoxHora.setSelectedIndex(0);
        ComboBoxFuncionario.setSelectedIndex(0);
        ComboBoxServico.setSelectedIndex(0);
        ComboBoxComissao.setSelectedIndex(0);
        TextFieldValor.setText("0.0");
        TextFieldSinal.setText("0.0");
        CheckBoxAtendido.setSelected(false);
        CheckBoxColaborador.setSelected(false);
        listenerPreencheValores();
        preencherCombosDataAtual();
        LabelPorcento.setVisible(false);
        LabelComissao.setVisible(false);
        ComboBoxComissao.setSelectedIndex(0);
        ComboBoxComissao.setVisible(false);
    }

    private boolean validaData() {
        boolean dataValida = DateUtils.validarDataComUI(
                comboDia.getSelectedItem(),
                comboMes.getSelectedItem(),
                comboAno.getSelectedItem(),
                LabelErroData
        );

        ButtonAgendar.setEnabled(dataValida);
        return dataValida;
    }

    private void listenerPreencheValores() {
        TextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldValor.setText("0.00");
        TextFieldValor.setForeground(Color.GRAY);

        TextFieldValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (TextFieldValor.getText().equals("0.00")) {
                    TextFieldValor.setText("");
                    TextFieldValor.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (TextFieldValor.getText().isEmpty()) {
                    TextFieldValor.setText("0.00");
                    TextFieldValor.setForeground(Color.GRAY);
                }
            }
        });
        TextFieldSinal.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldSinal.setText("0.00");
        TextFieldSinal.setForeground(Color.GRAY);

        TextFieldSinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (TextFieldSinal.getText().equals("0.00")) {
                    TextFieldSinal.setText("");
                    TextFieldSinal.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (TextFieldSinal.getText().isEmpty()) {
                    TextFieldSinal.setText("0.00");
                    TextFieldSinal.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void salvarAgenda() throws SQLException {
        try {
            Agenda a = new Agenda();
            Comissao c = new Comissao();

            // Coleta id funcionario
            String texto = ComboBoxFuncionario.getSelectedItem().toString();
            int idFuncionario = validarID(texto); // Será usado para adicionar o participante depois

            // Coleta horário
            String hora = ComboBoxHora.getSelectedItem().toString();

            // Coleta id do cliente
            String idCliente = TextFieldId.getText();

            // Coleta valor para cálculo de comissao
            double valor = Double.parseDouble(TextFieldValor.getText());
            c.setValor(valor); // se informado com string entra no catch

            // Valores que pertencem a agenda_funcionário
            String tipoServico = ComboBoxServico.getSelectedItem().toString();

            // Valores que pertencem à agenda
            a.setSinal(Double.parseDouble(TextFieldSinal.getText()));

            boolean colaboradorExtra = CheckBoxColaborador.isSelected();
            a.setPermiteColaborador(colaboradorExtra);

            boolean statusAtendido = CheckBoxAtendido.isSelected();

            int dia = Integer.parseInt(comboDia.getSelectedItem().toString());
            int mes = Integer.parseInt(comboMes.getSelectedItem().toString());
            int ano = Integer.parseInt(comboAno.getSelectedItem().toString());
            a.setDataAgendada(ano + "-" + mes + "-" + dia);

            if (!DateUtils.isHojeOuFuturo(dia, mes, ano)) {
                JOptionPane.showMessageDialog(this, "Selecione uma data a partir de hoje.");
                return;
            }
            if (!verificaDataValidaParaSalvar()) {
                return; // Cancela o salvamento
            }
            if ("".equalsIgnoreCase(idCliente)) {
                JOptionPane.showMessageDialog(null, "Selecione um cliente");
                return;
            }
            int idc = Integer.parseInt(TextFieldId.getText());
            a.setIdCliente(idc);

            if ("Orçamento".equalsIgnoreCase(tipoServico) && valor != 0 && !"0".equalsIgnoreCase(ComboBoxComissao.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "O sistema não aceita cobrança para: (" + tipoServico + ")");
                TextFieldValor.setText("0.0");
                TextFieldSinal.setText("0.0");
                ComboBoxComissao.setSelectedIndex(0);
                ComboBoxComissao.setVisible(false);
                LabelComissao.setVisible(false);
                LabelPorcento.setVisible(false);
                return;
            }
            if (valor == 0 && a.getSinal() != 0) {
                JOptionPane.showMessageDialog(null, "Para cobrar um sinal, é preciso que o serviço tenha um valor declarado");
                return;
            }
            if (valor < a.getSinal()) {
                JOptionPane.showMessageDialog(null, "O valor do sinal não pode ser maior que o valor cobrado");
                return;
            }

            if ("Selecione".equalsIgnoreCase(texto)) {
                JOptionPane.showMessageDialog(null, "Selecione um funcionário");
                return;
            }
            a.setIdFuncionario(idFuncionario);

            if ("Selecione".equalsIgnoreCase(tipoServico)) {
                JOptionPane.showMessageDialog(null, "Selecione um tipo de serviço");
                return;
            }
            if ("Selecione".equalsIgnoreCase(hora)) {
                JOptionPane.showMessageDialog(null, "Selecione um horário");
                return;
            }
            a.setHorario(hora);

            if (valor == 0.0 && !"Orçamento".equalsIgnoreCase(tipoServico)) {
                int resposta = JOptionPane.showConfirmDialog(this,
                        "Confirmar agendamento com valor R$0 ?", "Confirmação",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            a.setStatus(statusAtendido ? "Atendido" : "Agendado");

            // Regra específica para Orçamento
            if ("Orçamento".equalsIgnoreCase(tipoServico) && CheckBoxColaborador.isSelected()) {
                JOptionPane.showMessageDialog(null, "Não é possível adicionar colaborador\npara tipo de serviço: (" + tipoServico + ")");
                return;
            }
            // Situação Atendido - abre ComboBoxPorcento
            if (statusAtendido) {
                if (AgendaDAO.agendar(a)) {
                    int idNovoAgendamento = AgendaDAO.buscarUltimoId();
                    AgendaDAO.inserirParticipante(idNovoAgendamento, idFuncionario, "Principal", tipoServico);

                    Comissao cc = new Comissao();
                    cc.setIdAgenda(idNovoAgendamento);
                    cc.setIdProfissional(idFuncionario);
                    cc.setValor(c.getValor());
                    cc.setPorcentagem(Integer.parseInt(ComboBoxComissao.getSelectedItem().toString()));
                    cc.setValorCalculado(c.getValorCalculado());

                    if (!ComissaoUtils.definirPorcentagem(cc, ComboBoxComissao, a.getStatus(), c.getValor(), c.getValor(), this)) {
                        return;
                    }

                    if (deveGravarComissao(tipoServico, statusAtendido)) {
                        ComissaoDAO.inserirComissao(cc);
                    }

                    if (deveGravarInfoExtra(tipoServico, statusAtendido)) {
                        salvarInfoExtra();
                    }

                    JOptionPane.showMessageDialog(null, "Atendimento concluído com sucesso");
                    limparCampos();
                    configurarComissao();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao agendar.");
                }
            } else { // Situação Agendado
                if (AgendaDAO.agendar(a)) {
                    Informacao i = new Informacao();
                    InfoDAO iDAO = new InfoDAO();
                    TelaObs obs = new TelaObs();
                    int idNovoAgendamento = AgendaDAO.buscarUltimoId();
                    AgendaDAO.inserirParticipante(idNovoAgendamento, idFuncionario, "Principal", tipoServico);
                    // Adiciona comissão:
                    c.setValor(valor);
                    c.setPorcentagem(100);
                    c.setIdAgenda(idNovoAgendamento);
                    c.setIdProfissional(idFuncionario);
                    c.setValorCalculado(c.getValorCalculado());
                    ComissaoDAO.inserirComissao(c);

                    salvarInfoExtra();

                    System.out.println("Valor RECEBIDO : " + c.getValor());
                    JOptionPane.showMessageDialog(null, "Agendado com sucesso!");
                    obs.setVisible(true);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao agendar.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite valores válidos" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Erro ao salvar comissão : " + e);
        }

    }
// sempre insere um numero de sessão

    private void salvarInfoExtra() {
        try {
            InfoDAO iDAO = new InfoDAO();
            Informacao i = new Informacao();
            int idAtendido = AgendaDAO.buscarUltimoId();
            i.setIdAgenda(idAtendido);
            int idCliente = Integer.parseInt(TextFieldId.getText().trim());
            int proximaSessao = iDAO.buscarProximaSessao(idCliente);
            i.setSessao(proximaSessao);
            i.setDuracao("00:00");
            i.setNota("");

            if (InfoDAO.adicionarInfo(i)) {
                System.out.println("Informações adicionadas com sucesso");
                System.out.println("SESSÃO -> " + proximaSessao);
            } else {
                System.err.println("Não foi possível salvar informações");
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter ID do cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "ID do cliente inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean deveGravarComissao(String tipoServico, boolean statusAtendido) {
        return !(statusAtendido && "Orçamento".equalsIgnoreCase(tipoServico));
    }

    private boolean deveGravarInfoExtra(String tipoServico, boolean statusAtendido) {
        return !(statusAtendido && "Orçamento".equalsIgnoreCase(tipoServico));
    }

    private void configurarComissao() {
        // Define o estado inicial
        atualizarVisibilidadeCamposComissao();

        // Listener para mudanças no CheckBoxAtendido
        CheckBoxAtendido.addActionListener(e -> {
            atualizarVisibilidadeCamposComissao();
        });

        // Listener para mudanças no ComboBoxServico
        ComboBoxServico.addActionListener(e -> {
            atualizarVisibilidadeCamposComissao();
        });
    }

    private void atualizarVisibilidadeCamposComissao() {
        boolean atendido = CheckBoxAtendido.isSelected();
        Object itemSelecionado = ComboBoxServico.getSelectedItem();

        // Verifica se o item selecionado não é nulo
        boolean ehOrcamento = itemSelecionado != null
                && "Orçamento".equalsIgnoreCase(itemSelecionado.toString());

        // Lógica para campos de comissão
        boolean mostrarCamposComissao = atendido && !ehOrcamento;
        LabelPorcento.setVisible(mostrarCamposComissao);
        LabelComissao.setVisible(mostrarCamposComissao);
        ComboBoxComissao.setVisible(mostrarCamposComissao);

        // Lógica para TextFieldSinal e TextFieldValor
        boolean habilitarCamposValor = !ehOrcamento;
        TextFieldSinal.setEnabled(habilitarCamposValor);
        TextFieldValor.setEnabled(habilitarCamposValor);
        CheckBoxColaborador.setEnabled(habilitarCamposValor);
    }

    private void preencherCombosDataAtual() {
        LocalDate hoje = LocalDate.now();
        int diaAtual = hoje.getDayOfMonth();
        int mesAtual = hoje.getMonthValue();
        int anoAtual = hoje.getYear();

        // Preencher anos (ano atual e próximo)
        comboAno.removeAllItems();
        for (int a = anoAtual; a <= anoAtual + 1; a++) {
            comboAno.addItem(String.valueOf(a));
        }
        comboAno.setSelectedItem(String.valueOf(anoAtual));

        comboMes.removeAllItems();
        for (int m = 1; m <= 12; m++) {
            comboMes.addItem(String.format("%02d", m));
        }
        comboMes.setSelectedItem(String.format("%02d", mesAtual));

        comboDia.removeAllItems();
        for (int d = 1; d <= 31; d++) {
            comboDia.addItem(String.format("%02d", d));
        }
        comboDia.setSelectedItem(String.format("%02d", diaAtual));
    }

    private boolean verificaDataValidaParaSalvar() {
        try {
            int dia = Integer.parseInt(comboDia.getSelectedItem().toString());
            int mes = Integer.parseInt(comboMes.getSelectedItem().toString());
            int ano = Integer.parseInt(comboAno.getSelectedItem().toString());

            boolean statusAtendido = CheckBoxAtendido.isSelected();

            LocalDate dataSelecionada = LocalDate.of(ano, mes, dia);
            LocalDate dataAtual = LocalDate.now();

            if (statusAtendido) {
                if (dataSelecionada.isAfter(dataAtual)) {
                    JOptionPane.showMessageDialog(this,
                            "Não é possível confirmar atendimento para uma data que ainda não aconteceu,\n"
                            + "edite a data informada caso necessário.",
                            "Data Inválida", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else {
                if (dataSelecionada.isBefore(dataAtual)) {
                    JOptionPane.showMessageDialog(this,
                            "Não é possível agendar para uma data passada.",
                            "Data Inválida", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }

            if (!validaData()) {
                JOptionPane.showMessageDialog(this,
                        "Não é possível agendar para a data informada.",
                        "Erro", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            return true;

        } catch (DateTimeParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Data inválida. Verifique os campos da data informada.",
                    "Erro de Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgendar;
    private javax.swing.JButton ButtonListar;
    private javax.swing.JCheckBox CheckBoxAtendido;
    private javax.swing.JCheckBox CheckBoxColaborador;
    private javax.swing.JComboBox<String> ComboBoxComissao;
    private javax.swing.JComboBox<String> ComboBoxFuncionario;
    private javax.swing.JComboBox<String> ComboBoxHora;
    private javax.swing.JComboBox<String> ComboBoxServico;
    private javax.swing.JLabel LabelComissao;
    private javax.swing.JLabel LabelErroData;
    private javax.swing.JLabel LabelNomeCliente;
    private javax.swing.JLabel LabelPorcento;
    private javax.swing.JTextField TextFieldId;
    private javax.swing.JTextField TextFieldSinal;
    private javax.swing.JTextField TextFieldValor;
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
