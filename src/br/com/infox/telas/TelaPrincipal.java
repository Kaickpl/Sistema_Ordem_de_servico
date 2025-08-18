/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.infox.telas;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author kaick
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setUndecorated(false);
        setLocationRelativeTo(null); // centraliza a janela
        setVisible(true);
        getContentPane().setBackground(new Color(173, 190, 209));
    }
    
    private void logout() {
    // Pergunta se o usuário quer realmente sair
    int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION) {
        try {
            // Fecha a tela principal
            this.dispose();

            // Abre novamente a tela de login
            Tela_login login = new Tela_login();
            login.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        lbldata = new javax.swing.JLabel();
        btnperfil = new javax.swing.JButton();
        lblusuario = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        mencad = new javax.swing.JMenu();
        mencadcli = new javax.swing.JMenuItem();
        mencados = new javax.swing.JMenuItem();
        mencadusu = new javax.swing.JMenuItem();
        menrel = new javax.swing.JMenu();
        menrelser = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menaju = new javax.swing.JMenu();
        menajusob = new javax.swing.JMenuItem();
        menopc = new javax.swing.JMenu();
        menopcsai = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X - Sistema para para controle de OS");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(102, 125, 181));
        setForeground(new java.awt.Color(102, 125, 181));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Desktop.setPreferredSize(new java.awt.Dimension(779, 663));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );

        lbldata.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldata.setText("Data:");

        btnperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-user-50.png"))); // NOI18N
        btnperfil.setText("Usuário");
        btnperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperfilActionPerformed(evt);
            }
        });

        lblusuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblusuario.setText("Perfil");
        lblusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblusuarioMouseEntered(evt);
            }
        });

        Menu.setEnabled(false);

        mencad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-add-user-male-40.png"))); // NOI18N
        mencad.setText("Cadastro");

        mencadcli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mencadcli.setText("Cliente");
        mencadcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mencadcliActionPerformed(evt);
            }
        });
        mencad.add(mencadcli);

        mencados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mencados.setText("OS");
        mencados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mencadosActionPerformed(evt);
            }
        });
        mencad.add(mencados);

        mencadusu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mencadusu.setText("Usuários");
        mencadusu.setEnabled(false);
        mencadusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mencadusuActionPerformed(evt);
            }
        });
        mencad.add(mencadusu);

        Menu.add(mencad);

        menrel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-business-report-48.png"))); // NOI18N
        menrel.setText("Relatório");
        menrel.setEnabled(false);

        menrelser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menrelser.setText("Serviços");
        menrelser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menrelserActionPerformed(evt);
            }
        });
        menrel.add(menrelser);

        Menu.add(menrel);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-pay-64.png"))); // NOI18N
        jMenu1.setText("Pagamento");

        jMenuItem1.setText("Pagamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        Menu.add(jMenu1);

        menaju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-help-48.png"))); // NOI18N
        menaju.setText("Ajuda");

        menajusob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menajusob.setText("Sobre");
        menajusob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menajusobActionPerformed(evt);
            }
        });
        menaju.add(menajusob);

        Menu.add(menaju);

        menopc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/icons8-logout-40.png"))); // NOI18N
        menopc.setText("Opções");

        menopcsai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menopcsai.setText("Sair");
        menopcsai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menopcsaiActionPerformed(evt);
            }
        });
        menopc.add(menopcsai);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menopc.add(jMenuItem2);

        Menu.add(menopc);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldata, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusuario))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusuario))
                    .addComponent(btnperfil))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1020, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mencadcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencadcliActionPerformed
        TelaCliente cliente = new TelaCliente();
        cliente.setVisible(true);
        Desktop.add(cliente);

    }//GEN-LAST:event_mencadcliActionPerformed

    private void mencadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencadosActionPerformed
       TelaOs os = new TelaOs();
       os.setVisible(true);
       Desktop.add(os);
    }//GEN-LAST:event_mencadosActionPerformed

    private void menrelserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menrelserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menrelserActionPerformed

    private void menopcsaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menopcsaiActionPerformed
        // fazer sair quando apertartr em sair 
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "ATENÇÃO",
                JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_menopcsaiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // as linhas abaixo substituem as labels laldata ao iniciar o forms
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.DATE_FIELD);
        lbldata.setText(formatador.format(data));

    }//GEN-LAST:event_formWindowActivated


    private void menajusobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menajusobActionPerformed
        // chamando a tela sobre 
        TelaSobre2 sobre = new TelaSobre2();
        Desktop.add(sobre);   // Adiciona ao JDesktopPane!
        sobre.setVisible(true);
        try {
            sobre.setSelected(true);  // Seleciona a janela interna (opcional)
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menajusobActionPerformed

    private void lblusuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblusuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusuarioMouseEntered

    private void mencadusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencadusuActionPerformed
        // as linhas abaixo vão abrir o forms TelaUsuario, dentro do desktoPane
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
        Desktop.add(usuario);

    }//GEN-LAST:event_mencadusuActionPerformed

    private void btnperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnperfilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        logout();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    public static javax.swing.JButton btnperfil;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lbldata;
    public static javax.swing.JLabel lblusuario;
    private javax.swing.JMenu menaju;
    private javax.swing.JMenuItem menajusob;
    private javax.swing.JMenu mencad;
    private javax.swing.JMenuItem mencadcli;
    private javax.swing.JMenuItem mencados;
    public static javax.swing.JMenuItem mencadusu;
    private javax.swing.JMenu menopc;
    private javax.swing.JMenuItem menopcsai;
    public static javax.swing.JMenu menrel;
    private javax.swing.JMenuItem menrelser;
    // End of variables declaration//GEN-END:variables
}
