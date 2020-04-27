/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hugo
 */
public class TableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public TableModel(ArrayList linhas, String[] colunas) {
        setLinhas(linhas);
        setColunas(colunas);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        try {
            
        Object[] linha = (Object[]) getLinhas().get(numLin);

        return linha[numCol];
        
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

}
