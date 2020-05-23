/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view;

import com.hugo.atena.controler.Controler;
import com.hugo.atena.utils.Events;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    private int ultimoRegistroSelecionado = -1;

    /**
     * @return the painelNavegacao
     */
    public JPanel getPainelNavegacao() {

        if (painelNavegacao == null) {

            listagemDadosTabela = new JTable();

            //Quando muda o registro na tabela
            listagemDadosTabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {

                    carregaRegistroTabela();
                }
            });

            //Add Key Listener
            listagemDadosTabela.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent e) {
                    
                    //key code = 127 (Excluir)    extended modifiers = 64 (Shift)
                    if (e.getKeyCode() == 127 && e.getModifiersEx() == 64) {
                        
                        getBtnExcluir().doClick();
                        
                    }
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

            try {

                getControler().updateDataTable(listagemDadosTabela);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

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
     * Utilizado para setar o foco quando excluir um registro
     *
     * @return
     */
    public abstract JPanel getPainelListagemDados();

    /**
     * Painel principal de abas
     *
     * @return
     */
    public abstract JTabbedPane getPainelPrincipal();

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

                    //Faz ficar visível a última linha
                    Rectangle cellBounds = getListagemDadosTabela().getCellRect(0, 0, true);

                    getListagemDadosTabela().scrollRectToVisible(cellBounds);

                    getListagemDadosTabela().setRowSelectionInterval(0, 0);

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

                    if (getListagemDadosTabela().getSelectedRow() > 0) {

                        getListagemDadosTabela().setRowSelectionInterval(0, getListagemDadosTabela().getSelectedRow() - 1);

                    } else {
                        //primeiro registro
                        getListagemDadosTabela().setRowSelectionInterval(0, 0);
                    }

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

                    if ((getListagemDadosTabela().getRowCount() - 1)
                            > getListagemDadosTabela().getSelectedRow()) {

                        getListagemDadosTabela().setRowSelectionInterval(0, getListagemDadosTabela().getSelectedRow() + 1);

                    }

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

                    if (getListagemDadosTabela().getRowCount() > 0) {

                        //Faz ficar visível a última linha
                        Rectangle cellBounds = getListagemDadosTabela().getCellRect(getListagemDadosTabela().getRowCount() - 1, 0, true);

                        getListagemDadosTabela().scrollRectToVisible(cellBounds);

                        //Seleciona o ultimo registro
                        getListagemDadosTabela().setRowSelectionInterval(0, getListagemDadosTabela().getRowCount() - 1);

                    }

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
        getControler().init();

    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        configurarBotoes(false, false, true, true, true);
        habilitarTextField(true);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (getUltimoRegistroSelecionado() > 0) {

            carregaRegistroTabela(getUltimoRegistroSelecionado());
        } else {
            modoInicial();
        }

    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            // TODO add your handling code here:
            getControler().save(getValoresInformadosNaTela());
            modoInicialComRegistro();

            if (getListagemDadosTabela() != null) {
                getControler().updateDataTable(getListagemDadosTabela());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "Confirma excluir registro?", "Excluir registro", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            getControler().remove(getControler().getEntity());

            try {

                getControler().updateDataTable(listagemDadosTabela);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            modoInicial();

            //envia para o o tab principal
            if (getPainelPrincipal() != null
                    && getPainelListagemDados() != null) {

                getPainelPrincipal().setSelectedComponent(getPainelListagemDados());
            }

        }

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
    private void carregaRegistroTabela() {

        int id = Integer.parseInt(getListagemDadosTabela().getValueAt(getListagemDadosTabela().getSelectedRow(), 0).toString());

        if (getUltimoRegistroSelecionado() != id) {

            setUltimoRegistroSelecionado(id);

            carregaRegistroTabela(id);
        }
    }

    private void carregaRegistroTabela(int id) {

        if (id > 0) {

            getControler().load(id);

            atualizaValoresDadosTela();

            modoInicialComRegistro();
        } else {
            modoInicial();
        }

    }

    /**
     * @return the listagemDadosTabela
     */
    public JTable getListagemDadosTabela() {
        return listagemDadosTabela;
    }

    /**
     * @return the ultimoRegistroSelecionado
     */
    public int getUltimoRegistroSelecionado() {
        return ultimoRegistroSelecionado;
    }

    /**
     * @param ultimoRegistroSelecionado the ultimoRegistroSelecionado to set
     */
    public void setUltimoRegistroSelecionado(int ultimoRegistroSelecionado) {
        this.ultimoRegistroSelecionado = ultimoRegistroSelecionado;
    }

}
