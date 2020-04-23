/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.model.Pessoa;
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

    Pessoa people;

    public PessoaControle() {

    }

    @Override
    public void init() {
        people = new Pessoa();
    }

    @Override
    public Object getEntity() {

        if (people == null) {

            people = new Pessoa();
        }

        return people;
    }

    @Override
    public void setEntity(Object object) {

        people = (Pessoa) object;

    }

    /**
     * Retornam todas as pessoas cadastradas
     * @return 
     */
    public static List<Pessoa> getPessoas() {

        String jpSql = "from People order";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }
    
    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "CPF", "Telefone", "E-mail"};

        for (Pessoa p : getPessoas()) {
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
            setEntity((Pessoa) load);
        } else {
            setEntity(new Pessoa());
        }
    }

    @Override
    public void save(Object object) {
        super.save(object, ((Pessoa) object).getId());
    }
}
