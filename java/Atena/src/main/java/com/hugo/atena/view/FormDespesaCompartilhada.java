/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.Controler;
import com.hugo.atena.controler.DespesaCompartilhadaControle;
import com.hugo.atena.controler.enums.TipoDespesa;
import com.hugo.atena.model.Competencia;
import com.hugo.atena.model.DespesaCompartilhada;
import com.hugo.atena.view.model.ComboBoxModelCompetencia;
import com.hugo.atena.view.model.ComboBoxModelMes;
import com.hugo.atena.view.model.ComboBoxModelTipoDespesa;

/**
 *
 * @author hugo
 */
public class FormDespesaCompartilhada extends HDialog {

    private final DespesaCompartilhadaControle controle = new DespesaCompartilhadaControle();

    /**
     * Creates new form formPeople
     *
     * @param parent
     * @param modal
     */
    public FormDespesaCompartilhada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        painelBotoesManutencao.add(this.getPainelSalvador());

        painelListaDados.add(this.getPainelNavegacao(), java.awt.BorderLayout.PAGE_END);

        jComboBoxCompetencia.setModel(ComboBoxModelCompetencia.getModel());
    
        jComboBoxTipoDespesa.setModel(ComboBoxModelTipoDespesa.getModel());
        
        jComboBoxParcelas.setModel(ComboBoxModelMes.getModel());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCompetencia = new javax.swing.JComboBox<>();
        jComboBoxTipoDespesa = new javax.swing.JComboBox<>();
        jComboBoxParcelas = new javax.swing.JComboBox<>();
        painelBotoesManutencao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas");

        jTabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPaneFocusGained(evt);
            }
        });

        painelListaDados.setLayout(new java.awt.BorderLayout());
        jTabbedPane.addTab("Lista de despesas compartilhadas", painelListaDados);

        painelCadastro.setLayout(new java.awt.BorderLayout());

        painelCamposPersonaizados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                painelCamposPersonaizadosFocusGained(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Comp.:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tipo:");

        jTextFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescricaoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Parcelas:");

        javax.swing.GroupLayout painelCamposPersonaizadosLayout = new javax.swing.GroupLayout(painelCamposPersonaizados);
        painelCamposPersonaizados.setLayout(painelCamposPersonaizadosLayout);
        painelCamposPersonaizadosLayout.setHorizontalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCamposPersonaizadosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCamposPersonaizadosLayout.createSequentialGroup()
                        .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5))
                            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 84, Short.MAX_VALUE))
        );

        painelCamposPersonaizadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5, jLabel6});

        painelCamposPersonaizadosLayout.setVerticalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(281, 281, 281))
        );

        painelCadastro.add(painelCamposPersonaizados, java.awt.BorderLayout.NORTH);

        painelBotoesManutencao.setLayout(new java.awt.GridLayout(1, 0));
        painelCadastro.add(painelBotoesManutencao, java.awt.BorderLayout.SOUTH);

        jTabbedPane.addTab("Despesas compartilhadas", painelCadastro);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(724, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed


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
            java.util.logging.Logger.getLogger(FormDespesaCompartilhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDespesaCompartilhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDespesaCompartilhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDespesaCompartilhada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                FormDespesaCompartilhada dialog = new FormDespesaCompartilhada(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBoxParcelas;
    private javax.swing.JComboBox<String> jComboBoxTipoDespesa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JPanel painelBotoesManutencao;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelCamposPersonaizados;
    private javax.swing.JPanel painelListaDados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarTextField(boolean habilitar) {

        jTextFieldDescricao.setEnabled(habilitar);
        jComboBoxTipoDespesa.setEnabled(habilitar);
        jComboBoxCompetencia.setEnabled(habilitar);
        jTextFieldValor.setEnabled(habilitar);
        jComboBoxParcelas.setEnabled(habilitar);

    }

    @Override
    public void limparTextField() {

        jTextFieldDescricao.setText("");
        jTextFieldValor.setText("");
        jComboBoxTipoDespesa.getModel().setSelectedItem(TipoDespesa.SEM_INVESTIMENTO);
        jComboBoxCompetencia.getModel().setSelectedItem(new Competencia());
        jComboBoxParcelas.setSelectedItem(1);
    }

    @Override
    public void preencherTextField(Object object) {

        DespesaCompartilhada p = (DespesaCompartilhada) object;

        jTextFieldDescricao.setText(p.getDescricao());
        jTextFieldValor.setText(String.valueOf(p.getValor()) );
        jComboBoxTipoDespesa.setSelectedItem(p.getTipoDespesaa());
        jComboBoxCompetencia.setSelectedItem(p.getCompetencia());
        jComboBoxParcelas.setSelectedItem(p.getParcelas());

    }

    @Override
    public Object getValoresInformadosNaTela() {

        DespesaCompartilhada dc = (DespesaCompartilhada) controle.getEntity();
        
        dc.setCompetencia((Competencia) jComboBoxCompetencia.getSelectedItem());
        dc.setDescricao(jTextFieldDescricao.getText());
        dc.setParcelas(Integer.parseInt(jComboBoxParcelas.getSelectedItem().toString()));
        dc.setTipoDespesa(((TipoDespesa) jComboBoxTipoDespesa.getSelectedItem()).getTipo());
        dc.setValor(Double.parseDouble(jTextFieldValor.getText()) );
                
        return dc;

    }

    @Override
    public Controler getControler() {
        return this.controle;
    }

    @Override
    public void atualizaValoresDadosTela() {
        
        preencherTextField(controle.getEntity());
        
    }
}
