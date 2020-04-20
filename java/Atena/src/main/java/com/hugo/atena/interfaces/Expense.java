/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.interfaces;

/**
 *
 * @author hugo
 */
public interface Expense {

    /**
     * valor
     *
     * @return
     */
    public Number getValue();

    /**
     * Parcela
     *
     * @return
     */
    public Number getPortion();

    /**
     * Descricao
     *
     * @return
     */
    public String getDescription();

}
