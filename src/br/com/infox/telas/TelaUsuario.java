package br.com.infox.telas;

/*
 * @author kaick
 */
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null; // modulo de conexao
    PreparedStatement pst = null; //  preprara a conexao
    ResultSet rs = null; //exibe resultado da conexa

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void limparCamposPesquisa() {
        txtusuid.setText(null);
        txtusunome.setText(null);
        txtusufone.setText(null);
        txtusulogin.setText(null);
        txtususenha.setText(null);
        comboperfil.setSelectedItem(null);
    }

    private void corNormal() {
        Color normal = Color.WHITE;
        txtusuid.setBackground(normal);
        txtusunome.setBackground(normal);
        txtusulogin.setBackground(normal);
        txtususenha.setBackground(normal);
        comboperfil.setBackground(normal);
    }

    private void Consultar() {
        String sql = "select * from tbusuario where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            int idUsuario = Integer.parseInt(txtusuid.getText());
            pst.setInt(1, idUsuario); // Usa setInt() para valores numéricos
            rs = pst.executeQuery();
            if (rs.next()) {
                txtusunome.setText(rs.getString(2));
                txtusufone.setText(rs.getString(3));
                txtusulogin.setText(rs.getString(4));
                txtususenha.setText(rs.getString(5));
                comboperfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado ou "
                        + "não cadastrado");
                // linhas abixas limpam os campos
                limparCamposPesquisa();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // adciona usuario
    private void Adicionar() {
        // 1. Validação dos Campos (agora no início do método)
        // Verifique se os campos obrigatórios estão vazios.
        if (txtusuid.getText().isEmpty()
                || txtusunome.getText().isEmpty()
                || txtusulogin.getText().isEmpty()
                || txtususenha.getText().isEmpty()
                || comboperfil.getSelectedItem() == null) {

            // Use cores para destacar os campos vazios
            Color alerta = new Color(255, 204, 204);
            if (txtusuid.getText().isEmpty()) {
                txtusuid.setBackground(alerta);
            }
            if (txtusunome.getText().isEmpty()) {
                txtusunome.setBackground(alerta);
            }
            if (txtusulogin.getText().isEmpty()) {
                txtusulogin.setBackground(alerta);
            }
            if (txtususenha.getText().isEmpty()) {
                txtususenha.setBackground(alerta);
            }
            if (comboperfil.getSelectedItem() == null || comboperfil.getSelectedItem().toString().isEmpty()) {
                comboperfil.setBackground(alerta);
            }

            JOptionPane.showMessageDialog(null, "Preencha todos os Campos obrigatórios!");
            return; // Sai do método se houver campos vazios
        }

        // 2. Lógica para conectar e inserir no banco de dados
        String sql = "insert into tbusuario (iduser,usuario,fone,login,senha,perfil) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);

            // CONVERSÃO E INJEÇÃO DO VALOR NA CONSULTA
            // Você deve converter o texto do ID para um número antes de enviar ao banco.
            // Isso evita o erro de "character varying vs bigint/smallint".
            int idUsuario = Integer.parseInt(txtusuid.getText());
            pst.setInt(1, idUsuario);
            pst.setString(2, txtusunome.getText());
            pst.setString(3, txtusufone.getText());
            pst.setString(4, txtusulogin.getText());
            pst.setString(5, txtususenha.getText());
            pst.setString(6, comboperfil.getSelectedItem().toString());

            // Limpa a cor de fundo dos campos, pois a validação passou
            corNormal();

            // 3. Execução da consulta e feedback ao usuário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário " + txtusunome.getText() + " cadastrado(a) com Sucesso.");
                limparCamposPesquisa();
            }

        } catch (NumberFormatException e) {
            // Captura o erro se o usuário digitar letras no campo ID
            JOptionPane.showMessageDialog(null, "O ID do usuário deve ser um número válido.");
            txtusuid.setBackground(new Color(255, 204, 204));
        } catch (Exception e) {
            // Captura qualquer outro erro de banco de dados
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void atualizar() { // atualizar um perfil ja existente 
        String sql = "update tbusuario set usuario=?, fone=?,login=?, senha=?,perfil=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            int idUsuario = Integer.parseInt(txtusuid.getText());
            pst.setString(1, txtusunome.getText());
            pst.setString(2, txtusufone.getText());
            pst.setString(3, txtusulogin.getText());
            pst.setString(4, txtususenha.getText());
            pst.setString(5, comboperfil.getSelectedItem().toString());
            pst.setInt(6, idUsuario);
            // repete todo processo do metodo adicionar, no que diz respeito
            // a parte de verificação se ta vazio ou não.
            boolean camposVazios = false;

            if (txtusuid.getText().isEmpty()
                    || txtusunome.getText().isEmpty()
                    || txtusulogin.getText().isEmpty()
                    || txtususenha.getText().isEmpty()
                    || comboperfil.getSelectedItem().toString().isEmpty()) {

                camposVazios = true;

                // cor de fundo levemente vermelha para indicar erro
                Color alerta = new Color(255, 204, 204); // rosa claro

                if (txtusuid.getText().isEmpty()) {
                    txtusuid.setBackground(alerta);
                }
                if (txtusunome.getText().isEmpty()) {
                    txtusunome.setBackground(alerta);
                }
                if (txtusulogin.getText().isEmpty()) {
                    txtusulogin.setBackground(alerta);
                }
                if (txtususenha.getText().isEmpty()) {
                    txtususenha.setBackground(alerta);
                }
                if (comboperfil.getSelectedItem().toString().isEmpty()) {
                    comboperfil.setBackground(alerta);
                }

                JOptionPane.showMessageDialog(null, "Preencha todos os Campos obrigatórios!");
            } else {
                // linha abaixa atualiza a tabela usuario coloque uma variavel apenas 
                // para conseguier mostra a mensagem que um novo usuario foi cadastrado
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário: " + txtusunome.getText() + " atualizados com Sucesso.");
                    limparCamposPesquisa();
                    corNormal();

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem "
                + "certeza que deseja remover o acesso de "
                + txtusunome.getText() + " do sistema?");
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete FROM tbusuario WHERE iduser = ?";
            try {
                pst = conexao.prepareStatement(sql);
                int idUsuario = Integer.parseInt(txtusuid.getText());
                pst.setInt(1,idUsuario);
                int removido = pst.executeUpdate();
                if (removido > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário "
                            + txtusunome.getText()
                            + " removido do sistema com sucesso.");
                    limparCamposPesquisa();
                    txtusuid.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não removido.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblusuid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusuid = new javax.swing.JTextField();
        txtusunome = new javax.swing.JTextField();
        txtusulogin = new javax.swing.JTextField();
        txtususenha = new javax.swing.JPasswordField();
        comboperfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtusufone = new javax.swing.JTextField();
        btnusuadd = new javax.swing.JButton();
        btnusuedt = new javax.swing.JButton();
        btnusupes = new javax.swing.JButton();
        btnusudel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuário");
        setToolTipText("");
        setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 470));

        lblusuid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblusuid.setText("*Id");
        lblusuid.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("*Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("*Login");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("*Senha");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("*Perfil");

        txtusuid.setToolTipText("Código único de Usuário");
        txtusuid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuidActionPerformed(evt);
            }
        });

        txtusulogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuloginActionPerformed(evt);
            }
        });

        comboperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        comboperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboperfilActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("* Fone");

        txtusufone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusufoneActionPerformed(evt);
            }
        });

        btnusuadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49576_new_add_plus_user_icon.png"))); // NOI18N
        btnusuadd.setToolTipText("Adicionar");
        btnusuadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuadd.setPreferredSize(new java.awt.Dimension(80, 80));
        btnusuadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuaddActionPerformed(evt);
            }
        });

        btnusuedt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49585_human_male_user_icon.png"))); // NOI18N
        btnusuedt.setToolTipText("Atualizar");
        btnusuedt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuedt.setPreferredSize(new java.awt.Dimension(80, 80));
        btnusuedt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuedtActionPerformed(evt);
            }
        });

        btnusupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49620_male_search_user_icon.png"))); // NOI18N
        btnusupes.setToolTipText("Pesquisar");
        btnusupes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusupes.setPreferredSize(new java.awt.Dimension(80, 80));
        btnusupes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusupesActionPerformed(evt);
            }
        });

        btnusudel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/49612_delete_male_icon.png"))); // NOI18N
        btnusudel.setToolTipText("Deletar");
        btnusudel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusudel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnusudel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusudelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("* Campos Obrigátorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblusuid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtusuid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtusunome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtusufone, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(txtususenha))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(txtusulogin, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnusuedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(comboperfil, 0, 274, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnusuadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnusupes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnusudel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuid)
                    .addComponent(txtusuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusunome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtusulogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtusufone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtususenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnusuadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnusudel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnusupes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnusuedt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );

        setBounds(0, 0, 779, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuidActionPerformed

    private void txtusuloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuloginActionPerformed

    private void comboperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboperfilActionPerformed

    private void txtusufoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusufoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusufoneActionPerformed

    private void btnusuaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuaddActionPerformed
        Adicionar();
    }//GEN-LAST:event_btnusuaddActionPerformed

    private void btnusupesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusupesActionPerformed
        Consultar();
    }//GEN-LAST:event_btnusupesActionPerformed

    private void btnusuedtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuedtActionPerformed
        atualizar();
    }//GEN-LAST:event_btnusuedtActionPerformed

    private void btnusudelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusudelActionPerformed
        excluir();
    }//GEN-LAST:event_btnusudelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnusuadd;
    private javax.swing.JButton btnusudel;
    private javax.swing.JButton btnusuedt;
    private javax.swing.JButton btnusupes;
    private javax.swing.JComboBox<String> comboperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblusuid;
    private javax.swing.JTextField txtusufone;
    private javax.swing.JTextField txtusuid;
    private javax.swing.JTextField txtusulogin;
    private javax.swing.JTextField txtusunome;
    private javax.swing.JPasswordField txtususenha;
    // End of variables declaration//GEN-END:variables
}
