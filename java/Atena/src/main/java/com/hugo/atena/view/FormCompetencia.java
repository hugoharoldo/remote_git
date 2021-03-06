/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.CompetenciaControle;
import com.hugo.atena.controler.Controler;
import com.hugo.atena.model.Competencia;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author hugo
 */
public class FormCompetencia extends HDialog {

    private final CompetenciaControle controleCompetencia = new CompetenciaControle();

    /**
     * Creates new form formPeople
     *
     * @param parent
     * @param modal
     */
    public FormCompetencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        painelBotoesManutencao.add(this.getPainelSalvador());

        painelListaDados.add(this.getPainelNavegacao(), java.awt.BorderLayout.PAGE_END);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        painelListaDados = new javax.swing.JPanel();
        painelCadastro = new javax.swing.JPanel();
        painelCamposPersonaizados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMes = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        painelBotoesManutencao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas");

        jTabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPaneFocusGained(evt);
            }
        });

        painelListaDados.setLayout(new java.awt.BorderLayout());
        jTabbedPane.addTab("Lista de competencias", painelListaDados);

        painelCadastro.setLayout(new java.awt.BorderLayout());

        painelCamposPersonaizados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                painelCamposPersonaizadosFocusGained(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mês:");

        jTextFieldAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ano:");

        javax.swing.GroupLayout painelCamposPersonaizadosLayout = new javax.swing.GroupLayout(painelCamposPersonaizados);
        painelCamposPersonaizados.setLayout(painelCamposPersonaizadosLayout);
        painelCamposPersonaizadosLayout.setHorizontalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCamposPersonaizadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jTextFieldMes))
                .addContainerGap(489, Short.MAX_VALUE))
        );

        painelCamposPersonaizadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        painelCamposPersonaizadosLayout.setVerticalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAno)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMes))
                .addGap(351, 351, 351))
        );

        painelCadastro.add(painelCamposPersonaizados, java.awt.BorderLayout.NORTH);

        painelBotoesManutencao.setLayout(new java.awt.GridLayout(1, 0));
        painelCadastro.add(painelBotoesManutencao, java.awt.BorderLayout.SOUTH);

        jTabbedPane.addTab("Competencia", painelCadastro);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(724, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnoActionPerformed


    private void jTabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPaneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPaneFocusGained

    private void painelCamposPersonaizadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_painelCamposPersonaizadosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_painelCamposPersonaizadosFocusGained

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
            java.util.logging.Logger.getLogger(FormCompetencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCompetencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCompetencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCompetencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCompetencia dialog = new FormCompetencia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JPanel painelBotoesManutencao;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelCamposPersonaizados;
    private javax.swing.JPanel painelListaDados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarTextField(boolean habilitar) {

        jTextFieldAno.setEnabled(habilitar);
        jTextFieldMes.setEnabled(habilitar);

    }

    @Override
    public void limparTextField() {

        jTextFieldAno.setText("");
        jTextFieldMes.setText("");
    }

    @Override
    public void preencherTextField(Object object) {

        Competencia p = (Competencia) object;

        jTextFieldAno.setText(String.valueOf(p.getAno()));
        jTextFieldMes.setText(String.valueOf(p.getMes()));

    }

    @Override
    public Object getValoresInformadosNaTela() {

        Competencia competencia = (Competencia) controleCompetencia.getEntity();

        competencia.setAno(Integer.parseInt(jTextFieldAno.getText()));
        competencia.setMes(Integer.parseInt(jTextFieldMes.getText()));

        return competencia;

    }

    @Override
    public Controler getControler() {
        return this.controleCompetencia;
    }

    @Override
    public void atualizaValoresDadosTela() {

        preencherTextField(controleCompetencia.getEntity());
    
    }
    
        
    @Override
    public JPanel getPainelListagemDados() {
        
        return painelListaDados;
        
    }
    
    @Override
    public JTabbedPane getPainelPrincipal() {
        
        return jTabbedPane;
        
    }
}
