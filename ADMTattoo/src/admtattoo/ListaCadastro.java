package admtattoo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ListaCadastro extends javax.swing.JFrame {

    private Funcionario funcionarioLogado;

    private boolean tabelaMontadaPorFiltroEspecial = false;
    private OrigemChamada origem;
    private boolean origemAgendamento;
    private JFrame pai;

    public ListaCadastro(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        initComponents();
        setLocationRelativeTo(null);
        configurarTextBusca();
        RadioButtonFuncionario.setSelected(true);
        configurarListenersRadio();
        acionarButtonBuscar();
        contarLinhasTabela();
        atualizarEstadoBotoes();
        aplicarPermissoes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public ListaCadastro(TelaFormResponsa aThis) {
    }

    public ListaCadastro(Funcionario funcionarioLogado, boolean origemAgendamento) {
        this.funcionarioLogado = funcionarioLogado;
        this.origemAgendamento = origemAgendamento;
        initComponents();
        setLocationRelativeTo(null);
        configurarTextBusca();
        configurarListenersRadio();
        TableCadastro.setModel(montarTabela());
        atualizarEstadoBotoes();
        aplicarPermissoes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public ListaCadastro(Funcionario funcionarioLogado, JFrame pai, OrigemChamada origem) {
        this.funcionarioLogado = funcionarioLogado;
        this.pai = pai;
        this.origem = origem;
        initComponents();
        setLocationRelativeTo(null);
        configurarTextBusca();
        configurarListenersRadio();
        TableCadastro.setModel(montarTabela());
        atualizarEstadoBotoes();
        aplicarPermissoes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selecionaCliente();
    }

    // Construtor que lista o último cadastro
    ListaCadastro(Funcionario funcionarioLogado, TelaCadastrar aThis, OrigemChamada origemChamada, int id) {
        this.funcionarioLogado = funcionarioLogado;
        this.pai = aThis;
        this.origem = origemChamada;
        initComponents();
        setLocationRelativeTo(null);
        configurarTextBusca();
        configurarListenersRadio();
        TableCadastro.setModel(montarTabelaID(id));
        contarLinhasTabela();
        botoesModoAgenda();
        aplicarPermissoes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCadastro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ButtonExcluir = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        ButtonSelecione = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();
        ButtonHistorico = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ButtonBuscar = new javax.swing.JButton();
        TextBusca = new javax.swing.JTextField();
        RadioButtonCliente = new javax.swing.JRadioButton();
        RadioButtonFuncionario = new javax.swing.JRadioButton();
        RadioButtonFornecedor = new javax.swing.JRadioButton();
        RadioButtonTodos = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        ButtonAniversario = new javax.swing.JButton();
        ButtonFuncionario = new javax.swing.JButton();
        LabelRegistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Lista de cadastros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableCadastro.setModel(new javax.swing.table.DefaultTableModel(
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
        TableCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TableCadastroFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TableCadastro);

        ButtonExcluir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonExcluir.setText("Excluir");
        ButtonExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirActionPerformed(evt);
            }
        });

        ButtonEditar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonEditar.setText("Editar");
        ButtonEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditarActionPerformed(evt);
            }
        });

        ButtonSelecione.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonSelecione.setText("Selecione");
        ButtonSelecione.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonSelecione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSelecioneActionPerformed(evt);
            }
        });

        ButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });

        ButtonHistorico.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonHistorico.setText("Histórico");
        ButtonHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(ButtonHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonSelecione, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSelecione, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        ButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ButtonBuscar.setText("Buscar");
        ButtonBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        TextBusca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextBusca.setText("Digite o nome:");

        buttonGroup1.add(RadioButtonCliente);
        RadioButtonCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonCliente.setText("Cliente");

        buttonGroup1.add(RadioButtonFuncionario);
        RadioButtonFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonFuncionario.setText("Funcionário");

        buttonGroup1.add(RadioButtonFornecedor);
        RadioButtonFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonFornecedor.setText("Fornecedor");

        buttonGroup1.add(RadioButtonTodos);
        RadioButtonTodos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RadioButtonTodos.setText("Todos");
        RadioButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(TextBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(RadioButtonTodos)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonCliente)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButtonFornecedor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonCliente)
                    .addComponent(RadioButtonFuncionario)
                    .addComponent(RadioButtonFornecedor)
                    .addComponent(RadioButtonTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonAniversario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonAniversario.setText("Aniversariantes");
        ButtonAniversario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonAniversario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAniversarioActionPerformed(evt);
            }
        });

        ButtonFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonFuncionario.setText("Funcionários");
        ButtonFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(ButtonAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ButtonAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ButtonFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        LabelRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelRegistro.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditarActionPerformed
        int id = getPosicao();
        if (id == -1) {
            return;
        }

        Cadastro cadastro = CadastroDAO.buscarPorId(id);
        if (cadastro != null) {

            // Guarda o estado atual antes de abrir a edição
            OrigemMontagem estadoAnterior = origemMontagem;

            AtualizarCadastro ac = new AtualizarCadastro(funcionarioLogado, cadastro);
            ac.setLocationRelativeTo(null);

// Adiciona o listener para saber quando a janela foi fechada
            ac.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    // Restaura a tabela conforme a origem original
                    switch (estadoAnterior) {
                        case ANIVERSARIO:
                            ButtonAniversario.doClick();
                            break;
                        case FUNCIONARIO:
                            ButtonFuncionario.doClick();
                            break;
                        case NORMAL:
                        default:
                            acionarButtonBuscar();
                            break;
                    }

                    // Atualiza a tabela se houve edição
                    if (ac.isAtualizado()) {
                        atualizarTabela();
                    }
                    aplicarPermissoes();
                }
            });

            ac.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Cadastro não encontrado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonEditarActionPerformed

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed
        try {
            int id = getPosicao();
            if (id == -1) {
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir este cadastro ?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                boolean sucesso = CadastroDAO.excluir(id);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Cadastro excluído com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    TableCadastro.setModel(montarTabela());
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao excluir cadastro.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao tentar excluir cadastro: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonExcluirActionPerformed

    private void ButtonSelecioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSelecioneActionPerformed
        int posicao = TableCadastro.getSelectedRow();
        if (posicao == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cadastro!");
            return;
        }

        int idSelecionado = getPosicao();

        switch (origem) {
            case TelaAgendar:
                if (pai instanceof TelaAgendar telaAgendar) {
                    telaAgendar.setIdSelecionado(idSelecionado);
                }
                break;
            case TelaCadastrar:
                TelaAgendar telaAgendar = new TelaAgendar(idSelecionado);
                telaAgendar.setVisible(true);
                break;
            case TelaFormResponsa:
                if (pai instanceof TelaFormResponsa telaForm) {
                    telaForm.receberIdCliente(idSelecionado);
                }
                break;
            case TelaFormResponsaResponsavel:
                if (pai instanceof TelaFormResponsa telaForm) {
                    Cadastro responsavel = CadastroDAO.buscarPorId(idSelecionado);
                    if (responsavel != null) {
                        telaForm.setResponsavelSelecionado(responsavel);
                    }
                }
                break;
            case ListaFormulario:
                if (pai instanceof ListaFormulario listaFormulario) {
                    listaFormulario.setIdSelecionado(idSelecionado);
                }
                break;
        }
        if (pai == null) {
            JOptionPane.showMessageDialog(this, "Cliente selecionado com sucesso.");
        }

        if (pai != null) {
            this.dispose();
        }
    }//GEN-LAST:event_ButtonSelecioneActionPerformed

    private void TableCadastroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TableCadastroFocusGained
    }//GEN-LAST:event_TableCadastroFocusGained

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarActionPerformed
        // Guarda o estado atual antes de abrir a edição
        OrigemMontagem estadoAnterior = origemMontagem;

        TelaCadastrar tc;

        // Usa origem e pai para definir o tipo de chamada
        if (origem != null && pai instanceof TelaFormResponsa telaForm) {
            switch (origem) {
                case TelaFormResponsa -> {
                    tc = new TelaCadastrar(telaForm, TelaCadastrar.OrigemChamada.TelaFormResponsa);
                }
                case TelaFormResponsaResponsavel -> {
                    tc = new TelaCadastrar(telaForm, TelaCadastrar.OrigemChamada.TelaFormResponsaResponsavel);
                }
                default -> {
                    tc = new TelaCadastrar(); // chamada padrão
                }
            }
        } else {
            tc = new TelaCadastrar(); // chamada padrão
        }

        tc.setLocationRelativeTo(null);

        // Adiciona o listener para saber quando a janela foi fechada
        tc.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                // Restaura a tabela conforme a origem original
                switch (estadoAnterior) {
                    case ANIVERSARIO ->
                        ButtonAniversario.doClick();
                    case FUNCIONARIO ->
                        ButtonFuncionario.doClick();
                    case NORMAL, default ->
                        acionarButtonBuscar();
                }
            }
        });

        tc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonCadastrarActionPerformed

    private void RadioButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonTodosActionPerformed
    }//GEN-LAST:event_RadioButtonTodosActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        TableCadastro.setModel(montarTabela());
        buscaComFiltro();
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void ButtonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHistoricoActionPerformed
        int posicao = TableCadastro.getSelectedRow();
        if (posicao == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cadastro!");
            return;
        }
        // Pega o ID e o tipo do cadastro selecionado
        int id = getPosicao();
        String status = CadastroDAO.buscarStatusPorId(id);
        ListaAgenda la = new ListaAgenda(id, status);
        la.setVisible(true);
    }//GEN-LAST:event_ButtonHistoricoActionPerformed

    private void ButtonAniversarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAniversarioActionPerformed
        origemMontagem = OrigemMontagem.ANIVERSARIO;
        TableCadastro.setModel(montarTabela());
        filtrarAniversariantesDoMes();
    }//GEN-LAST:event_ButtonAniversarioActionPerformed

    private void ButtonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFuncionarioActionPerformed
        origemMontagem = OrigemMontagem.FUNCIONARIO;
        montarTabelaFuncionario();
        //Ajustar cabeçalhos ou outras configurações
        TableCadastro.getTableHeader().setReorderingAllowed(false);
    }//GEN-LAST:event_ButtonFuncionarioActionPerformed
    private void acionarButtonBuscar() {
        origemMontagem = OrigemMontagem.NORMAL;
        ButtonBuscar.doClick(); // Simula um clique no botão
    }

    private enum OrigemMontagem {
        NORMAL,
        ANIVERSARIO,
        FUNCIONARIO
    }
    private OrigemMontagem origemMontagem = OrigemMontagem.NORMAL;

    private void resetarEstadoMontagem() {
        origemMontagem = OrigemMontagem.NORMAL;
    }

    private void atualizarTabelaComResultados(List<Cadastro> cadastros) {
        DefaultTableModel model = (DefaultTableModel) TableCadastro.getModel();
        model.setRowCount(0);

        for (Cadastro cadastro : cadastros) {
            model.addRow(new Object[]{
                cadastro.getId(),
                cadastro.getStatus(),
                cadastro.getNome(),
                cadastro.getCpf(),
                cadastro.getCnpj(),
                formatarDataString(cadastro.getNascimento()),
                cadastro.getTel(),
                cadastro.getCep(),
                cadastro.getRua(),
                cadastro.getNumero(),
                cadastro.getBairro(),
                cadastro.getCfal(),
                cadastro.getCidade(),
                cadastro.getEmail()
            });
        }
        atualizarEstadoBotoes();
        aplicarPermissoes();
        model.addTableModelListener(e -> contarLinhasTabela());
        contarLinhasTabela();
    }

    private void aplicarPermissoes() {
        if (funcionarioLogado == null) {
            return;
        }
        if (!"Gerente".equalsIgnoreCase(funcionarioLogado.getCargo())) {
            ButtonEditar.setEnabled(false);
            ButtonExcluir.setEnabled(false);
        }
    }

    private DefaultTableModel montarTabela() {
        String[] colunas = {"id", "status", "nome", "cpf", "cnpj", "data", "tel", "cep", "rua", "numero", "bairro", "local", "cidade", "email"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Integer.class : String.class;
            }
        };

        try {
            ArrayList<Cadastro> lista = CadastroDAO.listarTodos();
            for (Cadastro c : lista) {
                model.addRow(new Object[]{
                    c.getId(),
                    c.getStatus(),
                    c.getNome(),
                    c.getCpf(),
                    c.getCnpj(),
                    formatarDataString(c.getNascimento()),
                    c.getTel(),
                    c.getCep(),
                    c.getRua(),
                    c.getNumero(),
                    c.getBairro(),
                    c.getCfal(),
                    c.getCidade(),
                    c.getEmail()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addTableModelListener(e -> contarLinhasTabela());
        contarLinhasTabela();
        configurarTabela();
        aplicarPermissoes();
        return model;
    }

    // Monta tabela com ID específico
    private DefaultTableModel montarTabelaID(int id) {
        String[] colunas = {"id", "status", "nome", "cpf", "cnpj", "data", "tel", "cep", "rua", "numero", "bairro", "local", "cidade", "email"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Integer.class : String.class;
            }
        };
        try {
            Cadastro cadastro = CadastroDAO.buscarPorId(id); // Recebe um único Cadastro
            if (cadastro != null) { // Verifica se encontrou o cadastro
                model.addRow(new Object[]{
                    cadastro.getId(),
                    cadastro.getStatus(),
                    cadastro.getNome(),
                    cadastro.getCpf(),
                    cadastro.getCnpj(),
                    formatarDataString(cadastro.getNascimento()),
                    cadastro.getTel(),
                    cadastro.getCep(),
                    cadastro.getRua(),
                    cadastro.getNumero(),
                    cadastro.getBairro(),
                    cadastro.getCfal(),
                    cadastro.getCidade(),
                    cadastro.getEmail()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addTableModelListener(e -> contarLinhasTabela());
        contarLinhasTabela();
        configurarTabela();
        aplicarPermissoes();
        return model;
    }

    private void montarTabelaFuncionario() {
        JTable table = TableCadastro;

        String[] colunas = {"ID", "Nome", "Cargo", "Admissão", "Status", "Demissão"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Integer.class;  // ID
                    case 3:
                        return String.class;    // Admissão
                    case 4:
                        return String.class;   // Status
                    case 5:
                        return String.class;   // Demissão
                    default:
                        return String.class;   // Demais colunas
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            ArrayList<Funcionario> lista = FuncionarioDAO.listarTodos();

            for (Funcionario f : lista) {
                model.addRow(new Object[]{
                    f.getIdProfissional(),
                    f.getNome(),
                    f.getCargo(),
                    formatarDataString(f.getDataEntrada()),
                    f.isStatus() ? "Ativo" : "Inativo",
                    formatarDataString(f.getDataSaida())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionários: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        table.setModel(model);

        // Configurar renderizador para a coluna de Status
        table.getColumn("Status").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                setText(value == null ? "" : value.toString());
                // personalizar aparência
                setHorizontalAlignment(SwingConstants.CENTER);
            }
        });

        // Ajustar largura das colunas
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);  // ID
        columnModel.getColumn(1).setPreferredWidth(150); // Nome
        columnModel.getColumn(2).setPreferredWidth(100); // Cargo

        contarLinhasTabela();
        aplicarPermissoes();
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
    public void atualizarTabela() {
        try {
            List<Cadastro> todosCadastros = CadastroDAO.listarTodos();
            atualizarTabelaComResultados(todosCadastros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar cadastros: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public int getPosicao() {
        int selectedRow = TableCadastro.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum cadastro selecionado. Por favor, selecione um na tabela.",
                    "Seleção Necessária", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        try {
            Object valorId = TableCadastro.getValueAt(selectedRow, 0);
            return Integer.parseInt(valorId.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao obter ID do cadastro: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void configurarTabela() {
        // Configuração básica da tabela
        TableCadastro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableCadastro.setRowSelectionAllowed(true);
        TableCadastro.setColumnSelectionAllowed(false);
        TableCadastro.setShowGrid(true);
        TableCadastro.setGridColor(Color.LIGHT_GRAY);

        // Configuração visual da seleção
        TableCadastro.setSelectionBackground(new Color(0, 120, 215));
        TableCadastro.setSelectionForeground(Color.WHITE);

        // Renderizador personalizado para melhor visualização
        TableCadastro.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground());
                } else {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
// Listener para clique do mouse na tabela
        TableCadastro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = TableCadastro.rowAtPoint(e.getPoint());

                // Ignora cliques fora da tabela
                if (row < 0) {
                    return;
                }
            }
        });
    }

    public String obterTipoCadastroSelecionado() {
        String status = "";
        if (RadioButtonCliente.isSelected()) {
            status = "Cliente";
        } else if (RadioButtonFuncionario.isSelected()) {
            status = "Funcionário";
        } else if (RadioButtonFornecedor.isSelected()) {
            status = "Fornecedor";
        } else {
            return "Todos";
        }
        return status;
    }
// Método que atualiza a JTable

    private void atualizarTabela(List<Cadastro> lista) {
        DefaultTableModel model = (DefaultTableModel) TableCadastro.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Cadastro cadastro : lista) {
            model.addRow(new Object[]{
                cadastro.getId(),
                cadastro.getStatus(),
                cadastro.getNome(),
                cadastro.getCpf(),
                cadastro.getCnpj(),
                formatarDataString(cadastro.getNascimento()),
                cadastro.getTel(),
                cadastro.getCep(),
                cadastro.getRua(),
                cadastro.getNumero(),
                cadastro.getBairro(),
                cadastro.getCfal(),
                cadastro.getCidade(),
                cadastro.getEmail()
            });
        }
        model.addTableModelListener(e -> contarLinhasTabela());
        contarLinhasTabela();
        aplicarPermissoes();
    }
// Método que filtra a lista pelo nome digitado

    private List<Cadastro> filtrarListaPorNome(List<Cadastro> listaOriginal, String nomeBusca) {
        List<Cadastro> listaFiltrada = new ArrayList<>();
        for (Cadastro cadastro : listaOriginal) {
            if (cadastro.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                listaFiltrada.add(cadastro);
            }
        }
        aplicarPermissoes();
        return listaFiltrada;
    }

    public void selecionaCliente() {
        RadioButtonCliente.setSelected(true);
        buscaComFiltro();
    }

    public void buscaComFiltro() {
        try {
            CadastroDAO cDAO = new CadastroDAO();
            String busca = TextBusca.getText().trim();
            String tipoSelecionado = obterTipoCadastroSelecionado();

            List<Cadastro> lista = cDAO.buscarPorStatus(tipoSelecionado);

            if (!busca.isEmpty() && !busca.equalsIgnoreCase("Digite o nome:")) {
                lista = filtrarListaPorNome(lista, busca);
            }
            atualizarTabelaComResultados(lista);
            aplicarPermissoes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar cadastros: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private boolean permitirEdicao = true;

    public void setPermitirEdicao(boolean permitir) {
        this.permitirEdicao = permitir;
    }

    private void botoesModoAgenda() {
        ButtonSelecione.setEnabled(true);
        ButtonHistorico.setEnabled(false);
        ButtonEditar.setEnabled(false);
        ButtonExcluir.setEnabled(false);
        ButtonCadastrar.setEnabled(false);
        ButtonAniversario.setEnabled(false);
        ButtonFuncionario.setEnabled(false);
        ButtonBuscar.setEnabled(false);
        TextBusca.setEnabled(false);
        RadioButtonTodos.setEnabled(false);
        RadioButtonFuncionario.setEnabled(false);
        RadioButtonCliente.setEnabled(false);
        RadioButtonFornecedor.setEnabled(false);
    }

    private void atualizarEstadoBotoes() {
        // Se foi chamado por outro frame (pai != null ou origemAgendamento == true), habilita o botão Selecione
        boolean habilitarSelecione = origemAgendamento || pai != null;

        // Se foi acessado diretamente (sem pai e sem origem de agendamento), habilita os demais botões
        boolean habilitarOutros = !origemAgendamento && pai == null;

        ButtonSelecione.setEnabled(habilitarSelecione);
        ButtonHistorico.setEnabled(habilitarOutros);
        ButtonEditar.setEnabled(habilitarOutros);
        ButtonExcluir.setEnabled(habilitarOutros);
    }

    private void configurarTextBusca() {
        // Configura o texto inicial
        TextBusca.setText("Digite o nome:");
        TextBusca.setForeground(Color.GRAY);

        // Configura o listener
        TextBusca.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextBusca.getText().equals("Digite o nome:")) {
                    TextBusca.setText("");
                    TextBusca.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TextBusca.getText().isEmpty()) {
                    TextBusca.setText("Digite o nome:");
                    TextBusca.setForeground(Color.GRAY);
                }
            }
        });

        // Truque para garantir o foco inicial correto
        SwingUtilities.invokeLater(() -> {
            // Força o foco para outro componente temporariamente
            JComponent dummy = new JPanel();
            add(dummy);
            dummy.requestFocusInWindow();

            // Restaura o estado normal do TextBusca
            remove(dummy);
            TextBusca.setFocusable(true);

            if (getContentPane().getComponentCount() > 0) {
                getContentPane().getComponent(0).requestFocusInWindow();
            }
        });
    }

    private void filtrarAniversariantesDoMes() {
        int mesAtual = LocalDate.now().getMonthValue();
        CadastroDAO cadastroDAO = new CadastroDAO();

        List<Cadastro> aniversariantes = cadastroDAO.buscarAniversariantesDoMes(mesAtual);
        atualizarTabela(aniversariantes); // método que atualiza a JTable

        if (aniversariantes.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum aniversariante encontrado para este mês.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        aplicarPermissoes();
    }
//    identifica a origem da chamada

    public enum OrigemChamada {
        TelaCadastrar,
        TelaFormResponsa,
        TelaFormResponsaResponsavel, // caso para o responsável
        TelaAgendar,
        ListaFormulario
    }

    private void contarLinhasTabela() {
        int totalLinhas = TableCadastro.getRowCount();
        LabelRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        LabelRegistro.setVerticalAlignment(SwingConstants.CENTER);
        LabelRegistro.setText("Total de registros : " + totalLinhas);
        if (totalLinhas == 0) {
            LabelRegistro.setText("Nenhum registro encontrado !");
            LabelRegistro.setForeground(Color.RED);
            LabelRegistro.setFont(LabelRegistro.getFont().deriveFont(Font.BOLD));
        } else {
            LabelRegistro.setForeground(Color.BLACK);
            LabelRegistro.setFont(LabelRegistro.getFont().deriveFont(Font.PLAIN));
        }
    }

    private void configurarListenersRadio() {
        ActionListener listenerStatus = e -> {
            if (RadioButtonFuncionario.isSelected()) {
                TableCadastro.setModel(montarTabela());
                buscaComFiltro();
            } else if (RadioButtonCliente.isSelected()) {
                TableCadastro.setModel(montarTabela());
                buscaComFiltro();
            } else if (RadioButtonFornecedor.isSelected()) {
                TableCadastro.setModel(montarTabela());
                buscaComFiltro();
            } else if (RadioButtonTodos.isSelected()) {
                TableCadastro.setModel(montarTabela());
                buscaComFiltro();
            } else {
                TableCadastro.setModel(montarTabela());
            }
        };

        RadioButtonFuncionario.addActionListener(listenerStatus);
        RadioButtonCliente.addActionListener(listenerStatus);
        RadioButtonFornecedor.addActionListener(listenerStatus);
        RadioButtonTodos.addActionListener(listenerStatus);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAniversario;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JButton ButtonFuncionario;
    private javax.swing.JButton ButtonHistorico;
    private javax.swing.JButton ButtonSelecione;
    private javax.swing.JLabel LabelRegistro;
    private javax.swing.JRadioButton RadioButtonCliente;
    private javax.swing.JRadioButton RadioButtonFornecedor;
    private javax.swing.JRadioButton RadioButtonFuncionario;
    private javax.swing.JRadioButton RadioButtonTodos;
    private javax.swing.JTable TableCadastro;
    private javax.swing.JTextField TextBusca;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
