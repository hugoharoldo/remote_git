/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.Apartamento;
import com.hugo.atena.model.Competencia;
import com.hugo.atena.model.MedicaoGas;
import com.hugo.atena.model.util.EntityManagerUtil;
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
public class MedicaoGasControler extends ControlerBasic implements Controler {

    MedicaoGas medicaoGas;

    public MedicaoGasControler() {

    }

    @Override
    public void init() {
        medicaoGas = new MedicaoGas();
    }

    @Override
    public Object getEntity() {

        if (medicaoGas == null) {

            medicaoGas = new MedicaoGas();
        }

        return medicaoGas;
    }

    @Override
    public void setEntity(Object object) {

        medicaoGas = (MedicaoGas) object;

    }

    /**
     * Retornam todas as pessoas cadastradas
     *
     * @return
     */
    public static List<MedicaoGas> getTodasMedicoesGas() {

        String jpSql = "from MedicaoGas order";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Competencia", "Apartamento",
            "Leitura Anterior", "Leitura Atual", "Total Consumido", "Valor"};

        for (MedicaoGas p : getTodasMedicoesGas()) {
            dados.add(new Object[]{
                p.getId(),
                p.getCompetencia().getAno() + " - " + p.getCompetencia().getMes(),
                p.getApartamento().getNrApartamento(),
                p.getLeituraAnterior(),
                p.getLeituraAtual(),
                p.getTotalConsumido(),
                p.getValor()
            });
        }

        TableModel model = new TableModel(dados, colunas);

        jTable.setModel(model);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(0).setResizable(true);

        jTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(1).setResizable(true);

        jTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(2).setResizable(true);

        jTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(3).setResizable(true);

        jTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(4).setResizable(true);

        jTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(5).setResizable(true);

        jTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(6).setResizable(true);

        jTable.getTableHeader().setResizingAllowed(false);

        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @Override
    public void load(int id) {

        Object load = this.load(id, getEntity());

        if (load != null) {
            setEntity((MedicaoGas) load);
        } else {
            setEntity(new MedicaoGas());
        }
    }

    @Override
    public void save(Object object) {
        super.save(object, ((MedicaoGas) object).getId());
    }

    public static int getUltimaMedicaoGas(final Apartamento a, final Competencia c) throws Exception {
        
        Competencia anterior = new CompetenciaControle().getAnteriorCompetencia(c.getAno(), c.getMes());
        
        MedicaoGas mg = getMedicaoGas(a, anterior);
        
        if (mg == null){
            return 0;
        }else{
            return mg.getLeituraAtual();
        }

    }
    
    public static MedicaoGas getMedicaoGas(final Apartamento a, final Competencia c) throws Exception {

        
        String jpSql = "from MedicaoGas where apartamento_id = ?1 and competencia_id = ?2";

        Query query = EntityManagerUtil.getEntityManager().createQuery(jpSql);
        query.setParameter(1, a.getId());
        query.setParameter(2, c.getId());

        List list = query.getResultList();

        if (list != null && !list.isEmpty()) {

            MedicaoGas mg = (MedicaoGas) list.get(0);

            return mg;
        } else {
            return null;
        }

    }

}
