/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.LancamentoCondominioControle;
import com.hugo.atena.model.Competencia;
import com.hugo.atena.model.LancamentoCondominio;
import com.hugo.atena.view.model.ComboBoxModelCompetencia;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author hugo
 */
public class FormLancamentoCondominio extends HDialog {
    
    private final LancamentoCondominioControle controle = new LancamentoCondominioControle();

    /**
     * Creates new form formPeople
     *
     * @param parent
     * @param modal
     */
    public FormLancamentoCondominio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        painelBotoesManutencao.add(this.getPainelSalvador());
        
        painelListaDados.add(this.getPainelNavegacao(), java.awt.BorderLayout.PAGE_END);
        
        jComboBoxCompetencia.setModel(ComboBoxModelCompetencia.getModel());
        
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
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCompetencia = new javax.swing.JComboBox<>();
        painelBotoesManutencao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas");

        jTabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPaneFocusGained(evt);
            }
        });

        painelListaDados.setLayout(new java.awt.BorderLayout());
        jTabbedPane.addTab("Lista de lançamentos de condomínio", painelListaDados);

        painelCadastro.setLayout(new java.awt.BorderLayout());

        painelCamposPersonaizados.setPreferredSize(new java.awt.Dimension(694, 350));
        painelCamposPersonaizados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                painelCamposPersonaizadosFocusGained(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Competencia:");

        jComboBoxCompetencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCompetenciaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelCamposPersonaizadosLayout = new javax.swing.GroupLayout(painelCamposPersonaizados);
        painelCamposPersonaizados.setLayout(painelCamposPersonaizadosLayout);
        painelCamposPersonaizadosLayout.setHorizontalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 464, Short.MAX_VALUE))
        );
        painelCamposPersonaizadosLayout.setVerticalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(309, Short.MAX_VALUE))
        );

        painelCadastro.add(painelCamposPersonaizados, java.awt.BorderLayout.NORTH);

        painelBotoesManutencao.setLayout(new java.awt.GridLayout(1, 0));
        painelCadastro.add(painelBotoesManutencao, java.awt.BorderLayout.SOUTH);

        jTabbedPane.addTab("Lançamento de condomínio", painelCadastro);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(724, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPaneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPaneFocusGained

    private void painelCamposPersonaizadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_painelCamposPersonaizadosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_painelCamposPersonaizadosFocusGained
    

    

    private void jComboBoxCompetenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCompetenciaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxCompetenciaItemStateChanged

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
            java.util.logging.Logger.getLogger(FormLancamentoCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLancamentoCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLancamentoCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLancamentoCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                FormLancamentoCondominio dialog = new FormLancamentoCondominio(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBoxCompetencia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel painelBotoesManutencao;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelCamposPersonaizados;
    private javax.swing.JPanel painelListaDados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarTextField(boolean habilitar) {
        
        
        jComboBoxCompetencia.setEnabled(habilitar);
        
        
    }
    
    @Override
    public void limparTextField() {
        
        
        jComboBoxCompetencia.getModel().setSelectedItem(new Competencia());
        
        
        
    }
    
    @Override
    public void preencherTextField(Object object) {
        
        LancamentoCondominio lancamentoCondominio = (LancamentoCondominio) object;
        
        
        jComboBoxCompetencia.getModel().setSelectedItem(lancamentoCondominio.getCompetencia());
        
        
    }
    
    @Override
    public Object getValoresInformadosNaTela() {
        
        LancamentoCondominio lancamentoCondominio = (LancamentoCondominio) controle.getEntity();
        
        lancamentoCondominio.setCompetencia((Competencia) jComboBoxCompetencia.getModel().getSelectedItem());
        
        return lancamentoCondominio;
        
    }
    
    @Override
    public LancamentoCondominioControle getControler() {
        return this.controle;
    }
    
    @Override
    public void atualizaValoresDadosTela() {
        
        preencherTextField((LancamentoCondominio) controle.getEntity());
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
