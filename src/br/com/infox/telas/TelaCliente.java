/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void limparCamposPesquisa() {

        txtnomecli.setText(null);
        txtclifone.setText(null);;
        txtcliemail.setText(null);
        txtclirua.setText(null);
        txtclinu.setText(null);
        txtcliba.setText(null);
        txtclicidade.setText(null);
        txtcliCEP.setText(null);
        ((DefaultTableModel) tblcli.getModel()).setRowCount(0);
    }

    private void corNormal() {
        Color normal = Color.WHITE;
        txtnomecli.setBackground(normal);
        txtclifone.setBackground(normal);
        txtcliemail.setBackground(normal);
        txtclirua.setBackground(normal);
        txtclinu.setBackground(normal);
        comboclicom.setBackground(normal);
        txtcliba.setBackground(normal);
        txtclicidade.setBackground(normal);
        combocliestado.setBackground(normal);
        txtcliCEP.setBackground(normal);
    }

    private void pesquisarCliente() {
        String sql = "SELECT * from tbcliente where nomecli like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            // passando o conteudo da caixa de pesquisa para o ?
            // atenção ao % continuação da String sql
            pst.setString(1, txtcliid.getText() + "%");
            rs = pst.executeQuery();
            //  linha abaixo uso a bibliteca rs2xml.jar para prenchera tabela
            tblcli.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblcli = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcliid = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btncliadd = new javax.swing.JButton();
        btncliedt = new javax.swing.JButton();
        btnclidel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnomecli = new javax.swing.JTextField();
        txtclifone = new javax.swing.JTextField();
        txtclicidade = new javax.swing.JTextField();
        txtclirua = new javax.swing.JTextField();
        combocliestado = new javax.swing.JComboBox<>();
        txtclinu = new javax.swing.JTextField();
        txtcliba = new javax.swing.JTextField();
        comboclicom = new javax.swing.JComboBox<>();
        txtcliemail = new javax.swing.JTextField();
        txtcliCEP = new javax.swing.JTextField();
        lblidcli = new javax.swing.JLabel();
        txtidcli = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Cliente");
        setToolTipText("");
        setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(779, 663));

        tblcli = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;

            }
        };
        tblcli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Email", "Rua", "Número", "Complemento", "Bairo", "Cidade", "Estado", "CEP"
            }
        ));
        tblcli.setFocusable(false);
        tblcli.getTableHeader().setReorderingAllowed(false);
        tblcli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcli);

        txtcliid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcliidKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtcliid);

        jLabel1.setText("* Nome");

        jLabel2.setText("* Telefone");

        btncliadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49576_new_add_plus_user_icon.png"))); // NOI18N
        btncliadd.setToolTipText("Adicionar cliente");
        btncliadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncliadd.setPreferredSize(new java.awt.Dimension(80, 80));
        btncliadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncliaddActionPerformed(evt);
            }
        });

        btncliedt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49585_human_male_user_icon.png"))); // NOI18N
        btncliedt.setToolTipText("Editar cliente");
        btncliedt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncliedt.setPreferredSize(new java.awt.Dimension(80, 80));
        btncliedt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncliedtActionPerformed(evt);
            }
        });

        btnclidel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49612_delete_male_icon.png"))); // NOI18N
        btnclidel.setToolTipText("Deletar Cliente");
        btnclidel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclidel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnclidel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclidelActionPerformed(evt);
            }
        });

        jLabel3.setText("* Número");

        jLabel4.setText("* Complemento");

        jLabel5.setText("* Email");

        jLabel6.setText("* Bairo");

        jLabel7.setText("* Rua");

        jLabel8.setText("* Cidade");

        jLabel9.setText("* Estado");

        jLabel10.setText("* CEP");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-look-for-48.png"))); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(50, 50));

        txtnomecli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomecliActionPerformed(evt);
            }
        });

        txtclifone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclifoneActionPerformed(evt);
            }
        });

        txtclicidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclicidadeActionPerformed(evt);
            }
        });

        txtclirua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliruaActionPerformed(evt);
            }
        });

        combocliestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC  ", "AL  ", "AM  ", "AP  ", "BA  ", "CE  ", "DF  ", "ES  ", "GO  ", "MA  ", "MG  ", "MS  ", "MT  ", "PA  ", "PB  ", "PE  ", "PI  ", "PR  ", "RJ  ", "RN  ", "RO  ", "RR  ", "RS  ", "SC  ", "SE  ", "SP  ", "TO  ", " " }));

        comboclicom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa", "Apartamento", "Condomínio", "Trabalho" }));
        comboclicom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboclicomActionPerformed(evt);
            }
        });

        txtcliCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliCEPActionPerformed(evt);
            }
        });

        lblidcli.setText("ID Cliente");

        txtidcli.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblidcli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidcli, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnomecli))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(347, 347, 347)
                                        .addComponent(btnclidel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btncliadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(btncliedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcliemail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtclifone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtclicidade)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtclinu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcliba, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtclirua, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcliCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combocliestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboclicom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnomecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblidcli)
                    .addComponent(txtidcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtclicidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtclirua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtcliCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(combocliestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclinu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcliba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboclicom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(txtclifone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncliedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclidel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncliadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        setBounds(0, 0, 779, 655);
    }// </editor-fold>//GEN-END:initComponents
    // metodo add clientes

    private void adicionar() {
        String sql = "insert into tbcliente (nomecli,fonecli,emailcli,rua,numero,complemento, bairo,cidade,estado,cep)"
                + " values (?,?,?,?,?,?,?,?,?,?) ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtnomecli.getText());
            pst.setString(2, txtclifone.getText());
            pst.setString(3, txtcliemail.getText());
            pst.setString(4, txtclirua.getText());
            pst.setString(5, txtclinu.getText());
            pst.setString(6, comboclicom.getSelectedItem().toString());
            pst.setString(7, txtcliba.getText());
            pst.setString(8, txtclicidade.getText());
            pst.setString(9, combocliestado.getSelectedItem().toString());
            pst.setString(10, txtcliCEP.getText());

            // a parti dessa linha abaxo ele verifica se os campos obrigatórios
            // foram preenchidos, caso não tenham sido apenas destacam em red
            boolean camposVazios = false;
            // if  abaixo verifica cada campo obrigatório
            if (txtnomecli.getText().isEmpty()
                    || txtclifone.getText().isEmpty()
                    || txtcliemail.getText().isEmpty()
                    || txtclirua.getText().isEmpty()
                    || txtclinu.getText().isEmpty()
                    || comboclicom.getSelectedItem().toString().isEmpty()
                    || txtcliba.getText().isEmpty()
                    || txtclicidade.getText().isEmpty()
                    || combocliestado.getSelectedItem().toString().isEmpty()
                    || txtcliCEP.getText().isEmpty()) {

                camposVazios = true;

                // cor de fundo levemente vermelha para indicar erro
                Color alerta = new Color(255, 204, 204);
                // CADA LINHA ABAIXO  destaca em vermelho caso esteja vazio
                if (txtnomecli.getText().isEmpty()) {
                    txtnomecli.setBackground(alerta);
                }
                if (txtclifone.getText().isEmpty()) {
                    txtclifone.setBackground(alerta);
                }
                if (txtcliemail.getText().isEmpty()) {
                    txtcliemail.setBackground(alerta);
                }
                if (txtclirua.getText().isEmpty()) {
                    txtclirua.setBackground(alerta);
                }
                if (txtclinu.getText().isEmpty()) {
                    txtclinu.setBackground(alerta);
                }
                if (comboclicom.getSelectedItem().toString().isEmpty()) {
                    comboclicom.setBackground(alerta);
                }
                if (txtcliba.getText().isEmpty()) {
                    txtcliba.setBackground(alerta);
                }
                if (txtclicidade.getText().isEmpty()) {
                    txtclicidade.setBackground(alerta);
                }
                if (combocliestado.getSelectedItem().toString().isEmpty()) {
                    combocliestado.setBackground(alerta);
                }
                if (txtcliCEP.getText().isEmpty()) {
                    txtcliCEP.setBackground(alerta);
                }
                // solta mensagem que tem que preeencher 
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos obrigatórios!");
                return;
            } else {// depos que todos estão preenchidos volta a cor nromal
                // linha abaixa atualiza a tabela usuario coloque uma variavel apenas 
                // para conseguier mostra a mensagem que um novo usuario foi cadastrado
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente "
                            + txtnomecli.getText()
                            + " cadastrado(a) com Sucesso.");
                    limparCamposPesquisa();
                    corNormal();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void setar_campos() {
        int setar = tblcli.getSelectedRow();
        txtidcli.setText(tblcli.getModel().getValueAt(setar, 0).toString());
        txtnomecli.setText(tblcli.getModel().getValueAt(setar, 1).toString());
        txtclifone.setText(tblcli.getModel().getValueAt(setar, 2).toString());
        txtcliemail.setText(tblcli.getModel().getValueAt(setar, 3).toString());
        txtclirua.setText(tblcli.getModel().getValueAt(setar, 4).toString());
        txtclinu.setText(tblcli.getModel().getValueAt(setar, 5).toString());
        comboclicom.setSelectedItem(tblcli.getModel().getValueAt(setar, 6).toString());
        txtcliba.setText(tblcli.getModel().getValueAt(setar, 7).toString());
        txtclicidade.setText(tblcli.getModel().getValueAt(setar, 8).toString());
        combocliestado.setSelectedItem(tblcli.getModel().getValueAt(setar, 9).toString());
        txtcliCEP.setText(tblcli.getModel().getValueAt(setar, 10).toString());
        btncliadd.setEnabled(false);
        
    }

    private void atualizar() {
        String sql = "update tbcliente set nomecli=?, fonecli=?, emailcli=?, rua=?, numero=?, complemento=?, bairo=?, cidade=?, estado=?, cep=?"
                + " where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtnomecli.getText());
            pst.setString(2, txtclifone.getText());
            pst.setString(3, txtcliemail.getText());
            pst.setString(4, txtclirua.getText());
            pst.setString(5, txtclinu.getText());
            pst.setString(6, comboclicom.getSelectedItem().toString());
            pst.setString(7, txtcliba.getText());
            pst.setString(8, txtclicidade.getText());
            pst.setString(9, combocliestado.getSelectedItem().toString());
            pst.setString(10, txtcliCEP.getText());
            int idCliente = Integer.parseInt(txtidcli.getText());
            pst.setInt(11, idCliente);
            // repete todo processo do metodo adicionar, no que diz respeito
            // a parte de verificação se ta vazio ou não.
            boolean camposVazios = false;

            if (txtnomecli.getText().isEmpty()
                    || txtclifone.getText().isEmpty()
                    || txtcliemail.getText().isEmpty()
                    || txtclirua.getText().isEmpty()
                    || txtclinu.getText().isEmpty()
                    || comboclicom.getSelectedItem().toString().isEmpty()
                    || txtcliba.getText().isEmpty()
                    || txtclicidade.getText().isEmpty()
                    || combocliestado.getSelectedItem().toString().isEmpty()
                    || txtcliCEP.getText().isEmpty()) {

                camposVazios = true;

                // cor de fundo levemente vermelha para indicar erro
                Color alerta = new Color(255, 204, 204);
                // CADA LINHA ABAIXO  destaca em vermelho caso esteja vazio
                if (txtnomecli.getText().isEmpty()) {
                    txtnomecli.setBackground(alerta);
                }
                if (txtclifone.getText().isEmpty()) {
                    txtclifone.setBackground(alerta);
                }
                if (txtcliemail.getText().isEmpty()) {
                    txtcliemail.setBackground(alerta);
                }
                if (txtclirua.getText().isEmpty()) {
                    txtclirua.setBackground(alerta);
                }
                if (txtclinu.getText().isEmpty()) {
                    txtclinu.setBackground(alerta);
                }
                if (comboclicom.getSelectedItem().toString().isEmpty()) {
                    comboclicom.setBackground(alerta);
                }
                if (txtcliba.getText().isEmpty()) {
                    txtcliba.setBackground(alerta);
                }
                if (txtclicidade.getText().isEmpty()) {
                    txtclicidade.setBackground(alerta);
                }
                if (combocliestado.getSelectedItem().toString().isEmpty()) {
                    combocliestado.setBackground(alerta);
                }
                if (txtcliCEP.getText().isEmpty()) {
                    txtcliCEP.setBackground(alerta);
                }

                JOptionPane.showMessageDialog(null, "Preencha todos os Campos obrigatórios!");

            } else {
                // linha abaixa atualiza a tabela usuario coloque uma variavel apenas 
                // para conseguier mostra a mensagem que um novo usuario foi cadastrado
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente: " + txtnomecli.getText() + " atualizados com Sucesso.");
                    limparCamposPesquisa();
                    corNormal();
                    btncliadd.setEnabled(true);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    private void deletar(){
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem "
                + "certeza que deseja remover o acesso de "
                + txtnomecli.getText() + " do sistema?");
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete FROM tbcliente WHERE idcli = ?";
            try {
                pst = conexao.prepareStatement(sql);
                int idCliente = Integer.parseInt(txtidcli.getText());
                pst.setInt(1, idCliente);
                int removido = pst.executeUpdate();
                if(removido > 0){
                    JOptionPane.showMessageDialog(null,"Cliente "+ 
                            txtnomecli.getText()+ 
                            " removido do sistema com sucesso.");
                            limparCamposPesquisa();
                            txtidcli.setText(null);
                }else{
                    JOptionPane.showMessageDialog(null,"Cliente não removido.");
                }
                
                        
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    
    

    private void txtnomecliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomecliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomecliActionPerformed

    private void txtclifoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclifoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclifoneActionPerformed

    private void txtclicidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclicidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclicidadeActionPerformed

    private void txtcliruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliruaActionPerformed

    private void btnclidelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclidelActionPerformed
        // chama metodo deletra cliente
        deletar();
    }//GEN-LAST:event_btnclidelActionPerformed

    private void btncliaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncliaddActionPerformed
        adicionar();
    }//GEN-LAST:event_btncliaddActionPerformed

    private void txtcliCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliCEPActionPerformed

    private void comboclicomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboclicomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboclicomActionPerformed

    private void txtcliidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcliidKeyReleased
        // evento abaixo é do tipo = enquanto estiver digitando
        pesquisarCliente();
    }//GEN-LAST:event_txtcliidKeyReleased

    private void tblcliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcliMouseClicked
        // evento que sera usado para tranferir da tabela para os camopos// metodo setar
        setar_campos();
    }//GEN-LAST:event_tblcliMouseClicked

    private void btncliedtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncliedtActionPerformed
        atualizar();
    }//GEN-LAST:event_btncliedtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncliadd;
    private javax.swing.JButton btnclidel;
    private javax.swing.JButton btncliedt;
    private javax.swing.JComboBox<String> comboclicom;
    private javax.swing.JComboBox<String> combocliestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblidcli;
    private javax.swing.JTable tblcli;
    private javax.swing.JTextField txtcliCEP;
    private javax.swing.JTextField txtcliba;
    private javax.swing.JTextField txtclicidade;
    private javax.swing.JTextField txtcliemail;
    private javax.swing.JTextField txtclifone;
    private javax.swing.JTextPane txtcliid;
    private javax.swing.JTextField txtclinu;
    private javax.swing.JTextField txtclirua;
    private javax.swing.JTextField txtidcli;
    private javax.swing.JTextField txtnomecli;
    // End of variables declaration//GEN-END:variables
}
