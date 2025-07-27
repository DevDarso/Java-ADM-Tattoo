package admtattoo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AtualizarCadastro extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;
    private FuncionarioDAO FuncionarioDAO;
    Funcionario f = new Funcionario();
    private CadastroDAO CadastroDAO;
    Cadastro c = new Cadastro();
    ConexaoJDBC cjdbc = new ConexaoJDBC();

    private boolean atualizado = false;

    public AtualizarCadastro(Funcionario funcionarioLogado, Cadastro c) {
        this.funcionarioLogado = funcionarioLogado;
        this.c = c;
        this.CadastroDAO = new CadastroDAO();
        this.FuncionarioDAO = new FuncionarioDAO();

        // Se for funcionário, carrega os dados específicos
        if (c.isFuncionario()) {
            this.f = FuncionarioDAO.buscarPorId(c.getId());
        } else {
            this.f = null;
        }
        initComponents();
        carregarDados();
        FormatadorSwing.aplicarTelefone(TextFieldTel);
        FormatadorSwing.aplicarCPF(TextFieldCpf);
        FormatadorSwing.aplicarCEP(TextFieldCep);
        FormatadorSwing.aplicarCNPJ(TextFieldCNPJ);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adicionarConfirmacaoDeSaida();
    }

    public AtualizarCadastro() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LabelID = new javax.swing.JLabel();
        TextFieldNome = new javax.swing.JTextField();
        TextFieldCpf = new javax.swing.JTextField();
        TextFieldTel = new javax.swing.JTextField();
        TextFieldCep = new javax.swing.JTextField();
        TextFieldEmail = new javax.swing.JTextField();
        LabelStatus = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        RadioButtonCasa = new javax.swing.JRadioButton();
        RadioButtonFundos = new javax.swing.JRadioButton();
        RadioButtonAp = new javax.swing.JRadioButton();
        RadioButtonLoja = new javax.swing.JRadioButton();
        TextFieldRua = new javax.swing.JTextField();
        TextFieldBairro = new javax.swing.JTextField();
        TextFieldNumero = new javax.swing.JTextField();
        TextFieldCidade = new javax.swing.JTextField();
        LabelCnpj = new javax.swing.JLabel();
        TextFieldCNPJ = new javax.swing.JTextField();
        comboDia = new javax.swing.JComboBox<>();
        comboMes = new javax.swing.JComboBox<>();
        comboAno = new javax.swing.JComboBox<>();
        RadioButtonCliente = new javax.swing.JRadioButton();
        RadioButtonFuncionario = new javax.swing.JRadioButton();
        RadioButtonFornecedor = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        ButtonAtualizar = new javax.swing.JButton();
        PanelFuncionario = new javax.swing.JPanel();
        LabelCargo = new javax.swing.JLabel();
        TextFieldCargo = new javax.swing.JTextField();
        LabelEntrada = new javax.swing.JLabel();
        TextFieldEntrada = DateUtils.criarCampoData();
        LabelStatus2 = new javax.swing.JLabel();
        RadioButtonAtivo = new javax.swing.JRadioButton();
        RadioButtonInativo = new javax.swing.JRadioButton();
        LabelSaida = new javax.swing.JLabel();
        TextFieldSaida = DateUtils.criarCampoData();
        LabelSenha = new javax.swing.JLabel();
        TextSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(710, 710));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Atualizar cadastro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(172, 172, 172))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nome :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CPF :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nascimento :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tel :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("CEP :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("E-mail :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("id :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Status :");

        LabelID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelID.setText(String.valueOf(c.getId()));

        TextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldNome.setText(c.getNome());

        TextFieldCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCpf.setText(c.getCpf());

        TextFieldTel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldTel.setText(c.getTel());

        TextFieldCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCep.setText(c.getCep());

        TextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldEmail.setText(c.getEmail());

        LabelStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelStatus.setText(c.getStatus());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Rua :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Nº");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Bairro :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Cidade :");

        buttonGroup2.add(RadioButtonCasa);
        RadioButtonCasa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonCasa.setText("Casa");

        buttonGroup2.add(RadioButtonFundos);
        RadioButtonFundos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonFundos.setText("Fundos");

        buttonGroup2.add(RadioButtonAp);
        RadioButtonAp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonAp.setText("Apartamento");

        buttonGroup2.add(RadioButtonLoja);
        RadioButtonLoja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonLoja.setText("Loja");

        TextFieldRua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldRua.setText(c.getRua());

        TextFieldBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldBairro.setText(c.getBairro());

        TextFieldNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldNumero.setText(c.getNumero());

        TextFieldCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCidade.setText(c.getCidade());

        LabelCnpj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCnpj.setText("CNPJ :");

        TextFieldCNPJ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextFieldCNPJ.setText(c.getCnpj());

        buttonGroup1.add(RadioButtonCliente);
        RadioButtonCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonCliente.setText("Cliente");

        buttonGroup1.add(RadioButtonFuncionario);
        RadioButtonFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonFuncionario.setText("Funcionário");

        buttonGroup1.add(RadioButtonFornecedor);
        RadioButtonFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RadioButtonFornecedor.setText("Fornecedor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel8)
                .addGap(18, 19, Short.MAX_VALUE)
                .addComponent(LabelID)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(LabelStatus)
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldTel)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldRua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCNPJ))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RadioButtonCasa)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonFundos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioButtonAp)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonLoja))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RadioButtonCliente)
                .addGap(18, 18, 18)
                .addComponent(RadioButtonFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioButtonFornecedor)
                .addGap(173, 173, 173))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LabelID)
                    .addComponent(jLabel9)
                    .addComponent(LabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCnpj)
                    .addComponent(TextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadioButtonCasa)
                    .addComponent(RadioButtonFundos)
                    .addComponent(RadioButtonAp)
                    .addComponent(RadioButtonLoja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(TextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonCliente)
                    .addComponent(RadioButtonFuncionario)
                    .addComponent(RadioButtonFornecedor))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ButtonAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonAtualizar.setText("Atualizar");
        ButtonAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LabelCargo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCargo.setText("Cargo :");

        TextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        LabelEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelEntrada.setText("Admissão :");

        TextFieldEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        LabelStatus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelStatus2.setText("Status :");

        buttonGroup3.add(RadioButtonAtivo);
        RadioButtonAtivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioButtonAtivo.setText(" Ativo");

        buttonGroup3.add(RadioButtonInativo);
        RadioButtonInativo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioButtonInativo.setText(" Inativo");

        LabelSaida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSaida.setText("Demissão :");

        TextFieldSaida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        LabelSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSenha.setText("Senha:");

        TextSenha.setText("jPasswordField1");

        javax.swing.GroupLayout PanelFuncionarioLayout = new javax.swing.GroupLayout(PanelFuncionario);
        PanelFuncionario.setLayout(PanelFuncionarioLayout);
        PanelFuncionarioLayout.setHorizontalGroup(
            PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFuncionarioLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelStatus2)
                    .addComponent(LabelEntrada)
                    .addComponent(LabelCargo))
                .addGap(18, 18, 18)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFuncionarioLayout.createSequentialGroup()
                        .addComponent(RadioButtonAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioButtonInativo))
                    .addComponent(TextFieldCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(TextFieldEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelSenha)
                    .addComponent(LabelSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(TextFieldSaida))
                .addGap(91, 91, 91))
        );
        PanelFuncionarioLayout.setVerticalGroup(
            PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCargo)
                    .addComponent(TextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSenha)
                    .addComponent(TextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEntrada)
                    .addComponent(LabelSaida)
                    .addComponent(TextFieldEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStatus2)
                    .addComponent(RadioButtonAtivo)
                    .addComponent(RadioButtonInativo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAtualizarActionPerformed
        try {
            salvarAlteracoes();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar alterações: " + ex.getMessage());
        }
    }//GEN-LAST:event_ButtonAtualizarActionPerformed

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained

    }//GEN-LAST:event_jPanel3FocusGained

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
            java.util.logging.Logger.getLogger(AtualizarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarCadastro().setVisible(true);
            }
        });
    }

    private void carregarDados() {
        // Carrega dados básicos do cadastro
        String status = c.getStatus() != null ? c.getStatus().toLowerCase() : "";
        String local = c.getCfal() != null ? c.getCfal().toLowerCase() : "";

        // Configura radio buttons
        RadioButtonFuncionario.setSelected(status.contains("funcionário") || status.contains("funcionario"));
        RadioButtonFornecedor.setSelected("fornecedor".equals(status));
        RadioButtonCliente.setSelected("cliente".equals(status));

        RadioButtonCasa.setSelected("casa".equals(local));
        RadioButtonFundos.setSelected("fundos".equals(local));
        RadioButtonAp.setSelected("apartamento".equals(local));
        RadioButtonLoja.setSelected("loja".equals(local));

        // Preenche campos básicos
        LabelID.setText(Integer.toString(c.getId()));
        LabelStatus.setText(c.getStatus());
        TextFieldNome.setText(c.getNome());
        TextFieldCpf.setText(c.getCpf());
        TextFieldTel.setText(c.getTel());
        TextFieldCep.setText(c.getCep());
        TextFieldEmail.setText(c.getEmail());

        // Preenche combobox de datas
        DateComboBoxUtils.preencherComboboxDatas(comboDia, comboMes, comboAno);
        preencherDataNosCombos(c.getNascimento());

        // Verifica se é funcionário
        boolean isFuncionario = c.isFuncionario();

        // Configura visibilidade/habilitação dos campos específicos
        configurarCamposFuncionario(isFuncionario);

        // Se for funcionário, carrega os dados específicos
        if (isFuncionario) {
            carregarDadosFuncionario();
        }
        System.out.println("Debug - Dados carregados:");
        System.out.println("É funcionário? " + c.isFuncionario());
        System.out.println("Objeto Funcionario: " + (f != null ? "Carregado" : "Nulo"));
        if (f != null) {
            System.out.println("Cargo: " + f.getCargo());
            System.out.println("Status: " + f.isStatus());
        }

    }

    private void configurarCamposFuncionario(boolean exibir) {
        // Habilita/desabilita componentes
        TextFieldCargo.setVisible(exibir);
        TextFieldEntrada.setVisible(exibir);
        TextFieldSaida.setVisible(exibir);
        RadioButtonAtivo.setVisible(exibir);
        RadioButtonInativo.setVisible(exibir);
        LabelCargo.setVisible(exibir);
        LabelStatus2.setVisible(exibir);
        LabelEntrada.setVisible(exibir);
        LabelSaida.setVisible(exibir);
        LabelSenha.setVisible(exibir);
        TextSenha.setVisible(exibir);

        // Se não for funcionário, limpa os campos
        if (!exibir) {
            TextFieldCargo.setText("");
            TextFieldEntrada.setText("");
            TextFieldSaida.setText("");
            RadioButtonAtivo.setSelected(false);
            RadioButtonInativo.setSelected(false);
        }
    }

    private void carregarDadosFuncionario() {
        try {
            // Verifica se o objeto Funcionario foi carregado
            if (f == null) {
                f = FuncionarioDAO.buscarPorId(c.getId()); // Carrega se não estiver carregado
            }

            if (f != null) {
                // Preenche os campos
                TextFieldCargo.setText(f.getCargo());
                TextFieldEntrada.setText(formatarData(f.getDataEntrada()));
                TextFieldSaida.setText(f.getDataSaida() != null ? formatarData(f.getDataSaida()) : "");
                TextSenha.setText(f.getSenha());
                // Configura o status
                boolean ativo = f.isStatus();
                RadioButtonAtivo.setSelected(ativo);
                RadioButtonInativo.setSelected(!ativo);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Dados de funcionário não encontrados",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados de funcionário: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private String formatarData(String dataString) {
        if (dataString == null || dataString.isEmpty()) {
            return "";
        }

        try {
            // Se a data estiver no formato do banco (yyyy-MM-dd)
            LocalDate data = LocalDate.parse(dataString);
            return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            // Se já estiver no formato desejado, retorna sem converter
            return dataString;
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
            }
        }
    }

    private void salvarAlteracoes() throws Exception {
        try {
            String novoStatus = obterTipoCadastroSelecionado();
            String statusAnterior = c.getStatus(); // Status atual no banco
            System.out.println("Status recebido: " + novoStatus);

            // Verifica mudança de Funcionário para outro tipo
            if ((statusAnterior != null && statusAnterior.equalsIgnoreCase("Funcionário"))
                    && !novoStatus.equalsIgnoreCase("Funcionário")) {

                // Busca o funcionário no banco (não usa a instância existente)
                Funcionario f = FuncionarioDAO.buscarPorId(c.getId());

                // Garante que temos o objeto funcionário
                if (f == null) {
                    f = FuncionarioDAO.buscarPorId(c.getId());
                }

                // Se encontrou o funcionário no banco
                if (f != null) {
                    // Marca como inativo
                    RadioButtonInativo.setSelected(true);
                    f.setStatus(false);

                    // Preenche data de saída se estiver vazia
                    if (TextFieldSaida.getText().trim().isEmpty()) {
                        LocalDate hoje = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String dataSaida = hoje.format(formatter);

                        TextFieldSaida.setText(dataSaida);
                    }

                    // Força a validação da data de saída
                    if (!verificaDataDemissao()) {
                        return;
                    }

                    // Seta no objeto
                    f.setDataSaida(TextFieldSaida.getText().trim());

                    // Atualiza no banco
                    boolean ok = FuncionarioDAO.atualizar(f);
                    if (!ok) {
                        System.out.println("Data de entrada: " + f.getDataEntrada());
                        throw new Exception("Erro ao atualizar funcionário após mudança de status");
                    }
                }
            }
            // Verifica mudança de outro tipo para Funcionário
            if ((statusAnterior == null || !statusAnterior.equalsIgnoreCase("Funcionário"))
                    && novoStatus.equalsIgnoreCase("Funcionário")) {

                // Verifica se já existe na tabela de funcionários
                Funcionario funcionarioExistente = FuncionarioDAO.buscarPorId(c.getId());

                if (funcionarioExistente != null) {
                    // Já existe registro - faz UPDATE
                    f = funcionarioExistente;
                    LocalDate hoje = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    // Atualiza data de entrada para hoje e remove data de saída
                    f.setDataEntrada(hoje.format(formatter));
                    f.setDataSaida(null);
                    RadioButtonAtivo.setSelected(true);
                    TextFieldEntrada.setText(hoje.format(formatter));
                    TextFieldSaida.setText("");
                } else {
                    // Não existe registro - preenche automaticamente a data de entrada
                    LocalDate hoje = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    TextFieldEntrada.setText(hoje.format(formatter));
                    RadioButtonAtivo.setSelected(true);

                    // Cria novo objeto Funcionario
                    f = new Funcionario();
                    f.setIdProfissional(c.getId());
                    f.setDataEntrada(hoje.format(formatter));
                    f.setDataSaida(null);
                    f.setStatus(true);

                    // criptografia de senha antes de salvar
                    String senhaOriginal = TextSenha.getText();
                    String senhaCriptografada = SegurancaUtils.hashSenha(senhaOriginal);
                    f.setSenha(senhaCriptografada);

                    // Salva o novo funcionário no banco de dados
                    FuncionarioDAO fDAO = new FuncionarioDAO();
                    boolean salvou = fDAO.salvarNovo(f);

                    if (!salvou) {
                        throw new Exception("Falha ao salvar novo funcionário no banco de dados");
                    }

                }
            }
            // Salva restante das alterações
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

            // Validar os campos
            String mensagemErro = validarDocumentosComMensagem(cpf, cnpj);
            if (mensagemErro != null) {
                JOptionPane.showMessageDialog(null, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (novoStatus == null) {
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
            // Garante que o ex-funcionário passe para status "Cliente"
            // Preencher o objeto Cadastro
            if (RadioButtonInativo.isSelected()) {
                RadioButtonCliente.setSelected(true);
                c.setStatus("Cliente");
            } else {
                c.setStatus(novoStatus);
            }
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

            // Atualizar no banco
            boolean cadastroAtualizado = CadastroDAO.atualizar(c);

            // Tratamento específico para funcionários
            if (cadastroAtualizado && (novoStatus.equalsIgnoreCase("Funcionario")
                    || novoStatus.equalsIgnoreCase("Funcionário"))) {

                // Garante que o objeto Funcionario existe
                if (f == null) {
                    f = new Funcionario();
                    f.setIdProfissional(c.getId()); // Associa ao ID do cadastro
                }

                // Captura dos campos específicos
                String cargo = TextFieldCargo.getText().trim();
                String entrada = TextFieldEntrada.getText().trim();
                String saida = TextFieldSaida.getText().trim();
                boolean ativo = RadioButtonAtivo.isSelected();

                String senhaOriginal = TextSenha.getText();
                String senhaCriptografada = SegurancaUtils.hashSenha(senhaOriginal);
                String senha = senhaCriptografada;

                if ("Funcionário".equalsIgnoreCase(statusAnterior) && !DateUtils.isDataValida(entrada)) {
                    JOptionPane.showMessageDialog(this, "Data de entrada inválida!");
                    return;
                }
                if (!verificaDataDemissao()) {
                    return;
                }

                // Atribui os novos valores
                f.setCargo(cargo);
                f.setDataEntrada(entrada);
                String saidaAtual = TextFieldSaida.getText().trim();
                f.setDataSaida(saidaAtual.isEmpty() ? null : saidaAtual);
                f.setStatus(ativo);
                f.setSenha(senha);

                // Atualiza no banco
                boolean funcionarioAtualizado = FuncionarioDAO.atualizar(f);

                if (!funcionarioAtualizado) {
                    throw new Exception("Falha ao atualizar dados de funcionário no banco");
                }
            }

            if (cadastroAtualizado) {
                JOptionPane.showMessageDialog(this, "Cadastro atualizado com sucesso!");
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private boolean verificaDataDemissao() {
        try {
            String textoEntrada = TextFieldEntrada.getText().trim();
            String textoSaida = TextFieldSaida.getText().trim();
            boolean inativo = RadioButtonInativo.isSelected();

            // Verifica se o campo está vazio ou com máscara não preenchida
            boolean saidaVazia = textoSaida.isEmpty() || textoSaida.equals("__/__/____");

            // Limpa o campo se contiver apenas a máscara
            if (textoSaida.equals("__/__/____")) {
                TextFieldSaida.setText("");
                textoSaida = "";
                saidaVazia = true;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate hoje = LocalDate.now();
            LocalDate dataEntrada = null;
            LocalDate dataSaida = null;

            // Validação da data de entrada
            try {
                dataEntrada = LocalDate.parse(textoEntrada, formatter);

                // Validação para data de entrada futura
                if (dataEntrada.isAfter(hoje)) {
                    JOptionPane.showMessageDialog(this,
                            "A data de admissão não pode ser maior que a data atual.",
                            "Data inválida", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this,
                        "Data de entrada inválida. Verifique o campo informado.",
                        "Erro de Data", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Tratamento para data de saída vazia
            if (saidaVazia) {
                if (inativo) {
                    int resposta = JOptionPane.showConfirmDialog(this,
                            "Deseja aplicar a data atual como data de demissão?",
                            "Data de Demissão", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {
                        dataSaida = hoje;
                        TextFieldSaida.setText(hoje.format(formatter));
                        RadioButtonInativo.setSelected(true);
                    } else {
                        return false;
                    }
                }
                // Se não está inativo, permite data vazia
                return true;
            }

            // Validação da data de saída (quando preenchida)
            try {
                dataSaida = LocalDate.parse(textoSaida, formatter);

                // Data saída menor que data entrada
                if (dataSaida.isBefore(dataEntrada)) {
                    JOptionPane.showMessageDialog(this,
                            "Não é possível confirmar demissão para uma data menor que a data de admissão.",
                            "Data Inválida", JOptionPane.WARNING_MESSAGE);
                    TextFieldSaida.setText("");
                    return false;
                }

                // Data saída maior que data atual
                if (dataSaida.isAfter(hoje)) {
                    JOptionPane.showMessageDialog(this,
                            "Demissão para data futura.\nAguarde o dia da saída para atualizar o sistema.",
                            "Data Inválida", JOptionPane.WARNING_MESSAGE);
                    TextFieldSaida.setText("");
                    return false;
                }

                // Data saída preenchida mas não está inativo
                if (!inativo) {
                    JOptionPane.showMessageDialog(this,
                            "Para confirmar uma data de demissão, a opção 'Inativo' deve estar selecionada.",
                            "Erro", JOptionPane.WARNING_MESSAGE);
                    TextFieldSaida.setText("");
                    return false;
                }

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this,
                        "Data de saída inválida. Verifique o campo informado.",
                        "Erro de Data", JOptionPane.ERROR_MESSAGE);
                TextFieldSaida.setText("");
                return false;
            }

            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro inesperado ao validar datas: " + ex.getMessage(),
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean isAtualizado() {
        return atualizado;
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

    private void adicionarConfirmacaoDeSaida() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        AtualizarCadastro.this,
                        "Fechar a tela, irá perder os dados atualizados\nDeseja salvar antes de sair?",
                        "Confirmar saída",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resposta == JOptionPane.YES_OPTION) {
                    try {
                        salvarAlteracoes();
                        dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(
                                AtualizarCadastro.this,
                                "Erro ao salvar antes de sair: " + ex.getMessage(),
                                "Erro",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else if (resposta == JOptionPane.NO_OPTION) {
                    dispose();
                }
            }
        });
    }

    public LocalDate converterStringParaLocalDate(String dataString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString, formatter);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAtualizar;
    private javax.swing.JLabel LabelCargo;
    private javax.swing.JLabel LabelCnpj;
    private javax.swing.JLabel LabelEntrada;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelSaida;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelStatus;
    private javax.swing.JLabel LabelStatus2;
    private javax.swing.JPanel PanelFuncionario;
    private javax.swing.JRadioButton RadioButtonAp;
    private javax.swing.JRadioButton RadioButtonAtivo;
    private javax.swing.JRadioButton RadioButtonCasa;
    private javax.swing.JRadioButton RadioButtonCliente;
    private javax.swing.JRadioButton RadioButtonFornecedor;
    private javax.swing.JRadioButton RadioButtonFuncionario;
    private javax.swing.JRadioButton RadioButtonFundos;
    private javax.swing.JRadioButton RadioButtonInativo;
    private javax.swing.JRadioButton RadioButtonLoja;
    private javax.swing.JTextField TextFieldBairro;
    private javax.swing.JTextField TextFieldCNPJ;
    private javax.swing.JTextField TextFieldCargo;
    private javax.swing.JTextField TextFieldCep;
    private javax.swing.JTextField TextFieldCidade;
    private javax.swing.JTextField TextFieldCpf;
    private javax.swing.JTextField TextFieldEmail;
    private javax.swing.JTextField TextFieldEntrada;
    private javax.swing.JTextField TextFieldNome;
    private javax.swing.JTextField TextFieldNumero;
    private javax.swing.JTextField TextFieldRua;
    private javax.swing.JTextField TextFieldSaida;
    private javax.swing.JTextField TextFieldTel;
    private javax.swing.JPasswordField TextSenha;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
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
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
