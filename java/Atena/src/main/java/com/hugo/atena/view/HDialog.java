/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.Controler;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hugo
 */
public abstract class HDialog extends javax.swing.JDialog {

    private JPanel painelNavegacao, navegador, painelSalvador;
    private JButton btnSalvar, btnNovo, btnEditar, btnCancelar, btnExcluir;
    private JButton btnPrimeiro, btnAnterior, btnProximo, btnUltimo;
    private JScrollPane listagemDados;
    private JTable listagemDadosTabela;

    /**
     * @return the painelNavegacao
     */
    public JPanel getPainelNavegacao() {

        if (painelNavegacao == null) {

            listagemDadosTabela = new JTable();

            listagemDadosTabela.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    listagemDadosTabelaMouseClicked(evt);
                }
            });

            listagemDados = new JScrollPane();
            listagemDados.setViewportView(getListagemDadosTabela());

            painelNavegacao = new JPanel();
            painelNavegacao.setLayout(new BorderLayout());
            painelNavegacao.add(listagemDados, java.awt.BorderLayout.NORTH);

            navegador = new JPanel();

            navegador.setLayout(new java.awt.GridLayout(1, 0));

            navegador.add(getBtnPrimeiro());
            navegador.add(getBtnAnterior());
            navegador.add(getBtnProximo());
            navegador.add(getBtnUltimo());

            painelNavegacao.add(navegador, java.awt.BorderLayout.CENTER);

            getControler().atualizaValoresTabela(listagemDadosTabela);

        }

        return painelNavegacao;
    }

    public HDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public abstract Object getValoresInformadosNaTela();

    public abstract void habilitarTextField(boolean habilitar);

    public abstract void limparTextField();

    public abstract void preencherTextField(Object object);

    public abstract Controler getControler();

    /**
     * Atualizar os Fields da tela com os valores que estão no Controler
     */
    public abstract void atualizaValoresDadosTela();

    /**
     * @return the painelSalvador
     */
    public JPanel getPainelSalvador() {

        if (painelSalvador == null) {

            painelSalvador = new JPanel();
            painelSalvador.setLayout(new java.awt.GridLayout(1, 0));

            painelSalvador.add(getBtnNovo());
            painelSalvador.add(getBtnEditar());
            painelSalvador.add(getBtnCancelar());
            painelSalvador.add(getBtnSalvar());
            painelSalvador.add(getBtnExcluir());

            modoInicial();

        }

        return painelSalvador;
    }

    //
    // <editor-fold defaultstate="collapsed" desc="Construtores dos botões">    
    public JButton getBtnNovo() {

        if (btnNovo == null) {

            btnNovo = new JButton();
            btnNovo.setText("Novo");
            btnNovo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNovoActionPerformed(evt);
                }

            });
        }

        return btnNovo;

    }

    private JButton getBtnEditar() {

        if (btnEditar == null) {

            btnEditar = new JButton();
            btnEditar.setText("Editar");
            btnEditar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnEditarActionPerformed(evt);
                }

            });
        }

        return btnEditar;

    }

    /**
     * @return the btnCancelar
     */
    public JButton getBtnCancelar() {

        if (btnCancelar == null) {

            btnCancelar = new JButton();
            btnCancelar.setText("Cancelar");
            btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelarActionPerformed(evt);
                }
            });
        }

        return btnCancelar;
    }

    /**
     * @return the btnSalvar
     */
    public JButton getBtnSalvar() {

        if (btnSalvar == null) {

            btnSalvar = new JButton();
            btnSalvar.setText("Salvar");
            btnSalvar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSalvarActionPerformed(evt);
                }

            });

        }
        return btnSalvar;

    }

    /**
     * @return the btnExcluir
     */
    public JButton getBtnExcluir() {

        if (btnExcluir == null) {

            btnExcluir = new JButton();
            btnExcluir.setText("Excluir");
            btnExcluir.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExcluirActionPerformed(evt);
                }

            });

        }

        return btnExcluir;

    }

    /**
     * @return the btnPrimeiro
     */
    public JButton getBtnPrimeiro() {

        if (btnPrimeiro == null) {

            btnPrimeiro = new JButton();
            btnPrimeiro.setText("Primeiro");
            btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.println("Primeiro");
                }

            });

        }

        return btnPrimeiro;
    }

    /**
     * @return the btnAnterior
     */
    public JButton getBtnAnterior() {

        if (btnAnterior == null) {

            btnAnterior = new JButton();
            btnAnterior.setText("Anterior");
            btnAnterior.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.println("Anterior");
                }

            });

        }

        return btnAnterior;
    }

    /**
     * @return the btnProximo
     */
    public JButton getBtnProximo() {

        if (btnProximo == null) {

            btnProximo = new JButton();
            btnProximo.setText("Proximo");
            btnProximo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.println("btnProximo");
                }

            });

        }

        return btnProximo;
    }

    /**
     * @return the btnProximo
     */
    public JButton getBtnUltimo() {

        if (btnUltimo == null) {

            btnUltimo = new JButton();
            btnUltimo.setText("Último");
            btnUltimo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.println("btnUltimo");
                }

            });

        }

        return btnUltimo;
    }

    // </editor-fold>
    //
    // <editor-fold defaultstate="collapsed" desc="Eventos dos botões">    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {

        configurarBotoes(false, false, true, true, false);
        habilitarTextField(true);
        limparTextField();

    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        configurarBotoes(false, false, true, true, true);
        habilitarTextField(true);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        modoInicial();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        // TODO add your handling code here:
        getControler().gravar(getValoresInformadosNaTela());
        modoInicialComRegistro();

        if (getListagemDadosTabela() != null) {
            getControler().atualizaValoresTabela(getListagemDadosTabela());
        }

    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        modoInicial();
    }

    // </editor-fold>
    //
    // <editor-fold defaultstate="collapsed" desc="Controle dos botões">    
    /**
     *
     * @param n - novo
     * @param e - editar
     * @param c - cancelar
     * @param s - salvar
     * @param d - deletar
     */
    private void configurarBotoes(boolean n, boolean e, boolean c, boolean s, boolean d) {

        getBtnNovo().setEnabled(n);
        getBtnEditar().setEnabled(e);
        getBtnCancelar().setEnabled(c);
        getBtnSalvar().setEnabled(s);
        getBtnExcluir().setEnabled(d);

    }

    private void modoInicialComRegistro() {
        configurarBotoes(true, true, false, false, true);
        habilitarTextField(false);
    }

    private void modoInicial() {
        configurarBotoes(true, false, false, false, false);
        habilitarTextField(false);
        limparTextField();
    }

    // </editor-fold>
//    
//    
    private void listagemDadosTabelaMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        int id = Integer.parseInt(getListagemDadosTabela().getValueAt(getListagemDadosTabela().getSelectedRow(), 0).toString());

        getControler().load(id);

        atualizaValoresDadosTela();

    }

    /**
     * @return the listagemDadosTabela
     */
    public JTable getListagemDadosTabela() {
        return listagemDadosTabela;
    }

}
