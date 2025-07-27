package admtattoo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TelaFormResponsa extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;

    private boolean ignorarVerificacaoIdade = false;
    private boolean bloquearModoResponsavel = false;
    private Cadastro responsavelSelecionado;
    private Cadastro clienteSelecionado;
    private String cabecalhoGerado = "";
    private int idCliente = 0;
    private int idFormularioAtual = 1;

    public TelaFormResponsa() {
        initComponents();
        carregarDados();
        TextFieldID.setEditable(false);
        TextFieldTitulo.setEnabled(false);
        modoClienteMaior();
        configurarListenerIDCliente();
        verificarIdadeInstantaneamente();
        CadastroDAO cDAO = new CadastroDAO();
        String dataTexto = cDAO.buscarDataComId(this.idCliente);
        System.out.println("ID cliente: " + idCliente + ", data nascimento: " + dataTexto);
        contadorDeBytes();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        FormResponsa form = FormResponsaDAO.buscarUltimoFormulario();
        if (form != null) {
            TextFieldTitulo.setText(form.getTitulo());
            TextFieldCidade.setText(form.getCidade());
            TextAreaFormulario.setText(form.getQuestionario());
            TextNomeEmpresa.setText(form.getEmpresa());
        }
    }

    public TelaFormResponsa(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        initComponents();
        carregarDados();
        TextFieldID.setEditable(false);
        TextFieldTitulo.setEnabled(false);
        modoClienteMaior();
        configurarListenerIDCliente();
        verificarIdadeInstantaneamente();
        CadastroDAO cDAO = new CadastroDAO();
        String dataTexto = cDAO.buscarDataComId(this.idCliente);
        System.out.println("ID cliente: " + idCliente + ", data nascimento: " + dataTexto);
        contadorDeBytes();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        FormResponsa form = FormResponsaDAO.buscarUltimoFormulario();
        if (form != null) {
            TextFieldTitulo.setText(form.getTitulo());
            TextFieldCidade.setText(form.getCidade());
            TextAreaFormulario.setText(form.getQuestionario());
            TextNomeEmpresa.setText(form.getEmpresa());
        }
    }
// Recebe ID da ListaInfo

    public TelaFormResponsa(int id) {
        initComponents();
        this.idCliente = id;
        verificarIdade();
        System.out.println("Construtor com ID - idCliente recebido: " + this.idCliente);
        TextFieldID.setText(String.valueOf(id));
        TextFieldTitulo.setEnabled(false);
        modoClienteMaior();
        configurarListenerIDCliente();
        verificarIdadeInstantaneamente();
        contadorDeBytes();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Carrega últimos dados do formulário (se quiser manter)
        FormResponsa form = FormResponsaDAO.buscarUltimoFormulario();
        if (form != null) {
            TextFieldTitulo.setText(form.getTitulo());
            TextFieldCidade.setText(form.getCidade());
            TextNomeEmpresa.setText(form.getEmpresa());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ButtonSalvar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        TextFieldID = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TextFieldTitulo = new javax.swing.JTextField();
        LabelCliente = new javax.swing.JLabel();
        ComboBoxTermo = new javax.swing.JComboBox<>();
        LabelResponsavel = new javax.swing.JLabel();
        TextFieldIDResponsavel = new javax.swing.JTextField();
        ButtonBuscarResponsavel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaFormulario = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextNomeEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextFieldCidade = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        LabelBytes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Formulários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ButtonSalvar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonSalvar.setText("Gerar e salvar");
        ButtonSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        TextFieldID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldID.setText("ID cliente:");
        TextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIDActionPerformed(evt);
            }
        });

        ButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonBuscar.setText("Buscar");
        ButtonBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Título :");

        TextFieldTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        LabelCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelCliente.setText("ID do cliente :");

        ComboBoxTermo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBoxTermo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Consentimento", "Autorizacão", "História clínica" }));
        ComboBoxTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTermoActionPerformed(evt);
            }
        });

        LabelResponsavel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelResponsavel.setText("ID do responsável :");

        TextFieldIDResponsavel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextFieldIDResponsavel.setText("ID cliente:");

        ButtonBuscarResponsavel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonBuscarResponsavel.setText("Buscar");
        ButtonBuscarResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonBuscarResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarResponsavelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(LabelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(LabelResponsavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldIDResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonBuscarResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)))
                .addGap(103, 103, 103))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabelCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonBuscarResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TextFieldIDResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabelResponsavel))))
                    .addComponent(ComboBoxTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextAreaFormulario.setColumns(20);
        TextAreaFormulario.setLineWrap(true);
        TextAreaFormulario.setRows(5);
        TextAreaFormulario.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TextAreaFormulario);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Digite o nome da empresa :");

        TextNomeEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Digite o nome da cidade :");

        TextFieldCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldCidade)
                    .addComponent(TextNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LabelBytes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelBytes.setText("Limite de Bytes: 345/65535");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(LabelBytes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelBytes)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        String idTexto = TextFieldID.getText().trim();

        if (idTexto.isEmpty() || !idTexto.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente antes de salvar.");
            return;
        }

        idCliente = Integer.parseInt(idTexto);

        if (clienteSelecionado == null) {
            for (Cadastro c : CadastroDAO.listarTodos()) {
                if (c.getId() == idCliente) {
                    clienteSelecionado = c;
                    break;
                }
            }
        }

        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente antes de salvar.");
            return;
        }
