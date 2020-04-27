/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import com.hugo.atena.model.Competencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author hugo
 */
public class ComboBoxModelCompetencia extends AbstractListModel implements ComboBoxModel {

    private final List<Competencia> listaCompetencias;
    private Competencia competenciaSelecionada;

    public ComboBoxModelCompetencia() {

        this.listaCompetencias = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.getListaCompetencias().size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.getListaCompetencias().get(i);
    }

    @Override
    public void setSelectedItem(Object o) {

        if (o instanceof Competencia) {
            this.setCompetenciaSelecionada((Competencia) o);
        }

    }

    @Override
    public Object getSelectedItem() {
        return this.getCompetenciaSelecionada();
    }

    public void reset() {
        getListaCompetencias().clear();
        competenciaSelecionada = null;
    }

    /**
     * @return the listaCompetencias
     */
    public List<Competencia> getListaCompetencias() {
        return listaCompetencias;
    }

    /**
     * @param listaCompetencias the listaCompetencias to set //
     */
    public void addCompetencias(List<Competencia> listaCompetencias) {
        this.listaCompetencias.addAll(listaCompetencias);
    }

    /**
     *
     * @param apartamento
     */
    public void addCompetencias(Competencia apartamento) {
        getListaCompetencias().add(apartamento);
        fireContentsChanged(apartamento, 0, this.getListaCompetencias().size());
    }

    /**
     * @return the competenciaSelecionada
     */
    private Competencia getCompetenciaSelecionada() {
        return competenciaSelecionada;
    }

    /**
     * @param competenciaSelecionada the competenciaSelecionada to set
     */
    private void setCompetenciaSelecionada(Competencia competenciaSelecionada) {
        this.competenciaSelecionada = competenciaSelecionada;
    }
    
    public static ComboBoxModelCompetencia getModel() {

        ComboBoxModelCompetencia comoboxModel = new ComboBoxModelCompetencia();
        comoboxModel.addCompetencias(Competencia.getCompetencias());

        return comoboxModel;
    }
}
