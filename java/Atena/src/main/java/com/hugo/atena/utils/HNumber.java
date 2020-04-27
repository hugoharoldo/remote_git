/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.utils;

import com.hugo.atena.exceptions.NumberException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author hugo
 */
public class HNumber extends BigDecimal {

    public static final int SCALE = 2;

    public HNumber(BigDecimal bigDecimal) {
        super(bigDecimal.toString());
        this.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public HNumber() {
        super(0);
        this.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public HNumber(String val) {
        super(val);
        this.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public HNumber(int val) {
        super(val);
        this.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public HNumber(double val) {
        super(val);
        this.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public static HNumber getNumber(double value) {
        return new HNumber(value);
    }

    public boolean isPositive() {
        return this.compareTo(ZERO) == 1;
    }

    public boolean isNegative() {
        return this.compareTo(ZERO) == -1;
    }

    public boolean isZero() {
        return this.compareTo(ZERO) == 0;
    }

    public boolean isGreater(HNumber numeric) {
        return this.compareTo(numeric) > 0;
    }

    public boolean isGreaterEquals(HNumber numeric) {
        return this.compareTo(numeric) >= 0;
    }

    public boolean isIgual(HNumber numeric) {
        return this.compareTo(numeric) == 0;
    }

    public HNumber add(HNumber numeric) throws NumberException {
        return HNumber.getNumber(super.add(numeric)).rounds();
    }

    public HNumber add(double numeric) throws NumberException {
        return this.add(HNumber.getNumber(numeric));
    }

    public HNumber subtract(HNumber numeric) throws NumberException {
        return HNumber.getNumber(super.subtract(numeric));
    }

    public HNumber subtract(String numeric) throws NumberException {
        return this.subtract(HNumber.getNumber(numeric));
    }

    public HNumber multiply(HNumber numeric) throws NumberException {
        return HNumber.getNumber(super.multiply(numeric));
    }

    public HNumber multiply(double numeric) throws NumberException {
        return this.multiply(HNumber.getNumber(numeric));
    }

    public HNumber divide(HNumber numeric) throws NumberException {
        return HNumber.getNumber(super.divide(numeric, SCALE));
    }

    public HNumber divide(double numeric) throws NumberException {
        return this.divide(HNumber.getNumber(numeric));
    }

    public int compareTo(double numeric) throws NumberException {
        return this.compareTo(HNumber.getNumber(numeric));
    }

    public HNumber rounds(int scale) throws NumberException {
        return HNumber.getNumber(this.setScale(scale));

    }

    public HNumber rounds() throws NumberException {
        return rounds(SCALE);
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(this.toString());
    }

    public HNumber percentage(Double percentage) throws NumberException {

        return this.multiply(percentage).divide(100);

    }

    public static HNumber sum(HNumber n1, HNumber n2) throws NumberException {

        if (n1 == null || n2 == null) {
            throw new NumberException("Invalida number");
        }

        if (n1 instanceof HNumber) {

            if (n2 instanceof HNumber) {
                return n2.add(n1);
            } else {
                return n1;
            }

        } else {
            return n2;
        }
    }

    public static HNumber subtract(HNumber n1, HNumber n2) throws NumberException {

        if (n1 == null || n2 == null) {
            throw new NumberException("Invalida number");
        }

        return n1.subtract(n2);

    }

    public static HNumber getNumber(BigDecimal bigDecimal) throws NumberException {
        return getNumber(bigDecimal.toString());
    }

    public static HNumber getNumber(String string) throws NumberException {

        if (string == null || string.trim().isEmpty()) {
            throw new NumberException("Invalid number");
        } else {
            return new HNumber(string.replace(",", ""));
        }
    }
    
    public static boolean isInteger(String text) {
        try {
            Integer i = Integer.parseInt(text);
            return i != null;
        } catch (Exception e) {
            return false;
        }
    }
}