// Garante que origemMontagem nunca seja null
        if (origemMontagem == null) {
            String tituloFormulario = TextFieldTitulo.getText().toLowerCase();
            if (tituloFormulario.matches("(?i).*autoriz.*")) {
                origemMontagem = OrigemMontagem.AUTORIZACAO;
            } else if (tituloFormulario.matches("(?i).*consent.*")) {
                origemMontagem = OrigemMontagem.CONSENTIMENTO;
            } else {
                origemMontagem = OrigemMontagem.HISTORICO;
            }
            System.out.println("OrigemMontagem definida automaticamente como: " + origemMontagem);
        }

        // Cria o formulário e preenche os dados
        FormResponsa formulario = new FormResponsa();
        formulario.setIdCliente(clienteSelecionado.getId());

        String tituloLimpo = TextFieldTitulo.getText().strip().replaceAll("[\\r\\n]", "");
        formulario.setTitulo(tituloLimpo);

        formulario.setCidade(TextFieldCidade.getText().strip());
        formulario.setEmpresa(TextNomeEmpresa.getText().strip());
        formulario.setQuestionario(TextAreaFormulario.getText());

        // Gera o cabeçalho e rodapé
        String cabecalho = TextoFormulario.gerarCabecalho(clienteSelecionado);

        String rodape = TextoFormulario.gerarRodape(formulario.getCidade(), formulario.getEmpresa());

// Salvar o rodapé com quebras e espaços no arquivo .txt
        String rodapeParaArquivo = rodape;

