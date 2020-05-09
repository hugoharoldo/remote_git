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
public enum TamanhoApartamento {

    PEQUENO(1),
    GRANDE(2);

    private int tipo;

    private TamanhoApartamento(int tipo) {
        this.tipo = tipo;
    }

    public static TamanhoApartamento getTipo(int tipo) throws Exception {

        if (tipo == PEQUENO.tipo) {
            return PEQUENO;
        } else if (tipo == GRANDE.tipo) {
            return GRANDE;
        } else {
            throw new Exception("Tipo não autorizado");
        }
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

}
