/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.model.TipoApartamento;
import com.hugo.atena.view.model.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class TipoApartamentoControle extends ControlerBasic implements Controler {

    TipoApartamento tipoApartamento;

    public TipoApartamentoControle() {

    }

    @Override
    public void init() {
        tipoApartamento = new TipoApartamento();
    }

    @Override
    public Object getEntity() {

        if (tipoApartamento == null) {

            tipoApartamento = new TipoApartamento();
        }

        return tipoApartamento;
    }

    @Override
    public void setEntity(Object object) {

        tipoApartamento = (TipoApartamento) object;

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Tipo", "Valor Condomínio", "Fundo Reserva"};

     

        for (TipoApartamento p : TipoApartamento.getTipoApartamentos()) {
            dados.add(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getVlrCondominio(),
                p.getVlrFundoReserva()});
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
            setEntity((TipoApartamento) load);
        } else {
            setEntity(new TipoApartamento());
        }
    }

    @Override
    public void save(Object object) {
        super.save(object, ((TipoApartamento) object).getId());
    }
}
