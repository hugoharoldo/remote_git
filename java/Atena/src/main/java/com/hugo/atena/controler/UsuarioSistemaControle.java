/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.model.UsuarioSistema;
import com.hugo.atena.view.model.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class UsuarioSistemaControle extends ControlerBasic implements Controler {

    UsuarioSistema usuarioSistema;

    public UsuarioSistemaControle() {

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome"};

        String jpSql = "from UsuarioSistema order";

        List<UsuarioSistema> list = EntityManagerUtil.getEntityManager()
                .createQuery(jpSql).getResultList();

        for (UsuarioSistema us : list) {
            dados.add(new Object[]{
                us.getId(),
                us.getNome()});
        }

        TableModel model = new TableModel(dados, colunas);

        jTable.setModel(model);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(0).setResizable(false);

        jTable.getColumnModel().getColumn(1).setResizable(true);

        jTable.getTableHeader().setResizingAllowed(false);

        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @Override
    public void setEntity(Object object) {
        usuarioSistema = (UsuarioSistema) object;
    }

    @Override
    public void load(int id) {
        Object load = this.load(id, getEntity());

        if (load != null) {
            setEntity((UsuarioSistema) load);
        } else {
            setEntity(new UsuarioSistema());
        }
    }

    @Override
    public Object getEntity() {

        if (usuarioSistema == null) {
            usuarioSistema = new UsuarioSistema();
        }

        return usuarioSistema;

    }

    @Override
    public void init() {
        usuarioSistema = new UsuarioSistema();
    }

    @Override
    public void save(Object object) {
        super.save(object, ((UsuarioSistema) object).getId());
    }

    public static boolean isUsuarioAutorizado(String usuario, String senha) {

        if (usuario == null || senha == null) {
            return false;
        }

        try {

            String jpSql = "FROM UsuarioSistema WHERE nome = ?1";

            Query query = EntityManagerUtil.getEntityManager().createQuery(jpSql);
            query.setParameter(1, usuario);

            UsuarioSistema us = (UsuarioSistema) query.getSingleResult();

            return senha.equals(us.getSenha());
            
        } catch (Exception e) {

            e.printStackTrace();
            
            return false;
        }

    }
}
