/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler.enums;

/**
 *
 * @author hugo
 */
public enum TipoDespesa {

    SEM_INVESTIMENTO(1, "Sem investimento"),
    COM_INVESTIMENTO(2, "Com investimento");

    private int tipo;
    private String descricao;

    private TipoDespesa(int tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return getDescricao();
    }

    public static TipoDespesa get(int tipo) {

        if (tipo == 2) {
            return COM_INVESTIMENTO;
        } else {
            return SEM_INVESTIMENTO;
        }

    }

}
