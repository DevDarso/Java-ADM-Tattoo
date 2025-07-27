package admtattoo;

import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AtualizarAgenda extends javax.swing.JFrame {

    private int porcento; //carrega combo principal na atualização
    private int idCliente;
    private int idFuncionario;
    private int idAgenda;
    private double valor;// valor total
    private double valor1; // valor funcionario
    private double valor2; // valor colaborador
    private CadastroDAO CadastroDAO;
    private AgendaDAO AgendaDAO;
    private ComissaoDAO ComissaoDAO;
    private InfoDAO InfoDAO;
    private ListaAgenda la;
    private String nomeCliente = "";
    private String status;

    ConexaoJDBC cjdbc = new ConexaoJDBC();

    Agenda a = new Agenda();
    Comissao c = new Comissao();
    Informacao i = new Informacao();
    Participante p = new Participante();
    private boolean atualizado = false;

   // String s = p.getTipoServico();

    public AtualizarAgenda(Agenda a, ListaAgenda la) {
        this.la = la; // salva a instância recebida
        this.a = a;
        this.idCliente = a.getIdCliente();
        this.idFuncionario = a.getIdFuncionario();
        this.idAgenda = a.getId();
        this.status = a.getStatus();
        initComponents();
        carregaStatus();
        carregaComboBoxData();
        carregarDados();
        LabelErroData.setVisible(false);
        exibeErro();
        listenerPreencheValores();
        comboDia.addActionListener(e -> validaData());
        comboMes.addActionListener(e -> validaData());
        comboAno.addActionListener(e -> validaData());
        permiteColaborador();
        configurarCheckBoxes();
        inicializarEstadoInicial();
        ComboBoxFuncionarioListener();
        permiteColaborador();
        TextFieldSinal.setEditable(false);
        atualizarEstadoComboBox();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    public AtualizarAgenda(int id) {
        initComponents();
        carregarDados();
        carregaStatus();
        exibeErro();
        listenerPreencheValores();
        TextFieldSinal.setEditable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    public AtualizarAgenda() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LabelIdAgenda = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LabelCPF = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelNome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ComboBoxHora = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        TextFieldValorTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboAno = new javax.swing.JComboBox<>();
        LabelErroData = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox<>();
        comboDia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TextFieldSinal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CheckBoxColaborador = new javax.swing.JCheckBox();
        LabelErro = new javax.swing.JLabel();
        TextFieldValor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ComboBoxServico = new javax.swing.JComboBox<>();
        ComboBoxFuncionario = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LabelFuncionario = new javax.swing.JLabel();
        LabelComissao = new javax.swing.JLabel();
        ComboBoxPorcento = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        ComboBoxFuncionario2 = new javax.swing.JComboBox<>();
        LabelFuncionario2 = new javax.swing.JLabel();
        LabelNomeFuncionario2 = new javax.swing.JLabel();
        LabelServico2 = new javax.swing.JLabel();
        ComboBoxServico2 = new javax.swing.JComboBox<>();
        LabelValor2 = new javax.swing.JLabel();
        TextFieldValor2 = new javax.swing.JTextField();
        LabelComissao2 = new javax.swing.JLabel();
        ComboBoxPorcento2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        LabelStatus = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        CheckBoxAtendido = new javax.swing.JCheckBox();
        CheckBoxCancelado = new javax.swing.JCheckBox();
        ButtonAtualizar = new javax.swing.JButton();
        LabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("ID agenda:");

        LabelIdAgenda.setText(String.valueOf(idAgenda));

        jLabel4.setText("ID cliente:");

        LabelID.setText("jLabel5");

        jLabel6.setText("CPF:");

        LabelCPF.setText("jLabel7");

        jLabel8.setText("Cliente:");

        LabelNome.setText(nomeCliente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelIdAgenda))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelNome)))
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelID)
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(LabelCPF)
                .addGap(155, 155, 155))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelIdAgenda)
                    .addComponent(jLabel4)
                    .addComponent(LabelID)
                    .addComponent(jLabel6)
                    .addComponent(LabelCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LabelNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ComboBoxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45" }));

        jLabel11.setText("Hora:");

        TextFieldValorTotal.setText("jTextField1");

        jLabel3.setText("Valor cobrado:");

        LabelErroData.setText("jLabel5");

        jLabel10.setText("Data:");

        TextFieldSinal.setText("jTextField1");

        jLabel12.setText("Sinal de adiantamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelErroData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelErroData)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldSinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
        );

        CheckBoxColaborador.setText("Adicionar colaborador ");
        CheckBoxColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxColaboradorActionPerformed(evt);
            }
        });

        LabelErro.setText("jLabel18");

        TextFieldValor.setText("jTextField2");

        jLabel17.setText("Valor:");

        jLabel16.setText("Serviço:");

        ComboBoxServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Funcionário:");

        jLabel13.setText("_____________________________________________________________________________________________");

        LabelFuncionario.setText("jLabel5");

        LabelComissao.setText("Comissão:");

        ComboBoxPorcento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(CheckBoxColaborador))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 101, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(LabelComissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelFuncionario)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelComissao)
                    .addComponent(ComboBoxPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckBoxColaborador))
        );

        jLabel23.setText("_____________________________________________________________________________________________");

        ComboBoxFuncionario2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        LabelFuncionario2.setText("Funcionário 2:");

        LabelNomeFuncionario2.setText("jLabel7");

        LabelServico2.setText("Serviço:");

        ComboBoxServico2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LabelValor2.setText("Valor:");

        TextFieldValor2.setText("jTextField2");

        LabelComissao2.setText("Comissão:");

        ComboBoxPorcento2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(LabelFuncionario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNomeFuncionario2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(LabelValor2))
                    .addComponent(LabelServico2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TextFieldValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(LabelComissao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxPorcento2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboBoxServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNomeFuncionario2)
                    .addComponent(LabelFuncionario2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelServico2)
                    .addComponent(ComboBoxServico2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelComissao2)
                    .addComponent(ComboBoxPorcento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelValor2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LabelStatus.setText(a.getStatus());

        jLabel24.setText("Status:");

        CheckBoxAtendido.setText("Atendido");

        CheckBoxCancelado.setText("Cancelado");

        ButtonAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonAtualizar.setText("Atualizar");
        ButtonAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxAtendido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CheckBoxCancelado))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(LabelStatus)
                    .addComponent(CheckBoxAtendido)
                    .addComponent(CheckBoxCancelado))
                .addGap(12, 12, 12)
                .addComponent(ButtonAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LabelTitulo.setText("Atualizar agenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAtualizarActionPerformed
        if (a.isPermiteColaborador() && !CheckBoxColaborador.isSelected()) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    "Se o colaborador não for adicionado\nserá impossível adicioná-lo posteriormente.\nDeseja prosseguir ?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resposta != JOptionPane.YES_OPTION) {
                return;
            }
        }
        salvarAlteracoes();
    }//GEN-LAST:event_ButtonAtualizarActionPerformed

    private void CheckBoxColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxColaboradorActionPerformed

    }//GEN-LAST:event_CheckBoxColaboradorActionPerformed

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
            java.util.logging.Logger.getLogger(AtualizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarAgenda().setVisible(true);
            }
        });
    }

    public boolean isAtualizado() {
        return atualizado;
    }

    private void carregaStatus() {
        if ("Atendido".equalsIgnoreCase(status)) {
            LabelStatus.setForeground(Color.RED);
            LabelStatus.setFont(LabelStatus.getFont().deriveFont(Font.BOLD));
        } else {
            LabelStatus.setForeground(Color.GREEN);
            LabelStatus.setFont(LabelStatus.getFont().deriveFont(Font.BOLD));
        }
    }

    private void carregarServicoNoComboBox() {
        List<Servico> servicos = ServicoDAO.buscarPorServicoNoComboBox();

        // Carrega participante principal com o tipo de serviço já salvo
        Participante p = AgendaDAO.carregarParticipante(idAgenda, idFuncionario);
        String servicoSalvo = p.getTipoServico();

        // Mapa para acessar valor do serviço por nome
        Map<String, Double> servicosMap = new HashMap<>();
        for (Servico servico : servicos) {
            servicosMap.put(servico.getNomeServico(), servico.getValor());
        }
        ComboBoxServico.removeAllItems();
        ComboBoxServico2.removeAllItems();

        // Adiciona os itens fixos
        if ("Orçamento".equalsIgnoreCase(servicoSalvo)) {
            ComboBoxServico.addItem("Orçamento");
        }
        ComboBoxServico2.addItem("Selecione");

        // Preenche com os serviços do banco
        for (Servico servico : servicos) {
            ComboBoxServico.addItem(servico.getNomeServico());
            ComboBoxServico2.addItem(servico.getNomeServico());
        }

        // Define o serviço salvo como selecionado no ComboBoxServico
        ComboBoxServico.setSelectedItem(servicoSalvo);

        // Listener do ComboBoxServico - atualiza TextFieldValor
        ComboBoxServico.addActionListener(e -> {
            if (ComboBoxServico.getSelectedIndex() > 0) { // Ignora "Orçamento"
                String servicoSelecionado = (String) ComboBoxServico.getSelectedItem();
                Double valor = servicosMap.get(servicoSelecionado);

                if (valor != null) {
                    TextFieldValor.setText(String.format(Locale.US, "%.2f", valor));
                    TextFieldValor.setForeground(Color.BLACK);
                }
            } else {
                TextFieldValor.setText("0.00");
                TextFieldValor.setForeground(Color.GRAY);
            }
        });

        // Listener do ComboBoxServico2 - atualiza TextFieldValor2
        ComboBoxServico2.addActionListener(e -> {
            if (ComboBoxServico2.getSelectedIndex() > 0) { // Ignora "Selecione"
                String servicoSelecionado = (String) ComboBoxServico2.getSelectedItem();
                Double valor = servicosMap.get(servicoSelecionado);

                if (valor != null) {
                    TextFieldValor2.setText(String.format(Locale.US, "%.2f", valor));
                    TextFieldValor2.setForeground(Color.BLACK);
                }
            } else {
                TextFieldValor2.setText("0.00");
                TextFieldValor2.setForeground(Color.GRAY);
            }
        });
    }

    private void carregarDados() {
        LabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        LabelTitulo.setVerticalAlignment(SwingConstants.CENTER);
        try {
            //Validação inicial
            if (status == null) {
                status = ""; // Valor padrão
            }
            //Carrega dados
            Cadastro cadastroCliente = new CadastroDAO().buscarNomePeloId(idCliente);
            if (cadastroCliente == null) {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado para o ID: " + idCliente,
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CadastroDAO cDAO = new CadastroDAO();
            idFuncionario = AgendaDAO.buscarIdFuncionarioPorAgenda(idAgenda);
            Cadastro cadastroFuncionario = cDAO.buscarNomePeloId(idFuncionario);
            idFuncionario = AgendaDAO.buscarIdFuncionarioPorAgenda(idAgenda);
            c = ComissaoDAO.buscarComissao(idAgenda, idFuncionario);

            if (c != null) {
                porcento = c.getPorcentagem();
                valor = c.getValor();
            }
            // Preenche os campos com os dados do agendamento
            nomeCliente = cadastroCliente.getNome();
            String nomeFuncionario = cadastroFuncionario.getNome();
            LabelCPF.setText(cadastroCliente.getCpf());
            LabelID.setText(Integer.toString(idCliente));
            LabelFuncionario.setText(nomeFuncionario);
            LabelNomeFuncionario2.setText(ComboBoxFuncionario2.getSelectedItem().toString());
            LabelNome.setText(nomeCliente);
// Preenche valor e tipo de serviço a partir do participante
            TextFieldValor.setText(String.valueOf(valor));
            TextFieldSinal.setText(String.valueOf(a.getSinal()));
            ComboBoxHora.setSelectedItem(a.getHorario());

            if (!"Agendado".equalsIgnoreCase(status) && c.getPorcentagem() != 0) {
                ComboBoxPorcento.setSelectedItem(String.valueOf(porcento));
            } else {
                ComboBoxPorcento.setSelectedItem("0");
            }
            preencherDataNosCombos(a.getDataAgendada());
            carregarFuncionarioNoComboBox(idFuncionario);
            carregarServicoNoComboBox();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibeErro() {
        if (a.isPermiteColaborador() && "Atendido".equalsIgnoreCase(status)) {
            LabelErro.setVisible(true);
            LabelErro.setText("<html>"
                    + "Se status for 'Atendido' ou 'Cancelado', não é possível atualizar,<br>"
                    + "mas caso esteja disponível, ainda é possível adicionar colaborador!"
                    + "</html>");
            LabelErro.setForeground(Color.RED);
            LabelErro.setFont(new Font("Arial", Font.PLAIN, 12));
            LabelErro.setHorizontalAlignment(SwingConstants.CENTER);
            LabelErro.setVerticalAlignment(SwingConstants.CENTER);
            LabelErro.setForeground(Color.RED);
        } else {
            LabelErro.setVisible(false);
        }
    }

    private void preencherDataNosCombos(String dataMysql) {
        if (dataMysql != null && !dataMysql.isEmpty()) {
            String[] partes = dataMysql.split("-"); // [0]=ano, [1]=mês, [2]=dia
            if (partes.length == 3) {
                String ano = partes[0];
                String mes = String.format("%02d", Integer.parseInt(partes[1]));
                String dia = String.format("%02d", Integer.parseInt(partes[2]));

                comboDia.setSelectedItem(dia);
                comboMes.setSelectedItem(mes);
                comboAno.setSelectedItem(ano);
                String completa = ano + mes + dia;
                System.out.println("Data completa: " + completa);
            }
        }
    }

    private void carregarFuncionarioNoComboBox(int idSelecionado) {
        List<Cadastro> cadastros = CadastroDAO.buscarPorFuncionariosComboBox();
        ComboBoxFuncionario.removeAllItems();
        ComboBoxFuncionario2.removeAllItems();
        ComboBoxFuncionario2.addItem("Selecione");
        for (Cadastro cadastro : cadastros) {
            String idStr = String.valueOf(cadastro.getId());
            ComboBoxFuncionario.addItem(String.valueOf(cadastro.getId()));
            ComboBoxFuncionario2.addItem(String.valueOf(cadastro.getId()));

            // Seleciona automaticamente se for o ID correto
            if (cadastro.getId() == idSelecionado) {
                ComboBoxFuncionario.setSelectedItem(idStr);
            }
        }
    }

    private void salvarAlteracoes() {
        try {
            Comissao com = new Comissao();
            //Coleta e validação dos campos principal e colaborador (se houver)
            String tipoServico = ComboBoxServico.getSelectedItem().toString();
            String servicoColab = ComboBoxServico2.getSelectedItem().toString();
            String comisColab = ComboBoxPorcento2.getSelectedItem().toString();
            String nomeColab = ComboBoxFuncionario2.getSelectedItem().toString();
            double valorTotal = Double.parseDouble(TextFieldValorTotal.getText().trim().replace(",", "."));
            valor1 = Double.parseDouble(TextFieldValor.getText().trim().replace(",", "."));
            valor2 = Double.parseDouble(TextFieldValor2.getText().trim().replace(",", "."));
            double valorSinal = Double.parseDouble(TextFieldSinal.getText().trim().replace(",", "."));
            boolean statusAtendido = CheckBoxAtendido.isSelected();
            boolean statusCancelado = CheckBoxCancelado.isSelected();
            String status = LabelStatus.getText();
            System.out.println("VALOR TOTAL - R$: " + valorTotal);

            if (statusCancelado && !"Agendado".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(rootPane, "Não é permitido cancelar quando o status está : " + status);
                return;
            }
            if (valorTotal == 0.00) {
                ComboBoxPorcento.setSelectedItem("0");
                ComboBoxPorcento2.setSelectedItem("0");
            }

            if (statusAtendido) {
                String dataTexto = comboAno.getSelectedItem() + "-" + comboMes.getSelectedItem() + "-" + comboDia.getSelectedItem();
                LocalDate dataInformada = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (dataInformada.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(this, "Não é possível confirmar atendimento para uma data futura.", "Data Inválida", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (valor1 > valorTotal || valor2 > valorTotal) {
                JOptionPane.showMessageDialog(this, "O valor do funcionário não pode ser maior que o valor cobrado do cliente");
                return;
            }

            if (valorTotal == 0 && valorSinal != 0) {
                JOptionPane.showMessageDialog(this, "O valor do sinal deve ser 0 se o valor total for 0.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (valorSinal > valorTotal) {
                JOptionPane.showMessageDialog(this, "O valor do sinal não pode ser maior que o valor total.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!ComissaoUtils.definirPorcentagem(com, ComboBoxPorcento, status, valor1, valor, this)) {
                return;
            }
            //Colaborador extra (se houver)
            if (CheckBoxColaborador.isSelected()) {
                Comissao comissaoColab = new Comissao();
                if ("Selecione".equalsIgnoreCase(nomeColab)) {
                    JOptionPane.showMessageDialog(rootPane, "Selecione um funcionário colaborador");
                    return;
                }
                if ("Selecione".equalsIgnoreCase(servicoColab)) {
                    JOptionPane.showMessageDialog(rootPane, "Selecione um tipo de serviço");
                    return;
                }
                // Valida se o colaborador é o mesmo funcionário principal
                int idPrincipal = Integer.parseInt(ComboBoxFuncionario.getSelectedItem().toString());
                int idColaborador = Integer.parseInt(ComboBoxFuncionario2.getSelectedItem().toString());

                if (idColaborador == idPrincipal) {
                    JOptionPane.showMessageDialog(this, "O colaborador não pode ser o mesmo funcionário principal.", "Erro", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                comissaoColab.setIdAgenda(Integer.parseInt(LabelIdAgenda.getText()));
                comissaoColab.setIdProfissional(Integer.parseInt(ComboBoxFuncionario2.getSelectedItem().toString()));
                comissaoColab.setValor(valor2);
                comissaoColab.setValorCalculado(comissaoColab.getValorCalculado());
                System.out.println("Colaborador -> Valor : " + valor2 + " -> Porcentagem : " + comissaoColab.getPorcentagem() + " -> Resultado : " + comissaoColab.getValorCalculado());

                if (!ComissaoUtils.definirPorcentagem(comissaoColab, ComboBoxPorcento2, status, valor2, valor, this)) {
                    return;
                }
                // Verifica se o colaborador já existe antes de inserir
                if (!AgendaDAO.participanteExiste(idAgenda, comissaoColab.getIdProfissional(), "Colaborador")) {
                    AgendaDAO.inserirParticipante(
                            comissaoColab.getIdAgenda(),
                            comissaoColab.getIdProfissional(),
                            "Colaborador",
                            servicoColab
                    );
                } else {
                    AgendaDAO.atualizarTipoServico(idAgenda, comissaoColab.getIdProfissional(), servicoColab);
                }
                if (!ComissaoDAO.existeComissao(comissaoColab.getIdAgenda(), comissaoColab.getIdProfissional())) {
                    ComissaoDAO.inserirComissao(comissaoColab);
                } else {
                    ComissaoDAO.atualizarValores(comissaoColab);
                }
                AgendaDAO.atualizarFuncionarioExtra(comissaoColab.getIdAgenda(), false);
// Se o usuário desmarca o CheckBoxColaborador com valor informado, não altera valor principal
            } else {
                if (a.isPermiteColaborador() && !CheckBoxColaborador.isSelected()) {
                    valor2 = 0.00;
                    valor1 = valorTotal;

                }
            }
            int idAgenda = Integer.parseInt(LabelIdAgenda.getText());
            String texto = ComboBoxFuncionario.getSelectedItem().toString();
            int novoIdFuncionario = Integer.parseInt(texto);
            int idFuncionarioAntigo = AgendaDAO.buscarIdFuncionarioPorAgenda(idAgenda);

            Agenda a = new Agenda();
            a.setId(idAgenda);
            a.setIdFuncionario(novoIdFuncionario);
            a.setDataAgendada(comboAno.getSelectedItem() + "-" + comboMes.getSelectedItem() + "-" + comboDia.getSelectedItem());
            a.setHorario(ComboBoxHora.getSelectedItem().toString());
            a.setSinal(valorSinal);
            if ("Atendido".equalsIgnoreCase(status)) {
                a.setStatus("Atendido");
            } else {
                a.setStatus(statusCancelado ? "Cancelado" : (statusAtendido ? "Atendido" : "Agendado"));
            }
            a.setIdFuncionario(novoIdFuncionario);

            if (!validaColaborador()) {
                return;
            }

            if (AgendaDAO.atualizar(a) && validaData()) {
                atualizado = true;

                Comissao comissaoFunc = new Comissao();
                comissaoFunc.setIdAgenda(idAgenda);
                comissaoFunc.setIdProfissional(novoIdFuncionario);

                comissaoFunc.setValor(valor1);
                int porcentagem = Integer.parseInt(ComboBoxPorcento.getSelectedItem().toString());
                comissaoFunc.setPorcentagem(porcentagem);

                if ("Orçamento".equalsIgnoreCase(tipoServico) && valorTotal > 0 && porcentagem != 0) {
                    JOptionPane.showMessageDialog(this, "Não é permitido cobrança de valores/comissão para o tipo 'Orçamento'.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    valor1 = 0.00;
                    valorTotal = 0.00;
                    porcentagem = 0;
                    return;
                }

                if (!ComissaoUtils.definirPorcentagem(comissaoFunc, ComboBoxPorcento, status, valor1, valor, this)) {
                    return;
                }
                if (valor1 == 0.0 && valor2 == valorTotal && valorTotal != 0.00) {
                    int resposta = JOptionPane.showConfirmDialog(this,
                            "Se o valor do colaborador for igual ao valor total,\na comissão do funcionário principal será atualizada para 0.\nDeseja prosseguir?",
                            "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resposta != JOptionPane.YES_OPTION) {
                        return;
                    }
                    porcentagem = 0;
                    comissaoFunc.setPorcentagem(porcentagem);
                }
                System.out.println("Funcionário 1 -> Valor : " + valor1 + " -> Porcentagem : " + comissaoFunc.getPorcentagem() + " -> Resultado : " + comissaoFunc.getValorCalculado());

                if (ComissaoDAO.existeComissao(idAgenda, novoIdFuncionario)) {
                    ComissaoDAO.atualizarValores(comissaoFunc);
                    if ("Orçamento".equalsIgnoreCase(tipoServico)) {
                        ComissaoDAO.excluir(idAgenda);
                        InfoDAO.excluirInfo(idAgenda);
                    }
                } else {
                    if (!"Orçamento".equalsIgnoreCase(tipoServico)) {
                        ComissaoDAO.inserirComissao(comissaoFunc);
                    }
                }
                if (novoIdFuncionario != idFuncionarioAntigo) {
                    boolean ok = AgendaDAO.atualizarFuncionario(
                            idAgenda, novoIdFuncionario, idFuncionarioAntigo, tipoServico);
                    if (!ok) {
                        JOptionPane.showMessageDialog(this, "Não foi possível atualizar o profissional principal.");
                    }
                } else {
                    AgendaDAO.atualizarTipoServico(idAgenda, novoIdFuncionario, tipoServico);
                }
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
                if (la != null) {
                    la.carregarAgendados();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar AGENDA", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Certifique-se de que todos os campos estão preenchidos corretamente.\n" + e,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
// Permite desbloqueio de atualização com data retroativa        

    private boolean aceitaAtualizar() {
        if (a.isPermiteColaborador() && !"Atendido".equalsIgnoreCase(status)
                || !"Cancelado".equalsIgnoreCase(status));
        return true;
    }

    private boolean validaData() {
        if (!aceitaAtualizar()) {
            boolean dataValida = DateUtils.validarDataComUI(
                    comboDia.getSelectedItem(),
                    comboMes.getSelectedItem(),
                    comboAno.getSelectedItem(),
                    LabelErroData
            );
            ButtonAtualizar.setEnabled(dataValida);
            return dataValida;
        }
        return true;
    }

    private boolean validaColaborador() {
        // VALIDA O STATUS para proibir novas edições
        boolean statusAtendidoFinal = CheckBoxAtendido.isSelected();
        boolean statusCanceladoFinal = CheckBoxCancelado.isSelected();
        boolean colaborador = CheckBoxColaborador.isSelected();

        if (colaborador && !statusAtendidoFinal) {
            JOptionPane.showMessageDialog(rootPane, "Para adicionar um colaborador,\na caixa 'Atendido' deve estar selecionada.");
            return false;
        }
        if ("Atendido".equalsIgnoreCase(status) || "Agendado".equalsIgnoreCase(status) && statusAtendidoFinal) {
            a.setPermiteColaborador(false); // trava futuras edições de colaborador
            a.setStatus(status);
            return true;
        } else {
            a.setPermiteColaborador(true);
            a.setStatus(statusCanceladoFinal ? "Cancelado" : (statusAtendidoFinal ? "Atendido" : "Agendado"));
        }
        System.out.println("Status a ser salvo: " + a.getStatus());
        return true;
    }
// limpa os campos se usuário tentar salvar com status cancelado ou orçamento               
/*
  private void limpaInfoExtra(){

                ComboBoxPorcento.setSelectedItem("0");
                ComboBoxPorcento2.setSelectedItem("0");
 } 

  private boolean statusPermiteSalvarInfoAdicional() {
    String statusAtual = LabelStatus.getText();
    if (statusAtual == null) {
        return false;
    }
    return "Atendido".equalsIgnoreCase(statusAtual.trim()) || CheckBoxAtendido.isSelected();
}*/
    private void permiteColaborador() {
        boolean permite = a.isPermiteColaborador();
        CheckBoxColaborador.setVisible(permite);
        if (!permite) {
            modoColaboradorDesativado();
        }
    }

    private void inicializarEstadoInicial() {
        if ("Atendido".equalsIgnoreCase(status)) {
            // Regras para status = Atendido:
            CheckBoxAtendido.setSelected(true);
            CheckBoxCancelado.setEnabled(false);
            CheckBoxAtendido.setEnabled(true);

            if (CheckBoxColaborador.isSelected()) {
                modoColaboradorAtivado();
            }
            if (valor == 0.00) {
                desabilitarCamposPrincipal();
                habilitarCamposColaboradorBasico();
            } else {
                desabilitarCamposPrincipal();
                habilitarCamposColaboradorCompleto();
            }
        } else {
            CheckBoxAtendido.setSelected(false);
            CheckBoxCancelado.setEnabled(true);
            habilitarTodosCampos();
        }
    }

    private void configurarCheckBoxes() {
        ActionListener statusListener = e -> {
            JCheckBox source = (JCheckBox) e.getSource();
            if (source == CheckBoxAtendido && source.isSelected()) {
                CheckBoxCancelado.setSelected(false);
            }
            if (source == CheckBoxCancelado && source.isSelected()) {
                CheckBoxAtendido.setSelected(false);
            }
        };
        CheckBoxAtendido.addActionListener(statusListener);
        CheckBoxCancelado.addActionListener(statusListener);
        // Listener do CheckBoxColaborador
        CheckBoxColaborador.addActionListener(e -> {
            if (CheckBoxColaborador.isSelected()) {
                modoColaboradorAtivado();
            } else {
                modoColaboradorDesativado();
            }
        });
    }

    private void habilitarTodosCampos() {
        setEnabledTodosCampos(true);
        TextFieldSinal.setEnabled(false);
    }

    private void desabilitarCamposPrincipal() {
        // Campos do funcionário principal
        ComboBoxPorcento.setEnabled(false);
        TextFieldValor.setEnabled(false);
        ComboBoxPorcento.setEnabled(false);
        TextFieldValor.setEnabled(false);
        TextFieldValorTotal.setEnabled(false);
        ComboBoxFuncionario.setEnabled(false);
        comboDia.setEnabled(false);
        comboMes.setEnabled(false);
        comboAno.setEnabled(false);
        ComboBoxHora.setEnabled(false);
        ComboBoxServico.setEnabled(false);
    }

    private void habilitarCamposColaboradorBasico() {
        ComboBoxFuncionario2.setEnabled(true);
        ComboBoxServico2.setEnabled(true);
        TextFieldValor2.setEnabled(false);
        ComboBoxPorcento2.setEnabled(false);
    }

    private void habilitarCamposColaboradorCompleto() {
        habilitarCamposColaboradorBasico();
        TextFieldValor2.setEnabled(true);
        ComboBoxPorcento2.setEnabled(true);
    }

    private void modoColaboradorAtivado() {
        LabelErro.setVisible(false);
        LabelFuncionario2.setVisible(true);
        LabelNomeFuncionario2.setVisible(true);
        ComboBoxFuncionario2.setVisible(true);
        LabelServico2.setVisible(true);
        ComboBoxServico2.setVisible(true);
        LabelValor2.setVisible(true);
        TextFieldValor2.setVisible(true);
        LabelComissao2.setVisible(true);
        ComboBoxPorcento2.setVisible(true);
        CheckBoxAtendido.setSelected(true);
        CheckBoxAtendido.setEnabled(false);
    }

    private void modoColaboradorDesativado() {
        LabelFuncionario2.setVisible(false);
        LabelNomeFuncionario2.setVisible(false);
        ComboBoxFuncionario2.setVisible(false);
        LabelServico2.setVisible(false);
        ComboBoxServico2.setVisible(false);
        LabelValor2.setVisible(false);
        TextFieldValor2.setVisible(false);
        LabelComissao2.setVisible(false);
        ComboBoxPorcento2.setVisible(false);
        CheckBoxAtendido.setSelected(false);
        CheckBoxAtendido.setEnabled(true);
    }

    private void setEnabledTodosCampos(boolean enabled) {
        // Lista todos os componentes do formulário
        ComboBoxPorcento.setEnabled(enabled);
        TextFieldValor.setEnabled(false);
        TextFieldValorTotal.setEnabled(enabled);
        ComboBoxFuncionario.setEnabled(enabled);
        comboDia.setEnabled(enabled);
        comboMes.setEnabled(enabled);
        comboAno.setEnabled(enabled);
        ComboBoxHora.setEnabled(enabled);
        ComboBoxServico.setEnabled(enabled);

        // Campos do colaborador (se existe)
        ComboBoxFuncionario2.setEnabled(enabled);
        ComboBoxServico2.setEnabled(enabled);
        TextFieldValor2.setEnabled(enabled);
        ComboBoxPorcento2.setEnabled(enabled);
        TextFieldSinal.setEnabled(false);
        CheckBoxAtendido.setEnabled(true);
        CheckBoxCancelado.setEnabled(true);
    }
//    atualiza o Label com nome do funcionário

    private void ComboBoxFuncionarioListener() {
        ComboBoxFuncionario.addActionListener(e -> atualizarLabelFuncionario());
        ComboBoxFuncionario2.addActionListener(e -> atualizarLabelColaborador());
    }

    private void atualizarEstadoComboBox() {
        System.out.println(">> Entrou em atualizarEstadoComboBox. Check selecionado? " + CheckBoxColaborador.isSelected());
        if (CheckBoxColaborador.isSelected() && valor != 0.0) {
            modoColaboradorAtivado();
        }
        if (CheckBoxColaborador.isSelected() && valor == 0.0) {
            modoColaboradorAtivado();
            TextFieldValor2.setEnabled(false);
            ComboBoxPorcento2.setEnabled(false);
        }
        if (!CheckBoxColaborador.isSelected()) {
            modoColaboradorDesativado();
        }
    }

    private void atualizarLabelFuncionario() {
        CadastroDAO cadastroDAO = new CadastroDAO();
        Object itemSelecionado = ComboBoxFuncionario.getSelectedItem();
        if (itemSelecionado != null) {
            int idFuncionario;

            try {
                idFuncionario = Integer.parseInt(itemSelecionado.toString()); // conversão segura
            } catch (NumberFormatException e) {
                LabelFuncionario.setText("ID inválido");
                return;
            }
            Cadastro cadastroFuncionario = cadastroDAO.buscarNomePeloId(idFuncionario);
            String nomeFuncionario = cadastroFuncionario.getNome();
            LabelFuncionario.setText(nomeFuncionario);
        } else {
            LabelFuncionario.setText("Erro");
        }
    }

    private void atualizarLabelColaborador() {
        CadastroDAO cadastroDAO = new CadastroDAO();
        Object itemSelecionado = ComboBoxFuncionario2.getSelectedItem();
        if (itemSelecionado != null) {
            int idFuncionario;

            try {
                idFuncionario = Integer.parseInt(itemSelecionado.toString()); // conversão segura
            } catch (NumberFormatException e) {
                LabelNomeFuncionario2.setText("ID inválido");
                return;
            }
            Cadastro cadastroFuncionario = cadastroDAO.buscarNomePeloId(idFuncionario);
            String nomeFuncionario = cadastroFuncionario.getNome();
            LabelNomeFuncionario2.setText(nomeFuncionario);
        } else {
            LabelNomeFuncionario2.setText("Erro");
        }
    }

    private void listenerPreencheValores() {

        Participante p = new Participante();

        double valorTotal = valor;
        double valor1 = valorTotal - p.getValor();
        double valor2 = valorTotal - valor1;

        String total = String.format("%.2f", valorTotal);
        String valorF1 = String.format("%.2f", valor1);
        String valorF2 = String.format("%.2f", valor2);
        String valorSinal = String.format("%.2f", a.getSinal());

        TextFieldValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldValorTotal.setText(total);
        TextFieldValorTotal.setForeground(Color.GRAY);
        TextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldValor.setText(valorF1);
        TextFieldValor.setForeground(Color.GRAY);
        TextFieldValor2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldValor2.setText(valorF2);
        TextFieldValor2.setForeground(Color.GRAY);
        TextFieldSinal.setFont(new java.awt.Font("Segoe UI", 0, 14));
        TextFieldSinal.setText(valorSinal);
        TextFieldSinal.setForeground(Color.GRAY);
        configurarFocus(TextFieldValorTotal);
        configurarFocus(TextFieldValor);
        configurarFocus(TextFieldValor2);
        configurarFocus(TextFieldSinal);

        final boolean[] atualizando = {false};

        TextFieldValor.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                atualizarValor1();
            }

            public void removeUpdate(DocumentEvent e) {
                atualizarValor1();
            }

            public void changedUpdate(DocumentEvent e) {
            }

            private void atualizarValor1() {
                if (atualizando[0]) {
                    return;
                }
                atualizando[0] = true;
                try {
                    double v1 = Double.parseDouble(TextFieldValor.getText().replace(",", "."));
                    double total = Double.parseDouble(TextFieldValorTotal.getText().replace(",", "."));
                    if (v1 > total) {
                        v1 = total;
                    }
                    double v2 = total - v1;
                    TextFieldValor2.setText(String.format("%.2f", v2));
                } catch (NumberFormatException ex) {
                }
                atualizando[0] = false;
            }
        });

        TextFieldValor2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                atualizarValor2();
            }

            public void removeUpdate(DocumentEvent e) {
                atualizarValor2();
            }

            public void changedUpdate(DocumentEvent e) {
            }

            private void atualizarValor2() {
                if (atualizando[0]) {
                    return;
                }
                atualizando[0] = true;
                try {
                    double v2 = Double.parseDouble(TextFieldValor2.getText().replace(",", "."));
                    double total = Double.parseDouble(TextFieldValorTotal.getText().replace(",", "."));
                    if (v2 > total) {
                        v2 = total;
                    }
                    double v1 = total - v2;
                    TextFieldValor.setText(String.format("%.2f", v1));
                } catch (NumberFormatException ex) {
                }
                atualizando[0] = false;
            }
        });
// Novo listener para atualizar valor1 quando valorTotal for alterado
        TextFieldValorTotal.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                atualizarTotal();
            }

            public void removeUpdate(DocumentEvent e) {
                atualizarTotal();
            }

            public void changedUpdate(DocumentEvent e) {
            }

            private void atualizarTotal() {
                if (atualizando[0]) {
                    return;
                }
                atualizando[0] = true;
                try {
                    double totalNovo = Double.parseDouble(TextFieldValorTotal.getText().replace(",", "."));
                    // valor1 passa a ser o totalNovo e valor2 = 0
                    TextFieldValor.setText(String.format("%.2f", totalNovo));
                    TextFieldValor2.setText("0.00");
                } catch (NumberFormatException ex) {
                }
                atualizando[0] = false;
            }
        });
    }

    private void configurarFocus(JTextField campo) {
        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            String valorOriginal = campo.getText(); // valor inicial capturado

            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campo.getText().equals(valorOriginal)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campo.getText().isEmpty()) {
                    campo.setText(valorOriginal);
                    campo.setForeground(Color.GRAY);
                } else {
                    valorOriginal = campo.getText(); // atualiza valor original
                }
            }
        });
    }

    private void carregaComboBoxData() {

        for (int i = 1; i <= 31; i++) {
            comboDia.addItem(String.format("%02d", i));
        }
        for (int i = 1; i <= 12; i++) {
            comboMes.addItem(String.format("%02d", i));
        }
// Anos (Sempre mostra ano atual + 2)
        int anoAtual = Year.now().getValue();
        for (int i = 0; i < 3; i++) {
            comboAno.addItem(String.valueOf(anoAtual + i));
        }
    }

    private void adicionarConfirmacaoDeSaida() {
        String status = LabelStatus.getText();
        if ("Atendido".equalsIgnoreCase(status) || "Cancelado".equalsIgnoreCase(status)) {
            this.dispose();
        } else {
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int resposta = JOptionPane.showConfirmDialog(
                            AtualizarAgenda.this,
                            "Fechar a tela, irá perder os dados atualizados\nDeseja salvar antes de sair?",
                            "Confirmar saída",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (resposta == JOptionPane.YES_OPTION) {
                        salvarAlteracoes();
                        dispose();
                    } else if (resposta == JOptionPane.NO_OPTION) {
                        dispose();
                    } else {
                        return;
                    }
                }
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAtualizar;
    private javax.swing.JCheckBox CheckBoxAtendido;
    private javax.swing.JCheckBox CheckBoxCancelado;
    private javax.swing.JCheckBox CheckBoxColaborador;
    private javax.swing.JComboBox<String> ComboBoxFuncionario;
    private javax.swing.JComboBox<String> ComboBoxFuncionario2;
    private javax.swing.JComboBox<String> ComboBoxHora;
    private javax.swing.JComboBox<String> ComboBoxPorcento;
    private javax.swing.JComboBox<String> ComboBoxPorcento2;
    private javax.swing.JComboBox<String> ComboBoxServico;
    private javax.swing.JComboBox<String> ComboBoxServico2;
    private javax.swing.JLabel LabelCPF;
    private javax.swing.JLabel LabelComissao;
    private javax.swing.JLabel LabelComissao2;
    private javax.swing.JLabel LabelErro;
    private javax.swing.JLabel LabelErroData;
    private javax.swing.JLabel LabelFuncionario;
    private javax.swing.JLabel LabelFuncionario2;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelIdAgenda;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelNomeFuncionario2;
    private javax.swing.JLabel LabelServico2;
    private javax.swing.JLabel LabelStatus;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelValor2;
    private javax.swing.JTextField TextFieldSinal;
    private javax.swing.JTextField TextFieldValor;
    private javax.swing.JTextField TextFieldValor2;
    private javax.swing.JTextField TextFieldValorTotal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
