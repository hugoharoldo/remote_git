/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler.enums;

import com.hugo.atena.utils.HNumber;

/**
 *
 * @author hugo
 */
public enum TipoDespesa {

    //Limpeza de caixa de água, manutenção no portão, coisas de manutenção
    SEM_INVESTIMENTO(1, "Sem investimento"),
    //Chamada de capital, pintura, obra
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

    public HNumber valorParticipacao(TamanhoApartamento td, double valorDespesa) throws Exception {

        double fator;

        if (null == this) {
            throw new Exception("Tipo de apartamento não cadastrado");
        } else {

            switch (this) {

                case COM_INVESTIMENTO:
                    if (td == TamanhoApartamento.GRANDE) {
                        fator = 11.2975;
                    } else {
                        fator = 12.8998;
                    }
                    break;

                case SEM_INVESTIMENTO:
                    if (td == TamanhoApartamento.GRANDE) {

                        fator = 11.5241;
                    } else {
                        fator = 15.3911;

                    }
                    break;

                default:
                    throw new Exception("Tipo de apartamento não cadastrado");
            }
        }
        
        
        return new HNumber((fator * valorDespesa) / 100);

    }

}
