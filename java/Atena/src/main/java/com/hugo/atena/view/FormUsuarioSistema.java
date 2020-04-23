/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.Controler;
import com.hugo.atena.controler.UsuarioSistemaControle;
import com.hugo.atena.model.UsuarioSistema;

/**
 *
 * @author hugo
 */
public class FormUsuarioSistema extends HDialog {

    private final UsuarioSistemaControle usc = new UsuarioSistemaControle();

    /**
     * Creates new form FormUsuarioSistema
     */
    public FormUsuarioSistema(java.awt.Frame parent, boolean modal) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFieldNome = new javax.swing.JTextField();
        jFiledSenha = new javax.swing.JPasswordField();
        painelBotoesManutencao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelListaDados.setLayout(new java.awt.BorderLayout());
        jTabbedPane.addTab("Lista de Usuários", painelListaDados);

        painelCadastro.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nome:");

        jLabel2.setText("Senha:");

        javax.swing.GroupLayout painelCamposPersonaizadosLayout = new javax.swing.GroupLayout(painelCamposPersonaizados);
        painelCamposPersonaizados.setLayout(painelCamposPersonaizadosLayout);
        painelCamposPersonaizadosLayout.setHorizontalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFieldNome)
                    .addComponent(jFiledSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        painelCamposPersonaizadosLayout.setVerticalGroup(
            painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposPersonaizadosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCamposPersonaizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFiledSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        painelCadastro.add(painelCamposPersonaizados, java.awt.BorderLayout.NORTH);

        painelBotoesManutencao.setLayout(new java.awt.GridLayout(1, 0));
        painelCadastro.add(painelBotoesManutencao, java.awt.BorderLayout.SOUTH);

        jTabbedPane.addTab("Usuário", painelCadastro);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(722, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormUsuarioSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuarioSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuarioSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuarioSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormUsuarioSistema dialog = new FormUsuarioSistema(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField jFieldNome;
    private javax.swing.JPasswordField jFiledSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel painelBotoesManutencao;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelCamposPersonaizados;
    private javax.swing.JPanel painelListaDados;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getValoresInformadosNaTela() {

        UsuarioSistema us = (UsuarioSistema) usc.getEntity();

        us.setNome(jFieldNome.getText());
        us.setSenha(jFiledSenha.getText());

        return us;

    }

    @Override
    public void habilitarTextField(boolean habilitar) {
        jFieldNome.setEnabled(habilitar);
        jFiledSenha.setEnabled(habilitar);
    }

    @Override
    public void limparTextField() {
        jFieldNome.setText("");
        jFiledSenha.setText("");
    }

    @Override
    public void preencherTextField(Object object) {

        UsuarioSistema us = (UsuarioSistema) object;

        jFieldNome.setText(us.getNome());
        jFiledSenha.setText(us.getSenha());

    }

    @Override
    public Controler getControler() {
        return this.usc;
    }

    @Override
    public void atualizaValoresDadosTela() {
        jFieldNome.setText(((UsuarioSistema) usc.getEntity()).getNome());
        jFiledSenha.setText(((UsuarioSistema) usc.getEntity()).getSenha());
    }
}
