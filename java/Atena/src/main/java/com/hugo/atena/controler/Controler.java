/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import javax.swing.JTable;

/**
 *
 * @author hugo
 */
public interface Controler {

    public Object getEntity();
    
    public void setEntity(Object object);
    
    public void load(int id);
    
    public void gravar(Object object);
    
    public void atualizaValoresTabela(JTable table);

}
