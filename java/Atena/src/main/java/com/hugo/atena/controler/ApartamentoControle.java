/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.model.Apartamento;
import com.hugo.atena.view.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class ApartamentoControle extends ControlerBasic implements Controler {

    Apartamento apartamento;

    public ApartamentoControle() {

    }

    @Override
    public void init() {
        apartamento = new Apartamento();
    }

    @Override
    public Object getEntity() {

        if (apartamento == null) {

            apartamento = new Apartamento();
        }

        return apartamento;
    }

    @Override
    public void setEntity(Object object) {

        apartamento = (Apartamento) object;

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Apartamento", "Responsável" , "Proprietário"};

        String jpSql = "from Apartamento order";

        List<Apartamento> list = EntityManagerUtil.getEntityManager()
                .createQuery(jpSql).getResultList();

        for (Apartamento p : list) {
            dados.add(new Object[]{
                p.getId(),
                p.getNrApartamento(),
                p.getResponsavel().getName(),
                p.getProprietario().getName()});
        }

        TableModel model = new TableModel(dados, colunas);

        jTable.setModel(model);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(0).setResizable(true);

        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(1).setResizable(true);

        jTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(2).setResizable(true);

        jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(3).setResizable(true);

        jTable.getTableHeader().setResizingAllowed(false);

        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @Override
    public void load(int id) {

        Object load = this.load(id, getEntity());

        if (load != null) {
            setEntity((Apartamento) load);
        } else {
            setEntity(new Apartamento());
        }
    }

    @Override
    public void save(Object object) {
        super.save(object, ((Apartamento) object).getId());
    }
}
