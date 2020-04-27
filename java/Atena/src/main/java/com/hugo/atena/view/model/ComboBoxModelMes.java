/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class ComboBoxModelMes extends AbstractListModel implements ComboBoxModel {

    private final List<Integer> lista;
    private Integer intSelecionado;

    public ComboBoxModelMes() {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        lista = Arrays.asList(a);

    }

    @Override
    public int getSize() {
        return this.getListaInteiro().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaInteiro().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof Integer) {
            this.setPessoaSelecionada((Integer) o);
            fireContentsChanged(o, 0, this.getListaInteiro().size());
        }

    }

    @Override
    public Object getSelectedItem() {
        return this.getPessoaSelecionada();
    }

    public void reset() {
        getListaInteiro().clear();
        intSelecionado = null;
    }

    /**
     * @return the lista
     */
    public List<Integer> getListaInteiro() {
        return lista;
    }


    /**
     * @return the intSelecionado
     */
    private Integer getPessoaSelecionada() {
        return intSelecionado;
    }

    /**
     * @param intSelecionado the intSelecionado to set
     */
    private void setPessoaSelecionada(Integer intSelecionado) {
        this.intSelecionado = intSelecionado;
    }

    public static ComboBoxModelMes getModel() {

        ComboBoxModelMes comoboxModel = new ComboBoxModelMes();


        return comoboxModel;
    }

}
