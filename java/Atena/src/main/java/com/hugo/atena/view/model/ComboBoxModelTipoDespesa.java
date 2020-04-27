/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import com.hugo.atena.controler.enums.TipoDespesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class ComboBoxModelTipoDespesa extends AbstractListModel implements ComboBoxModel {

    private final List<TipoDespesa> lista;
    private TipoDespesa competenciaSelecionada;

    public ComboBoxModelTipoDespesa() {

        this.lista = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.getListaTipoDespesa().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaTipoDespesa().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof TipoDespesa) {
            this.setTipoDespesaSelecionada((TipoDespesa) o);
        }

    }

    @Override
    public Object getSelectedItem() {
        return this.getTipoDespesaSelecionada();
    }


    /**
     * @return the listaTipoDespesa
     */
    public List<TipoDespesa> getListaTipoDespesa() {
        return lista;
    }

    /**
     * @param listaTipoDespesa the listaTipoDespesa to set //
     */
    public void addTipoDespesa(List<TipoDespesa> listaTipoDespesa) {
        this.lista.addAll(listaTipoDespesa);
    }

    /**
     *
     * @param apartamento
     */
    public void addTipoDespesa(TipoDespesa apartamento) {
        getListaTipoDespesa().add(apartamento);
        fireContentsChanged(apartamento, 0, this.getListaTipoDespesa().size());
    }

    /**
     * @return the competenciaSelecionada
     */
    private TipoDespesa getTipoDespesaSelecionada() {
        return competenciaSelecionada;
    }

    /**
     * @param competenciaSelecionada the competenciaSelecionada to set
     */
    private void setTipoDespesaSelecionada(TipoDespesa competenciaSelecionada) {
        this.competenciaSelecionada = competenciaSelecionada;
    }
    
    public static ComboBoxModelTipoDespesa getModel() {

        ComboBoxModelTipoDespesa comoboxModel = new ComboBoxModelTipoDespesa();
        comoboxModel.addTipoDespesa(TipoDespesa.SEM_INVESTIMENTO);
        comoboxModel.addTipoDespesa(TipoDespesa.COM_INVESTIMENTO);
        
        return comoboxModel;
    }
}
