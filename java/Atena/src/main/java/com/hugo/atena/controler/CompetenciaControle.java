/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.Competencia;
import com.hugo.atena.view.model.TableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class CompetenciaControle extends ControlerBasic implements Controler {

    Competencia competencia;

    public CompetenciaControle() {

    }

    @Override
    public void init() {
        competencia = new Competencia();
    }

    @Override
    public Object getEntity() {

        if (competencia == null) {
            competencia = new Competencia();
        }

        return competencia;

    }

    @Override
    public void setEntity(Object object) {
        competencia = (Competencia) object;
    }

    @Override
    public void load(int id) {

        Object load = this.load(id, getEntity());

        if (load != null) {
            setEntity((Competencia) load);
        } else {
            setEntity(new Competencia());
        }

    }

    @Override
    public void save(Object object) {
        super.save(object, ((Competencia) object).getId());
    }

    @Override
    public void updateDataTable(JTable table) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Ano", "Mês"};

        for (Competencia p : Competencia.getCompetencias()) {
            dados.add(new Object[]{
                p.getId(),
                p.getAno(),
                p.getMes()});
        }

        TableModel model = new TableModel(dados, colunas);

        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(0).setResizable(true);

        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setResizable(true);

        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setResizable(true);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
