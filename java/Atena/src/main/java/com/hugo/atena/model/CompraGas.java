/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import com.hugo.atena.utils.HNumber;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */
@Entity
@Table(name = "compra_gas")
public class CompraGas implements Serializable {

    @Id
    @SequenceGenerator(name = "cpg_id", sequenceName = "seq_compra_gas_id", allocationSize = 1)
    @GeneratedValue(generator = "cpg_id", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "cpr_dtcompra", nullable = false)
    private GregorianCalendar dataCompra;
    
    @Column(name = "cpr_valor", precision = 2)
    private Double valorPago;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompraGas other = (CompraGas) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the dataCompra
     */
    public GregorianCalendar getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(GregorianCalendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the valorPago
     */
    public Double getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    
}
