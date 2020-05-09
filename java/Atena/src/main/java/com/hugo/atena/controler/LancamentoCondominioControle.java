/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.controler.enums.TipoDespesa;
import com.hugo.atena.model.Apartamento;
import com.hugo.atena.model.Competencia;
import com.hugo.atena.model.DespesaCompartilhada;
import com.hugo.atena.model.LancamentoCondominio;
import com.hugo.atena.model.LancamentoCondominioDespesa;
import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.utils.HNumber;
import com.hugo.atena.view.model.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class LancamentoCondominioControle extends ControlerBasic implements Controler {

    LancamentoCondominio lancamentoCodominio;

    public LancamentoCondominioControle() {

    }

    @Override
    public void init() {
        lancamentoCodominio = new LancamentoCondominio();
    }

    @Override
    public Object getEntity() {

        if (lancamentoCodominio == null) {

            lancamentoCodominio = new LancamentoCondominio();
        }

        return lancamentoCodominio;
    }

    @Override
    public void setEntity(Object object) {

        lancamentoCodominio = (LancamentoCondominio) object;

    }

    /**
     * Retornam todas as pessoas cadastradas
     *
     * @return
     */
    public static List<LancamentoCondominio> getTodasLancamentoCondominio() {

        String jpSql = "from LancamentoCondominio order";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }

    @Override
    public void updateDataTable(JTable jTable) throws Exception{

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Competencia", "Apartamento",
            "Gás", "Despesas com investimento", "Despesas com investimento", "Total"};

        for (LancamentoCondominio p : getTodasLancamentoCondominio()) {
            
            HNumber comInvetimento = new HNumber();
            HNumber semInvetimento = new HNumber();
            
            for (LancamentoCondominioDespesa lcd : p.getDespesas()){
            
                if (TipoDespesa.COM_INVESTIMENTO == lcd.getCompartilhada().getTipoDespesaa()){
                    comInvetimento = comInvetimento.add(lcd.getValorCorrespondente());
                } else  {
                    semInvetimento = semInvetimento.add(lcd.getValorCorrespondente());
                }
                
            }
            
            dados.add(new Object[]{
                p.getId(),
                p.getCompetencia().getAno() + " - " + p.getCompetencia().getMes(),
                p.getApartamento().getNrApartamento(),
                p.getGas().getValor(),
                semInvetimento.toString(),
                comInvetimento.toString(),
                p.getValorTotal()
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
            setEntity((LancamentoCondominio) load);
        } else {
            setEntity(new LancamentoCondominio());
        }
    }

    @Override
    public void save(Object object) throws Exception {

        if (((LancamentoCondominio) object).getId() == 0) {

            //vamos pegar todos os apartamentos cadastrados
            super.save(getLancamentoCondominios(lancamentoCodominio.getCompetencia()));

        } else {
            //não é possível alterar o lancamento
        }
    }

    private ArrayList<Object> getLancamentoCondominios(Competencia competencia) throws Exception {

        ArrayList<Object> lancamentoCondominio = new ArrayList<>();

        List<DespesaCompartilhada> despesaCompartilhadas = DespesaCompartilhadaControle.getDespesaCompartilhadas();

        for (Apartamento apartamento : Apartamento.getApartamentos()) {

            LancamentoCondominio lc = new LancamentoCondominio();

            lc.setApartamento(apartamento);
            lc.setCompetencia(competencia);
            lc.calculaValores(despesaCompartilhadas);

            lancamentoCondominio.add(lc);

        }

        return lancamentoCondominio;

    }

}