// Limpar o rodapé antes de salvar no banco
        String rodapeParaBanco = rodape.replaceAll("[\\t\\n\\r]+", "").strip();

        formulario.setRodape(rodapeParaBanco);

        formulario.setCabecalho(cabecalho);
        formulario.setRodape(rodape);

        String tituloFormatado = TextoFormulario.gerarTitulo(tituloLimpo);

        // Detecta se é menor de idade
        int idade = 0;
        try {
            LocalDate nascimento = LocalDate.parse(clienteSelecionado.getNascimento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            idade = Period.between(nascimento, LocalDate.now()).getYears();
        } catch (Exception e) {
            System.err.println("Erro ao calcular idade: " + e.getMessage());
        }

        // Validações de regra conforme origemMontagem
        switch (origemMontagem) {
            case CONSENTIMENTO -> {
                if (idade < 18) {
                    JOptionPane.showMessageDialog(null,
                            "O cliente selecionado é menor de idade.\nUse o termo de autorização.",
                            "Validação", JOptionPane.WARNING_MESSAGE);
                    ComboBoxTermo.setSelectedIndex(2);
                    verificarIdade();
                    restaurarModeloPadraoMenor();
                    origemMontagem = OrigemMontagem.AUTORIZACAO;
                    return;
                }
            }

            case AUTORIZACAO -> {
                if (idade >= 18) {
                    JOptionPane.showMessageDialog(null,
                            "O cliente é maior de idade.\nUse o termo de consentimento.",
                            "Validação", JOptionPane.WARNING_MESSAGE);
                    ComboBoxTermo.setSelectedIndex(1);
                    modoClienteMaior();
                    restaurarModeloPadraoConsentimento();
                    origemMontagem = OrigemMontagem.CONSENTIMENTO;
                    return;
                }
                if (responsavelSelecionado == null) {
                    JOptionPane.showMessageDialog(null,
                            "É necessário selecionar um responsável para menores de idade.",
                            "Validação", JOptionPane.WARNING_MESSAGE);
                    //verificarIdade();
                    ComboBoxTermo.setSelectedIndex(2);
                    verificarIdade();
                    restaurarModeloPadraoMenor();
                    origemMontagem = OrigemMontagem.AUTORIZACAO;
                    return;
                }
            }

            case HISTORICO -> {
                // Nenhuma validação necessária
                origemMontagem = OrigemMontagem.HISTORICO;
            }

            default -> {
                JOptionPane.showMessageDialog(null,
                        "Tipo de termo não reconhecido.\nSelecione novamente no ComboBox.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                ComboBoxTermo.setSelectedIndex(0);
                return;
            }
        }

        // Geração do texto final
        String textoCompleto;

        if (idade < 18 && responsavelSelecionado != null) {
            // Menor de idade com responsável
            String cabecalhoResponsa = TextoFormulario.gerarCabecalhoResponsavel(responsavelSelecionado);
            formulario.setCabecalhoResponsa(cabecalhoResponsa);
            textoCompleto = tituloFormatado
                    + cabecalho + "\n"
                    + cabecalhoResponsa + "\n"
                    + formulario.getQuestionario() + "\n"
                    + rodapeParaArquivo;
        } else {
            // Cliente maior de idade ou sem responsável
            textoCompleto = tituloFormatado
                    + cabecalho + "\n"
                    + formulario.getQuestionario() + "\n"
                    + rodapeParaArquivo;
        }

        // Verifica o tamanho e ajusta o conteúdo para o banco se exceder
        int limiteMaximoBytes = 60000;
        int tamanhoBytes = textoCompleto.getBytes(StandardCharsets.UTF_8).length;

        if (tamanhoBytes > limiteMaximoBytes) {
            String aviso = "Limite máximo atingido para salvar no banco, porém o arquivo txt foi salvo com o documento completo.";
            formulario.setQuestionario(aviso);
        }
        // Salva o arquivo normalmente com o conteúdo original
        boolean salvo = FormularioRelatorioGenerator.gerarArquivoTextoComDialogo(textoCompleto);

        // Atualiza banco com o conteúdo ajustado (original ou aviso)
        if (salvo) {
            boolean atualizado = FormResponsaDAO.atualizarFormulario(formulario);
            if (atualizado) {
                JOptionPane.showMessageDialog(null, "Banco de dados atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o banco de dados.");
            }
            this.dispose();
        }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
// identifica que a chamada está vindo de TelaFormResponsa
        new ListaCadastro(funcionarioLogado, this, ListaCadastro.OrigemChamada.TelaFormResponsa).setVisible(true);
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void ComboBoxTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTermoActionPerformed
        try {
            // Guarda o estado atual quando seleciona ComboBox   
            int indiceSelecionado = ComboBoxTermo.getSelectedIndex();
            System.out.println("ComboBoxTermo selecionado: " + ComboBoxTermo.getSelectedIndex());
            if (indiceSelecionado <= 0) {
                return;
            }

            if (idCliente == 0) {
                JOptionPane.showMessageDialog(this,
                        "Nenhum cliente foi selecionado.\nPor favor, selecione um cliente antes de continuar.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                ComboBoxTermo.setSelectedIndex(0);
                return;
            }
            // Centraliza cálculo da idade
            int idade = -1;
            String dataTexto = new CadastroDAO().buscarDataComId(idCliente);
            if (dataTexto != null && !dataTexto.isEmpty()) {
                LocalDate nascimento = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                idade = Period.between(nascimento, LocalDate.now()).getYears();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Não foi possível recuperar a data de nascimento do cliente.",
                        "Erro de dados", JOptionPane.ERROR_MESSAGE);
                ComboBoxTermo.setSelectedIndex(0);
                return;
            }
            // Garante que campos de responsável fiquem ocultos no index 3 (independente da idade)
            if (indiceSelecionado == 3) {
                modoClienteMaior();
            }
            // Regras por índice
            switch (indiceSelecionado) {
                case 1 -> {
                    if (idade < 18) {
                        JOptionPane.showMessageDialog(this,
                                "O cliente selecionado é menor de idade.\nSelecione o termo de autorização.",
                                "Termo inadequado", JOptionPane.WARNING_MESSAGE);
                        ComboBoxTermo.setSelectedIndex(2);
                        verificarIdade();
                        restaurarModeloPadraoMenor();
                        origemMontagem = OrigemMontagem.AUTORIZACAO;
                    } else {
                        restaurarModeloPadraoConsentimento();
                        origemMontagem = OrigemMontagem.CONSENTIMENTO;
                    }
                }

                case 2 -> {
                    if (idade < 18) {
                        restaurarModeloPadraoMenor();
                        verificarIdade(); // Exibe os campos do responsável
                        origemMontagem = OrigemMontagem.AUTORIZACAO;
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "O cliente selecionado é maior de idade.\nNão é necessário termo de autorização.\nSelecione o termo de consentimento.",
                                "Termo inadequado", JOptionPane.INFORMATION_MESSAGE);
                        ComboBoxTermo.setSelectedIndex(1);
                        modoClienteMaior();
                        restaurarModeloPadraoConsentimento();
                        origemMontagem = OrigemMontagem.CONSENTIMENTO;
                    }
                }
                case 3 -> {
                    ignorarVerificacaoIdade = true;
                    bloquearModoResponsavel = true; // impede exibição dos campos do responsável
                    modoClienteMaior();
                    List<Informacao> info;
                    try {
                        info = InfoDAO.buscarInfoPeloIdCliente(idCliente);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao buscar informações para este ID: " + e.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (info.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "Nenhuma informação encontrada para o ID: " + idCliente,
                                "Informação", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    new ListaInfo(idCliente).setVisible(true);
                    this.dispose();
                }

                default ->
                    throw new IllegalArgumentException("Índice inválido: " + indiceSelecionado);
            }

            bloquearModoResponsavel = false;
            ignorarVerificacaoIdade = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ComboBoxTermoActionPerformed

    private void ButtonBuscarResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarResponsavelActionPerformed
        new ListaCadastro(funcionarioLogado, this, ListaCadastro.OrigemChamada.TelaFormResponsaResponsavel).setVisible(true);
    }//GEN-LAST:event_ButtonBuscarResponsavelActionPerformed

    private void TextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIDActionPerformed

    }//GEN-LAST:event_TextFieldIDActionPerformed
    public void desativarCamposResponsavel() {
        SwingUtilities.invokeLater(() -> {
            modoClienteMaior();
            System.out.println("Modo cliente responsável desativado");
        });
    }

    private void carregarDados() {
        FormResponsa formulario = FormResponsaDAO.buscarUltimoFormulario(); // busca o último formulário salvo no banco
        if (formulario != null) {
            String tituloBruto = formulario.getTitulo();
            if (tituloBruto != null) {
                // Remove todos os tipos de espaços laterais (incluindo tabs, quebras de linha etc.)
                String tituloFormatado = tituloBruto.replaceAll("^[\\s\\u00A0]+|[\\s\\u00A0]+$", "");
                //String tituloFormatado = tituloBruto.replaceAll("^\\s+|\\s+$", "");
                TextFieldTitulo.setText(tituloFormatado);
            } else {
                TextFieldTitulo.setText(""); // Ou um valor padrão se preferir
            }
            TextAreaFormulario.setText(formulario.getQuestionario());
            TextFieldCidade.setText(formulario.getCidade());
            TextNomeEmpresa.setText(formulario.getEmpresa());

            // Atualiza o ID atual para uso posterior
            idFormularioAtual = formulario.getId();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados do formulário.");
        }
    }

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
            java.util.logging.Logger.getLogger(TelaFormResponsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFormResponsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFormResponsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFormResponsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFormResponsa().setVisible(true);
            }
        });
    }

    public void receberIdCliente(int idCliente) {
        for (Cadastro c : CadastroDAO.listarTodos()) {
            if (c.getId() == idCliente) {
                clienteSelecionado = c;
                this.idCliente = c.getId();
                break;
            }
        }

        if (clienteSelecionado != null) {
            cabecalhoGerado = TextoFormulario.gerarCabecalho(clienteSelecionado);
            TextFieldID.setText(String.valueOf(idCliente));

            // Força a verificação da idade após preencher o campo
            verificarIdadeInstantaneamente();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
        }
    }

    private void verificarIdade() {
        try {
            // Impede reativação dos campos quando index 3 estiver ativo
            if (bloquearModoResponsavel) {
                modoClienteMaior();
                return;
            }
            CadastroDAO cDAO = new CadastroDAO();
            String dataTexto = cDAO.buscarDataComId(this.idCliente);

            TextFieldID.setBackground(Color.YELLOW); // Indica processamento

            if (dataTexto != null && !dataTexto.isEmpty()) {
                LocalDate dataNascimento = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate dataAtual = LocalDate.now();
                int idade = Period.between(dataNascimento, dataAtual).getYears();

                if (idade < 18) {
                    SwingUtilities.invokeLater(() -> {
                        LabelCliente.setText("ID (menor):");
                        LabelResponsavel.setVisible(true);
                        TextFieldIDResponsavel.setVisible(true);
                        TextFieldIDResponsavel.setEnabled(false);
                        ButtonBuscarResponsavel.setVisible(true);
                    });
                } else {
                    modoClienteMaior();
                }
            } else {
                System.err.println("Data de nascimento não encontrada.");
                modoClienteMaior(); // Se não encontrou data de nascimento
            }

        } catch (Exception e) {
            modoClienteMaior(); // Em caso de qualquer erro
            System.err.println("Erro ao verificar idade: " + e.getMessage());
        }
        TextFieldID.setBackground(Color.WHITE);
    }
