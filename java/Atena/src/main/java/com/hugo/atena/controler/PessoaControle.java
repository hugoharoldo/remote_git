/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.daos.EntityManagerUtil;
import com.hugo.atena.model.People;
import com.hugo.atena.view.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class PessoaControle extends ControlerBasic implements Controler {

    People people;

    public PessoaControle() {

    }

    @Override
    public void init() {
        people = new People();
    }

    @Override
    public Object getEntity() {

        if (people == null) {

            people = new People();
        }

        return people;
    }

    @Override
    public void setEntity(Object object) {

        people = (People) object;

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "CPF", "Telefone", "E-mail"};

        String jpSql = "from People order";

        List<People> list = EntityManagerUtil.getEntityManager()
                .createQuery(jpSql).getResultList();

        for (People p : list) {
            dados.add(new Object[]{
                p.getId(),
                p.getName(),
                p.getCPFCNPJ(),
                p.getFone(),
                p.getEmail()});
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
            setEntity((People) load);
        } else {
            setEntity(new People());
        }
    }
}
