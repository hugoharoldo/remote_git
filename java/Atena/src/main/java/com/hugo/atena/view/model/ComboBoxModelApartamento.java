/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import com.hugo.atena.model.Apartamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class ComboBoxModelApartamento extends AbstractListModel implements ComboBoxModel {

    private final List<Apartamento> listaDados;
    private Apartamento apartamentoSelecionada;

    public ComboBoxModelApartamento() {

        this.listaDados = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.getListaApartamentos().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaApartamentos().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof Apartamento) {
            this.setApartamentoSelecionada((Apartamento) o);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.getApartamentoSelecionada();
    }

    public void reset() {
        getListaApartamentos().clear();
        apartamentoSelecionada = null;
    }

    /**
     * @return the listaDados
     */
    public List<Apartamento> getListaApartamentos() {
        return listaDados;
    }

    /**
     * @param listaDados the listaDados to set //
     */
    public void addApartamentos(List<Apartamento> listaDados) {
        this.listaDados.addAll(listaDados);
    }

    /**
     *
     * @param apartamento
     */
    public void addApartamentos(Apartamento apartamento) {
        getListaApartamentos().add(apartamento);
        fireContentsChanged(apartamento, 0, this.getListaApartamentos().size());
    }

    /**
     * @return the apartamentoSelecionada
     */
    private Apartamento getApartamentoSelecionada() {
        return apartamentoSelecionada;
    }

    /**
     * @param apartamentoSelecionada the apartamentoSelecionada to set
     */
    private void setApartamentoSelecionada(Apartamento apartamentoSelecionada) {
        this.apartamentoSelecionada = apartamentoSelecionada;
    }
    
    public static ComboBoxModelApartamento getModel() {

        ComboBoxModelApartamento comoboxModel = new ComboBoxModelApartamento();
        comoboxModel.addApartamentos(Apartamento.getApartamentos());

        return comoboxModel;
    }
}