//desativa componentes do responsável

    private boolean isMenor() {
        try {
            String dataTexto = new CadastroDAO().buscarDataComId(idCliente);
            if (dataTexto != null && !dataTexto.isEmpty()) {
                LocalDate nascimento = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int idade = Period.between(nascimento, LocalDate.now()).getYears();
                return idade < 18;
            }
        } catch (Exception e) {
            System.err.println("Erro ao calcular idade: " + e.getMessage());
        }
        return false; // Por padrão, considera maior
    }

    private void verificarIdadeInstantaneamente() {

        if (ignorarVerificacaoIdade) {
            System.out.println("verificarIdadeInstantaneamente() ignorado temporariamente.");
            return;
        }
        String idText = TextFieldID.getText().trim();
        if (!idText.isEmpty() && idText.matches("\\d+")) {
            try {
                int id = Integer.parseInt(idText);
                if (id != idCliente) { // Só verifica se o ID mudou
                    idCliente = id;
                    verificarIdade();
                }
            } catch (NumberFormatException ex) {
                modoClienteMaior(); // Volta ao modo padrão se ID inválido
            }
        } else {
            modoClienteMaior(); // Volta ao modo padrão se campo vazio ou inválido
        }
    }

    private void configurarListenerIDCliente() {
        TextFieldID.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                verificarIdadeInstantaneamente();
            }

            public void removeUpdate(DocumentEvent e) {
                verificarIdadeInstantaneamente();
            }

            public void changedUpdate(DocumentEvent e) {
                verificarIdadeInstantaneamente();
            }
        });
    }

    public void setResponsavelSelecionado(Cadastro responsavel) {
        this.responsavelSelecionado = responsavel;
        TextFieldIDResponsavel.setText(String.valueOf(responsavel.getId()));
        JOptionPane.showMessageDialog(this, "Responsável selecionado com sucesso.");
    }

    private void modoClienteMaior() {
        LabelCliente.setText("ID do cliente :");
        LabelResponsavel.setVisible(false);
        TextFieldIDResponsavel.setVisible(false);
        ButtonBuscarResponsavel.setVisible(false);
    }

    private void restaurarModeloPadraoConsentimento() {
        try ( InputStream is = getClass().getResourceAsStream("/resources/consentimento.txt");  BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String modeloPadrao = reader.lines().collect(Collectors.joining("\n"));
            TextAreaFormulario.setText(modeloPadrao);
            TextFieldTitulo.setText("----- TERMO DE CONSENTIMENTO -----");
        } catch (IOException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar modelo padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void restaurarModeloPadraoMenor() {
        try ( InputStream is = getClass().getResourceAsStream("/resources/autoriza.txt");  BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String modeloPadrao = reader.lines().collect(Collectors.joining("\n"));
            TextAreaFormulario.setText(modeloPadrao);
            TextFieldTitulo.setText("----- TERMO DE AUTORIZAÇÃO E CONSENTIMENTO -----");
        } catch (IOException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar modelo padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
//    Carrega formulário selecionado na lista de formulários

    public void carregarFormulario(int idFormulario) {
        try {
            FormResponsa formulario = FormResponsaDAO.buscarFormularioPorId(idFormulario);

            if (formulario != null) {
                //  preenchimento dos campos
                this.idFormularioAtual = formulario.getId();
                TextFieldID.setText(String.valueOf(formulario.getIdCliente()));
                TextFieldTitulo.setText(formulario.getTitulo());
                TextAreaFormulario.setText(formulario.getQuestionario());
                TextFieldCidade.setText(formulario.getCidade());
                TextNomeEmpresa.setText(formulario.getEmpresa());
            } else {
                JOptionPane.showMessageDialog(this, "Formulário não encontrado no banco de dados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar o formulário: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void setTextoNoFormulario(String texto) {
        TextAreaFormulario.setText(texto);
    }

    public void setTituloHistorico(String titulo) {
        TextFieldTitulo.setText(titulo);
        origemMontagem = OrigemMontagem.HISTORICO;
    }

    private enum OrigemMontagem {
        HISTORICO,
        AUTORIZACAO,
        CONSENTIMENTO
    }
    private OrigemMontagem origemMontagem;

    private void contadorDeBytes() {
        TextAreaFormulario.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            int limiteBytes = 65535;

            private void atualizarContadorBytes() {
                try {
                    // Calcula o tamanho real em bytes no encoding UTF-8
                    byte[] bytes = TextAreaFormulario.getText().getBytes("UTF-8");
                    int tamanho = bytes.length;

                    LabelBytes.setText("Limite de Bytes: " + tamanho + "/" + limiteBytes);

                    if (tamanho > limiteBytes) {
                        LabelBytes.setForeground(Color.RED);
                    } else {
                        LabelBytes.setForeground(Color.BLACK);
                    }
                } catch (Exception e) {
                    LabelBytes.setText("Erro ao contar bytes");
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContadorBytes();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContadorBytes();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                atualizarContadorBytes();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonBuscarResponsavel;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JComboBox<String> ComboBoxTermo;
    private javax.swing.JLabel LabelBytes;
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelResponsavel;
    private javax.swing.JTextArea TextAreaFormulario;
    private javax.swing.JTextField TextFieldCidade;
    private javax.swing.JTextField TextFieldID;
    private javax.swing.JTextField TextFieldIDResponsavel;
    private javax.swing.JTextField TextFieldTitulo;
    private javax.swing.JTextField TextNomeEmpresa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
