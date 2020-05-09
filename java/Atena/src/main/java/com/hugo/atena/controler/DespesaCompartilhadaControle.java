/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.Competencia;
import com.hugo.atena.model.util.EntityManagerUtil;
import com.hugo.atena.model.DespesaCompartilhada;
import com.hugo.atena.view.model.TableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class DespesaCompartilhadaControle extends ControlerBasic implements Controler {

    DespesaCompartilhada despesaCompartilhada;

    public DespesaCompartilhadaControle() {

    }

    @Override
    public void init() {
        despesaCompartilhada = new DespesaCompartilhada();
    }

    @Override
    public Object getEntity() {

        if (despesaCompartilhada == null) {

            despesaCompartilhada = new DespesaCompartilhada();
        }

        return despesaCompartilhada;
    }

    @Override
    public void setEntity(Object object) {

        despesaCompartilhada = (DespesaCompartilhada) object;

    }

    /**
     * Retornam todas as pessoas cadastradas
     *
     * @return
     */
    public static List<DespesaCompartilhada> getDespesaCompartilhadas() {

        String jpSql = "from DespesaCompartilhada order";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }

    @Override
    public void updateDataTable(JTable jTable) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Competencia", "Valor", "Parcela", "Descricao", "Tipo"};

        for (DespesaCompartilhada p : getDespesaCompartilhadas()) {
            dados.add(new Object[]{
                p.getId(),
                p.getCompetencia(),
                p.getValor(),
                p.getParcelas(),
                p.getDescricao(),
                p.getTipoDespesaa().getDescricao()});
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

        jTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(4).setResizable(true);

        jTable.getTableHeader().setResizingAllowed(false);

        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @Override
    public void load(int id) {

        Object load = this.load(id, getEntity());

        if (load != null) {
            setEntity((DespesaCompartilhada) load);
        } else {
            setEntity(new DespesaCompartilhada());
        }
    }

    @Override
    public void save(Object object) throws Exception {

//        Fazer o controle aqui se tiver mais de uma parcela, 
//        perguntando se deseja lançar tudo
        DespesaCompartilhada dc = (DespesaCompartilhada) object;

        int parcelas = dc.getParcelas();

        if (parcelas > 1) {

            CompetenciaControle cc = new CompetenciaControle();
            Competencia c = dc.getCompetencia();

            double valorParcela = dc.getValor();
            double somaValorParcelaLancado = 0;

            BigDecimal valorParcelado = new BigDecimal(valorParcela / parcelas).setScale(2, RoundingMode.HALF_EVEN);
            ArrayList<DespesaCompartilhada> despesas = new ArrayList();
            for (int i = 0; i < parcelas; i++) {

                DespesaCompartilhada d = dc.clone();

                d.setValor(valorParcelado.doubleValue());
                d.setParcelas(1 + i);
                d.setCompetencia(c);

                despesas.add(d);

                somaValorParcelaLancado += valorParcelado.doubleValue();

                //Se ainda tem mais um registro para iterar
                if (i < parcelas) {
                    c = cc.getProximaCompetencia(c.getAno(), c.getMes());
                }
            }

            if (valorParcela > somaValorParcelaLancado) {

                BigDecimal diferenca = new BigDecimal(valorParcelado.doubleValue() - somaValorParcelaLancado).setScale(2, RoundingMode.HALF_EVEN);
                double valorCorrigido = diferenca.doubleValue() + despesas.get(0).getValor();

                despesas.get(0).setValor(valorCorrigido);
            }

            super.save(despesas);

        } else {
            super.save(dc, dc.getId());
        }

    }

    /**
     * Retornam todas as DespesaCompartilhada da competencia
     *
     * @param competencia
     * @return
     */
    public static List<DespesaCompartilhada> getDespesaCompartilhadas(Competencia competencia) {

        String jpSql = "from DespesaCompartilhada where dsc_competencia = ?1";

        Query query = EntityManagerUtil.getEntityManager().createQuery(jpSql);
        query.setParameter(1, competencia.getId());

        return query.getResultList();

    }
}
