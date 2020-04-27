/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import javax.swing.JOptionPane;

/**
 *
 * @author hugo
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public FormPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        jMenuRegister = new javax.swing.JMenu();
        jMenuIPeople = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atena -  Sistema de Cadastro");

        jMenuRegister.setText("Cadastros");

        jMenuIPeople.setText("Pessoas");
        jMenuIPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIPeopleActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuIPeople);

        jMenuItem3.setText("Apartamentos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem3);

        jMenuItem5.setText("Tipo Apartamento");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem5);

        jMenuItem2.setText("Competencia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem2);

        jMenuItem4.setText("Medição de Gás");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem4);

        jMenuItem6.setText("Despesas Compartilhadas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem6);

        jMenuItem1.setText("Usuários do Sistemas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuRegister.add(jMenuItem1);

        menuBar.add(jMenuRegister);

        jMenuHelp.setText("Ajuda");
        jMenuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelpActionPerformed(evt);
            }
        });

        jMenuAbout.setText("Sobre");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuAbout);

        menuBar.add(jMenuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(500, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuIPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIPeopleActionPerformed
        // TODO add your handling code here:
        FormPessoa frmPeople = new FormPessoa(this, true);
        frmPeople.setTitle("Manutenção de Pessoas");
        frmPeople.setLocationRelativeTo(null);
        frmPeople.setResizable(false);
        frmPeople.setVisible(true);
    }//GEN-LAST:event_jMenuIPeopleActionPerformed

    private void jMenuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelpActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuHelpActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Atenas");
    }//GEN-LAST:event_jMenuAboutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        FormUsuarioSistema frmPeople = new FormUsuarioSistema(this, true);
        frmPeople.setTitle("Manutenção de Usuários do Sistema");
        frmPeople.setLocationRelativeTo(null);
        frmPeople.setResizable(false);
        frmPeople.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        FormCompetencia frmPeople = new FormCompetencia(this, true);
        frmPeople.setTitle("Manutenção de Competencias");
        frmPeople.setLocationRelativeTo(null);
        frmPeople.setResizable(false);
        frmPeople.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        FormApartamento frm = new FormApartamento(this, true);
        frm.setTitle("Manutenção de Apartamentos");
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        FormMedicaoGas frm = new FormMedicaoGas(this, true);
        frm.setTitle("Manutenção de Apartamentos");
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        FormTipoApartamento frm = new FormTipoApartamento(this, true);
        frm.setTitle("Manutenção de Tipos de Apartamento");
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        FormDespesaCompartilhada frm = new FormDespesaCompartilhada(this, true);
        frm.setTitle("Manutenção de despesas");
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuIPeople;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jMenuRegister;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
