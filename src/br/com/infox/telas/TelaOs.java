/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; // trazer dados da tabela

/**
 *
 * @author kaick
 */
public class TelaOs extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    // cria uma variavel para armazenar um texto de acordo com um radion butoon
    private String tipo;
    
    public TelaOs() {
        initComponents();
        conexao = ModuloConexao.conector();

    }

    private void consultar() {
        String sql = "select idcli, nomecli, fonecli from tbcliente where nomecli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtosnome.getText() + "%"); // pesquisa por nome
            rs = pst.executeQuery();
            tabelaoscli.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    private void setar_campos(){
        int setar = tabelaoscli.getSelectedRow();
        txtosid.setText(tabelaoscli.getModel().getValueAt(setar, 0).toString());
    }
    
    private void limparCamposOS(){
    txtosequip.setText(null);
    txtosdef.setText(null);
    txtosserv.setText(null);
    txtostec.setText(null);
    txtosvalor.setText(null);
    txtosid.setText(null);
    }
    private void corNormalOS(){
    Color normal = Color.WHITE;
    txtosequip.setBackground(normal);
    txtosdef.setBackground(normal);
    txtosserv.setBackground(normal);
    txtostec.setBackground(normal);
    txtosvalor.setBackground(normal);
    txtosid.setBackground(normal); 
    }
    
    
    private void adicionarOS(){
    String sql = "INSERT INTO tbos(tipo, situacao, equipamento, defeito, servico, tecnico, valor, idcli)"
               + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, tipo);
        pst.setString(2, combosituacao.getSelectedItem().toString());
        pst.setString(3, txtosequip.getText());
        pst.setString(4, txtosdef.getText());
        pst.setString(5, txtosserv.getText());
        pst.setString(6, txtostec.getText());
        String valorTexto = txtosvalor.getText().replace(",", ".");
        double valorNumerico = Double.parseDouble(valorTexto);
        pst.setDouble(7, valorNumerico);
        int idCliente = Integer.parseInt(txtosid.getText());
        pst.setInt(8, idCliente);

        boolean camposVazios = false;
        Color alerta = new Color(255, 204, 204);

        // Verifica cada campo obrigatório
        if (tipo == null || tipo.trim().isEmpty()) {
            camposVazios = true;
        }
        if (combosituacao.getSelectedItem() == null || combosituacao.getSelectedItem().toString().trim().isEmpty()) {
            camposVazios = true;
            combosituacao.setBackground(alerta);
        }
        if (txtosequip.getText().isEmpty()) {
            camposVazios = true;
            txtosequip.setBackground(alerta);
        }
        if (txtosdef.getText().isEmpty()) {
            camposVazios = true;
            txtosdef.setBackground(alerta);
        }
        if (txtosserv.getText().isEmpty()) {
            camposVazios = true;
            txtosserv.setBackground(alerta);
        }
        if (txtostec.getText().isEmpty()) {
            camposVazios = true;
            txtostec.setBackground(alerta);
        }
        if (txtosvalor.getText().isEmpty()) {
            camposVazios = true;
            txtosvalor.setBackground(alerta);
        }
        if (txtosid.getText().isEmpty()) {
            camposVazios = true;
            txtosid.setBackground(alerta);
        }

        if (camposVazios) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            return;
        }

        // Se chegou aqui, todos os campos foram preenchidos
        int adicionado = pst.executeUpdate();
        if (adicionado > 0) {
            JOptionPane.showMessageDialog(null, "Ordem de serviço cadastrada com sucesso!");
            limparCamposOS();
            corNormalOS();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    private void pesquisarOS(){
        String num = JOptionPane.showInputDialog("Número da OS");
        String sql = "select * from tbos where os = " + num;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma ordem de serviço encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. Tente novamente");
            
        }
            
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblidos = new javax.swing.JLabel();
        lbldataos = new javax.swing.JLabel();
        txtordemid = new javax.swing.JTextField();
        txtosdata = new javax.swing.JTextField();
        radioorcamento = new javax.swing.JRadioButton();
        radioOS = new javax.swing.JRadioButton();
        lblsituacao = new javax.swing.JLabel();
        combosituacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtosnome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtosid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaoscli = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblosequip = new javax.swing.JLabel();
        lblostec = new javax.swing.JLabel();
        lblosdef = new javax.swing.JLabel();
        txtosequip = new javax.swing.JTextField();
        txtostec = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtosserv = new javax.swing.JTextArea();
        lblosserv = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtosdef = new javax.swing.JTextArea();
        lblosvalor = new javax.swing.JLabel();
        txtosvalor = new javax.swing.JTextField();
        btneditos = new javax.swing.JButton();
        btndeleteos = new javax.swing.JButton();
        btnprintos = new javax.swing.JButton();
        btnaddos = new javax.swing.JButton();
        btnpesqos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("OS");
        setPreferredSize(new java.awt.Dimension(779, 663));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblidos.setText("N° OS");

        lbldataos.setText("Data");

        txtordemid.setEditable(false);

        txtosdata.setEditable(false);

        buttonGroup1.add(radioorcamento);
        radioorcamento.setText("Orçamento");
        radioorcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioorcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioOS);
        radioOS.setText("Ordem de Serviço");
        radioOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtordemid, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioorcamento))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioOS)
                    .addComponent(lbldataos)
                    .addComponent(txtosdata, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidos)
                    .addComponent(lbldataos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtordemid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtosdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioorcamento)
                    .addComponent(radioOS))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lblsituacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsituacao.setText("Situação");

        combosituacao.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        combosituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------", "Entrega feita ", "Orçamento REPROVADO", "Aguardando APROVAÇÃO", "Aguardando peças", "Abandonado pelo cliente", "Na bancada", "Retornou", " ", " " }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtosnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtosnomeKeyReleased(evt);
            }
        });

        jLabel5.setText("* Id");

        txtosid.setEnabled(false);

        tabelaoscli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Fone"
            }
        ));
        tabelaoscli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaoscliMouseClicked(evt);
            }
        });
        tabelaoscli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaoscliKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaoscli);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-search-48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtosnome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtosid, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtosnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtosid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblosequip.setText("* Equipamento");

        lblostec.setText("* Técnico");

        lblosdef.setText("* Defeito");

        txtosserv.setColumns(20);
        txtosserv.setRows(5);
        jScrollPane2.setViewportView(txtosserv);

        lblosserv.setText("* Serviço");

        txtosdef.setColumns(20);
        txtosdef.setRows(5);
        jScrollPane3.setViewportView(txtosdef);

        lblosvalor.setText("* Valor total");

        txtosvalor.setText("0");

        btneditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/file (2).png"))); // NOI18N
        btneditos.setToolTipText("Editar Ordem  de Serviço");
        btneditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditosActionPerformed(evt);
            }
        });

        btndeleteos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/file.png"))); // NOI18N
        btndeleteos.setToolTipText("Deletar Ordem de Serviço");
        btndeleteos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnprintos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/printer.png"))); // NOI18N
        btnprintos.setToolTipText("Imprimir Ordem de Serviço");
        btnprintos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnprintos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintosActionPerformed(evt);
            }
        });

        btnaddos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/add-file.png"))); // NOI18N
        btnaddos.setToolTipText("Adicionar Ordem de Serviço");
        btnaddos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaddos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddosActionPerformed(evt);
            }
        });

        btnpesqos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/file (1).png"))); // NOI18N
        btnpesqos.setPreferredSize(new java.awt.Dimension(80, 80));
        btnpesqos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesqosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblsituacao, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combosituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblosserv)
                            .addComponent(lblosdef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(txtosequip)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblostec)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtostec, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblosvalor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtosvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblosequip)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnaddos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnpesqos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btneditos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btndeleteos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnprintos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblosvalor)
                        .addComponent(txtosvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combosituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblsituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblosequip)
                            .addComponent(txtosequip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblostec)
                            .addComponent(txtostec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblosdef)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblosserv)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnprintos, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnaddos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnpesqos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btneditos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeleteos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        setBounds(0, 0, 780, 663);
    }// </editor-fold>//GEN-END:initComponents

    private void btnprintosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprintosActionPerformed
    private void tabelaoscliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaoscliKeyReleased

    }//GEN-LAST:event_tabelaoscliKeyReleased

    private void btnaddosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddosActionPerformed
        adicionarOS();
    }//GEN-LAST:event_btnaddosActionPerformed

    private void txtosnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtosnomeKeyReleased
        consultar();
    }//GEN-LAST:event_txtosnomeKeyReleased

    private void tabelaoscliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaoscliMouseClicked
        setar_campos();
    }//GEN-LAST:event_tabelaoscliMouseClicked

    private void radioorcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioorcamentoActionPerformed
        // atribuindo um texto a variaveç tip, caso selecionado
        tipo = "Orçamento";
    }//GEN-LAST:event_radioorcamentoActionPerformed

    private void radioOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOSActionPerformed
        tipo = "Ordem de Serviço";
    }//GEN-LAST:event_radioOSActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // ao abrir o forms marca um radionbuton
        radioorcamento.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btneditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditosActionPerformed

    private void btnpesqosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesqosActionPerformed
        pesquisarOS();
    }//GEN-LAST:event_btnpesqosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddos;
    private javax.swing.JButton btndeleteos;
    private javax.swing.JButton btneditos;
    private javax.swing.JButton btnpesqos;
    private javax.swing.JButton btnprintos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combosituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbldataos;
    private javax.swing.JLabel lblidos;
    private javax.swing.JLabel lblosdef;
    private javax.swing.JLabel lblosequip;
    private javax.swing.JLabel lblosserv;
    private javax.swing.JLabel lblostec;
    private javax.swing.JLabel lblosvalor;
    private javax.swing.JLabel lblsituacao;
    private javax.swing.JRadioButton radioOS;
    private javax.swing.JRadioButton radioorcamento;
    private javax.swing.JTable tabelaoscli;
    private javax.swing.JTextField txtordemid;
    private javax.swing.JTextField txtosdata;
    private javax.swing.JTextArea txtosdef;
    private javax.swing.JTextField txtosequip;
    private javax.swing.JTextField txtosid;
    private javax.swing.JTextField txtosnome;
    private javax.swing.JTextArea txtosserv;
    private javax.swing.JTextField txtostec;
    private javax.swing.JTextField txtosvalor;
    // End of variables declaration//GEN-END:variables
}
