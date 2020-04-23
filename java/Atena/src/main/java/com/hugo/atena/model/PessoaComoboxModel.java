/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class PessoaComoboxModel extends AbstractListModel implements ComboBoxModel {

    private List<People> listaPessoas;
    private People pessoaSelecionada;

    public PessoaComoboxModel() {

        this.listaPessoas = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.getListaPessoas().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaPessoas().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof People) {
            this.setPessoaSelecionada((People) o);
            fireContentsChanged(o, 0, this.getListaPessoas().size());
        }

    }

    @Override
    public Object getSelectedItem() {
        return this.getPessoaSelecionada();
    }

    public void reset() {
        getListaPessoas().clear();
        pessoaSelecionada = null;
    }

    /**
     * @return the listaPessoas
     */
    public List<People> getListaPessoas() {
        return listaPessoas;
    }

    /**
     * @param listaPessoas the listaPessoas to set //
     */
    public void addPessoas(List<People> listaPessoas) {
        this.listaPessoas.addAll(listaPessoas);
    }

    /**
     *
     * @param people
     */
    public void addPessoas(People people) {
        getListaPessoas().add(people);
        fireContentsChanged(people, 0, this.getListaPessoas().size());
    }

    /**
     * @return the pessoaSelecionada
     */
    private People getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    /**
     * @param pessoaSelecionada the pessoaSelecionada to set
     */
    private void setPessoaSelecionada(People pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

}
