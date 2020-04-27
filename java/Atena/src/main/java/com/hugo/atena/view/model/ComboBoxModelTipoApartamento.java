/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import com.hugo.atena.model.TipoApartamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class ComboBoxModelTipoApartamento extends AbstractListModel implements ComboBoxModel {

    private final List<TipoApartamento> listaDados;
    private TipoApartamento tipoApartamentoSelecionada;

    public ComboBoxModelTipoApartamento() {

        this.listaDados = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.getListaTipoApartamentos().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaTipoApartamentos().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof TipoApartamento) {
            this.setTipoApartamentoSelecionada((TipoApartamento) o);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.getTipoApartamentoSelecionada();
    }

    public void reset() {
        getListaTipoApartamentos().clear();
        tipoApartamentoSelecionada = null;
    }

    /**
     * @return the listaDados
     */
    public List<TipoApartamento> getListaTipoApartamentos() {
        return listaDados;
    }

    /**
     * @param listaTipoApartamentos the listaDados to set //
     */
    public void addTipoApartamentos(List<TipoApartamento> listaTipoApartamentos) {
        this.listaDados.addAll(listaTipoApartamentos);
    }

    /**
     *
     * @param apartamento
     */
    public void addTipoApartamentos(TipoApartamento apartamento) {
        getListaTipoApartamentos().add(apartamento);
        fireContentsChanged(apartamento, 0, this.getListaTipoApartamentos().size());
    }

    /**
     * @return the tipoApartamentoSelecionada
     */
    private TipoApartamento getTipoApartamentoSelecionada() {
        return tipoApartamentoSelecionada;
    }

    /**
     * @param tipoApartamentoSelecionada the tipoApartamentoSelecionada to set
     */
    private void setTipoApartamentoSelecionada(TipoApartamento tipoApartamentoSelecionada) {
        this.tipoApartamentoSelecionada = tipoApartamentoSelecionada;
    }

    public static ComboBoxModelTipoApartamento getModel() {

        ComboBoxModelTipoApartamento comoboxModel = new ComboBoxModelTipoApartamento();
        comoboxModel.addTipoApartamentos(TipoApartamento.getTipoApartamentos());

        return comoboxModel;
    }


}
