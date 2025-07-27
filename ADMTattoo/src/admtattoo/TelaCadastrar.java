package admtattoo;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaCadastrar extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;

    public enum OrigemChamada {
        TelaFormResponsa,
        TelaFormResponsaResponsavel
    }
    private OrigemChamada origemChamada = null;
    private TelaFormResponsa pai = null;

    Cadastro c = new Cadastro();

    public TelaCadastrar(TelaFormResponsa pai, OrigemChamada origem) {
        this(); // chama o construtor padrão
        this.origemChamada = origem;
        this.pai = pai;
    }

    public TelaCadastrar() {
        initComponents();
        comboAno.addActionListener(e -> atualizarIdade());
        comboMes.addActionListener(e -> atualizarIdade());
        comboDia.addActionListener(e -> atualizarIdade());
        FormatadorSwing.aplicarTelefone(TextFieldTel);
        FormatadorSwing.aplicarCPF(TextFieldCpf);
        FormatadorSwing.aplicarCEP(TextFieldCep);
        FormatadorSwing.aplicarCNPJ(TextFieldCNPJ);
        DateComboBoxUtils.preencherComboboxDatas(comboDia, comboMes, comboAno);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public TelaCadastrar(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        initComponents();
        comboAno.addActionListener(e -> atualizarIdade());
        comboMes.addActionListener(e -> atualizarIdade());
        comboDia.addActionListener(e -> atualizarIdade());
        FormatadorSwing.aplicarTelefone(TextFieldTel);
        FormatadorSwing.aplicarCPF(TextFieldCpf);
        FormatadorSwing.aplicarCEP(TextFieldCep);
        FormatadorSwing.aplicarCNPJ(TextFieldCNPJ);
        DateComboBoxUtils.preencherComboboxDatas(comboDia, comboMes, comboAno);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public TelaCadastrar(Cadastro cadastro) {
        initComponents();
        comboAno.addActionListener(e -> atualizarIdade());
        comboMes.addActionListener(e -> atualizarIdade());
        comboDia.addActionListener(e -> atualizarIdade());
        FormatadorSwing.aplicarTelefone(TextFieldTel);
        FormatadorSwing.aplicarCPF(TextFieldCpf);
        FormatadorSwing.aplicarCEP(TextFieldCep);
        FormatadorSwing.aplicarCNPJ(TextFieldCNPJ);
        DateComboBoxUtils.preencherComboboxDatas(comboDia, comboMes, comboAno);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    TelaCadastrar(int id) {
        initComponents();
        comboAno.addActionListener(e -> atualizarIdade());
        comboMes.addActionListener(e -> atualizarIdade());
        comboDia.addActionListener(e -> atualizarIdade());
        FormatadorSwing.aplicarTelefone(TextFieldTel);
        FormatadorSwing.aplicarCPF(TextFieldCpf);
        FormatadorSwing.aplicarCEP(TextFieldCep);
        FormatadorSwing.aplicarCNPJ(TextFieldCNPJ);
        DateComboBoxUtils.preencherComboboxDatas(comboDia, comboMes, comboAno);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextFieldNome = new javax.swing.JTextField();
        TextFieldCpf = new javax.swing.JTextField();
        TextFieldTel = new javax.swing.JTextField();
        TextFieldCep = new javax.swing.JTextField();
        TextFieldEmail = new javax.swing.JTextField();
        RadioButtonCliente = new javax.swing.JRadioButton();
        RadioButtonFuncionario = new javax.swing.JRadioButton();
        RadioButtonFornecedor = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        TextFieldRua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextFieldNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TextFieldBairro = new javax.swing.JTextField();
        RadioButtonCasa = new javax.swing.JRadioButton();
        RadioButtonFundos = new javax.swing.JRadioButton();
        RadioButtonAp = new javax.swing.JRadioButton();
        RadioButtonLoja = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        TextFieldCidade = new javax.swing.JTextField();
        comboDia = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        comboAno = new javax.swing.JComboBox<>();
        LabelIdade = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextFieldCNPJ = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ButtonCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Novo cadastro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(218, 218, 218))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nome :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CPF :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Insc/Nasc :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tel :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("CEP :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("E-mail :");

        TextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextFieldCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextFieldTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextFieldCep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        buttonGroup1.add(RadioButtonCliente);
        RadioButtonCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonCliente.setText("Cliente");

        buttonGroup1.add(RadioButtonFuncionario);
        RadioButtonFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonFuncionario.setText("Funcionário");

        buttonGroup1.add(RadioButtonFornecedor);
        RadioButtonFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonFornecedor.setText("Fornecedor");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Rua :");

        TextFieldRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Nº");

        TextFieldNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Bairro :");

        TextFieldBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        buttonGroup2.add(RadioButtonCasa);
        RadioButtonCasa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonCasa.setText("Casa");

        buttonGroup2.add(RadioButtonFundos);
        RadioButtonFundos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonFundos.setText("Fundos");
        RadioButtonFundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonFundosActionPerformed(evt);
            }
        });

        buttonGroup2.add(RadioButtonAp);
        RadioButtonAp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonAp.setText("Apartamento");
        RadioButtonAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonApActionPerformed(evt);
            }
        });

        buttonGroup2.add(RadioButtonLoja);
        RadioButtonLoja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonLoja.setText("Loja");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Cidade :");

        TextFieldCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCidadeActionPerformed(evt);
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

        LabelIdade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelIdade.setText("Idade: -");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("CNPJ :");

        TextFieldCNPJ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Local :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(RadioButtonCliente)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonFornecedor)
                        .addGap(171, 171, 171))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabelIdade))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(TextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TextFieldNome)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel10)
                .addGap(369, 369, 369)
                .addComponent(jLabel9)
                .addGap(174, 174, 174))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel11)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(TextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(RadioButtonLoja)
                            .addGap(18, 18, 18)
                            .addComponent(RadioButtonCasa)
                            .addGap(18, 18, 18)
                            .addComponent(RadioButtonFundos)
                            .addGap(18, 18, 18)
                            .addComponent(RadioButtonAp))
                        .addComponent(TextFieldCidade)
                        .addComponent(TextFieldEmail)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(TextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TextFieldRua, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonCliente)
                    .addComponent(RadioButtonFuncionario)
                    .addComponent(RadioButtonFornecedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(TextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelIdade)
                    .addComponent(jLabel4)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(TextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonCasa)
                    .addComponent(RadioButtonFundos)
                    .addComponent(RadioButtonAp)
                    .addComponent(RadioButtonLoja)
                    .addComponent(jLabel13))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarActionPerformed
        salvarCadastro();
    }//GEN-LAST:event_ButtonCadastrarActionPerformed

    private void TextFieldCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCidadeActionPerformed

    private void RadioButtonFundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonFundosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonFundosActionPerformed

    private void RadioButtonApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonApActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonApActionPerformed

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrar().setVisible(true);
            }
        });
    }

    public String obterTipoCadastroSelecionado() {
        if (RadioButtonCliente.isSelected()) {
            return "Cliente";
        } else if (RadioButtonFuncionario.isSelected()) {
            return "Funcionário";
        } else if (RadioButtonFornecedor.isSelected()) {
            return "Fornecedor";
        } else {
            return null;
        }
    }

    public String obterTipoEnderecoSelecionado() {
        if (RadioButtonCasa.isSelected()) {
            return "Casa";
        } else if (RadioButtonFundos.isSelected()) {
            return "Fundos";
        } else if (RadioButtonAp.isSelected()) {
            return "Apartamento";
        } else if (RadioButtonLoja.isSelected()) {
            return "Loja";
        } else {
            return "Não especificado";
        }
    }

    public String validarDocumentosComMensagem(String cpf, String cnpj) {
        boolean cpfPreenchido = cpf != null && !cpf.trim().isEmpty();
        boolean cnpjPreenchido = cnpj != null && !cnpj.trim().isEmpty();

        if (!cpfPreenchido && !cnpjPreenchido) {
            return "Erro: É obrigatório informar CPF ou CNPJ";
        }
        if (cpfPreenchido && cnpjPreenchido) {
            return "Erro: Informe apenas CPF ou apenas CNPJ, não ambos";
        }
        if (cpfPreenchido && !c.validarCPF(cpf)) {
            return "Erro: CPF inválido";
        }
        if (cnpjPreenchido && !c.validarCNPJ(cnpj)) {
            return "Erro: CNPJ inválido";
        }
        return null; // Retorna null se não houver erros
    }

    private void limparCampos() {
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        TextFieldNome.setText("");
        TextFieldCpf.setText("");
        TextFieldCNPJ.setText("");
        TextFieldTel.setText("");
        TextFieldCep.setText("");
        TextFieldRua.setText("");
        TextFieldBairro.setText("");
        TextFieldNumero.setText("");
        TextFieldCidade.setText("");
        TextFieldEmail.setText("");
        comboDia.setSelectedIndex(0);
        comboMes.setSelectedIndex(0);
        comboAno.setSelectedIndex(0);
    }

    public boolean isAtualizacaoRealizada() {
        // Retorna true se os dados foram atualizados
        return true;
    }

    private void salvarCadastro() {
        try {
            String status = obterTipoCadastroSelecionado();
            System.out.println("Status recebido: " + status);
            String nome = TextFieldNome.getText().trim();
            String cpf = TextFieldCpf.getText().trim();
            String cnpj = TextFieldCNPJ.getText().trim();
            String tel = TextFieldTel.getText().trim();
            String cep = TextFieldCep.getText().trim();
            String rua = TextFieldRua.getText().trim();
            String bairro = TextFieldBairro.getText().trim();
            String numero = TextFieldNumero.getText().trim();
            String cidade = TextFieldCidade.getText().trim();
            String email = TextFieldEmail.getText().trim();
            String cfal = obterTipoEnderecoSelecionado();

            String dataTexto = comboAno.getSelectedItem().toString() + "-"
                    + comboMes.getSelectedItem().toString() + "-"
                    + comboDia.getSelectedItem().toString();

            String mensagemErro = validarDocumentosComMensagem(cpf, cnpj);
            if (mensagemErro != null) {
                JOptionPane.showMessageDialog(null, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (status == null) {
                JOptionPane.showMessageDialog(this, "Para continuar, selecione se é Cliente, Funcionário ou Fornecedor.");
                return;
            }

            if (!c.validarNome(nome)) {
                JOptionPane.showMessageDialog(this, "Nome inválido. Use apenas letras e não deixe em branco.");
                return;
            }

            if (!c.validarTelefone(tel)) {
                JOptionPane.showMessageDialog(this, "Telefone inválido.");
                return;
            }

            if (!c.validarCEP(cep)) {
                JOptionPane.showMessageDialog(this, "CEP inválido.");
                return;
            }

            if (!c.validarData(dataTexto)) {
                JOptionPane.showMessageDialog(this, "Data inválida.");
                return;
            }

            if (!c.validarRua(rua)) {
                JOptionPane.showMessageDialog(this, "Rua inválida.\nDigite somente letras e números por extenso");
                return;
            }

            if (!c.validarCidade(cidade)) {
                JOptionPane.showMessageDialog(this, "Cidade inválida.\nDigite somente letras e números por extenso");
                return;
            }

            if (!c.validarBairro(bairro)) {
                JOptionPane.showMessageDialog(this, "Bairro inválido.\nDigite somente letras e números por extenso");
                return;
            }

            if ("Não especificado".equalsIgnoreCase(cfal)) {
                JOptionPane.showMessageDialog(this, "O local está nulo e será salvo como 'Não especificado' por padrão,\nmas você pode alterá-lo quando quiser acessando: menu/consultar/cadastro/atualizar");
            }

            if ("".equalsIgnoreCase(email)) {
                int resposta = JOptionPane.showConfirmDialog(this,
                        "O e-mail é interessante para receber promoções e ofertas,\nconfirmar cadastro sem e-mail ?", "Confirmação",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (resposta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            c.setStatus(status);
            c.setNome(nome);
            c.setCpf(cpf);
            c.setCnpj(cnpj);
            c.setTel(tel);
            c.setCep(cep);
            c.setRua(rua);
            c.setBairro(bairro);
            c.setNumero(numero);
            c.setCfal(cfal);
            c.setCidade(cidade);
            c.setEmail(email);
            c.setNascimento(dataTexto);

            if (CadastroDAO.cadastrar(c)) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

                if ("Funcionário".equalsIgnoreCase(status)) {
                    int idGerado = CadastroDAO.buscarUltimoId();
                    Funcionario f = new Funcionario();
                    f.setIdProfissional(idGerado);
                    f.setStatus(true);
                    boolean salvouFuncionario = FuncionarioDAO.salvarNovo(f);
                    if (!salvouFuncionario) {
                        JOptionPane.showMessageDialog(this, "Cadastro realizado, mas houve erro ao salvar na tabela funcionário.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }

                int idUltimo = CadastroDAO.buscarUltimoId();

                if (origemChamada != null && pai != null) {
                    switch (origemChamada) {
                        case TelaFormResponsa -> {
                            pai.receberIdCliente(idUltimo);
                            JOptionPane.showMessageDialog(this, "Cliente cadastrado e selecionado com sucesso.");
                            this.dispose();
                            return;
                        }
                        case TelaFormResponsaResponsavel -> {
                            Cadastro responsavel = CadastroDAO.buscarPorId(idUltimo);
                            if (responsavel != null) {
                                pai.setResponsavelSelecionado(responsavel);
                                JOptionPane.showMessageDialog(this, "Responsável cadastrado e selecionado com sucesso.");
                                this.dispose();
                                return;
                            }
                        }
                    }
                }

// Caso padrão (nenhuma origem definida)
                if (origemChamada == null || pai == null) {
                    int resposta = JOptionPane.showConfirmDialog(this,
                            "Deseja criar formulário de consentimento/autorização ?",
                            "Confirmação de Responsabilidade", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (resposta == JOptionPane.YES_OPTION) {
                        limparCampos();
                        TelaFormResponsa tela = new TelaFormResponsa(idUltimo);
                        tela.receberIdCliente(idUltimo);
                        tela.setVisible(true);
                        this.dispose();
                        return;
                    } else {
                        new ListaCadastro(funcionarioLogado, this, ListaCadastro.OrigemChamada.TelaCadastrar, idUltimo).setVisible(true);
                    }
                    this.dispose();
                }
                limparCampos();

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar " + status, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado ao cadastrar", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        this.dispose();
    }
// método para atualizar data dinamicamente no LabelData

    private void atualizarIdade() {
        try {
            String dataTexto = comboAno.getSelectedItem().toString() + "-"
                    + comboMes.getSelectedItem().toString() + "-"
                    + comboDia.getSelectedItem().toString();

            LocalDate dataNascimento = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate dataAtual = LocalDate.now();

            int idade = Period.between(dataNascimento, dataAtual).getYears();

            LabelIdade.setText("Idade: " + idade + " anos");

            if (idade < 18) {
                LabelIdade.setForeground(Color.RED);
            } else {
                LabelIdade.setForeground(Color.BLACK);
            }

        } catch (Exception e) {
            // Caso os campos ainda não estejam preenchidos corretamente
            LabelIdade.setText("Idade: -");
            LabelIdade.setForeground(Color.BLACK);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JLabel LabelIdade;
    private javax.swing.JRadioButton RadioButtonAp;
    private javax.swing.JRadioButton RadioButtonCasa;
    private javax.swing.JRadioButton RadioButtonCliente;
    private javax.swing.JRadioButton RadioButtonFornecedor;
    private javax.swing.JRadioButton RadioButtonFuncionario;
    private javax.swing.JRadioButton RadioButtonFundos;
    private javax.swing.JRadioButton RadioButtonLoja;
    private javax.swing.JTextField TextFieldBairro;
    private javax.swing.JTextField TextFieldCNPJ;
    private javax.swing.JTextField TextFieldCep;
    private javax.swing.JTextField TextFieldCidade;
    private javax.swing.JTextField TextFieldCpf;
    private javax.swing.JTextField TextFieldEmail;
    private javax.swing.JTextField TextFieldNome;
    private javax.swing.JTextField TextFieldNumero;
    private javax.swing.JTextField TextFieldRua;
    private javax.swing.JTextField TextFieldTel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
