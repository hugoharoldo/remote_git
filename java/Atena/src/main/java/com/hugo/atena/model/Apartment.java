/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

/**
 *
 * @author hugo
 */
public class Apartment {
    
    private static int code;
    private static Titular titular;

    public Apartment(int code, Titular titular) {
        Apartment.code = code;
        Apartment.titular = titular;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the titular
     */
    public static Titular getTitular() {
        return titular;
    }

}
